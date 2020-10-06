package pageibject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import general.ProjectPaths;

public class Mensajes {

	String testCase;


	// Objetos Mensajes
	private By btnMensajes = By.id("inboxHeaderLink");
	private By btnMsgRecibidos = By.id("rcvLink");
	private By btnMsgRedactar = By.id("sendNewMsgLink");
	private By btnMsgEnviados = By.id("sentLink");
	
	private By listaMensajesBandeja = By.xpath("//*[contains(@class, 'inboxmail list-group-item')]");
	private By detalleMensajesBandeja = By.id("msg-answer-disabled");
	private By checkmensajeEnviado = By.xpath("//h3[text()='Gracias por tu mensaje.']");
	
	private By checkPantallaMensajesRecibidos = By.xpath("//h3[text()='Recibidos']");
	
	private By btnBorrarMsg = By.id("rubbishIcon");
	
	// Redactar Mensaje
	private By desplegableAsuntoMsg = By.id("subject-messageSelectBoxIt");
	private By desplegableOpcionConsultaTarjetaMsg = By.xpath("//a[text()='Consulta Tarjeta']");
	private By textAreaMsg = By.id("msg-text");
	private By btnEnviarMsg = By.id("sendNewMsgButton");
	private By checkMensajeEnvioMsg = By.id("messageSentDiv");
	
	// PopUp Borrar Mensaje
	private By btnBorrarSIMsgPopUp = By.id("modalYesButton");
//	private By btnBorrarNOMsgPopUp = By.id("modalNoButton");
	private By checkMensajeBorrarMsg = By.id("messageDeletedDiv");
	
	
	

	/**
	 * Metodo para Validar los Mensajes Recibidos
	 * 
	 * @return
	 * 
	 */
	/**public boolean checkMsgRecibidos() throws Exception {
		try {
			ProjectPaths.waitExt(1);	
			boolean resultado = false;
			
			click(btnMensajes);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes'");
			
			ProjectPaths.waitExt(6);
			isDisplayed(btnMsgRecibidos);
			click(btnMsgRecibidos);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes Recibidos'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes Recibidos'");
			
			ProjectPaths.waitExt(2);
//			Funciones.sincronizaObjetoClick(listaMensajesBandeja);
//			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el primer Mensaje de la bandeja", "");
//			System.out.println("OK - Se pulsa en el primer Mensaje de la bandeja");
//			
//			// Validamos que se muestra el mensaje recibido
//			resultado = Funciones.checkObjeto(detalleMensajesBandeja);
//			if (resultado) {
//				egea.reportaTraza(testCase, "INFO", "OK", "Se abre el Mensaje Recibido y se valida la pantalla", "");
//				System.out.println("OK - Se abre el Mensaje Recibido y se valida la pantalla");
//			} else {
//				egea.reportaTraza(testCase, "ERROR", "KO", "NO se abre el Mensaje Recibido y se valida la pantalla", "");
//				System.out.println("KO - No se abre el Mensaje Recibido y se valida la pantalla");
//			}

			// Validamos que se muestra el mensaje recibido
			resultado = isDisplayed(checkPantallaMensajesRecibidos);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida la pantalla Mensajes Recibidos", "");
				System.out.println("OK - Se valida la pantalla Mensajes Recibidos");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida la pantalla Mensajes Recibidos", "");
				System.out.println("KO - No se valida la pantalla Mensajes Recibidos");
			}
			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("KO - No se valida la pantalla Mensajes Recibidos");
			e.printStackTrace();
			throw new Exception("KO - No se valida la pantalla Mensajes Recibidos " + e.toString());
		}

	}**/
	
	/**
	 * Metodo para Validar los Mensajes Enviados
	 * 
	 * @return
	 * 
	 */
	/**public boolean checkMsgEnviados() throws Exception {
		try {
			boolean resultado = false;
			
			click(btnMensajes);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes'");
			
			//Funciones.waitForElement(btnMsgRedactar,4,"no se carga la pantalla");
			ProjectPaths.waitExt(2);
			click(btnMsgRedactar);
			egea.reportaTraza(testCase, "INFO", "OK", "Se Muestra la p�gina de creaci�n de mensajes", "");
			System.out.println("OK - Se Muestra la p�gina de creaci�n de mensajes");
			
			//Escribimos un mensaje para asegurar mensajes en  bandeja salida
			ProjectPaths.waitExt(4);
			click(desplegableAsuntoMsg);
			click(desplegableOpcionConsultaTarjetaMsg);
			click(textAreaMsg);
			type("test123",textAreaMsg);
			click(btnEnviarMsg);
			
			ProjectPaths.waitExt(4);
			click(btnMsgEnviados);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes Enviados'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes Enviados'");
			
			//Funciones.waitForElement(listaMensajesBandeja, 5, "Esperando a carga bandeja entrada");
			click(listaMensajesBandeja);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el primer Mensaje de la bandeja", "");
			System.out.println("OK - Se pulsa en el primer Mensaje de la bandeja");
			ProjectPaths.waitExt(4);
			
			// Validamos que se muestra el mensaje Enviado
			resultado = isDisplayed(btnBorrarMsg);
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", " Validamos que se muestra el mensaje Enviado", "");
				System.out.println("OK -  Validamos que se muestra el mensaje Enviado");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO validamos que se muestra el mensaje Enviado", "");
				System.out.println("KO - No validamos que se muestra el mensaje Enviado");
			}
			return resultado;
			
		} catch (Exception e) {
			System.out.println("KO - NO validamos que se muestra el mensaje Enviado");
			e.printStackTrace();
			throw new Exception("KO - NO validamos que se muestra el mensaje Enviado " + e.toString());
		}

	}**/
	
	
	/**
	 * Metodo para Redactar Mensajes
	 * 
	 * @return
	 * 
	 */
	/**public boolean redactarMsg() throws Exception {
		try {

			boolean resultado = false;
			
			ProjectPaths.sincronizaObjetoSoloClick(btnMensajes);
			//Funciones.waitExt(2);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes'");
			
			ProjectPaths.waitForElement(btnMsgRedactar,4,"no se carga la pantalla");
			ProjectPaths.sincronizaObjetoClick(btnMsgRedactar);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes Enviados'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes Enviados'");
			
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoClick(desplegableAsuntoMsg);
			ProjectPaths.sincronizaObjetoClick(desplegableOpcionConsultaTarjetaMsg);
			egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona el Asunto con 'Consulta Tarjeta'", "");
			System.out.println("OK - Se selecciona el Asunto con 'Consulta Tarjeta'");
			
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoEscribe(textAreaMsg, "Texto prueba");
			egea.reportaTraza(testCase, "INFO", "OK", "Se escribe el mensaje a Enviar", "");
			System.out.println("OK - Se escribe el mensaje a Enviar");
			

			ProjectPaths.sincronizaObjetoClick(btnEnviarMsg);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Enviar'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Enviar'");
			
			
			// Validamos que se muestra el PopUp indicando que se ha enviado el Mensaje
			resultado = (ProjectPaths.checkObjeto(checkMensajeEnvioMsg));
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida que el Mensaje ha sido enviado puesto que se muestra el PopUp", "");
				System.out.println("OK - Se valida que el Mensaje ha sido enviado puesto que se muestra el PopUp");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp", "");
				System.out.println("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp");
			}
			return resultado;
			
		} catch (Exception e) {
			System.out.println("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp");
			e.printStackTrace();
			throw new Exception("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp " + e.toString());
		}

	}**/
	
	/**
	 * Metodo XXXXXXXXX
	 * 
	 * @return
	 * 
	 */
	/**public boolean borrarMensajes() throws Exception {
		try {
			boolean resultado = false;
			
			ProjectPaths.sincronizaObjetoClick(btnMensajes);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes'");
			
			ProjectPaths.waitExt(4);
			ProjectPaths.sincronizaObjetoClick(btnMsgEnviados);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Mensajes Enviados'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Mensajes Enviados'");
			
			ProjectPaths.sincronizaObjetoClick(listaMensajesBandeja);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el primer Mensaje de la bandeja", "");
			System.out.println("OK - Se pulsa en el primer Mensaje de la bandeja");
			
			ProjectPaths.waitExt(4);
			ProjectPaths.sincronizaObjetoClick(btnBorrarMsg);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Borrar Mensaje'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Borrar Mensaje'");
			
			ProjectPaths.sincronizaObjetoClick(btnBorrarSIMsgPopUp);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Si' para borrar el Mensaje", "");
			System.out.println("OK - Se pulsa en el bot�n 'Si' para borrar el Mensaje");
			
			// Validamos que se muestra el mensaje 'Mensaje borrado'
			resultado = (ProjectPaths.checkObjeto(checkMensajeBorrarMsg));
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el mensaje informativo 'Mensaje borrado'", "");
				System.out.println("OK - Se muestra el mensaje informativo 'Mensaje borrado'");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "NO se muestra el mensaje informativo 'Mensaje borrado'", "");
				System.out.println("KO - No se muestra el mensaje informativo 'Mensaje borrado'");
			}
			return resultado;
			
		} catch (Exception e) {
			System.out.println("KO - No se muestra el mensaje informativo 'Mensaje borrado'");
			e.printStackTrace();
			throw new Exception("KO - No se muestra el mensaje informativo 'Mensaje borrado' " + e.toString());
		}

	}**/
	
}
