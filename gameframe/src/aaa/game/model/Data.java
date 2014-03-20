package aaa.game.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import aaa.game.constv.ConstVar;

import com.google.gson.Gson;

public class Data implements IModel {

	private Map<String, Map<String, String>> map = null;
	private Gson gson = new Gson();

	public Data() {
		map = new HashMap<String, Map<String, String>>();
	}

	@Override
	public String get(String id, String attribuate) {
		// TODO Auto-generated method stub
		if (attribuate == null || attribuate.equals("")) {
			return gson.toJson(map.get(id));
		}
		if (!map.get(id).containsKey(attribuate)) {
			return null;
		}
		return map.get(id).get(attribuate);
	}

	@Override
	public boolean set(String id, String attribuate, String value) {
		// TODO Auto-generated method stub
		if (map.containsKey(id)) {
			map.get(id).put(attribuate, value);
		} else {
			Map<String, String> tempMap = new HashMap<>();
			tempMap.put(attribuate, value);
			map.put(id, tempMap);
		}
		return true;
	}

	@Override
	public boolean add(String id, String attribuate, String value) {
		// TODO Auto-generated method stub
		if (map.containsKey(id)) {
			String curString = map.get(id).get(attribuate);
			if (curString == null) {
				curString = value;
			} else {
				curString = curString + ConstVar.LIST_ELEMENT_SEPERATOR + value;
			}
			map.get(id).put(attribuate, curString);
		} else {
			Map<String, String> tempMap = new HashMap<>();
			tempMap.put(attribuate, value);
			map.put(id, tempMap);
		}
		return true;
	}

	@Override
	public Set<String> getAllId() {
		return map.keySet();
	}

	@Override
	public boolean delete(String id, String attribuate, String value) {
		// TODO Auto-generated method stub
		if (map.containsKey(id) && map.get(id).containsKey(attribuate)) {
			String[] elementStrings = map.get(id).get(attribuate)
					.split(ConstVar.LIST_ELEMENT_SEPERATOR);
			if(elementStrings.length == 0) {
				elementStrings = new String[1];
				elementStrings[0] = map.get(id).get(attribuate);
			}
			StringBuilder stringBuilder = new StringBuilder();
			for (String string : elementStrings) {
				if (!string.equals(value)) {
					if (stringBuilder.length() == 0) {
						stringBuilder.append(string);
					} else {
						stringBuilder.append(ConstVar.LIST_ELEMENT_SEPERATOR
								+ string);
					}
				}
			}
			set(id, attribuate, stringBuilder.toString());
			return true;
		}
		return false;
	}

	@Override
	public Map<String, String> get(String id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}
}
