package Test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import general.Browser;
import general.Final;
import general.Log;
import general.ProjectPaths;
import general.Reporting;
import general.Utilidades;
import io.qameta.allure.Description;
import pageobject.Login;


public class WZ_TC_0004{

	@Parameters({ "browserName","userName","password" })
	@Test (priority = 1, description="Recordar contraseña")
	@Description("Recordar contraseña")
	public static void recuperarUsuario(@Optional String url, @Optional String nombreUsuario, @Optional String contrasenia) throws Exception {
		String codeTC = Browser.getActualTC(Thread.currentThread().getStackTrace()[Final.ONE].getClassName());
		XWPFDocument doc = null;

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
			
			doc = Utilidades.createWordDocument(codeTC + " - " + Final.TC_0004_TXT_0);
			login.recordarPassword(codeTC, doc);
			Reporting.reportResultOK();

		} catch (Exception e) {
			Reporting.reportResultKO();
			Log.info(e);
			
		} finally {
			Utilidades.closeWordDocument(doc, codeTC);
			Browser.stopDriver();
			Log.info("Cerramos el navegador");
		}


	}
}
