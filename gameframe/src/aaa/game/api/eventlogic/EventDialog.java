package aaa.game.api.eventlogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

/**
 * 将对话初始化为一个可以直接供api调用的对话
 */
public class EventDialog {
	List<Map<String, String>> dialogs = null;// 当前事件全部对话内容，需要使用arraylist类型，保证插入顺序与原来对话顺序一致

	public List<Map<String, String>> initDialog(String eventId) {
		String[] tempDialogs = ShareData.events.get(eventId,
				ConstVar.Event.EVN_DIALOG).split(
				ConstVar.Event.EVN_DIALOG_SEPERATOR);// 将共享数据中的对话按照对话分割符分割为独立的对话数据集合
		// 每个对话数据集合内部可能有若干属性用于区分该对话的性质
		dialogs = new ArrayList<Map<String, String>>();// 初始化用来保存对话的队列
		for (String string : tempDialogs) {
			if (string.equals("")) {
				continue;
			}
			String linePhrase[] = string
					.split(ConstVar.Event.EVN_DIALOG_NUM_SEPERATOR);//去除对话前部用于标记对话序号的数字，后面直接使用数组下标作为对话跳转的依据
			String lineEleSet = linePhrase[0];
			if (linePhrase.length > 1) {
				lineEleSet = linePhrase[1];
			}
			dialogs.add(dialogPhrase(lineEleSet));
		}
		return dialogs;
	}

	private Map<String, String> dialogPhrase(String dialog) {
		Map<String, String> dialogContent = new HashMap<String, String>();
		String[] dialogElem = dialog
				.split(ConstVar.Event.EVN_DIALOG_ELM_SEPERATOR);
		if (dialogElem.length == 2) {
			dialogContent.put(ConstVar.Event.TYPE, ConstVar.Event.TYPE_D);
			dialogContent.put(ConstVar.Event.DIALOG, dialogElem[1]);
			dialogContent.put(ConstVar.Event.ROLE_ID, ShareData.globalData.get(dialogElem[0]));
		}
		return dialogContent;
	}
}
