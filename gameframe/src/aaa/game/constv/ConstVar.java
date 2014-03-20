package aaa.game.constv;

/**
 * 全局参数定义
 */
public final class ConstVar {

	// 全局参数定义
	public final static String LIST_ELEMENT_SEPERATOR = "%%%";// 用来描述属性中涉及list的属性，作为list各个属性的分隔符

	public final static String GAME_CURSOR = "images/cursor.png";
	public final static int FPS = 100;
	public final static boolean DEBUG = true;

	public final static int GLOBAL_WIDTH = 1240;
	public final static int GLOBAL_HEIGHT = 860;

	public final static int COMMON_SIDE_PAPER_X = 0;// 侧边组件的x坐标
	public final static int COMMON_SIDE_PAPER_Y = 90;// 侧边组件的y坐标
	public final static int COMMON_SIDE_PAPER_WIDTH_BORD = 10;// 侧边组件内部按钮距离组件x方向边框宽度
	public final static int COMMON_SIDE_PAPER_HEIGHT_BORD = 10;// 侧边组件内部按钮距离组件y方向边框宽度
	public final static int COMMON_SIDE_BUR_WIDTH = 125;// 侧边组件按钮宽度
	public final static int COMMON_SIDE_BUR_HEIGHT = 50;// 侧边组件按钮高度
	public final static String COMMON_SIDE_BUR_IMAGE = "images/button.png";// 侧边按钮背景图
	public final static float COMMON_SIDE_ALPHA = 0.f;// 侧边组件按钮高度

	public final static int COMMON_BOTTOM_PAPER_WIDTH_BORD = 10;// 底边组件内部按钮距离组件x方向边框宽度
	public final static int COMMON_BOTTOM_PAPER_HEIGHT_BORD = 10;// 底边组件内部按钮距离组件x方向边框宽度
	public final static int COMMON_BOTTOM_BUR_WIDTH = 100;// 底边组件按钮宽度
	public final static int COMMON_BOTTOM_BUR_HEIGHT = 100;// 底边组件按钮宽度
	public final static int COMMON_BOTTOM_BUR_MAXX_SIZE = 10;// 底边组件按钮每行最大数目
	public final static int COMMON_BOTTOM_PAPER_X = (GLOBAL_WIDTH
			- COMMON_BOTTOM_BUR_WIDTH * COMMON_BOTTOM_BUR_MAXX_SIZE - 2 * COMMON_BOTTOM_PAPER_WIDTH_BORD) / 2;// 底边组件的x坐标
	public final static int COMMON_BOTTOM_PAPER_Y = 650;// 底边组件的y坐标
	public final static int COMMON_BOTTOM_PAPER_WIDTH = COMMON_BOTTOM_BUR_WIDTH
			* COMMON_BOTTOM_BUR_MAXX_SIZE + 2 * COMMON_BOTTOM_PAPER_WIDTH_BORD;
	public final static int COMMON_BOTTOM_PAPER_HEIGHT = COMMON_BOTTOM_BUR_HEIGHT
			+ 2 * COMMON_BOTTOM_PAPER_HEIGHT_BORD;
	public final static String COMMON_BOTTOM_BACK_IMAGE = "images/window.png";// 底边组件按钮每行最大数目

	public final static int COMMON_BOTTOM_MESSAGE_WIDTH = 800;
	public final static int COMMON_BOTTOM_MESSAGE_HEIGHT = 150;

	public final static int COMMON_BOTTOM_MESSAGE_X = (GLOBAL_WIDTH - COMMON_BOTTOM_MESSAGE_WIDTH) / 2;
	public final static int COMMON_BOTTOM_MESSAGE_Y = COMMON_BOTTOM_PAPER_Y;

	// 全局地图相关数据
	static public class GlobalMap {
		public final static String MAP = "images/glob_map.jpg";
		public final static int MAP_WIDTH = 1920;
		public final static int MAP_HEIGHT = 1080;
	}

	// 数据定义
	static public class People {
		public final static String PEOPLE_ID_PRE = "rol";
		public final static String PEOPLE_IMAGE_KEY = "image_head";
		public final static String PEOPLE_BODY_IMAGE_KEY = "image_body";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String FACILITY_KEY = "facility";
		public final static String FOLLOWERS_KEY = "followers";
		public final static String ITEMS_KEY = "items";
		public final static String MONEY = "money";
	}

	static public class City {
		public final static String CITY_ID_PRE = "cty";
		public final static String NAME_KEY = "name";
		public final static String MAIN_FACILITY = "city_facility";
		public final static String FACILITIES_KEY = "facilities";
		public final static String CITY_BACK_IMAGE = "background";
		public final static String CITY_X = "x";
		public final static String CITY_Y = "y";
	}

	static public class Facility {
		public final static String FACILITY_ID_PRE = "fac";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String PEOPLES_KEY = "roles";
		public final static String BACK_IMAGE = "image";
		public final static String TYPE_KEY = "type";
	}

	static public class Item {
		public final static String ITEM_ID_PRE = "ite";
		public final static String NAME_KEY = "name";
		public final static String SIZE_KEY = "size";
		public final static String PRICE_KEY = "price";
	}
	
	static public class EventType {
		public final static String EVENTSUBSET_ID_PRE = "evt";
		public final static String EVENTSUBSET_LIST = "elist";
	}
	static public class Event {
		public final static String EVN_ID_PRE = "evn";
		public final static String EVT_ID = "evtid";
		public final static String EVN_FLAG = "flag";
//		public final static String EVN_PARAM_LIST= "params";
		public final static String EVN_DIALOG= "dialogs";
		public final static String EVN_RESULT= "result";
		public final static String ATTRIBUTE_SEPERATOR= "-";
		public final static String EVN_COUNT = "count";
		public final static String EVN_PRIORITY = "priority";
		public final static String EVN_DIALOG_SEPERATOR = "#";
		public final static String EVN_DIALOG_NUM_SEPERATOR = ":";
		public final static String EVN_DIALOG_ELM_SEPERATOR = "%";
		public final static String TYPE = "dialog_type";
		public final static String TYPE_D = "dia";
		public final static String TYPE_S = "sel";
		public final static String DIALOG = "dialog";
		public final static String SELECT_PRE= "s";
		public final static String RESULT_PRE= "r";
		public final static String ROLE_ID= "role";
	}
	static public class GlobalData {
		//人物相关的全局信息
		public final static String CUR_PEOPLE_ID = "cur_people";
		public final static String CUR_DEAD_PEOPLE = "cur_dead";
		public final static String MAIN_ROLE= "main";
		
		
		//地点相关的全局信息
		public final static String CUR_CITY_ID = "cur_city";
		
		//设施相关的全局信息
		public final static String CUR_FACILITY_ID = "cur_facility";
	}
}
