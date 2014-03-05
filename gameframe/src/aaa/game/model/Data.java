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
			map.get(id).put(attribuate,
					curString + ConstVar.LIST_ELEMENT_SEPERATOR + value);
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
}
