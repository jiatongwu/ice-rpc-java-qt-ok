package cn.xvkang.ice_rpc_demo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.my.demo.Demo.TestService;
import com.zeroc.Ice.Current;
import org.apache.commons.io.IOUtils;



public class TestServiceImpl implements TestService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4316038784886681112L;


	@Override
	public byte[] getData(byte[] bytes, int len, Current current) {
		try {
			System.out.println("服務器收到："+new String(bytes,"UTF-8"));
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			IOUtils.copy(new FileInputStream("/Users/wu/tmp/test.zip"),baos);
			return baos.toByteArray();
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}
}
