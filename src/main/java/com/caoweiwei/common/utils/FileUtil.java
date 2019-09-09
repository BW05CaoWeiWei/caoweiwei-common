package com.caoweiwei.common.utils;

import java.io.File;

import org.apache.log4j.Logger;

/** 
* @author 作者:曹伟伟
* @version 创建时间：2019年9月6日 下午6:50:15
* 类功能说明 
*/
public class FileUtil {
	
	public static Logger log = Logger.getLogger(FileUtil.class); 
	
	/**
	 * 如果是目录，则下面的文件和所有子目录中的文件都要删除
	     使用递归。涉及内容。判断目录的存在性，判断是否为目录或文件，删除。

	 * @param fileName
	 */
	public static void delFilePath(String fileName) {
		
		File file = new File(fileName);
		// 文件不存在  则直接返回
		if(!file.exists()) {
			return;
		}
		
		// 如果是文件  则删除后返回
		if(file.isFile()) {
			log.info(" 删除文件 " + fileName);
			file.delete();
			return;
		}
		
		//如果是目录
		if(file.isDirectory()) {
			// 则列出目录下所有的子目录和文件
			 String[] list = file.list();
			 //针对每一项
			 for (String subPath : list) {
				 //调用删除功能
				 delFilePath(fileName + "/" + subPath);
			}
			 log.info(" ------------ 删除文件 夹 ： " + fileName); 
			file.delete(); 
		}
		
		
	}
	
	//3.5.2获取文件扩展名
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		//没有扩展名
		if(dotIndex<0) {
			return "";
		}
		//最后一位是 .
		if(dotIndex>=fileName.length()) {
			return "";
		}
		//
		return fileName.substring(dotIndex+1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
