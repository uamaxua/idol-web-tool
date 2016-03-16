package org.ikmiv.idol.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.ikmiv.idol.ws.handlers.ServiceHandler;

public class ServiceHandlerWS {

	public static final String HTTP_CONNECTOR_SERVICE_NAME = "AutonomyHTTPConnector";
	public static final String FILE_CONNECTOR_SERVICE_NAME = "AutonomyFileSystemConnector";
	public static final String SOCIAL_MEDIA_CONNECTOR_SERVICE_NAME = "SocialMediaConnector";
	public static final String WEB_CONNECTOR_SERVICE_NAME = "WebConnector";
	public static final String TWITTER_CONNECTOR_SERVICE_NAME = "TwitterConnector";
	public static final String SAND_BOX_SERVER_IP1 = "10.24.1.51";
	private static final String PORT = "6754";
	private ServiceHandler serviceHandler;
	private static ServiceHandlerWS instance;

	private ServiceHandlerWS(String wsServerIp) {
		try {
			URL url = new URL("http://" + SAND_BOX_SERVER_IP1 + ":" + PORT + "/ws/serviceHandler?wsdl");
			QName qname = new QName("http://impl.handlers.ws.idol.ikmiv.org/", "ServiceHandlerImplService");
			Service service = Service.create(url, qname);
			serviceHandler = service.getPort(ServiceHandler.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static ServiceHandlerWS getInstance(String wsServerIp) {
		if (instance == null) {
			instance = new ServiceHandlerWS(wsServerIp);
		}
		return instance;
	}

	public boolean startService(String serviceName) {
		return serviceHandler.startService(serviceName);
	}

	public boolean stopService(String serviceName) throws Exception {
		return serviceHandler.stopService(serviceName);
	}

	public int getServiceStatus(String serviceName) throws Exception {
		return serviceHandler.getServiceStatus(serviceName);
	}
}
