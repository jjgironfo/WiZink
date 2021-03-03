package pageobject;

import static general.Browser.driver;

//import static Com.Funciones.driver;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import general.Browser;
import general.Log;
import general.PropertyControl;
import general.Reporting;
import general.Utilidades;

public class Login extends Utilidades{

	String testCase;
	private static String actualEnv = System.getProperty("entorno");
 //pre
	private By btnAreaCliente =  By.id("btnLogin");

	// Objetos Login
	private By txtUsuario = By.id("user-userName");
	private By txtPassword = By.id("password");
	private By btnAccesoClientes = By.id("btnLogin");
	
	private By btnPrivacidadLogin = By.id("consent_prompt_submit");
	
	private By enlaceHome = By.id("enlaceHomepage");
	private By botonCondiciones = By.id("showModal1");
	private By pag3Condiciones = By.xpath("//*[@id='id3_3']/p");
	private By botonSiCondiciones = By.id("acepto1");

	// Check Pantalla Posicion Global
	private By logoWizink = By.id("enlaceHomepage");
	private By nombreCliente = By.xpath("//*[@class='nombre-usuario']");
	private By imagenCliente = By.id("profileImageHeader");
	private By linkAreaPersonal = By.xpath("//*[@class='area-personal']");
	private By fechaHoraAcceso = By.xpath("//*[@class='ultimo-acceso u-font-size-xs']");
	private By btnInicio = By.id("globalPositionHeaderLink");
	private By btnMensajes = By.id("inboxHeaderLink");
	private By btnAyuda = By.id("ayudaHeadLink");
	private By btnNumTarjeta = By.id("MaskUnmaskDataHeaderLinkShow");
	private By btnSalir = By.id("logoutHeaderLink");

	private By txtMisTarjetas = By.xpath("//*[@class='c-card-info']");
	private By btnTarjetas = By.xpath("//*[@class='owl-item active']");
	private By btnContacto = By.id("contactLink");
	private By btnInforLegal = By.id("legalInformationLink");
	
	// Objetos Registro
	private By btnRegistrateAhora = By.id("goToUserRegisterLink");
	
	private By radioNIF = By.id("user-document-nif");
	private By txtNif = By.id("documentNumber");
	private By txtFechaNacimiento = By.id("authorized-date-birth");
	private By btnSeguir = By.id("continue");
	
	
	// Objetos Recordar Usuario
	private By btnRecordarUsuario = By.id("client-access-forgot-user-link");
	private By btnSeguirRecordarUsuario = By.id("continueBtn");
	private By titleRecordarUsuario = By.xpath("//h2[text()='¿Has olvidado tu usuario?']");
	private By btnSeguirOTPRecordarUsuario = By.id("continueBtn");
	
	private By txtOTPRecordarUsuario = By.id("verify-code");
	
	private By txtUsuarioRecordarUsuario = By.id("user-userName");
	private By txtPasswordRecordarUsuario = By.id("password");
	private By btnEntrarRecordarUsuario = By.id("btnLogin");
	
	
	// Objetos Recordar Contrase�a
	private By btnRecordarPassword = By.id("client-access-forgot-password-link");
	private By txtUsuarioRecordarPassword = By.id("alias");
	private By titleRecordarPassword = By.xpath("//h2[text()='Accede a WiZink Online']");
	private By txtPasswordNuevaRecordarPassword = By.id("user-password-create");
	private By txtPasswordNuevaRepetirRecordarPassword = By.id("user-password-repeat");
	
	private By checkPasswordNueva= By.xpath("//h2[text()='�Contrase�a cambiada!']");
	

	// Logout
	private By btnLogout = By.id("logoutHeaderLink");
	
	// Aceptar Cookies
	private By btnAceptarCookie = By.id("cookieButton");
	



	
	
	
	/**
	 * Metodo para realizar login en la aplicacion - Introduciendo Usuario y Password
	 * 
	 * @return
	 * 
	 */
	public void doLoginUsuarioPassword(String nombreUsuario, String contrasenia) throws Exception {
		
			//boolean isDisabled = false;
		
		nombreUsuario = PropertyControl.getLogProperty("usuario_" + actualEnv);
		contrasenia = PropertyControl.getLogProperty("password_" + actualEnv);
		Browser.clickElementSyncro(btnPrivacidadLogin);
		Browser.clickElementSyncro(btnAreaCliente);
			// Aceptamos PopUp 'TU PRIVACIDAD ES IMPORTANTE PARA NOSOTROS'
		//if (Browser.checkFieldDisabled(btnPrivacidadLogin,"login") {
					//try {
				//Browser.clickElementSyncro(btnPrivacidadLogin);
		
		//Browser.clickElementSyncro(btnPrivacidadLogin);
					//} catch (Exception e) {
						//System.out.println("No existe el PopUp 'Tu Privacidad es Importante para Nosotros'");
					//}
				//}
			
			//Browser.waitExt(20);
			//if (Browser.checkFieldDisabled(btnAccesoClientes, "Acceso clientes", isDisabled)) {
				
				Browser.clickElementSyncro(txtUsuario);
				Browser.writeTextSyncro(txtUsuario, nombreUsuario);
				Browser.clickElementSyncro(txtPassword);
				Browser.writeTextSyncro(txtPassword, contrasenia);
				/*
				 * try { this.takeRemoteScreenshot(driver); } catch(Exception e){
				 * e.printStackTrace(); }
				 */
				//Se comprueba si aparece la pantalla de aceptar condiciones
				Browser.clickElementSyncro(btnAccesoClientes);
				//Se comprueba si aparece la pantalla de aceptar condiciones
				//https://wizinkprees/clientes/contrato_login"
				if(Browser.checkObjeto(botonCondiciones)) {
					Browser.clickElementSyncro(botonCondiciones);
					Browser.waitForElementScreen(pag3Condiciones);
					WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"id3_3\"]/p"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", targetElement);
					Browser.clickElementSyncro(botonSiCondiciones);
				}
			//}
			
	}
	
	/**
	 * Metodo para realizar login en la aplicacion - Introduciendo Usuario y Password
	 * 
	 * @return
	 * 
	 */
	public void recordarUsuario() throws Exception {
		
		Browser.clickElementSyncro(btnPrivacidadLogin);
		Browser.clickElementSyncro(btnAreaCliente);
		Browser.clickElementSyncro(btnRecordarUsuario);
		Browser.checkFieldText(titleRecordarUsuario, "¿Has olvidado tu usuario?");
			
			
	}
	public void recordarPassword() throws Exception {
		
		Browser.clickElementSyncro(btnPrivacidadLogin);
		Browser.clickElementSyncro(btnAreaCliente);
		Browser.clickElementSyncro(btnRecordarPassword);
		Browser.checkFieldText(titleRecordarPassword, "Accede a WiZink Online");
			
			
	}
		public void checkLog() throws Exception {
				
				Browser.checkFieldText(enlaceHome, "Home");
				Reporting.reportOK("Se inicia sesión en la aplicación");
			}
	

	/**
	 * Metodo para realizar Logout en la aplicacion
	 * 
	 */
	public void doLogout() throws Exception {

			Browser.clickElementSyncro(btnLogout);
			Reporting.reportOK("Hacemos el logout en la aplicacion");

			Reporting.reportOK("Log out Ok");

	}

	/**
	 * Metodo para validar la pantalla de Posici�n Global
	 * 
	 * @return
	 * 
	 */
	public void checkPantallaPosicionGlobal() throws Exception {

			Browser.waitExt(1);
			boolean resultado = false;

			// Verificamos lo siguiente:
			// Cabecera: Logo wizink (parte superior izquierda) / Nombre cliente / Imagen
			// cliente / Enlace al �rea personal /Fecha y hora del �ltimo acceso / Inicio /
			// Mensajes / Ayuda / N� tarjeta (desenmascararla) / Salir / Banners

			boolean checklogoWizink = (driver.findElements(logoWizink).size() != 0);
			boolean checknombreCliente = (driver.findElements(nombreCliente).size() != 0);
			boolean checkimagenCliente = (driver.findElements(imagenCliente).size() != 0);
			boolean checklinkAreaPersonal = (driver.findElements(linkAreaPersonal).size() != 0);
			boolean checkfechaHoraAcceso = (driver.findElements(fechaHoraAcceso).size() != 0);
			boolean checkbtnInicio = (driver.findElements(btnInicio).size() != 0);
			boolean checkbtnMensajes = (driver.findElements(btnMensajes).size() != 0);
			boolean checkbtnAyuda = (driver.findElements(btnAyuda).size() != 0);
			boolean checkbtnNumTarjeta = (driver.findElements(btnNumTarjeta).size() != 0);
			boolean checkbtnSalir = (driver.findElements(btnSalir).size() != 0);
			boolean checktxtMisTarjetas = (driver.findElements(txtMisTarjetas).size() != 0);
			boolean checkbtnTarjetas = (driver.findElements(btnTarjetas).size() != 0);
			boolean checkbtnContacto = (driver.findElements(btnContacto).size() != 0);
			boolean checkbtnInforLegal = (driver.findElements(btnInforLegal).size() != 0);

			if (checklogoWizink && checknombreCliente && checkimagenCliente && checklinkAreaPersonal
					&& checkfechaHoraAcceso && checkbtnInicio && checkbtnMensajes && checkbtnAyuda && checkbtnNumTarjeta
					&& checkbtnSalir && checktxtMisTarjetas && checkbtnTarjetas && checkbtnContacto && checkbtnInforLegal)
				

				Reporting.reportOK("Estamos en posicion global");
	}

	
	/**
	 * Metodo para realizar Registro en la aplicacion
	 * 
	 * @return
	 * 
	 */
	public boolean doRegistro() throws Exception {
		try {
			// Aceptamos PopUp 'TU PRIVACIDAD ES IMPORTANTE PARA NOSOTROS'
			if (Browser.checkObjeto(btnPrivacidadLogin)) {
				try {
					driver.findElement(btnPrivacidadLogin).click();
				} catch (Exception e) {
					Reporting.reportKO("No existe el PopUp 'Tu Privacidad es Importante para Nosotros'");
				}
			}

			Browser.waitExt(1);
			boolean resultado = false;
			
			// Pulsar el botn 'Regstrate Ahora'
			Browser.clickElementSyncro(btnRegistrateAhora);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Regstrate Ahora'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Regstrate Ahora'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en el botn "seguir"
			Browser.sincronizaObjetoSoloClick(radioNIF);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			Reporting.reportOK("OK - Se pulsa en el radio 'NIF'");
			
			String Nif = Utilidades.generaNif("1");
			Browser.writeTextSyncro(txtNif, Nif);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			Reporting.reportOK("OK - Se escribe el 'NIF'");
			
			String fechaNacimiento = "01/01/1990";
			Browser.writeTextSyncro(txtFechaNacimiento, fechaNacimiento);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la 'Fecha de Nacimiento'", "");
			Reporting.reportOK("OK - Se escribe la 'Fecha de Nacimiento'");
			
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
			
			
	// FALTARIA POR DESARROLLAR A PARTIR DE AQUI
			
			// Rellenar los campos usuario, contrasea y repetir contrasea y el campo email. 
			// Hacer click en el check de condiciones en el pop up que se abre. 
			// Introducir el cdigo OTP en el textbox
			
//			Browser.clickElementSyncro(btnAccesoClientes);
//			resultado = Browser.checkObjeto(enlaceHome);
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO KO");
			}		
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}


	}
	
	/**
	 * Metodo para Recordar Usuario en la aplicacion
	 * 
	 * @return
	 * 
	 */
	public boolean doRecordarUsuario(String nif, String fecha, String usuario, String password) throws Exception {
		try {
			boolean resultado = false;

			// Pulsar el link "He olvidado mi usuario"
			Browser.clickElementSyncro(btnRecordarUsuario);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'He olvidado mi usuario'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'He olvidado mi usuario'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en el botn "seguir"
			Browser.sincronizaObjetoSoloClick(radioNIF);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			Reporting.reportOK("OK - Se pulsa en el radio 'NIF'");
			
			String Nif = Utilidades.generaNif("1");
			
			Browser.writeTextSyncro(txtNif, Nif);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			Reporting.reportOK("OK - Se escribe el 'NIF'");
			
			String fechaNacimiento = "01/01/1990";
			
			Browser.writeTextSyncro(txtFechaNacimiento, fechaNacimiento);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la 'Fecha de Nacimiento'", "");
			Reporting.reportOK("OK - Se escribe la 'Fecha de Nacimiento'");
			
			Browser.clickElementSyncro(btnSeguirRecordarUsuario);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
			
	// FALTARIA POR DESARROLLAR A PARTIR DE AQUI
			
			// Introducir el cdigo OTP en el textbox y pulsamos en continuar
			
			
//			Browser.clickElementSyncro(btnAccesoClientes);
//			resultado = Browser.checkObjeto(enlaceHome);
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO KO");
			}		
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}


	}
	
	/**
	 * Metodo para Recordar Contrase�a en la aplicacion
	 * 
	 * @return
	 * 
	 */
	public boolean doRecordarPassword(String nif, String fecha, String usuario, String password) throws Exception {
		try {
			boolean resultado = false;

			// Pulsar el link "He olvidado mi contasea"
			Browser.clickElementSyncro(btnRecordarPassword);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'He olvidado mi contasea'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'He olvidado mi usuario'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en seguir
			Browser.sincronizaObjetoSoloClick(radioNIF);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			Reporting.reportOK("OK - Se pulsa en el radio 'NIF'");
			
			String Nif = Utilidades.generaNif("1");
			
			Browser.writeTextSyncro(txtNif, Nif);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			Reporting.reportOK("OK - Se escribe el 'NIF'");
			
			//String usuario = "Usuario";
			
			Browser.writeTextSyncro(txtUsuarioRecordarPassword, usuario);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'Usuario'", "");
			Reporting.reportOK("OK - Se escribe el 'Usuario'");
			
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
			
	// FALTARIA POR DESARROLLAR A PARTIR DE AQUI
			
			// Introducir el OTP y pulsar continuar
			// Introducimos nueva password y damos a Continuar
			
			
//			Browser.clickElementSyncro(btnAccesoClientes);
//			resultado = Browser.checkObjeto(enlaceHome);
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO KO");
			}		
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}


	}
	
	
}
