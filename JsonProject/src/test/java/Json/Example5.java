package Json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Example5 {

	public static int i = 0;
	static Object value;

	public static Object getvalue(Object obj, String key, int index) {
		JSONObject jobj = new JSONObject();
		if (obj instanceof org.json.simple.JSONObject)
			jobj = new JSONObject(obj.toString());
		if (obj instanceof org.json.simple.JSONArray) {
			JSONArray jarr = new JSONArray(obj.toString());
			jobj = jarr.getJSONObject(0);
		}
		i = 0;
		getKey(jobj, key, index);
		return value;
	}

	public static void getKey(JSONObject obj, String key, int index) {
		boolean check = obj.has(key);
		Iterator keys;
		String nextkeys;

		if (check == false) {
			keys = obj.keys();
			while (keys.hasNext()) {
				nextkeys = (String) keys.next();
				if (obj.get(nextkeys) instanceof JSONObject) {
						getKey(obj.getJSONObject(nextkeys), key, index);
				} else if (obj.get(nextkeys) instanceof JSONArray) {
					JSONArray jarray = obj.getJSONArray(nextkeys);
					for (int i = 0; i < jarray.length(); i++) {
						if ((jarray.get(i) instanceof JSONObject)) {
							String str1 = jarray.get(i).toString();
							JSONObject obj1 = new JSONObject(str1);
								getKey(obj1, key, index);
						}
					}
				}
			}
		} else {
			if (i == index)
				value = obj.get(key);
			i++;
		}
	}

	public static void main(String[] args) throws Throwable {
		FileReader fr = new FileReader("src/test/java/Data/data3.json");
		Object obj = new JSONParser().parse(fr);
		System.out.println(getvalue(obj, "city", 0));
		System.out.println(getvalue(obj, "firstName", 0));
	}
}
