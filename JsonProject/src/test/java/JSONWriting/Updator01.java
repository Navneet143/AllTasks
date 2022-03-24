package JSONWriting;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Updator01 {

	public static JSONObject setProperty(JSONObject js1, String keys, String valueNew) throws JSONException {
		String[] keyMain = keys.split("\\.");
		for (String keym : keyMain) {
			Iterator iterator = js1.keys();
			String key = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				if ((js1.optJSONArray(key) == null) && (js1.optJSONObject(key) == null)) {
					if (js1.keySet().contains(keym)) {
						if ((key.equals(keym))) {
							js1.put(key, valueNew);
							return js1;
						}
					} else {
						js1.put(keym, valueNew);
						return js1;
					}

				}
				if (js1.optJSONObject(key) != null) {

					if ((key.equals(keym))) {
						js1 = js1.getJSONObject(key);
						break;
					}
				}
				if (js1.optJSONArray(key) != null) {
					JSONArray jArray = js1.getJSONArray(key);
					for (int i = 0; i < jArray.length(); i++) {
						js1 = jArray.getJSONObject(i);
					}
					break;
				}
			}
		}
		return js1;
	}

	public static void insertdata(JSONObject obj, String Path) throws Exception {
		File f1 = new File(Path);
		FileWriter fw = new FileWriter(f1);
		fw.write(obj.toString());
		fw.close();

	}

	public static void main(String[] args) throws Exception {
		File f1 = new File("src\\test\\java\\JSONWriting\\data3.json");
		Reader read = new FileReader(f1);
		if (f1.length() == 0) {
			JSONObject obj = new JSONObject();
			JSONObject innerobj = new JSONObject();
			innerobj.put("FirstName", "Ajay");
			innerobj.put("LastName", "Rana");
			innerobj.put("Age", "24");
			obj.put("Employee", innerobj);
			insertdata(obj, "src\\test\\java\\JSONWriting\\data3.json");
		} else {
			Object obj = new JSONParser().parse(read);
			String text = new String(obj.toString());
			JSONObject json = new JSONObject(text);
			setProperty(json, "Employee.FirstName", "Keshav");
			setProperty(json, "Employee.LastName", "Sharma");
			setProperty(json, "Employee.State", "Mumbai");
			setProperty(json, "Employee.Hobby", "Cricket");
			// System.out.println(json.toString(1));
			insertdata(json, "src\\test\\java\\JSONWriting\\data3.json");
		}
		System.out.println("Data Written");

	}
}
