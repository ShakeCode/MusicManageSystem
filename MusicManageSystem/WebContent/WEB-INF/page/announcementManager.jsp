<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>后台管理页面</title>

		<link rel="stylesheet" href='<c:url value="/assert/css/bootstrap.css"></c:url>' />
		<link rel="stylesheet" href='<c:url value="/assert/css/bootstrapValidator.css"></c:url>'>
		<link href='<c:url value="/assert/css/ie10-viewport-bug-workaround.css"></c:url>' rel="stylesheet">
		<link href='<c:url value="/assert/css/dashboard.css"></c:url>' rel="stylesheet">
		<link href='<c:url value="/assert/css/trumbowyg.css"></c:url>' rel="stylesheet">

		<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>

		<script src='<c:url value="/assert/js/jquery-1.11.2.min.js"></c:url>'></script>
		<script src='<c:url value="/assert/js/bootstrap.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/ie-emulation-modes-warning.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/bootstrapValidator.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/trumbowyg.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/cn.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/trumbowyg.base64.js"></c:url>'></script>

	</head>

	<body ng-app="myApp">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<a class="navbar-brand" href="#">在线音乐管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="http://localhost:8080/MusicManageSystem/user/login">退出</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<li>
							<a href="http://localhost:8080/MusicManageSystem/user/getAllUser">用户管理 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/manager/getAllManager">管理员管理</a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/singer/getAllSinger">歌手管理</a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/song/getAllSong">音乐管理</a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/ablum/getAllAblum">专辑管理</a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/message/getAllMessage">通知管理</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" ng-controller="UserList">
					<h2 class="sub-header">公告管理</h2>
					<div>
						<div class="input-group">
							<span class="input-group-addon">标题:</span>
							<input type="text" class="form-control" ng-model="title">
						</div>
					</div>
					<div>
						&nbsp;
						<div> 
							<span class="label col-md-1" style="font-size: 15px;background-color: rgb(238, 238, 238); color: rgb(51, 51, 51);"> 公告内容： </span>
						</div>
						&nbsp;
						<div id="customized-buttonpane" class="editor">
						</div>
					</div>
					<button type="button" class="btn btn-primary" ng-click="save()">保存</button>
				</div>
			</div>
	</body>

	<script>
		$('#customized-buttonpane').trumbowyg({
			lang: 'cn',
			closable: true,
			fixedBtnPane: true,
			btnsDef: {
				// Customizables dropdowns
				align: {
					dropdown: ['justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],
					ico: 'justifyLeft'
				},
				image: {
					dropdown: ['base64'],
					ico: 'insertImage'
				}
			},
			btns: ['viewHTML',
				'|', 'formatting',
				'|', 'btnGrp-test',
				'|', 'align',
				'|', 'btnGrp-lists',
				'|', 'image'
			]
		});
		$('.editor').on('dblclick', function(e) {
			$(this).trumbowyg({
				lang: 'cn',
				closable: true,
				fixedBtnPane: true

			});
		});
		var tit = <%=request.getAttribute("title")%>;
		var con = '<%=request.getAttribute("content")%>';
		//初始化
		$('#customized-buttonpane').html(con);
		var app = angular.module("myApp", []);
		app.controller("UserList", function($scope) {
			$scope.title = tit;
			$scope.content = con;
			
			$scope.save = function(){
				var con = $('#customized-buttonpane').trumbowyg('html');
				if(con=="" || con==null || $scope.title == "" || $scope.title == null){
					alert("标题和内容都不能为空！");
					return;
				}
				$.ajax({
					url: 'http://localhost:8080/MusicManageSystem/message/saveAnnouncement',
					type: "POST",
					data: {
						title:$scope.title,
						content:con
					},success: function(date) {
						ajaxobj = eval("(" + date + ")");
						if(ajaxobj.isSuccess == "success") {
							$('#modifyUserModal').modal('hide');
							alert("修改公告信息成功！");
							document.location.reload(); //当前页面 
						} else {
							alert("修改公告信息失败！");
						}
					},
					error: function() {
						alert("连接错误！");
					}
				})
			}
		})
	</script>

</html>