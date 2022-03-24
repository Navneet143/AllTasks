package JSONWriting;


import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JsonWrite {
	
	public void insertdata(JSONObject obj, String Path) throws Exception {
		File f1 = new File(Path);
		FileWriter fw = new FileWriter(f1);
		fw.write(obj.toJSONString());
		fw.close();
		
	}
	
	@Test
	public void writedata()throws Exception{
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject innerobj = new JSONObject();
		
		innerobj.put("FirstName", "Aman");
		innerobj.put("LastName", "Rana");
		innerobj.put("Age", "24");
		arr.add(innerobj);
		
		System.out.println(innerobj);
		System.out.println(arr);
		innerobj.clear();
		
		innerobj.put("FirstName", "Peter");
		innerobj.put("LastName", "Desuja");
		innerobj.put("Age", "27");
		arr.add(innerobj);
		
		System.out.println(innerobj);
		System.out.println(arr);
		
		String Path= "src\\test\\java\\JSONWriting\\data2.json";
		obj.put("Employee",arr);
		System.out.println(obj);
		
		insertdata(obj,Path);
		Path= "src\\test\\java\\JSONWriting\\data1.yml";
		insertdata(obj,Path);
	}

}
