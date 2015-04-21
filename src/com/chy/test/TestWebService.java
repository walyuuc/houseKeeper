package com.chy.test;
import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.chy.entity.User;


public class TestWebService {

	public static void main(String[] args) throws Exception {
		EndpointReference targetEPR = new EndpointReference("http://localhost/houseKeeper/services/userService?wsdl");
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		options.setTo(targetEPR);
		QName opGetCpwsList = new QName("http://service.chy.com", "delete");
		Object[] opArgs = new Object[] { 7 };
		Class[] returnTypes = new Class[] { String.class };
		Object[] response = serviceClient.invokeBlocking(opGetCpwsList,opArgs, returnTypes);
		String res=(String) response[0];
		System.out.println(res);
	}
}
