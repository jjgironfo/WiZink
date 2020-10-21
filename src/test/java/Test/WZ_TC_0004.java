package Test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import general.Browser;
import general.Final;
import general.Log;
import general.ProjectPaths;
import general.Reporting;
import pageibject.Login;


public class WZ_TC_0004{

	@Parameters({ "browserName" })
	@Test (description = "Recordar Contraseña")
	public static void recuperarUsuario(@Optional(Final.CHROME) String browserName) throws Exception {
		String codeTC = Browser.getActualTC(Thread.currentThread().getStackTrace()[Final.ONE].getClassName());

		try {

			// We launch the Test case
			Reporting.initializeReporting(codeTC);
			Reporting.reportOK("*** EJECUCIÓN PRUEBA: " + codeTC + " ***");

			/**
			 * INITIALIZE THE OBJECTS
			 * 
			 */

			Login login = new Login();
		
			
			/**
			 *  INITIALIZE BROWSER
			*/
			Browser.start();
			
			/**
			 * NAVIGATE TO URL
			 */
			
			Browser.navegar();
			
			/**
			 * Start test
			 */
			
			login.recordarPassword();
			Reporting.reportResultOK();

		} catch (Exception e) {
			Reporting.reportResultKO();
			Log.info(e);
			
		} finally {
			Browser.stopDriver();
			Log.info("Cerramos el navegador");
		}


	}
}
