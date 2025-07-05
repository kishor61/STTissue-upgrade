select SUM(W.WHITEWT) as WHITETON,SUM(W.REDWT) as REDTON,SUM(W.REJWT) as REJTON,SUM(W.WHITEWT+W.REDWT) as TOTALTON,
W.DATE,SHIFT
from (
	select 
	ROUND(ISNULL(WhiteWeight,0)/2000,2) as WHITEWT,
	ROUND(ISNULL(RedWeight,0)/2000,2) as REDWT,
	ROUND(ISNULL(RejectWeight,0)/2000,2) as REJWT,
	CASE
	WHEN DATEPART(HOUR,[DateTimeEntered])>=0 and DATEPART(HOUR,[DateTimeEntered])<7 THEN
	CAST(DATEADD(DAY,-1,[DateTimeEntered]) AS DATE)
	ELSE 
	CAST([DateTimeEntered] AS DATE)
	END AS DATE,
	UPPER(Shift) as SHIFT
	from tblWrapperProduction where 
	[DateTimeEntered] between :sdate and :edate AND [WrapperNumber] <> 'ZZZ' AND (UPPER(Team)  IS NOT NULL) AND (UPPER(Team) <> '') AND [WrapperNumber]='WR5'
) as W group by W.DATE,W.SHIFT order by W.DATE,SHIFT