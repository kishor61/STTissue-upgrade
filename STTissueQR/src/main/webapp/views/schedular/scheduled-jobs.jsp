<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> Dashboard</title>
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

        .fade-out {
        transition: opacity 0.5s ease-out;
        opacity: 0;
    }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4 text-center">Emails Job Dashboard</h1>
<c:if test="${not empty message}">
    <div id="flashMessage" class="alert alert-success alert-dismissible fade show" role="alert">
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
        <!-- Add New Job Button -->
        <div class="mb-3 text-end">
            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#newJobModal">Add New Job</button>
        </div>

     <div class="mb-3 text-end">
    <button class="btn btn-success" onclick="location.href='<spring:url value="/dashboard/maildashboard"/>'">
    Daily Monitoring
</button></div>


        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Job Name</th>
                    <th>Last Execution</th>
                    <th>Next Execution</th>
                    <th>Cron Expression</th>
                    <th>Email Address</th>
                    <th>Status</th>
                    <th>Settings</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="job" items="${jobs}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${job.jobName}</td>
                        <td></td>
                        <td></td>
                         <td>${job.cronExpression}</td> 
                         <td>${job.email}</td>
                        <td>
                            <c:choose>
                                <c:when test="${job.active == 'true'}">
                                    <span class="status-success">Active</span>
                                </c:when>
                                <c:when test="${job.active == 'false'}">
                                    <span class="status-failed">Inactive</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="status-in-progress"></span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <div class="d-flex justify-content-around">

                                 <!-- Edit Button -->
                <button class="btn btn-sm btn-primary" 
                        data-bs-toggle="modal" 
                        data-bs-target="#editJobModal" 
                        onclick="openEditModal('${job.id}', '${job.jobName}', '${job.cronExpression}', '${job.active}','${job.email}')">
                    Edit
                </button>
                                <!-- Delete Button -->
                <button class="btn btn-sm btn-danger" onclick="confirmDelete('${job.id}')">Delete</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Modal for Adding New Job -->
    <div class="modal fade" id="newJobModal" tabindex="-1" aria-labelledby="newJobModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="<c:url value='/JobMonitoring/save'/>" method="post" onsubmit="return validateForm();">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newJobModalLabel">Add New Job</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="jobName" class="form-label">Job Name</label>
                            <input type="text" class="form-control" id="jobName" name="jobName" required>
                        </div>
                        <div class="mb-3">
                            <label for="cronExpression" class="form-label">Cron Expression</label>
                            <input type="text" class="form-control" id="cronExpressionId" name="cronExpression" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email Addresses</label>
                            <input type="text" class="form-control" id="emailId" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="status" class="form-label">Status</label>
                            <select class="form-select" id="status" name="active" required>
                                <option value="1">Active</option>
                                <option value="0">InActive</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add Job</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


<!-- Modal for Edit Job -->

    <div class="modal fade" id="editJobModal" tabindex="-1" aria-labelledby="editJobModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <form action="<c:url value='/JobMonitoring/editJob'/>" method="post" onsubmit="return validateForm();">
                <div class="modal-header">
                    <h5 class="modal-title" id="editJobModalLabel">Edit Job</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="editJobId" name="id" >
                    <div class="mb-3">
                        <label for="editJobName" class="form-label">Job Name</label>
                        <input type="text" class="form-control" id="editJobName" name="jobName" required>
                    </div>
                    <div class="mb-3">
                        <label for="editCronExpression" class="form-label">Cron Expression</label>
                        <input type="text" class="form-control" id="editCronExpression" name="cronExpression" required>
                    </div>

                    <div class="mb-3">
                        <label for="editEmail" class="form-label">Email Address</label>
                        <input type="text" class="form-control" id="editEmail" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="editStatus" class="form-label">Status</label>
                        <select class="form-select" id="editStatus" name="active" required>
                            <option value="1">Active</option>
                            <option value="0">Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function openEditModal(jobId, jobName, cronExpression, status,email) {
        // Populate the modal fields with the job's data
        document.getElementById('editJobId').value = jobId;
        document.getElementById('editJobName').value = jobName;
        document.getElementById('editEmail').value = email;
        document.getElementById('editCronExpression').value = cronExpression;
        document.getElementById('editStatus').value = status;
    }


    function confirmDelete(jobId) {
        if (confirm("Are you sure you want to delete this job?")) {
      const url = "/STTissueQR/JobMonitoring/deleteJob?id="+jobId;
        window.location.href = url;
    }
    }

    setTimeout(function() {
        var flashMessage = document.getElementById('flashMessage');
        if (flashMessage) {
            flashMessage.classList.add('fade-out');
            setTimeout(function() {
                flashMessage.remove();
            }, 500); // Remove after fade-out completes
        }
    }, 1000);

    function validateForm() {
    const cronExpression = document.getElementById("cronExpressionId").value;
    const email = document.getElementById("emailId").value;

    // Validate Cron Expression
    if (!isValidCronExpression(cronExpression)) {
        showError("Invalid Cron Expression! Please ensure the cron syntax is correct.");
        return false;
    }

    // Validate Email
    if (!isValidEmail(email)) {
        showError("Invalid Email Address! Please enter a valid email.");
        return false;
    }

    // If all validations pass, clear any error messages and proceed
    clearError();
    return true;
}

// Helper function to validate Cron Expression
function validateCronExpression(cronExpression) {
    const cronPattern = /^((\*|([0-9]|[1-5][0-9])(-([0-9]|[1-5][0-9]))?)(\/[1-9][0-9]*)?(,(\*|([0-9]|[1-5][0-9])(-([0-9]|[1-5][0-9]))?)(\/[1-9][0-9]*)?)*) (\*|([0-9]|1[0-9]|2[0-3])(-([0-9]|1[0-9]|2[0-3]))?)(\/[1-9][0-9]*)?(,(\*|([0-9]|1[0-9]|2[0-3])(-([0-9]|1[0-9]|2[0-3]))?)(\/[1-9][0-9]*)?)* (\*|([1-9]|[1-2][0-9]|3[0-1])(-([1-9]|[1-2][0-9]|3[0-1]))?)(\/[1-9][0-9]*)?(,(\*|([1-9]|[1-2][0-9]|3[0-1])(-([1-9]|[1-2][0-9]|3[0-1]))?)(\/[1-9][0-9]*)?)* (\*|(1[0-2]|[1-9])(-([1-9]|1[0-2]))?)(\/[1-9][0-9]*)?(,(\*|(1[0-2]|[1-9])(-([1-9]|1[0-2]))?)(\/[1-9][0-9]*)?)* (\*|([0-6])(-([0-6]))?)(\/[1-9][0-9]*)?(,(\*|([0-6])(-([0-6]))?)(\/[1-9][0-9]*)?)*$/;

    if (!cronPattern.test(cronExpression)) {
        
        return false;
    }
    return true;
}


// Helper function to validate Email Address
function isValidEmail(email) {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailPattern.test(email);
}

// Helper function to show error messages
function showError(message) {
    const errorDiv = document.getElementById("errorDiv");
    if (errorDiv) {
        errorDiv.innerText = message;
        errorDiv.style.display = "block";
    } else {
        alert(message); // Fallback if errorDiv is not present
    }
}

// Helper function to clear error messages
function clearError() {
    const errorDiv = document.getElementById("errorDiv");
    if (errorDiv) {
        errorDiv.innerText = "";
        errorDiv.style.display = "none";
    }
}
</script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- JavaScript for additional actions -->
</body>
</html>
