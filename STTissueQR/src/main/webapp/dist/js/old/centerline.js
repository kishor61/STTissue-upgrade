var currnetCellValue;
var currnetGradeCellValue;

var centerlineGrade;
var saveLock=false;
var saveLockGrade=false;
var clearTimer;
var clearTimerGrade;

$(function(){
		$('input[name=date],input[name=issueDate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		
		$('select[name=grade]').change(function(){
			var grade=$(this).val();
			
			if($('#pageFlag').val()=='edit'){
				
			}else{
				$('#centerlineTable tbody input').val('');
			}
			
			
			
		//	rangeCheck();
			
			if(grade!=''){
				$.ajax({
					url:getGradeUrl,
					type:'POST',
					data:{grade : grade},
					success:function(data){
						setGradeValue(data);
						rangeCheck();
					},
					error: function(xhr, status, error) {
						alert('Server error.. :-(' );
					}
				});
			}else{
				alert('Select grade.');
			}
		});
		
		$('#centerlineTable input, #centerlineTable tbody textarea').focusout(function(){
			
			var self=this;
			if(validateCell($(this))){
				setTimeout(function(){$(self).focus();}, 1);
				return false;
			}
		
			rangeCheck();
			
			
			if(currnetCellValue!=$(this).val()){
				saveCenterline();
			}
			
		});
		$('#centerlineTable input, #centerlineTable tbody textarea').focusin(function(){
			currnetCellValue=$(this).val();
		});
		
		
		$('.vcolor').qtip({
			 content: {
				text:function(event, api) {
		          if(centerlineGrade){
		        	  var minC=$(this).next().find('input').attr('name')+'MinC';
						var target=$(this).next().find('input').attr('name');
						var maxC=$(this).next().find('input').attr('name')+'MaxC';
						var text="" +
			           		"<span>Min Control=" +centerlineGrade[minC]+"</span>"+
			           		"<br><span>Target=" +centerlineGrade[target]+"</span>"+
			           		"<br><span>Max Control=" +centerlineGrade[maxC]+"</span>"+
			           		"<br>";
			           
			            return text;
		          }
					
		        },
			    title: 'Range'
			  },
			  position: {
			        my: 'bottom center',
			        at: 'top center'
			 }
		});
		
		
		
		//Centerline Grade...
		
		$('#centerlineGradeTable input').focusout(function(){
			
			var gradeflag=false;
			
			if(!($('#centerlineGradeTable input[name=gradeCode]').is('[readonly]'))){
				$('select[name=cgrade] option').each(function(){
					
					if($.trim($('#centerlineGradeTable input[name=gradeCode]').val()).toUpperCase()==$.trim($(this).text()).toUpperCase()){
						gradeflag=true;
						return;
					}
				});
			}
			
			var id=$('#centerlineGradeTable input[name=id]').val();
			var gText=$('#centerlineGradeTable input[name=gradeCode]').val().toUpperCase();
			var sText=$("select[name=cgrade] option[value='"+id+"']").text().toUpperCase();;
			if(gText==sText){
				gradeflag=false;
			}
			

			if(gradeflag){
				setTimeout(function(){$('#centerlineGradeTable input[name=gradeCode]').focus();}, 100);
				$('#tmessage').text('Grade "'+$('#centerlineGradeTable input[name=gradeCode]').val().toUpperCase()+'" already exist.');
				return;
			}
			
			
			var self=this;
			if(validateCell($(this))){
				setTimeout(function(){$(self).focus();}, 1);
				return false;
			}
			if(currnetGradeCellValue!=$(this).val()){
				saveCenterlineGrade();
			}
		});
		$('#centerlineGradeTable input').focusin(function(){
			currnetGradeCellValue=$(this).val();
		});
		
	});


function setGradeValue(data){
	centerlineGrade=data;
	
	var table=$('#centerlineTable');
	table.find('input[name=yankeeSpeed]').parent().prev().text(data.yankeeSpeed);
	table.find('input[name=qcsBasisWtTarget]').parent().prev().text(data.qcsBasisWtTarget);
	table.find('input[name=reelMoisture]').parent().prev().text(data.reelMoisture);
	table.find('input[name=crepe]').parent().prev().text(data.crepe);
	table.find('input[name=yankeeSteam]').parent().prev().text(data.yankeeSteam);
	table.find('input[name=yankeeRelease]').parent().prev().text(data.yankeeRelease);
	table.find('input[name=yankeeAdesive]').parent().prev().text(data.yankeeAdesive);
	table.find('input[name=jetWireRatio]').parent().prev().text(data.jetWireRatio);
	table.find('input[name=fanPumpFlowRate]').parent().prev().text(data.fanPumpFlowRate);
	table.find('input[name=afterDryerSteam]').parent().prev().text(data.afterDryerSteam);
	table.find('input[name=sprLoading]').parent().prev().text(data.sprLoading);
	table.find('input[name=feltPassivator]').parent().prev().text(data.feltPassivator);
	table.find('input[name=sprayboomPressure]').parent().prev().text(data.sprayboomPressure);
	table.find('input[name=sprayboomTemparature]').parent().prev().text(data.sprayboomTemparature);
	table.find('input[name=wefanSpeed]').parent().prev().text(data.wefanSpeed);
	table.find('input[name=defanSpeed]').parent().prev().text(data.defanSpeed);
	table.find('input[name=makeUpAirDamper]').parent().prev().text(data.makeUpAirDamper);
	table.find('input[name=exhaustDamper]').parent().prev().text(data.exhaustDamper);
	table.find('input[name=exhaustFanSpeed]').parent().prev().text(data.exhaustFanSpeed);
	table.find('input[name=wehoodTemperature]').parent().prev().text(data.wehoodTemperature);
	table.find('input[name=dehoodTemperature]').parent().prev().text(data.dehoodTemperature);
	table.find('input[name=yankeeAP]').parent().prev().text(data.yankeeAP);
	table.find('input[name=afterDryerAP]').parent().prev().text(data.afterDryerAP);
	table.find('input[name=secArmLoading]').parent().prev().text(data.secArmLoading);
	table.find('input[name=reelOffset]').parent().prev().text(data.reelOffset);
	table.find('input[name=uhleBoxNorthValve]').parent().prev().text(data.uhleBoxNorthValve);
	table.find('input[name=uhleBoxSouthValve]').parent().prev().text(data.uhleBoxSouthValve);
	table.find('input[name=faltBox1VacuumValve]').parent().prev().text(data.faltBox1VacuumValve);
	table.find('input[name=faltBox2VacuumValve]').parent().prev().text(data.faltBox2VacuumValve);
	table.find('input[name=faltBox4VacuumValve]').parent().prev().text(data.faltBox4VacuumValve);
	table.find('input[name=fanPumpSpeed]').parent().prev().text(data.fanPumpSpeed);
	table.find('input[name=totalHead]').parent().prev().text(data.totalHead);
	table.find('input[name=headboxLevel]').parent().prev().text(data.headboxLevel);
	table.find('input[name=horizontalSlice]').parent().prev().text(data.horizontalSlice);
	table.find('input[name=verticalSlice]').parent().prev().text(data.verticalSlice);
	table.find('input[name=selectifierRejectFlow1]').parent().prev().text(data.selectifierRejectFlow1);
	table.find('input[name=selectifierRejectFlow2]').parent().prev().text(data.selectifierRejectFlow2);
	table.find('input[name=secScreenCycleTime]').parent().prev().text(data.secScreenCycleTime);
	table.find('input[name=lowDensityCycleTime]').parent().prev().text(data.lowDensityCycleTime);
	table.find('input[name=refinersEnergy]').parent().prev().text(data.refinersEnergy);
	table.find('input[name=numberOfRefiners]').parent().prev().text(data.numberOfRefiners);
	table.find('input[name=refinerInletConsistency]').parent().prev().text(data.refinerInletConsistency);
	table.find('input[name=machineChestConsistency]').parent().prev().text(data.machineChestConsistency);
	table.find('input[name=stockFlow]').parent().prev().text(data.stockFlow);
	table.find('input[name=sweetnerFlow]').parent().prev().text(data.sweetnerFlow);
	table.find('input[name=broke]').parent().prev().text(data.broke);
	table.find('input[name=wetStrength]').parent().prev().text(data.wetStrength);
	//New Field
	table.find('input[name=afterDryerDraw]').parent().prev().text(data.afterDryerDraw);
	table.find('input[name=horizontalSliceDcs]').parent().prev().text(data.horizontalSliceDcs);
	table.find('input[name=verticalSliceDcs]').parent().prev().text(data.verticalSliceDcs);

	
	table.find('input[name=issueDate]').val(data.fissueDate);
	table.find('input[name=revision]').val(data.revision);
}

function setClDataValue(data){
	
	var table=$('#centerlineTable');
/*alert(data.gradeId);*/
	table.find('input[name=id]').val(data.id);
	table.find('select[name=grade]').val(data.gradeId);
	table.find('select[name=crew]').val(data.crew);
	table.find('select[name=shift]').val(data.shift);
	table.find('input[name=date]').val(data.fdate);
//	table.find('input[name=issueDate]').val(data.fissueDate);
//	table.find('input[name=revision]').val(data.revision);
	
	
	table.find('input[name=yankeeSpeed]').val(data.yankeeSpeed);
	table.find('input[name=qcsBasisWtTarget]').val(data.qcsBasisWtTarget);
	table.find('input[name=reelMoisture]').val(data.reelMoisture);
	table.find('input[name=crepe]').val(data.crepe);
	table.find('input[name=yankeeSteam]').val(data.yankeeSteam);
	table.find('input[name=yankeeRelease]').val(data.yankeeRelease);
	table.find('input[name=yankeeAdesive]').val(data.yankeeAdesive);
	table.find('input[name=jetWireRatio]').val(data.jetWireRatio);
	table.find('input[name=fanPumpFlowRate]').val(data.fanPumpFlowRate);
	table.find('input[name=afterDryerSteam]').val(data.afterDryerSteam);
	table.find('input[name=sprLoading]').val(data.sprLoading);
	table.find('input[name=feltPassivator]').val(data.feltPassivator);
	table.find('input[name=sprayboomPressure]').val(data.sprayboomPressure);
	table.find('input[name=sprayboomTemparature]').val(data.sprayboomTemparature);
	table.find('input[name=wefanSpeed]').val(data.wefanSpeed);
	table.find('input[name=defanSpeed]').val(data.defanSpeed);
	table.find('input[name=makeUpAirDamper]').val(data.makeUpAirDamper);
	table.find('input[name=exhaustDamper]').val(data.exhaustDamper);
	table.find('input[name=exhaustFanSpeed]').val(data.exhaustFanSpeed);
	table.find('input[name=wehoodTemperature]').val(data.wehoodTemperature);
	table.find('input[name=dehoodTemperature]').val(data.dehoodTemperature);
	table.find('input[name=yankeeAP]').val(data.yankeeAP);
	table.find('input[name=afterDryerAP]').val(data.afterDryerAP);
	table.find('input[name=secArmLoading]').val(data.secArmLoading);
	table.find('input[name=reelOffset]').val(data.reelOffset);
	table.find('input[name=uhleBoxNorthValve]').val(data.uhleBoxNorthValve);
	table.find('input[name=uhleBoxSouthValve]').val(data.uhleBoxSouthValve);
	table.find('input[name=faltBox1VacuumValve]').val(data.faltBox1VacuumValve);
	table.find('input[name=faltBox2VacuumValve]').val(data.faltBox2VacuumValve);
	table.find('input[name=faltBox4VacuumValve]').val(data.faltBox4VacuumValve);
	table.find('input[name=fanPumpSpeed]').val(data.fanPumpSpeed);
	table.find('input[name=totalHead]').val(data.totalHead);
	table.find('input[name=headboxLevel]').val(data.headboxLevel);
	table.find('input[name=horizontalSlice]').val(data.horizontalSlice);
	table.find('input[name=verticalSlice]').val(data.verticalSlice);
	table.find('input[name=selectifierRejectFlow1]').val(data.selectifierRejectFlow1);
	table.find('input[name=selectifierRejectFlow2]').val(data.selectifierRejectFlow2);
	table.find('input[name=secScreenCycleTime]').val(data.secScreenCycleTime);
	table.find('input[name=lowDensityCycleTime]').val(data.lowDensityCycleTime);
	table.find('input[name=refinersEnergy]').val(data.refinersEnergy);
	table.find('input[name=numberOfRefiners]').val(data.numberOfRefiners);
	table.find('input[name=refinerInletConsistency]').val(data.refinerInletConsistency);
	table.find('input[name=machineChestConsistency]').val(data.machineChestConsistency);
	table.find('input[name=stockFlow]').val(data.stockFlow);
	table.find('input[name=sweetnerFlow]').val(data.sweetnerFlow);
	table.find('input[name=broke]').val(data.broke);
	
	table.find('input[name=wetStrength]').val(data.wetStrength);
	
	
	//New Filed
	table.find('input[name=afterDryerDraw]').val(data.afterDryerDraw);
	table.find('input[name=horizontalSliceDcs]').val(data.horizontalSliceDcs);
	table.find('input[name=verticalSliceDcs]').val(data.verticalSliceDcs);
	
	
	table.find('textarea[name=noteSecA]').val(data.noteSecA);
	table.find('textarea[name=noteSecB]').val(data.noteSecB);
	
	
	rangeCheck();
}

function saveCenterline(){
	
	
	if($('select[name=grade]').val()==''){
		alert('Select grade!');
		$('select[name=grade]').focus();
		return;
	}
	
	
	
	
	var table=$('#centerlineTable');
	
	
	var idEle=table.find('input[name=id]');
	
	var id=table.find('input[name=id]').val();
	var grade=table.find('select[name=grade]').val();
	var crew=table.find('select[name=crew]').val();
	var shift=table.find('select[name=shift]').val();
	var yankeeSpeed=table.find('input[name=yankeeSpeed]').val();
	var qcsBasisWtTarget=table.find('input[name=qcsBasisWtTarget]').val();
	var reelMoisture=table.find('input[name=reelMoisture]').val();
	var crepe=table.find('input[name=crepe]').val();
	var yankeeSteam=table.find('input[name=yankeeSteam]').val();
	var yankeeRelease=table.find('input[name=yankeeRelease]').val();
	var yankeeAdesive=table.find('input[name=yankeeAdesive]').val();
	var jetWireRatio=table.find('input[name=jetWireRatio]').val();
	var fanPumpFlowRate=table.find('input[name=fanPumpFlowRate]').val();
	var afterDryerSteam=table.find('input[name=afterDryerSteam]').val();
	var sprLoading=table.find('input[name=sprLoading]').val();
	var feltPassivator=table.find('input[name=feltPassivator]').val();
	var sprayboomPressure=table.find('input[name=sprayboomPressure]').val();
	var sprayboomTemparature=table.find('input[name=sprayboomTemparature]').val();
	var wefanSpeed=table.find('input[name=wefanSpeed]').val();
	var defanSpeed=table.find('input[name=defanSpeed]').val();
	var makeUpAirDamper=table.find('input[name=makeUpAirDamper]').val();
	var exhaustDamper=table.find('input[name=exhaustDamper]').val();
	var exhaustFanSpeed=table.find('input[name=exhaustFanSpeed]').val();
	var wehoodTemperature=table.find('input[name=wehoodTemperature]').val();
	var dehoodTemperature=table.find('input[name=dehoodTemperature]').val();
	var yankeeAP=table.find('input[name=yankeeAP]').val();
	var afterDryerAP=table.find('input[name=afterDryerAP]').val();
	var secArmLoading=table.find('input[name=secArmLoading]').val();
	var reelOffset=table.find('input[name=reelOffset]').val();
	var uhleBoxNorthValve=table.find('input[name=uhleBoxNorthValve]').val();
	var uhleBoxSouthValve=table.find('input[name=uhleBoxSouthValve]').val();
	var faltBox1VacuumValve=table.find('input[name=faltBox1VacuumValve]').val();
	var faltBox2VacuumValve=table.find('input[name=faltBox2VacuumValve]').val();
	var faltBox4VacuumValve=table.find('input[name=faltBox4VacuumValve]').val();
	var fanPumpSpeed=table.find('input[name=fanPumpSpeed]').val();
	var totalHead=table.find('input[name=totalHead]').val();
	var headboxLevel=table.find('input[name=headboxLevel]').val();
	var horizontalSlice=table.find('input[name=horizontalSlice]').val();
	var verticalSlice=table.find('input[name=verticalSlice]').val();
	var selectifierRejectFlow1=table.find('input[name=selectifierRejectFlow1]').val();
	var selectifierRejectFlow2=table.find('input[name=selectifierRejectFlow2]').val();
	var secScreenCycleTime=table.find('input[name=secScreenCycleTime]').val();
	var lowDensityCycleTime=table.find('input[name=lowDensityCycleTime]').val();
	var refinersEnergy=table.find('input[name=refinersEnergy]').val();
	var numberOfRefiners=table.find('input[name=numberOfRefiners]').val();
	var refinerInletConsistency=table.find('input[name=refinerInletConsistency]').val();
	var machineChestConsistency=table.find('input[name=machineChestConsistency]').val();
	var stockFlow=table.find('input[name=stockFlow]').val();
	var sweetnerFlow=table.find('input[name=sweetnerFlow]').val();
	var broke=table.find('input[name=broke]').val();
	var wetStrength=table.find('input[name=wetStrength]').val();
	var date=table.find('input[name=date]').val();
	var issueDate=table.find('input[name=issueDate]').val();
	var revision=table.find('input[name=revision]').val();
	var noteSecA=table.find('textarea[name=noteSecA]').val();
	var noteSecB=table.find('textarea[name=noteSecB]').val();

	
	//New Field
	var afterDryerDraw=table.find('input[name=afterDryerDraw]').val();
	var horizontalSliceDcs=table.find('input[name=horizontalSliceDcs]').val();
	var verticalSliceDcs=table.find('input[name=verticalSliceDcs]').val();
	
	if(date==''){
		alert('Select date');
		return;
	}
	
	if(grade==''){
		alert('Select grade');
		grade=table.find('select[name=grade]').focus();
		return;
	}
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	if(saveLock){
		return;
	}
	
	
	saveLock=true;
	
	$.ajax({
		url:savecldataUrl,
		type:'POST',
		data:{
			id : id,
			grade : grade,
			crew : crew,
			shift : shift,
			yankeeSpeed : yankeeSpeed,
			qcsBasisWtTarget : qcsBasisWtTarget,
			reelMoisture : reelMoisture,
			crepe : crepe,
			yankeeSteam : yankeeSteam,
			yankeeRelease : yankeeRelease,
			yankeeAdesive : yankeeAdesive,
			jetWireRatio : jetWireRatio,
			fanPumpFlowRate : fanPumpFlowRate,
			afterDryerSteam : afterDryerSteam,
			sprLoading : sprLoading,
			feltPassivator : feltPassivator,
			sprayboomPressure : sprayboomPressure,
			sprayboomTemparature : sprayboomTemparature,
			wefanSpeed : wefanSpeed,
			defanSpeed : defanSpeed,
			makeUpAirDamper : makeUpAirDamper,
			exhaustDamper : exhaustDamper,
			exhaustFanSpeed : exhaustFanSpeed,
			wehoodTemperature : wehoodTemperature,
			dehoodTemperature : dehoodTemperature,
			yankeeAP : yankeeAP,
			afterDryerAP : afterDryerAP,
			secArmLoading : secArmLoading,
			reelOffset : reelOffset,
			uhleBoxNorthValve : uhleBoxNorthValve,
			uhleBoxSouthValve : uhleBoxSouthValve,
			faltBox1VacuumValve : faltBox1VacuumValve,
			faltBox2VacuumValve : faltBox2VacuumValve,
			faltBox4VacuumValve : faltBox4VacuumValve,
			fanPumpSpeed : fanPumpSpeed,
			totalHead : totalHead,
			headboxLevel : headboxLevel,
			horizontalSlice : horizontalSlice,
			verticalSlice : verticalSlice,
			selectifierRejectFlow1 : selectifierRejectFlow1,
			selectifierRejectFlow2 : selectifierRejectFlow2,
			secScreenCycleTime : secScreenCycleTime,
			lowDensityCycleTime : lowDensityCycleTime,
			refinersEnergy : refinersEnergy,
			numberOfRefiners : numberOfRefiners,
			refinerInletConsistency : refinerInletConsistency,
			machineChestConsistency : machineChestConsistency,
			stockFlow : stockFlow,
			sweetnerFlow : sweetnerFlow,
			broke : broke,
			wetStrength : wetStrength,
			date : date,
			issueDate : issueDate,
			revision : revision,
			noteSecA : noteSecA,
			noteSecB : noteSecB,
			afterDryerDraw : afterDryerDraw,
			horizontalSliceDcs : horizontalSliceDcs,
			verticalSliceDcs : verticalSliceDcs
		},
		success:function(data){
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
			}else{
				alert(data.message);
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
}

function validateCell(jq){
	if(jq.hasClass('number')){
		if(isNaN(jq.val()) & jq.val()!=''){
			alert('Please enter numeric value.');
			return true;
		}
	}else if(jq.hasClass('string1')){
		if($.trim(jq.val())!=''){
			var valF=jq.val().split("/")[0];
			if(!valF | isNaN(valF)){
				alert('Please enter valid front value.');
				return true;
			}
			var valB=jq.val().split("/")[1];
			if(!valB | isNaN(valB)){
				alert('Please enter valid back value.');
				return true;
			}
		}
		return false;
	}else if(jq.hasClass('string2')){
		var value=jq.val();
		if($.trim(value)!=''){
			if(value.indexOf(' ')!=-1){
			try {
				value=value.replace(' ','+');
				var val=eval(value);
				if(!val){
					alert('Enter a valid value.');
					return true;
				}
			} catch (e) {
				alert('Enter a valid value.');
				return true;
			}
				
			}else if(value.indexOf('/')!=-1){
				try {
					if(!eval(value)){
						alert('Enter a valid value.');
						return true;
					}
				} catch (e) {
					alert('Enter a valid value.');
					return true;
				}
				
				
			}else if(isNaN(value)){
				alert('Enter a valid value.');
				return true;
			}
		}
		return false;
	}
}

function rangeCheck(){
	$('#centerlineTable tbody input[type=text]').each(function(){
		var value=$.trim($(this).val());
		
		var nameT=$(this).attr('name');
		var nameMinC=nameT+'MinC';
		var nameMaxC=nameT+'MaxC';
		
		if($(this).hasClass('number') & value!=''){
			if(centerlineGrade){
				var val=parseFloat(value);
				var target=parseFloat(centerlineGrade[nameT]);
				var conMin=parseFloat(centerlineGrade[nameMinC]);
				var conMax=parseFloat(centerlineGrade[nameMaxC]);
				if(val!=0){
					if(conMin==0 & conMax==0){
						if(val==target){
							addGreenClass($(this));
						}else{
							addRedClass($(this));
						}
					}else if(conMin!=0 & conMax==0){
						if(val>conMin & val<=target){
							addGreenClass($(this));
						}else{
							addRedClass($(this));
						}
					}else if(conMin==0 & conMax!=0){
						if(val>=target & val<conMax){
							addGreenClass($(this));
						}else{
							addRedClass($(this));
						}
					}else if(conMin!=0 & conMax!=0){
						if(val>conMin & val<conMax){
							addGreenClass($(this));
						}else{
							addRedClass($(this));
						}
					}else{
						removeGreenRedClass($(this));
					}
				}else{
					removeGreenRedClass($(this));
				}
				
				
			}
			
		}else if($(this).hasClass('string1') & value!=''){
			//SPR Loading
			if(centerlineGrade){
				
				
				
				
				var valF=value.split("/")[0];
				if(valF){
					valF=parseFloat(valF);
				}
				var valB=value.split("/")[1];
				if(valB){
					valB=parseFloat(valB);
				}
				
				
				var targetF=0;
				var targetB=0;
				if(centerlineGrade[nameT]){
					targetF=centerlineGrade[nameT].split("/")[0];
					if(targetF){
						targetF=parseFloat(targetF);
					}else{
						targetF=0;
					}
					
					targetB=centerlineGrade[nameT].split("/")[1];
					if(targetB){
						targetB=parseFloat(targetB);
					}else{
						targetB=0;
					}
				}
				
				var conMinF=0;
				var conMinB=0;
				if(centerlineGrade[nameMinC]){
					conMinF=centerlineGrade[nameMinC].split("/")[0];
					if(conMinF){
						conMinF=parseFloat(conMinF);
					}else{
						conMinF=0;
					}			
					conMinB=centerlineGrade[nameMinC].split("/")[1];
					if(conMinB){
						conMinB=parseFloat(conMinB);
					}else{
						conMinB=0;
					}
				}
				
				var conMaxF=0;
				var conMaxB=0;
				if(centerlineGrade[nameMaxC]){
					conMaxF=centerlineGrade[nameMaxC].split("/")[0];
					if(conMaxF){
						conMaxF=parseFloat(conMaxF);
					}else{
						conMaxF=0;
					}
					
					conMaxB=centerlineGrade[nameMaxC].split("/")[1];
					if(conMaxB){
						conMaxB=parseFloat(conMaxB);
					}else{
						conMaxB=0;
					}
				}
				
				var bfla=false;
			
				if(conMinB==0 & conMaxB==0){
					if(valB==targetB){
						addGreenClass($(this));
					}else{
						bfla=true;
						addRedClass($(this));
					}
				}else if(conMinB!=0 & conMaxB==0){
					if(valB>conMinB & valB<=targetB){
						addGreenClass($(this));
					}else{
						bfla=true;
						addRedClass($(this));
					}
				}else if(conMinB==0 & conMaxB!=0){
					if(valB>=targetB & valB<conMaxB){
						addGreenClass($(this));
					}else{
						bfla=true;
						addRedClass($(this));
					}
				}else if(conMinB!=0 & conMaxB!=0){
					if(valB>conMinB & valB<conMaxB){
						addGreenClass($(this));
					}else{
						bfla=true;
						addRedClass($(this));
					}
				}

				if(bfla){
					return;
				}
				
				if(conMinF==0 & conMaxF==0){
					if(valF==targetF){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else if(conMinF!=0 & conMaxF==0){
					if(valF>conMinF & valF<=targetF){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				} else if(conMinF==0 & conMaxF!=0){
					if(valF>=targetF & valF<conMaxF){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else if(conMinF!=0 & conMaxF!=0){
					if(valF>conMinF & valF<conMaxF){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else{
					removeGreenRedClass($(this));
				}
				
				
			}
			
		}else if($(this).hasClass('string2') & value!=''){
			var val=0;
			if(value){
				try {
					if(value.indexOf(' ')!=-1){
						value=value.replace(' ','+');
						var valT=parseFloat(eval(value));
						if(valT){
							val=valT;
						}
							
					}else if(value.indexOf('/')!=-1){
						if(eval(value)){
							val=parseFloat(eval(value));
						}
					}else if(!isNaN(value)){
						val=parseFloat(value);
					}			
				} catch (e) {
					alert('Error in checking range..');
				}
			}
			
			var target=0;
			
			var targetValue=centerlineGrade[nameT];
			
			if(targetValue){
				targetValue=$.trim(targetValue);
				try {
					if(targetValue.indexOf(' ')!=-1){
						var valueT=targetValue.replace(' ','+');
						var valT=parseFloat(eval(valueT));
						if(valT){
							target=valT;
						}
							
					}else if(targetValue.indexOf('/')!=-1){
						if(eval(targetValue)){
							target=parseFloat(eval(targetValue));
						}
					}else if(!isNaN(value)){
						target=parseFloat(targetValue);
					}			
				} catch (e) {
					alert('Error in checking range..');
				}
			}
			var conMin=0;
			
			var minValue=centerlineGrade[nameMinC];
			if(minValue){
				minValue=$.trim(minValue);
				try {
					if(minValue.indexOf(' ')!=-1){
						var valueT=minValue.replace(' ','+');
						var valT=parseFloat(eval(valueT));
						if(valT){
							conMin=valT;
						}
							
					}else if(minValue.indexOf('/')!=-1){
						if(eval(minValue)){
							conMin=parseFloat(eval(minValue));
						}
					}else if(!isNaN(minValue)){
						conMin=parseFloat(minValue);
					}		
				} catch (e) {
					alert('Error in checking range..');
				}
			}
			var conMax=0;
			var maxValue=centerlineGrade[nameMaxC];
			if(maxValue){
				maxValue=$.trim(maxValue);
				try {
					if(maxValue.indexOf(' ')!=-1){
						var valueT=maxValue.replace(' ','+');
						var valT=parseFloat(eval(valueT));
						if(valT){
							conMax=valT;
						}
							
					}else if(maxValue.indexOf('/')!=-1){
						if(eval(maxValue)){
							conMax=parseFloat(eval(maxValue));
						}
					}else if(!isNaN(maxValue)){
						conMax=parseFloat(maxValue);
					}	
				} catch (e) {
					alert('Error in checking range..');
				}
			}
			
			
			if(val!=0){
				if(conMin==0 & conMax==0){
					if(val==target){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else if(conMin!=0 & conMax==0){
					if(val>conMin & val<=target){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else if(conMin==0 & conMax!=0){
					if(val>=target & val<conMax){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else if(conMin!=0 & conMax!=0){
					if(val>conMin & val<conMax){
						addGreenClass($(this));
					}else{
						addRedClass($(this));
					}
				}else{
					removeGreenRedClass($(this));
				}
			}else{
				removeGreenRedClass($(this));
			}
			
		}else{
			removeGreenRedClass($(this));
		}
	});
}

function loadRunningGrade(id){
	$.ajax({
		url:loadcldataUrl,
		type:'POST',
		data:{id:id},
		success:function(data){
			var grade=data.clgrade;
			setGradeValue(grade);
			var cldata=data.cldata;
			setClDataValue(cldata);
			$('#dialog').hide();
		},
		error: function(xhr, status, error) {
			alert('Error in loading grade' );
		}
	});
}

function deletecl(id){
	if(id!=''){
		$.ajax({
			url:deletecldataURL,
			type:'POST',
			data:{id:id},
			success:function(data){
				if(data.status){
					alert('Record removed from database.');
					location.reload(true);
				}
			},
			error: function(xhr, status, error) {
				alert('Error in delete data' );
			}
		});
	}
}
function deleteclfromView(id){
	if(id!=''){
		$.ajax({
			url:deletecldataURL,
			type:'POST',
			data:{id:id},
			success:function(data){
				if(data.status){
					alert('Record removed from database.');
					$('#searchForm').submit();
				}
			},
			error: function(xhr, status, error) {
				alert('Error in delete data' );
			}
		});
	}
}

function addGreenClass(jq){
	if(!jq.hasClass('greencolor')){
		jq.addClass('greencolor');
	}
	
	if(jq.hasClass('redcolor')){
		jq.removeClass('redcolor');
	}
}
function addRedClass(jq){
	if(!jq.hasClass('redcolor')){
		jq.addClass('redcolor');
	}
	
	if(jq.hasClass('greencolor')){
		jq.removeClass('greencolor');
	}
}
function removeGreenRedClass(jq){

	if(jq.hasClass('greencolor')){
		jq.removeClass('greencolor');
	}
	
	if(jq.hasClass('redcolor')){
		jq.removeClass('redcolor');
	}
}

function saveCenterlineGrade(){
	$('#tmessage').text('');
	clearTimeout(clearTimerGrade);
	if(saveLockGrade){
		return;
	}
	
	
	
	
	
	var table=$('#centerlineGradeTable');
	
	if($.trim(table.find('input[name=gradeCode]').val())==''){
		alert('Please enter grade code.');
		setTimeout(function(){table.find('input[name=gradeCode]').focus();}, 100);
		return;
	}
	
	
	var idEle=table.find('input[name=id]');
	var id=table.find('input[name=id]').val();
	
	var gradeCode=table.find('input[name=gradeCode]').val();
	var issueDate=table.find('input[name=issueDate]').val();
	var revision=table.find('input[name=revision]').val();
	
	var yankeeSpeed=table.find('input[name=yankeeSpeed]').val();
	var qcsBasisWtTarget=table.find('input[name=qcsBasisWtTarget]').val();
	var reelMoisture=table.find('input[name=reelMoisture]').val();
	var crepe=table.find('input[name=crepe]').val();
	var yankeeSteam=table.find('input[name=yankeeSteam]').val();
	var yankeeRelease=table.find('input[name=yankeeRelease]').val();
	var yankeeAdesive=table.find('input[name=yankeeAdesive]').val();
	var jetWireRatio=table.find('input[name=jetWireRatio]').val();
	var fanPumpFlowRate=table.find('input[name=fanPumpFlowRate]').val();
	var afterDryerSteam=table.find('input[name=afterDryerSteam]').val();
	var sprLoading=table.find('input[name=sprLoading]').val();
	var feltPassivator=table.find('input[name=feltPassivator]').val();
	var sprayboomPressure=table.find('input[name=sprayboomPressure]').val();
	var sprayboomTemparature=table.find('input[name=sprayboomTemparature]').val();
	var wefanSpeed=table.find('input[name=wefanSpeed]').val();
	var defanSpeed=table.find('input[name=defanSpeed]').val();
	var makeUpAirDamper=table.find('input[name=makeUpAirDamper]').val();
	var exhaustDamper=table.find('input[name=exhaustDamper]').val();
	var exhaustFanSpeed=table.find('input[name=exhaustFanSpeed]').val();
	var wehoodTemperature=table.find('input[name=wehoodTemperature]').val();
	var dehoodTemperature=table.find('input[name=dehoodTemperature]').val();
	var yankeeAP=table.find('input[name=yankeeAP]').val();
	var afterDryerAP=table.find('input[name=afterDryerAP]').val();
	var secArmLoading=table.find('input[name=secArmLoading]').val();
	var reelOffset=table.find('input[name=reelOffset]').val();
	var uhleBoxNorthValve=table.find('input[name=uhleBoxNorthValve]').val();
	var uhleBoxSouthValve=table.find('input[name=uhleBoxSouthValve]').val();
	var faltBox1VacuumValve=table.find('input[name=faltBox1VacuumValve]').val();
	var faltBox2VacuumValve=table.find('input[name=faltBox2VacuumValve]').val();
	var faltBox4VacuumValve=table.find('input[name=faltBox4VacuumValve]').val();
	var fanPumpSpeed=table.find('input[name=fanPumpSpeed]').val();
	var totalHead=table.find('input[name=totalHead]').val();
	var headboxLevel=table.find('input[name=headboxLevel]').val();
	var horizontalSlice=table.find('input[name=horizontalSlice]').val();
	var verticalSlice=table.find('input[name=verticalSlice]').val();
	var selectifierRejectFlow1=table.find('input[name=selectifierRejectFlow1]').val();
	var selectifierRejectFlow2=table.find('input[name=selectifierRejectFlow2]').val();
	var secScreenCycleTime=table.find('input[name=secScreenCycleTime]').val();
	var lowDensityCycleTime=table.find('input[name=lowDensityCycleTime]').val();
	var refinersEnergy=table.find('input[name=refinersEnergy]').val();
	var numberOfRefiners=table.find('input[name=numberOfRefiners]').val();
	var refinerInletConsistency=table.find('input[name=refinerInletConsistency]').val();
	var machineChestConsistency=table.find('input[name=machineChestConsistency]').val();
	var stockFlow=table.find('input[name=stockFlow]').val();
	var sweetnerFlow=table.find('input[name=sweetnerFlow]').val();
	var broke=table.find('input[name=broke]').val();
	var wetStrength=table.find('input[name=wetStrength]').val();

	var yankeeSpeedMinC=table.find('input[name=yankeeSpeedMinC]').val();
	var qcsBasisWtTargetMinC=table.find('input[name=qcsBasisWtTargetMinC]').val();
	var reelMoistureMinC=table.find('input[name=reelMoistureMinC]').val();
	var crepeMinC=table.find('input[name=crepeMinC]').val();
	var yankeeSteamMinC=table.find('input[name=yankeeSteamMinC]').val();
	var yankeeReleaseMinC=table.find('input[name=yankeeReleaseMinC]').val();
	var yankeeAdesiveMinC=table.find('input[name=yankeeAdesiveMinC]').val();
	var jetWireRatioMinC=table.find('input[name=jetWireRatioMinC]').val();
	var fanPumpFlowRateMinC=table.find('input[name=fanPumpFlowRateMinC]').val();
	var afterDryerSteamMinC=table.find('input[name=afterDryerSteamMinC]').val();
	var sprLoadingMinC=table.find('input[name=sprLoadingMinC]').val();
	var feltPassivatorMinC=table.find('input[name=feltPassivatorMinC]').val();
	var sprayboomPressureMinC=table.find('input[name=sprayboomPressureMinC]').val();
	var sprayboomTemparatureMinC=table.find('input[name=sprayboomTemparatureMinC]').val();
	var wefanSpeedMinC=table.find('input[name=wefanSpeedMinC]').val();
	var defanSpeedMinC=table.find('input[name=defanSpeedMinC]').val();
	var makeUpAirDamperMinC=table.find('input[name=makeUpAirDamperMinC]').val();
	var exhaustDamperMinC=table.find('input[name=exhaustDamperMinC]').val();
	var exhaustFanSpeedMinC=table.find('input[name=exhaustFanSpeedMinC]').val();
	var wehoodTemperatureMinC=table.find('input[name=wehoodTemperatureMinC]').val();
	var dehoodTemperatureMinC=table.find('input[name=dehoodTemperatureMinC]').val();
	var yankeeAPMinC=table.find('input[name=yankeeAPMinC]').val();
	var afterDryerAPMinC=table.find('input[name=afterDryerAPMinC]').val();
	var secArmLoadingMinC=table.find('input[name=secArmLoadingMinC]').val();
	var reelOffsetMinC=table.find('input[name=reelOffsetMinC]').val();
	var uhleBoxNorthValveMinC=table.find('input[name=uhleBoxNorthValveMinC]').val();
	var uhleBoxSouthValveMinC=table.find('input[name=uhleBoxSouthValveMinC]').val();
	var faltBox1VacuumValveMinC=table.find('input[name=faltBox1VacuumValveMinC]').val();
	var faltBox2VacuumValveMinC=table.find('input[name=faltBox2VacuumValveMinC]').val();
	var faltBox4VacuumValveMinC=table.find('input[name=faltBox4VacuumValveMinC]').val();
	var fanPumpSpeedMinC=table.find('input[name=fanPumpSpeedMinC]').val();
	var totalHeadMinC=table.find('input[name=totalHeadMinC]').val();
	var headboxLevelMinC=table.find('input[name=headboxLevelMinC]').val();
	var horizontalSliceMinC=table.find('input[name=horizontalSliceMinC]').val();
	var verticalSliceMinC=table.find('input[name=verticalSliceMinC]').val();
	var selectifierRejectFlow1MinC=table.find('input[name=selectifierRejectFlow1MinC]').val();
	var selectifierRejectFlow2MinC=table.find('input[name=selectifierRejectFlow2MinC]').val();
	var secScreenCycleTimeMinC=table.find('input[name=secScreenCycleTimeMinC]').val();
	var lowDensityCycleTimeMinC=table.find('input[name=lowDensityCycleTimeMinC]').val();
	var refinersEnergyMinC=table.find('input[name=refinersEnergyMinC]').val();
	var numberOfRefinersMinC=table.find('input[name=numberOfRefinersMinC]').val();
	var refinerInletConsistencyMinC=table.find('input[name=refinerInletConsistencyMinC]').val();
	var machineChestConsistencyMinC=table.find('input[name=machineChestConsistencyMinC]').val();
	var stockFlowMinC=table.find('input[name=stockFlowMinC]').val();
	var sweetnerFlowMinC=table.find('input[name=sweetnerFlowMinC]').val();
	var brokeMinC=table.find('input[name=brokeMinC]').val();
	var wetStrengthMinC=table.find('input[name=wetStrengthMinC]').val();

	var yankeeSpeedMaxC=table.find('input[name=yankeeSpeedMaxC]').val();
	var qcsBasisWtTargetMaxC=table.find('input[name=qcsBasisWtTargetMaxC]').val();
	var reelMoistureMaxC=table.find('input[name=reelMoistureMaxC]').val();
	var crepeMaxC=table.find('input[name=crepeMaxC]').val();
	var yankeeSteamMaxC=table.find('input[name=yankeeSteamMaxC]').val();
	var yankeeReleaseMaxC=table.find('input[name=yankeeReleaseMaxC]').val();
	var yankeeAdesiveMaxC=table.find('input[name=yankeeAdesiveMaxC]').val();
	var jetWireRatioMaxC=table.find('input[name=jetWireRatioMaxC]').val();
	var fanPumpFlowRateMaxC=table.find('input[name=fanPumpFlowRateMaxC]').val();
	var afterDryerSteamMaxC=table.find('input[name=afterDryerSteamMaxC]').val();
	var sprLoadingMaxC=table.find('input[name=sprLoadingMaxC]').val();
	var feltPassivatorMaxC=table.find('input[name=feltPassivatorMaxC]').val();
	var sprayboomPressureMaxC=table.find('input[name=sprayboomPressureMaxC]').val();
	var sprayboomTemparatureMaxC=table.find('input[name=sprayboomTemparatureMaxC]').val();
	var wefanSpeedMaxC=table.find('input[name=wefanSpeedMaxC]').val();
	var defanSpeedMaxC=table.find('input[name=defanSpeedMaxC]').val();
	var makeUpAirDamperMaxC=table.find('input[name=makeUpAirDamperMaxC]').val();
	var exhaustDamperMaxC=table.find('input[name=exhaustDamperMaxC]').val();
	var exhaustFanSpeedMaxC=table.find('input[name=exhaustFanSpeedMaxC]').val();
	var wehoodTemperatureMaxC=table.find('input[name=wehoodTemperatureMaxC]').val();
	var dehoodTemperatureMaxC=table.find('input[name=dehoodTemperatureMaxC]').val();
	var yankeeAPMaxC=table.find('input[name=yankeeAPMaxC]').val();
	var afterDryerAPMaxC=table.find('input[name=afterDryerAPMaxC]').val();
	var secArmLoadingMaxC=table.find('input[name=secArmLoadingMaxC]').val();
	var reelOffsetMaxC=table.find('input[name=reelOffsetMaxC]').val();
	var uhleBoxNorthValveMaxC=table.find('input[name=uhleBoxNorthValveMaxC]').val();
	var uhleBoxSouthValveMaxC=table.find('input[name=uhleBoxSouthValveMaxC]').val();
	var faltBox1VacuumValveMaxC=table.find('input[name=faltBox1VacuumValveMaxC]').val();
	var faltBox2VacuumValveMaxC=table.find('input[name=faltBox2VacuumValveMaxC]').val();
	var faltBox4VacuumValveMaxC=table.find('input[name=faltBox4VacuumValveMaxC]').val();
	var fanPumpSpeedMaxC=table.find('input[name=fanPumpSpeedMaxC]').val();
	var totalHeadMaxC=table.find('input[name=totalHeadMaxC]').val();
	var headboxLevelMaxC=table.find('input[name=headboxLevelMaxC]').val();
	var horizontalSliceMaxC=table.find('input[name=horizontalSliceMaxC]').val();
	var verticalSliceMaxC=table.find('input[name=verticalSliceMaxC]').val();
	var selectifierRejectFlow1MaxC=table.find('input[name=selectifierRejectFlow1MaxC]').val();
	var selectifierRejectFlow2MaxC=table.find('input[name=selectifierRejectFlow2MaxC]').val();
	var secScreenCycleTimeMaxC=table.find('input[name=secScreenCycleTimeMaxC]').val();
	var lowDensityCycleTimeMaxC=table.find('input[name=lowDensityCycleTimeMaxC]').val();
	var refinersEnergyMaxC=table.find('input[name=refinersEnergyMaxC]').val();
	var numberOfRefinersMaxC=table.find('input[name=numberOfRefinersMaxC]').val();
	var refinerInletConsistencyMaxC=table.find('input[name=refinerInletConsistencyMaxC]').val();
	var machineChestConsistencyMaxC=table.find('input[name=machineChestConsistencyMaxC]').val();
	var stockFlowMaxC=table.find('input[name=stockFlowMaxC]').val();
	var sweetnerFlowMaxC=table.find('input[name=sweetnerFlowMaxC]').val();
	var brokeMaxC=table.find('input[name=brokeMaxC]').val();
	
	var afterDryerDrawMinC=table.find('input[name=afterDryerDrawMinC]').val();
	var afterDryerDraw=table.find('input[name=afterDryerDraw]').val();
	var afterDryerDrawMaxC=table.find('input[name=afterDryerDrawMaxC]').val();
	
	var horizontalSliceDcsMinC=table.find('input[name=horizontalSliceDcsMinC]').val();
	var horizontalSliceDcs=table.find('input[name=horizontalSliceDcs]').val();
	var horizontalSliceDcsMaxC=table.find('input[name=horizontalSliceDcsMaxC]').val();
	
	var verticalSliceDcsMinC=table.find('input[name=verticalSliceDcsMinC]').val();
	var verticalSliceDcs=table.find('input[name=verticalSliceDcs]').val();
	var verticalSliceDcsMaxC=table.find('input[name=verticalSliceDcsMaxC]').val();
	
	
	
	//New Fields
	var wetStrengthMaxC=table.find('input[name=wetStrengthMaxC]').val();
	saveLockGrade=true;
	
	$.ajax({
		url:saveGradeURL,
		type:'POST',
		data : {
			gradeCode : gradeCode.toUpperCase() , 
			issueDate : issueDate,
			revision : revision,
			yankeeSpeed : yankeeSpeed,
			qcsBasisWtTarget : qcsBasisWtTarget,
			reelMoisture : reelMoisture,
			crepe : crepe,
			yankeeSteam : yankeeSteam,
			yankeeRelease : yankeeRelease,
			yankeeAdesive : yankeeAdesive,
			jetWireRatio : jetWireRatio,
			fanPumpFlowRate : fanPumpFlowRate,
			afterDryerSteam : afterDryerSteam,
			sprLoading : sprLoading,
			feltPassivator : feltPassivator,
			sprayboomPressure : sprayboomPressure,
			sprayboomTemparature : sprayboomTemparature,
			wefanSpeed : wefanSpeed,
			defanSpeed : defanSpeed,
			makeUpAirDamper : makeUpAirDamper,
			exhaustDamper : exhaustDamper,
			exhaustFanSpeed : exhaustFanSpeed,
			wehoodTemperature : wehoodTemperature,
			dehoodTemperature : dehoodTemperature,
			yankeeAP : yankeeAP,
			afterDryerAP : afterDryerAP,
			secArmLoading : secArmLoading,
			reelOffset : reelOffset,
			uhleBoxNorthValve : uhleBoxNorthValve,
			uhleBoxSouthValve : uhleBoxSouthValve,
			faltBox1VacuumValve : faltBox1VacuumValve,
			faltBox2VacuumValve : faltBox2VacuumValve,
			faltBox4VacuumValve : faltBox4VacuumValve,
			fanPumpSpeed : fanPumpSpeed,
			totalHead : totalHead,
			headboxLevel : headboxLevel,
			horizontalSlice : horizontalSlice,
			verticalSlice : verticalSlice,
			selectifierRejectFlow1 : selectifierRejectFlow1,
			selectifierRejectFlow2 : selectifierRejectFlow2,
			secScreenCycleTime : secScreenCycleTime,
			lowDensityCycleTime : lowDensityCycleTime,
			refinersEnergy : refinersEnergy,
			numberOfRefiners : numberOfRefiners,
			refinerInletConsistency : refinerInletConsistency,
			machineChestConsistency : machineChestConsistency,
			stockFlow : stockFlow,
			sweetnerFlow : sweetnerFlow,
			broke : broke,
			wetStrength : wetStrength,

			yankeeSpeedMinC : yankeeSpeedMinC,
			qcsBasisWtTargetMinC : qcsBasisWtTargetMinC,
			reelMoistureMinC : reelMoistureMinC,
			crepeMinC : crepeMinC,
			yankeeSteamMinC : yankeeSteamMinC,
			yankeeReleaseMinC : yankeeReleaseMinC,
			yankeeAdesiveMinC : yankeeAdesiveMinC,
			jetWireRatioMinC : jetWireRatioMinC,
			fanPumpFlowRateMinC : fanPumpFlowRateMinC,
			afterDryerSteamMinC : afterDryerSteamMinC,
			sprLoadingMinC : sprLoadingMinC,
			feltPassivatorMinC : feltPassivatorMinC,
			sprayboomPressureMinC : sprayboomPressureMinC,
			sprayboomTemparatureMinC : sprayboomTemparatureMinC,
			wefanSpeedMinC : wefanSpeedMinC,
			defanSpeedMinC : defanSpeedMinC,
			makeUpAirDamperMinC : makeUpAirDamperMinC,
			exhaustDamperMinC : exhaustDamperMinC,
			exhaustFanSpeedMinC : exhaustFanSpeedMinC,
			wehoodTemperatureMinC : wehoodTemperatureMinC,
			dehoodTemperatureMinC : dehoodTemperatureMinC,
			yankeeAPMinC : yankeeAPMinC,
			afterDryerAPMinC : afterDryerAPMinC,
			secArmLoadingMinC : secArmLoadingMinC,
			reelOffsetMinC : reelOffsetMinC,
			uhleBoxNorthValveMinC : uhleBoxNorthValveMinC,
			uhleBoxSouthValveMinC : uhleBoxSouthValveMinC,
			faltBox1VacuumValveMinC : faltBox1VacuumValveMinC,
			faltBox2VacuumValveMinC : faltBox2VacuumValveMinC,
			faltBox4VacuumValveMinC : faltBox4VacuumValveMinC,
			fanPumpSpeedMinC : fanPumpSpeedMinC,
			totalHeadMinC : totalHeadMinC,
			headboxLevelMinC : headboxLevelMinC,
			horizontalSliceMinC : horizontalSliceMinC,
			verticalSliceMinC : verticalSliceMinC,
			selectifierRejectFlow1MinC : selectifierRejectFlow1MinC,
			selectifierRejectFlow2MinC : selectifierRejectFlow2MinC,
			secScreenCycleTimeMinC : secScreenCycleTimeMinC,
			lowDensityCycleTimeMinC : lowDensityCycleTimeMinC,
			refinersEnergyMinC : refinersEnergyMinC,
			numberOfRefinersMinC : numberOfRefinersMinC,
			refinerInletConsistencyMinC : refinerInletConsistencyMinC,
			machineChestConsistencyMinC : machineChestConsistencyMinC,
			stockFlowMinC : stockFlowMinC,
			sweetnerFlowMinC : sweetnerFlowMinC,
			brokeMinC : brokeMinC,
			wetStrengthMinC : wetStrengthMinC,

			yankeeSpeedMaxC : yankeeSpeedMaxC,
			qcsBasisWtTargetMaxC : qcsBasisWtTargetMaxC,
			reelMoistureMaxC : reelMoistureMaxC,
			crepeMaxC : crepeMaxC,
			yankeeSteamMaxC : yankeeSteamMaxC,
			yankeeReleaseMaxC : yankeeReleaseMaxC,
			yankeeAdesiveMaxC : yankeeAdesiveMaxC,
			jetWireRatioMaxC : jetWireRatioMaxC,
			fanPumpFlowRateMaxC : fanPumpFlowRateMaxC,
			afterDryerSteamMaxC : afterDryerSteamMaxC,
			sprLoadingMaxC : sprLoadingMaxC,
			feltPassivatorMaxC : feltPassivatorMaxC,
			sprayboomPressureMaxC : sprayboomPressureMaxC,
			sprayboomTemparatureMaxC : sprayboomTemparatureMaxC,
			wefanSpeedMaxC : wefanSpeedMaxC,
			defanSpeedMaxC : defanSpeedMaxC,
			makeUpAirDamperMaxC : makeUpAirDamperMaxC,
			exhaustDamperMaxC : exhaustDamperMaxC,
			exhaustFanSpeedMaxC : exhaustFanSpeedMaxC,
			wehoodTemperatureMaxC : wehoodTemperatureMaxC,
			dehoodTemperatureMaxC : dehoodTemperatureMaxC,
			yankeeAPMaxC : yankeeAPMaxC,
			afterDryerAPMaxC : afterDryerAPMaxC,
			secArmLoadingMaxC : secArmLoadingMaxC,
			reelOffsetMaxC : reelOffsetMaxC,
			uhleBoxNorthValveMaxC : uhleBoxNorthValveMaxC,
			uhleBoxSouthValveMaxC : uhleBoxSouthValveMaxC,
			faltBox1VacuumValveMaxC : faltBox1VacuumValveMaxC,
			faltBox2VacuumValveMaxC : faltBox2VacuumValveMaxC,
			faltBox4VacuumValveMaxC : faltBox4VacuumValveMaxC,
			fanPumpSpeedMaxC : fanPumpSpeedMaxC,
			totalHeadMaxC : totalHeadMaxC,
			headboxLevelMaxC : headboxLevelMaxC,
			horizontalSliceMaxC : horizontalSliceMaxC,
			verticalSliceMaxC : verticalSliceMaxC,
			selectifierRejectFlow1MaxC : selectifierRejectFlow1MaxC,
			selectifierRejectFlow2MaxC : selectifierRejectFlow2MaxC,
			secScreenCycleTimeMaxC : secScreenCycleTimeMaxC,
			lowDensityCycleTimeMaxC : lowDensityCycleTimeMaxC,
			refinersEnergyMaxC : refinersEnergyMaxC,
			numberOfRefinersMaxC : numberOfRefinersMaxC,
			refinerInletConsistencyMaxC : refinerInletConsistencyMaxC,
			machineChestConsistencyMaxC : machineChestConsistencyMaxC,
			stockFlowMaxC : stockFlowMaxC,
			sweetnerFlowMaxC : sweetnerFlowMaxC,
			brokeMaxC : brokeMaxC,
			wetStrengthMaxC : wetStrengthMaxC,
			
			afterDryerDrawMinC : afterDryerDrawMinC,
			afterDryerDraw : afterDryerDraw,
			afterDryerDrawMaxC : afterDryerDrawMaxC,
			horizontalSliceDcsMinC : horizontalSliceDcsMinC,
			horizontalSliceDcs: horizontalSliceDcs,
			horizontalSliceDcsMaxC : horizontalSliceDcsMaxC,
			verticalSliceDcsMinC : verticalSliceDcsMinC,
			verticalSliceDcs : verticalSliceDcs,
			verticalSliceDcsMaxC : verticalSliceDcsMaxC,
			
			id : id

		},
		success:function(data){
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text('Data saved successfully..');
				clearTimerGrade=setTimeout(function(){$('#tmessage').text('');}, 5000);
				saveLockGrade=false;
			}else{
				alert(data.error);
			}
			
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLockGrade=false;
		}
	});
}