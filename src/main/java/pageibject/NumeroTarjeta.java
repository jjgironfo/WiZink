package pageibject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import general.ProjectPaths;

public class NumeroTarjeta  {

	String testCase;


	// Objetos Numero Tarjeta
	private By btnNumeroTarjeta = By.id("MaskUnmaskDataHeaderLinkShow");
	
	private By checkMostrarNumeroTarjeta = By.xpath("//div[@class='c-congrats']");
	
	private By btnOTPTarjeta = By.id("verify-code");
	private By btnVerDatosTarjeta = By.id("btnContinuar");
	
	

	/**public NumeroTarjeta(WebDriver driver, String testCase, EgeaCom egea) {
		super(driver);
		this.testCase = testCase;
		this.egea = egea;
	}**/

	/**
	 * Metodo para Mostrar el Numero de Tarjeta
	 * 
	 * @return
	 * 
	 */
/**	public boolean mostrarNumeroTarjeta() throws Exception {
		try {
			boolean resultado = false;

			// Pulsar sobre bot�n "Numero tarjeta" situado en la barra
			click(btnNumeroTarjeta);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'N�mero tarjeta'", "");
			System.out.println("OK - Se pulsa en el bot�n 'N�mero tarjeta'");
			ProjectPaths.waitExt(10);
			
			// Introducir el OTP
			if(isDisplayed(btnVerDatosTarjeta)){
				introduceCodigoOTP(btnOTPTarjeta, "");
				egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
				System.out.println("OK - Se introduce el OTP");
			}

			
			// Pulsar en "VER DATOS"
			click(btnVerDatosTarjeta);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Ver Datos'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Ver Datos'");
			
			// Validamos Que se muestra el mensaje Final
			resultado = isDisplayed(checkMostrarNumeroTarjeta);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.'", "");
				System.out.println("OK - Se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.'");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.'", "");
				System.out.println("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.'");
			}
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.'");
			e.printStackTrace();
			throw new Exception("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeraci�n de tus tarjetas y tus productos de ahorro.' " + e.toString());
		}

	}**/
	

}
