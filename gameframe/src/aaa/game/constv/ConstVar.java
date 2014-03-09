package aaa.game.constv;

/**
 * 全局参数定义 
 */
public final class ConstVar {

	//全局参数定义
	public final static String LIST_ELEMENT_SEPERATOR = "%%%";//用来描述属性中涉及list的属性，作为list各个属性的分隔符
	
	
	public final static String GAME_CURSOR = "images/cursor.png";
	public final static int FPS = 100;
	
	public final static int GLOBAL_WIDTH = 1440;
	public final static int GLOBAL_HEIGHT = 960;
	
	public final static int COMMON_SIDE_PAPER_X = 0;//侧边组件的x坐标
	public final static int COMMON_SIDE_PAPER_Y = 90;//侧边组件的y坐标
	public final static int COMMON_SIDE_PAPER_WIDTH_BORD = 10;//侧边组件内部按钮距离组件x方向边框宽度
	public final static int COMMON_SIDE_PAPER_HEIGHT_BORD = 10;//侧边组件内部按钮距离组件y方向边框宽度
	public final static int COMMON_SIDE_BUR_WIDTH = 125;//侧边组件按钮宽度
	public final static int COMMON_SIDE_BUR_HEIGHT = 50;//侧边组件按钮高度
	public final static String COMMON_SIDE_BUR_IMAGE = "images/button.png";//侧边按钮背景图
	public final static float COMMON_SIDE_ALPHA = 0.f;//侧边组件按钮高度
	
	public final static int COMMON_BOTTOM_PAPER_X = 110;//底边组件的x坐标
	public final static int COMMON_BOTTOM_PAPER_Y = 700;//底边组件的y坐标
	public final static int COMMON_BOTTOM_PAPER_WIDTH_BORD = 10;//底边组件内部按钮距离组件x方向边框宽度 
	public final static int COMMON_BOTTOM_PAPER_HEIGHT_BORD = 10;//底边组件内部按钮距离组件x方向边框宽度 
	public final static int COMMON_BOTTOM_BUR_WIDTH = 100;//底边组件按钮宽度
	public final static int COMMON_BOTTOM_BUR_HEIGHT = 100;//底边组件按钮宽度
	public final static int COMMON_BOTTOM_BUR_MAXX_SIZE = 13;//底边组件按钮每行最大数目
	
	//全局地图相关数据
	static public class GlobalMap {
		public final static String MAP = "images/1.jpg";
		public final static int MAP_WIDTH = 1920;
		public final static int MAP_HEIGHT = 1080;
	}
	//数据定义
	static public class People {
		public final static String PEOPLE_ID_PRE = "rol";
		public final static String PEOPLE_IMAGE_KEY = "image_head";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String FACILITY_KEY = "facility";
		public final static String FOLLOWERS_KEY = "followers";
		public final static String ITEMS_KEY = "items";
	}

	static public class City {
		public final static String CITY_ID_PRE = "cty";
		public final static String NAME_KEY = "name";
		public final static String FACILITIES_KEY = "facilities";
		public final static String CITY_BACK_IMAGE = "background";
	}

	static public class Facility {
		public final static String FACILITY_ID_PRE = "fac";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String PEOPLES_KEY = "roles";
		public final static String BUTTON_KEY = "button";
	}

	static public class Item {
		public final static String ITEM_ID_PRE = "ite";
		public final static String NAME_KEY = "name";
		public final static String SIZE_KEY = "size";
		public final static String PRICE_KEY = "price";
	}
}
