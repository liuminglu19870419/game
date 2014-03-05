package aaa.test.libtest;

public class StringBuilderLengthTest {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(stringBuilder.length());
		stringBuilder.append("");
		System.out.println(stringBuilder.length());
		stringBuilder.append("test");
		System.out.println(stringBuilder.length());
	}
}
