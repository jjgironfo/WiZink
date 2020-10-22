package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import general.Browser;
import general.ProjectPaths;
import general.Reporting;

public class NumeroTarjeta  {

	String testCase;


	// Objetos Numero Tarjeta
	private By btnNumeroTarjeta = By.id("MaskUnmaskDataHeaderLinkShow");
	
	private By checkMostrarNumeroTarjeta = By.xpath("//div[@class='c-congrats']");
	
	private By btnOTPTarjeta = By.id("verify-code");
	private By btnVerDatosTarjeta = By.id("btnContinuar");
	
	

	/**public NumeroTarjeta(WebDriver driver, String testCase) {
		super();
		this.testCase = testCase;
	}**/

	/**
	 * Metodo para Mostrar el Numero de Tarjeta
	 * 
	 * @return
	 * 
	 */
	public boolean mostrarNumeroTarjeta() throws Exception {
		try {
			boolean resultado = false;

			// Pulsar sobre botn "Numero tarjeta" situado en la barra
			Browser.clickElementSyncro(btnNumeroTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Nmero tarjeta'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Nmero tarjeta'");
			
			// Introducir el OTP
			Browser.checkObjeto(btnVerDatosTarjeta);
			Browser.introduceCodigoOTP(btnOTPTarjeta, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			
			// Pulsar en "VER DATOS"
			Browser.clickElementSyncro(btnVerDatosTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Ver Datos'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Ver Datos'");
			
			// Validamos Que se muestra el mensaje Final
			resultado = (Browser.checkObjeto(checkMostrarNumeroTarjeta));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'", "");
				Reporting.reportOK("OK - Se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'", "");
				Reporting.reportKO("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
			e.printStackTrace();
			throw new Exception("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.' " + e.toString());
		}

	}

	

}
