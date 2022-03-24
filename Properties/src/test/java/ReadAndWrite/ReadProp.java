package ReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) throws IOException {
		
		File file=new File("src\\test\\java\\Data\\prop1.properties");
		FileInputStream fileInput=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fileInput);
		
		
		String fname=prop.getProperty("FirstName");
		String lname=prop.getProperty("LastName");
		String age=prop.getProperty("Age");
		String email=prop.getProperty("Email");
		String password=prop.getProperty("Password");
		
		 
		System.out.println(fname+ " " + lname+ " "+ age+ " " + email+ " " + password  ); 
		
	}
}