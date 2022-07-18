package mama;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger
            = Logger.getLogger(
                Hello.class.getName());

		logger.log(Level.INFO, "Hello World");
		byte a = 3;     
        byte b = 8;     
        byte result;
        result = (byte) (a + b);

        logger.log(Level.INFO, "");
	}

}
