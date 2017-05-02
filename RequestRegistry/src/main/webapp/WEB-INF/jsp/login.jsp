<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script>
$(function() {
$("#login-form").validate({
    rules: {
        password: {
          required: true,
        },
        username: {
          required: true,
        }
    }
});
});

</script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();' style="  background-image: url('https://teknikol.com/img/bg/blur-background08.jpg');">

<div class="page-header" style="text-align: center;">
  <h1>Request Registry <small style="color: #aaaaaa;">by ZPatrik94</small></h1>
</div>

	<div id="login-box">

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">${msg}</div>
		</c:if>
		
		<h3 style="text-align: center; " class="label label-primary">Login:</h3>

		<form name='loginForm' id="login-form"
			action="<c:url value='login' />"
			method='POST'>

			<table width = "100%">
				<tr>
				
					<td style="padding-bottom: 5px; padding-top: 5px;">
					<div>
					<input class="form-control" type='text' name='username' placeholder="Username">
					</div>
					</td>
					
				</tr>
				<tr>
					<td style="padding-bottom: 5px"><input class="form-control" type='password' name='password' placeholder="Password"/></td>
				</tr>

				<tr>
					<td style="text-align: center;" colspan='2'>
					<input name="submit" class="btn btn-lg btn-default" type="submit"
						value="Sign In" />
						</td>
				</tr>

			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>

	</div>

</body>
</html>
