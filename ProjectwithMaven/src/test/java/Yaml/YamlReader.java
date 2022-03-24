package Yaml;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlReader {

	public static void main(String[] args) throws Throwable{
		// Loading the YAML file from the /resources folder
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File("src/test/java/Yaml/data3.yml");

		// Instantiating a new ObjectMapper as a YAMLFactory
		ObjectMapper om = new ObjectMapper(new YAMLFactory());

		// Mapping the employee from the YAML file to the Employee class
		Employee employee = om.readValue(file, Employee.class);

		// Printing out the information
		System.out.println("Employee info " + employee.toString());

		// Access the first element of the list and print it as well
		//System.out.println("Accessing first element: " + employee.getColleagues().get(0).toString());
	}

}
