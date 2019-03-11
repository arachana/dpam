package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class EmailReportingHelper {
	
	public static void sendreportinMail(String resultPath) {
		  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		  	String reportFilePath = null;
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = "adaptyautomationreporter@gmail.com";//
		     final String password = "testingadapty";
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("umar.muqthar@adapty.com"));
		     
		     String[] to = {"arachana.varma@adapty.com"};
		     InternetAddress[] addressTo = new InternetAddress[to.length];
		     for (int i = 0; i < to.length; i++){
               addressTo[i] = new InternetAddress(to[i]);
           }
		     msg.setRecipients(Message.RecipientType.TO, addressTo);
		     
		     String[] toBCC = {"muqtharece@gmail.com"};
		     InternetAddress[] addressToCC = new InternetAddress[toBCC.length];
		     for (int i = 0; i < toBCC.length; i++){
	             addressToCC[i] = new InternetAddress(toBCC[i]);
	         }
		     msg.setRecipients(Message.RecipientType.CC, addressToCC); 
		     
		     
		     
		     //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("testing.adapty@gmail.com",false));
		     //msg.setSubject("Brasseler  Automation Run report "+new Date());
		    // msg.setText("Please find the latest Automation Run Report ");
		     //msg.setSentDate(new Date());
		     
		     ///Attchment code starts here
		  // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("Please find the latest Test Automation Run Report of Brasseler Regression Suite");
		  // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         File fileToSend = null;
	         fileToSend=EmailReportingHelper.getLastReportExcel(resultPath);
	         reportFilePath=fileToSend.getPath();
	         
	         Path p = Paths.get(fileToSend.getAbsoluteFile().toURI());
	         BasicFileAttributes view = null;
	            try {
	                view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            FileTime creationTime = view.creationTime();
	            
	            System.out.println("File Creation Date:============================"+creationTime);
	           
	           	msg.setSubject("Brasseler Test Automation Run report "+creationTime);
			     msg.setText("Please find the latest Test Automation Run Report of Brasseler Regression Suite");
			     msg.setSentDate(new Date());
	         
	         
	         messageBodyPart = new MimeBodyPart();
	         String filename = reportFilePath;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("BrasselerAutomationReporter.xlsx");
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         msg.setContent(multipart );

		     
		     
		     
		     Transport.send(msg);
		     System.out.println("Message sent.");
		  }catch (MessagingException e)
		     { 
			  System.out.println("Error Cause " + e);
			  }
		     }
	
	public static File getLastReportExcel(String ResultsPath) {
		File lastReportFolder=EmailReportingHelper.listModifiedDirectory(ResultsPath);
		
	    File fl = new File(lastReportFolder.getPath());
	    long millisec;
	    long milliSecCreated;
	    String path;
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	    	millisec=file.lastModified();
	    	
	    	Date dt = new Date(millisec);
	    	 path = file.getPath();

	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();


	            Path p = Paths.get(file.getAbsoluteFile().toURI());
	            
	            
	        }
	    }
	    //System.out.println(choice.getPath());
	    return choice;
	}
	
	public static File listModifiedDirectory(String dir) {
	    File file = new File(dir);
	    File directoryFile;
	    String[] names = file.list();
	    String folderPath;
	    long milliseconds;
	    String path;
	    File choice = null;
	    long lastMod = Long.MIN_VALUE;

	    for(String name : names){
	    	directoryFile=new File(dir+name);
	        if (directoryFile.isDirectory()){
	        	milliseconds=directoryFile.lastModified();	        	
	    		Date dt = new Date(milliseconds);
	    		path = directoryFile.getPath();
		    	 
	    	 if (directoryFile.lastModified() > lastMod) {
		            choice = directoryFile;
		            lastMod = directoryFile.lastModified();
		      }		    			
	        }	        
	    }
	    System.out.println(choice.getPath());
	    return choice;
	}

	 
	 
}


	
	
	
