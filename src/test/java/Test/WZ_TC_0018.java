package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;

import io.qameta.allure.Description;
import pageibject.AreaPersonal;
import pageibject.Login;
import pageibject.Mensajes;
import pageibject.PosicionGlobal;
import general.Browser;

import general.Final;
import general.Log;
import general.Reporting;



public class WZ_TC_0018 {
	
	@Parameters({ "browserName","userName","password"})
	@Test()
	@Description("Eliminar Favoritos")
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
			
			login.doLoginUsuarioPassword(userName, pass);
			//PENDIENTE
			//posicionGlobal.checkEliminarFavoritos()
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
