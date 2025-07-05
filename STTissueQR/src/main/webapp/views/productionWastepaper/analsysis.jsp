<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
  /* #paperProductionChart {
    width: 400px !important; /* Force width */
    height: 400px !important; /* Force height */
    display: block; /* Ensure it's a block-level element */
    box-sizing: border-box; /* Include padding and border in the element's total width and height */
}
#paperProductionChart1 {
    width: 400px !important; /* Force width */
    height: 400px !important; /* Force height */
    display: block; /* Ensure it's a block-level element */
    box-sizing: border-box; /* Include padding and border in the element's total width and height */
} */

  canvas {
      width: 100% !important;  /* Force canvas width to be 100% of its container */
      height: auto !important; /* Automatically adjust the height based on the aspect ratio */
  }

  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    background-color: #f4f4f4;
    color: #333;
    font-size: 16px;
}

/* Dashboard container */
.dashboard {
    width: 90%;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

/* Dashboard header */
.dashboard-header {
    text-align: center;
    margin-bottom: 20px;
}

.dashboard-header h1 {
    font-size: 2em;
    font-weight: bold;
    color: #4CAF50;
}

/* Dashboard content layout */
.dashboard-content {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: 20px;
}

/* Chart container */
.chart-container {
    background: #fff;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

/* Ensure the canvas takes up full space */
canvas {
    width: 100% !important;
    height: auto !important;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});

</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">ST Tissue Inventory</span>
				</div>
				<br>
				<div class="table-selector">
				<spring:url value="/analysis/view" var="viewURL"/>
				<form action="${viewURL}" method="get">	
					<table>
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							
							<td>Customer:</td>
							<td>
								<select name="customer" style="padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${customers}" var="cust">
										<c:choose>
											<c:when test="${customer eq cust}">
												<option value="${cust}" selected="selected">${cust}</option>
											</c:when>
											<c:otherwise>
												<option value="${cust}">${cust}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>Machine:</td>
							<td>
								<select name="machine" style="padding: 2px;">
									<option value="">Select</option>
									<option value="WR6" >PM6</option>
									<option value="WR5" >PM5</option>
								</select>
							</td>
							
							<td>Quater:</td>
							<td>
								<select name="quater" style="padding: 2px;">
									<option value="">Select</option>
									<option value="1" >1</option>
									<option value="2" >2</option>
									<option value="3" >3</option>
									<option value="4" >4</option>
								</select>
							</td>
							<td>
								<button type="submit">VIEW</button>
							</td>
						</tr>
					</table>
				</form>
				</div>
				
<div style="padding: 2px; ">
<c:if test="${data == 'true'}"> 
<div class="dashboard">
    <header class="dashboard-header">
        <h1>Graph Dashboard</h1>
    </header>
  <div class="dashboard-content">
      <div class="chart-container">
          <canvas id="paperProductionChart"></canvas>
      </div>
      <div class="chart-container">
          <canvas id="paperProductionChart1"></canvas>
      </div>
       <div class="chart-container">
        <canvas id="chart4"></canvas>
    </div>  
  </div>
</div>
</c:if>

    <script>
    // Prepare the labels and data arrays
    var labels = [];
    var data = [];

    <c:forEach var="production" items="${paperProductionList}">
        labels.push('${production.month}');
        data.push(${production.production});
    </c:forEach>

    // Create the chart
    var ctx = document.getElementById('paperProductionChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [
                {
                label: 'Machine Production (Tons)',
                backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 2,		
				fill:false,
                data: data
            },
            {
                label: 'Wrapper Production (Tons)',
                backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 1,

                data: data
            }



                ]
        },
        options: {
          responsive: false,  // Disable responsiveness
        maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
    const ctx4 = document.getElementById('chart4').getContext('2d');
const chart4 = new Chart(ctx4, {
    type: 'radar',
    data: {
        labels: ['Running', 'Swimming', 'Eating', 'Cycling'],
        datasets: [{
            label: 'My First Dataset',
            data: [20, 10, 4, 2],
            fill: true,
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            borderColor: 'rgb(255, 99, 132)',
            pointBackgroundColor: 'rgb(255, 99, 132)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgb(255, 99, 132)'
        }]
    },
    options: {
        responsive: true,
        scales: {
            r: {
                angleLines: {
                    display: false
                },
                suggestedMin: 0,
                suggestedMax: 20
            }
        }
    }
});
</script>
<script>
  // Prepare the labels and data arrays
  var labels = [];
  var data = [];

  <c:forEach var="production" items="${paperProductionList}">
      labels.push('${production.month}');
      data.push(${production.production});
  </c:forEach>

  // Create the chart
  var ctx = document.getElementById('paperProductionChart1').getContext('2d');
  var chart = new Chart(ctx, {
      type: 'line',
      data: {
          labels: labels,
          datasets: [{
              label: 'Paper Production (Tons)',
              backgroundColor: 'rgba(0, 123, 255, 0.5)',
              borderColor: 'rgba(0, 123, 255, 1)',
              data: data
          }]
      },
      options: {
        responsive: false,  // Disable responsiveness
      maintainAspectRatio: false,
          scales: {
              y: {
                  beginAtZero: true
              }
          }
      }
  });
</script>
</div>
			</div>

		</div>


	</div>

</body>
</html>
