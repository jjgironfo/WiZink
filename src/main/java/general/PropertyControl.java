package general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import general.PathControl;

public class PropertyControl {



	// constants
	public static final Properties CONF_PROPERTIES = getProperties("config");
	public static final Properties LOG_PROPERTIES = getProperties("login");
	
	
	/**
	 * Method to load the Properties files and their data
	 * 
	 * @param opcion {String}
	 * @return {Properties} prop
	 */
	public static Properties getProperties(String opcion) {

		// initialize vars
		Properties prop = new Properties();
		// it is necessary null var initializing
		File file = null;
		file = new File(PathControl.getRootPath() + "\\properties\\" + opcion + ".properties");
		// Se obtienen los bytes de entrada de un archivo en un sistema de archivos
		FileInputStream fileInput = null;

		// open file
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// load properties
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			Log.info(e);
		}
		
		
		// return properties
		return prop;
	}
	
	
	
	/**
	 * Methods for get a expecifique property
	 * @param propertyName {String} The name of the property
	 * @return
	 */
	public static String getConfProperty(String propertyName){
		return CONF_PROPERTIES.getProperty(propertyName);
	}
	public static String getLogProperty(String propertyName){
		return LOG_PROPERTIES.getProperty(propertyName);
	}

	
}
