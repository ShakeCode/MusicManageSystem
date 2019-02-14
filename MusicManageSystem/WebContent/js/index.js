$(function() {
	// 播放列表页中播放器中播放列表数据
	var musicSrcData = [{
			id: 1,
			title: "As Long As You Love",
			artist: "Backstreet Boys",
			mp3: "E:\\music\\Backstreet Boys-Backstreet'S Back-As Long As You Love Me-320.mp3",
			oga: "E:\\music\\Backstreet Boys-Backstreet'S Back-As Long As You Love Me-320.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 2,
			title: "I want you that way",
			artist: "Backstreet Boys",
			mp3: "E:\\music\\i-want-you.mp3",
			oga: "E:\\music\\i-want-you.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 3,
			title: "眼睛不能没眼泪",
			artist: "古巨基",
			mp3: "E:\\music\\古巨基-Guitar Fever-眼睛不能没眼泪-128.mp3",
			oga: "E:\\music\\古巨基-Guitar Fever-眼睛不能没眼泪-128.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 4,
			title: "阴天",
			artist: "莫文蔚",
			mp3: "E:\\music\\莫文蔚-你可以-阴天-128.mp3",
			oga: "E:\\music\\莫文蔚-你可以-阴天-128.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
	];
	// 保存歌曲页中列表的数据
	var addMusicSrcData = [{
			id: 5,
			title: "匆匆那年",
			artist: "王菲",
			mp3: "E:\\music\\王菲-匆匆那年-匆匆那年-320.mp3",
			oga: "E:\\music\\王菲-匆匆那年-匆匆那年-320.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 6,
			title: "Where Did U Go",
			artist: "邓紫棋",
			mp3: "E:\\music\\G.E.M.邓紫棋-G.E.M.-Where Did U Go-320.mp3",
			oga: "E:\\music\\G.E.M.邓紫棋-G.E.M.-Where Did U Go-320.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 7,
			title: "Yesterday Once More",
			artist: "Carpenters-Singles",
			mp3: "E:\\music\\Carpenters-Singles 1969-1981-Yesterday Once More-128.mp3",
			oga: "E:\\music\\Carpenters-Singles 1969-1981-Yesterday Once More-128.ogg",
			poster: "../../img/singers/yqh.jpg"
		},

	];
	// 这是搜索歌曲的时候，将搜索的到的歌曲的结果保存到这个变量中
	var addMusicSrcData2 = [{
			id: 51,
			title: "姊妹",
			artist: "杨千嬅",
			mp3: "../../music/杨千嬅 - 姊妹.mp3",
			oga: "../../music/杨千嬅 - 姊妹.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 52,
			title: "小城大事",
			artist: "杨千嬅",
			mp3: "../../music/杨千嬅 - 小城大事.mp3",
			oga: "../../music/杨千嬅 - 小城大事.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 53,
			title: "野孩子",
			artist: "杨千嬅 ",
			mp3: "../../music/杨千嬅 - 野孩子.mp3",
			oga: "../../music/杨千嬅 - 野孩子.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 54,
			title: "吻别",
			artist: "张学友 ",
			mp3: "../../music/英文歌 - 吻别.mp3",
			oga: "../../music/英文歌 - 吻别.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 55,
			title: "匆匆那年",
			artist: "王菲",
			mp3: "E:\\music\\王菲-匆匆那年-匆匆那年-320.mp3",
			oga: "E:\\music\\王菲-匆匆那年-匆匆那年-320.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 6,
			title: "Where Did U Go",
			artist: "邓紫棋",
			mp3: "E:\\music\\G.E.M.邓紫棋-G.E.M.-Where Did U Go-320.mp3",
			oga: "E:\\music\\G.E.M.邓紫棋-G.E.M.-Where Did U Go-320.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 7,
			title: "Yesterday Once More",
			artist: "Carpenters-Singles",
			mp3: "E:\\music\\Carpenters-Singles 1969-1981-Yesterday Once More-128.mp3",
			oga: "E:\\music\\Carpenters-Singles 1969-1981-Yesterday Once More-128.ogg",
			poster: "../../img/singers/yqh.jpg"
		},

	];
	// 以下三组分类的数据是排行榜的数据
	var catogerySongs1 = [{
			id: 8,
			title: "Everybody's Changing",
			artist: "Keane",
			mp3: "../../Keane - Everybody's Changing.mp3",
			oga: "../../Keane - Everybody's Changing.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 9,
			title: "Because Of You",
			artist: "Kelly Clarkson",
			mp3: "../../Kelly Clarkson - Because Of You.mp3",
			oga: "../../Kelly Clarkson - Because Of You.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 10,
			title: "处处吻",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 处处吻.mp3",
			oga: "../../杨千嬅 - 处处吻.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 11,
			title: "大城大事",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 大城大事.mp3",
			oga: "../../杨千嬅 - 大城大事.ogg",
			poster: "../../img/singers/yqh.jpg"
		},

	]
	var catogerySongs2 = [{
			id: 12,
			title: "好不容易遇见爱",
			artist: "Keane",
			mp3: "../../杨千嬅 - 好不容易遇见爱.mp3",
			oga: "../../杨千嬅 - 好不容易遇见爱.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 13,
			title: "假如让我说下去",
			artist: "Kelly Clarkson",
			mp3: "../../杨千嬅 - 假如让我说下去.mp3",
			oga: "../../杨千嬅 - 假如让我说下去.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 14,
			title: "处可惜我是水瓶座",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 处可惜我是水瓶座.mp3",
			oga: "../../杨千嬅 - 处可惜我是水瓶座.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 15,
			title: "烈女",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 烈女.mp3",
			oga: "../../杨千嬅 - 烈女.ogg",
			poster: "../../img/singers/yqh.jpg"
		},

	]
	var catogerySongs3 = [{
			id: 16,
			title: "少女的祈祷",
			artist: "杨千嬅",
			mp3: "../../music/杨千嬅 - 少女的祈祷.mp3",
			oga: "../../music/杨千嬅 - 少女的祈祷.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 17,
			title: "小城大事",
			artist: "杨千嬅",
			mp3: "../../杨千嬅 - 小城大事.mp3",
			oga: "../../杨千嬅 - 小城大事.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 18,
			title: "野孩子",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 野孩子.mp3",
			oga: "../../杨千嬅 - 野孩子.ogg",
			poster: "../../img/singers/yqh.jpg"
		},
		{
			id: 19,
			title: "再见二丁目",
			artist: "杨千嬅 ",
			mp3: "../../杨千嬅 - 再见二丁目.mp3",
			oga: "../../杨千嬅 - 再见二丁目.ogg",
			poster: "../../img/singers/yqh.jpg"
		},

	]
	// 排行榜中的数据
	var popularData = [{ id: 1, img: "../../img/singers/1.jpg", category: "国内排行", songs: catogerySongs1, },
			{ id: 2, img: "../../img/singers/2.jpg", category: "日韩排行", songs: catogerySongs2, },
			{ id: 3, img: "../../img/singers/3.jpg", category: "欧美排行", songs: catogerySongs3 },
		];
	// 歌手页中用于保存歌手列表
	var singListData = [{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
		{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
		{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
		{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
		{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
		{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
		{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },
		{ id: 7, artist: "Cnatan", img: "../../img/singers/2.jpg" },
		{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
	];
	//---------------------------------------------数组=[]------------------------------------------------------------------------------
	
	// 用于某位歌手的信息和歌曲
	var singerAndSongs = {
		id: 1,
		artist: "杨千嬅",
		poster: "../../img/singers/yqh.jpg",
		description: "杨千嬅，原名杨泽嬅，1974年2月3日出生于中国香港，中国香港女歌手、演员。1995年参加第14届TVB8全球华人新秀歌唱大赛获得季军而入行。2000年以《少女的祈祷》一曲横扫香港乐坛四台颁奖典礼多个金曲奖项。2002年、2008年与2009年三度夺得十大劲歌金曲最受欢迎女歌星。2013年凭借《春娇与志明》夺得第32届香港电影金像奖最佳女主角，2014年主演电影《五个小孩的校长》，同年推出国语单曲《色惑》。2010年凭电影《抱抱俏佳人》获得香港电影评论学会大奖最佳女主角。 同年，也凭《志明与春娇》获香港电影金像奖提名最佳女主角，[3]由此成为继梅艳芳之后第二位获得香港乐坛与影坛标志性大奖的女艺人。参演电影《完美嫁衣》[4]，影片中杨千嬅扮演一个在婚礼上被未婚夫抛弃的准新娘，随后自己成为知名的婚礼策划师 。2013年7月，参演电影《单身男女2》 ，也是十年之后再次和古天乐合作。",
		songs: [{
				id: 20,
				title: "姊妹",
				artist: "杨千嬅",
				mp3: "../../杨千嬅 - 姊妹.mp3",
				oga: "../../杨千嬅 - 姊妹.ogg",
				poster: "../../img/singers/yqh.jpg"
			},
			{
				id: 21,
				title: "小城大事",
				artist: "杨千嬅",
				mp3: "../../杨千嬅 - 小城大事.mp3",
				oga: "../../杨千嬅 - 小城大事.ogg",
				poster: "../../img/singers/yqh.jpg"
			},
			{
				id: 22,
				title: "野孩子",
				artist: "杨千嬅 ",
				mp3: "../../杨千嬅 - 野孩子.mp3",
				oga: "../../杨千嬅 - 野孩子.ogg",
				poster: "../../img/singers/yqh.jpg"
			},
			{
				id: 23,
				title: "吻别",
				artist: "张学友 ",
				mp3: "../../英文歌 - 吻别.mp3",
				oga: "../../英文歌 - 吻别.ogg",
				poster: "../../img/singers/yqh.jpg"
			},
		]
	}
	
	// 歌手详情页中的歌曲列表插件对象
	var showPlayList2 = null;
	
	// 播放器的播放列表对象
	var playList;
	
	// jplay播放器
	var myPlaylist = new jPlayerPlaylist({
		jPlayer: "#jquery_jplayer_N",
		cssSelectorAncestor: "#jp_container_N",
		play: function() {
			console.log("播放");
		},
		ended: function() {},

	}, [], {
		playlistOptions: {
			enableRemoveControls: true,

		},
		swfPath: "../dist/jplayer",
		supplied: "webmv, ogv, m4v, oga, mp3",
		useStateClassSkin: true,
		autoBlur: false,
		smoothPlayBar: true,
		keyEnabled: true,
		audioFullScreen: true,
		play: function() {
			console.log("單錢", myPlaylist.current);
			if(playList) {
				playList.playOne(null, myPlaylist.current);
			}

		},
		pause: function() {
			if(playList) {
				playList.pause(null, myPlaylist.current);
			}
		}
	});

	// 自定义播放列表
	playList = $("#customPlayListItems").customPlayList({
		data: musicSrcData,
		playTool: myPlaylist,
	});


	// --------------------------------------歌曲列表1：这是供用户选择添加到播放列表中进行播放的----------------------------
	var showPlayList = $("#showPlayList").customShowList({
		data: addMusicSrcData,
		addOne: function(data) {
			playList.addOne(data);
		},
		play: function(data) {
			playList.playOne(data.id);
		},
		showDetail: function(data) {
			console.log(data);
		}
	});

	// 这是歌曲列表1中的“批量添加”按钮：批量添加到播放列表
	$(".mul-add").click(function() {
		playList.mulAdd(showPlayList.checkedData);
	});

	// 这是歌曲列表1中的“批量播放”按钮：批量添加播放
	$("#songs .mul-play").click(function() {
		playList.mulPlay(showPlayList.checkedData);
	});

	// 播放器中的播放列表“批量删除”按钮
	$(".mul-delete").click(function() {
		playList.removeAll(null);
	});

	var $singerListContainer = $("#album");
	var $singerDetailContainer = $("#singer-detail");
	$singerDetailContainer.slideUp(function() {

	})
	//----------------------------------------------------------------------------------------------

	//-------------------------------------------歌手列表-------------------------------------------------------------------------------------------------
	// 获取歌手的数据
	var $singerList = $(".singerGrid").singerList({
		data: singListData,
		loadCompleted: function(singerId) {
			// ajax 请求某位歌手的数据,样例以下：取消注释之后，需要将ajax语句后面的4行代码放在ajax的success函数的if语句里面
			// 请求需要传过去的参数是singerId
//			$.ajax({
//				url: "",
//				type: "",
//				success: function(data) {
//					// data的数据结构跟singerAndSongs 是一样的
//					singerAndSongs = data;
//					if(singerAndSongs) {
//						pushDataIntoDom(singerAndSongs);
//						$singerListContainer.slideUp(function() {
//							$singerDetailContainer.slideDown();
//						});
//					}
//				},
//			});
			pushDataIntoDom(singerAndSongs);
			$singerListContainer.slideUp(function() {
				$singerDetailContainer.slideDown();
			});

		}
	});
	// 歌手页：返回歌手列表
	$(".backList").click(function() {
		$singerDetailContainer.slideUp(function() {
			$singerListContainer.slideDown();
			$singerListContainer.css({ height: 'auto' });
		});
	});
	
	// 歌手页，点击进行歌手分类的label获取对应类型的歌手
	$("#album .classifyBar a").click(function() {
		var id = $(this).attr("id");
		var data = [];
		// ajax请求，获取对应分类的歌手，上面的id代表的是歌手的分类ID，我已经定好了每种分类的ID，1：大陆，2：港台，3：日韩：4欧美
		// 请求需要带过去的参数是分类的id：id
		// 获取到数据之后，赋给data变量，然后可以删除switch(id) 语句，然后将switch语句后面的那行代码放在ajax的success回调函数中
		// 在下面获取对应的分类id
		switch(id) {
			case "1":
				
				data = [
					{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },
					{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
					{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
					{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
					{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
					{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
					{ id: 7, artist: "Cnatan", img: "../../img/singers/2.jpg" },
					{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
					{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
				];
				break;
			case "2":
				data = [
					{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
					{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
					{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },
					{ id: 7, artist: "Cnatan", img: "../../img/singers/2.jpg" },
					{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
					{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
					{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
					{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
					{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
				];
				break;
			case "3":
				data = [{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
					{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
					{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
					{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
					{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
					{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
					{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },
					{ id: 7, artist: "Cnatan", img: "../../img/singers/2.jpg" },
					{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
				];
				break;
			case "4":
				data = [{ id: 7, artist: "Cnatan", img: "../../img/singers/2.jpg" },
					{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
					{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
					{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
					{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
					{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
					{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
					{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
					{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },

				];
				break;
		}

		
		$singerList.resetList(data);

	});
	//----------------------------------------------

	// --------------------------------------------排行榜页：获取排行榜的数据---------------------------------------------------------
	$(".tm-3-col-container").popularItem({
		data: popularData,
		playCall: function(data) { // 点击播放进行播放
			playList.mulPlay(data);
		}
	});

	// 选择分类歌曲时
	$(".album-item-col").click(function() {
		var cato_id = $(this).attr("id");
		// ajax请求，分类的歌曲，请求带过去的参数是分类的ID
		// ajax请求之后在success方法中调用以下的代码，将请求到的参数赋给showPlayList.resetList的方法。
		showPlayList.resetList(catogerySongs1);
	});

	$("#jquery_jplayer_N")[0].style.height = "300px";
	$("#jquery_jplayer_N").find("img")[0].style.height = "100%";

	//--------------------------------------------------分页插件------------------------------------
	var $songPage = $("#song-page").pagination({
		currentPage: 4, // 当前页数
		totalPage: 16, // 总页数
		isShow: true, // 是否显示首尾页
		count: 6, // 显示个数
		homePageText: "首页", // 首页文本
		endPageText: "尾页", // 尾页文本
		prevPageText: "上一页", // 上一页文本
		nextPageText: "下一页", // 下一页文本
		callback: function(current) {
			// 回调,current(当前页数)
			// ajax请求获取歌曲页，第current页的数据，
			// 请求需要传过去的参数:current
			// 然后在ajax的success方法中调用playList.resetList(data)，data是ajax请求到的数据
			
		}
	});
	var $singerSongPage = $("#singer-song-page").pagination({
		currentPage: 4, // 当前页数
		totalPage: 16, // 总页数
		isShow: true, // 是否显示首尾页
		count: 6, // 显示个数
		homePageText: "首页", // 首页文本
		endPageText: "尾页", // 尾页文本
		prevPageText: "上一页", // 上一页文本
		nextPageText: "下一页", // 下一页文本
		callback: function(current) {
			// 回调,current(当前页数)
			// ajax请求获取歌曲页，第current页的数据，
			// 歌手的id可以$(".tm-text-title").attr("id")来获取
			// 请求需要传过去的参数是歌手的ID和页码数
			// 然后在ajax的success方法中调用showPlayList2.resetList(data)，data是ajax请求到的数据
		}
	});
	var $singerPage = $("#singerPage").pagination({
		currentPage: 4, // 当前页数
		totalPage: 16, // 总页数
		isShow: true, // 是否显示首尾页
		count: 6, // 显示个数
		homePageText: "首页", // 首页文本
		endPageText: "尾页", // 尾页文本
		prevPageText: "上一页", // 上一页文本
		nextPageText: "下一页", // 下一页文本
		callback: function(current) {
			// 回调,current(当前页数)
		},
	});
	//------------------------------------------------------设置歌手详情页------------------------------------------------------------------------------
	var $dot = setDotdot();

	function pushDataIntoDom(data) {
		var after = "<a href='javascript:void(0)' class='readmore'>更多</a>";
		var $container = $("#singer-detail");
		$container.find("#poster").attr("src", data.poster);
		$container.find(".songs-num").text("一共" + data.songs.length + "首歌曲");
		$container.find(".tm-text-title").attr("id",data.id).text(data.artist);
		$container.find("#dot").html(data.description + after);
		$dot.trigger("update.dot");
		$dot.trigger("click");
		// 这个是具体某个歌手的歌曲列表
		if(showPlayList2){
			showPlayList2.resetList(data.songs);
		}else{
			showPlayList2 = $container.find("#showPlayList").customShowList({
			data: data.songs,
			addOne: function(data) {
				playList.addOne(data);
			},
			play: function(data) {
				playList.playOne(data.id);
			},
			showDetail: function(data) {
				console.log(data);
			}
		});
		}
		

		// 这个是具体某个歌手的歌曲列表：批量添加到播放列表
		$container.find(".mul-add").click(function() {
			playList.mulAdd(showPlayList2.checkedData);
		});

		// 这个是具体某个歌手的歌曲列表：批量添加播放
		$container.find(".mul-play").click(function() {
			playList.mulPlay(showPlayList2.checkedData);
		});

	}
	//----------------------------dotdot--begin-------------------------------

	function setDotdot() {
		var $dot = $('#dot').dotdotdot({
			after: 'a.readmore',
			wrap: 'letter',
			watch: 'window'
		});
		$dot.on('click', function() {
			$dot.toggleClass('opened');
			if($dot.hasClass('opened')) {
				$dot.trigger('destroy.dot');
				$("a.readmore").text('收起');
			} else {
				$("a.readmore").text('更多');
				$dot.dotdotdot({
					after: 'a.readmore',
					wrap: 'letter',
					watch: 'window'
				});
			}
		});
		return $dot;
	}

	// ---------------------------dotdot---end------------------------------------

	$("img#jp_poster_0")[0].style.width = "100%";

	//---------------------------------------------------------------------------------搜索框---------------------------------------------------------
	$("#search-btn").click(function() {
		var selectVal = $("#search-select").val();
		var inputVal = $("#search-input").val();
		if(selectVal && inputVal) {
			/*console.log({ selectVal, inputVal });*/
			switch(selectVal) {
				case "0"://搜 歌曲
					// 进行ajax请求，请求带过去的参数：selectVal(请求的分类),inputVal（输入框中的关键字）
					// 然后在ajax的success回调函数中调用以下两行代码，使用请求到的数据代替以下的addMusicSrcData2
					showPlayList.resetList(addMusicSrcData2);
					$("a[data-no='2']").trigger("click");
					break;
				case "1"://搜歌手
					// 进行ajax请求，请求带过去的参数：selectVal(请求的分类),inputVal（输入框中的关键字）
					// 然后在ajax的success回调函数中调用以下两行代码，使用请求到的数据传给$singerList.resetList()方法中
					$singerList.resetList(
						[{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
							{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" }, { id: 7, artist: "Cnatan", img: "img/singers/2.jpg" },
							{ id: 8, artist: "黄家驹", img: "../../img/singers/hjj.jpg" },
							{ id: 0, artist: "陈奕迅", img: "../../img/singers/cyx.jpg" },
							{ id: 1, artist: "Crazy Freso", img: "../../img/singers/1.jpg" },
							{ id: 2, artist: "韩红", img: "../../img/singers/hh.jpg" },
							{ id: 3, artist: "Adele", img: "../../img/singers/adele.jpg" },
							{ id: 4, artist: "王菲", img: "../../img/singers/wf.jpg" },
							{ id: 5, artist: "Lina SANTA", img: "../../img/singers/4.jpg" },
							{ id: 6, artist: "张国荣", img: "../../img/singers/zgr.jpg" },

						]
					);
					$("a[data-no='3']").trigger("click");
					break;
			}
		}
	});

	$(".mul-add").click(function() {
		$(".alert-warning #text").text("批量添加成功");
		addWindow();
	});
	$(".mul-play").click(function() {
		$(".alert-warning #text").text("批量播放成功");
		addWindow();
	});

	// 设置播放器的宽度
	function addWindow() {
		$(".alert-warning").removeClass("no-display");
		setTimeout(function() {
			$(".alert-warning").animate({ top: "0" }, "slow", function() {
				$(".alert-warning").addClass("no-display").css("top", "400px");
			});
		}, 600);
	}

	// 设置播放器的图标
	//var slideFlag = true;
	var slideLength = 0;
	var slideOp = 1;

	$(".nav-item").click(function() {

		$("#jquery_jplayer_N")[0].style.width = "90%";
		$("#jquery_jplayer_N")[0].style.height = $("#jquery_jplayer_N").width();
		$("#jquery_jplayer_N").width($("#jquery_jplayer_N").height());
		console.log($("#jquery_jplayer_N").width(), $("#jquery_jplayer_N").height());
		slideLength = $("#jslideLengthquery_jplayer_N").width() - $("#jp-type-playlist").width() - 5;
		window.setInterval(function() {
			slideLength = slideLength + slideOp * 1;
			$("#jquery_jplayer_N").css({ left: slideLength });
			if(slideLength + $("#jquery_jplayer_N").width() >= $(".jp-gui").width()) {
				slideOp = -1;
			}
			if(slideLength <= 0) {
				slideOp = 1;
			}

		}, 50);
	});
	//-------------------------------------------通知框---------------------------------
	var top = 0;
	var left = 0;
	var op = 1;
	var notifyFn = function() {
		top = op * 1 + top;
		left = op * 2 + left;
		$("#notification").css({ top: top, left: left });
		if((left + $("#notification").width()) >= $(window).width()) {
			op = -1;
			console.log();
		}
		if(left <= 0) {
			op = 1
		}
	}
	var intrv = setInterval(notifyFn, 100);
	$("#notification").hover(function() {
		clearInterval(intrv);
	}, function() {
		intrv = setInterval(notifyFn, 100);
	});

	//----------------------------------------通知框-----the end----------------------------
	//-----------------------------------------------------------登录注册-----------------------------
	//1、点击退出
	$(".log-out").click(function(e) {
		// 这里进行退出的操作

		// 最后执行logout()函数
		logout();
		e.stopPropagation();
	});
	//2、点击登录
	$("#login-container").click(function() {
		if($(this).hasClass("isLogouted")) {
			// 转到登陆界面，ajax请求到登录见面
			var location_arr = window.location.href.split("/");
			location_arr[location_arr.length - 1] = "login.html";
			window.location.href = location_arr.join("/");
			console.log("地址", location_arr.join("/"));
		}

	});

	function logout() {
		// 退出之后注销父容器的class:isLogined
		$("#login-container").removeClass("isLogined").addClass("isLogouted");
		$("#login-container .user-name").text("请登录");
		$(".login-div img").attr("src", "../../img/cry-face.jpg");
	}

	function login(userName) {
		$("#login-container").addClass("isLogined").removeClass("isLogouted");
		$("#login-container .user-name").text("Hi," + userName);
		$(".login-div img").attr("src", "../../img/login.jpg");
	}
	login("小彩椒");
	//--------------------------------------------------------登录注册--the end-----------------
	
	
		//----------------------------------------------页面一进来首先需要获取的数据-fisrt ajax-----------------------------------------------------------------------------
//	$.ajax({
//		url:"",
//		type:"",
//		success:function(data){
//			// 将数据存到popularData变量中
//			popularData = data;
			// 将后面跟下面相同的代码删除
//			$(".tm-3-col-container").popularItem({
//				data: popularData,
//				playCall: function(data) { // 点击播放进行播放
//					playList.mulPlay(data);
//				}
//			});
//		}
//	});
//	$(".nav-item").click(function(){
//		var page = $(this).find("a").attr("data-no");
//		console.log(page);
//		switch(page){
//			case "2":// 第二页是歌曲页
//				if(addMusicSrcData.length==0){
//					// 进行ajax请求获取歌曲页的数据，是分页获取，默认是获取第一页的数据
//					// 获取数据之后，在ajax的success方法中调用showPlayList.resetList(请求到数据)，
//				}
//				break;
//			case "3":
//				if(singListData.length==0){
//						// 进行ajax请求获取歌曲页的数据，是分页获取，默认是获取第一页的数据
//						// 获取数据之后，在ajax的success方法中调用$singerList.resetList(请求到数据)，
//					}
//				break;
//		}
//	});
	//-------------------------------------------------------------------------------------------------------------------------------
	
	
});
//