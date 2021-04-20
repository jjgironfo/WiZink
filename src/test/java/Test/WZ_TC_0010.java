package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Optional;

import io.qameta.allure.Description;
import pageobject.AreaPersonal;
import pageobject.Login;
import pageobject.Mensajes;
import general.Browser;

import general.Final;
import general.Log;
import general.Reporting;
import general.Utilidades;



public class WZ_TC_0010 {
	
	@Parameters({ "browserName","userName","password"})
	@Test(priority = 1, description="Abrir área personal")
	@Description("Abrir área personal")
	static void login(@Optional (Final.CHROME) String browserName, @Optional String userName , @Optional  String pass) throws Exception {

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
			AreaPersonal areaPersonal = new AreaPersonal();
			
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
			
			login.doLoginUsuarioPassword(userName, pass, codeTC);
			doc = Utilidades.createWordDocument(codeTC + " - " + Final.TC_0010_TXT_0);
			areaPersonal.checkAreaPersonal(codeTC, doc);
			Reporting.reportResultOK();

		} catch (Exception e) {
			e.printStackTrace();
			Reporting.reportResultKO();
			Log.info(e);
			
		} finally {
			Utilidades.closeWordDocument(doc, codeTC);
			Browser.stopDriver();
			Log.info("Cerramos el navegador");
		}


	}

}
