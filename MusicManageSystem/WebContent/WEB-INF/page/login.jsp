<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/buttons.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login-style.css" />

		
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/userSet.js"></script>
	<script src="${pageContext.request.contextPath }/js/login.js"></script>
	<script src="${pageContext.request.contextPath }/js/notify.js"></script>

</head>


	<body>
		<!--<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-sm-10 col-sm-offset-1">
					<div class="alert alert-info alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                &times;
      </button> 用户名：ycj 和 密码：ycj 可以登录哦
					</div>
				</div>
			</div>

		</div>
		-->
		<div class="container">
			<div class="col-lg-6 col-md-8 col-sm-10 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
				<!--登录-->
				<div id="login" class="content center-block">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12 text-center logo-wrap">
								<div class="my-hidden-xs">
									<img src="${pageContext.request.contextPath }/img/music.jpg" class="img-circle">
								</div>
								<h4 class="my-visible-xs">Login </h4>
							</div>
						</div>
						<form role="form">
						   <div class="form-group col-md-10 col-md-offset-1" id="uinArea">
			                    <div class="inputOuter3" style="margin-left: 120px">
				                    <label style="margin-right: 50px"><input name="role" type="radio" value="1" checked="checked"/ style="margin-right: 5px">用戶 </label> 
									<label><input name="role" type="radio" value="2" style="margin-right: 5px" />管理員</label> 
								</div>
			               </div>
               
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="input-group">
									<input class="form-control input-has-tip" id="username" placeholder="USERNAME" />
									<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
								</div>
							</div>
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="input-group">
									<input type="password" class="form-control input-has-tip" id="password" placeholder="PASSWORD" />
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
								</div>
							</div>
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="checkbox">
									<a href="javascript:void(0);" id="switchToRegister" class="text-uppercase">&lt;&lt; register</a>
								</div>
								<span href="javascript:login(0);" class="login-btn button-uppercase button-raised button-primary button-small">loggin</span>
							</div>

						</form>
					</div>
				</div>
				<!--注册-->
				<div id="register" class="content center-block">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12 text-center logo-wrap">
								<div class="my-hidden-xs">
									<img src="${pageContext.request.contextPath}/img/music.jpg" class="img-circle">
								</div>
								<h4 class="my-visible-xs">Register</h4>
							</div>
						</div>
						<form role="form">
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="input-group">
									<input class="form-control input-has-tip" id="usernameRes" placeholder="USERNAME" />
									<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
								</div>
							</div>
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="input-group">
									<input type="password" class="form-control input-has-tip" id="passwordRes" placeholder="PASSWORD" />
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
								</div>
							</div>
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="input-group">
									<input type="password" class="form-control input-has-tip" id="repassword" placeholder="PASSWORD RECOMFIRM" />
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
								</div>
							</div>
							<div class="form-group col-md-10 col-md-offset-1">
								<div class="checkbox">
									<a href="javascript:register();" id="switchToLogin" class="text-uppercase">&lt;&lt; login</a>
								</div>
								<span class="register-btn button-uppercase button-raised button-primary button-small">register</span>
							</div>

						</form>
					</div>
				</div>
			</div>

		</div>
	</body>
	
	<script type="text/javascript">
		$(function($){
	
		})
	</script>
</html>