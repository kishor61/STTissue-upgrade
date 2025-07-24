<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='dist/css/login.css' />">
    <script>
        // Auto-hide error message after 5 seconds
        window.onload = function() {
            const errorMessage = document.querySelector('.error-message');
            if (errorMessage) {
                setTimeout(function() {
                    errorMessage.style.transition = 'opacity 1s ease-out';
                    errorMessage.style.opacity = '0';
                    setTimeout(function() {
                        errorMessage.style.display = 'none';
                    }, 1000);
                }, 5000);
            }
        };
    </script>
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h1 style="font-family: 'Futura', 'Avenir', 'Century Gothic', sans-serif; margin-top: -20px; text-align: center;">
                <img src="<c:url value='/dist/images/STTissue.JPG' />" alt=" STTissue Solutions" style="max-width: 400px; display: inline-block;">
            </h1>
            
            <c:if test="${param.error != null}">
                <div class="error-message">
                    Invalid username or password. Please try again.
                </div>
            </c:if>
            
            <form action="<c:url value='/login' />" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" placeholder="Enter Username" required>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter Password" required>
                
                <button type="submit">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
