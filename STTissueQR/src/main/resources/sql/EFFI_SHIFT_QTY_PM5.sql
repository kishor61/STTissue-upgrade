Select       
convert(varchar(10), cast(e.Date AS DATE), 126) as CDATE,
cast(e.StartTime as time) [StartTime],
cast(e.EndTime as time) [EndTime],
pc.TYPE,Shift
FROM efficiencyData_pm5 e, efficiencySecondaryCode_pm5 sc,efficiencyPrimaryCode_pm5 pc
where e.Date between :sdate and :edate
and 
e.SecodaryCode=sc.ID
and
sc.PrimaryCodeID = pc.ID
