$(function(){           
     			$(document).on('change', '#starDate', function(){
					var sdate=$('select[name=starDate]').val();	
					const d = new Date(sdate);
					let day = d.getDay()				
					if(day!=0){
							alert('Please Chose Only Moday');
							return;
					}
					d.setDate(d.getDate()+14);
					const yyyy = d.getFullYear();
					let mm = d.getMonth() + 1; // Months start at 0!
					let dd = d.getDate();

					if (dd < 10) dd = '0' + dd;
					if (mm < 10) mm = '0' + mm;

					const formattedToday = yyyy + '/' + mm + '/' + dd;
					const edate = new Date(formattedToday).toISOString().slice(0, 10)								
					$('#edate').val(edate);	
				}); 
     			var gloval; 
     			$(document).on('focusin', 'input', function(){
         			
             			if($(this).val()=='')
             				gloval=0;
             			else
     						gloval=$(this).val();     				
     			});	   			
				$(document).on('change', 'input', function(){
					var vacationID=$(this).closest('tr').find('td:eq(0) input').val();
					var sysCode=$(this).closest('tr').find('td:eq(1) input').val();
					var empId=$(this).closest('tr').find('td:eq(2) input').val();
					var empName=$(this).closest('tr').find('td:eq(3) input').val();
					var email=$(this).closest('tr').find('td:eq(4) input').val();
					var eligibleVacations=$(this).closest('tr').find('td:eq(5) input').val();
					var eligibleVacationsDate=$(this).closest('tr').find('td:eq(6) input').val();
					var openingVacation=$(this).closest('tr').find('td:eq(7) input').val();
					var openingVacationDate=$(this).closest('tr').find('td:eq(8) input').val();
					var availabelVacation=$(this).closest('tr').find('td:eq(9) input').val();
					var usedVacation=$(this).closest('tr').find('td:eq(10) input').val();
					var lepsVactions=$(this).closest('tr').find('td:eq(11) input').val();
					var lepsVactionsDate=$(this).closest('tr').find('td:eq(12) input').val();
					var addOnVactions=$(this).closest('tr').find('td:eq(13) input').val();
					var addOnVactionsDate=$(this).closest('tr').find('td:eq(14) input').val();
					var vactionsYear=$(this).closest('tr').find('td:eq(15) input').val();
					var payout1Data=$(this).closest('tr').find('td:eq(16) input').val();
					var payout1Date=$(this).closest('tr').find('td:eq(17) input').val();
					var payout2Data=$(this).closest('tr').find('td:eq(18) input').val();
					var payout2Date=$(this).closest('tr').find('td:eq(19) input').val();
					var payout3Data=$(this).closest('tr').find('td:eq(20) input').val();
					var payout3Date=$(this).closest('tr').find('td:eq(21) input').val();
					var payout4Data=$(this).closest('tr').find('td:eq(22) input').val();
					var payout4Date=$(this).closest('tr').find('td:eq(23) input').val();
					
					var current=$(this).attr('id');
							
					if(current=='payout1Data'){
						
						if(payout1Data=='')
							payout1Data=0;					
						payout1Data=parseFloat(payout1Data);
						gloval=parseFloat(gloval);
						if(availabelVacation>=payout1Data){
							availabelVacation=availabelVacation-payout1Data+gloval;							
							usedVacation=parseFloat(usedVacation)+payout1Data-gloval;					
							
							$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
							$(this).closest('tr').find('td:eq(10) input').val(usedVacation);
						}else{ 
							alert('Please Put valid vacation !'); 
							alert('you can take maximum  '+availabelVacation+'  vacation '); 
							var payout1Data=$(this).closest('tr').find('td:eq(16) input').val("");
						}	
					}
					if(current=='payout2Data'){
					if(payout2Data=='')
						payout2Data=0;				
					payout2Data=parseFloat(payout2Data);
					gloval=parseFloat(gloval);
					if(availabelVacation>=payout2Data){					
					availabelVacation=availabelVacation-payout2Data+gloval;
					usedVacation=parseFloat(usedVacation)+payout2Data-gloval;
												
					$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
					$(this).closest('tr').find('td:eq(10) input').val(usedVacation);
					}else{ 
						alert('Please Put valid vacation !'); 
						alert('you can take maximum  '+availabelVacation+'  vacation ');
						var payout2Data=$(this).closest('tr').find('td:eq(18) input').val("");
							
					}
				}
					if(current=='payout3Data'){
						if(payout3Data=='')
							payout3Data=0;				
						payout3Data=parseFloat(payout3Data);
						gloval=parseFloat(gloval);
						if(availabelVacation>=payout3Data){	
							availabelVacation=availabelVacation-payout3Data+gloval;
							usedVacation=parseFloat(usedVacation)+payout3Data-gloval;
													
							$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
							$(this).closest('tr').find('td:eq(10) input').val(usedVacation);
						}else{ 
							alert('Please Put valid vacation !'); 
							alert('you can take maximum  '+availabelVacation+'  vacation ');
							 var payout3Data=$(this).closest('tr').find('td:eq(20) input').val("");
						}
					}
					if(current=='payout4Data'){
						if(payout4Data=='')
							payout4Data=0;				
						payout4Data=parseFloat(payout4Data);
						gloval=parseFloat(gloval);
						
						if(availabelVacation>=payout4Data){		
							availabelVacation=availabelVacation-payout4Data+gloval;
							usedVacation=parseFloat(usedVacation)+payout4Data-gloval;				
														
							$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
							$(this).closest('tr').find('td:eq(10) input').val(usedVacation);
						}else{ 
							alert('Please Put valid vacation !'); 
							alert('you can take maximum  '+availabelVacation+'  vacation ');
							var payout4Data=$(this).closest('tr').find('td:eq(22) input').val("");
						}
					}
					if(current=='lepsVactions'){
						if(lepsVactions=='')
							lepsVactions=0;				
						lepsVactions=parseFloat(lepsVactions);
						gloval=parseFloat(gloval);
						
						if(availabelVacation>=lepsVactions){		
							availabelVacation=availabelVacation-lepsVactions+gloval;
							usedVacation=parseFloat(usedVacation)+lepsVactions-gloval;				
														
							$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
							$(this).closest('tr').find('td:eq(10) input').val(usedVacation);
						}else{ 
							alert('Please Put valid vacation !'); 
							alert('you can take maximum  '+availabelVacation+'  vacation ');
							var payout4Data=$(this).closest('tr').find('td:eq(22) input').val("");
						}
					}

					if(current=='addOnVactions'){
						if(addOnVactions=='')
							addOnVactions=0;				
						addOnVactions=parseFloat(addOnVactions);
						gloval=parseFloat(gloval);
						availabelVacation=parseFloat(availabelVacation);
						openingVacation=parseFloat(openingVacation);
						availabelVacation=availabelVacation+addOnVactions-gloval;
						openingVacation=openingVacation+addOnVactions-gloval;
						$(this).closest('tr').find('td:eq(7) input').val(openingVacation);			
						$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
						
					}
					
					if(current=='openingVacation'){
						if(openingVacation=='')
							openingVacation=0;				
						openingVacation=parseFloat(openingVacation);						
						availabelVacation=openingVacation-usedVacation					
												
						$(this).closest('tr').find('td:eq(9) input').val(availabelVacation);
						
					}			
				});					
				$(document).on('change', 'input', function(){

					var vacationID=$(this).closest('tr').find('td:eq(0) input').val();
					var sysCode=$(this).closest('tr').find('td:eq(1) input').val();
					var empId=$(this).closest('tr').find('td:eq(2) input').val();
					var empName=$(this).closest('tr').find('td:eq(3) input').val();
					var email=$(this).closest('tr').find('td:eq(4) input').val();
					var eligibleVacations=$(this).closest('tr').find('td:eq(5) input').val();
					var eligibleVacationsDate=$(this).closest('tr').find('td:eq(6) input').val();
					var openingVacation=$(this).closest('tr').find('td:eq(7) input').val();
					var openingVacationDate=$(this).closest('tr').find('td:eq(8) input').val();
					var availabelVacation=$(this).closest('tr').find('td:eq(9) input').val();
					var usedVacation=$(this).closest('tr').find('td:eq(10) input').val();
					var lepsVactions=$(this).closest('tr').find('td:eq(11) input').val();
					var lepsVactionsDate=$(this).closest('tr').find('td:eq(12) input').val();
					var addOnVactions=$(this).closest('tr').find('td:eq(13) input').val();
					var addOnVactionsDate=$(this).closest('tr').find('td:eq(14) input').val();
					var vactionsYear=$(this).closest('tr').find('td:eq(15) input').val();
					var payout1Data=$(this).closest('tr').find('td:eq(16) input').val();
					var payout1Date=$(this).closest('tr').find('td:eq(17) input').val();
					var payout2Data=$(this).closest('tr').find('td:eq(18) input').val();
					var payout2Date=$(this).closest('tr').find('td:eq(19) input').val();
					var payout3Data=$(this).closest('tr').find('td:eq(20) input').val();
					var payout3Date=$(this).closest('tr').find('td:eq(21) input').val();
					var payout4Data=$(this).closest('tr').find('td:eq(22) input').val();
					var payout4Date=$(this).closest('tr').find('td:eq(23) input').val();

					$.ajax({
						url:'${saveAllvacationReport}',
						type:'POST',
						data:   {
														
							vacationID:vacationID,
							sysCode:sysCode,
							empId:empId,
							empName:empName,
							email:email,
							eligibleVacations:eligibleVacations,
							eligibleVacationsDate:eligibleVacationsDate,
							openingVacation:openingVacation,
							openingVacationDate:openingVacationDate,							
							availabelVacation:availabelVacation,
							usedVacation:usedVacation,
							lepsVactions:lepsVactions,
							lepsVactionsDate:lepsVactionsDate,
							addOnVactions:addOnVactions,
							addOnVactionsDate:addOnVactionsDate,
							payout1Data:payout1Data,
							payout1Date:payout1Date,
							payout2Data:payout2Data,
							payout2Date:payout2Date,
							payout3Data:payout3Data,
							payout3Date:payout3Date,
							payout4Data:payout4Data,
							payout4Date:payout4Date,
							
							vactionsYear:vactionsYear
							
						},
						success:function(data){
							if(!data){
							    alert('You are only allowed to take one floating vacation.');																							
							}
							/* window.location.reload(); */														
						}
					}); 						
								
				});				
			
					
					
     		});