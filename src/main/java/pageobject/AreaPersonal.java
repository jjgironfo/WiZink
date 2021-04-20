package pageobject;

import static general.Browser.driver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

import javax.swing.ImageIcon;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.By;

import general.Browser;
import general.Final;
import general.PathControl;
import general.PropertyControl;
import general.Reporting;
import general.Utilidades;


public class AreaPersonal extends Utilidades {

	String testCase;
	private static String actualEnv = System.getProperty("entorno");

	// Objetos Area Personal
	private By btnAreaPersonal = By.id("userDataHeaderLink");
	
	// Check Pantalla Area Personal
	private By txtNombreApellidos = By.xpath("//h4[text()='Nombre y apellidos']");
	private By txtNIF = By.xpath("//h4[text()='NIF']");
	private By txtNIE = By.xpath("//h4[text()='NIE']");
	private By txtFechaNacimiento = By.xpath("//h4[text()='Fecha de nacimiento']");
	private By fotoPerfil = By.id("imgProfileCustomerData");
	private By direccion = By.xpath("//h4[text()='Dirección']");
	private By email = By.xpath("//h4[text()='Email']");
	private By telefono = By.xpath("//h4[text()='Nombre y apellidos']");
	private By telefonoField = By.id("phone");
	private By btnCambiarMiUsuario = By.id("cambiarUsername");
	private By btnCambiarMiPassword = By.id("cambiarContrasena");
	private By btnActualizarDocumentoIdentidad = By.xpath("//a[text()='ACTUALIZAR DOCUMENTO DE IDENTIDAD']");
	private By btnCambiarDatosAreaPersonal = By.id("personalDataChangeLink");
	private By btnCambiarDatoFoto = By.id("changePhoto");
	private By btnCambiarDatoDemografico = By.id("demographicDataChangeLink");
	
	
	
	
	// Cambiar Datos Personales
	private By txtOTPDatosPersonales = By.id("verify-code");
	private By btnSeguirDatosPersonales = By.id("continueButton");
	
	//private By txtTelefonoDatosPersonales = By.id("phone");
	private By txtDireccionDatosPersonales = By.id("direccion");
	private By txtNombreDatosPersonales = By.id("name");
	
	private By btnSeleccionardni = By.id("selectFileBtn");
	
	private By checkCambiarDatosPersonales = By.xpath("//div[@class='c-congrats']");
	
	
	// Cambiar Usuario
	private By txtUsuarioCambiarUsuario = By.id("alias");
	private By txtPasswordCambiarUsuario = By.id("password");
	private By checkcambioUsuario = By.xpath("//p[text()='Has cambiado tu usuario de acceso.']");
	private By volverInicio = By.id("gotoUserData");
	
	//Cambiar datos direccion
	private By txtNombreVia = By.id("direccion");
	private By checkCambiarDireccion = By.xpath("//*[contains(text(),'Por mantener actualizados tus datos de contacto.')]");
	
	// Cambiar Imagen Perfil
	private By btnImagenCambioFoto = By.id("profile");
	private By btnGuardarCambiosImagenCambioFoto = By.xpath("//button[text()='Guardar cambios']");
	private By btnVolverImagenCambioFoto = By.xpath("//a[text()='Volver']");
	
	private By btnEliminarImagenCambioFoto = By.id("delete");
	
	// Cambiar Mi Contrase�a
	private By txtPassActualMiPass = By.id("user-password-old");
	private By txtPassCrea1MiPass = By.id("user-password-create");
	private By txtPassCrea2MiPass = By.id("user-password-repeat");
	private By btnGuardarCambiosMiPass = By.id("continueButton");
	private By checkCambioPass = By.xpath("//p[text()='Has cambiado tu contraseña para acceder a WiZink.']");
	
	// Opciones
//	private By btnDatosPersonales = By.id("customerLink1");
	private By btnDocumentacion = By.id("customerLink3");
//	private By btnDatosPrivacidadMisDatos = By.id("customerLink4");
	
	// Documentacion
	private By checkGenerales = By.xpath("//h4[text()='Generales']");
	private By checkCredito = By.xpath("//h4[text()='Crédito']");
	
	private By btnTerminosYCondicionesGeneral = By.xpath("//a/p[contains(text(),'Marketplace')]");
	private By btnContratoMulticanal = By.xpath("//a/p[text()='OLB - Contrato Multicanal']");
	
	

	/**
	 * Metodo para Validar el Area Personal
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public void checkAreaPersonal(String codeTC, XWPFDocument doc) throws Exception {

				Utilidades.addTextToDocument(doc, Final.TC_0010_TXT_1);
				
				boolean isDisabled = true;
				boolean NIF = false;
				boolean NIE = false;

				Browser.waitExt(5);
				
				Browser.waitForElementScreen(btnAreaPersonal);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				Browser.clickElementSyncro(btnAreaPersonal);
				
				Reporting.reportOK("OK - Se pulsa en el botón 'Área Personal'");

				// 1.3 Se pulsa Ir a Área Personal y se visualizan los datos personales, demográficos,
				// foto de perfil y opciones de cambiar estos, el usuario y la contraseña.
				Browser.waitForElementScreen(btnCambiarMiUsuario);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
				Browser.checkFieldText(btnCambiarMiUsuario, "Cambiar mi usuario");
				
				// Validamos la pantalla de �rea Personal
				Browser.checkFieldText(txtNombreApellidos,"Nombre y apellidos");
				NIF = Browser.isElementDisplayed(txtNIF);
				NIE = Browser.isElementDisplayed(txtNIE);
				if (NIF) {
					Browser.checkFieldText(txtNIF, "NIF"); 
				} else if (NIE) {
					Browser.checkFieldText(txtNIE, "NIE");
				}
				
				Browser.checkFieldText(txtFechaNacimiento, "Fecha de nacimiento"); 
				Browser.checkFieldText(fotoPerfil,"imgProfileCustomerData");
				Browser.checkFieldText(direccion,"Dirección");
				Browser.checkFieldText(email,"Email");
				Browser.checkFieldText(telefono,"Telófono"); 
				Browser.checkFieldText(btnCambiarMiUsuario,"Cambiar mi usuario");
				Browser.checkFieldText(btnCambiarMiPassword,"Cambiar mi contrase�a");
				//No se valida el botón de actualizar DNI
				//Browser.checkFieldText(btnActualizarDocumentoIdentidad,"ACTUALIZAR DOCUMENTO DE IDENTIDAD");
				Browser.checkFieldText(btnCambiarDatosAreaPersonal,"personalDataChangeLink") ;
				Browser.checkFieldText(btnCambiarDatoFoto,"changePhoto");
				Browser.checkFieldText(btnCambiarDatoDemografico,"demographicDataChangeLink");
				
				// report 
				Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
				Reporting.reportOK("Estamos en el área personal");
			
			


	}
	
	/**
	 * Metodo para Validar la pantalla Documentacion
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public void  checkDocumentacion(String codeTC, XWPFDocument doc) throws Exception{
		
		Utilidades.addTextToDocument(doc, Final.TC_0016_TXT_1);
		
				Browser.waitExt(1);
				
				Browser.waitForElementScreen(btnAreaPersonal);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				Browser.clickElementSyncro(btnAreaPersonal);
				
				Reporting.reportOK("OK - Se pulsa en el botón 'Área Personal'");

				Browser.waitExt(5);
				Browser.waitForElementScreen(btnDocumentacion);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
				Browser.clickElementSyncro(btnDocumentacion);
				
				Reporting.reportOK("OK - Se pulsa en el botón 'Documentacion'");
				
				// 1.4 Se pulsa sobre la opcin Documentación y se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito.
				Browser.waitForElementScreen(btnTerminosYCondicionesGeneral);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
					  e.printStackTrace(); }
				Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
				Browser.checkObjeto(btnTerminosYCondicionesGeneral);
				
				//report
				Reporting.reportOK("Se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crédito");
				
					
				Properties datosConfig = PropertyControl.getProperties("config");
				
				String ruta = "";
				File fichero;
				switch (actualEnv) {
				case "PRE":
					// PRE
					// Borramos antes el fichero si existe y luego descargamos
					ruta = Browser.rutaPath + File.separator + "properties" + File.separator + "Terminos y Condiciones General.pdf";
					fichero = new File(ruta);
					if (fichero.exists()) {
						fichero.delete();
					}
					
					// 1.5	Se pulsa sobre el enlace Contrato multicanal
					//No se comprueba descargar documento ya que pide código OTP
					//Browser.clickElementSyncro(btnTerminosYCondicionesGeneral);
					//report
					//Reporting.reportOK("OK - Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'");
					break;
				case "PRO":
					// PRO
					// Borramos antes el fichero si existe y luego descargamos
					ruta = Browser.rutaPath + File.separator + "properties" + File.separator + "OLB - Contrato Multicanal.pdf";
					fichero = new File(ruta);
					if (fichero.exists()) {
						fichero.delete();
					}
					
					// 1.5	Se pulsa sobre el enlace Contrato multicanal
					//No se comprueba descargar documento ya que pide código OTP
					//Browser.clickElementSyncro(btnTerminosYCondicionesGeneral);
					//Browser.clickElementSyncro(btnContratoMulticanal);
					
					//Report
					//Reporting.reportOK("OK - Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'");
					break;
				default:
					Reporting.reportKO("No se ha indicado un entorno valido");
					break;
				}

				// Esperamos a que se descargue el Fichero PDF
				Browser.waitExt(20);
				
				// Validamos que se ha descargado el Fichero PDF
				fichero = new File(ruta);
				

				
			


	}

	
	/**
	 * Metodo para Validar el Area Personal
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public void cambiarFotoPerfilAreaPersonal(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0013_TXT_1);
		
			boolean isDisabled = true;

			// 1.3 Se pulsa Ir a Área Personal
			Browser.waitForElementScreen(btnAreaPersonal);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAreaPersonal);
			Reporting.reportOK("OK - Se pulsa en el botón 'Área Personal'");

			// 1.4 Pulsar sobre el link 'Cambiar' de la Foto de Perfil
			Browser.waitForElementScreen(btnCambiarDatoFoto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnCambiarDatoFoto);
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar' de la Foto de Perfil");

			// 1.5 Pulsar sobre la foto y se muestran las fotos disponibles para seleccionar
			Browser.waitForElementScreen(btnImagenCambioFoto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnImagenCambioFoto);
			
			Reporting.reportOK("OK - Se pulsa sobre la foto y se muestran las fotos disponibles para seleccionar");
			
			// Realizamos la subida del Fichero
			Browser.waitExt(1);
			Reporting.reportOK("Subimos Imagen");
			
			//File file = new File("/Users/cexmobile/git/wizink_testng/IMAGEN.png");
			//StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
			//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Browser.waitExt(1);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			uploadMediaByRobot("IMAGEN.png");

			Browser.waitExt(1);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Reporting.reportOK("Fin Subir Imagen");
			Browser.waitExt(1);
			
			// 1.6 Seleccionar foto y pulsar en ok. La foto seleccionada se muestra como la del perfil
			Browser.waitForElementScreen(btnGuardarCambiosImagenCambioFoto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.waitForElementSyncro(btnGuardarCambiosImagenCambioFoto);
			Browser.scrollNavegadorVertical("ABAJO");
			Browser.clickElementSyncro(btnGuardarCambiosImagenCambioFoto);
			
			Reporting.reportOK("OK - Seleccionar foto y pulsar en ok. La foto seleccionada se muestra como la del perfil");
			
			Browser.waitExt(1);
			Browser.cargarSpinner();
			Browser.waitExt(1);
			
			// Nos volvemos para verificar que se ha incluido el cambio de la Imagen -- Boton Volver
			Browser.waitForElementScreen(btnVolverImagenCambioFoto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.waitForElementSyncro(btnVolverImagenCambioFoto);
			Browser.clickElementSyncro(btnVolverImagenCambioFoto);
			
			Reporting.reportOK("OK - Nos volvemos para verificar que se ha incluido el cambio de la Imagen");
			
			// Validamos que se muestra el boton Eliminar (Significa que se ha incluido anteriormente)
			//Este método no se encuentra en el código antiguo
			//Browser.checkFieldDisabled(btnEliminarImagenCambioFoto, "delete", isDisabled);
						
			// Borramos la Imagen para futuras ejecuciones de la prueba
			Browser.waitForElementScreen(btnEliminarImagenCambioFoto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnEliminarImagenCambioFoto);
			Reporting.reportOK("OK - Eliminamos la Imagen");
			
			//Browser.checkObjetoNoExiste(btnEliminarImagenCambioFoto);
			Reporting.reportOK("OK - El boton Eliminar no existe");
			
			// report 
			Reporting.reportOK("El botón eliminar no existe");
			


	}
	
	/**
	 * Metodo para Validar el Area Personal
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarPasswordPerfilAreaPersonal(String contrasenia, String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0015_TXT_1);
		
		try {
			Browser.waitExt(1);
			boolean resultado = false;

			// 1.3 Se pulsa Ir a rea Personal
			Browser.waitForElementScreen(btnAreaPersonal);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAreaPersonal);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'rea Personal'", "");
			Reporting.reportOK("OK - Se pulsa en el botón 'Área Personal'");

			// 1.4 Pulsar el botn "CAMBIAR MI CONTRASEA"
			Browser.waitExt(1);
			Browser.waitForElementScreen(btnCambiarMiPassword);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnCambiarMiPassword);
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi Contrasea'", "");
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar Mi Contraseña'");

			// 1.5 Introducir la contrasea antigua, y la nueva en los campos contrasea y repetir contrasea
			String password = "";
			Properties datosConfig = PropertyControl.getProperties("config");
			Properties datosLogin = PropertyControl.getProperties("login");

			switch (actualEnv) {
			case "DES":
				password = datosLogin.getProperty("password_DES");
				break;
			case "PRE":
				password = datosLogin.getProperty("password_PRE");
				break;
			case "PRO":
				password = datosLogin.getProperty("password_PRO");
				break;
			default:
				Reporting.reportKO("No se ha indicado un entorno valido");
				break;
			}
			Browser.waitForElementScreen(txtPassActualMiPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.writeTextSyncro(txtPassActualMiPass, password);
			
			Browser.waitForElementScreen(txtPassCrea1MiPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.writeTextSyncro(txtPassCrea1MiPass, password);
			
			Browser.waitForElementScreen(txtPassCrea2MiPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.writeTextSyncro(txtPassCrea2MiPass, password);
			
			// 1.6 Pulsar en el botn "GUARDAR CAMBIOS". Los cambios se guardan de manera correcta
			Browser.waitForElementScreen(btnGuardarCambiosMiPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnGuardarCambiosMiPass);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Guardar Cambios'", "");
			Reporting.reportOK("OK - Se pulsa sobre el link 'Guardar Cambios'");
			
			// Validamos que se guarda la Nueva Contrasea indicada
			Browser.waitForElementScreen(checkCambioPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = (Browser.checkObjeto(checkCambioPass));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se guarda la Nueva Contrasea indicada", "");
				Reporting.reportOK("OK - Validamos que se guarda la Nueva Contrasea indicada");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda la Nueva Contrasea indicada", "");
				Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
			}
			
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
			e.printStackTrace();
			throw new Exception("KO - NO se guarda la Nueva Contrasea indicada " + e.toString());
		}


	}
	
	/**
	 * Metodo para Validar el Area Personal
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarUsuarioPerfilAreaPersonal(String nombreUsuario, String contrasenia, String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0014_TXT_1);
		
		try {
			boolean resultado = false;

			// 1.3 Se pulsa Ir a rea Personal
			Browser.waitForElementScreen(btnAreaPersonal);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAreaPersonal);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'rea Personal'", "");
			Reporting.reportOK("OK - Se pulsa en el botn Área Personal'");

			// 1.4 Pulsar el botn "CAMBIAR MI USUARIO"
			Browser.waitForElementScreen(btnCambiarMiUsuario);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnCambiarMiUsuario);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi usuario'", "");
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar Mi usuario'");
			
			String usuario = "";
			String password = "";
			Properties datosConfig = PropertyControl.getProperties("config");
			Properties datosLogin = PropertyControl.getProperties("login");

			switch (actualEnv) {
			case "DES":
				usuario = datosLogin.getProperty("usuario_DES");
				password = datosLogin.getProperty("password_DES");
				break;
			case "PRE":
				usuario = datosLogin.getProperty("usuario_PRE");
				password = datosLogin.getProperty("password_PRE");
				break;
			case "PRO":
				usuario = datosLogin.getProperty("usuario_PRO");
				password = datosLogin.getProperty("password_PRO");
				break;
			default:
				Reporting.reportKO("No se ha indicado un entorno valido");
				break;
			}

			// 1.5 Introducir el nuevo usuario y la clave actual
						Browser.waitForElementScreen(txtUsuarioCambiarUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.writeTextSyncro(txtUsuarioCambiarUsuario, "digesp066");
						
						Browser.waitForElementScreen(txtPasswordCambiarUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.writeTextSyncro(txtPasswordCambiarUsuario, password);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el nuevo Usuario y contrasea", "");
						Reporting.reportOK("OK - Se escribe el nuevo Usuario y contrasea");
						
						// 1.6 Pulsar en el botn "Seguir". Los cambios se guardan de manera correcta
						Browser.waitForElementScreen(btnSeguirDatosPersonales);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
						Browser.clickElementSyncro(btnSeguirDatosPersonales);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
						Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
						
						// 1.6 Pulsar en el botn "Seguir". Los cambios se guardan de manera correcta
						Browser.waitForElementScreen(volverInicio);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
						Browser.clickElementSyncro(volverInicio);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
						Reporting.reportOK("OK - Se pulsa en el botón 'Volver al inicio'");
				
						// 1.3 Se pulsa Ir a rea Personal para volver al usuario antiguo
						Browser.waitForElementScreen(btnAreaPersonal);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.clickElementSyncro(btnAreaPersonal);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'rea Personal'", "");
						Reporting.reportOK("OK - Se pulsa en el botn 'Área Personal'");

						// 1.4 Pulsar el botn "CAMBIAR MI USUARIO" 
						Browser.waitForElementScreen(btnCambiarMiUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.clickElementSyncro(btnCambiarMiUsuario);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi usuario'", "");
						Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar Mi usuario'");
						
						// 1.5 Introducir el nuevo usuario y la clave actual
						Browser.waitForElementScreen(txtUsuarioCambiarUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.writeTextSyncro(txtUsuarioCambiarUsuario, usuario);
						
						Browser.waitForElementScreen(txtPasswordCambiarUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.writeTextSyncro(txtPasswordCambiarUsuario, password);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el nuevo Usuario y contraseña", "");
						Reporting.reportOK("OK - Se escribe el nuevo Usuario y contrasea");
						
						// 1.6 Pulsar en el botn "Seguir". Los cambios se guardan de manera correcta
						Browser.waitForElementScreen(btnSeguirDatosPersonales);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.clickElementSyncro(btnSeguirDatosPersonales);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
						Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
			
						
						
						// Validamos que se guarda el nuevo usuario
						Browser.waitForElementScreen(checkcambioUsuario);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						resultado = (Browser.checkObjeto(checkcambioUsuario));
						if (resultado) {
							//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se guarda el nuevo Usuario indicado", "");
							Reporting.reportOK("OK - Validamos que se guarda el nuevo Usuario indicado");
						} else {
							//egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda el nuevo Usuario indicado", "");
							Reporting.reportKO("KO - NO se guarda el nuevo Usuario indicadoa");
						}
						
						// 1.6 Pulsar en el botn "Seguir". Los cambios se guardan de manera correcta
						Browser.waitForElementScreen(volverInicio);
						try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
							  e.printStackTrace(); }
						Browser.clickElementSyncro(volverInicio);
						//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
						Reporting.reportOK("OK - Se pulsa en el botón 'Volver al inicio'");
						
						return resultado;

					} catch (Exception e) {
						Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
						e.printStackTrace();
						throw new Exception("KO - NO se guarda la Nueva Contrasea indicada " + e.toString());
					}


	}
	
	public static void uploadMediaByRobot(String fileName) {
	    //File Need to be imported
	    File file = new File(PathControl.getRootPath() + File.separator + fileName);
	    StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
	    //Copy to clipboard
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	    Robot robot = null;
	    try {
	        robot = new Robot();
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }

	    // Cmd + Tab is needed since it launches a Java app and the browser looses focus
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_TAB);
	    robot.delay(500);

	    //Open Goto window
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_SHIFT);
	    robot.keyPress(KeyEvent.VK_G);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_SHIFT);
	    robot.keyRelease(KeyEvent.VK_G);

	    //Paste the clipboard value
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_V);

	    //Press Enter key to close the Goto window and Upload window
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    robot.delay(500);
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Metodo para Cambiar Datos Personales
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarDatosPersonales(String telefono, String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0011_TXT_1);
		
		try {
			boolean resultado = false;
			telefono = PropertyControl.getLogProperty("telefono_" + actualEnv);
			// 1.3 Se pulsa Ir a rea Personal
			Browser.waitExt(5);
			
			Browser.waitForElementScreen(btnAreaPersonal);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAreaPersonal);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'rea Personal'", "");
			Reporting.reportOK("OK - Se pulsa en el botón 'Área Personal'");

			// 1.4 Pulsar el botn Cambiar Datos Personales
			
			Browser.waitForElementScreen(btnCambiarDatoDemografico);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnCambiarDatoDemografico);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Datos Personales'", "");
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar Datos Personales'");

			// Se introduce el otp recibido por sms y se pulsa en seguir
			Browser.waitForElementScreen(btnSeguirDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.checkObjeto(btnSeguirDatosPersonales);
			Properties datosConfig = PropertyControl.getProperties("config");
			switch (actualEnv) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtOTPDatosPersonales, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				Reporting.reportKO("No se ha indicado un entorno valido");
				break;
			}
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			
			// Pulsamos en Seguir
			Browser.waitForElementScreen(btnSeguirDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnSeguirDatosPersonales);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botón 'Seguir'");
			
			// Modificar el telfono y Pulsar en "COMPLETAR"
			
			Browser.waitForElementScreen(telefonoField);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(this.telefonoField);
			Browser.writeTextSyncro(this.telefonoField, telefono);
			
			//Guardar los cambios
			Browser.waitForElementScreen(btnGuardarCambiosMiPass);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnGuardarCambiosMiPass);
			
			// Validamos que se guarda la Nueva Contrasea indicada
			Browser.waitForElementScreen(checkCambiarDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = (Browser.checkObjeto(checkCambiarDatosPersonales));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se guarda la Nueva Contrasea indicada", "");
				Reporting.reportOK("OK - Validamos que se guarda la Nueva Contrasea indicada");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda la Nueva Contrasea indicada", "");
				
				Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
			}
			
			return resultado;

		} catch (Exception e) {
			e.printStackTrace();
			Reporting.reportKO("KO - NO se guarda la Nueva Contraseña indicada");
			throw new Exception("KO - NO se guarda la Nueva Contraseña indicada " + e.toString());
		}


	}
	
	
	/**
	 * Metodo para Cambiar Datos Demograficos
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarDatosDemograficos(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0012_TXT_1);
		
		try {
			boolean resultado = false;
			String nombreVia = "Prueba123";
			
			// 1.3 Se pulsa Ir a rea Personal
			Browser.waitForElementScreen(btnAreaPersonal);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAreaPersonal);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'rea Personal'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'rea Personal'");

			// 1.4 Pulsar el botn Cambiar Datos Demogrficos
			Browser.waitForElementScreen(btnCambiarDatoDemografico);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnCambiarDatoDemografico);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Datos Demogrficos'", "");
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar Datos Demogrficos'");

			// Se introduce el otp recibido por sms y se pulsa en seguir
			Browser.waitForElementScreen(btnSeguirDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.checkObjeto(btnSeguirDatosPersonales);
			Properties datosConfig = PropertyControl.getProperties("config");
			switch (actualEnv) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtOTPDatosPersonales, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				Reporting.reportKO("No se ha indicado un entorno valido");
				break;
			}
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			
			// Pulsamos en Seguir
			Browser.waitForElementScreen(btnSeguirDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnSeguirDatosPersonales);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
			
			// Modifcar la direccin 
			Browser.waitForElementScreen(txtNombreVia);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.getWebElement(txtNombreVia).clear();
			Browser.writeTextSyncro(txtNombreVia, nombreVia);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la direccion", "");
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Reporting.reportOK("OK - Se escribe la direccion");
		
			// Pulsamos en Seguir
			Browser.waitForElementScreen(btnSeguirDatosPersonales);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnSeguirDatosPersonales);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Seguir'");
		
			// Validamos que se guarda la Nueva Contrasea indicada
			Browser.waitForElementScreen(checkCambiarDireccion);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = (Browser.checkObjeto(checkCambiarDireccion));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda la Nueva Contrasea indicada", "");
				Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
			}
			
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - NO se guarda la Nueva Contrasea indicada");
			e.printStackTrace();
			throw new Exception("KO - NO se guarda la Nueva Contrasea indicada " + e.toString());
		}

	}

	
	
	
}
