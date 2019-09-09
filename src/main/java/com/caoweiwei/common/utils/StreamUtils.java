package com.caoweiwei.common.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 
* @author 作者:曹伟伟
* @version 创建时间：2019年9月8日 下午8:50:44
* 类功能说明 
*/
public class StreamUtils {
	/**
	 * 关闭流
	 * @param closeables
	 * @throws IOException 
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	
	/**
	 * 
	 * @param is
	 * @param os
	 * @throws IOException 
	 */
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
		
		byte b[] = new byte[1024];
		while(is.read(b)>0) {
			os.write(b);
		}
		//刷新
		os.flush();
		
	}
}
