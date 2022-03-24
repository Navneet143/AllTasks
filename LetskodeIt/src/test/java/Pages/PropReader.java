package Pages;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class PropReader {

	 public static String propFilePath = "src\\test\\java\\Data\\Config.properties";
	 public static Properties prop= new Properties();
	 
	public static void readvalue() throws Exception {
		Reader read= new FileReader(new File(propFilePath));
		prop.load(read);
	
	}
	
	public static String getdata(String key)throws Exception{
		readvalue();
		return prop.get(key).toString();
	}
}
