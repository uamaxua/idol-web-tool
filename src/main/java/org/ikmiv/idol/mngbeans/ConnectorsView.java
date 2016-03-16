package org.ikmiv.idol.mngbeans;

import static org.ikmiv.idol.util.ServiceHandlerWS.FILE_CONNECTOR_SERVICE_NAME;
import static org.ikmiv.idol.util.ServiceHandlerWS.HTTP_CONNECTOR_SERVICE_NAME;
import static org.ikmiv.idol.util.ServiceHandlerWS.SAND_BOX_SERVER_IP1;
import static org.ikmiv.idol.util.ServiceHandlerWS.SOCIAL_MEDIA_CONNECTOR_SERVICE_NAME;
import static org.ikmiv.idol.util.ServiceHandlerWS.TWITTER_CONNECTOR_SERVICE_NAME;
import static org.ikmiv.idol.util.ServiceHandlerWS.WEB_CONNECTOR_SERVICE_NAME;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.ikmiv.idol.util.ServiceHandlerWS;

@ManagedBean
@RequestScoped
public class ConnectorsView implements Serializable {

	private static final long serialVersionUID = 2911198522718719119L;
	private String httpConnectorStatus;
	private String webConnectorStatus;
	private String twitterConnectorStatus;
	private String socialMediaConnectorStatus;
	private String fileConnectorStatus;
	private int httpConnectorStatusCode;
	private int webConnectorStatusCode;
	private int twitterConnectorStatusCode;
	private int socialMediaConnectorStatusCode;
	private int fileConnectorStatusCode;

	private ServiceHandlerWS serviceHandlerWSForSandBoxServer1;

	public String getHttpConnectorStatus() {
		return httpConnectorStatus;
	}

	public void setHttpConnectorStatus(String httpConnectorStatus) {
		this.httpConnectorStatus = httpConnectorStatus;
	}

	public String getWebConnectorStatus() {
		return webConnectorStatus;
	}

	public void setWebConnectorStatus(String webConnectorStatus) {
		this.webConnectorStatus = webConnectorStatus;
	}

	public String getTwitterConnectorStatus() {
		return twitterConnectorStatus;
	}

	public void setTwitterConnectorStatus(String twitterConnectorStatus) {
		this.twitterConnectorStatus = twitterConnectorStatus;
	}

	public String getSocialMediaConnectorStatus() {
		return socialMediaConnectorStatus;
	}

	public void setSocialMediaConnectorStatus(String socialMediaConnectorStatus) {
		this.socialMediaConnectorStatus = socialMediaConnectorStatus;
	}

	public String getFileConnectorStatus() {
		return fileConnectorStatus;
	}

	public void setFileConnectorStatus(String fileConnectorStatus) {
		this.fileConnectorStatus = fileConnectorStatus;
	}

	public int getHttpConnectorStatusCode() {
		return httpConnectorStatusCode;
	}

	public void setHttpConnectorStatusCode(int httpConnectorStatusCode) {
		this.httpConnectorStatusCode = httpConnectorStatusCode;
	}

	public int getWebConnectorStatusCode() {
		return webConnectorStatusCode;
	}

	public void setWebConnectorStatusCode(int webConnectorStatusCode) {
		this.webConnectorStatusCode = webConnectorStatusCode;
	}

	public int getTwitterConnectorStatusCode() {
		return twitterConnectorStatusCode;
	}

	public void setTwitterConnectorStatusCode(int twitterConnectorStatusCode) {
		this.twitterConnectorStatusCode = twitterConnectorStatusCode;
	}

	public int getSocialMediaConnectorStatusCode() {
		return socialMediaConnectorStatusCode;
	}

	public void setSocialMediaConnectorStatusCode(int socialMediaConnectorStatusCode) {
		this.socialMediaConnectorStatusCode = socialMediaConnectorStatusCode;
	}

	public int getFileConnectorStatusCode() {
		return fileConnectorStatusCode;
	}

	public void setFileConnectorStatusCode(int fileConnectorStatusCode) {
		this.fileConnectorStatusCode = fileConnectorStatusCode;
	}

	@PostConstruct
	public void init() {
		/*
		 * httpConnectorService = new AciConnector(AciConnector.SERVER_IP,
		 * AciConnector.HTTP_CONNECTOR_SERVICE_PORT); Properties properties =
		 * httpConnectorService.getPropertiesFromAtion("getStatusInfo");
		 * httpConnectorStatus = properties.getProperty("ServiceStatus");
		 * 
		 * serviceHandler = XmlRpc.createClient(ServiceHandler.class,
		 * "serviceHandler", "10.24.1.51", 6754); httpConnectorStatus =
		 * serviceHandler.getServiceStatus("AutonomyHTTPConnector");
		 */
		try {
			serviceHandlerWSForSandBoxServer1 = ServiceHandlerWS.getInstance(SAND_BOX_SERVER_IP1);
			httpConnectorStatusCode = serviceHandlerWSForSandBoxServer1.getServiceStatus(HTTP_CONNECTOR_SERVICE_NAME);
			webConnectorStatusCode = serviceHandlerWSForSandBoxServer1.getServiceStatus(WEB_CONNECTOR_SERVICE_NAME);
			twitterConnectorStatusCode = serviceHandlerWSForSandBoxServer1
					.getServiceStatus(TWITTER_CONNECTOR_SERVICE_NAME);
			socialMediaConnectorStatusCode = serviceHandlerWSForSandBoxServer1
					.getServiceStatus(SOCIAL_MEDIA_CONNECTOR_SERVICE_NAME);
			fileConnectorStatusCode = serviceHandlerWSForSandBoxServer1.getServiceStatus(FILE_CONNECTOR_SERVICE_NAME);

			httpConnectorStatus = getStatusFromCode(httpConnectorStatusCode);
			webConnectorStatus = getStatusFromCode(webConnectorStatusCode);
			twitterConnectorStatus = getStatusFromCode(twitterConnectorStatusCode);
			socialMediaConnectorStatus = getStatusFromCode(socialMediaConnectorStatusCode);
			fileConnectorStatus = getStatusFromCode(fileConnectorStatusCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stopHttpConnector() {
		System.out.println("Stopping...");
		try {
			serviceHandlerWSForSandBoxServer1.stopService(HTTP_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! stop");

	}

	public void startHttpConnector() {
		System.out.println("Starting...");
		try {
			serviceHandlerWSForSandBoxServer1.startService(HTTP_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! start");

	}

	public void stopWebConnector() {
		System.out.println("Stopping...");
		try {
			serviceHandlerWSForSandBoxServer1.stopService(WEB_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! stop");

	}

	public void startWebConnector() {
		System.out.println("Starting...");
		try {
			serviceHandlerWSForSandBoxServer1.startService(WEB_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! start");

	}

	public void stopTwitterConnector() {
		System.out.println("Stopping...");
		try {
			serviceHandlerWSForSandBoxServer1.stopService(TWITTER_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! stop");

	}

	public void startTwitterConnector() {
		System.out.println("Starting...");
		try {
			serviceHandlerWSForSandBoxServer1.startService(TWITTER_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! start");

	}

	public void stopFileConnector() {
		System.out.println("Stopping...");
		try {
			serviceHandlerWSForSandBoxServer1.stopService(FILE_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! stop");

	}

	public void startFileConnector() {
		System.out.println("Starting...");
		try {
			serviceHandlerWSForSandBoxServer1.startService(FILE_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! start");

	}

	public void stopSocialMediaConnector() {
		System.out.println("Stopping...");
		try {
			serviceHandlerWSForSandBoxServer1.stopService(SOCIAL_MEDIA_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! stop");

	}

	public void startSocialMediaConnector() {
		System.out.println("Starting...");
		try {
			serviceHandlerWSForSandBoxServer1.startService(SOCIAL_MEDIA_CONNECTOR_SERVICE_NAME);
		} catch (Exception e) {
			System.out.println("Timeout error");
		}
		System.out.println("Succses!!!!!!! start");

	}

	private String getStatusFromCode(int statusCode) {
		switch (statusCode) {
		case 1:
			return "остановлен";
		case 2:
			return "запускается";
		case 3:
			return "останавливается";
		case 4:
			return "запущен";
		case 5:
			return "возобновлние после паузы";
		case 6:
			return "устоновка на паузу";
		case 7:
			return "на паузе";

		default:
			return "неизвестно";
		}

	}

}
