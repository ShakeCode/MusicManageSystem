package com.icloud.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Announcement {
	private static String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	public static Map<String, Object> get(){
		Map<String, Object> resutl = new HashMap<String, Object>();
		Properties prop = new Properties();
		File file = new File(path+"prop.properties");
		FileInputStream fis = null;
		try {
			//文件不存在就创建
			if(!file.exists()){
				file.createNewFile();
			}
			fis = new FileInputStream(file);
			prop.load(fis);
			resutl.put("title", prop.getProperty("title"));
			resutl.put("content", prop.getProperty("content"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				// 关闭流
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return resutl;
	}
	
	public static boolean set(String title, String content){
		Properties prop = new Properties();
		prop.setProperty("title", title);
		prop.setProperty("content", content);
		File file = new File(path+"prop.properties");
		FileOutputStream fos = null;
		try {
			//文件不存在就创建
			if(!file.exists()){
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			prop.store(fos,"");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				// 关闭流
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
}
