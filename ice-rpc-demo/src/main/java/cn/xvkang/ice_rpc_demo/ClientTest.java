package cn.xvkang.ice_rpc_demo;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

import com.my.demo.Demo.TestServicePrx;
import com.my.demo.Demo.TestServicePrxHelper;

public class ClientTest {
	public static void main(String[] args) {
		  int status = 0;
	        Ice.Communicator ic = null;
	        try {
	            ic = Ice.Util.initialize(args);
	            Ice.ObjectPrx base = ic.stringToProxy("TestService:default -p 10000");
	            
	            TestServicePrx testServicePrx=TestServicePrxHelper.checkedCast(base);
	            
	            if (testServicePrx == null)
	                throw new Error("Invalid proxy");

	            byte[] data = testServicePrx.getData("i am client".getBytes("UTF-8"), 8);
	          //  System.out.println("收到服務器的响应： "+new String(data,"UTF-8"));
	            IOUtils.copy(new ByteArrayInputStream(data),new FileOutputStream("d:\\test2.zip"));
	            
	        } catch (Ice.LocalException e) {
	            e.printStackTrace();
	            status = 1;
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            status = 1;
	        }
	        if (ic != null) {
	            // Clean up
	            //
	            try {
	                ic.destroy();
	            } catch (Exception e) {
	                System.err.println(e.getMessage());
	                status = 1;
	            }
	        }
	        System.exit(status);
	
	}
}
