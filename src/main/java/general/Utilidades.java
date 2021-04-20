package general;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import javax.imageio.ImageIO;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class Utilidades {

	private static String OTP = null;
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
	
	public static byte[] takeRemoteScreenshot(WebDriver driver, String nomCaso) throws URISyntaxException, IOException {
		

		
		try {
               String filename = generateRandomFilename();
               WebDriver augmentedDriver = new Augmenter().augment(driver);
               File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(screenshot, new File(reportsDir + SLASH + nomCaso + SLASH + filename));
               return Files.readAllBytes(Paths.get(screenshot.toURI()));
        } catch (IOException e) {
               System.out.println("We have a problem: Error in screenshot");
               System.out.println(e);
        }
        return null;
  }
	
	@Attachment(value = "Screenshot jpg attachment", type = "image/jpg")
    @Step("Taking a screenshot from Assert")
	
	public static byte[] takeRemoteScreenshot(WebDriver driver) throws URISyntaxException, IOException {
		

		
		try {
               String filename = generateRandomFilename();
               WebDriver augmentedDriver = new Augmenter().augment(driver);
               File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(screenshot, new File(reportsDir + SLASH + filename));
               return Files.readAllBytes(Paths.get(screenshot.toURI()));
        } catch (IOException e) {
               System.out.println("We have a problem: Error in screenshot");
               System.out.println(e);
        }
        return null;
  }
	
	@Attachment(value = "Screenshot jpg attachment", type = "image/jpg")
    @Step("Taking a screenshot from Assert")
	
	public static File fileGetRemoteScreenshot(WebDriver driver) throws URISyntaxException, IOException {
		   WebDriver augmentedDriver = new Augmenter().augment(driver);
		   File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		   return screenshot;
  }
	
	public static XWPFDocument createWordDocument(String codeTC) {
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		String p1 = codeTC;
		r.setFontFamily("Arial Black");
		r.setFontSize(24);
		r.setText(p1);
		r.addBreak();
		return doc;
	}
	
	public static void addTextToDocument(XWPFDocument doc, String text) {
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		String p1 = text;
		r.setText(p1);
		r.addBreak();
	}
	
	public static void closeWordDocument(XWPFDocument doc, String codeTC) throws IOException {
		String wordDir = "." + SLASH + "wordReport";
		File theDir = new File(wordDir);
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(wordDir + SLASH + codeTC + ".docx");
		doc.write(out);
		out.close();
		doc.close();
	}
	
	public static void addImagesToWordDocument(XWPFDocument doc, File imageFile1)
			throws IOException, InvalidFormatException {
		
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		BufferedImage bimg1 = ImageIO.read(imageFile1);
		int width1 = bimg1.getWidth();
		int height1 = bimg1.getHeight();
		String imgFile1 = imageFile1.getName();
		int imgFormat1 = getImageFormat(imgFile1);
		r.addPicture(new FileInputStream(imageFile1), imgFormat1, imgFile1, Units.toEMU(width1), Units.toEMU(height1));
		// page break
		r.addBreak(BreakType.PAGE);
		
	}

	private static int getImageFormat(String imgFileName) {
		int format;
		if (imgFileName.endsWith(".emf"))
			format = XWPFDocument.PICTURE_TYPE_EMF;
		else if (imgFileName.endsWith(".wmf"))
			format = XWPFDocument.PICTURE_TYPE_WMF;
		else if (imgFileName.endsWith(".pict"))
			format = XWPFDocument.PICTURE_TYPE_PICT;
		else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
			format = XWPFDocument.PICTURE_TYPE_JPEG;
		else if (imgFileName.endsWith(".png"))
			format = XWPFDocument.PICTURE_TYPE_PNG;
		else if (imgFileName.endsWith(".dib"))
			format = XWPFDocument.PICTURE_TYPE_DIB;
		else if (imgFileName.endsWith(".gif"))
			format = XWPFDocument.PICTURE_TYPE_GIF;
		else if (imgFileName.endsWith(".tiff"))
			format = XWPFDocument.PICTURE_TYPE_TIFF;
		else if (imgFileName.endsWith(".eps"))
			format = XWPFDocument.PICTURE_TYPE_EPS;
		else if (imgFileName.endsWith(".bmp"))
			format = XWPFDocument.PICTURE_TYPE_BMP;
		else if (imgFileName.endsWith(".wpg"))
			format = XWPFDocument.PICTURE_TYPE_WPG;
		else {
			return 0;
		}
		return format;
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
	 
	 public static String readEmail() {
		 
	        Properties props = new Properties();
	   	 	String smtpDir = "." + SLASH + "properties";
	 
	        try {
	            props.load(new FileInputStream(new File(smtpDir + SLASH + "smtp.properties")));
	            Session session = Session.getDefaultInstance(props, null);
	 
	            Store store = session.getStore("imaps");
	            store.connect("smtp.gmail.com", "testing.mobile.cex@gmail.com", "Everis01");
	 
	            Folder inbox = store.getFolder("inbox");
	            inbox.open(Folder.READ_ONLY);
	            int messageCount = inbox.getMessageCount();
	 
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	          	      System.in));
	            	Message message = null;
	                   // retrieve the messages from the folder in an array and print it
	                   Message[] messages = inbox.getMessages();
	                   //System.out.println("messages.length---" + messages.length);

	                   for (int i = (messages.length)-1; i < messages.length; i++) {
	                      message = messages[i];
	                      //System.out.println("---------------------------------");
	                      writePart(message);
	                      //String line = reader.readLine();
	                      //System.out.println( (String)message.getContent());
							/*
							 * if ("YES".equals(line)) { message.writeTo(System.out); } else if
							 * ("QUIT".equals(line)) { break; }
							 */
	                   }

	 
	            inbox.close(true);
	            store.close();
	            return OTP;
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	 /*
	   * This method checks for content-type 
	   * based on which, it processes and
	   * fetches the content of the message
	   */
	   public static void writePart(Part p) throws Exception {
	      if (p instanceof Message)
	         //Call methos writeEnvelope
	         writeEnvelope((Message) p);

	      //System.out.println("----------------------------");
	      //System.out.println("CONTENT-TYPE: " + p.getContentType());

	      //check if the content is plain text
	      if (p.isMimeType("text/plain")) {
	         //System.out.println("This is plain text");
	    	 //System.out.println("---------------------------");
	         //System.out.println((String) p.getContent());
	         OTP = (String) p.getContent();
	      } 
	      //check if the content has attachment
	      else if (p.isMimeType("multipart/*")) {
	         //System.out.println("This is a Multipart");
	         //System.out.println("---------------------------");
	         Multipart mp = (Multipart) p.getContent();
	         int count = mp.getCount();
	         for (int i = 0; i < count; i++)
	            writePart(mp.getBodyPart(i));
	      } 
	      //check if the content is a nested message
	      else if (p.isMimeType("message/rfc822")) {
	         //System.out.println("This is a Nested Message");
	         //System.out.println("---------------------------");
	         writePart((Part) p.getContent());
	      } 
	      //check if the content is an inline image
	      else if (p.isMimeType("image/jpeg")) {
	         //System.out.println("--------> image/jpeg");
	         Object o = p.getContent();

	         InputStream x = (InputStream) o;
	         // Construct the required byte array
	         //System.out.println("x.length = " + x.available());
	         byte[] bArray = new byte[x.available()];
	         int i = 0;
	         while ((i = (int) ((InputStream) x).available()) > 0) {
	            int result = (int) (((InputStream) x).read(bArray));
	            if (result == -1) {
	            	i = 0;
	            }

	            break;
	         }
	         FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
	         f2.write(bArray);
	      } 
	      else if (p.getContentType().contains("image/")) {
	         //System.out.println("content type" + p.getContentType());
	         File f = new File("image" + new Date().getTime() + ".jpg");
	         DataOutputStream output = new DataOutputStream(
	            new BufferedOutputStream(new FileOutputStream(f)));
	            com.sun.mail.util.BASE64DecoderStream test = 
	                 (com.sun.mail.util.BASE64DecoderStream) p
	                  .getContent();
	         byte[] buffer = new byte[1024];
	         int bytesRead;
	         while ((bytesRead = test.read(buffer)) != -1) {
	            output.write(buffer, 0, bytesRead);
	         }
	      } 
	      else {
	         Object o = p.getContent();
	         if (o instanceof String) {
	            //System.out.println("This is a string");
	            //System.out.println("---------------------------");
	            //System.out.println((String) o);
	         } 
	         else if (o instanceof InputStream) {
	            //System.out.println("This is just an input stream");
	            //System.out.println("---------------------------");
	            InputStream is = (InputStream) o;
	            is = (InputStream) o;
	            int c;
	            while ((c = is.read()) != -1) {
	               //System.out.write(c);
	            }
	         } 
	         else {
	            //System.out.println("This is an unknown type");
	            //System.out.println("---------------------------");
	            //System.out.println(o.toString());
	         }
	      }

	   }
	   
	   /*
	    * This method would print FROM,TO and SUBJECT of the message
	    */
	    public static void writeEnvelope(Message m) throws Exception {
	       //System.out.println("This is the message envelope");
	       //System.out.println("---------------------------");
	       Address[] a;

	       // FROM
	       if ((a = m.getFrom()) != null) {
	          for (int j = 0; j < a.length; j++) {
	          //System.out.println("FROM: " + a[j].toString());
	          }
	       }

	       // TO
	       if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
	          for (int j = 0; j < a.length; j++) {
	          //System.out.println("TO: " + a[j].toString());
	          }
	       }

	       // SUBJECT
	       if (m.getSubject() != null) {
	          //System.out.println("SUBJECT: " + m.getSubject());
	       }

	    }
	 
	    public static String getOTP (String bodyEmail) {
	    	return bodyEmail.substring(bodyEmail.indexOf(":")+2, bodyEmail.indexOf(":")+8);
	    }
	    
	    public static void CrearWordReporteFinal(String entorno) {
	    	
	    	WordMerge wm = null;
	    	
	    	try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.now();
				//System.out.println(dtf.format(localDate)); //2016/11/16
				FileOutputStream faos = new FileOutputStream(entorno + "-" + dtf.format(localDate) + ".docx");
				wm = new WordMerge(faos); 
				
				for (int i = 1; i<=32; i++) {
					File f = new File("WZ_TC_00" + String.format("%02d", i) +".docx");
					if(f.exists() && !f.isDirectory()) { 
					    //System.out.println("SI existe el " + String.format("%02d", i));
					    wm.add( new FileInputStream("WZ_TC_00" + String.format("%02d", i) +".docx") ); 
					}
					else {
						//System.out.println("NO existe el " + String.format("%02d", i));
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					wm.doMerge();
					wm.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	
	    }
}
