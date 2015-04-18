package com.chy.test;
import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.chy.entity.User;


public class TestWebService {

	public static void main(String[] args) throws Exception {
		EndpointReference targetEPR = new EndpointReference("http://localhost:8080/houseKeeper/services/userService?wsdl");
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		options.setTo(targetEPR);
		QName opGetCpwsList = new QName("http://impl.manager.chy.com", "getById");
		Object[] opArgs = new Object[] { 1 };
		Class[] returnTypes = new Class[] { User.class };
		Object[] response = serviceClient.invokeBlocking(opGetCpwsList,opArgs, returnTypes);
		User user=(User) response[0];
		System.out.println(user.getPassword());
	}
}
