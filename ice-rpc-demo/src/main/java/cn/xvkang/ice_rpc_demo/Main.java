package cn.xvkang.ice_rpc_demo;

import Ice.Communicator;
import Ice.ObjectAdapter;
import Ice.Util;

public class Main {

	public static void main(String[] args) {
		//--Ice.MessageSizeMax=102400000
		Communicator communicator=null;

		try {
			communicator = Util.initialize(args);
			
			ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("TestServiceAdapter",
					"default -p 10000");
			Ice.Object object = new TestServiceImpl();
			adapter.add(object, Util.stringToIdentity("TestService"));
			adapter.activate();
			communicator.waitForShutdown();
		} catch (Exception e) {
		} finally {
			communicator.destroy();
		}
	}

}
