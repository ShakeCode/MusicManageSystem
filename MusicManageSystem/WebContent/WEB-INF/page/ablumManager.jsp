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

		<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>

		<script src='<c:url value="/assert/js/jquery-1.11.2.min.js"></c:url>'></script>
		<script src='<c:url value="/assert/js/bootstrap.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/ie-emulation-modes-warning.js"></c:url>'></script>
		<script type="text/javascript" src='<c:url value="/assert/js/bootstrapValidator.js"></c:url>'></script>
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
							<a href="http://localhost:8080/MusicManageSystem/user/getAllUser">音乐管理 </a>
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
						<li  class="active">
							<a href="http://localhost:8080/MusicManageSystem/ablum/getAllAblum">专辑管理</a>
						</li>
						<li>
							<a href="http://localhost:8080/MusicManageSystem/message/getAllMessage">通知管理</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" ng-controller="UserList">
					<h2 class="sub-header">专辑列表</h2>
					<div>
						<a href="#" class="btn btn-primary btn-xm col-md-2" ng-click="addNewUser()">
							<span class="glyphicon glyphicon-plus">添加新专辑</span>
						</a>
						<div class="input-group col-md-5 col-md-offset-3">
							<input type="text" class="form-control" ng-model="searchcontent">
							<div class="input-group-btn">
								<button class="btn btn-primary" ng-click="search()">搜索</button>
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped " id="tableId" data-pagination="true">
							<thead>
								<tr>
									<th>ID</th>
									<th>专辑名</th>
									<th>歌手</th>
									<th>访问量</th>
									<th>介绍</th>
									<th>-</th>
									<th>-</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="x in users track by $index">
									<td>{{x.id}}</td>
									<td>{{x.name}}</td>
									<td>{{x.singer}}</td>
									<td>{{x.views}}</td>
									<td>{{x.introduction}}</td>
									<td>
										<button class="btn btn-primary" ng-click="modify($index)">修改</button>
									</td>
									<td>
										<button class="btn btn-primary" ng-click="deleteuser($index)">删除</button>
									</td>
								</tr>
							</tbody>
						</table>
						<!-- 分页-->
						<div class="text-right">
							<ul class="pager">
								<li>一共<span id="pagetotal" ng-model="page">1</span> 页，
								</li>
								<li>
									<a href="#" ng-click="previous()">上一页</a>
								</li>
								<li><span id="currentpage" ng-model="curpage" />1</span>
								</li>
								<li>
									<a href="#" ng-click="next()">下一页</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="modifyUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title" id="myModalLabel"><p ng-model="modalTitle"></p></h4>
								</div>
								<div class="modal-body">
									<form id="defaultForm">
										<div class="form-group input-group" ng-hide="div_id">
											<span class="input-group-addon">ID：</span>
											<input type="text" lass="form-control" readonly="true" ng-model="modalID"></span>
										</div>
										<div class="form-group input-group">
											<span class="input-group-addon">专辑名称：</span>
											<input type="text" class="form-control" placeholder="请输入专辑名称" ng-model="modalName" name="name">
										</div>
										<div class="form-group input-group">
											<span class="input-group-addon">歌手名称：</span>
											<input type="text" class="form-control" placeholder="请输入歌曲名称" ng-model="modalSinger" name="singer">
										</div>
										<div class="form-group input-group">
											<span class="input-group-addon">访问量：</span>
											<input type="number" class="form-control" placeholder="请输入专辑访问量" ng-model="modalViews" name="views">
										</div>
										<div class="form-group input-group">
											<span class="input-group-addon">简介 ：</span>
											<input type="text" class="form-control" placeholder="请输入专辑简介" ng-model="modalIntroduction" name="introduction">
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
									<button ng-hide="btn_add" type="button" class="btn btn-primary" ng-click="addUser()">确认</button>
									<button ng-hide="btn_modify" type="button" class="btn btn-primary" ng-click="modifyUser()">确认</button>

								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
				</div>
			</div>
	</body>

	<script>
		//每一页的数量
		var pagenums = 20;
		var totalpage;
		//验证
		$(document).ready(function() {
			$('#defaultForm').bootstrapValidator({
				message: 'This value is not valid',
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					name: {
						message: '专辑名称不能为空',
						validators: {
							notEmpty: {
								messgae: '专辑名称不能为空'
							},
						}
					},
					singer: {
						message: '歌手名称不能为空',
						validators: {
							notEmpty: {
								messgae: '歌手名称不能为空'
							},
						}
					},
					views: {
						message: '访问量不能为空',
						validators: {
							notEmpty: {
								messgae: '访问量不能为空'
							},
						}
					},
					introduction: {
						message: '简介不能为空',
						validators: {
							notEmpty: {
								messgae: '简介不能为空'
							},
						}
					}
				}
			});
			var u = <%=request.getAttribute("albums")%>;
			var l = u.length;
			if(l % pagenums == 0) {
				totalpage = l / pagenums;
			} else {
				totalpage = parseInt(l / pagenums + 1);
			}
			if(totalpage == 0){
				totalpage = 1;
			}
			//总页数
			$('#pagetotal').html(totalpage);
			//当前页数
			$('#currentpage').html("1");
		});
		var userlist = <%=request.getAttribute("albums")%>;
		var showlist = new Array(),
			num = 0;
		for(var user in userlist) {
			if(num >= pagenums) {
				break;
			}
			showlist[num++] = userlist[user];
		}
		var app = angular.module("myApp", []);
		app.controller("UserList", function($scope) {
			$scope.users = showlist;
			$scope.div_id = false;
			$scope.curpage = 1;
			//搜索按钮
			$scope.search = function() {
				var con = $scope.searchcontent;
				if(con == "") {
					$scope.users = showlist;
					return;
				}
				var list = new Array();
				var index = 0;
				for(var user in userlist) {
					if(userlist[user].name.indexOf(con) >= 0) {
						list[index++] = userlist[user];
					} else if(userlist[user].singer.indexOf(con) >= 0) {
						list[index++] = userlist[user];
					} else if(userlist[user].introduction.indexOf(con) >= 0) {
						list[index++] = userlist[user];
					} 
				}
				$scope.users = list;
			}
			//上一页按钮
			$scope.previous = function() {
				var nextpage;
				//当前页
				if($scope.curpage > 1) {
					nextpage = $scope.curpage - 1;
					var list = new Array();
					var index = 0;
					for(var user in userlist) {
						//当前页之前的
						if(user < ((nextpage - 1) * pagenums)) {
							user++;
							continue;
						}
						//当前页之后的
						if(user > (nextpage * pagenums-1)) {
							break;
						}
						//当前页的内容
						list[index] = userlist[user];
						index++;
					}
					//重置内容
					$scope.users = list;
					$scope.curpage = $scope.curpage-1;
					$('#currentpage').html($scope.curpage);
				}
			}
			//下一页按钮
			$scope.next = function() {
				var nextpage;
				$scope.curpage;
				//当前页
				if($scope.curpage < totalpage) {
					nextpage = $scope.curpage + 1;
					var list = new Array();
					var index = 0;
					for(var user in userlist) {
						//当前页之前的
						if(user < ((nextpage - 1) * pagenums)) {
							user++;
							continue;
						}
						//当前页之后的
						if(user > (nextpage * pagenums-1)) {
							break;
						}
						//当前页的内容
						list[index] = userlist[user];
						index++;
					}
					//重置内容
					$scope.users = list;
					$scope.curpage = $scope.curpage+1;
					$('#currentpage').html($scope.curpage);
				}
			}
			//修改按钮
			$scope.modify = function(index) {
				$scope.btn_add = true;
				$scope.btn_modify = false;
				$scope.div_id = false;
				$("h4").html("修改专辑信息");

				$scope.modalID = showlist[index].id;
				$scope.modalName = showlist[index].name;
				$scope.modalSinger = showlist[index].singer;
				$scope.modalViews = showlist[index].views;
				$scope.modalIntroduction = showlist[index].introduction;

				$('#modifyUserModal').modal('toggle');
			}
			//发送修改请求
			$scope.modifyUser = function() {
				//判断是否为空
				if($scope.modalName == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalSinger == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalViews == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalIntroduction == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				$.ajax({
					url: 'http://localhost:8080/MusicManageSystem/ablum/modify',
					type: "POST",
					data: {
						id: $scope.modalID,
						typeName : $scope.modalName,
					},
					success: function(date) {
						ajaxobj = eval("(" + date + ")");
						if(ajaxobj.isSuccess == "success") {
							$('#modifyUserModal').modal('hide');
							alert("修改专辑信息成功！");
							document.location.reload(); //当前页面 
						} else {
							alert("修改专辑信息失败！");
						}
					},
					error: function() {
						alert("连接错误！");
					}
				});
			}
			//添加新音乐按钮
			$scope.addNewUser = function() {
				$scope.btn_add = false;
				$scope.btn_modify = true;
				$scope.div_id = true;
				$("h4").html("添加新歌曲类型");
				$scope.modalName = "";
				$scope.modalSinger = "";
				$scope.modalViews = 1;
				$scope.modalIntroduction = "";

				$('#modifyUserModal').modal('toggle');
			}
			//发送添加音乐请求
			$scope.addUser = function() {
				//判断是否为空
				if($scope.modalName == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalSinger == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalViews == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				if($scope.modalIntroduction == "") {
					alert("专辑名、歌手名、访问量和解决不能为空！");
					return;
				}
				$.ajax({
					url: 'http://localhost:8080/MusicManageSystem/ablum/add',
					type: "POST",
					data: {
						name : $scope.modalName,
						singer : $scope.modalSinger,
						views : $scope.modalViews,
						introduction : $scope.modalIntroduction
					},
					success: function(date) {
						ajaxobj = eval("(" + date + ")");
						if(ajaxobj.isSuccess == "success") {
							$('#modifyUserModal').modal('hide');
							alert("添加专辑成功！");
							document.location.reload(); //当前页面 
						} else {
							alert("添加专辑失败！");
						}
					},
					error: function() {
						alert("连接错误！");
					}
				});
			}
			//发送删除请求
			$scope.deleteuser = function(index) {
				$.ajax({
					url: 'http://localhost:8080/MusicManageSystem/ablum/delete',
					type: "POST",
					data: {
						id: $scope.users[index].id
					},
					success: function(date) {
						ajaxobj = eval("(" + date + ")");
						if(ajaxobj.isSuccess == "success") {
							$('#modifyUserModal').modal('hide');
							alert("删除专辑成功！");
							document.location.reload(); //当前页面 
						} else {
							alert("删除专辑失败！");
						}
					},
					error: function() {
						alert("连接错误！");
					}
				});
			}
		})
	</script>

</html>