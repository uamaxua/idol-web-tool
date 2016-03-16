package org.ikmiv.idol.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import com.autonomy.aci.client.services.AciService;
import com.autonomy.aci.client.services.impl.AciServiceImpl;
import com.autonomy.aci.client.services.impl.ByteArrayProcessor;
import com.autonomy.aci.client.services.impl.DocumentProcessor;
import com.autonomy.aci.client.transport.AciServerDetails;
import com.autonomy.aci.client.transport.impl.AciHttpClientImpl;
import com.autonomy.aci.client.util.AciParameters;

public class AciConnector {

	public static final String SERVER_IP = "10.24.1.52";
	public static final int CFS_ACI_PORT = 7000;
	public static final int CFS_SERVICE_PORT = 40300;
	public static final int IDOL_ACI_PORT = 9000;
	public static final int CFS_INDEX_PORT = 9001;
	public static final int IDOL_SERVICE_PORT = 9002;
	public static final int HTTP_CONNECTOR_ACI_PORT = 5678;
	public static final int HTTP_CONNECTOR_SERVICE_PORT = 5432;

	private AciService aciService;

	public AciConnector(String host, int port) {
		super();
		this.aciService = new AciServiceImpl(new AciHttpClientImpl(new DefaultHttpClient()),
				new AciServerDetails(host, port));

	}

	// Send the action and process the response into a DOM Document...
	public Document getXmlDocument(String actionName) {
		return aciService.executeAction(new AciParameters(actionName), new DocumentProcessor());

	}

	public Properties getPropertiesFromAtion(String actionName) throws IOException {
		byte[] text = this.aciService.executeAction(new AciParameters(actionName), new ByteArrayProcessor());
		InputStream is = new ByteArrayInputStream(text);
		Properties properties = new Properties();
		properties.load(is);
		return properties;
	}

	public String getElementByXpath(Document xmlDoc, String path) {
		String element;
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			element = (String) xpath.evaluate(path, xmlDoc, XPathConstants.STRING);
		} catch (XPathExpressionException xpe) {
			xpe.printStackTrace();
			return "IdolOEMTunnel - getversion: Error Occurred - not a valid XML autnresponse";
		} catch (Exception e) {
			e.printStackTrace();
			return "IdolOEMTunnel - getversion: unexpected Error Occurred";
		}
		return element;
	}

}
