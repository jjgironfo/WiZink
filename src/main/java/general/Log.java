package general;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


public class Log {

	private static final Logger LOGGER = LogManager.getLogger();

	public Log() {
		Configurator.setRootLevel(Level.INFO);
	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * 
	 * @param msn - String
	 */
	public static void info(String msn) {
		Configurator.setRootLevel(Level.INFO);
		LOGGER.info(msn);
	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * 
	 * @param msn - String
	 */
	public static void info(Exception e) {
		Configurator.setRootLevel(Level.INFO);
		LOGGER.info(e);
	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * reportaTraza method is executed for OK case
	 * 
	 * @param msn - String
	 */
	public void loggerOK(String testCase, String msn) {
		logger(testCase, "INFO", "OK", msn);
	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * reportaTraza method is executed for OK case
	 * 
	 * @param msn - String
	 */
	public void loggerKO(String testCase, String msn) {
		logger(testCase, "ERROR", "KO", msn);

	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * reportaTraza method is executed for OK case
	 * 
	 * @param msn - String
	 */
	private void logger(String testCase, String level, String result, String msn) {
		try {
			LOGGER.info(msn);
		} catch (Exception e) {
			logger(e);
		}

	}

	/**
	 * Method used instead of println for the console output of the error messages
	 * 
	 * @param e - Exception
	 */
	public void logger(Exception e) {
		LOGGER.info(e);
	}

}