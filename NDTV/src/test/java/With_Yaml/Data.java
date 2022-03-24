package With_Yaml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Data {
	
	private Map<String,String>xpath;
	private List<String> city= new ArrayList<>();
	
	
	public Data(){}
	
	Data(Map<String,String> xpath,List<String> city){
		this.xpath=xpath;
		this.city=city;
		
	}
	
	public Map<String,String> getXpath() {
		return xpath;
	}
	
	public List<String> getcity() {
		return city;
	}
	
	
	@Override
	public String toString() {
		return "\nxpath: "+xpath+"\ncity: "+city;
	}

}