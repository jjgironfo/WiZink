package pageibject;

import static general.Browser.driver;

//import static Com.Funciones.driver;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import general.Browser;
import general.Log;
import general.PropertyControl;
import general.Reporting;

public class Login {

	String testCase;
 //pre
	private By btnAreaCliente = By.xpath("//*[@class='area']");

	// Objetos Login
	private By txtUsuario = By.id("user-userName");
	private By txtPassword = By.id("password");
	private By btnAccesoClientes = By.id("btnLogin");
	
	private By btnPrivacidadLogin = By.id("consent_prompt_submit");
	
	private By enlaceHome = By.id("enlaceHomepage");

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
			
		nombreUsuario = PropertyControl.getLogProperty("usuario_PRE");
		nombreUsuario = PropertyControl.getLogProperty("password_PRE");
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
			
			//Funciones.waitExt(20);
			//if (Browser.checkFieldDisabled(btnAccesoClientes, "Acceso clientes", isDisabled)) {
				
				Browser.clickElementSyncro(txtUsuario);
				Browser.writeTextSyncro(txtUsuario, nombreUsuario);
				Browser.clickElementSyncro(txtPassword);
				Browser.writeTextSyncro(txtPassword, contrasenia);

				Browser.clickElementSyncro(btnAccesoClientes);
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
			System.out.println("Hacemos el logout en la aplicacion");

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
	/**public boolean doRegistro() throws Exception {
		try {
			// Aceptamos PopUp 'TU PRIVACIDAD ES IMPORTANTE PARA NOSOTROS'
			if (ProjectPaths.checkObjeto(btnPrivacidadLogin)) {
				try {
					click(btnPrivacidadLogin);
				} catch (Exception e) {
					System.out.println("No existe el PopUp 'Tu Privacidad es Importante para Nosotros'");
				}
			}

			ProjectPaths.waitExt(1);
			boolean resultado = false;
			
			// Pulsar el bot�n 'Reg�strate Ahora'
			ProjectPaths.sincronizaObjetoClick(btnRegistrateAhora);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Reg�strate Ahora'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Reg�strate Ahora'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en el bot�n "seguir"
			ProjectPaths.sincronizaObjetoSoloClick(radioNIF);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			System.out.println("OK - Se pulsa en el radio 'NIF'");
			
			String Nif = Log.generaNif("1");
			ProjectPaths.sincronizaObjetoEscribe(txtNif, Nif);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			System.out.println("OK - Se escribe el 'NIF'");
			
			String fechaNacimiento = "01/01/1990";
			ProjectPaths.sincronizaObjetoEscribe(txtFechaNacimiento, fechaNacimiento);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la 'Fecha de Nacimiento'", "");
			System.out.println("OK - Se escribe la 'Fecha de Nacimiento'");
			
			ProjectPaths.sincronizaObjetoClick(btnSeguir);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			
	// FALTARIA POR DESARROLLAR A PARTIR DE AQUI
			
			// Rellenar los campos usuario, contrase�a y repetir contrase�a y el campo email. 
			// Hacer click en el check de condiciones en el pop up que se abre. 
			// Introducir el c�digo OTP en el textbox
			
//			Funciones.sincronizaObjetoClick(btnAccesoClientes);
//			resultado = Funciones.checkObjeto(enlaceHome);
			
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				System.out.println("OK - TEXTO OK");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				System.out.println("KO - TEXTO KO");
			}		
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}

	}**/
	
	/**
	 * Metodo para Recordar Usuario en la aplicacion
	 * 
	 * @return
	 * 
	 */
	/**public boolean doRecordarUsuario(String nif, String fecha, String usuario, String password) throws Exception {
		try {
			boolean resultado = false;
			
			// Aceptamos PopUp 'TU PRIVACIDAD ES IMPORTANTE PARA NOSOTROS'
			if (ProjectPaths.checkObjeto(btnPrivacidadLogin)) {
				try {
					click(btnPrivacidadLogin);
				} catch (Exception e) {
					System.out.println("No existe el PopUp 'Tu Privacidad es Importante para Nosotros'");
				}
			}
						
			// Pulsar el link "He olvidado mi usuario"
			ProjectPaths.sincronizaObjetoClick(btnRecordarUsuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'He olvidado mi usuario'", "");
			System.out.println("OK - Se pulsa en el bot�n 'He olvidado mi usuario'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en el bot�n "seguir"
			ProjectPaths.sincronizaObjetoSoloClick(radioNIF);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			System.out.println("OK - Se pulsa en el radio 'NIF'");
			
			ProjectPaths.sincronizaObjetoEscribe(txtNif, nif);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			System.out.println("OK - Se escribe el 'NIF'");
			
			ProjectPaths.sincronizaObjetoEscribe(txtFechaNacimiento, fecha);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la 'Fecha de Nacimiento'", "");
			System.out.println("OK - Se escribe la 'Fecha de Nacimiento'");
			
			ProjectPaths.sincronizaObjetoClick(btnSeguirRecordarUsuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			// Introducir el c�digo OTP en el textbox y pulsamos en continuar
			ProjectPaths.waitExt(2);
			ProjectPaths.checkObjeto(btnSeguirOTPRecordarUsuario);
			introduceCodigoOTP(txtOTPRecordarUsuario, "");
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			System.out.println("OK - Se introduce el OTP");
			ProjectPaths.sincronizaObjetoClick(btnSeguirOTPRecordarUsuario);

			ProjectPaths.sincronizaObjetoEscribe(txtUsuarioRecordarUsuario, usuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el Usuario", "");
			System.out.println("OK - Se introduce el Usuario");
			
			ProjectPaths.sincronizaObjetoEscribe(txtPasswordRecordarUsuario, password);
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el Password", "");
			System.out.println("OK - Se introduce el Password");
			
			ProjectPaths.sincronizaObjetoClick(btnEntrarRecordarUsuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el boton Entrar", "");
			System.out.println("OK - Se pulsa en el boton Entrar");
			
			ProjectPaths.waitExt(2);
			resultado = ProjectPaths.checkObjeto(enlaceHome);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se realiza la funcion 'He olvidado mi usuario'", "");
				System.out.println("OK - Se realiza la funcion 'He olvidado mi usuario'");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "Se realiza la funcion 'He olvidado mi usuario'", "");
				System.out.println("KO - No se realiza la funcion 'He olvidado mi usuario'");
			}		
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - No se realiza la funcion 'He olvidado mi usuario'");
			e.printStackTrace();
			throw new Exception("KO - No se realiza la funcion 'He olvidado mi usuario' " + e.toString());
		}

	}**/
	
	/**
	 * Metodo para Recordar Contrase�a en la aplicacion
	 * 
	 * @return
	 * 
	 */
	/**public boolean doRecordarPassword(String nif, String fecha, String usuario, String password) throws Exception {
		try {
			boolean resultado = false;
			// Aceptamos PopUp 'TU PRIVACIDAD ES IMPORTANTE PARA NOSOTROS'
			if (ProjectPaths.checkObjeto(btnPrivacidadLogin)) {
				try {
					click(btnPrivacidadLogin);
				} catch (Exception e) {
					System.out.println("No existe el PopUp 'Tu Privacidad es Importante para Nosotros'");
				}
			}

			// Pulsar el link "He olvidado mi contase�a"
			ProjectPaths.sincronizaObjetoClick(btnRecordarPassword);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'He olvidado mi contase�a'", "");
			System.out.println("OK - Se pulsa en el bot�n 'He olvidado mi usuario'");
			
			// Introducir el nif y la fecha de nacimiento y pulsar en seguir
			ProjectPaths.sincronizaObjetoSoloClick(radioNIF);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el radio 'NIF'", "");
			System.out.println("OK - Se pulsa en el radio 'NIF'");
			
			ProjectPaths.sincronizaObjetoEscribe(txtNif, nif);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'NIF'", "");
			System.out.println("OK - Se escribe el 'NIF'");
			
			ProjectPaths.sincronizaObjetoEscribe(txtUsuarioRecordarPassword, usuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el 'Usuario'", "");
			System.out.println("OK - Se escribe el 'Usuario'");
			
			ProjectPaths.sincronizaObjetoClick(btnSeguir);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			// Introducimos nueva password y damos a Continuar
			ProjectPaths.sincronizaObjetoEscribe(txtPasswordNuevaRecordarPassword, password);
			ProjectPaths.sincronizaObjetoEscribe(txtPasswordNuevaRepetirRecordarPassword, password);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la Nueva Contrase�a y se repite", "");
			System.out.println("OK - Se escribe la Nueva Contrase�a y se repite");
			
			ProjectPaths.sincronizaObjetoClick(btnSeguir);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			// Introducir el OTP y pulsar continuar
			ProjectPaths.waitExt(2);
			ProjectPaths.checkObjeto(btnSeguir);
			introduceCodigoOTP(txtOTPRecordarUsuario, "");
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			System.out.println("OK - Se introduce el OTP");
			ProjectPaths.sincronizaObjetoClick(btnSeguir);
			
			ProjectPaths.waitExt(2);
			resultado = ProjectPaths.checkObjeto(checkPasswordNueva);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida que se ha realizado la Modificacion del Password", "");
				System.out.println("OK - Se valida que se ha realizado la Modificacion del Password");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida que se ha realizado la Modificacion del Password", "");
				System.out.println("KO - No se valida que se ha realizado la Modificacion del Password");
			}		
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - No se valida que se ha realizado la Modificacion del Password");
			e.printStackTrace();
			throw new Exception("KO - No se valida que se ha realizado la Modificacion del Password " + e.toString());
		}

	}**/
	
	
}
