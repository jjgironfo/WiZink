package pageibject;

import static general.Browser.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import general.ProjectPaths;

public class PosicionGlobal {

	String testCase;

	// Objetos Posicion Global
	private By btnAnadirAccesoDirecto = By.xpath("//*[text()='A�ADIR']/ancestor::a");
	
	// PopUP Accesos Directos
	private By btnAnadirAccesoDirectoPopUp = By.id("addShortcutButton");
	
	private By opcionComboAccesoPopUp = By.id("addShortcutSelectBoxIt");
	private By opcionConsultarPINPopUp=By.xpath("//*[@id='addShortcutSelectBoxItOptions']/*[@data-id='0']");
	//private By opcionConsultarPINPopUp = By.xpath("//a[contains(text(),'Consultar PIN')]");
	private By btnAnadirOtroAccesoDirectoPopUp = By.id("button_a�adir");
	
	private By btnAspaRojarAccesoDirectoPopUp = By.xpath("//*[@id='listaEnlaces']/li[1]/button");
	private By btnEliminarAccesoDirectoPopUp = By.xpath("//button[text()='ELIMINAR']");
	//private By ElementoAccesoDirectoPopUp = By.xpath("//*[@id='listaEnlaces']/li[text()='Consultar PIN']");
	

	/**
	 * Metodo para validar los Favoritos
	 * 
	 * @return
	 * 
	 */
	/**ublic boolean checkFavoritos() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 En el apartado de Accesos directos pulsar sobre A�adir
			ProjectPaths.sincronizaObjetoClick(btnAnadirAccesoDirecto);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'A�adir Acceso Directo'", "");
			System.out.println("OK - Se pulsa en el bot�n 'A�adir Acceso Directo'");
			
			JavascriptExecutor  js = (JavascriptExecutor ) driver;
			if (ProjectPaths.checkObjeto(btnEliminarAccesoDirectoPopUp)) {
				try {
					js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
					ProjectPaths.sincronizaObjetoClick(btnEliminarAccesoDirectoPopUp);
				} catch (Exception e) {
					System.out.println("No existe el Boton Eliminar Favoritos");
				}
			}
						
			// 1.4 Se pulsa A�adir
			ProjectPaths.sincronizaObjetoClick(btnAnadirAccesoDirectoPopUp);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'A�adir Acceso Directo PopUp'", "");
			System.out.println("OK - Se pulsa en el bot�n 'A�adir Acceso Directo PopUp'");
			
			// 1.5 Seleccionar el Acceso: Consultar PIN y pulsar A�adir
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoClick(opcionComboAccesoPopUp);
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoClick(opcionConsultarPINPopUp);
			ProjectPaths.sincronizaObjetoClick(btnAnadirOtroAccesoDirectoPopUp);
			egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona en el combo la opcion 'Consultar PIN'", "");
			System.out.println("OK - Se selecciona en el combo la opcion 'Consultar PIN'");
			
			// 1.6 Seleccionar uno de los accesos directos creados y pulsar el icono X para eliminarlo:
			js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente", "");
			System.out.println("OK - Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente");
			
			// 1.7 Se pulsa eliminar
			ProjectPaths.sincronizaObjetoClick(btnEliminarAccesoDirectoPopUp);
			ProjectPaths.waitExt(3);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Eliminar'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Eliminar'");
						
			// Validamos que el Aspa Roja del Acceso directo no existe
			resultado = (ProjectPaths.checkObjetoNoExiste(btnAspaRojarAccesoDirectoPopUp));
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida se ha eliminado el Acceso Directo creado", "");
				System.out.println("OK - Se valida se ha eliminado el Acceso Directo creado");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida se ha eliminado el Acceso Directo creado", "");
				System.out.println("KO - NO se valida se ha eliminado el Acceso Directo creado");
			}
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - No se valida se ha eliminado el Acceso Directo creado");
			e.printStackTrace();
			throw new Exception("KO - No se valida se ha eliminado el Acceso Directo creado " + e.toString());
		}

	}**/
	/**
	 * Metodo para a�adir los Favoritos
	 * 
	 * @return
	 * 
	 */
	/**public boolean checkAniadirFavoritos() throws Exception {
		try {
			boolean resultado = false;

			// 1.3 En el apartado de Accesos directos pulsar sobre A�adir
			ProjectPaths.sincronizaObjetoClick(btnAnadirAccesoDirecto);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'A�adir Acceso Directo'", "");
			System.out.println("OK - Se pulsa en el bot�n 'A�adir Acceso Directo'");
			
			//JavascriptExecutor  js = (JavascriptExecutor ) driver;
			//js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			//Funciones.sincronizaObjetoClick(btnEliminarAccesoDirectoPopUp);
			
			// 1.4 Se pulsa A�adir
			ProjectPaths.sincronizaObjetoClick(btnAnadirAccesoDirectoPopUp);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'A�adir Acceso Directo PopUp'", "");
			System.out.println("OK - Se pulsa en el bot�n 'A�adir Acceso Directo PopUp'");
			
			// 1.5 Seleccionar el Acceso: Consultar PIN y pulsar A�adir
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoClick(opcionComboAccesoPopUp);
			ProjectPaths.waitExt(1);
			ProjectPaths.sincronizaObjetoClick(opcionConsultarPINPopUp);
			ProjectPaths.sincronizaObjetoClick(btnAnadirOtroAccesoDirectoPopUp);
			egea.reportaTraza(testCase, "INFO", "OK", "Se selecciona en el combo la opcion 'Consultar PIN'", "");
			System.out.println("OK - Se selecciona en el combo la opcion 'Consultar PIN'");
		
			// 1.6 Seleccionar uno de los accesos directos creados y pulsar el icono X para eliminarlo:
			//js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente", "");
			//System.out.println("OK - Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente");
												
			// Validamos que existe el aspa roja de los accesos directos
			resultado = (ProjectPaths.checkObjeto(btnAspaRojarAccesoDirectoPopUp));
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida que se ha a�adido el Acceso Directo creado", "");
				System.out.println("OK - Se valida que se ha a�adido  el Acceso Directo creado");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida que se ha a�adido el Acceso Directo creado", "");
				System.out.println("KO - No se valida que se ha a�adido el Acceso Directo creado");
			}
			return resultado;

		} catch (Exception e) {
			System.out.println("KO -  No se valida que se ha a�adido el Acceso Directo creadoo");
			e.printStackTrace();
			throw new Exception("KO -  No se valida que se ha a�adido el Acceso Directo creado" + e.toString());
		}

	}**/
	/**
	 * Metodo para validar los Favoritos
	 * 
	 * @return
	 * 
	 */
	/**public boolean checkEliminarFavoritos() throws Exception {
		try {
			boolean resultado = false;
			
			//1.3 En el apartado de Accesos directos pulsar sobre A�adir
			//Funciones.sincronizaObjetoClick(btnAnadirAccesoDirecto);
			//egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'A�adir Acceso Directo'", "");
			//System.out.println("OK - Se pulsa en el bot�n 'A�adir Acceso Directo'");
			
			JavascriptExecutor  js = (JavascriptExecutor ) driver;
			//js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			//Funciones.sincronizaObjetoClick(btnEliminarAccesoDirectoPopUp);
			
			// 1.6 Seleccionar uno de los accesos directos creados y pulsar el icono X para eliminarlo:
			js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente", "");
			System.out.println("OK - Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente");
			
			// 1.7 Se pulsa eliminar
			ProjectPaths.sincronizaObjetoClick(btnEliminarAccesoDirectoPopUp);
			//Funciones.waitExt(3);
			egea.reportaTraza(testCase, "INFO", "OK", "Se pulsa en el bot�n 'Eliminar'", "");
			System.out.println("OK - Se pulsa en el bot�n 'Eliminar'");
						
			// Validamos que el Aspa Roja del Acceso directo no existe
			ProjectPaths.waitForElement(btnAnadirAccesoDirectoPopUp, 2, "Volviendo a a�adir");
			resultado = (ProjectPaths.checkObjetoNoExiste(btnAspaRojarAccesoDirectoPopUp));
			if (resultado) {
				egea.reportaTraza(testCase, "INFO", "OK", "Se valida se ha eliminado el Acceso Directo creado", "");
				System.out.println("OK - Se valida se ha eliminado el Acceso Directo creado");
			} else {
				egea.reportaTraza(testCase, "ERROR", "KO", "No se valida se ha eliminado el Acceso Directo creado", "");
				System.out.println("KO - NO se valida se ha eliminado el Acceso Directo creado");
			}
			return resultado;

		} catch (Exception e) {
			System.out.println("KO - No se valida se ha eliminado el Acceso Directo creado");
			e.printStackTrace();
			throw new Exception("KO - No se valida se ha eliminado el Acceso Directo creado " + e.toString());
		}

	}**/

}
