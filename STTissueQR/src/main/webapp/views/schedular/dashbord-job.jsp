<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .status-success {
            color: green;
            font-weight: bold;
        }
        .status-failed {
            color: red;
            font-weight: bold;
        }
        .status-in-progress {
            color: orange;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4 text-center">Cron Job Dashboard</h1>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Job Name</th>
                    <th>Status</th>
                    <th>Settings</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="job" items="${jobs}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${job.jobName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${job.status == 'SUCCESS'}">
                                    <span class="status-success">${job.status}</span>
                                </c:when>
                                <c:when test="${job.status == 'FAILED'}">
                                    <span class="status-failed">${job.status}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="status-in-progress">${job.status}</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <div class="d-flex justify-content-around">
                                <button class="btn btn-sm btn-primary" onclick="editJob('${job.id}')">Edit</button>
                                <button class="btn btn-sm btn-danger" onclick="deleteJob('${job.id}')">Delete</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- JavaScript for actions -->
    <script>
        function editJob(jobId) {
            alert("Edit functionality is not implemented yet for Job ID: " + jobId);
            // Add actual edit logic here
        }

        function deleteJob(jobId) {
            if (confirm("Are you sure you want to delete this job?")) {
                alert("Delete functionality is not implemented yet for Job ID: " + jobId);
                // Add actual delete logic here
            }
        }
    </script>
</body>
</html>
