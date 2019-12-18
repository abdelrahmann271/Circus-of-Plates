package Logger;
import java.io.IOException;
import java.text.Format;
import java.util.Calendar;
import java.util.logging.*;
public class LoggerSingle {

	 
	 private static   Logger logger = null ;
	  
	    public static Logger getInstance() 
	    { 
	        if (logger == null) {
	            logger = Logger.getLogger(LoggerSingle.class.getName());
	        FileHandler fh = null;
			try {
				fh = new FileHandler("MyLogFile_"
				        +".log");
			} catch (SecurityException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
       
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);
            logger.info("game start");
	        }
	        return logger; 
	    } 
}
