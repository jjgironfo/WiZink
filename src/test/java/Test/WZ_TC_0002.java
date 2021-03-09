package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import io.qameta.allure.Description;
import pageobject.Login;
import general.Browser;

import general.Final;
import general.Log;
import general.Reporting;
import general.Utilidades;



public class WZ_TC_0002 {
	
	@Parameters({ "browserName","userName","password"})
	@Test()
	@Description("Login en wizink")
	
	static void login(@Optional (Final.CHROME) String browserName, @Optional String userName , @Optional  String pass) throws Exception {
		Utilidades utilidades = null;
		WebDriver driver = null;
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
			
			login.doLoginUsuarioPassword(userName,pass, codeTC);
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
