SELECT
tblMachineProduction.DateEntered,
tblMachineProduction.ReelNumber,
tblMachineProduction.GradeCode,
SUM(IsNull([GoodWeight],0))/count(tblMachineProduction.ReelNumber) AS ReelWhiteWeight, 
SUM(IsNull([RedWeight],0))/count(tblMachineProduction.ReelNumber) AS ReelRedWeight,
SUM(IsNull([RejectedWeight],0))/count(tblMachineProduction.ReelNumber) AS ReelRejectWeight,

SUM(ISNULL(qryWrapperMachineWeightSum.WrappedCount,0)) as WrappedCount, 
SUM(ISNULL(qryWrapperMachineWeightSum.WrappedWhite,0)) as WrappedWhite, 
SUM(ISNULL(qryWrapperMachineWeightSum.WrappedRed,0)) as WrappedRed, 
SUM(ISNULL(qryWrapperMachineWeightSum.WrappedReject,0)) as WrappedReject,
SUM(IsNull([RWidth],0)) AS WrapperWidth,  
SUM(IsNull([ReelWidth],0)) AS MachReelWidth
FROM tblMachineProduction LEFT JOIN (
	SELECT tblRewinderProduction.MachineRollID1,
	qryWrapperRollWidth.RWidth, 
	Count(tblWrapperProduction.RollID) AS WrappedCount, 
	Sum(tblWrapperProduction.WhiteWeight) AS WrappedWhite, 
	Sum(tblWrapperProduction.RedWeight) AS WrappedRed, 
	Sum(tblWrapperProduction.RejectWeight) AS WrappedReject
	FROM (tblWrapperProduction INNER JOIN tblRewinderProduction ON tblWrapperProduction.RollID = tblRewinderProduction.RewinderID) 
		INNER JOIN (
			SELECT tblWrapperProduction.RollNumber, 
			Sum(CAST(Replace(Replace(IsNull(NULLIF([RollWidth],''),'0'),'"',''),'''','') as decimal(12,2))*1) AS RWidth
			FROM tblWrapperProduction
			GROUP BY tblWrapperProduction.RollNumber, tblWrapperProduction.DateEntered
			HAVING (((tblWrapperProduction.DateEntered) Between  :sdate And :edate))

		) AS qryWrapperRollWidth ON tblWrapperProduction.RollNumber = qryWrapperRollWidth.RollNumber
	WHERE (tblWrapperProduction.DateEntered) Between   :sdate And :edate
	GROUP BY tblRewinderProduction.MachineRollID1, qryWrapperRollWidth.RWidth
	HAVING ((tblRewinderProduction.MachineRollID1)>'')	

) AS qryWrapperMachineWeightSum ON tblMachineProduction.RollID = qryWrapperMachineWeightSum.MachineRollID1
WHERE (tblMachineProduction.DateEntered) Between  :sdate And :edate

group by 
tblMachineProduction.DateEntered,
tblMachineProduction.ReelNumber,
tblMachineProduction.GradeCode