package com.icloud.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.icloud.entity.Album;
import com.icloud.entity.CommonResult;
import com.icloud.entity.Pager;
import com.icloud.entity.Singer;
import com.icloud.entity.Song;
import com.icloud.entity.SongList;
import com.icloud.entity.User;
import com.icloud.service.AlbumService;
import com.icloud.service.SingerService;
import com.icloud.service.SongListService;
import com.icloud.service.SongService;
import com.icloud.service.UserService;

@Controller
@RequestMapping("/song")
public class SongController extends BaseController{

	@Resource(name="songService")
	private SongService songService;
	
	@Resource(name="albumService")
	private AlbumService albumService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="singerService")
	private SingerService singerService;
	
	//TODO:闇�鍚戦〉闈紶閫掞紝鎵�鏈夌殑姝屾洸绫诲瀷
	@RequestMapping("/getAllSong")
	public String getAllSong(Model model){
		String json = new Gson().toJson(songService.getAllSong());
		model.addAttribute("songs",json ); 
		return "songManager";
	}

	//查询排行榜
	@GetMapping("/selectRankingListByType")
	@ResponseBody
	public CommonResult selectRankingListByType(String type) throws UnsupportedEncodingException {
		List<Song> list = null;
		
		try {
			if("1".equals(type)){
				list = songService.selectRankingListByType("大陆");
			}else if("2".equals(type)){
				list = songService.selectRankingListByType("港台");
			}else if("3".equals(type)){
				list = songService.selectRankingListByType("欧美");
			}else if("4".equals(type)){
				list =  songService.selectRankingListByType("日韩");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.returnError(0,"查询失败");
		}
		return CommonResult.returnSuccess(list);
	}
	
	@PostMapping("/List/Add")
	@ResponseBody
	public CommonResult AddToSongList(String[] ids,String username){
	/*	String[] ids,String username*/
		/*String[] ids = {"1","2","4","6"};
				String username = "123456";*/
		try {
			User user = userService.findUserByUserName(username);
			if(user != null && ids != null){
				Integer userId = user.getId();
				for(String id : ids ){
					 Integer songId = Integer.valueOf(id);
					 //判断歌曲是否存在播放列表，存在不添加到播放列表
					 List<SongList> songList = songService.selectSongListByIdAndUserId(songId,userId);
					 if(songList !=null && songList.size()>0){
						 System.out.println("已存在,歌曲id:"+songList.get(0).getSongID());
						 continue;
					 }
					 int i = songService.AddSongListByUserIdAndSongId(userId, songId);
				 }
			}else{
				return CommonResult.returnSuccess(0,"没有选中歌曲");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return CommonResult.returnSuccess(1,"success");
	}
	
	@GetMapping("/List/Delete")
	@ResponseBody
	public CommonResult deleteSongList(String[] ids,String username){
		/*String[] ids = {"1","2","4","6"};
		String username = "123456";*/
		try {
			User user = userService.findUserByUserName(username);
			if(user != null && ids != null){
				Integer userId = user.getId();
				for(String id : ids ){
					 Integer songId = Integer.valueOf(id);
					 Boolean i = songService.deleteSongList(userId, songId);
				 }
			}else{
				return CommonResult.returnError(0,"没有选中歌曲");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return CommonResult.returnSuccess(1,"success");
		
	}
	
	//按照ID查询歌手信息
	@GetMapping(value="/select/singer/id")
	@ResponseBody
	public  CommonResult selectSingerListById(Integer id){
		List<Singer> list = null;
		try {
			list = songService.selectSingerListById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.returnError(0,"查询失败！！");	
		}
		
		if(list != null && list.size()>0){
			return CommonResult.returnSuccess(list);	
		}else{
			return CommonResult.returnError(0,"查询为空");
		}
	}
	
//按照歌名，歌手名，类型查询歌曲
	@PostMapping(value="/selectSongListBySongNameOrSingerOrType")
	@ResponseBody
	public CommonResult selectSongListBySongNameOrSinger(
			@RequestParam(value="songName",required=false)String songName,
			@RequestParam(value="singer",required=false)String singer,
			@RequestParam(value="type",required=false)String type,
			Integer pageIndex,Integer pageSize){
		 List<Song> list= null;
		 Pager pageList= null;
		 Pager  pager = null;
		try {
			if(! StringUtils.isEmpty(songName)){
				list =  songService.selectSongListBySongName(songName);
				return CommonResult.returnSuccess(list);
			}else if(! StringUtils.isEmpty(singer) && pageIndex !=null && pageSize != null){
				pager = songService.selectSongListBySinger(singer, pageIndex, pageSize);
				if(pager != null && pager.getList()!=null &&  pager.getList().size()>0){
					return CommonResult.returnSuccess(pager);	
				}else{
					return CommonResult.returnError(0,"查询为空");
				}
			}else if(! StringUtils.isEmpty(type)){
				if("1".equals(type)){
					pageList =  songService.selectSongListByType("大陆",pageIndex,pageSize);
				}else if("2".equals(type)){
					pageList =  songService.selectSongListByType("港台",pageIndex,pageSize);
				}else if("3".equals(type)){
					pageList =  songService.selectSongListByType("欧美",pageIndex,pageSize);
				}else if("4".equals(type)){
					pageList =  songService.selectSongListByType("日韩",pageIndex,pageSize );
				}
				if(pageList != null && pageList.getList()!=null &&  pageList.getList().size()>0){
					return CommonResult.returnSuccess(pageList);	
				}else{
					return CommonResult.returnError(0,"查询为空");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.returnError(0,"查询失败！！");	
		}
		return CommonResult.returnSuccess(list);
	}
	
	//模糊查询歌手列表
		@PostMapping(value="/select/singer/list")
		@ResponseBody
		public CommonResult selectSingerListByName(
				@RequestParam(value="singerName",required=true)String singerName) {
			List<Singer>  list = null;
			try {
				 list = songService.selectSingerListByName(singerName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return CommonResult.returnError(0,"查询失败！！");	
			}
			if(list != null && list.size()>0){
				return CommonResult.returnSuccess(list);	
			}else{
				return CommonResult.returnError(0,"查询为空");
			}
		}
		
		//查询排行播放列表,分页查询
		@PostMapping("/selectSongListByUserName")
		@ResponseBody
		public CommonResult selectSongListByUserName(String username,Integer pageIndex,Integer pageSize) throws UnsupportedEncodingException {
			 Pager  pager = null;
			try {
				if(!StringUtils.isEmpty(username) && pageIndex !=null && pageSize !=null){
					pager = songService.selectSongListByUserName(username,pageIndex,pageSize);
				}else{
					return CommonResult.returnError(0,"查询失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(pager != null && pager.getList()!=null &&  pager.getList().size()>0){
				return CommonResult.returnSuccess(pager);	
			}else{
				return CommonResult.returnError(0,"查询为空");
			}
			
		}
		
		//根据类型查询歌手列表,分页查询
		@GetMapping(value="/select/singer/list/type")
		@ResponseBody
		public CommonResult  selectSingerListByType(
				@RequestParam(value="type",required=true)String type,Integer pageIndex,Integer pageSize) {
			 Pager  pager = null;
			try {
				if("1".equals(type)){
					pager = songService.selectSingerListByType("大陆",pageIndex,pageSize);
				}else if("2".equals(type)){
					pager = songService.selectSingerListByType("港台",pageIndex,pageSize);
				}else if("3".equals(type)){
					pager =  songService.selectSingerListByType("欧美",pageIndex,pageSize);
				}else if("4".equals(type)){
					pager = songService.selectSingerListByType("日韩",pageIndex,pageSize);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return CommonResult.returnError(0,"查询失败！！");	
			}
			if(pager != null && pager.getList()!=null &&  pager.getList().size()>0){
				return CommonResult.returnSuccess(pager);	
			}else{
				return CommonResult.returnError(0,"查询为空");
			}
		}
		
		@RequestMapping(value ="/add", method = RequestMethod.POST)
		@ResponseBody
		public String addSong(String songName,String singer,String album,String typeName,
				String fileSize,String fileURL,String format,String playTime,String hits,String download){
			HashMap<String, Object> map = new HashMap<String, Object>();
			Song song = new Song(songName, singer, album, typeName, fileSize, fileURL, format, 
					playTime,Integer.parseInt(hits), Integer.parseInt(download));
			int result =0;
			try{
				Singer sin = singerService.getSingerByName(singer);
				if(sin == null){
					map.put("isSuccess", "faile");
					map.put("message", "歌手不存在！");
					String json = new Gson().toJson(map);
					return json;
				}
				result = songService.addSong(song);
				Album album1 = albumService.getAlbumByName(album);
				if(album1 == null){
					albumService.addAlbum(new Album(album, singer, 0, "暂无"));
				}
				
			}catch(Exception e){
				map.put("isSuccess", "faile");
				String json = new Gson().toJson(map);
				return json;
			}	
			//成功执行
			map.put("isSuccess", "success");
			map.put("id", result);
			String json = new Gson().toJson(map);
			return json;
		}
	
	@RequestMapping(value ="/modify/hitsOrDownload", method = RequestMethod.GET)
	@ResponseBody
	public String updateSongHitsOrDownload(Integer id,Integer hits,Integer download){
		Boolean result = null;
		
		if(id != null && hits != null && download == null){
			 result = songService.updateSongHitOrDownLoad(id,hits,null);
		}else if(id != null && download != null && hits == null){
			 result =songService.updateSongHitOrDownLoad(id,null,download);
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		if(result){
			map.put("isSuccess", "success");
			String json = new Gson().toJson(map);
			return json;
		}else{
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteSong(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= songService.delSong(Integer.parseInt(id));
		
		if(result){
			map.put("isSuccess", "success");
			String json = new Gson().toJson(map);
			return json;
		}else{
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}
	}
	
	@RequestMapping(value ="/uploadSong", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String uploadSong(@RequestParam("uploadFile")MultipartFile file) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
            	// 文件保存路径 (项目路径) 
                String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
                int num=t.indexOf(".metadata");
                String path=t.substring(1,num).replace('/', '\\')+"MusicManageSystem\\WebContent\\music\\";
                
                String filePath = path + file.getOriginalFilename();  
                
                File destFile = new File(filePath);
                File parentFile = destFile.getParentFile();
                if(!parentFile.exists()){
                	parentFile.mkdirs();
                }
                if(!destFile.exists()){
                	destFile.createNewFile();
                }
                // 转存文件  
                file.transferTo(destFile);
                
                map.put("isSuccess", "success");
                map.put("fileName", file.getOriginalFilename());
                
                map.put("fileUrl", "../../music/"+file.getOriginalFilename());
                map.put("fileSize", file.getSize());
                map.put("format", file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1));
//                long duration = 0;//音频长度，秒
                MP3File f = (MP3File)AudioFileIO.read(destFile);
                MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
                int a = audioHeader.getTrackLength();
                String playTime = ""+a/60+":"+a%60;
                map.put("playTime", playTime);
//                System.out.println();
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }else{
        	map.put("isSuccess", "faile");
        }
		return new Gson().toJson(map);
	}
}