package pageobject;

import java.io.File;
import java.util.Properties;

import org.apache.velocity.runtime.parser.node.GetExecutor;
import org.openqa.selenium.By;

import general.Browser;
import general.PropertyControl;
import general.Reporting;
import general.Utilidades;

public class Producto {

	String testCase;
	private static String actualEnv;
	// Objetos Producto
	private By btnDetalleProducto = By.xpath("//div[contains(@class, 'c-card--ps')]/a");
	//private By btnOpcionesDetalleProducto = By.xpath("//*[@class='layout-content user_titular']/ul/li[4]");
	private By btnOpcionesDetalleProducto = By.xpath("//*[@class='layout-content user_titular']/descendant::a[text()='Opciones']");
	private By btnExtractosDetalleProducto = By.xpath("//*[@class='layout-content user_titular']/descendant::a[text()='Extractos']");

	private By btnCambiarFormaPagoOpcionesProducto = By.id("changePaymentOptionYourCard");
	private By btnCambiarCuentaDomiciliacionOpcionesProducto =  By.id("changePayAccount");
	private By btnHacerUnIngresoOpcionesProducto = By.id("paymentSummaryLink");
	private By btnConsultaPINOpcionesProducto = By.id("sec_changepin");
	private By btnConsultarNumCVVOpcionesProducto = By.id("consultCVV");
	private By btnCargoNoReconocidoOpcionesProducto = By.id("reclaimMovementLink");
	private By btnInformacionWizinkPayOpcionesProducto = By.id("wizinkPayLink");
	private By btnDesactivarWizinkPayOpcionesProducto = By.id("sec_wizinkPay");
	
	// Campo Codigo OTP
	private By txtCodigoOTPCambiarFormaPago = By.id("verify-code");
	
	// Cambiar Forma de Pago
	private By radioPagoMinimoCambiarFormaPago = By.xpath("//label[@for='payment-min']");
	private By btnSeguirCambiarFormaPago = By.id("submitChangePaymentOptionForm");
	
	// Cambiar Cuenta Cargo
	private By txtIBANCambiarCuentaCargo = By.id("newPaymentDebitAccount");
	private By btnSeguirCambiarCuentaCargo = By.id("submitChangePaymentAccountForm");
	
	// Hacer un Ingreso
	private By btnAccederPagoOnline = By.id("vposPaymentsButton0");
	private By chkOtroImporte = By.id("rbtDebtOtro");
	private By txtOtraCantidad = By.id("txtOtherAmount");
	private By txtNombreCliente = By.id("txtAutFirstName");
	private By txtNumeracionTarjeta = By.id("txtAddNewCard");
	private By txtFechaCaducidad = By.id("txtCardExpireDate");
	private By txtCvv = By.id("txtPassword");
	private By chkSoyTitular = By.id("chkLegalCondition");
	private By btnRealizarPago = By.id("continue");
	
	// Ver nmero y CVV de mi tarjeta
	private By btnSeguirVerNumCVVTarjeta = By.id("btnContinuar");
	private By checkNumTarjeta = By.id("cardFrontId");
	private By btnMasInfoCVV = By.xpath("//*[@class='action_link activate_flip_new only_front']");
	private By checkCVVTarjeta = By.id("cvvId");
	
	// Consultar PIN
	private By btnSeguirConsultarPIN = By.id("btnContinuar");
	private By btnMostrarPIN = By.xpath("//*[@class='c-show-pin--action']");
	private By imagenPIN = By.id("pinImg");
	
	// Bloquear Tarjeta
	private By btnBloquearTarjeta = By.id("sec_blockCard");
	private By radioMeHanRobadoTarjeta = By.xpath("//label[@for='motive-stolen']");
	private By btnSeguirBloqueo = By.id("continueButton");
	
	// Resumen
//	private By checkHoyProducto = By.xpath("//h2[contains(text(), 'Hoy,')]");
	private By checkSituacionActualProducto = By.xpath("//*[contains(text(), 'Situacin actual')]/ancestor::div[1]");
	
	// Extractos
	private By btnExtractosMesAnterior = By.id("previousExtract");
	private By checkOperacionesMesProducto = By.xpath("//*[@class='card-movement-detail'][1]");
	
	private By btnCambiarInscritoExtracto = By.id("enrollmentToPaperLink");
	private By checkCambiarExtractoPapel = By.xpath("//*[@id=\"statementEnrollmentProcessForm\"]/div[2]/div/div[2]/div/div/div[2]/label");
	private By checkCambiarExtractoElectronico = By.xpath("//label[@for='reminder-available']");
	
	private By btnSeguir = By.id("enrollmentToModal");
	private By txtOTPDatosPersonales = By.id("verify-code");
	private By confirmar = By.id("continueButton");
	private By checkCambiarExtracto = By.xpath("//header[@class='bypass']");
	
	private By btnVolverExtractos = By.id("returnPageFunction");
	
	// Operaciones
	private By btnGraficosOperacionesMes = By.id("chartButton");
	private By btnXLSOperacionesMes = By.id("downloadExtractLinkXLS");
	private By graficosOperacionesMes = By.xpath("//li[@class='chart']");
	
	//reenvio de tarjetas
	private By btnReenvioTarjeta = By.xpath("//*[@id='sec_renoveCard']");
	private By btnSeguirReenvio = By.xpath("//*[@id='seguirButton']");
	private By btnRenovarTarjeta = By.xpath("/html/body/main/div[1]/div[1]/div[1]/section/div/div/div/form/div[2]/div/div");
	private By txtDirecciónEnvio = By.xpath("//*/address");
		
	
	public Producto(String testCase) {
		super();
		this.testCase = testCase;
	}

	/**
	 * Metodo para validar Opciones del Producto
	 * 
	 * @return
	 * 
	 */
	public void checkProductoOpciones() throws Exception {
		

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			
			
			// Las opciones pueden ser: cambiar forma de pago, cambiar la cuenta de domiciliacin, 
			// consultar pin, consultar num y cvv de la tarjeta, bloquear tarjeta, reclamar un cargo no reconocido, 
			// pedir reenvo de tarjeta, informarme sobre wizink pay, solicitar una tarjeta adicional
			Browser.waitExt(10);
			if (Browser.checkObjeto(btnCambiarFormaPagoOpcionesProducto) && Browser.checkObjeto(btnCambiarCuentaDomiciliacionOpcionesProducto) 
						&& Browser.checkObjeto(btnHacerUnIngresoOpcionesProducto) && Browser.checkObjeto(btnConsultarNumCVVOpcionesProducto) 
						&& Browser.checkObjeto(btnCargoNoReconocidoOpcionesProducto) && Browser.checkObjeto(btnInformacionWizinkPayOpcionesProducto)
						&& Browser.checkObjeto(btnDesactivarWizinkPayOpcionesProducto)) {
							
				Reporting.reportOK("OK - Se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional");
					}
		
	

	}
	
	/**
	 * Metodo para validar los movimientos de hoy
	 * 
	 * @return
	 * 
	 */
	public void checkProductoMovimientosHoy() throws Exception {
		

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Se visualizan los movimientos realizados el da de la prueba Con ttulo "Hoy,."
			Browser.checkObjeto(checkSituacionActualProducto);
			Reporting.reportOK("OK - Se visualizan los movimientos de la tarjeta de la prueha");
			
	}
	
	
	/**
	 * Extractos
	 * 
	 * 
	 */
	public void checkProductoExtractos() throws Exception {
		

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre extractos");	
			
			
			//Report
			Reporting.reportOK("OK - Se pulsa sobre extractos");
			
			// 1.5 Se seleacciona el Mes anterior al actual y se muestran los movimientos de la tarjeta correspondientes a ese mes
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			
			//reoirt
			Reporting.reportOK("OK - Se seleacciona el Mes anterior al actual");

			Browser.waitExt(1);
			Browser.checkObjeto(checkOperacionesMesProducto);
			
			//Report
			Reporting.reportOK("OK - Se muestran los movimientos de la tarjeta correspondientes al mes seleccionado");
			
			

	}
	
	
	/**
	 * MMostrar las gráficas
	 * 
	 */
	public void checkProductoExtractosGraficos() throws Exception {
		
			//actualEnv = PropertyControl.getConfProperty("actualEnv");
			actualEnv = System.getProperty("entorno");
			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre extractos");	
				
			// 1.5 Se seleacciona el Mes anterior al actual y se muestran los movimientos de la tarjeta correspondientes a ese mes
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			Browser.clickElementSyncro(btnExtractosMesAnterior);	
			
	
			// 1.6 Pulsar en el botn "Mostrar Grficos" de los movimientos y se muestra un diagrama con las operaciones del mes
			Browser.waitExt(2);
			Browser.clickElementSyncro(btnGraficosOperacionesMes);
			Reporting.reportOK("OK - Se pulsa en el botn 'Mostrar Gráficos' de los movimientos");
			
			Browser.waitExt(2);
			Browser.checkObjeto(graficosOperacionesMes);
			Reporting.reportOK("OK - Se muestra un diagrama con las operaciones del mes"); 

	}
	
	
	/**
	 * Acceder al extracto de la tarjeta
	 * 
	 */
	public void checkProductoExtractosXLS() throws Exception {
	

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(5);
			
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			
			Reporting.reportOK("OK - Se pulsa sobre extractos");	
		
			
			// 1.5 Se seleacciona el Mes anterior al actual y se muestran los movimientos de la tarjeta correspondientes a ese mes
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			
			//1.6 descargamos los excel
			// Borramos antes el fichero si existe y luego descargamos
			String ruta = Browser.rutaPath + File.separator + "properties" + File.separator + "movimientosExtracto.xls";
			File fichero = new File(ruta);
			if (fichero.exists()) {
				fichero.delete();
			}

			Browser.waitExt(4);
			Browser.checkObjeto(btnXLSOperacionesMes);	
			Browser.clickElementSyncro(btnXLSOperacionesMes);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Descarga XLS' de los movimientos", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Descarga XLS' de los movimientos");

			//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se ha descargado el Fichero XLS", "");
			Reporting.reportOK("OK - Validamos que se ha descargado el Fichero XLS");
			

	}
	
	/**
	 * Metodo para Modificar Tipo Extracto
	 * 
	 * @return
	 * 
	 */
	public void modificarTipoExtracto() throws Exception {
	

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre extractos");	
			
			
			
			// Pulsar en el botn "Cambiar" en el recuadro "ests inscrito al extracto electrnico"
			Browser.waitExt(10);
			Browser.scrollNavegadorVertical("ABAJO");
			Browser.waitExt(5);
			Browser.clickElementSyncro(btnCambiarInscritoExtracto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botón 'Cambiar'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botón 'Cambiar'");
			
			Browser.waitExt(10);

			// Modificar el tipo de suscripcin y Pulsar en "SEGUIR"
			Browser.clickElementSyncro(checkCambiarExtractoPapel);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el check 'Cambiar a extracto en Papel'", "");
			Reporting.reportOK("OK - Se pulsa sobre el check 'Cambiar a extracto en Papel'");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botón 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botón 'Seguir'");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(confirmar);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botón 'Confirmar cambios'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botón 'Confirmar cambios'");
			
			
			
			Browser.waitExt(10);
			Browser.checkObjeto(txtOTPDatosPersonales);
			// Introducir OTP y Pulsar en "SEGUIR"
			Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(confirmar);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botón 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botón 'Seguir'");

			Browser.checkObjeto(checkCambiarExtracto);
			Reporting.reportOK("OK - Validamos que se ha cambiado el Tipo de Extracto");
		
			
	// VOLVEMOS EL DATO A SU ESTADO INICIAL - PARA FUTURAS EJECUCIONES
			Reporting.reportOK("INFO - VOLVEMOS EL DATO A SU ESTADO INICIAL - PARA FUTURAS EJECUCIONES");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnVolverExtractos);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Volver a Extractos'");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnCambiarInscritoExtracto);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Cambiar a Extracto Electronico'");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(checkCambiarExtractoElectronico);
			Reporting.reportOK("OK - Se pulsa sobre el check 'Cambiar a extracto Electronico'");
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnSeguir);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Seguir'");
			
			Browser.waitExt(10);
			Browser.checkObjeto(checkCambiarExtracto);
			Reporting.reportOK("OK - Se valida que el dato ha regresado a su estado inicial");
			

	}
	
	
	/**
	 * Metodo para Cambiar Forma de Pago
	 * 
	 * @return
	 * 
	 */
	public void cambiarFormaPago() throws Exception {
	
			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
					
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(2);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
		
			// 1.5 Pulsar en 'Cambiar forma de pago'
			Browser.waitExt(2);
			Browser.clickElementSyncro(btnCambiarFormaPagoOpcionesProducto);
			Reporting.reportOK("OK - Se pulsa en el botn 'Cambiar forma de pago'");
			
			// Seleccionar 'Pago mnimo' y Pulsar en 'SEGUIR'
			Browser.waitExt(2);
			Browser.clickElementSyncro(radioPagoMinimoCambiarFormaPago);
			Reporting.reportOK("OK - Se selecciona 'Pago mnimo' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarFormaPago);
			
			// Introducir el OTP y Pulsar en "SEGUIR"
			Browser.waitExt(2);
			Properties datosConfig = PropertyControl.getProperties("config");
			String entorno = datosConfig.getProperty("actualEnv");
			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			
			Browser.clickElementSyncro(btnSeguirCambiarFormaPago);


	}
	
	
	/**
	 * Metodo para Cambiar Cuenta Cargo
	 * 
	 * @return
	 * 
	 */
	public void  cambiarCuentaCargo() throws Exception {
		

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.waitExt(5);		
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
					
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del panel de la izquierda la opción 'Opciones'");
				
			
			// 1.5 Pulsar en "Cambiar Cuenta de domiciliación"
			Browser.waitExt(5);
			Browser.clickElementSyncro(btnCambiarCuentaDomiciliacionOpcionesProducto);
			Reporting.reportOK("OK - Se pulsa en el botón 'Cambiar Cuenta de domiciliación'");
			
			// Introducir un IBAN y pulsar en "SEGUIR"
			Browser.waitExt(5);
			String nuevoIBAN = "ES2001499948810144233424";
			Browser.writeTextSyncro(txtIBANCambiarCuentaCargo, nuevoIBAN);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el nuevo Código IBAN y posteriormente se pulsa en 'Seguir'", "");
			Reporting.reportOK("OK - Se introduce el nuevo Cdigo IBAN y posteriormente se pulsa en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarCuentaCargo);
			
			// Introducir el OTP y pulsar en "SEGUIR"
			Browser.waitExt(5);
			Properties datosConfig = PropertyControl.getProperties("config");
			String entorno = datosConfig.getProperty("actualEnv");
			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarCuentaCargo);
			

			Reporting.reportOK("OK - TEXTO OK");

	}
	
	/**
	 * Metodo para Hacer Ingreso
	 * 
	 * @return
	 * 
	 */
	public void hacerIngreso() throws Exception {

			
			// Pulsar en 'Hacer un Ingreso'
			Browser.waitExt(5);
			Browser.clickElementSyncro(btnHacerUnIngresoOpcionesProducto);
			Reporting.reportOK("OK - Se pulsa en el botn 'Hacer un Ingreso'");
			
			//Pulsar en 'Hacer pago online'
			Browser.waitExt(5);
			Browser.clickElementSyncro(btnAccederPagoOnline);
			Reporting.reportOK("OK - Se pulsa en el botn 'Accede a pago Online'");
			
			//Pulsar en 'otro importe'
			//Browser.clickElementSyncro(chkOtroImporte);
			Reporting.reportOK("OK - Se pulsa en el botn 'Accede a pago Online'");
			
			// Introducir los datos de la tarjeta 'importe' 'Nombre' 'Cvv' 'Fecha Caducidad' 'Numero Tarjeta'
			Browser.waitExt(20);
			String importe = "10";
			String titular = "Ricardo Bernardos Camino";
			String numeroTarjeta = "5267 5209 1031 2903";
			String cvv = "082";
			String fechaCaducidad = "05/23";
			
			Browser.writeTextSyncro(txtOtraCantidad, importe);
			Browser.writeTextSyncro(txtNombreCliente, titular);
			Browser.writeTextSyncro(txtNumeracionTarjeta, numeroTarjeta);
			Browser.writeTextSyncro(txtCvv, cvv);
			Browser.writeTextSyncro(txtFechaCaducidad, fechaCaducidad);
			
			
			//Hacer click en el botn realizar pagos
			Browser.waitExt(5);
			Browser.clickElementSyncro(btnRealizarPago);
			
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introducen los datos de forma correcta y pulsamos el botn 'Realizar pago'", "");
			Reporting.reportOK("OK - Se introducen los datos de forma correcta y pulsamos el botn 'Realizar pago'");
			
			//Reporting.reportOK("OK - TEXTO OK");
	
	}
	
	
	/**
	 * Metodo para ver cvv
	 * 
	 * @return
	 * 
	 */
	public void verNumCVVTarjeta() throws Exception {

		
			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
		Browser.waitExt(20);	
		Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
					
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// 1.5 Pulsar en "Ver nmero y CVV de mi tarjeta"
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnConsultarNumCVVOpcionesProducto);
			Reporting.reportOK("OK - Se pulsa en 'Ver nmero y CVV de mi tarjeta'");
			
			// Introducir el OTP y pulsamos en "SEGUIR"	
			Browser.waitExt(10);
			Properties datosConfig = PropertyControl.getProperties("config");
			String entorno = datosConfig.getProperty("actualEnv");
			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirVerNumCVVTarjeta);
			
			// Se valida que se muestra el Num de Tarjeta
			Browser.waitExt(10);
			boolean check1 = Browser.checkObjeto(checkNumTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el Nm de mi tarjeta'", "");
			Reporting.reportOK("OK - Se muestra el Nm de mi tarjeta'");
			
			// Pulsamos en Mas Info para ver el CVV de la Tarjeta
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnMasInfoCVV);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en 'Ms Info' para ver CVV de mi tarjeta'", "");
			Reporting.reportOK("OK - Se pulsa en 'Ms Info' para ver CVV de mi tarjeta'");
			
			// Se valida que se muestra el CVV de Tarjeta
			Browser.waitExt(10);
			boolean check2 = Browser.checkObjeto(checkCVVTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el Nm de mi tarjeta'", "");
			Reporting.reportOK("OK - Se muestra el Nm de mi tarjeta'");
			
			if (check1 && check2) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra tanto el 'Nmero y CVV' de mi tarjeta", "");
				Reporting.reportOK("OK - Se muestra tanto el 'Nmero y CVV' de mi tarjeta");
				
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se muestra tanto el 'Nmero y CVV' de mi tarjeta", "");
				Reporting.reportKO("KO - No se muestra tanto el 'Nmero y CVV' de mi tarjeta");
				
			}

	}
	
	
	/**
	 * Metodo para Hacer Ingreso
	 * 
	 * @return
	 * 
	 */
	public void consultarPIN() throws Exception {
		
			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.waitExt(20);	
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
		
			// Pulsar en "Consultar PIN"
			
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnConsultaPINOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en 'Consultar PIN'", "");
			Reporting.reportOK("OK - Se pulsa en 'Consultar PIN'");
			
			// Introducir el OTP y pulsamos en "SEGUIR"
			Browser.waitExt(10);
			Properties datosConfig = PropertyControl.getProperties("config");
			String entorno = datosConfig.getProperty("actualEnv");
			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
				break;
			case "PRO":
				Thread.sleep(8000);
				Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirConsultarPIN);
			
			// Pulsamos en 'Mostrar el Pin de tu Tarjeta'
			Browser.waitExt(10);
			Browser.checkObjeto(btnMostrarPIN);			
			Browser.clickElementSyncro(btnMostrarPIN);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Mostrar el Pin de tu Tarjeta'", "");
			Reporting.reportOK("OK - Pulsamos en 'Mostrar el Pin de tu Tarjeta'");
			
			
			if (Browser.checkObjeto(imagenPIN)	) {
				Reporting.reportOK("OK - Se muestra el PIN de la Tarjeta");
			} else {
				Reporting.reportKO("KO - No se muestra el PIN de la Tarjeta");
			}
			

	}
	
	
	
	/**
	 * Metodo para Bloquear Tarjeta
	 * 
	 * @return
	 * 
	 */
	public void bloquearTarjeta() throws Exception {
		

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.waitExt(20);	
			Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
					
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);	
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			//1.5 Pulsar en "Bloquear la tarjeta"
			Browser.waitExt(10);	
			Browser.clickElementSyncro(btnBloquearTarjeta);
			Reporting.reportOK("OK - Pulsamos en 'Bloquear la tarjeta'");
			
			// Seleccionar 'Me la han robado'
			//Browser.clickElementSyncro(radioMeHanRobadoTarjeta);
			//Reporting.reportOK("OK - Se selecciona la opcion 'Me la han robado'");
			
			// Pulsar en "Seguir"
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnSeguir);
			Reporting.reportOK("OK - Pulsamos en 'Seguir'");
			
			// Pulsar en "ACEPTAR"
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnSeguir);
			Reporting.reportOK("OK - Pulsamos en 'Aceptar para finalizar el envio'");


	}
	/**
	 * Metodo para reenvo de la tarjeta
	 * 
	 * @return
	 * 
	 */
	public void reenviarTarjeta() throws Exception {
		

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
		Browser.waitExt(20);	
		Browser.clickElementSyncro(btnDetalleProducto);
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
					
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(20);	
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// 1.5 iniciamos el proceso de "Reenvío de tarjeta"
			Browser.waitExt(10);
			Browser.clickElementSyncro(btnReenvioTarjeta);
			Reporting.reportOK("OK - Pulsamos en 'Reenviar la tarjeta'");
			
			// Pulsar en "seguir"
			Browser.waitExt(10);

			Properties datosConfig = PropertyControl.getProperties("config");
			String entorno = datosConfig.getProperty("actualEnv");
			boolean direccion = false;
			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":

				break;
			case "PRO":
				direccion = Browser.checkFieldText(txtDirecciónEnvio, "Prueba123 1, B 8 3 A\n" + 
						"09007 BURGOS\n" + 
						"BURGOS - ESP");
				if(direccion) {
					Reporting.reportOK("OK - Verificamos la dirección de envío");
				} else {
					Reporting.reportKO("KO - Verificamos la dirección de envío");
				}
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			
			
			
			

			switch (entorno) {
			case "DES":
				
				break;
			case "PRE":
				Browser.clickElementSyncro(btnSeguirReenvio);
				Reporting.reportOK("OK - Pulsamos en 'Seguir'");
				// Introducir OTP y Pulsar en "SEGUIR"
				Browser.checkObjeto(txtOTPDatosPersonales);		
				Browser.waitExt(10);
				Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
				break;
			case "PRO":
				//En PRO no introducimos el código OTP
				//Thread.sleep(8000);
				//Reporting.reportOK("Código OTP (PRO):" + Utilidades.getOTP(Utilidades.readEmail()));
				//Browser.introduceCodigoOTP(txtOTPDatosPersonales, Utilidades.getOTP(Utilidades.readEmail()));
				break;
			default:
				System.out.println("No se ha indicado un entorno valido");
				break;
			}
			//Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			


	}

}
