package aaa.game.data;

import aaa.game.constv.ConstVar;
import aaa.game.model.Data;
import aaa.game.model.GlobalEventData;

public class ShareData {
	public static Data cities = new Data();
	public static Data peoples = new Data();
	public static Data facilities = new Data();
	public static Data items = new Data();
	public static Data globalSideButtons = new Data();
	public static Data globalBottomButtons = new Data();
	public static Data citySideButtons = new Data();
	public static Data cityBottomButtons = new Data();
	public static Data events = new Data();
	public static Data eventTypes = new Data();
	public static GlobalEventData globalData = new GlobalEventData();

	public static String get(String id, String attribuate) {
		String pre = id.substring(0, 3);
		switch (pre) {
		case ConstVar.People.PEOPLE_ID_PRE:
			return peoples.get(id, attribuate);
		case ConstVar.City.CITY_ID_PRE:
			return cities.get(id, attribuate);
		case ConstVar.Facility.FACILITY_ID_PRE:
			return facilities.get(id, attribuate);
		default:
			return peoples.get(id, attribuate);
		}
	}

	/**
	 * 输入一些测试案例
	 */
	static {

		// 街道测试
		cities.set(ConstVar.City.CITY_ID_PRE + "00100", ConstVar.City.NAME_KEY,
				"兰州");
		cities.set(ConstVar.City.CITY_ID_PRE + "00100", ConstVar.City.CITY_X,
				"300");
		cities.set(ConstVar.City.CITY_ID_PRE + "00100", ConstVar.City.CITY_Y,
				"500");
		cities.set(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.CITY_BACK_IMAGE, "images/city.jpg");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.MAIN_FACILITY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00100");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00101");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00102");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00109");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00110");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101", ConstVar.City.NAME_KEY,
				"拉面");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101", ConstVar.City.CITY_X,
				"600");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101", ConstVar.City.CITY_Y,
				"500");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.CITY_BACK_IMAGE, "images/city2.jpg");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.MAIN_FACILITY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00103");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00104");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00105");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00106");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00107");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00108");

		// 角色测试
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00000",
				ConstVar.People.NAME_KEY, "主角");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00000",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/b.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00000",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00000",
				ConstVar.People.MONEY, "1000");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00102",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00100",
				ConstVar.People.NAME_KEY, "张三丰");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00100",
				ConstVar.People.FACILITY_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00100");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00101",
				ConstVar.People.NAME_KEY, "张四");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00102",
				ConstVar.People.NAME_KEY, "c1_sA_r3");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00103",
				ConstVar.People.NAME_KEY, "c1_sB_r4");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00104",
				ConstVar.People.NAME_KEY, "c2_j_r5");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00105",
				ConstVar.People.NAME_KEY, "c2_j_r6");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00106",
				ConstVar.People.NAME_KEY, "c2_sC_r7");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00107",
				ConstVar.People.NAME_KEY, "c2_sD_r8");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00108",
				ConstVar.People.NAME_KEY, "c2_sD_r9");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00100",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00101",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00102",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00103",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00104",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00105",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00106",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00107",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00108",
				ConstVar.People.PEOPLE_IMAGE_KEY, "images/loli.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00100",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/a.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00101",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/b.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00102",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/c.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00103",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/a.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00104",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/b.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00105",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/c.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00106",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/a.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00107",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/b.png");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00108",
				ConstVar.People.PEOPLE_BODY_IMAGE_KEY, "images/c.png");
		// 设施测试
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00100",
				ConstVar.Facility.NAME_KEY, "城市");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00100",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00100",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00100",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00101");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00101",
				ConstVar.Facility.NAME_KEY, "市场");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00101",
				ConstVar.Facility.BACK_IMAGE, "images/market.jpg");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00101",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00101",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00102");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00102",
				ConstVar.Facility.NAME_KEY, "书院");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00102",
				ConstVar.Facility.BACK_IMAGE, "images/school.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00102",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00102",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00103");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00103",
				ConstVar.Facility.NAME_KEY, "城市");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00103",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00103",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00104");

		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00103",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00105");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00104",
				ConstVar.Facility.NAME_KEY, "自宅");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00104",
				ConstVar.Facility.BACK_IMAGE, "images/home.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00104",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00104",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00106");
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00105",
				ConstVar.Facility.NAME_KEY, "铁铺");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00105",
				ConstVar.Facility.BACK_IMAGE, "images/datie.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00105",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00105",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00105",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00106",
				ConstVar.Facility.NAME_KEY, "青楼");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00106",
				ConstVar.Facility.BACK_IMAGE, "images/qinglou.jpg");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00106",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00106",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00106",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00107",
				ConstVar.Facility.NAME_KEY, "兵营");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00107",
				ConstVar.Facility.BACK_IMAGE, "images/datie.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00107",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00107",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00107",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00108",
				ConstVar.Facility.NAME_KEY, "赌场");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00108",
				ConstVar.Facility.BACK_IMAGE, "images/datie.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00108",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00108",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00108",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00109",
				ConstVar.Facility.NAME_KEY, "野外");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00109",
				ConstVar.Facility.BACK_IMAGE, "images/datie.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00109",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00109",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00109",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00110",
				ConstVar.Facility.NAME_KEY, "酒馆");
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00110",
				ConstVar.Facility.BACK_IMAGE, "images/datie.png");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00110",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00110",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00107");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00110",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00108");

		/********************************************************/
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00100",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00100");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00100",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00101");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00100",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00102");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00100",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00103");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00101",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00104");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00101",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00105");
		eventTypes.add(ConstVar.EventType.EVENTSUBSET_ID_PRE + "00101",
				ConstVar.EventType.EVENTSUBSET_LIST, ConstVar.Event.EVN_ID_PRE
						+ "00106");

		/*******************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00100",
				ConstVar.Event.EVN_FLAG, "(("
						+ ConstVar.GlobalData.CUR_PEOPLE_ID
						+ ConstVar.Event.ATTRIBUTE_SEPERATOR
						+ ConstVar.People.FACILITY_KEY + "="
						+ ConstVar.Facility.FACILITY_ID_PRE + "00100))");
		events.set(ConstVar.Event.EVN_ID_PRE + "00100",
				ConstVar.Event.EVN_PRIORITY, "1000");
		events.set(ConstVar.Event.EVN_ID_PRE + "00100",ConstVar.Event.EVN_DIALOG,
				"#1"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.CUR_PEOPLE_ID + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "bcda" + 
				"#2"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.MAIN_ROLE + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "qwerty" + 
				"#3"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.CUR_PEOPLE_ID + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "bcda");
		events.add(ConstVar.Event.EVN_ID_PRE + "00100",
				ConstVar.Event.EVN_RESULT, ConstVar.People.PEOPLE_ID_PRE
						+ "00000." + ConstVar.People.MONEY + "+100");
		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00101",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00101",
				ConstVar.Event.EVN_DIALOG, "" + "#1:curp:abcdefghijk"
						+ "#2:main:qwertyyui" + "#3:curp:zxcvbnm," + "");
		events.add(ConstVar.Event.EVN_ID_PRE + "00101",
				ConstVar.Event.EVN_RESULT, ConstVar.People.PEOPLE_ID_PRE
						+ "00000." + ConstVar.People.MONEY + "-100");

		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00102",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00102",
				ConstVar.Event.EVN_DIALOG, "" + "#1:curp:abcdefghijk"
						+ "#2:main:qwertyyui" + "#3:curp:zxcvbnm," + "");
		events.add(ConstVar.Event.EVN_ID_PRE + "00102",
				ConstVar.Event.EVN_RESULT, "");

		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00103",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00103",
				ConstVar.Event.EVN_DIALOG, 
				"#1"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.CUR_PEOPLE_ID + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "bcda" + 
				"#2"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.MAIN_ROLE + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "qwerty" + 
				"#3"+ ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR + ConstVar.GlobalData.CUR_PEOPLE_ID + ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR + "bcda");

		events.add(ConstVar.Event.EVN_ID_PRE + "00103",
				ConstVar.Event.EVN_RESULT, "");

		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00104",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00104",
				ConstVar.Event.EVN_DIALOG, "" + "#1:curp:abcdefghijk"
						+ "#2:main:qwertyyui" + "#3:curp:zxcvbnm," + "");
		events.add(ConstVar.Event.EVN_ID_PRE + "00104",
				ConstVar.Event.EVN_RESULT, "");

		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00105",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00105",
				ConstVar.Event.EVN_DIALOG, "" + "#1:curp:abcdefghijk"
						+ "#2:main:qwertyyui" + "#3:curp:zxcvbnm," + "");
		events.add(ConstVar.Event.EVN_ID_PRE + "00105",
				ConstVar.Event.EVN_RESULT, "");

		/*************************************************/
		events.set(ConstVar.Event.EVN_ID_PRE + "00106",
				ConstVar.Event.EVN_FLAG, "");
		events.set(ConstVar.Event.EVN_ID_PRE + "00106",
				ConstVar.Event.EVN_DIALOG, "" + "#1:curp:abcdefghijk"
						+ "#2:main:qwertyyui" + "#3:curp:zxcvbnm," + "");
		events.add(ConstVar.Event.EVN_ID_PRE + "00106",
				ConstVar.Event.EVN_RESULT, "");
	}
}
