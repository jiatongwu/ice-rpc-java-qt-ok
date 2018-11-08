package cn.xvkang.ice_rpc_demo;


import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.Object;

public class Main {

	public static void main(String[] args) {
		try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
		{
			com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("TestServiceAdapter", "default -p 10000");
			com.zeroc.Ice.Object object = new TestServiceImpl();
			adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("TestService"));
			adapter.activate();
			communicator.waitForShutdown();
		}

	}

}
