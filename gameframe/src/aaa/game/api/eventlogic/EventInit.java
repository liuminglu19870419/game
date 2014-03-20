package aaa.game.api.eventlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

/**
 * 用于初始化事件参数，判断事件是否具有发生条件
 */
public class EventInit {
	private static EventLogic eventLogic = new EventLogic();
	private String eventId = null;

	protected EventInit() {

	}

	/**
	 * 初始化随机事件
	 */
	public String init(String eventTypeId) {
		String[] eventIdStrings = ShareData.eventTypes.get(eventTypeId,
				ConstVar.EventType.EVENTSUBSET_LIST).split(
				ConstVar.LIST_ELEMENT_SEPERATOR);
		List<String> eventList = new ArrayList<>();
		for (String string : eventIdStrings) {
			if (initBasicParam(string)) {
				eventList.add(string);
			}
		}
		return randomEvent(eventList);
	}

	/**
	 * 从符合条件的事件中随机选取一个发生
	 */
	private String randomEvent(List<String> eventList) {
		double total = 0;
		Random random = new Random(System.currentTimeMillis());
		for (String string : eventList) {
			String tempValue = ShareData.events.get(string,
					ConstVar.Event.EVN_PRIORITY);
			if (tempValue == null || tempValue.equals("")) {
				total += 1.0;
			} else {
				total += Double.parseDouble(tempValue);
			}
		}
		for (String string : eventList) {
			String tempValue = ShareData.events.get(string,
					ConstVar.Event.EVN_PRIORITY);
			double prob = 0;
			if (tempValue == null || tempValue.equals("")) {
				prob = 1.0 / total;
			} else {
				prob = Double.parseDouble(ShareData.events.get(string,
						ConstVar.Event.EVN_PRIORITY)) / total;
			}
			if (prob > random.nextDouble()) {
				return string;
			}
		}
		return eventList.get(0);
	}

	/**
	 * 事件参数初始化 返回该事件是否满足触发条件
	 */
	public boolean initBasicParam(String eventId) {
		this.eventId = eventId;
		String eventFlag = ShareData.events.get(eventId,
				ConstVar.Event.EVN_FLAG);
		if (eventFlag == null || eventFlag.equals("") || eventFlag.equals("()")) {// 无条件事件
			return true;
		}
		return eventLogic.isSatisfy(eventFlag);
	}

	public static void main(String[] args) {
		String a[] = "fad".split("");
		System.out.println(a.length);
		ShareData.globalData.set(ConstVar.GlobalData.MAIN_ROLE,
				ConstVar.People.PEOPLE_ID_PRE + "00000");
		ShareData.globalData.set(ConstVar.GlobalData.CUR_CITY_ID,
				ConstVar.City.CITY_ID_PRE + "00100");
		ShareData.globalData.set(ConstVar.GlobalData.CUR_FACILITY_ID,
				ConstVar.Facility.FACILITY_ID_PRE + "00100");
		ShareData.globalData.set(ConstVar.GlobalData.CUR_PEOPLE_ID,
				ConstVar.People.PEOPLE_ID_PRE + "00100");
		EventInit eventInit = new EventInit();
		String eventid = eventInit.init(ConstVar.EventType.EVENTSUBSET_ID_PRE
				+ "00100");
		System.out.println(eventid);
		EventDialog eventDialog = new EventDialog();
		List<Map<String, String>> dialogList = eventDialog.initDialog(eventid);
		for (Map<String, String> map : dialogList) {
			System.out.println(map.get(ConstVar.Event.ROLE_ID) + ":"
					+ map.get(ConstVar.Event.DIALOG));

		}
	}
}
