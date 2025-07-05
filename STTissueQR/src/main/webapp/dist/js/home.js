 
						$(function(){
							
							$(document).on('click', '#addBreak', function(){
								let date=$(this).closest('tr').find('td:eq(1) input').val(); 
								window.location.href='/timecard/addBraek/'+encodeURIComponent(date);
							});

							$(document).on('click', '#addCallIn', function(){
								let date=$(this).closest('tr').find('td:eq(1) input').val(); 
								window.location.href='/timecard/addCallIn/'+encodeURIComponent(date);
							});

							$(document).on("focusout","#inTime,#outTime", function(){
								
								let dayOfWeek=$(this).closest('tr').find('td:eq(0) input').val();
								let localDate=$(this).closest('tr').find('td:eq(1) input').val();								
								let inTime=$(this).closest('tr').find('td:eq(2) input[name=inTime]').val();
								let outTime=$(this).closest('tr').find('td:eq(3) input[name=outTime]').val();
								
								//let hoursWorkHoliAndSun=$(this).closest('tr').find('td:eq(5) select[name=hoursWorkHoliAndSun]').val();
								//let holiDayOverTime=$(this).closest('tr').find('td:eq(9) input[name=overTime]').val();
								//let floatingHoliday=$(this).closest('tr').find('td:eq(10) input[name=floatingHoliday]').val();
								//let vacation=$(this).closest('tr').find('td:eq(11) input[name=vacation]').val();
								//let holiday=$(this).closest('tr').find('td:eq(12) input[name=holiday]').val();
								//let funeral=$(this).closest('tr').find('td:eq(13) input[name=funeral]').val();
								//let comment=$(this).closest('tr').find('td:eq(15) input[name=comment]').val();
								if(inTime=='')
									{
										alert('Please choose correct inTime Formate as 07:30 AM');
										return;
									}
									if(outTime==''){
										return;
									}	
									if(outTime==''){
										alert('Please choose correct outTime Formate as 07:30 AM');
										return;
									}
									
									$.ajax({
										url:'${savePayrollInOutTime}',
										type:'POST',
										data:   {
											localDate			:	localDate,
											inTime 				: 	inTime,
										    outTime 			: 	outTime
										},
										success:function(data){
											if(!data){
											    alert('You are only allowed to take one floating vacation.');																							
											}
											location.reload(true);															
										}
									}); 
									
								});


						$(document).on("focusout","#vacation", function(){
								
								let dayOfWeek=$(this).closest('tr').find('td:eq(0) input').val();
								let localDate=$(this).closest('tr').find('td:eq(1) input').val();
								
								let vacation=$(this).closest('tr').find('td:eq(11) input[name=vacation]').val();

									if(vacation<0)
									{
										alert('Please put positive Number Only !');
										return;
										location.reload();
									}
									

								let data={
											localDate :	localDate,
											vacation : vacation
										};				  
										$.ajax({
											url:'${savePayrollvacation}',
											type:'POST',
											data:   data,
											success:function(data){
												
												if(data!=1){
													alert(data);
													location.reload(true);	
												}else
													location.reload(true);
											}
										}); 								
									
								});


						$(document).on("focusout","#floatingHoliday", function(){							
							let localDate=$(this).closest('tr').find('td:eq(1) input').val();							
							let floatingHoliday=$(this).closest('tr').find('td:eq(10) input[name=floatingHoliday]').val();
								if(floatingHoliday=='')return;
								if(floatingHoliday<0){
									alert('Please put positive Number Only !');
									return;
								}
							let data={
										localDate :	localDate,
										floatingHoliday : floatingHoliday
									};				  
									$.ajax({
										url:'${savefloatingHoliday}',
										type:'POST',
										data:   data,
										success:function(data){											
											if(data>2)
												alert('Only '+data +' Hours Applicable !');
											if(data==0)
												alert('No Floating holiday');
											location.reload(true);
										}
									});
							});

						$(document).on("focusout","#funeral", function(){							
							let localDate=$(this).closest('tr').find('td:eq(1) input').val();							
							let funeral=$(this).closest('tr').find('td:eq(13) input[name=funeral]').val();
								if(funeral=='')return;
								if(funeral<0){
									alert('Please put positive Number Only !');
									return;
								}
							let data={
										localDate :	localDate,
										funeral : funeral
									};				  
									$.ajax({
										url:'${saveFuneral}',
										type:'POST',
										data:   data,
										success:function(data){											
											if(data>2)
												alert('Only '+data +' Hours Funeral left !  ');
											if(data==0)
												alert('No Funeral');
											location.reload(true);	
										}
									});
							});

						$(document).on("focusout","#comment", function(){							
							let localDate=$(this).closest('tr').find('td:eq(1) input').val();							
							let comment=$(this).closest('tr').find('td:eq(15) input[name=comment]').val();
								if(comment=='')return;
							let data={
										localDate :	localDate,
										comment : comment
									};
							alert();				  
									$.ajax({
										url:'${saveComment}',
										type:'POST',
										data:   data,
										success:function(data){											
											if(data>2)
												alert('Only '+data +' Hours Funeral left !  ');
											if(data==0)
												alert('No Funeral');
											location.reload(true);	
										}
									});
							});
							
							
						

						$(document).on("change","#position", function(){							
							let localDate=$(this).closest('tr').find('td:eq(1) input').val();							
							let position=$(this).closest('tr').find('td:eq(14) select[name=position]').val();
								if(position=='')return;
							let data={
										localDate :	localDate,
										position : position
									};				  
									$.ajax({
										url:'${savePosition}',
										type:'POST',
										data:   data,
										success:function(data){											
											if(data>2)
												alert('Only '+data +' Hours Funeral left !  ');
											if(data==0)
												alert('No Funeral');
											location.reload(true);	
										}
									});
							});
							
							
						});