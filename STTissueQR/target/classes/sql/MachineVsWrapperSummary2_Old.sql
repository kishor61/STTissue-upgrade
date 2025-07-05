select 
avg(data.RWidth) as WrapperWidth,
Sum(data.WrappedWhite) AS WrappedWhite, 
Sum(data.WrappedRed) AS WrappedRed, 
Sum(data.WrappedReject) AS WrappedReject,
sum(data.WrappedCount)  AS WrappedCount

from
(
	select RollNumber,
			Sum(CAST(Replace(Replace(IsNull(NULLIF(RollWidth,''),'0'),'"',''),'''','') as decimal(12,2))*1) AS RWidth,
			Sum(WhiteWeight) AS WrappedWhite, 
			Sum(RedWeight) AS WrappedRed, 
			Sum(RejectWeight) AS WrappedReject,
			COUNT(RollNumber)  AS WrappedCount
	 from tblWrapperProduction where RollNumber in (select SetNumber from tblRewinderProduction where ReelNumber1=:reelNo)
	 group by RollNumber
)as data