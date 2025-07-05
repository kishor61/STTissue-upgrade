select 
DateEntered,
ReelNumber,
GradeCode,
Team,
ISNULL(GoodWeight,0) AS ReelWhiteWeight,
ISNULL(RedWeight,0) AS ReelRedWeight,
ISNULL(RejectedWeight,0)AS ReelRejectWeight,
IsNull([ReelWidth],0) AS MachReelWidth
from tblMachineProduction
where 
DateEntered between  :sdate And :edate AND Team IS NOT NULL AND  Team <> ''