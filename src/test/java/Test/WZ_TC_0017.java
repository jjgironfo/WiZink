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
import pageobject.PosicionGlobal;
import general.Browser;

import general.Final;
import general.Log;
import general.Reporting;
import general.Utilidades;



public class WZ_TC_0017 {
	
	@Parameters({ "browserName","userName","password"})
	@Test(priority = 1, description="Mostrar Favoritos")
	@Description("Mostrar Favoritos")
	static void login(@Optional (Final.CHROME) String browserName, @Optional String userName , @Optional  String pass) throws Exception {

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
			PosicionGlobal posicionGlobal = new PosicionGlobal();
			
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
			XWPFDocument doc = Utilidades.createWordDocument(codeTC);
			posicionGlobal.checkFavoritos(codeTC, doc);
			Utilidades.closeWordDocument(doc, codeTC);
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
