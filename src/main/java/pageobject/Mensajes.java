package pageobject;

import static general.Browser.driver;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import general.Browser;
import general.Final;
import general.ProjectPaths;
import general.Reporting;
import general.Utilidades;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Mensajes extends Utilidades{

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
	private By desplegableOpcionConsultaTarjetaMsg = By.xpath("//a[text()='Consultar Tarjeta']");
	private By textAreaMsg = By.id("msg-text");
	private By btnEnviarMsg = By.id("sendNewMsgButton");
	private By checkMensajeEnvioMsg = By.id("messageSentDiv");
	
	// PopUp Borrar Mensaje
	private By btnBorrarSIMsgPopUp = By.id("modalYesButton");
//	private By btnBorrarNOMsgPopUp = By.id("modalNoButton");
	private By checkMensajeBorrarMsg = By.id("messageDeletedDiv");
	
	
	

	/**
	 * Metodo para Validar los Mensajes Recibidos
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean checkMsgRecibidos(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0006_TXT_1);
		
		try {
			Browser.waitExt(1);	
			boolean resultado = false;
			
			Browser.waitForElementScreen(btnMensajes);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMensajes);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes'");
			
			Browser.waitExt(6);
			Browser.waitForElementScreen(btnMsgRecibidos);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.isElementDisplayed(btnMsgRecibidos);
			Browser.clickElementSyncro(btnMsgRecibidos);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes Recibidos'");
			
			Browser.waitExt(2);
			Browser.waitForElementScreen(listaMensajesBandeja);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = Browser.checkObjeto(listaMensajesBandeja);
			if (resultado) {
				Browser.clickElementSyncro(listaMensajesBandeja);
				Reporting.reportOK("OK - Se pulsa en el primer Mensaje de la bandeja");
			} else {
				Reporting.reportKO("KO - No hay mensajes en la bandeja de mensajes recibidos");
			}
			
			
			// Validamos que se muestra el mensaje recibido
			Browser.waitForElementScreen(detalleMensajesBandeja);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = Browser.checkObjeto(detalleMensajesBandeja);
			if (resultado) {
				Reporting.reportOK("OK - Se abre el Mensaje Recibido y se valida la pantalla");
			} else {
				Reporting.reportKO("KO - No se abre el Mensaje Recibido y se valida la pantalla");
			}

			// Validamos que se muestra el mensaje recibido
			Browser.waitForElementScreen(checkPantallaMensajesRecibidos);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			resultado = Browser.isElementDisplayed(checkPantallaMensajesRecibidos);
			if (resultado) {
				Reporting.reportOK("OK - Se valida la pantalla Mensajes Recibidos");
			} else {
				Reporting.reportKO("KO - No se valida la pantalla Mensajes Recibidos");
			}
			
			return resultado;
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporting.reportKO("KO - No se valida la pantalla Mensajes Recibidos");
			throw new Exception("KO - No se valida la pantalla Mensajes Recibidos " + e.toString());
		}

	}

	
	/**
	 * Metodo para Validar los Mensajes Enviados
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean checkMsgEnviados(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0007_TXT_1);
		
		try {
			boolean resultado = false;
			
			Browser.waitForElementScreen(btnMensajes);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMensajes);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes'");
			
			//Funciones.waitForElement(btnMsgRedactar,4,"no se carga la pantalla");
			Browser.waitExt(2);
			Browser.waitForElementScreen(btnMsgRedactar);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMsgRedactar);
			Reporting.reportOK("OK - Se Muestra la página de creación de mensajes");
			
			//Escribimos un mensaje para asegurar mensajes en  bandeja salida
			Browser.waitExt(4);
			Browser.waitForElementScreen(desplegableAsuntoMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(desplegableAsuntoMsg);
			
			Browser.waitForElementScreen(desplegableOpcionConsultaTarjetaMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(desplegableOpcionConsultaTarjetaMsg);
			
			Browser.waitForElementScreen(textAreaMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(textAreaMsg);
			
			Browser.waitForElementScreen(textAreaMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.writeTextSyncro(textAreaMsg,"test123");
			
			Browser.waitForElementScreen(btnEnviarMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnEnviarMsg);
			
			Browser.waitExt(4);
			Browser.waitForElementScreen(btnMsgEnviados);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMsgEnviados);
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes Enviados'");
			
			//Funciones.waitForElement(listaMensajesBandeja, 5, "Esperando a carga bandeja entrada");
			
				Browser.waitForElementScreen(listaMensajesBandeja);
				try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
				Browser.clickElementSyncro(listaMensajesBandeja);
				Reporting.reportOK("OK - Se pulsa en el primer Mensaje de la bandeja");
			
			Browser.waitExt(4);
			
			// Validamos que se muestra el mensaje Enviado
			Browser.waitForElementScreen(btnBorrarMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = Browser.isElementDisplayed(btnBorrarMsg);
			if (resultado) {
				Reporting.reportOK("OK -  Validamos que se muestra el mensaje Enviado");
			} else {
				Reporting.reportKO("KO - No validamos que se muestra el mensaje Enviado");
			}
			return resultado;
			
		} catch (Exception e) {
			Reporting.reportKO("KO - NO validamos que se muestra el mensaje Enviado");
			e.printStackTrace();
			throw new Exception("KO - NO validamos que se muestra el mensaje Enviado " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para Redactar Mensajes
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	@Step("Redactar Mensaje")
	public boolean redactarMsg(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0008_TXT_1);
		
		try {

			boolean resultado = false;
			
			Browser.waitForElementScreen(btnMensajes);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMensajes);
			//Funciones.waitExt(2);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes'");
			
			Browser.waitForElementScreen(btnMsgRedactar);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.waitForElement(btnMsgRedactar,4,"no se carga la pantalla");
			Browser.clickElementSyncro(btnMsgRedactar);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes Enviados'");
			
			Browser.waitExt(1);
			Browser.waitForElementScreen(desplegableAsuntoMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(desplegableAsuntoMsg);
			Browser.clickElementSyncro(desplegableOpcionConsultaTarjetaMsg);
			Reporting.reportOK("OK - Se selecciona el Asunto con 'Consulta Tarjeta'");
			
			Browser.waitExt(1);
			Browser.waitForElementScreen(textAreaMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.writeTextSyncro(textAreaMsg, "Texto prueba");
			Reporting.reportOK("OK - Se escribe el mensaje a Enviar");
			
			Browser.waitForElementScreen(btnEnviarMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnEnviarMsg);
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Reporting.reportOK("OK - Se pulsa en el botón 'Enviar'");
			
			
			// Validamos que se muestra el PopUp indicando que se ha enviado el Mensaje
			Browser.waitForElementScreen(checkMensajeEnvioMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = (Browser.checkObjeto(checkMensajeEnvioMsg));
			if (resultado) {
				Reporting.reportOK("OK - Se valida que el Mensaje ha sido enviado puesto que se muestra el PopUp");
			} else {
				Reporting.reportKO("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp");
			}
			return resultado;
			
		} catch (Exception e) {
			Reporting.reportKO("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp");
			e.printStackTrace();
			throw new Exception("KO - NO se valida que el Mensaje haya sido enviado puesto que NO se muestra el PopUp " + e.toString());
		}

	}
	
	/**
	 * Metodo XXXXXXXXX
	 * @param doc 
	 * 
	 * @return
	 * 
	 */
	public boolean borrarMensajes(String codeTC, XWPFDocument doc) throws Exception {
		
		Utilidades.addTextToDocument(doc, Final.TC_0009_TXT_1);
		
		try {
			boolean resultado = false;
			
			Browser.waitForElementScreen(btnMensajes);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMensajes);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes'");
			
			Browser.waitExt(4);
			Browser.waitForElementScreen(btnMsgEnviados);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnMsgEnviados);
			Reporting.reportOK("OK - Se pulsa en el botón 'Mensajes Enviados'");
			
			Browser.waitForElementScreen(listaMensajesBandeja);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(listaMensajesBandeja);
			Reporting.reportOK("OK - Se pulsa en el primer Mensaje de la bandeja");
			
			Browser.waitExt(4);
			Browser.waitForElementScreen(btnBorrarMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnBorrarMsg);
			Reporting.reportOK("OK - Se pulsa en el botón 'Borrar Mensaje'");
			
			Browser.waitForElementScreen(btnBorrarSIMsgPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			Browser.clickElementSyncro(btnBorrarSIMsgPopUp);
			Reporting.reportOK("OK - Se pulsa en el botón 'Si' para borrar el Mensaje");
			
			// Validamos que se muestra el mensaje 'Mensaje borrado'
			Browser.waitForElementScreen(checkMensajeBorrarMsg);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Utilidades.addImagesToWordDocument(doc, Utilidades.fileGetRemoteScreenshot(driver));
			resultado = (Browser.checkObjeto(checkMensajeBorrarMsg));
			if (resultado) {
				Reporting.reportOK("OK - Se muestra el mensaje informativo 'Mensaje borrado'");
			} else {
				Reporting.reportKO("KO - No se muestra el mensaje informativo 'Mensaje borrado'");
			}
			return resultado;
			
		} catch (Exception e) {
			Reporting.reportKO("KO - No se muestra el mensaje informativo 'Mensaje borrado'");
			e.printStackTrace();
			throw new Exception("KO - No se muestra el mensaje informativo 'Mensaje borrado' " + e.toString());
		}

	}
	
}
