package general;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import general.Log;
import general.PathControl;
import general.PropertyControl;

public class Browser {

	// driver
	public static WebDriver driver;
	
	// driverWaits
	private static WebDriverWait elementWait;
	private static WebDriverWait screenWait;
	private static int timeDelay;
	private static Integer timeImplicitlyWait;
	
	// nav data
	private static String usedNav;
	private static boolean headless;
	private static String actualEnv = System.getProperty("entorno");

	private static Object object;
	public static String rutaPath;
	
	//OS validator
	private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    public static boolean IS_SOLARIS = (OS.indexOf("sunos") >= 0);
	public static boolean IS_UBUNTU = (OS.indexOf("lin") >= 0);
	
	/**
	 * Initialize Browser, Driver and the variables of this class
	 * 
	 * @throws Exception
	 */
	public static void start() throws Exception {
		
		// intialize nav vars
		usedNav = PropertyControl.getConfProperty("navUsed");
		headless = Boolean.parseBoolean(PropertyControl.getConfProperty("headlessMode"));
		//actualEnv = PropertyControl.getConfProperty("actualEnv");
		System.out.println("actualEnv:" + actualEnv);
		
		rutaPath = PathControl.getRootPath();
		
		// disable selenium log output 
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		/** Initialize driver */
		switch (usedNav) {
			case Final.CHROME:
				if (headless) {
					// pendiente de implementar
				}else {
					driver = startChrome();
				}
				break;
			case Final.IEXPLORER:
				if (headless) {
					// pendiente de implementar
				}else {
					// pendiente de implementar
				}
				
				break;
			case Final.FIREFOX:
				if (headless) {
					// pendiente de implementar
				}else {
					// pendiente de implementar
				}
				break;
			default:
				Log.info("No se ha indicado un navegador valido");
		}
		
		
		/** Configure driver */
		// get time values
		int elementWaitTime =  Integer.parseInt(PropertyControl.getConfProperty("elemenTimeOut"));
		int screenWaitTime =  Integer.parseInt(PropertyControl.getConfProperty("screenTimeOut"));
		int implicityWaitTime =  Integer.parseInt(PropertyControl.getConfProperty("impliciTimeOut"));
		
		// configure driver waits
		elementWait = new WebDriverWait(driver, elementWaitTime);
		screenWait = new WebDriverWait(driver, screenWaitTime);
		timeDelay = Integer.parseInt(PropertyControl.getConfProperty("timeDelay"));
		timeImplicitlyWait = Integer.parseInt(PropertyControl.getConfProperty("timeOut"));
		
		// configure windows
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicityWaitTime, TimeUnit.SECONDS);

		
		// additional configurations for headless mode
		if(usedNav.equalsIgnoreCase(Final.CHROME) && headless) {
			driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
			
		}
		//Reporting.setDriver(driver);
		
		Log.info("Se abre el navegador: " + usedNav);

	}

	/**
	 * Method that starts the driver with Chrome
	 * 
	 * @throws Exception
	 */
	private static WebDriver startChrome() throws Exception {

		// clean the last chrome navs
		cleanChrome();
		
		// property
		if (IS_WINDOWS) {
			System.setProperty("webdriver.chrome.driver", PathControl.getRootPath() + File.separator +"lib" + File.separator + "chromedriver.exe");
        } else if (IS_MAC) {
        	System.setProperty("webdriver.chrome.driver", PathControl.getRootPath() + File.separator +"lib" + File.separator + "chromedriver");
        } else if (IS_UNIX) {
        	System.setProperty("webdriver.chrome.driver", PathControl.getRootPath() + File.separator +"lib" + File.separator + "chromedriver");
        } else if (IS_SOLARIS) {
        	System.setProperty("webdriver.chrome.driver", PathControl.getRootPath() + File.separator +"lib" + File.separator + "chromedriver");
		} else if (IS_UBUNTU) {
        	System.setProperty("webdriver.chrome.driver", PathControl.getRootPath() + File.separator +"bin" + File.separator + "chromedriver");
        } else {
            System.out.println("Your OS is not support!!");
        }
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		/** Chrome Options */
		ChromeOptions options = new ChromeOptions();
		
		HashMap<String, String> datos = new HashMap<>();
		// Directorio por defecto para las descargas
		datos.put("download.default_directory", PathControl.getRootPath());
		
		// Set options
		options.setExperimentalOption("prefs", datos);
		options.addArguments("disable-gpu");
		options.addArguments("no-sandbox");
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080\"");
		options.addArguments("ignore-certificate-errors");
		
		


		// initialize driver
		
		driver = new ChromeDriver(options);
		
		return driver;

	}
	
	public static void cleanChrome() throws Exception {
		
		// get cleanMode var
		boolean cleanMode = Boolean.parseBoolean(PropertyControl.getConfProperty("cleanMode"));
		
		// check if clean Mode is activated
		if(cleanMode) {
			
			// clean Chrome
			Browser.waitExt(Final.ONE);
			Runtime.getRuntime().exec("Taskkill /F /IM chromedriver");
			Browser.waitExt(Final.ONE);
			Runtime.getRuntime().exec("Taskkill /F /IM chrome");
			Log.info("Limpiamos Chrome");
		}
		
		
	}
	

	/**
	 * Method that navigates to the URL
	 * 
	 * @throws Exception
	 */
	public static void navegar() throws Exception {
		
		// getting url
		String urlName = "URL_" + actualEnv;
		String url = PropertyControl.getLogProperty(urlName);
		
		// nav
		driver.get(url);
		
		// info msg
		Log.info("Entorno: " + actualEnv + " - Navegamos a la URL de la aplicacion: " + url);
	}

	/**
	 * Method for Logout off the application
	 * 
	 */
	public static void stopDriver() {
		String actualNav = usedNav;
		if (driver != null) {
			if (actualNav.equalsIgnoreCase(Final.FIREFOX)) {
				driver.quit();
			} else {
				driver.close();
				driver.quit();
			}
		}
	}


	/**
	 * Click on an element
	 * 
	 * @param elemento {By} Element to click
	 * @throws Exception
	 * @author Pablo Muñoz
	 */
	public static void clickElementSyncro(By elemento) {
		try {
			elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
			elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
			driver.findElement(elemento).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Fill a text field
	 * 
	 * @param elemento {By} The element to fill
	 * @param valor    {String} The value of the text
	 * @throws Exception
	 * @author Pablo Muñoz
	 */
	public static void writeTextSyncro(By elemento, String valor) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
		driver.findElement(elemento).sendKeys(valor);
	}
	
	

	/**
	 * Return the text of the selected value
	 * 
	 * @param elemento {By} The select identify
	 * @return
	 * @author Pablo Muñoz
	 */
	public static String getSelectedValueOfCombo(By elemento) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
		Select elementoSelect = new Select(driver.findElement(elemento));
		return elementoSelect.getFirstSelectedOption().getText();

	}


	/**
	 * Select a value from a combo element
	 * 
	 * @param elemento {By} The select element
	 * @param valor    {String} The value of the text
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static void selectValueByTextSyncro(By elemento, String valor) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
		Select elementoSelect = new Select(driver.findElement(elemento));
		elementoSelect.selectByVisibleText(valor);
	}

	/**
	 * Select a value from a combo element
	 * 
	 * @param elemento {By} The select element
	 * @param valor    {String} The value of the text
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static void selectValueByOrderSyncro(By elemento, int order) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
		Select elementoSelect = new Select(driver.findElement(elemento));
		elementoSelect.selectByIndex(order);
	}

	public static boolean isElementPresent(By by) {
		  try {
		    driver.findElement(by);
		    return true;
		  }
		catch (NoSuchElementException e) {
		    return false;
		  }
		}
	public static boolean isElementDisplayed(By element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	        return isElementPresent(element);
	    } catch (org.openqa.selenium.NoSuchElementException
	            | org.openqa.selenium.StaleElementReferenceException
	            | org.openqa.selenium.TimeoutException e) {
	        return false;
	    }
	 }
	
	public static void waitForElementToBeGone(By element, int timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	/**
	 * Check the value of a writable field
	 * 
	 * @param element      {By} locator of the element to check
	 * @param expectedText {String} Text that we expect the element have
	 * @param fieldName    {String} The name of the field
	 * @return return TRUE if we can check expected value is equal to element value.
	 *         Throw an Exception if it isn't
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static boolean checkFieldText(By element, String expectedText) {
		// check text
		return getText(element).equalsIgnoreCase(expectedText);

	}

	/**
	 * Return the text of an element
	 * 
	 * @param element {By} the element to click
	 * @return
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static String getText(By element) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).getText();
	}


	/**
	 * Wait for an element to be visible and clickable
	 * 
	 * @param elemento {By} The identifier of the element
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static void waitForElementSyncro(By elemento) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		elementWait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	/**
	 * Wait for an element to be visible and clickable
	 * 
	 * @param elemento {By} The identifier of the element
	 * @throws Exception
	 * @author Pablo Munoz
	 */
	public static void waitForElementScreen(By elemento) {
		screenWait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		screenWait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	

	/**
	 * Metodo que espera a la carga completa del javascript
	 */
    public static void waitForLoad() throws Exception {
        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
            screenWait.until(pageLoadCondition);
    }
	
	/**
	 * Method to wait an specific time interval
	 * 
	 * @param tiempo {Integer} interval value
	 * @throws Exception
	 */
	public static void waitExt(Integer tiempo) throws Exception {

		// get delay
		int delay = timeDelay;
		
		// default value for delay
		if(delay == 0) {
			delay = 1000;
		}
		
		// calc time to wait
		Integer calculatedTime = tiempo * delay;
		
		try {
			Thread.sleep(calculatedTime);
		} catch (InterruptedException e) {
			//Reporting.reportKO("Se ha producido un error en la espera");
			Log.info(e);
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method edit and split testCase trace string
	 * 
	 * @param trace {String}
	 * @return {String} with TC script name
	 * @author Pablo Munoz
	 */
	public static String getActualTC(String trace) {
		return trace.split("\\.")[1];
	}
	
	
	
	public static String getActualEnv() {
		return actualEnv;
	}
	
	
	
	public static WebElement getWebElement(By idElement) {
		return driver.findElement(idElement);
	}

	
	

	/**
	 * Change frame class
	 * 
	 * @throws Exception
	 * @author Jesus
	 */
	public static void changeFrame(By iframe) {
		elementWait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
		WebElement e = driver.findElement(iframe);
		driver.switchTo().frame(e);
	}
	
	/**
	 * Método que se encarga de realizar scroll al elemento pasado por parámetro
	 */
	public static void scrollNavegadorElemento(By elemento)  { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
	}
	
	/**
	 * Metodo para realizar un scroll del navegador vertical
	 * 
	 * @param   String direccion: para hacer el scroll hacia arriba o hacia abajo
	 */	
	
	public static void scrollNavegadorVertical() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}


	public static List<WebElement> getListOfElements(By listId){
		return driver.findElements(listId);
	}
	
	/**
   	 * Metodo para validar elemento y devuelve booleano
     * @return 
   	 * 
   	 */
    public static boolean checkObjeto(By elemento) throws Exception {
	   boolean resultado = false;
	   if (driver.findElements(elemento).size() != 0) {
			resultado = true;
		} else {
			resultado = false;
		}
	   return resultado;
    } 
    
    /**
	 * Metodo para realizar un scroll del navegador vertical
	 * 
	 * @param   String direccion: para hacer el scroll hacia arriba o hacia abajo
	 */	
	
	public static void scrollNavegadorVertical(String direccion) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		switch (direccion) {
		case "ARRIBA":
			js.executeScript("window.scrollTo(0, 0)");
			break;
		case "ABAJO":
			js.executeScript("window.scrollTo(0, 10000)");
			break;
		default:
			Log.info("El parametro de la direccin introducida no es correcto, las opciones son 'ARRIBA' y 'ABAJO'");
			break;
		}
	}
	
	/**
	 * Mtodo que devuelve el valor de la variable timeImplicitlyWait
	 */
	public static Integer getTimeImplicitWait() {
		return timeImplicitlyWait;
	}

	
	/**
   	 * Metodo para Sincronizar el Spinner
   	 * 
   	 */
    public static boolean cargarSpinner() throws Exception {
    	boolean resultado = false;
    	//boolean resultado = true;
    	By objetoSpinerCargando = By.xpath("//div[@class='modal-backdrop in background-backdrop']");
    	try {
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		if (driver.findElements(objetoSpinerCargando).size() != 0) {
    			waitExt(3);
    			Log.info("INFO - Se encuentra el Spinner Cargando + Se espera Tiempo");
    			resultado = true;
    		} else {
    			Log.info("INFO - No se encuentra el Spinner Cargando");
    			resultado = false;
    		}
    		driver.manage().timeouts().implicitlyWait(timeImplicitlyWait, TimeUnit.SECONDS);
    	} catch (Exception e) {
    		Log.info("INFO - Excepcion - No se encuentra el Spinner Cargando");
    	}
    	return resultado;
    }
    
    /**
   	 * Metodo Introducir el Codigo OTP
   	 * 
   	 */
    public static void introduceCodigoOTP(By elemento, String codigoOTP) throws Exception {
	   Browser.waitExt(2);
	   if (codigoOTP == "") {
			// Codigo Automatico
			//codigoOTP = "123456";
			List<LogEntry> listaConsole = Browser.driver.manage().logs().get(LogType.BROWSER).getAll();
			codigoOTP = listaConsole.toString().substring(listaConsole.toString().indexOf("Codigo SMS") + 12, listaConsole.toString().indexOf("Codigo SMS") + 18);
			System.out.println("Código OTP: "+ codigoOTP);
			Browser.writeTextSyncro(elemento, codigoOTP);
    	} else {
    		// Codigo Pasado por Parametro
    		Browser.writeTextSyncro(elemento, codigoOTP);
    	}
    }

    /**
   	 * Metodo para validar que elemento no existe y devuelve booleano
     * @return 
   	 * 
   	 */
    
    /**
   	 * Metodo Introducir el Codigo OTP
   	 * 
   	 */
    public static void introduceCodigoOTPCFP(By elemento, String codigoOTP) throws Exception {
	   Browser.waitExt(2);
	   if (codigoOTP == "") {
			// Codigo Automatico
			//codigoOTP = "123456";
			List<LogEntry> listaConsole = Browser.driver.manage().logs().get(LogType.BROWSER).getAll();
			codigoOTP = listaConsole.toString().substring(listaConsole.toString().indexOf("VM328:1 Codigo SMS:") + 3, listaConsole.toString().indexOf("VM328:1 Codigo SMS:") +18 );
			System.out.println("Código OTP: "+ codigoOTP);
			Browser.writeTextSyncro(elemento, codigoOTP);
    	} else {
    		// Codigo Pasado por Parametro
    		Browser.writeTextSyncro(elemento, codigoOTP);
    	}
    }

    /**
   	 * Metodo para validar que elemento no existe y devuelve booleano
     * @return 
   	 * 
   	 */
    
    public static boolean checkObjetoNoExiste(By elemento) throws Exception {
	   boolean resultado = false;
	   if (driver.findElements(elemento).size() == 0) {
			resultado = true;
		} else {
			resultado = false;
		}
	   return resultado;
    }
    
    /**
   	 * Metodo para esperar un elemento
   	 * 
   	 */

    public static WebElement waitForElement(By by, int timeout, String msg) throws Exception {
		WebElement elem = null;
		int i = 0;
		boolean flag = false;
		while (i < timeout && !flag) {
			try {
				elem = driver.findElement(by);
				flag = true;
			} catch (Exception e) {
				i++;
			}
			Browser.waitExt(1);
		}
		if (!flag) {
			throw new Exception("Se ha superado la espera para el elemento: " + msg);
		}
		return elem;
	}
    
    /**
	 * Metodo que espera a la carga del Objeto y pulsa Click sobre el elemento
	 * 
	 */
    public static void sincronizaObjetoSoloClick(By elemento) throws Exception {
    	cargarSpinner();
		driver.findElement(elemento).click();
    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }


}
