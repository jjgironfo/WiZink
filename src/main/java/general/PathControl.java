package general;

import java.io.File;

public class PathControl {

		// constants
		private static final String ROOT_PATH = getRootDirectory();
		

		// private constructor is necessary (Sonar)
		private PathControl() {
			throw new IllegalStateException("Utility class");
		}

		/**
		 * Initialize and obtain the root directory path
		 * @return {String} root path
		 * 
		 */
		private static String getRootDirectory() {

			// initialize vars
			File rootDir = new File("");
			String path;

			// get path
			path = rootDir.getAbsolutePath();

			// return path
			return path;
		}
		

		/**
		 * Get the root path of the project
		 * 
		 * @return {String} root path
		 */
		public static String getRootPath(){
			return ROOT_PATH;
		}

		/** 
		 * Get download path 
		 * 
		 * @return {String} download path
		 */
		public static String getDownloadPath() {

			// generate download Path
			return ROOT_PATH +  PropertyControl.getConfProperty("downloadPath");

		}

		/** 
		 * Get file path
		 * 
		 * @return {String} file path
		 */
		public static String getfilePath() {

			// generate file Path
			return ROOT_PATH +  PropertyControl.getConfProperty("filePath");

		}

		/** 
		 * Get resource path
		 * 
		 * @return {String} resource path
		 */
		public static String getResourcePath() {

			// generate resource Path
			return ROOT_PATH +  PropertyControl.getConfProperty("resourcePath");

		}
	

}
