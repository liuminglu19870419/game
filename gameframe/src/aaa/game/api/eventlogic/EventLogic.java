package aaa.game.api.eventlogic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 随机事件生成逻辑，用于选择对话的具体内容
 */
public class EventLogic {

	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	private StringBuilder stringBuilder = null;
	// private Stack<ReturnTuple<SymbolType, String>> valueStack = null;
	private Stack<String> valueStack = null;
	private Class<?> complexLogicClass = EventLogic.class;// 存储计算复杂逻辑的函数的类
	private static final String regule = "()~!<>=&|";

	private static enum SymbolType {
		CHAR, EQUAL, GRE, LES, NEQ, AND, OR, NOT, LEFT, RIGHT, FUN, TRUE, FALSE
	};

	private static class ReturnTuple<A, B> {
		public final A type;
		public final B value;

		public ReturnTuple(A a, B b) {
			type = a;
			value = b;
		}
	}

	/**
	 * 输入事件判断字符串验证是否满足条件
	 */
	public boolean isSatisfy(String eventFlag) {
		stringBuilder = new StringBuilder(eventFlag);// 将要判断的字符串首先缓存起来，便于后面操作
		valueStack = new Stack<>();
		return logicPhrase().equals(TRUE);
	}

	public String logicPhrase() {
		while (stringBuilder.length() != 0) {
			String element = getElement(stringBuilder);
			if (element.equals("(")) {
				String value1, symbol, value2;
				//出栈顺序计算方式有待于研究
			} else {
				valueStack.push(element);
			}
		}

		return null;
	}

	/**
	 * 提取判断字符串的一个元素 这个元素可能是一个变量或者是一个操作符号 从右往左提取
	 */

	// public ReturnTuple<SymbolType, String> getElement(StringBuilder flag) {
	// StringBuilder stringBuilder = new StringBuilder();
	// SymbolType symbolType = null;
	// char lastChar = flag.charAt(flag.length() - 1);
	// symbolType = getCharType(lastChar);
	// if (symbolType == symbolType.CHAR || symbolType == symbolType.FUN) {
	// do {
	// stringBuilder.insert(0, lastChar);
	// flag.deleteCharAt(flag.length() - 1);
	// if (flag.length() == 0) {
	// break;
	// }
	// lastChar = flag.charAt(flag.length() - 1);
	// if (getCharType(lastChar) != SymbolType.CHAR) {
	// break;
	// }
	// } while (true);
	// } else {
	// stringBuilder.insert(0, lastChar);
	// flag.deleteCharAt(flag.length() - 1);
	// }
	// return new ReturnTuple<SymbolType, String>(symbolType,
	// stringBuilder.toString());
	// }
	public String getElement(StringBuilder flag) {
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
		} else {
			stringBuilder.insert(0, lastChar);
			flag.deleteCharAt(flag.length() - 1);
		}
		return stringBuilder.toString();
	}

	/**
	 * 根据输入逻辑运算符和输入变量对判断逻辑计算结果 返回字符串的TRUE， FALSE
	 */
	public String calcLogicPair(String symbol, String value1, String value2) {
		char a = symbol.charAt(0);
		String result;
		switch (getCharType(a)) {
		case CHAR:
			break;
		case EQUAL:
			break;
		case GRE:
			break;
		case LES:
			break;
		case NEQ:
			break;
		case AND:
			break;
		case OR:
			break;
		case NOT:
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		case FUN:
			break;
		default:
			break;
		}
		return null;
	}

	/**
	 * 获得所需属性的值
	 * */
	public String getValue(String id_attr_val) {
		return null;
	}

	/**
	 * 根据输入的字符判断他是否是一个括弧，或者字符串 0:这个字符是一个字符的一部分 1:这个字符是一个 逻辑符 2:这个字符是一个等于符
	 * 3:这个字符是一个比较号4:这个字符是一个左括弧 5:这个字符是一个右括弧
	 * */
	public SymbolType getCharType(char a) {
		SymbolType result;
		switch (a) {
		case '=':
			result = SymbolType.EQUAL;
			break;
		case '<':
			result = SymbolType.LES;
			break;
		case '>':
			result = SymbolType.GRE;
			break;
		case '~':
			result = SymbolType.NEQ;
			break;
		case '&':
			result = SymbolType.AND;
			break;
		case '|':
			result = SymbolType.OR;
			break;
		case '!':
			result = SymbolType.NOT;
			break;
		case '(':
			result = SymbolType.LEFT;
			break;
		case ')':
			result = SymbolType.RIGHT;
			break;
		case ']':
			result = SymbolType.FUN;
			break;
		default:
			result = SymbolType.CHAR;
			break;
		}
		return result;
	}

	/**
	 * 对于过于复杂的逻辑，很难用上述方式表示的，可以 使用一个方法进行描述，通过回调方法名称，和参数返回计算的结果
	 */
	public String getBoolByFunName(ArrayList<String> args) {

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
	public ArrayList<String> getFunArgs(String funString) {
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
	public static String flagMethod(String id1, String id2) {
		System.out.println(id1 + " " + id2);
		return TRUE;
	}

	public static String flagMethod2() {
		return FALSE;
	}

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder("bcd");
		stringBuilder.insert(0, 'a');
		System.out.println(stringBuilder);
		EventLogic eventLogic = new EventLogic();
		ArrayList<String> arg = new ArrayList<>();
		arg.add("flagMethod");
		arg.add("id");
		arg.add("id2");
		System.out.println(eventLogic.getBoolByFunName(arg));
		System.out.println(eventLogic.getBoolByFunName(eventLogic
				.getFunArgs("flagMethod2[]")));
		StringBuilder stringBuilder2 = new StringBuilder(
				"(abc!defgh~ijk[fdasf,fadf]lmnopq&rstuv&||wxyz<ABCDEF>GHIJKLMN(OPQRSTUVW)XYZ)");
		while (stringBuilder2.length() != 0) {
			String ret = eventLogic.getElement(stringBuilder2);
			System.out.println(ret);
		}
	}
}
