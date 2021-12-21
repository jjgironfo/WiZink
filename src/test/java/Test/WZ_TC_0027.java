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
import pageobject.Producto;
import general.Browser;

import general.Final;
import general.Log;
import general.Reporting;
import general.Utilidades;



public class WZ_TC_0027 {
	
	@Parameters({ "browserName","userName","password"})
	@Test(priority = 1, description="Hacer un ingreso")
	@Description("Hacer un ingreso")
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
			Producto producto = new Producto(codeTC);
			
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
			doc = Utilidades.createWordDocument(codeTC + " - " + Final.TC_0027_TXT_0);
			producto.checkProductoOpciones(codeTC, doc);
			producto.hacerIngreso(codeTC);
			Reporting.reportResultOK();

		} catch (Exception e) {
			Log.info(e);
			Reporting.reportResultKO();
		} finally {
			Utilidades.closeWordDocument(doc, codeTC);
			Browser.stopDriver();
			Log.info("Cerramos el navegador");
		}


	}

}
