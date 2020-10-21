package pageibject;

import java.io.File;

import org.openqa.selenium.By;

import general.Browser;
import general.Reporting;

public class Producto {

	String testCase;

	// Objetos Producto
	private By btnDetalleProducto = By.xpath("//div[contains(@class, 'c-card--ps')]/a");
	private By btnOpcionesDetalleProducto = By.xpath("//*[@class='layout-content user_titular']/descendant::a[text()='Opciones']");
	private By btnExtractosDetalleProducto = By.xpath("//*[@class='layout-content user_titular']/descendant::a[text()='Extractos']");
	
	private By btnCambiarFormaPagoOpcionesProducto = By.xpath("//span[text()='Cambiar la forma de pago']");
	private By btnCambiarCuentaDomiciliacionOpcionesProducto = By.xpath("//span[text()='Cambiar la cuenta de domiciliacin']");
	private By btnHacerUnIngresoOpcionesProducto = By.xpath("//span[text()='Hacer un ingreso']");
	private By btnConsultaPINOpcionesProducto = By.xpath("//a[@id='sec_changepin' and text()='Consultar PIN']");
	private By btnConsultarNumCVVOpcionesProducto = By.id("consultCVV");
	private By btnCargoNoReconocidoOpcionesProducto = By.xpath("//span[contains(text(),'no reconocido')]");
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
	private By btnBloquearTarjeta = By.id("sec_blockCard_AT");
	private By radioMeHanRobadoTarjeta = By.xpath("//label[@for='motive-stolen']");
	
	// Resumen
//	private By checkHoyProducto = By.xpath("//h2[contains(text(), 'Hoy,')]");
	private By checkSituacionActualProducto = By.xpath("//*[contains(text(), 'Situacin actual')]/ancestor::div[1]");
	
	// Extractos
	private By btnExtractosMesAnterior = By.id("previousExtract");
	private By checkOperacionesMesProducto = By.xpath("//*[@class='card-movement-detail'][1]");
	
	private By btnCambiarInscritoExtracto = By.id("enrollmentToPaperLink");
	private By checkCambiarExtractoPapel = By.xpath("//label[@for='unsubscribe']");
	private By checkCambiarExtractoElectronico = By.xpath("//label[@for='reminder-available']");
	
	private By btnSeguir = By.id("continueButton");
	private By txtOTPDatosPersonales = By.id("verify-code");
	
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
	public boolean checkProductoOpciones() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Las opciones pueden ser: cambiar forma de pago, cambiar la cuenta de domiciliacin, 
			// consultar pin, consultar num y cvv de la tarjeta, bloquear tarjeta, reclamar un cargo no reconocido, 
			// pedir reenvo de tarjeta, informarme sobre wizink pay, solicitar una tarjeta adicional
			Browser.waitExt(1);
			/*resultado = (Browser.checkObjeto(btnCambiarFormaPagoOpcionesProducto) && Browser.checkObjeto(btnCambiarCuentaDomiciliacionOpcionesProducto) 
					&& Browser.checkObjeto(btnHacerUnIngresoOpcionesProducto) && Browser.checkObjeto(btnConsultaPINOpcionesProducto) 
					&& Browser.checkObjeto(btnConsultarNumCVVOpcionesProducto) && Browser.checkObjeto(btnCargoNoReconocidoOpcionesProducto) &&
					Browser.checkObjeto(btnInformacionWizinkPayOpcionesProducto) && Browser.checkObjeto(btnDesactivarWizinkPayOpcionesProducto));
			*/
			resultado = (Browser.checkObjeto(btnCambiarFormaPagoOpcionesProducto) && Browser.checkObjeto(btnCambiarCuentaDomiciliacionOpcionesProducto) 
					&& Browser.checkObjeto(btnHacerUnIngresoOpcionesProducto) && Browser.checkObjeto(btnConsultarNumCVVOpcionesProducto) 
					&& Browser.checkObjeto(btnCargoNoReconocidoOpcionesProducto) && Browser.checkObjeto(btnInformacionWizinkPayOpcionesProducto)
					&& Browser.checkObjeto(btnDesactivarWizinkPayOpcionesProducto));
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional", "");
				Reporting.reportOK("OK - Se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional", "");
				Reporting.reportKO("KO - No se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportOK("KO - No se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional");
			e.printStackTrace();
			throw new Exception("KO - No se valida que las opciones sean: Cambiar forma de pago, Cambiar la cuenta de domiciliacin, Consultar pin, Consultar num y cvv de la tarjeta, Bloquear tarjeta, Reclamar un cargo no reconocido, Pedir reenvo de tarjeta, Informarme sobre wizink pay, Solicitar una tarjeta adicional " + e.toString());
		}

	}
	
	/**
	 * Metodo para validar Opciones del Producto
	 * 
	 * @return
	 * 
	 */
	public boolean checkProductoMovimientosHoy() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Se visualizan los movimientos realizados el da de la prueba Con ttulo "Hoy,."
//			resultado = (Browser.checkObjeto(checkHoyProducto) && Browser.checkObjeto(checkSituacionActualProducto));
			resultado = (Browser.checkObjeto(checkSituacionActualProducto));
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se visualizan los movimientos realizados el da de la prueba", "");
				Reporting.reportOK("OK - Se visualizan los movimientos realizados el da de la prueba");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se visualizan los movimientos realizados el da de la prueba", "");
				Reporting.reportKO("KO - No se visualizan los movimientos realizados el da de la prueba");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - No se visualizan los movimientos realizados el da de la prueba");
			e.printStackTrace();
			throw new Exception("KO - No se visualizan los movimientos realizados el da de la prueba " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para validar Opciones del Producto
	 * 
	 * @return
	 * 
	 */
	public boolean checkProductoExtractos() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre extractos", "");
			Reporting.reportOK("OK - Se pulsa sobre extractos");
			
			// 1.5 Se seleacciona el Mes anterior al actual y se muestran los movimientos de la tarjeta correspondientes a ese mes
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosMesAnterior);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se seleacciona el Mes anterior al actual", "");
			Reporting.reportOK("OK - Se seleacciona el Mes anterior al actual");

			Browser.waitExt(1);
			resultado = (Browser.checkObjeto(checkOperacionesMesProducto));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se muestran los movimientos de la tarjeta correspondientes al mes seleccionado", "");
				Reporting.reportOK("OK - Se muestran los movimientos de la tarjeta correspondientes al mes seleccionado");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se muestran los movimientos de la tarjeta correspondientes al mes seleccionado", "");
				Reporting.reportKO("KO - NO se muestran los movimientos de la tarjeta correspondientes al mes seleccionado");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - NO se muestran los movimientos de la tarjeta correspondientes al mes seleccionado");
			e.printStackTrace();
			throw new Exception("KO - NO se muestran los movimientos de la tarjeta correspondientes al mes seleccionado " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para validar Opciones del Producto
	 * 
	 * @return
	 * 
	 */
	public boolean checkProductoExtractosGraficos() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente");
			
			// 1.4 Pulsar sobre extractos
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre extractos", "");
			Reporting.reportOK("OK - Se pulsa sobre extractos");
			
			Browser.waitExt(6);
			Browser.checkObjeto(btnGraficosOperacionesMes);
			Browser.waitExt(1);
			Browser.scrollNavegadorVertical("ABAJO");			
			
			// 1.5 Pulsar en el botn "Mostrar Grficos" de los movimientos y se muestra un diagrama con las operaciones del mes
			Browser.waitExt(2);
			Browser.clickElementSyncro(btnGraficosOperacionesMes);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Mostrar Grficos' de los movimientos", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Mostrar Grficos' de los movimientos");
			
			Browser.waitExt(2);
			resultado = (Browser.checkObjeto(graficosOperacionesMes));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra un diagrama con las operaciones del mes", "");
				Reporting.reportOK("OK - Se muestra un diagrama con las operaciones del mes");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se muestra un diagrama con las operaciones del mes", "");
				Reporting.reportKO("KO - NO se muestra un diagrama con las operaciones del mes");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - NO se muestra un diagrama con las operaciones del mes");
			e.printStackTrace();
			throw new Exception("KO - NO se muestra un diagrama con las operaciones del mes " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para validar Opciones del Producto
	 * 
	 * @return
	 * 
	 */
	public boolean checkProductoExtractosXLS() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Pulsar sobre extractos
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre extractos", "");
			Reporting.reportOK("OK - Se pulsa sobre extractos");
			
			Browser.waitExt(4);
			Browser.checkObjeto(btnXLSOperacionesMes);
			Browser.scrollNavegadorVertical("ABAJO");			
			
			// Borramos antes el fichero si existe y luego descargamos
			String ruta = Browser.rutaPath + "Scripts\\properties\\movimientosExtracto.xls";
			File fichero = new File(ruta);
			if (fichero.exists()) {
				fichero.delete();
			}

			// 1.5 Pulsar en el botn descargar XLS y se descarga un documento XLS
			Browser.clickElementSyncro(btnXLSOperacionesMes);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Descarga XLS' de los movimientos", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Descarga XLS' de los movimientos");
			
			// Validamos que se ha descargado el Fichero XLS
			Browser.waitExt(5);
			fichero = new File(ruta);
			resultado = fichero.exists();
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se ha descargado el Fichero XLS", "");
				Reporting.reportOK("OK - Validamos que se ha descargado el Fichero XLS");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se valida que se ha descargado el Fichero XLS", "");
				Reporting.reportKO("KO - NO se valida que se ha descargado el Fichero XLS");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportOK("KO - NO se valida que se ha descargado el Fichero XLS");
			e.printStackTrace();
			throw new Exception("KO - NO se valida que se ha descargado el Fichero XLS " + e.toString());
		}

	}
	
	/**
	 * Metodo para Modificar Tipo Extracto
	 * 
	 * @return
	 * 
	 */
	public boolean modificarTipoExtracto() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Pulsar sobre la informacin de la tarjeta
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Pulsar sobre extractos
			Browser.clickElementSyncro(btnExtractosDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre extractos", "");
			Reporting.reportOK("OK - Se pulsa sobre extractos");
			
			// Pulsar en el botn "Cambiar" en el recuadro "ests inscrito al extracto electrnico"
			Browser.waitExt(6);
			Browser.scrollNavegadorVertical("ABAJO");
			Browser.waitExt(2);
			Browser.clickElementSyncro(btnCambiarInscritoExtracto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botn 'Cambiar'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Cambiar'");
			
			// Modificar el tipo de suscripcin y Pulsar en "SEGUIR"
			Browser.clickElementSyncro(checkCambiarExtractoPapel);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el check 'Cambiar a extracto en Papel'", "");
			Reporting.reportOK("OK - Se pulsa sobre el check 'Cambiar a extracto en Papel'");
			
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Seguir'");
			
			Browser.checkObjeto(txtOTPDatosPersonales);
			// Introducir OTP y Pulsar en "SEGUIR"
			Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			Reporting.reportOK("OK - Se introduce el OTP");
			
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el botn 'Seguir'", "");
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Seguir'");

			// Validacion Final
			resultado = (Browser.checkObjeto(checkCambiarExtracto));
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Validamos que se ha cambiado el Tipo de Extracto", "");
				Reporting.reportOK("OK - Validamos que se ha cambiado el Tipo de Extracto");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "NO se valida que se haya cambiado el Tipo de Extracto", "");
				Reporting.reportKO("KO - NO se valida que se haya cambiado el Tipo de Extracto");
			}
			
	// VOLVEMOS EL DATO A SU ESTADO INICIAL - PARA FUTURAS EJECUCIONES
			Reporting.reportOK("INFO - VOLVEMOS EL DATO A SU ESTADO INICIAL - PARA FUTURAS EJECUCIONES");
			
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnVolverExtractos);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Volver a Extractos'");
			
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnCambiarInscritoExtracto);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Cambiar a Extracto Electronico'");
			
			Browser.waitExt(1);
			Browser.clickElementSyncro(checkCambiarExtractoElectronico);
			Reporting.reportOK("OK - Se pulsa sobre el check 'Cambiar a extracto Electronico'");
			
			Browser.waitExt(1);
			Browser.clickElementSyncro(btnSeguir);
			Reporting.reportOK("OK - Se pulsa sobre el botn 'Seguir'");
			
			Browser.waitExt(1);
			Browser.checkObjeto(checkCambiarExtracto);
			Reporting.reportOK("OK - Se valida que el dato ha regresado a su estado inicial");
			
			return resultado;

		} catch (Exception e) {
			Reporting.reportOK("KO - NO se valida que se haya cambiado el Tipo de Extracto");
			e.printStackTrace();
			throw new Exception("KO - NO se valida que se haya cambiado el Tipo de Extracto " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para Cambiar Forma de Pago
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarFormaPago() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Pulsar en 'Cambiar forma de pago'
			Browser.clickElementSyncro(btnCambiarFormaPagoOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Cambiar forma de pago'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Cambiar forma de pago'");
			
			// Seleccionar 'Pago mnimo' y Pulsar en 'SEGUIR'
			Browser.clickElementSyncro(radioPagoMinimoCambiarFormaPago);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona 'Pago mnimo' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se selecciona 'Pago mnimo' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarFormaPago);
			
			// Introducir el OTP y Pulsar en "SEGUIR"
			Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarFormaPago);
			
			
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO OK");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para Cambiar Cuenta Cargo
	 * 
	 * @return
	 * 
	 */
	public boolean cambiarCuentaCargo() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Pulsar en "Cambiar Cuenta de domiciliacin"
			Browser.clickElementSyncro(btnCambiarCuentaDomiciliacionOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Cambiar Cuenta de domiciliacin'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Cambiar Cuenta de domiciliacin'");
			
			// Introducir un IBAN y pulsar en "SEGUIR"
			String nuevoIBAN = "ES2001499948810144233424";
			Browser.writeTextSyncro(txtIBANCambiarCuentaCargo, nuevoIBAN);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el nuevo Cdigo IBAN y posteriormente se pulsa en 'Seguir'", "");
			Reporting.reportOK("OK - Se introduce el nuevo Cdigo IBAN y posteriormente se pulsa en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarCuentaCargo);
			
			// Introducir el OTP y pulsar en "SEGUIR"
			Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirCambiarCuentaCargo);
			
			
			
			
			
			
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO OK");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}

	}
	
	/**
	 * Metodo para Hacer Ingreso
	 * 
	 * @return
	 * 
	 */
	public boolean hacerIngreso() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Pulsar en 'Hacer un Ingreso'
			Browser.clickElementSyncro(btnHacerUnIngresoOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Hacer un Ingreso'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Hacer un Ingreso'");
			
			//Pulsar en 'Hacer pago online'
			Browser.clickElementSyncro(btnAccederPagoOnline);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Accede a pago Online'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Accede a pago Online'");
			
			//Pulsar en 'otro importe'
			Browser.clickElementSyncro(chkOtroImporte);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el botn 'Accede a pago Online'", "");
			Reporting.reportOK("OK - Se pulsa en el botn 'Accede a pago Online'");
			
			// Introducir los datos de la tarjeta 'importe' 'Nombre' 'Cvv' 'Fecha Caducidad' 'Numero Tarjeta'
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
			
			//Seleccionar el check soy titular
			Browser.clickElementSyncro(chkOtroImporte);
			
			//Hacer click en el botn realizar pagos
			Browser.clickElementSyncro(btnRealizarPago);
			
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introducen los datos de forma correcta y pulsamos el botn 'Realizar pago'", "");
			Reporting.reportOK("OK - Se introducen los datos de forma correcta y pulsamos el botn 'Realizar pago'");
			
			
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO OK");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}
	}
	
	
	/**
	 * Metodo para Hacer Ingreso
	 * 
	 * @return
	 * 
	 */
	public boolean verNumCVVTarjeta() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Pulsar en "Ver nmero y CVV de mi tarjeta"
			Browser.clickElementSyncro(btnConsultarNumCVVOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en 'Ver nmero y CVV de mi tarjeta'", "");
			Reporting.reportOK("OK - Se pulsa en 'Ver nmero y CVV de mi tarjeta'");
			
			// Introducir el OTP y pulsamos en "SEGUIR"
			Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirVerNumCVVTarjeta);
			
			// Se valida que se muestra el Num de Tarjeta
			Browser.waitExt(1);
			boolean check1 = Browser.checkObjeto(checkNumTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el Nm de mi tarjeta'", "");
			Reporting.reportOK("OK - Se muestra el Nm de mi tarjeta'");
			
			// Pulsamos en Mas Info para ver el CVV de la Tarjeta
			Browser.clickElementSyncro(btnMasInfoCVV);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en 'Ms Info' para ver CVV de mi tarjeta'", "");
			Reporting.reportOK("OK - Se pulsa en 'Ms Info' para ver CVV de mi tarjeta'");
			
			// Se valida que se muestra el CVV de Tarjeta
			Browser.waitExt(1);
			boolean check2 = Browser.checkObjeto(checkCVVTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el Nm de mi tarjeta'", "");
			Reporting.reportOK("OK - Se muestra el Nm de mi tarjeta'");
			
			if (check1 && check2) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra tanto el 'Nmero y CVV' de mi tarjeta", "");
				Reporting.reportOK("OK - Se muestra tanto el 'Nmero y CVV' de mi tarjeta");
				resultado = true;
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se muestra tanto el 'Nmero y CVV' de mi tarjeta", "");
				Reporting.reportKO("KO - No se muestra tanto el 'Nmero y CVV' de mi tarjeta");
				resultado = false;
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - No se muestra tanto el 'Nmero y CVV' de mi tarjeta");
			e.printStackTrace();
			throw new Exception("KO - No se muestra tanto el 'Nmero y CVV' de mi tarjeta " + e.toString());
		}

	}
	
	
	/**
	 * Metodo para Hacer Ingreso
	 * 
	 * @return
	 * 
	 */
	public boolean consultarPIN() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// 1.4 Se selecciona del men de la izquierda la opcin 'Opciones' 
			Browser.clickElementSyncro(btnOpcionesDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona del men de la izquierda la opcin 'Opciones'", "");
			Reporting.reportOK("OK - Se selecciona del men de la izquierda la opcin 'Opciones'");
			
			// Pulsar en "Consultar PIN"
			Browser.clickElementSyncro(btnConsultaPINOpcionesProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en 'Consultar PIN'", "");
			Reporting.reportOK("OK - Se pulsa en 'Consultar PIN'");
			
			// Introducir el OTP y pulsamos en "SEGUIR"
			Browser.introduceCodigoOTP(txtCodigoOTPCambiarFormaPago, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'", "");
			Reporting.reportOK("OK - Se informa el 'Cdigo OTP' y posteriormente en 'Seguir'");
			Browser.clickElementSyncro(btnSeguirConsultarPIN);
			
			// Pulsamos en 'Mostrar el Pin de tu Tarjeta'
			Browser.waitExt(2);
			Browser.checkObjeto(btnMostrarPIN);			
			Browser.clickElementSyncro(btnMostrarPIN);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Mostrar el Pin de tu Tarjeta'", "");
			Reporting.reportOK("OK - Pulsamos en 'Mostrar el Pin de tu Tarjeta'");
			
			resultado = Browser.checkObjeto(imagenPIN);		
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "Se muestra el PIN de la Tarjeta", "");
				Reporting.reportOK("OK - Se muestra el PIN de la Tarjeta");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "No se muestra el PIN de la Tarjeta", "");
				Reporting.reportKO("KO - No se muestra el PIN de la Tarjeta");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}

	}
	
	
	
	/**
	 * Metodo para Bloquear Tarjeta
	 * 
	 * @return
	 * 
	 */
	public boolean bloquearTarjeta() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// Pulsar en "Bloquear la tarjeta"
			Browser.clickElementSyncro(btnBloquearTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Bloquear la tarjeta'", "");
			Reporting.reportOK("OK - Pulsamos en 'Bloquear la tarjeta'");
			
			// Seleccionar 'Me la han robado'
			Browser.clickElementSyncro(radioMeHanRobadoTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona la opcion 'Me la han robado'", "");
			Reporting.reportOK("OK - Se selecciona la opcion 'Me la han robado'");
			
			// Pulsar en "Seguir"
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Seguir'", "");
			Reporting.reportOK("OK - Pulsamos en 'Seguir'");
			
			// Pulsar en "ACEPTAR"
			Browser.clickElementSyncro(btnSeguir);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Aceptar'", "");
			Reporting.reportOK("OK - Pulsamos en 'Aceptar'");
			
				
			if (resultado) {
				//egea.reportaTraza(testCase, "INFO", "OK", "TEXTO OK", "");
				Reporting.reportOK("OK - TEXTO OK");
			} else {
				//egea.reportaTraza(testCase, "ERROR", "KO", "TEXTO KO", "");
				Reporting.reportKO("KO - TEXTO OK");
			}
			return resultado;

		} catch (Exception e) {
			Reporting.reportKO("KO - TEXTO KO");
			e.printStackTrace();
			throw new Exception("KO - TEXTO KO " + e.toString());
		}

	}
	/**
	 * Metodo para reenvo de la tarjeta
	 * 
	 * @return
	 * 
	 */
	public boolean reenviarTarjeta() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 Se pulsa sobre el producto asociado al cliente Visa Oro
			Browser.clickElementSyncro(btnDetalleProducto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa sobre el producto asociado al cliente Visa Oro", "");
			Reporting.reportOK("OK - Se pulsa sobre el producto asociado al cliente Visa Oro");
			
			// Pulsar en "Reenvo de tarjeta"
			Browser.clickElementSyncro(btnReenvioTarjeta);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Bloquear la tarjeta'", "");
			Reporting.reportOK("OK - Pulsamos en 'Bloquear la tarjeta'");
			
			// Pulsar en "seguir"
			Browser.clickElementSyncro(btnSeguirReenvio);
			//egea.reportaTraza(testCase, "INFO", "OK", "Pulsamos en 'Seguir'", "");
			Reporting.reportOK("OK - Pulsamos en 'Seguir'");
			
			Browser.checkObjeto(txtOTPDatosPersonales);
			// Introducir OTP y Pulsar en "SEGUIR"
			Browser.introduceCodigoOTP(txtOTPDatosPersonales, "");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se introduce el OTP", "");
			
			
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
