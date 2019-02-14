(function($) {
	/**
	 * 播放插件
	 * @param {Object} options
	 */
	$.fn.customPlayList = function(options) {
		options = $.extend({
			data: [],
			stopCall: function() {},
			playCall: function() {},
			playTool: null,
		}, options);
		var _index = 0;
		var _this = this;
		var $first = itemLike();
		var playTool = options.playTool;
		_this.currentPlay = null;
		_this.playList = [];
		_this.checkeData = [];
		//-----set event
		// 添加到播放列表
		_this.addOne = function(data, cal) {
			console.log('addOne');
			addPlayItem(_this, data, cal);
		}
		// 批量添加,不进行不播放
		_this.mulAdd = function(data, cal) {
			mulAdd(data, cal);
		}
		// 批量播放：批量添加,播放新添加的第一条
		_this.mulPlay = function(data, cal) {
			mulAdd(data, cal);
			if(data != null && data.length > 0) {
				playOne(null, _this.playList.length - data.length, playTool);
			}

		}
		// 移除播放列表
		_this.removeOne = function(index, cal) {
			removePlayItem(_this, index, cal);

		}
		// 删除所有列表
		_this.removeAll = function(cal) {
			for(var i=_this.checkeData.length-1; i>=0; i--) {
				removePlayItem(_this, _this.checkeData[i], cal);
			}
			$(_this).parents('table').find('input#checkAll')[0].checked = false;

		}
		// 播放哪一条
		_this.playOne = function(index, noPlay, cal) {
			playOne(index, noPlay, cal);
		}
		// 暂停/停止
		_this.pause = function(_indx, playIndex, cal) {
			pause(_indx, playIndex, cal);
		}

		return this.each(function() {
			_this.append($first);
			setPlayActionForItem(_this, options.playCall, options.stopCall);
			setRemoveActionForItem();
			for(var i = 0; i < options.data.length; i++) {
				addPlayItem(_this, options.data[i]);
			}
			$(this).parents('table').find('#checkAll').click(function() {
				checkAll(this);
			});
		});

		//------------------inner function---------------------
		/**
		 * 列表单条的样子
		 */
		function itemLike() {
			return $("<tr class='no-display'><td><input type='checkbox' name='checkedPlaySong'/></td><td class='play-icon-wrap'><i class='glyphicon play-icon glyphicon-play'></i></td><td class='song-name'></td><td class='singer'></td><td class='delete-icon'><i class='glyphicon glyphicon-trash'></i></td></tr>");
		}

		/**
		 * 播放列表的单条
		 */
		function itemConstructor(data) {
			if(data) {
				var $item = $first.clone(true);
				$item.attr('id', 'playList_' + _index).removeClass('no-display');
				$item.find('.song-name').text(data.title);
				$item.find('.singer').text(data.artist);
				$item.find('i').attr('id', _index);
				$item.find('input')[0].checked = false;
				data.index = _index;
				_index++;
				return $item;
			}
		}

		/**
		 * 设置播放按钮事件
		 * @param {Object} p
		 * @param {Object} playCall
		 * @param {Object} stopCall
		 */
		function setPlayActionForItem(p, playCall, stopCall) {
			var $play = p.find('.play-icon').click(function() {
				var that = this;
				if($(that).hasClass('glyphicon-play')) {

					//					// 暂停之前播放的音乐
					//				$('#customPlayList tr.active').removeClass('active');
					//					$(that).parents('tr').addClass('active');
					//					$('#customPlayList .glyphicon-pause').removeClass('glyphicon-pause').addClass('glyphicon-play');
					// 播放
					_this.currentPlay = $(that).attr('id');
					//					$(that).removeClass('glyphicon-play').addClass('glyphicon-pause');
					playOne(_this.currentPlay, null, playTool);
					if(playCall && (typeof playCall == 'function')) {
						playCall();
					}
				} else if($(that).hasClass('glyphicon-pause')) { // 暂停
					$(that).removeClass('glyphicon-pause').addClass('glyphicon-play');
					playTool.pause();
					if(playCall && (typeof stopCall == 'function')) {
						stopCall();
					}
				}
			});
		}

		function setRemoveActionForItem(cal) {
			$(_this).find('.delete-icon').click(function() {
				var id = $(this).parents('tr').attr('id').replace('playList_', '');
				removePlayItem(_this, id, cal);
			});
			$(_this).find("input[name='checkedPlaySong']").on('click', function() {
				var id = $(this).parents('tr').attr('id').replace('playList_', '');

				if($(this)[0].checked) {
					_this.checkeData.push(id);
				} else {
					_this.checkeData = popItem(_this.checkeData, null, id);
				}

			});

		}

		/**
		 * 添加到播放列表
		 * @param {Object} _this
		 * @param {Object} data
		 * @param {Object} cal
		 * @param {Object} prepend 插入前面
		 */

		function addPlayItem(_this, dataOrigin, cal) {
			// 先克隆数据对象，不在原来的数据对象进行修改
			var data = cloneObj(dataOrigin);
			itemConstructor(data).appendTo($(_this));
			_this.playList.push(data);
			playTool.add(data);
			if(cal && typeof cal == 'function') {
				cal();
			}
		}

		/**
		 * 批量添加
		 * @param {Object} data
		 * @param {Object} cal
		 */
		function mulAdd(data, cal, play) {
			for(var i = 0; i < data.length; i++) {
				addPlayItem(_this, data[i], cal);

			}

		}

		/**
		 * 移除播放列表
		 * @param {Object} _this
		 * @param {Object} index 要删除的元素的_index值
		 * @param {Object} cal
		 */
		function removePlayItem(_this, index, cal) {
			$('#playList_' + index).remove(); // 界面中删除
			var pIndex = getplayIndexBy_index(index);
			_this.playList = pop(_this.playList, pIndex); // 播放列表中删除
			_this.checkeData = popItem(_this.checkeData, null, index);
			playTool.setPlaylist(_this.playList);
			if(playTool.current == pIndex) {
				playTool.current == 0; // 播放器中删除
			}
			if(cal && typeof cal == 'function') {
				cal();
			}
		}

		/**
		 * 播放
		 * @param {data中带有的index} _indx data中带有的index
		 * @param {播放器播放的当条的index} playIndex
		 * @param {播放器} play_tool
		 * @param {Object} playCall
		 */
		function playOne(_indx, playIndex, play_tool, playCall) {
			if(!playIndex && _indx) {
				playIndex = getplayIndexBy_index(_indx);
			}

			if(playIndex && !_indx) {
				_indx = get_indexByPlayIndex(playIndex)
			}
			_this.currentPlay = _indx;
			// 暂停之前播放的音乐
			$('#customPlayList tr.active').removeClass('active');
			$(_this).find("tr:eq(" + (playIndex + 1) + ")").addClass('active');
			$('#customPlayList .glyphicon-pause').removeClass('glyphicon-pause').addClass('glyphicon-play');
			// 播放
			$(_this).find("tr:eq(" + (playIndex + 1) + ")").find('.glyphicon-play').removeClass('glyphicon-play').addClass('glyphicon-pause');
			if(play_tool) {
				play_tool.play(playIndex);
			}

			if(playCall && (typeof playCall == 'function')) {
				playCall();
			}

		}

		/**
		 * 停止播放
		 * @param {Object} id
		 * @param {Object} cal
		 */
		function pause(_indx, playIndex, cal) {
			$(_this).find("tr:eq(" + (playIndex + 1) + ") .glyphicon-pause").removeClass('glyphicon-pause').addClass('glyphicon-play');
			console.log(playTool);
			if(cal && (typeof cal == 'function')) {
				cal();
			}
		}

		/**
		 * 选择所有
		 * @param {Object} target
		 */
		function checkAll(target) {
			var $input = $(target).parents('table').find('input');
			if(target.checked) {
				_this.checkeData=[];
				$input.each(function() {
					this.checked = true;
					var _id = $(this).parents('tr').attr('id');
					if(_id) {
						var id = _id.split('_')[1];
						_this.checkeData.push(id);
					}

				});
			} else {
				$input.each(function() {
					this.checked = false;
				});
				_this.checkeData = [];
			}
		}

		/**
		 * 获取列表下表=index的data._index中
		 * @param {Object} index
		 */
		function get_indexByPlayIndex(index) {
			for(var i = 0; i < _this.playList.length; i++) {
				if(i == index) {
					return _this.playList[i].index;
				}
			}
		}

		/**
		 * 获取列表中的data._index=index的data的下表中
		 * @param {Object} index
		 */
		function getplayIndexBy_index(index) {
			for(var i = 0; i < _this.playList.length; i++) {
				if(_this.playList[i].index == index) {
					return i;
				}
			}
		}
	}

	//-------------------------------------------------------------------------------------------------------------------------
	//*************************************************************************************************************************
	//-------------------------------------------------------------------------------------------------------------------------

	/**
	 * 歌曲列表
	 * @param {Object} options
	 */
	$.fn.customShowList = function(options) {
		options = $.extend({
			data: [],
			showDetail: function(data) {},
			addOne: function(data) {},
			play: function(data) {},
		}, options);
		var _this = this;
		var $tbody = $(this).find('tbody');
		var $template = $("<tr class='no-display'><td><input type='checkbox' name='checkedSong'/></td><td class='songName'></td><td class='action'><i class='add-icon glyphicon glyphicon-plus' data-toggle='tooltip' title='添至播放列表'></i><i class='play-icon glyphicon glyphicon-play' data-toggle='tooltip' title='播放'></i><a><i class='glyphicon glyphicon-download-alt download-icon' data-toggle='tooltip' title='下载'></i></a></td><td class='singer'></td><td class='album'></td><td class='time'></td></tr>");
		_this.checkedData = []; //已将选择的歌曲
		_this.resetList = function(list) { // 重新设定列表
			resetList(list);
		};

		return _this.each(function() {
			$tbody.append($template);
			setEventFormItem();
			var data = options.data;
			for(var i = 0; i < data.length; i++) {
				$tbody.append(getChild(data[i]));
			}
			$tbody.parents('table').find('#checkAll').click(function() {
				checkAll($tbody, this)
			});

		});

		// ----------function
		/**
		 * 构造孩子节点
		 * @param {Object} data 单条歌曲信息对象
		 */
		function getChild(data) {
			var $child = $template.clone(true);
			$child.attr('id', data.id).removeClass('no-display');
			$child.find('input').val(data.id);
			$child.find('.songName').text(data.title);
			$child.find('.singer').text(data.artist);
			$child.find('.album').text(data.album);
			$child.find('.time').text(data.time);
			$child.find('a').attr({ 'href': data.mp3, 'download': data.title });
			return $child;
		}

		/**
		 * 全选
		 * @param {Object} p
		 */
		function checkAll($p, target) {
			var $input = $p.find('input');
			if(target.checked) {
				$input.each(function() {
					this.checked = true;
				});
				_this.checkedData = options.data;
			} else {
				$input.each(function() {
					this.checked = false;
				});
				_this.checkedData = [];
			}
		}

		function setEventFormItem() {
			// 加入播放列表
			$tbody.find('.action i').click(function() {
				var id = $(this).parents('tr').attr('id');
				var data = options.data;
				var checkData = getDataFromListById(data, id);

				if(checkData) {
					if($(this).hasClass('add-icon')) {
						options.addOne(checkData);
					} else if($(this).hasClass('play-icon')) {
						options.addOne(checkData);
						options.play(checkData);
					} else if($(this).hasClass('detail-icon')) {
						options.showDetail(checkData);
					}
				}
			});

			// 查看详情
		}

		/**
		 * 重设显示列表
		 * @param {Object} list
		 */
		function resetList(list) {
			_this.checkedData = [];
			options.data = list;
			$tbody.children().remove();
			var data = options.data;
			for(var i = 0; i < list.length; i++) {
				$tbody.append(getChild(list[i]));
			}
			var $input = $(_this).find('input');
			$input.each(function() {
				this.checked = false;
			});

			setEventFormItem();
		}

	}

	/**
	 * 歌手列表-----------------------------------------------------------------------------------------------
	 * @param {Object} options
	 */
	$.fn.singerList = function(options) {
		options = $.extend(true, {
			data: [],
			//获取某个歌手后的回调函数
			loadCompleted: function(singerId) {}
		}, options);
		var _this = this;
		var tmplt = template();
		_this.resetList = function(data){
			resetList(data);
		}
		return _this.each(function() {

			for(var i = 0; i < options.data.length; i++) {
				var chld = getChild(options.data[i]);
				chld.appendTo($(_this));
			}
			setActionForItem();
		});

		/**
		 * 模板
		 */
		function template() {
			var t = $("<div class='no-display col-sm-3 col-xs-12'><div class='album'><img src='img/singers/3.jpg' class='img-responsive' alt='music theme' /><div class='albumdetail'><h5 class='singerName'>Crazy Freso</h5><a href='#' class='listen' data-toggle='modal' data-target='#albumdetail'><span class='glyphicon glyphicon-headphones'></span> Listen Song</a></div></div></div>");
			return t;
		}

		/**
	   * 创建每个歌手
	   * @param {Object} data
	   * id:1,
			title:"As Long As You Love",
			artist:"Backstreet Boys",
	   */
		function getChild(data) {
			var c = tmplt.clone(true);
			c.removeClass("no-display");
			c.find(".singerName").text(data.artist).attr("id", data.id);
			c.find("a").attr("id", data.id);
			c.find("img").attr("src", data.img);
			return c;
		}

		/**
		 * 点击事件
		 */
		function setActionForItem() {
			$(_this).find("a").click(function() {

				var id = $(this).attr("id");
				if(id) {
					console.log("id", id);
					options.loadCompleted(id);
				}
			});
		}
		
		 /**
		  * 重设歌手列表
		  * @param {Object} data
		  */
		 function resetList(data){
		 	$(_this).children().remove();
		 	for(var i = 0; i < data.length; i++) {
				var chld = getChild(data[i]);
				chld.appendTo($(_this));
			}
			setActionForItem();
		 }
	}

	/**
	 * 流行榜-----------------------------------------------------------------------------------------------
	 * @param {Object} options
	 */
	$.fn.popularItem = function(options) {
		options = $.extend({
			data: [{ id: 1, category: "国内排行", songs: [{ id: 1, title: "匆匆那年", artist: "王菲" }] },
				{},
				{}
			],
			// 点击播放的回调函数，data是要播放的歌曲
			playCall: function(data) {}
		}, options);
		var _this = this;
		var $tmp = templateP();
		_this.each(function() {
			var len = options.data.length > 3 ? 3 : options.data.length;
			for(var i = 0; i < len; i++) {
				$(_this).append(getChild(options.data[i]));
			}
			setActionForItem();
		});

		/**
		 * 父容器模板
		 */
		function templateP() {
			var $parent = $("<div class='no-display col-xs-12 col-sm-6 col-md-4 col-lg-4 tm-3-col-textbox'><div class='text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-3-col-textbox-inner'></div></div>")
			var $part1 = $("<img class='img-cover' src='img/singers/1.jpg'/> ");
			var $part2 = $("<div class='popular-play-icon text-center'><i class='glyphicon glyphicon-play-circle'></i></div>");
			var $part3 = $("<h2 class='tm-text-title'>国内排行榜</h2>");
			var $part4 = $("<div class='popular-item-wrap'></div>");

			$parent.find(".tm-3-col-textbox-inner").append([$part1, $part2, $part3, $part4]);
			return $parent;
		}

		/**
		 * 子模板
		 * @param {Object} data
		 */
		function templateC(data) {
			var $item = $("<div class='popular-item'><p class='tm-text song-name'>我们的爱</p><p class='tm-text song-singer'>李敏镐</p></div>");
			$item.find(".song-name").text(data.title);
			$item.find(".song-singer").text(data.artist);
			return $item;
		}

		/**
		 * 获取子项
		 * @param {Object} data
		 */
		function getChild(data) {
			var $parent = $tmp.clone(true);
			$parent.find("img").attr("src", data.img);
			$parent.removeClass("no-display").attr("id", data.id);
			$parent.find(".tm-text-title").text(data.category);
			var songs = data.songs;
			var len = songs.length > 4 ? 4 : songs.length;
			for(var i = 0; i < len; i++) {
				$parent.find(".popular-item-wrap").append(templateC(songs[i]));
			}
			return $parent;

		}

		function setActionForItem() {
			var $target = $(_this).find(".tm-3-col-textbox");
			$target.click(function() {
				var id = $(this).attr("id");
				if(id) {
					options.playCall(getSongsById(id).songs);
				}
			});
		}

		/**
		 * 根据分类的ID获取该分类的歌曲
		 */
		function getSongsById(id) {
			var songs = options.data;
			for(var i = 0; i < songs.length; i++) {
				if(id == songs[i].id) {
					return songs[i];
				}
			}
		}
	}

	
	//--------------------通用函数--------------------------------
	/**
	 * 根据_index获取某列表中的数据
	 */
	function getDataFromListBy_index(list, _indx) {
		if(!(list && _indx)) {
			return null;
		}
		for(var i = 0; i < list.length; i++) {
			if(list[i]._index == _indx) {
				return list[i];
			}
		}
		return null;
	}

	/**
	 * 删除数组中下标为index一个元素
	 * @param {Object} arr
	 * @param {Object} index
	 */
	function pop(arr, index) {
		var arr2 = [];
		for(var i = 0; i < arr.length; i++) {
			if(i == index) {
				continue;
			}
			arr2.push(arr[i]);
		}
		return arr2;
	}

	/**
	 * 删除数组元素的p_name属性等于p_value的元素
	 * @param {Object} arr 数组元素是object对象
	 * @param {Object} p_name 
	 * @param {Object} p_value
	 */
	function popItem(arr, p_name, p_value) {
		var arr2 = [];
		if(p_name){
			for(var i = 0; i < arr.length; i++) {
				if(arr[i][p_name] == p_value) {
					continue;
				}
				arr2.push(arr[i]);
			}
		}else{
			for(var i = 0; i < arr.length; i++) {
				if(arr[i] == p_value) {
					continue;
				}
				arr2.push(arr[i]);
			}
		}
		
		return arr2;
	}

	/**
	 * 删除数组元素的p_name属性等于p_value的元素
	 * @param {数组} arr 
	 * @param {属性名} p_name 
	 * @param {属性值} p_value
	 */
	function getItem(arr, p_name, p_value) {
		var arr2 = [];
		for(var i = 0; i < arr.length; i++) {
			if(arr[i][p_name] == p_value) {
				return arr[i];
			}

		}

	}

	/**
	 * 复制一个对象
	 * @param {Object} obj
	 */
	function cloneObj(obj) {
		var cObj = {};
		for(var n in obj) {
			cObj[n] = obj[n];
		}
		return cObj;
	}

})(jQuery);