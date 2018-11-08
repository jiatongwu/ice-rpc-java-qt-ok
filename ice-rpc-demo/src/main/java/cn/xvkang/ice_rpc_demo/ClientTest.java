package cn.xvkang.ice_rpc_demo;

import java.io.*;

import com.my.demo.Demo.TestServicePrx;
import org.apache.commons.io.IOUtils;



public class ClientTest {
	public static void main(String[] args) {
		try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
		{
			com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("TestService:default -p 10000");
			TestServicePrx testServicePrx = TestServicePrx.checkedCast(base);
			if(testServicePrx == null)
			{
				throw new Error("Invalid proxy");
			}
			byte[] data = testServicePrx.getData("i am client".getBytes("UTF-8"), 8);
			//  System.out.println("收到服務器的响应： "+new String(data,"UTF-8"));
			IOUtils.copy(new ByteArrayInputStream(data),new FileOutputStream("/Users/wu/tmp/test2.zip"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
}
