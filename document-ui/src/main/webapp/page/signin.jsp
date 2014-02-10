<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
<!-- Force latest IE rendering engine or ChromeFrame if installed -->
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<meta name="google" value="notranslate">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
<title>Document Handler</title>
<%@include file="common/headerStyle.jsp"%>
<%@include file="common/headerScript.jsp"%>
<link href="style/signin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
	<form class="form-signin" role="form" action="<%=request.getContextPath()%>/j_spring_security_check" method="post">
		<h2 class="form-signin-heading">Please sign in</h2>
		<input type="text" name="j_username" class="form-control" placeholder="Email address" required autofocus>
		<input type="password" name="j_password" class="form-control" placeholder="Password" required>
		<label class="checkbox"><input type="checkbox" value="remember-me">Remember me</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
</div>
</body>
</html>