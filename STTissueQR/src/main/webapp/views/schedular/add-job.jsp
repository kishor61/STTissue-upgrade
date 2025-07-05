<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add/Edit Job</title>
</head>
<body>
    <h1>Add/Edit Scheduled Job</h1>
    <form action="/scheduled-jobs/save" method="post">
        <input type="hidden" name="id" value="${job.id}" />
        <div>
            <label>Job Name:</label>
            <input type="text" name="jobName" value="${job.jobName}" required />
        </div>
        <div>
            <label>Cron Expression:</label>
            <input type="text" name="cronExpression" value="${job.cronExpression}" required />
        </div>
        <div>
            <label>Active:</label>
            <input type="checkbox" name="active" ${job.active ? 'checked' : ''} />
        </div>
        <div>
            <button type="submit">Save</button>
            <a href="/scheduled-jobs">Cancel</a>
        </div>
    </form>
</body>
</html>
