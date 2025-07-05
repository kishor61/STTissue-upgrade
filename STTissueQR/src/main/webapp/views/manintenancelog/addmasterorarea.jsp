<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('#saveBtn').click(function(){
			var name=$.trim($('input[name=name]').val());
			if(name==''){
				alert('Please enter customer name.');
				return false;
			}
			
			return true;
		});
	});
</script>
<!-- Inline CSS for 3D Animation and Hover Effects -->
<style>
    /* 3D animation for the form */
    @keyframes formAnimation {
       
        100% {
            transform: rotateY(0);
            opacity: 1;
        }
    }

    /* Button Hover effect */
    #saveBtn:hover {
        background-color: #ff3d62; /* Light pink color when hovered */
        transform: scale(1.1); /* Slight zoom effect */
    }

    #saveBtn:active {
        transform: scale(0.95); /* Shrink effect when clicked */
    }

    /* General styling for inputs and textareas */
    input[type="text"], textarea {
        height: 40px;
        font-size: 14px;
        border-radius: 6px;
        background-color: #f3f3f3;
        color: #333;
        padding: 10px;
        border: 2px solid #fff;
        transition: background-color 0.3s ease;
        width: 100%;
    }

    input[type="text"]:focus, textarea:focus {
        background-color: #e0f7fa; /* Light cyan background on focus */
        border-color: #4CAF50; /* Green border on focus */
        outline: none;
    }

    /* Add shadow and animation to input fields */
    input[type="text"], textarea {
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        transition: box-shadow 0.3s ease, transform 0.2s ease;
    }

    input[type="text"]:focus, textarea:focus {
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        transform: scale(1.02); /* Slight scale effect */
    }
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Add Area</h5></div>

		<div class="block3">
			<div class="pageContent">

			
	<br>
	<span class="error">${error}</span>
	<span class="message">${message}</span>
	<form action='<spring:url value="/manintenancelog/addmasterorarea/save"/>' method="get">
	    <div style="max-width: 600px; margin: 20px auto; padding: 20px; background: #2189b9; border-radius: 10px; box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2); animation: formAnimation 2s ease-in-out; transform-style: preserve-3d; position: relative; overflow: hidden;">
	        <table style="width: 100%; color: #fff; font-family: 'Arial', sans-serif;">
	            <!-- User Type Row -->
	            <tr>
	                <td style="padding: 10px 0; font-size: 16px;">User Type</td>
	                <td style="padding: 10px 0;">
	                    <input type="text" name="usertype" value="${usetype}" readonly="readonly" style="width: 100%; padding: 10px; border: 2px solid #fff; border-radius: 5px; background-color: #f3f3f3; color: #333;">
	                </td>
	            </tr>
	            
	            <!-- Area Name Row -->
	            <tr>
	                <td style="padding: 10px 0; font-size: 16px;">Area Name</td>
	                <td style="padding: 10px 0;">
	                    <input type="text" name="name" style="width: 100%; padding: 10px; border: 2px solid #fff; border-radius: 5px; background-color: #f3f3f3; color: #333;">
	                </td>
	            </tr>
	            
	            <!-- Description Row -->
	            <tr>
	                <td style="padding: 10px 0; font-size: 16px;">Description</td>
	                <td style="padding: 10px 0;">
	                    <textarea name="description" style="width: 100%; height: 100px; padding: 10px; border: 2px solid #fff; border-radius: 5px; background-color: #f3f3f3; color: #333;"></textarea>
	                </td>
	            </tr>
	            
	            <!-- Submit Button Row -->
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Submit" id="saveBtn" style="background-color: #ff5c8d; color: white; padding: 10px 20px; font-size: 16px; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s ease, transform 0.2s ease;">
	                </td>
	            </tr>
	        </table>
	    </div>
	</form>

			</div>

		</div>


	</div>
	<!-- /.content-wrapper -->
	                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
	                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
	                   </footer>
</div>
</body>
</html>
