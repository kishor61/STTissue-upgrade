$(function(){
	$('#findMatchBtn').click(function(){
		var reel=$('#reelTaableBody input[name=rowCheckbox]:checked').val();
		if(reel){
			
			var tr=$('#reelTaableBody input[name=rowCheckbox]:checked').parent().parent();
			
			var gradeCode=tr.find('input[name=gradeCode]').val();
			var actualBasisWt=tr.find('input[name=actualBasisWt]').val();
			var bulk=tr.find('input[name=bulk]').val();
			var mdTensile=tr.find('input[name=mdTensile]').val();
			var cdTensile=tr.find('input[name=cdTensile]').val();
			var mdStretch=tr.find('input[name=mdStretch]').val();
			var mdcdTensileRatio=tr.find('input[name=mdcdTensileRatio]').val();
			var mdWetTensile=tr.find('input[name=mdWetTensile]').val();
			var cdWetTensile=tr.find('input[name=cdWetTensile]').val();
			var cdTensileRatio=tr.find('input[name=cdTensileRatio]').val();
			var brightness=tr.find('input[name=brightness]').val();
			var dirtCount=tr.find('input[name=dirtCount]').val();
			
			$('#dialog').show();
			$('#dialogBody').text('Loading....');
			
			$('#dialogBody').load(findmatchUrl,{
				gradeCode:gradeCode,
				actualBasisWt:actualBasisWt,
				bulk:bulk,
				mdTensile:mdTensile,
				cdTensile:cdTensile,
				mdStretch:mdStretch,
				mdcdTensileRatio:mdcdTensileRatio,
				mdWetTensile:mdWetTensile,
				cdWetTensile:cdWetTensile,
				cdTensileRatio:cdTensileRatio,
				brightness:brightness,
				dirtCount:dirtCount
				
			});
		}else{
			alert('Select row!');
		}
	});
	
	
	$( "#dialog" ).draggable({ handle: "#dialogHeader" });
});