package pageibject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;

import general.Browser;
import general.Final;
import general.PropertyControl;
import general.Reporting;


public class AreaPersonal  {

	String testCase;
	

	// Objetos Area Personal
	private By btnAreaPersonal = By.id("userDataHeaderLink");
	
	// Check Pantalla Area Personal
	private By txtNombreApellidos = By.xpath("//h4[text()='Nombre y apellidos']");
	private By txtNIF = By.xpath("//h4[text()='NIF']");
	private By txtFechaNacimiento = By.xpath("//h4[text()='Fecha de nacimiento']");
	private By fotoPerfil = By.id("imgProfileCustomerData");
	private By direccion = By.xpath("//h4[text()='Direcci�n']");
	private By email = By.xpath("//h4[text()='Email']");
	private By telefono = By.xpath("//h4[text()='Tel�fono']");
	private By btnCambiarMiUsuario = By.xpath("//button[text()='Cambiar mi usuario']");
	private By btnCambiarMiPassword = By.xpath("//button[text()='Cambiar mi contrase�a']");
	private By btnActualizarDocumentoIdentidad = By.xpath("//a[text()='ACTUALIZAR DOCUMENTO DE IDENTIDAD']");
	private By btnCambiarDatosAreaPersonal = By.id("personalDataChangeLink");
	private By btnCambiarDatoFoto = By.id("changePhoto");
	private By btnCambiarDatoDemografico = By.id("demographicDataChangeLink");
	
	
	
	
	// Cambiar Datos Personales
	private By txtOTPDatosPersonales = By.xpath("//*[@id='verify-code']");
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
	
	//Cambiar datos direccion
	//private By txtNombreVia = By.id("direccion");
	//private By checkCambiarDireccion = By.xpath("//p[text()='Por mantener actualizados tus datos de contacto']");
	
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
	private By checkCambioPass = By.xpath("//p[text()='Has cambiado tu contrase�a para acceder a WiZink.']");
	
	// Opciones
//	private By btnDatosPersonales = By.id("customerLink1");
	private By btnDocumentacion = By.id("customerLink3");
//	private By btnDatosPrivacidadMisDatos = By.id("customerLink4");
	
	// Documentacion
	private By checkGenerales = By.xpath("//h4[text()='Generales']");
	private By checkCredito = By.xpath("//h4[text()='Cr�dito']");
	
	private By btnTerminosYCondicionesGeneral = By.xpath("//a/p[text()='Terminos y Condiciones General']");
	private By btnContratoMulticanal = By.xpath("//a/p[text()='OLB - Contrato Multicanal']");
	
	

	/**
	 * Metodo para Validar el Area Personal
	 * 
	 * @return
	 * 
	 */
	public void checkAreaPersonal() throws Exception {

			
			boolean isDisabled = true;

			Browser.clickElementSyncro(btnAreaPersonal);
			
			Reporting.reportOK("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.3 Se pulsa Ir a �rea Personal y se visualizan los datos personales, demogr�ficos,
			// foto de perfil y opciones de cambiar estos, el usuario y la contrase�a.
			Browser.checkFieldText(btnCambiarMiUsuario, "Cambiar mi usuario");
			
			// Validamos la pantalla de �rea Personal
			Browser.checkFieldText(txtNombreApellidos,"Nombre y apellidos");
			Browser.checkFieldText(txtNIF,"NIF");
			Browser.checkFieldText(txtFechaNacimiento, "Fecha de nacimiento"); 
			Browser.checkFieldText(fotoPerfil,"imgProfileCustomerData");
			Browser.checkFieldText(direccion,"Direcci�n");
			Browser.checkFieldText(email,"Email");
			Browser.checkFieldText(telefono,"Tel�fono"); 
			Browser.checkFieldText(btnCambiarMiUsuario,"Cambiar mi usuario");
			Browser.checkFieldText(btnCambiarMiPassword,"Cambiar mi contrase�a");
			Browser.checkFieldText(btnActualizarDocumentoIdentidad,"ACTUALIZAR DOCUMENTO DE IDENTIDAD");
			Browser.checkFieldText(btnCambiarDatosAreaPersonal,"personalDataChangeLink") ;
			Browser.checkFieldText(btnCambiarDatoFoto,"changePhoto");
			Browser.checkFieldText(btnCambiarDatoDemografico,"demographicDataChangeLink");
			
			// report 
			Reporting.reportOK("Estamos en el área personal");


	}
	
	/**
	 * Metodo para Validar la pantalla Documentacion
	 * 
	 * @return
	 * 
	 */
	public boolean checkDocumentacion() throws Exception {
		
			try {
				Browser.waitExt(1);
				boolean resultado = false;

				Browser.clickElementSyncro(btnAreaPersonal);
				
				Reporting.reportOK("OK - Se pulsa en el bot�n '�rea Personal'");

				Browser.waitExt(5);
				Browser.clickElementSyncro(btnDocumentacion);
				Reporting.reportOK("OK - Se pulsa en el bot�n 'Documentacion'");
				
				// 1.4 Se pulsa sobre la opcin Documentacin y se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito.
				resultado = (Browser.checkObjeto(checkGenerales) && Browser.checkObjeto(checkCredito));
				if (resultado) {
					//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito", "");
					Reporting.reportOK("Se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito");
				} else {
					//egea.reportaTraza(testCase, "ERROR", "KO", "NO se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito", "");
					Reporting.reportKO("KO - NO se muestra la documentacin disponible divida en bloques: Generales, Ahorro y Crdito");
				}
				
				Properties datosConfig = PropertyControl.getProperties("config");
				String entorno = datosConfig.getProperty("entorno");
				
				String ruta = "";
				File fichero;
				switch (entorno) {
				case "DES":
					// DES
					// Borramos antes el fichero si existe y luego descargamos
					ruta = Browser.rutaPath + File.separator + "properties" + File.separator + "Terminos y Condiciones General.pdf";
					fichero = new File(ruta);
					if (fichero.exists()) {
						fichero.delete();
					}
					
					// 1.5	Se pulsa sobre el enlace Contrato multicanal
					Browser.clickElementSyncro(btnTerminosYCondicionesGeneral);
					//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'", "");
					Reporting.reportOK("OK - Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'");
					break;
				case "PRE":
					// PRE
					// Borramos antes el fichero si existe y luego descargamos
					ruta = Browser.rutaPath + File.separator + "properties" + File.separator + "OLB - Contrato Multicanal.pdf";
					fichero = new File(ruta);
					if (fichero.exists()) {
						fichero.delete();
					}
					
					// 1.5	Se pulsa sobre el enlace Contrato multicanal
					Browser.clickElementSyncro(btnContratoMulticanal);
					//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'", "");
					Reporting.reportOK("OK - Se pulsa sobre el enlace 'Contrato multicanal' - 'Terminos y Condiciones General'");
					break;
				default:
					Reporting.reportKO("No se ha indicado un entorno valido");
					break;
				}

				// Esperamos a que se descargue el Fichero PDF
				Browser.waitExt(20);
				
				// Validamos que se ha descargado el Fichero PDF
				fichero = new File(ruta);
				resultado = fichero.exists();
				if (resultado) {
					//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se ha descargado el Fichero PDF", "");
					Reporting.reportOK("OK - Validamos que se ha descargado el Fichero PDF");
				} else {
					//egea.reportaTraza(testCase, "ERROR", "KO", "NO se valida que se ha descargado el Fichero PDF", "");
					Reporting.reportKO("KO - NO se valida que se ha descargado el Fichero PDF");
				}
				
				return resultado;
			} catch (Exception e) {
				Reporting.reportKO("KO - NO se valida que se ha descargado el Fichero PDF");
				e.printStackTrace();
				throw new Exception("KO - NO se valida que se ha descargado el Fichero PDF " + e.toString());
			}


	}

	
	/**
	 * Metodo para Validar el Area Personal
	 * 
	 * @return
	 * 
	 */
	public void cambiarFotoPerfilAreaPersonal() throws Exception {
		
			boolean isDisabled = true;

			// 1.3 Se pulsa Ir a �rea Personal
			Browser.clickElementSyncro(btnAreaPersonal);
			Reporting.reportOK("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar sobre el link 'Cambiar' de la Foto de Perfil
			Browser.clickElementSyncro(btnCambiarDatoFoto);
			Reporting.reportOK("OK - Se pulsa sobre el link 'Cambiar' de la Foto de Perfil");

			// 1.5 Pulsar sobre la foto y se muestran las fotos disponibles para seleccionar
			Browser.clickElementSyncro(btnImagenCambioFoto);
			
			Reporting.reportOK("OK - Se pulsa sobre la foto y se muestran las fotos disponibles para seleccionar");
			
			// Realizamos la subida del Fichero
			Browser.waitExt(1);
			Reporting.reportOK("Subimos Imagen");

			//Properties datosConfig = PropertyControl.getConfProperty("config");
			//String text = datosConfig.getProperty("rutaImagen");
			
			//StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			//clipboard.setContents(stringSelection, stringSelection);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Reporting.reportOK("Fin Subir Imagen");
			Browser.waitExt(1);
			
			// 1.6 Seleccionar foto y pulsar en ok. La foto seleccionada se muestra como la del perfil
			Browser.waitForElementSyncro(btnGuardarCambiosImagenCambioFoto);
			Browser.scrollNavegadorVertical("ABAJO");
			Browser.clickElementSyncro(btnGuardarCambiosImagenCambioFoto);
			
			Reporting.reportOK("OK - Seleccionar foto y pulsar en ok. La foto seleccionada se muestra como la del perfil");
			
			Browser.waitExt(1);
			Browser.cargarSpinner();
			Browser.waitExt(1);
			
			// Nos volvemos para verificar que se ha incluido el cambio de la Imagen -- Boton Volver
			Browser.waitForElementSyncro(btnVolverImagenCambioFoto);
			Browser.clickElementSyncro(btnVolverImagenCambioFoto);
			
			Reporting.reportOK("OK - Nos volvemos para verificar que se ha incluido el cambio de la Imagen");
			
			// Validamos que se muestra el boton Eliminar (Significa que se ha incluido anteriormente)
			//Este método no se encuentra en el código antiguo
			//Browser.checkFieldDisabled(btnEliminarImagenCambioFoto, "delete", isDisabled);
						
			// Borramos la Imagen para futuras ejecuciones de la prueba
			Browser.clickElementSyncro(btnEliminarImagenCambioFoto);
			Reporting.reportOK("OK - Eliminamos la Imagen");
			
			//Browser.checkObjetoNoExiste(btnEliminarImagenCambioFoto);
			Reporting.reportOK("OK - El boton Eliminar no existe");
			
			// report 
			Reporting.reportOK("El botón eliminar no existe");
			


	}
	
	/**
	 * Metodo para Validar el Area Personal
	 * 
	 * @return
	 * 
	 */
/**	public boolean cambiarPasswordPerfilAreaPersonal(String password) throws Exception {
		try {
			ProjectPaths.waitExt(1);
			boolean resultado = false;

			// 1.3 Se pulsa Ir a �rea Personal
			click(btnAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n '�rea Personal'", "");
			System.out.println("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar el bot�n "CAMBIAR MI CONTRASE�A"
			ProjectPaths.waitExt(1);
			click(btnCambiarMiPassword);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi Contrase�a'", "");
			System.out.println("OK - Se pulsa sobre el link 'Cambiar Mi Contrase�a'");

			// 1.5 Introducir la contrase�a antigua, y la nueva en los campos contrase�a y repetir contrase�a
			click(txtPassActualMiPass);
			type(password,txtPassActualMiPass);
			click(txtPassCrea1MiPass);
			type(password,txtPassCrea1MiPass);
			click(txtPassCrea2MiPass);
			type(password,txtPassCrea2MiPass);
			
			
			// 1.6 Pulsar en el bot�n "GUARDAR CAMBIOS". Los cambios se guardan de manera correcta
			click(btnGuardarCambiosMiPass);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Guardar Cambios'", "");
			System.out.println("OK - Se pulsa sobre el link 'Guardar Cambios'");
			
			// Validamos que se guarda la Nueva Contrase�a indicada
			resultado = isDisplayed(checkCambioPass);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se guarda la Nueva Contrase�a indicada", "");
				System.out.println("OK - Validamos que se guarda la Nueva Contrase�a indicada");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda la Nueva Contrase�a indicada", "");
				System.out.println("KO - NO se guarda la Nueva Contrase�a indicada");
			}
			
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - NO se guarda la Nueva Contrase�a indicada");
			e.printStackTrace();
			throw new Exception("KO - NO se guarda la Nueva Contrase�a indicada " + e.toString());
		}

	}**/
	
	/**
	 * Metodo para Validar el Area Personal
	 * 
	 * @return
	 * 
	 */
/**	public boolean cambiarUsuarioPerfilAreaPersonal(String nombreUsuario, String contrasenia) throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa Ir a �rea Personal
			click(btnAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n '�rea Personal'", "");
			System.out.println("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar el bot�n "CAMBIAR MI USUARIO"
			click(btnCambiarMiUsuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi usuario'", "");
			System.out.println("OK - Se pulsa sobre el link 'Cambiar Mi usuario'");
			
			String usuario = "test123";

			

			// 1.5 Introducir el nuevo usuario y la clave actual
			click(txtUsuarioCambiarUsuario);
			type(usuario,txtUsuarioCambiarUsuario);
			
			click(txtPasswordCambiarUsuario);
			type(contrasenia,txtPasswordCambiarUsuario);

			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el nuevo Usuario y contrase�a", "");
			System.out.println("OK - Se escribe el nuevo Usuario y contrase�a");
						
			// 1.6 Pulsar en el bot�n "Seguir". Los cambios se guardan de manera correcta
			ProjectPaths.sincronizaObjetoClick(btnSeguirDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
							
			// Validamos que se guarda el nuevo usuario
			resultado = isDisplayed(checkcambioUsuario);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se guarda el nuevo Usuario indicado", "");
				System.out.println("OK - Validamos que se guarda el nuevo Usuario indicado");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO se guarda el nuevo Usuario indicado", "");
				System.out.println("KO - NO se guarda el nuevo Usuario indicadoa");
			}

			//Volvemos a restaurar el usuario
			//1.3 Se pulsa Ir a �rea Personal
			click(btnAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n '�rea Personal'", "");
			System.out.println("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar el bot�n "CAMBIAR MI USUARIO" 
			click(btnCambiarMiUsuario);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Mi usuario'", "");
			System.out.println("OK - Se pulsa sobre el link 'Cambiar Mi usuario'");
						
			// 1.5 Introducir el nuevo usuario y la clave actual
			click(txtUsuarioCambiarUsuario);
			type(nombreUsuario,txtUsuarioCambiarUsuario);
			
			click(txtPasswordCambiarUsuario);
			type(contrasenia,txtPasswordCambiarUsuario);
			
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el nuevo Usuario y contrase�a", "");
			System.out.println("OK - Se escribe el nuevo Usuario y contrase�a");
									
			// 1.6 Pulsar en el bot�n "Seguir". Los cambios se guardan de manera correcta
			ProjectPaths.sincronizaObjetoClick(btnSeguirDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			return resultado;
		} catch (Exception e) {
				System.out.println("KO - NO se guarda el nuevo usuario indicada");
				e.printStackTrace();
				throw new Exception("KO - NO se guarda el nuevo usuario indicada " + e.toString());
			}

	}**/
	
	/**
	 * Metodo para Cambiar Datos Personales
	 * 
	 * @return
	 * 
	 */
	/**public boolean cambiarDatosPersonales(String direccion) throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa Ir a �rea Personal
			click(btnAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n '�rea Personal'", "");
			System.out.println("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar el bot�n Cambiar Datos Personales
			click(btnCambiarDatosAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Datos Personales'", "");
			System.out.println("OK - Se pulsa sobre el link 'Cambiar Datos Personales'");

			// Se introduce el otp recibido por sms y se pulsa en seguir
			ProjectPaths.waitExt(3);
			introduceCodigoOTPDatosPersonales(txtOTPDatosPersonales, "");
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			System.out.println("OK - Se introduce el OTP");
			
			// Pulsamos en Seguir
			click(btnSeguirDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			// Modificar el nombre seleccionamos fichero y pulsamos continuar
			String valorDireccion = ProjectPaths.obtenerTextoElemento(txtNombreDatosPersonales, "value");
			click(txtNombreDatosPersonales);
			clear(txtNombreDatosPersonales);
			String DireccionMod = valorDireccion + " TEST";
			
			type(DireccionMod,txtNombreDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Modificamos el 'nombre' en los Datos Personales", "");
			System.out.println("OK - Modificamos el 'nombre' en los Datos Personales");
			
			// Subimos el documento PDF
			// Funciones.sincronizaObjetoClick(BTNCONTINUAR);
			
			
			// Fin de Subida documento PDF
			
			// Pulsamos en Continuar
			// Funciones.sincronizaObjetoClick(BTNCONTINUAR);
			
			// Validamos el Mesaje de la Modificacion
			resultado = isDisplayed(btnSeleccionardni);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Modificamos el 'Nombre' en los Datos Personales", "");
				System.out.println("OK - Modificamos el 'Nombre' en los Datos Personalesa");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO modificamos el 'Nombre' en los Datos Personales", "");
				System.out.println("KO - NO modificamos el 'Nombre' en los Datos Personales");
			}
			
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - NO Modificamos el 'Nombre' en los Datos Personales");
			e.printStackTrace();
			throw new Exception("KO - NO Modificamos el 'Nombre' en los Datos Personales " + e.toString());
		}

	}**/
	
	
	/**
	 * Metodo para Cambiar Datos Demograficos
	 * 
	 * @return
	 * 
	 */
	/**public boolean cambiarDatosDemograficos() throws Exception {
		try {
			boolean resultado = false;
			
			// 1.3 Se pulsa Ir a �rea Personal
			click(btnAreaPersonal);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n '�rea Personal'", "");
			System.out.println("OK - Se pulsa en el bot�n '�rea Personal'");

			// 1.4 Pulsar el bot�n Cambiar Datos Demogr�ficos
			click(btnCambiarDatoDemografico);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el link 'Cambiar Datos Demogr�ficos'", "");
			System.out.println("OK - Se pulsa sobre el link 'Cambiar Datos Demogr�ficos'");

			// Se introduce el otp recibido por sms y se pulsa en seguir
			isDisplayed(btnSeguirDatosPersonales);
			introduceCodigoOTP(txtOTPDatosPersonales, "");
			egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			System.out.println("OK - Se introduce el OTP");
			
			// Pulsamos en Seguir
			click(btnSeguirDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
			
			// Modifcar la direcci�n 
			// Modificar la direccion y Pulsar en "COMPLETAR"
			String valorDireccion = ProjectPaths.obtenerTextoElemento(txtDireccionDatosPersonales, "value");
			ProjectPaths.sincronizaObjetoLimpia(txtDireccionDatosPersonales);
			String DireccionMod = valorDireccion + " TEST";
			
			/*Funciones.sincronizaObjetoEscribe(txtNombreVia, nombreVia);
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe la direccion", "");
			System.out.println("OK - Se escribe la direccion");
			click(txtDireccionDatosPersonales);
			type(DireccionMod,txtDireccionDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Modificamos la 'Direcci�n' en los Datos Personales", "");
			System.out.println("OK - Modificamos la 'Direcci�n' en los Datos Personales");
			
			// Pulsamos en Seguir
			click(btnSeguirDatosPersonales);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Seguir'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Seguir'");
		
			
			
			// Validamos que se guardan los cambios
			ProjectPaths.waitExt(2);
			resultado = isDisplayed(checkCambiarDatosPersonales);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se ha cambiado la Direcci�n del apartado Datos Personales", "");
				System.out.println("OK - Validamos que se ha cambiado la Direcci�n del apartado Datos Personales");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida que se haya cambiado la Direcci�n del apartado Datos Personales", "");
				System.out.println("KO - No se valida que se haya cambiado la Direcci�n del apartado Datos Personales");
			}
			
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - NO se guarda la Nueva Contrase�a indicada");
			e.printStackTrace();
			throw new Exception("KO - NO se guarda la Nueva Contrase�a indicada " + e.toString());
		}

	}**/
	
	
	
}
