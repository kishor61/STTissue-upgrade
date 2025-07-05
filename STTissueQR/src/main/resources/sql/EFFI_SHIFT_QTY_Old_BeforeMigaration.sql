SELECT 
	DATEVALUE(IIF(DATEPART('h',e.Date)>=0 and DATEPART('h',e.Date)<7,(
		Format (DATEADD('d',-1,e.Date), "mm/dd/yyyy")
		),(
		Format (e.Date, "mm/dd/yyyy")
	))) AS CDATE,
	e.StartTime,e.EndTime,pc.TYPE,Shift

	FROM efficiencyData e, efficiencySecondaryCode sc,efficiencyPrimaryCode pc

 where e.Date between :sdate and :edate
 and 
 e.SecodaryCode=sc.ID
 and
 sc.PrimaryCodeID = pc.ID