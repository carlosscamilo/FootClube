function myFunction() {
	var a = document.getElementById("teste1").value;


			// Set new default font family and font color to mimic Bootstrap's
			// default styling
			Chart.defaults.global.defaultFontFamily = 'Nunito',
			'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#858796';

	var jogadores = document.getElementById("coluna1").value;
	var times = document.getElementById("coluna2").value;
	var tecnicos = document.getElementById("coluna3").value;

	// Pie Chart Example
	var ctx = document.getElementById("myPieChart");
	var myPieChart = new Chart(ctx, {
		type : 'doughnut',
		data : {
			labels : [ "Total Jogadores", "Total Times", "Total Tecnicos" ],
			datasets : [ {
				data : [ jogadores, times, tecnicos ],
				backgroundColor : [ '#4e73df', '#1cc88a', '#36b9cc' ],
				hoverBackgroundColor : [ '#2e59d9', '#17a673', '#2c9faf' ],
				hoverBorderColor : "rgba(234, 236, 244, 1)",
			} ],
		},
		options : {
			maintainAspectRatio : false,
			tooltips : {
				backgroundColor : "rgb(255,255,255)",
				bodyFontColor : "#858796",
				borderColor : '#dddfeb',
				borderWidth : 1,
				xPadding : 15,
				yPadding : 15,
				displayColors : false,
				caretPadding : 10,
			},
			legend : {
				display : false
			},
			cutoutPercentage : 80,
		},
	});

}

function selectTime(idTime){
	console.log(idTime);
	var idTime = document.getElementById("idTime").value = idTime[idTime.selectedIndex].value;
	form.submit();
}
