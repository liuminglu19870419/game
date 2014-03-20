package aaa.game.model;

import java.util.HashMap;
import java.util.Map;

public class GlobalEventData {
	private Map<String, String> data = null;
	public GlobalEventData() {
		data = new HashMap<String, String>();
	}
	
	public String get(String id) {
		String result= data.get(id) == null ? id: data.get(id);
		return result;
	}
	public void set(String id, String value) {
		data.put(id, value);
	}
}
