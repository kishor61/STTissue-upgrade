select SUM(M.ACTUALTWT) as ACTUALTTON,SUM(M.SLABOFF) as SLABOFFTON,M.DATE,M.TEAM,M.SHIFT
 from (
	select 
	CASE
	WHEN DATEPART(HOUR,[DateTimeEntered])>=0 and DATEPART(HOUR,[DateTimeEntered])<7 THEN
	CAST(DATEADD(DAY,-1,[DateTimeEntered]) AS DATE)
	ELSE 
	CAST([DateTimeEntered] AS DATE)
	END AS DATE,
	ROUND(ISNULL(GoodWeight,0),2) AS ACTUALTWT,
	ROUND(ISNULL(RejectedWeight,0),2) AS SLABOFF,
	UPPER(Team) as TEAM,
	UPPER(Shift) as SHIFT
	from [tblMachineProduction] where 
	[DateTimeEntered] between :sdate and :edate AND [MachineNumber] <> 'ZZZ' AND [MachineNumber] <> 'ZZZ' AND (UPPER(Team)  IS NOT NULL) AND (UPPER(Team) <> '') AND MachineNumber='TM5'
) as M group by M.DATE,M.SHIFT,M.TEAM
order by M.DATE,M.SHIFT