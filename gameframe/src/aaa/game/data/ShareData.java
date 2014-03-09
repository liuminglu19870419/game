package aaa.game.data;

import aaa.game.constv.ConstVar;
import aaa.game.model.Data;

public class ShareData {
	public static Data cities = new Data();
	public static Data peoples = new Data();
	public static Data facilities = new Data();
	public static Data items = new Data();
	public static Data globalSideButtons = new Data();
	public static Data globalBottomButtons = new Data();
	public static Data citySideButtons = new Data();
	public static Data cityBottomButtons = new Data();

	/**
	 * 输入一些测试案例
	 */
	static {

		// 街道测试
		cities.set(ConstVar.City.CITY_ID_PRE + "00100", ConstVar.City.NAME_KEY,
				"city1");
		cities.set(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.CITY_BACK_IMAGE, "images/2.jpg");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00100");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00101");
		cities.add(ConstVar.City.CITY_ID_PRE + "00100",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00102");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101", ConstVar.City.NAME_KEY,
				"city2");
		cities.set(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.CITY_BACK_IMAGE, "images/2.jpg");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00103");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00104");
		cities.add(ConstVar.City.CITY_ID_PRE + "00101",
				ConstVar.City.FACILITIES_KEY, ConstVar.Facility.FACILITY_ID_PRE
						+ "00105");

		// 角色测试
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00100",
				ConstVar.People.NAME_KEY, "c1_j_r1");
		peoples.set(ConstVar.People.PEOPLE_ID_PRE + "00101",
				ConstVar.People.NAME_KEY, "c1_j_r2");
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
		// 设施测试
		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00100",
				ConstVar.Facility.NAME_KEY, "jiedao");
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
				ConstVar.Facility.NAME_KEY, "sheshiA");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00101",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00101",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00102");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00102",
				ConstVar.Facility.NAME_KEY, "sheshiB");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00102",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00100");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00102",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00103");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00103",
				ConstVar.Facility.NAME_KEY, "jiedao");
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
				ConstVar.Facility.NAME_KEY, "sheshiC");
		facilities
				.set(ConstVar.Facility.FACILITY_ID_PRE + "00104",
						ConstVar.Facility.CITY_KEY, ConstVar.City.CITY_ID_PRE
								+ "00101");
		facilities.add(ConstVar.Facility.FACILITY_ID_PRE + "00104",
				ConstVar.Facility.PEOPLES_KEY, ConstVar.People.PEOPLE_ID_PRE
						+ "00106");

		/***********************************************************/
		facilities.set(ConstVar.Facility.FACILITY_ID_PRE + "00105",
				ConstVar.Facility.NAME_KEY, "sheshiD");
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
	}
}
