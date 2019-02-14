/**
 * Created by 14366 on 2017/4/24.
 */
$(function() {
//	//如果用户没有登录，
//	var url = window.location.href;
//	var user = url.split('#')[1];
//	//判断用户是否存在用户列表中,存在的话，该exsitUserArr不为空数组
//	var exsitUserArr = users.filter(function(u){
//		return u.name==user;
//	});
//	if(exsitUserArr.length<1){
//		window.location='login.html';//前往登录页面
//	}
$('.img-circle').css({
			'height': $('.album-block .img-circle').width(),
			'line-height': $('.album-block  .img-circle').width() + 30 + 'px'
		});
	//当窗口大小变化时，进行图片的高度的调整使得图片始终都是圆形
	$(window).resize(function() {
		$('.img-circle').css({
			'height': $('.album-block .img-circle').width(),
			'line-height': $('.album-block  .img-circle').width() + 30 + 'px'
		});
		
	});
	//启动tooltip的提示功能
	$("[data-toggle='tooltip']").tooltip();
	$(".check-lyrics").click(function() {
		$("#lyricsModal").modal();
	});

	//分页的点击事件的处理
	$(".page-number").click(function() {
		if($(this).hasClass("active")) {
			return;
		} else {
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		}
	});

	//分页的组件的头与为的点击事件
	$('.aquo').click(function() {
		$(".page-number").removeClass('active');
		$(".page-number:eq(0)").addClass('active');

	});

	
	
	//点击菜单栏时进行切换
	$('.nav li').click(function(){
		switchBlock('songs-block');
	});
	/**
	 * 版块切换
	 */
	function switchBlock(downBlock) {
		switch(downBlock) {
			case 'songs-block':
				console.log('songs-block');
				$('#singer-songs-block').slideUp('fast');
				$('#songs-block').slideDown('fast');
				break;
			case 'singer-songs-block':
				console.log('singer-songs-block');
				$('#songs-block').slideUp('fast');
				$('#singer-songs-block').slideDown('fast');
				break;
		}
	}
	
	//点击搜搜
	$('.search').click(function(){
		var text = $('.search-input').val();
		if(text){
			switchBlock('singer-songs-block');
		}else{
			alert('请输入搜索内容');
		}
	});
	
});