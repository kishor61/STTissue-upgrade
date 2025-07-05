UPDATE [OBCC].[dbo].[winderDown]
   SET 
   position=:position,
operatorname=:operatorname,
date=:date,
crew=:crew,
shift=:shift,
machinedown=:machinedown,
power=:power,
blade=:blade,
sizeadjustmentmovement=:sizeadjustmentmovement,
rollkickerworkingproperly=:rollkickerworkingproperly,
anyhydraulicleaks=:anyhydraulicleaks,
uprightbumperandcushionbumperworkingproperly=:uprightbumperandcushionbumperworkingproperly,
anycontrolpanelissues=:anycontrolpanelissues,
anynoticeableissueswithconveyor=:anynoticeableissueswithconveyor,
 powerDesc=:powerDesc,
 bladeDesc=:bladeDesc,
 sizeadjustmentmovementDesc=:sizeadjustmentmovementDesc,
 rollkickerworkingproperlyDesc=:rollkickerworkingproperlyDesc,
 anyhydraulicleaksDesc=:anyhydraulicleaksDesc,
 uprightbumperandcushionbumperworkingproperlyDesc=:uprightbumperandcushionbumperworkingproperlyDesc,
 anycontrolpanelissuesDesc=:anycontrolpanelissuesDesc,
 anynoticeableissueswithconveyorDesc=:anynoticeableissueswithconveyorDesc

 WHERE id=:id