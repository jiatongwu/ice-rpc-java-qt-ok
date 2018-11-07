package cn.xvkang.ice_rpc_demo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;

import com.my.demo.Demo._TestServiceDisp;

import Ice.Current;

public class TestServiceImpl extends _TestServiceDisp{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4316038784886681112L;

	@Override
	public byte[] getData(byte[] bytes, int len, Current __current) {
		try {
			System.out.println("服務器收到："+new String(bytes,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			IOUtils.copy(new FileInputStream("d:\\test.zip"),baos); 
					return baos.toByteArray();
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	
	
}
