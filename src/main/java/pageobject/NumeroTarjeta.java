package pageobject;

import static general.Browser.driver;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import general.Browser;
import general.ProjectPaths;
import general.PropertyControl;
import general.Reporting;
import general.Utilidades;

public class NumeroTarjeta extends Utilidades {

	String testCase;
	private static String actualEnv = System.getProperty("entorno");

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
	public boolean mostrarNumeroTarjeta(String codeTC) throws Exception {
		try {
			boolean resultado = false;

			// Pulsar sobre botn "Numero tarjeta" situado en la barra
			Browser.clickElementSyncro(btnNumeroTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Nmero tarjeta'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Nmero tarjeta'");
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			
			// Introducir el OTP
			Browser.checkObjeto(btnVerDatosTarjeta);
			
			Properties datosConfig = PropertyControl.getProperties("config");
			switch (actualEnv) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(btnOTPTarjeta, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(btnOTPTarjeta, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				break;
			}
			
			
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			
			// Pulsar en "VER DATOS"
			Browser.clickElementSyncro(btnVerDatosTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Ver Datos'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Ver Datos'");
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			
			// Validamos Que se muestra el mensaje Final
			resultado = (Browser.checkObjeto(checkMostrarNumeroTarjeta));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'", "");
				Reporting.reportOK("OK - Se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'", "");
				Reporting.reportKO("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.'");
			e.printStackTrace();
			throw new Exception("KO - No se valida el mensaje: 'Ahora puedes ver toda la numeracin de tus tarjetas y tus productos de ahorro.' " + e.toString());
		}

	}

	

}
