//用户的密码

$(function() {
	//进行登录判断
	$('.login-btn').click(function() {
		$username = $('#login #username');
		$psw = $('#login #password');
		//用户名为空不允许登录，给出提示
		if(!$username.val()) {
			inputEmty($username, '用户名不能为空');
			$username.tooltip('show');
		} else if(!$psw.val()) { //密码为空不允许登录，给出提示
			inputEmty($psw, '密码不能为空');
			$psw.tooltip('show');
		}/* else {
			var user_arr = users.filter(function(user) {
				return(user.name == $username.val() && user.psw == $psw.val());
			});
			if(user_arr.length < 1) {
				alert('用户名密码组合错误！');
			} else {
				window.location = 'home.html#' + user_arr[0].name;
			}
		}*/
		 $.ajax({
				type:"post",
				dataType:"json",
				data:{"role":$("input[name='role']:checked").val(),"username":$("#username").val(),"passward":$("#password").val()},
				url:"/MusicManageSystem/user/login/home",
				async:true,
				success:function(data){
					debugger
					if(data.status == 0){
						$.notify("登录失败");
					}else{
						$.notify("登录成功");
						if($("input[name='role']:checked").val() == "1"){
							//2秒钟之后跳转到指定的页面 
							setTimeout(window.location.href='/MusicManageSystem/user/login/index',10); 
						}else{
							setTimeout(window.location.href='/MusicManageSystem/user/getAllUser',2); 
						}
						/* $("#btlogin").attr("disabled",false);
						$('#btlogin').removeAttr('onclick');//去掉a标签中的onclick事件 */
						
					}
				},
				error:function(error){
					
				}, 
		 }) 
	});

	// 图片的样子：

	$('.input-has-tip').on({
		'propertychange input': function() { //当输入框输入内容时，取消tip
			if($(this).val()) {
				console.log($(this).val());
				$(this).tooltip('destroy');
				$(this).removeClass('danger');
				return;
			}

		},

		'blur': function() { //输入框失去焦点时隐藏tip
			$(this).tooltip('hide');
			$(this).removeClass('focus');
		},
		'focus': function() {
			$(this).addClass('focus');
		}

	});
	//---------------------------注册
	var isRegister = true;
	// 进行注册
	$('.register-btn').click(function() {
		
		$username = $('#register #usernameRes');
		$psw = $('#register #passwordRes');
		$repsw = $('#register #repassword');
		
//		alert($username.val());
//		alert($psw.val());
//		alert($repsw.val());
		//用户名为空不允许登录，给出提示
		if(!$username.val()) {     
			inputEmty($username, '用户名不能为空');
			$.notify("用户名不能为空");
			$username.tooltip('show');
			
			return ;
		} else if(!$psw.val()) { //密码为空不允许登录，给出提示
			inputEmty($psw, '密码不能为空');
			$.notify("密码不能为空");
			$psw.tooltip('show');
			return ;
		} else if(!$repsw.val()) {
			inputEmty($repsw, '请确认密码');
			$.notify("请确认密码");
			$repsw.tooltip('show');
			return ;
		} else if(!($repsw.val() == $psw.val())) {
			inputEmty($repsw, '两次密码不一致');
			$.notify("两次密码不一致");
			$repsw.tooltip('show');
			
			return ;
		} else if($psw.val().length < 6) { //密码为空不允许登录，给出提示
			inputEmty($psw, '密码过短,长度不可以少于6位');
			$.notify("密码过短,长度不可以少于6位");
			$psw.tooltip('show');
			
			return ;
		} 
		alert(1);
		 $.ajax({
				type:"post",
				dataType:"json",
				data:{"role":$("input[name='role']:checked").val(),"username":$("#usernameRes").val(),"passward":$("#passwordRes").val()},
				url:"/MusicManageSystem/user/register",
				async:false,
				success:function(data){
					debugger
					if(data.message=="用户已存在"){
						$.notify("用户已存在");
						return ;
					}
					if(data.status == 0){
						$.notify("注册失败");
					}else{
						$.notify("注册成功");
						if($("input[name='role']:checked").val() == "1"){
							//2秒钟之后跳转到指定的页面 
							setTimeout(window.location.href='/MusicManageSystem/user/login',10); 
						}else{
							setTimeout(window.location.href='/MusicManageSystem/user/login',2); 
						}
					}
				},
				error:function(error){
					
				}, 
		 })
	});

	/**
	 * input输入框为空，给出提示
	 * @param {Object} $username
	 */
	function inputEmty($obj, tip) {
		$obj.tooltip({
			title: tip || '不能为空',
			trigger: 'click'
		});
		$obj.addClass('danger');
		//当先显示tooltip，同时出发focus事件，使得输入框变为红色
		$obj.on('show.bs.tooltip', function() {
			$obj.trigger('focus');
		});

	}

	$("form a").click(function() {
		var id = $(this).attr("id");
		switch(id) {
			case "switchToLogin":
				$("#register").slideUp(function(){
					$("#login").slideDown();
				});
				break;
			case "switchToRegister":
				$("#login").slideUp(function(){
					$("#register").slideDown();
				});
				break;
		}
	});
});