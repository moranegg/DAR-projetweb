


$(document).ready(function() 
		{

	$.getJSON('http://data.iledefrance.fr/api/records/1.0/search/?dataset=liste_des_musees_franciliens&rows=139&facet=dept', 
			function(json_data)
			{ 
		console.log(JSON.stringify(json_data));
			});

		});

