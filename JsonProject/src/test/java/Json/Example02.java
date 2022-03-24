package Json;

import org.json.JSONArray;
import org.json.JSONObject;



public class Example02 {

	public static void main(String[] args) {
		
		String jsonString = "{"
				+ "  \"name\": \"coderolls\","
				+ "  \"type\": \"blog\","
				+ "  \"address\": {"
				+ "    \"street\": \"1600 Pennsylvania Avenue NW\","
				+ "    \"city\": \"Washington\","
				+ "    \"state\": \"DC\""
				+ "  },"
				+ "  \"employees\": ["
				+ "    {"
				+ "      \"firstName\": \"John\","
				+ "      \"lastName\": \"Doe\""
				+ "    },"
				+ "    {"
				+ "      \"firstName\": \"Anna\","
				+ "      \"lastName\": \"Smith\""
				+ "    },"
				+ "    {"
				+ "      \"firstName\": \"Peter\","
				+ "      \"lastName\": \"Jones\""
				+ "    }"
				+ "  ]"
				+ "}";
		
		System.out.println("Parsing the json string in java using JSON-Java......\n");

		//add jsonString to the constructor
		JSONObject coderollsJSONObject = new JSONObject(jsonString);
		
		//now we can access the values 
		String name = coderollsJSONObject.getString("name");
		System.out.println("Name: "+name+"\n");
		
		//we can get the JSON object present as value of any key in the parent JSON
		JSONObject addressJSONObject = coderollsJSONObject.getJSONObject("address");
		
		//access the values of the addressJSONObject 
		String street = addressJSONObject.getString("street");
		System.out.println("Street: "+street+"\n");
		
		
		//we can get the json array present as value of any key in the parent JSON
		JSONArray employeesJSONArray = coderollsJSONObject.getJSONArray("employees");
		System.out.println("Printing the employess json array: \n"+employeesJSONArray.toString()+"\n");
		
		//we can get individual json object at an index from the employeesJSONArray
		JSONObject employeeJSONObject = employeesJSONArray.getJSONObject(0);
		String firstName = employeeJSONObject.getString("firstName");
		System.out.println("First Name of the employee at index 0: "+firstName);
	}
}