package aaa.game.constv;

/**
 * 此类用来保存程序中所要涉及的全局常量
 */
public final class ConstVar {

	public final static String LIST_ELEMENT_SEPERATOR = "%%%";
	public final static int COMMON_SIDE_PAPER_X = 50;
	public final static int COMMON_SIDE_PAPER_Y = 50;
	public final static int COMMON_SIDE_PAPER_WIDTH_BORD = 10;// 设定按钮距离左右边距离
	public final static int COMMON_SIDE_PAPER_HEIGHT_BORD = 10;// 设定按钮距离上下边距离
	public final static int COMMON_SIDE_BUR_WIDTH = 100;
	public final static int COMMON_SIDE_BUR_HEIGHT = 50;
	public final static String COMMON_SIDE_BUR_IMAGE = "images/button.png";

	static public class People {
		public final static String PEOPLE_ID_PRE = "rol";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String FACILITY_KEY= "facility";
	}

	static public class City {
		public final static String CITY_ID_PRE = "cty";
		public final static String NAME_KEY = "name";
		public final static String FACILITIES_KEY = "facilities";
	}

	static public class Facility {
		public final static String FACILITY_ID_PRE = "fac";
		public final static String NAME_KEY = "name";
		public final static String CITY_KEY = "city";
		public final static String PEOPLES_KEY = "roles";
	}
	
	static public class Item {
		public final static String ITEM_ID_PRE = "ite";
		public final static String NAME_KEY = "name";
		public final static String SIZE_KEY = "size";
		public final static String PRICE_KEY = "price";
	}
}
