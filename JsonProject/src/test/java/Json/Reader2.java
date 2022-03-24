package Json;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Reader2 {

	public static void read_data() {

	}

	public static void traverse_map(Object obj, String key) {
		if (obj instanceof String || obj instanceof Long)
			System.out.println();
		else if(obj instanceof JSONArray) {
			Map m = new HashMap();
//			System.out.print("\t" + obj.getClass().getSimpleName());
			m = (Map) obj;
			for (Object obj1 : m.keySet()) {
				if (m.get(obj1) instanceof Object)
					traverse_map(m.get(obj1), key);
				if (obj1.toString().equalsIgnoreCase(key))
					System.out.print(obj1 + ":" + m.get(obj1));
			}
		}

	}

	public static void main(String[] args) throws Throwable {
		FileReader fr = new FileReader("src/test/java/Data/data2.json");
		Object obj1 = new JSONParser().parse(fr);
		// System.out.println(obj1);
		JSONObject jo = (JSONObject) obj1;

		JSONArray ja = (JSONArray) jo.get("data");
		System.out.println(ja);

		for (Object obj2 : ja) {
			//traverse_map(obj2, "f_name");
			System.out.println(((Map)obj2).getClass());
			Iterator<Map.Entry> it= ((Map)obj2).entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry pair = it.next();
	            System.out.print(pair.getKey() + " : " + pair.getValue()+"\t");
			}
				System.out.println();
		}
	}
}
