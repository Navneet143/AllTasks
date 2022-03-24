package Yaml;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class EmployeeReader {
	public static void main(String[] args) throws Exception {
		File file= new File("src/test/java/Yaml/data4.yml");
		ObjectMapper om= new ObjectMapper(new YAMLFactory());
		//om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Employee01 emp1 =om.readValue(file,Employee01.class);
		//System.out.println(emp1.name);
		for(Employee01 emp: emp1.getemployee())
			emp.print();
	}
}