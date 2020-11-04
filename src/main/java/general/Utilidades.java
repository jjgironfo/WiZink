package general;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Utilidades {

	// Letras del NIF
    private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M',
            'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
            'L', 'C', 'K', 'E' };
    /**
	 * Metodo para Generar Nif
	 * 
	 * @return
	 * 
	 */
    public static String generaNif(String seed) {
        if (seed != null) {
            try {
                Integer.parseInt(seed);
            } catch (NumberFormatException ex) {
                return "KO";
            }
        } else {
            seed = "";
        }
        String numeroDNI = String.valueOf(Math.random()).concat(seed);
        String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

        int dniInt = Integer.valueOf(fullDNI);
        fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
        return fullDNI;
    }
    
    /**
	 * Metodo para Calcular la Letra del Nif
	 * 
	 * @return
	 * 
	 */
    public static String calculaLetra(String nif) {
        if (nif.length() != 8) {
            return ("Nif Invlido");
        }
        return generaNif(nif).substring(8);
    }
    
    /**
	 * Metodo para Validar Nif
	 * 
	 * @return
	 * 
	 */
    public static String validaNif(String nif) {
        if (nif.substring(0, 8).length() == 8) {
            return nif.equalsIgnoreCase(generaNif(nif.substring(0, 8))) ? "OK"
                    : "KO";
        } else {
            return ("Nif Invlido");
        }
    }
    
    
    /**
	 * Metodo para Generar CIF
	 * 
	 * @return
	 * 
	 */
	public static String generadorCIFs() {
		String cif;
		Random r = new Random();
		int sumaPares = 0;
		int sumaInpares = 0;
		int sumaTotal;
		char[] LetraDigCont = "JABCDEFGHI".toCharArray();
		// Obtener la primera letra del CIF
		char[] letras = "ABCDEFGHJNPQRSUVW".toCharArray();
		int charsLength = letras.length;
		char letra = letras[r.nextInt(charsLength)];
		cif = String.valueOf(letra);
		// Random para obtener un numero aleatorio y montar una cadena de 7 caracteres
		for (int i = 1; i < 8; i++) {
			int value = r.nextInt(10);
			if (i % 2 == 0) { 
				// comprobamos si es un numero Par, si lo es sumamos el valor
				sumaPares = sumaPares + value;
			} else { 
				// si es impar realizamos multiplicamos por 2 y luego comprobamos si tiene dos cifras
				String resultado = Integer.toString(value * 2);
				if (resultado.length() == 2) { 
					// si tiene dos cifras las separamos y los sumamos
					int cifra1 = Integer.parseInt(resultado.substring(0, 1));
					int cifra2 = Integer.parseInt(resultado.substring(1, 2));
					sumaInpares = sumaInpares + (cifra1 + cifra2);
				} else {
					sumaInpares = sumaInpares + Integer.parseInt(resultado);
				}
			}
			cif = cif.concat(String.valueOf(value));
		}
		sumaTotal = sumaPares + sumaInpares;
		String AuxDigCont = String.valueOf(sumaTotal);
		int digCont = Integer.parseInt(AuxDigCont.substring(AuxDigCont.length() - 1, AuxDigCont.length()));
		if (digCont > 0) {
			digCont = 10 - digCont;
		}
		// Completamos el CIF con el digito de control
		if (letra != 'A' && letra != 'B' && letra != 'E' && letra != 'H') {
			// se aade una letra al final
			cif = cif.concat(String.valueOf(LetraDigCont[digCont]));
		} else { 
			// se aade el digito de control
			cif = cif.concat(String.valueOf(digCont));
		}
		return cif;
	}
    
	@Attachment(value = "Screenshot jpg attachment", type = "image/jpg")
    @Step("Taking a screenshot from Assert")
	
	public static byte[] takeRemoteScreenshot(WebDriver driver) throws URISyntaxException, IOException {
		

		
		try {
               String filename = generateRandomFilename();
               WebDriver augmentedDriver = new Augmenter().augment(driver);
               File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(screenshot, new File(reportsDir + SLASH + "2" + filename));
               return Files.readAllBytes(Paths.get(screenshot.toURI()));
        } catch (IOException e) {
               System.out.println("We have a problem: Error in screenshot");
               System.out.println(e);
        }
        return null;
  }
	
	 private static final String SLASH = File.separator;
	 public static final String reportsDir = "." + SLASH + "target" + SLASH + "site" + SLASH + "images";
	 
	 public static String generateRandomFilename() {
         Calendar c = Calendar.getInstance();
         String filename = "Test.jpg";
         filename = "" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-"
                      + c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND) + "-"
                      + filename;
         return filename;
   }
	 
}
