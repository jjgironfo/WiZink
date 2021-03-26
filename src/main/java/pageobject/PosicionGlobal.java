package pageobject;

import static general.Browser.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import general.Browser;
import general.ProjectPaths;
import general.Reporting;
import general.Utilidades;

public class PosicionGlobal extends Utilidades{

	String testCase;

	// Objetos Posicion Global
	private By btnAnadirAccesoDirecto = By.xpath("//*[text()='AÑADIR']/ancestor::a");
	
	// PopUP Accesos Directos
	private By btnAnadirAccesoDirectoPopUp = By.id("addShortcutButton");
	
	private By opcionComboAccesoPopUp = By.id("addShortcutSelectBoxIt");
	private By opcionConsultarPINPopUp= By.id("addShortcutSelectBoxItText");
	//private By opcionConsultarPINPopUp = By.xpath("//a[contains(text(),'Consultar PIN')]");
	private By btnAnadirOtroAccesoDirectoPopUp = By.id("button_añadir");
	
	private By btnAspaRojarAccesoDirectoPopUp = By.xpath("//*[@id='listaEnlaces']/li[1]/button");
	private By btnEliminarAccesoDirectoPopUp = By.xpath("//button[text()='ELIMINAR']");
	//private By ElementoAccesoDirectoPopUp = By.xpath("//*[@id='listaEnlaces']/li[text()='Consultar PIN']");
	

	/**
	 * Metodo para validar los Favoritos
	 * 
	 * @return
	 * 
	 */
	 public void checkFavoritos(String codeTC) throws Exception {
	

			// 1.3 En el apartado de Accesos directos pulsar sobre Añadir
		 	Browser.waitForElementScreen(btnAnadirAccesoDirecto);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAnadirAccesoDirecto);
			Reporting.reportOK("OK - Se pulsa en el botón 'Añadir Acceso Directo'");
			

			Browser.waitExt(1);			
			// 1.4 Se pulsa Añadir
			Browser.waitForElementScreen(btnAnadirAccesoDirectoPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnAnadirAccesoDirectoPopUp);
			Reporting.reportOK("OK - Se pulsa en el botón 'Añadir Acceso Directo PopUp'");
			Browser.waitExt(3);
			
			// 1.5 Seleccionar el Acceso: Consultar PIN y pulsar Añadir
			//Browser.waitExt(1);
			//Browser.clickElementSyncro(opcionComboAccesoPopUp);
			Browser.waitExt(1);
			Browser.waitForElementScreen(opcionConsultarPINPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(opcionConsultarPINPopUp);
			
			Browser.waitForElementScreen(btnAnadirOtroAccesoDirectoPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.waitExt(3);
			Browser.clickElementSyncro(btnAnadirOtroAccesoDirectoPopUp);
			Reporting.reportOK("OK - Se selecciona en el combo la opcion 'Consultar PIN'");
			
			// 1.6 Seleccionar uno de los accesos directos creados y pulsar el icono X para eliminarlo:
			JavascriptExecutor  js = (JavascriptExecutor ) driver;
			if (Browser.checkObjeto(btnEliminarAccesoDirectoPopUp)) {
				try {
					js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
					Browser.waitForElementScreen(btnEliminarAccesoDirectoPopUp);
					try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
						  e.printStackTrace(); }
					Browser.clickElementSyncro(btnEliminarAccesoDirectoPopUp);
				} catch (Exception e) {
					Reporting.reportKO("KO - No existe el Boton Eliminar Favoritos");
				}
			}
			//js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			Reporting.reportOK("OK - Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente");
			
			// 1.7 Se pulsa eliminar
			/*Browser.waitForElementScreen(btnEliminarAccesoDirectoPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.clickElementSyncro(btnEliminarAccesoDirectoPopUp);
			Browser.waitExt(3);
			Reporting.reportOK("OK - Se pulsa en el botón 'Eliminar'");*/
						
			// Validamos que el Aspa Roja del Acceso directo no existe
			//Browser.waitForElementScreen(btnAspaRojarAccesoDirectoPopUp);
			try { this.takeRemoteScreenshot(driver, codeTC); } catch(Exception e){
				  e.printStackTrace(); }
			Browser.checkObjetoNoExiste(btnAspaRojarAccesoDirectoPopUp);
			Reporting.reportOK("OK - Se valida se ha eliminado el Acceso Directo creado");

	}
	/**
	 * Metodo para añadir los Favoritos
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
	/**public void checkEliminarFavoritos() throws Exception {
		
			
			//1.3 En el apartado de Accesos directos pulsar sobre añadir
			Browser.clickElementSyncro(btnAnadirAccesoDirecto);
			Reporting.reportOK("OK - Se pulsa en el botón 'Añadir Acceso Directo'");
			
			JavascriptExecutor  js = (JavascriptExecutor ) driver;
			js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			Browser.clickElementSyncro(btnEliminarAccesoDirectoPopUp);
			
			// 1.6 Seleccionar uno de los accesos directos creados y pulsar el icono X para eliminarlo:
			js.executeScript("window.document.getElementsByClassName('c-shortcuts__item-close js-remove-shortcut wzicon wzicon-menu_close')[0].click();");
			Reporting.reportOK("OK - Se pulsa en el aspa Roja para eliminar el Acceso Directo creado anteriormente");
			
			// 1.7 Se pulsa eliminar
			Browser.clickElementSyncro(btnEliminarAccesoDirectoPopUp);
			//Funciones.waitExt(3);
			Reporting.reportOK("OK - Se pulsa en el botón 'Eliminar'");
						
			// Validamos que el Aspa Roja del Acceso directo no existe
			Browser.waitForElement(btnAnadirAccesoDirectoPopUp, 2, "Volviendo a añadir");
			Browser.checkObjetoNoExiste(btnAspaRojarAccesoDirectoPopUp);
		

	}**/

}
