Select       
convert(varchar(10), cast(e.Date AS DATE), 126) as CDATE,
cast(e.StartTime as time) [StartTime],
cast(e.EndTime as time) [EndTime],
pc.TYPE,Shift
FROM efficiencyData e, efficiencySecondaryCode sc,efficiencyPrimaryCode pc
where e.Date between :sdate and :edate
and 
e.SecodaryCode=sc.ID
and
sc.PrimaryCodeID = pc.ID
