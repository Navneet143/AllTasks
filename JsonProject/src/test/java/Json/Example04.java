package Json;

import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;



public class Example04 {

	public static void main(String[] args) throws Throwable {
		
		System.out.println("Parsing the json string in java using JSON-Java......\n");

		FileReader f1= new FileReader("src/test/java/Data/data4.json");
        Object obj = new JSONParser().parse(f1);
    	
          
        String Str1= obj.toString();
		//add jsonString to the constructor
		JSONObject coderollsJSONObject = new JSONObject(Str1);
		
		System.out.println(coderollsJSONObject);
		//now we can access the values 
		String fname = coderollsJSONObject.getString("firstName");
		System.out.println("Name: "+fname+"\n");

//		String lname = coderollsJSONObject.getString("lasttName");
//		System.out.println("Name: "+lname+"\n");
//		
		//we can get the JSON object present as value of any key in the parent JSON
		JSONObject addressJSONObject = coderollsJSONObject.getJSONObject("address");
		
		//access the values of the addressJSONObject 
		String street = addressJSONObject.getString("streetAddress");
		System.out.println("Street: "+street+"\n");
		
		
		//we can get the json array present as value of any key in the parent JSON
		JSONArray employeesJSONArray = coderollsJSONObject.getJSONArray("phoneNumbers");
		System.out.println("Printing the Phone Number json array: \n"+employeesJSONArray.toString()+"\n");
		
		//we can get individual json object at an index from the employeesJSONArray
		JSONObject employeeJSONObject = employeesJSONArray.getJSONObject(0);
		String number = employeeJSONObject.getString("number");
		System.out.println("Number of the employee at index 0: "+number);
		
		String type = employeeJSONObject.getString("type");
		System.out.println("Type of the employee at index 0: "+type);
		
		System.out.println(employeesJSONArray.getJSONObject(1).getJSONObject("type"));
	}
}