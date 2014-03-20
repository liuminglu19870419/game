package aaa.game.api.eventlogic;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

public class EventResult {
	protected EventResult() {

	}

	/**
	 * 执行第index个结局
	 */
	public void execResult(String result) {
		String[] elemStrings = result.split(ConstVar.Event.ATTRIBUTE_SEPERATOR);
		String idPre = elemStrings[0].substring(0, 3);
		switch (idPre) {
		// 处理人物属性的改变
		case ConstVar.People.PEOPLE_ID_PRE: {
			execResultPeople(elemStrings);
			break;
		}
		default:
			break;
		}
	}

	private void execResultPeople(String[] elemStrings) {
		String orginValue = ShareData.peoples.get(elemStrings[0],
				elemStrings[1]);
		try {
			Double.parseDouble(elemStrings[3]);
			double curresult = 0;
			if (orginValue == null) {
				orginValue = "0";
			}
			if (elemStrings[2].equals("+")) {
				curresult = Double.parseDouble(orginValue)
						+ Double.parseDouble(elemStrings[3]);
			} else if (elemStrings[2].equals("-")) {
				curresult = Double.parseDouble(orginValue)
						- Double.parseDouble(elemStrings[3]);
				if (curresult < 0) {
					curresult = 0;
				}
			} else {
				curresult = Double.parseDouble(elemStrings[3]);
			}
			ShareData.peoples.set(elemStrings[0], elemStrings[1],
					Double.toString(curresult));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			if (elemStrings[2].equals("+")) {
				ShareData.peoples.add(elemStrings[0], elemStrings[1],
						elemStrings[3]);
			} else if (elemStrings[2].equals("-")) {
				ShareData.peoples.delete(elemStrings[0], elemStrings[1],
						elemStrings[3]);
			} else {
				ShareData.peoples.set(elemStrings[0], elemStrings[1],
						elemStrings[3]);
			}
		}
	}
}
