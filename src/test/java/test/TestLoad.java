package test;

import java.io.IOException;

import com.gifisan.nio.client.TCPConnector;
import com.gifisan.nio.client.FixedSession;
import com.gifisan.nio.common.CloseUtil;
import com.gifisan.nio.common.test.ITest;
import com.gifisan.nio.common.test.ITestHandle;

public class TestLoad {
	
	public static void main(String[] args) throws IOException{
		
		
		TCPConnector connector = ClientUtil.getClientConnector();
		connector.connect();
		final FixedSession session = connector.getClientSession();
		int time = 10000;
		
		ITestHandle.doTest(new ITest() {
			public void test() throws Exception {
				session.request("TestSimpleServlet", "TestSimpleServlet");
			}
		}, time, "TestLoad");
		
		CloseUtil.close(connector);
		
	}
}
