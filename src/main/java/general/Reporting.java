package general;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;



public class Reporting {
	
	// vars
		private static final String REPORTXT = "\\** PRUEBA ";
		private static String testCaseName;
		private static boolean testOK;

		//private static HashMap<String, String> datos;

		private Reporting() {
			throw new IllegalStateException("Utility class");
		}

		/**
		 * Constructor
		 * 
		 * @param testCaseName {String} the name of the test case
		 * @author Pablo Muñoz
		 * @throws Exception
		 */
		public static void initializeReporting(String testCase) throws Exception {
			setTestCaseName(testCase);
			testOK = false;
		}

		/**
		 * Report the specified text trace (INFO)
		 * 
		 * @param msg {String} the report text
		 * @throws Exception
		 * @author Pablo Muñoz
		 */
		@Step("OK - {msg}")
		public static void reportOK(String msg) throws Exception {
			// print text
			Log.info(msg);

			// Assert
			Assert.assertEquals(true, true);
		}

		/**
		 * Report the specified text trace (ERROR)
		 * 
		 * @param msg {String} the report text
		 * @throws Exception
		 * @author Pablo Muñoz
		 */
		public static void reportKO(String msg) throws Exception {
			// print text
			Log.info(msg);
			
			// Assert
			Assert.assertEquals(true, false);
		}


		/**
		 * Report result from TC execution OK
		 * 
		 * @throws Exception
		*/
		public static void reportResultOK() throws Exception {
			// this method means test ends successfully
			testOK = true;

			// make a last reportOK
			Reporting.reportOK(REPORTXT + getTestCaseName() + ": OK **/");
		}

		/**
		 * Report result from TC execution KO
		 * 
		 * @throws Exception
		*/
		public static void reportResultKO() throws Exception {
			// this method means test ends successfully
			testOK = false;

			// make a last reportOK
			Reporting.reportKO(REPORTXT + getTestCaseName() + ": KO **/");
		}
		
		/**
		 * Report final result from TC execution
		 * 
		 * @throws Exception
		 */
		public static void reportResultFinal() throws Exception {
			
			// report result
			if(testOK) {
				
				// report the last OK trace
				Reporting.reportOK(REPORTXT + getTestCaseName() + ": OK **/");
				
			}else {

				// report a KO trace
				Reporting.reportKO(REPORTXT + getTestCaseName() + ": KO **/");
				
				// report the result of the test case
				Reporting.reportResultKO();
			}

			// anywhere we throw a final Log
			Log.info("Cerramos el navegador");
		}


		
		public static String getTestCaseName() {
			return testCaseName;
		}

		public static void setTestCaseName(String testCaseName) {
			Reporting.testCaseName = testCaseName;
		}
		
		/**
		 * Report the title of the testCase
		 * 
		 * @throws Exception
		 * @author Pablo Muñoz
		 */
		public static void reportInitialOK() throws Exception {
			reportOK("*** EJECUCIÓN PRUEBA: " + testCaseName + " ***");
		}


}
