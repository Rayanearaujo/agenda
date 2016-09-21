//<![CDATA[
		           
		var eventos = [[${eventos}]];
	        
		// An array of dates
	        var eventDates = {};
	        for (i = 0; i < eventos.length; i++) {
	        	var d = eventos[i].data;
				d =  d.slice(0, 10).split('-');
				d = d[1] +'-'+ d[2] +'-'+ d[0];
	        	eventDates[ new Date( d )] = new Date( d );
	        }	
		
			$('#calendar').datepicker({
				inline: true,
				firstDay: 1,
				showOtherMonths: true,
				dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
				dateFormat: "dd-mm-yy",
				
				beforeShowDay: function(date) {
			        var highlight = eventDates[date];
			        if (highlight) {
			             return [true, "event", highlight];
			        } else {
			             return [true, '', ''];
			        }
			     },
			
				onSelect: function(){
		        	var selected = $(this).val();
		        	$('#teste').empty();
		        	$('#tabela').empty();

					for (i = 0; i < eventos.length; i++) {		
						
						var d = eventos[i].data;
						d =  d.slice(0, 10).split('-');
						d = d[2] +'-'+ d[1] +'-'+ d[0];
						
						if (selected == d){
							var thead = $('<tr>');
							thead.append($('<th>').text('Titulo'));
							thead.append($('<th>').text('Hora'));
							$('#tabela').prepend(thead);
									
							var tds = $('<tr>');
							tds.append($('<td>').text(eventos[i].titulo));
							tds.append($('<td>').text(eventos[i].horaevento));
							/*tds.append($('<td>').text(eventos[i].descricao));
							tds.append($('<td>').text(eventos[i].data));
							tds.append($('<td>').text(eventos[i].tipo.descricao));*/
							$('#teste').prepend(tds);
						}
					}
				}
			       
	   		});
		//]]> 