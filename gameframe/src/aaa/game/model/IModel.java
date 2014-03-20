package aaa.game.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IModel {

	public Map<String, String> get(String id);
	
	public String get(String id, String attribuate);// 获取指定id的指定属性值，attribuate为空，返回整个id元素

	public boolean set(String id, String attribuate, String value);// 设置指定id的指定属性值，返回修改合法性

	public boolean add(String id, String attribuate, String value);// 在指定id的指定属性值后面追加一个新的元素，需要验证要追加的那个属性是不是list，返回修改合法性

	public boolean delete(String id, String attribuate, String value);

	public Set<String> getAllId();// 在指定id的指定属性值后面追加一个新的元素，需要验证要追加的那个属性是不是list，返回修改合法性
}
