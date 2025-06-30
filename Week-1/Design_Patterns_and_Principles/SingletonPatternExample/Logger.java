package SingletonPatternExample;
//Logger.java
public class Logger {
 // Static variable holds single instance
 private static Logger singleInstance;

 // Private constructor
 private Logger() {
     System.out.println("Logger initialized");
 }

 // Public method to provide access to the instance
 public static Logger getInstance() {
     if (singleInstance == null) {
         singleInstance = new Logger();
     }
     return singleInstance;
 }

 // Example log method
 public void log(String message) {
     System.out.println("Log: " + message);
 }
}
