package org.ikmiv.idol.ws.handlers;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ServiceHandler {
	@WebMethod
	boolean startService(String serviceName);

	@WebMethod
	boolean stopService(String serviceName);

	@WebMethod
	int getServiceStatus(String serviceName);
}
