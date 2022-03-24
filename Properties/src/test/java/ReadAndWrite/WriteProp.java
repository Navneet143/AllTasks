package ReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProp {

	public static void main(String[] args) throws IOException {
		File file=new File("src\\test\\java\\Data\\prop2.properties");
		FileInputStream fileInput=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fileInput);
		prop.setProperty("FirstName","David");
		prop.setProperty("LastName","Desuja");
		prop.setProperty("Age","23");
		prop.setProperty("Email","DavidDesuja@gmail.com");
		prop.setProperty("Password","p@ssword");
		FileOutputStream FileOutput=new FileOutputStream(file);
		prop.store(FileOutput, null);
		System.out.println("Successfully Written!!!!");
	}

}