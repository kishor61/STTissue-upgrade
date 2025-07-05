function coutMDCDRatio(m,c){
	var ratio=0;
	var md=parseFloat(m);
	var cd=parseFloat(c);
	if(!isNaN(md) & md!=''& !isNaN(cd) & cd!=''){
		ratio=md/cd;
		ratio=roundValue(ratio);
	}
		
	return ratio;
}

function coutCDWetDryRatio(m,c){
	var ratio=0;
	var md=parseFloat(m);
	var cd=parseFloat(c);
	if(!isNaN(md) & md!=''& !isNaN(cd) & cd!=''){
		ratio=md/cd;
		ratio=roundValue(ratio);
	}
		
	return ratio;
}

function countFwaDosage(pc,sc){
	var ratio=0;
	var p=parseFloat(pc);
	var s=parseFloat(sc);
	
	if(!isNaN(p) & p!=''& !isNaN(s) & s!=''){
		ratio=(p/s)*(0.12);
		ratio=roundValue(ratio);
	}
		
	return ratio;
}


function roundValue(value){
	return Math.round(value * 100) / 100;
}

