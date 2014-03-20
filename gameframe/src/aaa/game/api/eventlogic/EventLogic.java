package aaa.game.api.eventlogic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

/**
 * 随机事件生成逻辑，用于选择事件
 */
public class EventLogic {

	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	private StringBuilder stringBuilder = null;
	private Stack<String> valueStack = null;
	private Class<?> complexLogicClass = EventLogic.class;// 存储计算复杂逻辑的函数的类
	private static final String regule = "()~!<>=&|";
	
	protected EventLogic() {
		
	}
	/**
	 * 输入事件判断字符串验证是否满足条件
	 */
	public boolean isSatisfy(String eventFlag) {
		eventFlag = eventFlag.replace("\t", ""); // 去除空字符
		eventFlag = eventFlag.replace(" ", "");
		stringBuilder = new StringBuilder(eventFlag);// 将要判断的字符串首先缓存起来，便于后面操作
		valueStack = new Stack<>();
		return logicPhrase().equals(TRUE);
	}

	private String logicPhrase() {
		String result = null;
		while (stringBuilder.length() != 0) {
			String element = getElement(stringBuilder);
			String value1 = null;
			String value2 = null;
			String symbol = null;
			if (element.equals("(")) {
				for (;;) {
					value1 = valueStack.pop();
					symbol = valueStack.pop();
					if (symbol.contains(")")) {
						valueStack.push(value1);
						break;
					} else {
						value2 = valueStack.pop();// 双目运算符
						result = calcLogicPair(symbol, value2, value1);
						valueStack.push(result);
					}
				}
			} else {
				if ("<>=~".contains(element)) {// 对于高优先级的计算，直接计算结果并返回
					value1 = valueStack.pop();
					value2 = getElement(stringBuilder);
					element = calcLogicPair(element, value2, value1);
				} else if ("!".contains(element)) {
					value1 = valueStack.pop();
					element = calcLogicPair(element, value1, null);
				}
				valueStack.push(element);
			}
		}
		return valueStack.pop();
	}

	/**
	 * 提取判断字符串的一个元素 这个元素可能是一个变量或者是一个操作符号 从右往左提取
	 */
	private String getElement(StringBuilder flag) {
		StringBuilder stringBuilder = new StringBuilder();
		char lastChar = flag.charAt(flag.length() - 1);
		if (regule.indexOf(lastChar) < 0) {
			do {
				stringBuilder.insert(0, lastChar);
				flag.deleteCharAt(flag.length() - 1);
				if (flag.length() == 0) {
					break;
				}
				lastChar = flag.charAt(flag.length() - 1);
				if (regule.indexOf(lastChar) >= 0 || lastChar == ']') {
					break;
				}
			} while (true);
			// 根据获取的字符串判断来自的数据是一个属性值，列表值或是一个复杂逻辑方法返回值计算填入的结果或数值
			return getValue(stringBuilder.toString());
		} else {
			stringBuilder.insert(0, lastChar);
			flag.deleteCharAt(flag.length() - 1);
		}
		return stringBuilder.toString();
	}

	/**
	 * 根据输入逻辑运算符和输入变量对判断逻辑计算结果 返回字符串的TRUE， FALSE
	 */
	private String calcLogicPair(String symbol, String value1, String value2) {
		char a = symbol.charAt(0);
		if (value1 != null && value1.contains("[")) {
			value1 = getBoolByFunName(getFunArgs(value1));
		}
		if (value2 != null && value2.contains("[")) {
			value2 = getBoolByFunName(getFunArgs(value2));
		}
		String result;
		switch (a) {
		case '!':
			if (value1.equals(FALSE))
				result = TRUE;
			else
				result = FALSE;
			break;
		case '=':
			if (value1.equals(value2)) {
				result = TRUE;
			} else {
				result = FALSE;
			}
			break;
		case '>': {
			Double v1Double = Double.valueOf(value1);
			Double v2Double = Double.valueOf(value2);
			if (v1Double > v2Double) {
				result = TRUE;
			} else {
				result = FALSE;
			}
			break;
		}
		case '<': {
			Double v1Double = Double.valueOf(value1);
			Double v2Double = Double.valueOf(value2);
			if (v1Double < v2Double) {
				result = TRUE;
			} else {
				result = FALSE;
			}
			break;
		}
		case '~':
			if (value1.equals(value2)) {
				result = FALSE;
			} else {
				result = TRUE;
			}
			break;
		case '&': {
			boolean v1b = value1.equals(TRUE) ? true : false;
			boolean v2b = value2.equals(TRUE) ? true : false;
			if (v1b && v2b) {
				result = TRUE;
			} else {
				result = FALSE;
			}
			break;
		}
		case '|': {
			boolean v1b = value1.equals(TRUE) ? true : false;
			boolean v2b = value2.equals(TRUE) ? true : false;
			if (v1b || v2b) {
				result = TRUE;
			} else {
				result = FALSE;
			}
			break;
		}
		default:
			result = TRUE;
			break;
		}
		return result;
	}

	/**
	 * 获得所需属性的值
	 * */
	private String getValue(String id_attr_val) {
		String []elems = id_attr_val.split(ConstVar.Event.ATTRIBUTE_SEPERATOR);
//		String []elems = id_attr_val.split(".");
		if(elems.length == 1) {
			return ShareData.globalData.get(id_attr_val);
		}
		elems[0] = ShareData.globalData.get(elems[0]);
		return ShareData.get(elems[0], elems[1]);
	}

	/**
	 * 对于过于复杂的逻辑，很难用上述方式表示的，可以 使用一个方法进行描述，通过回调方法名称，和参数返回计算的结果
	 */
	private String getBoolByFunName(ArrayList<String> args) {

		String result = null;
		String funName = args.get(0);
		Method method = null;
		if (args.size() == 1) {// 处理无参数的情况
			try {
				method = complexLogicClass.getMethod(funName);
				result = (String) method.invoke(complexLogicClass);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			int size = args.size() - 1;
			Class[] cargs = new Class[size];
			Object[] margs = new Object[size];
			for (int i = 0; i < size; i++) {
				margs[i] = args.get(i + 1);
				cargs[i] = margs[i].getClass();
			}
			try {
				method = complexLogicClass.getMethod(funName, cargs);
				result = (String) method.invoke(complexLogicClass, margs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获得方法的参数
	 */
	private ArrayList<String> getFunArgs(String funString) {
		funString = funString.replace("[", ",");
		funString = funString.replace("]", ",");
		String fun_Args[] = funString.split(",");
		ArrayList<String> result = new ArrayList<String>();
		int size = fun_Args.length;
		for (int i = 0; i < size; i++) {
			result.add(fun_Args[i]);
		}
		return result;
	}

	/**
	 * 对于过于复杂的逻辑，直接使用方法进行判断 此方法用于演示这一功能使用
	 */
	private static String flagMethod(String id1, String id2) {
		System.out.println(id1 + " " + id2);
		return TRUE;
	}

	private static String flagMethod2() {
		return FALSE;
	}

	public static void main(String[] args) {
		// StringBuilder stringBuilder = new StringBuilder("bcd");
		// stringBuilder.insert(0, 'a');
		// System.out.println(stringBuilder);
		EventLogic eventLogic = new EventLogic();
		// ArrayList<String> arg = new ArrayList<>();
		// arg.add("flagMethod");
		// arg.add("id");
		// arg.add("id2");
		// System.out.println(eventLogic.getBoolByFunName(arg));
		// System.out.println(eventLogic.getBoolByFunName(eventLogic
		// .getFunArgs("flagMethod2[]")));
		// StringBuilder stringBuilder2 = new StringBuilder(
		// "(abc!defgh~ijk[fdasf,fadf]lmnopq&rstuv&||wxyz<ABCDEF>GHIJKLMN(OPQRSTUVW)XYZ)");
		// while (stringBuilder2.length() != 0) {
		// String ret = eventLogic.getElement(stringBuilder2);
		// System.out.println(ret);
		// }
		String testString = "(((12~12|21>123)&(ab=ab))|(3<2))|(((12~12|21>123)&(ab=ab))|(3<2))";
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arr.add(testString);
		}
		long start = System.currentTimeMillis();
		for (String string : arr) {
			boolean result = eventLogic.isSatisfy(string);
		}
		long end = System.currentTimeMillis() - start;
		System.out.println(end);
	}
}
