package org.ikmiv.idol.sand;

import com.sun.jna.platform.win32.W32Service;
import com.sun.jna.platform.win32.W32ServiceManager;
import com.sun.jna.platform.win32.Winsvc;

public class StartStopService {

	public static void main(String args[]) throws Exception {
		try {
			W32ServiceManager serviceManager = new W32ServiceManager();
			serviceManager.open(Winsvc.SC_MANAGER_ALL_ACCESS);
			System.out.println("Start");
			W32Service service = serviceManager.openService("4game-service", Winsvc.SC_MANAGER_ALL_ACCESS);
			service.startService();
			service.close();
			System.out.println("Success");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
