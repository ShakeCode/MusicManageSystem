package com.icloud.web;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icloud.entity.CommonResult;
import com.icloud.entity.Song;
import com.icloud.service.SongService;

@Scope("prototype") 
@Controller
@RequestMapping("/music")
public class DownLoadController extends BaseController{
	
	@Resource(name="songService")
	private SongService songService;
	
	/** 上传目录*/  
    private static final String downloadFolderName = "music";  
	
	@RequestMapping(value="/download/batch",method=RequestMethod.GET)
	public String AssessTeacherResultDownLoad(String[] ids) throws IOException{
		//存放在本地工程目录
				String curProjectPath = request.getServletContext().getRealPath("/");  
			    String saveDirectoryPath = curProjectPath  + downloadFolderName;  
			    File saveDirectory = new File(saveDirectoryPath); 
//			    String[] ids = {"2","3"};
			  
			    List<String> fileArray = new ArrayList<String>();
	if(ids != null && ids.length < 11){
    	for(int i = 0; i < ids.length; ++ i){
    		Integer idTemp = Integer.valueOf(ids[i]);
    		if(idTemp != null && !("null".equals(idTemp))){
    			Song song = songService.selectSongById(idTemp);
        		String musicName = song.getSongName() + "."+song.getFormat();
        		fileArray.add(musicName);
    		};
    	}
    	int size = fileArray.size();
    	for(int j = 0; j<fileArray.size(); j++){
    		String fileName = fileArray.get(j);
    		 File assessFile = new File(saveDirectoryPath+"\\"+fileName);
			    if(assessFile.exists()){
			    	System.out.println("正在执行下载任务：当前正在下载图片:" +fileName);
				    response.setHeader("content-type", "application/x-msdownload;");
//				    response.setContentType("application/force-download");
				    response.setContentType("application/x-msdownload;");
				    response.setHeader("Content-Disposition", "attachment;filename=" +new String(fileName.getBytes("utf-8"), "ISO8859-1"));
				    BufferedInputStream bf = null;
				    OutputStream fos = null;
				    FileOutputStream  fops = null;
				    try {
						byte[] buffer = new byte[1024*64];
						int length = 0;
						bf = new BufferedInputStream(new FileInputStream(assessFile));
						fos = response.getOutputStream();
						File obFile = new File("D:\\Image\\"+fileName);
						if(!obFile.getParentFile().exists()){
							obFile.getParentFile().mkdirs();
						}
						
						if(!obFile.exists()){
							obFile.createNewFile();
						}
						fops = new FileOutputStream(obFile);
						while((length = bf.read(buffer))!= -1){
							fos.write(buffer, 0, length);
							fops.write(buffer, 0, length);
							fos.flush();
						}
						size --;
						System.out.println("下载完成："+fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						System.out.println("--------------SIZE == "+ size);
						if(size == 0){
							CloseStream(fos);
							CloseStream(bf);
						}
					}	
			    }else{
			    	return "没有该文件";
			    }
		    }    
	}
	    return null;
	}
	
	/**
	 * @param cin
	 */
	public void CloseStream(Closeable cin) {
		if(cin != null){
			try {
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				throw new Exception("没有正确的流");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
