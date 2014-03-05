package aaa.test.libtest;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 测试使用map转化为json后的格式，以及json的反向转化*/
public class Map2JsonforGsonTest {
	public static void main(String[] args) {

		Map<String, Map<String, String>> dataMap = new HashMap<>();
		Map<String, String> element1= new HashMap<>();
		element1.put("key1", "value1");
		element1.put("key2", "value2");
		dataMap.put("id1", element1);
		Gson gson = new Gson();
		String tempString = gson.toJson(dataMap.get("id1"));
		System.out.println(tempString);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Map<String, String> tempMap = gson.fromJson(tempString, Map.class);
		System.out.println(tempMap.get("key1"));
		System.out.println(tempMap.get("key2"));
		
	}
}
