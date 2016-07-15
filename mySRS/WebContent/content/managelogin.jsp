<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
</head>
<body>
<script src="../js/jquery-3.0.0.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap.js"></script>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-12">
			<h3>
				学生选课系统
			</h3>
			<h3 class="text-center">
				登录
			</h3>
		</div>
	</div>
	<div class="row-fluid">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<form action="../Login" method="post" class="form-horizontal">
				<div class="control-group">
					 <label class="control-label" for="inputEmail">账号</label>
					<div class="controls">
						<input id="inputEmail" name="username" type="text" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input id="inputPassword"  name="password" type="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<br/>
						<input type="radio" name="identity" value="student" checked="checked" />学生 
						<input type="radio" name="identity" value="professor" />教师 
						<input type="radio" name="identity" value="admin" />管理员
					</div>
					<div class="controls">
						 <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
					</div>
				</div>
			
			
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>
</body>
</html>