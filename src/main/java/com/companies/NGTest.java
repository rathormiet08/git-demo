package com.companies;

public class NGTest {

	public static void main(String[] args) {
		// String str = "this_is_a_variable";
		String str = "thisIsAVariable";
		String res = modifyVariable(str);

		System.out.println("response====" + res);
	}

//	private static String modifyVariable(String str) {
//		if (str.length() == 0 && str == null || str == "") {
//			throw new IllegalArgumentException("enter proper string::");
//		}
//		
//		StringBuffer sb=new StringBuffer();
//		if(str.contains(String.valueOf('_'))) {
//			String[] ar=str.split("_");
//			for (String st : ar) {
//				char[] ch = st.toCharArray();
//				if(Character.isLowerCase(ch[0])) {
//					ch[0]=Character.toUpperCase(ch[0]);
//					
//				}else {
//					sb.ap
//				}
//			}
//		}else {
//			
//		}
//	}

	private static String modifyVariable(String str) {

		StringBuffer sb = new StringBuffer();

		if (str.contains(String.valueOf('_'))) {
			String[] st = str.split("_");
			String[] ar = new String[st.length - 1];
			for (int i = 1; i < st.length; i++) {
				ar[i - 1] = st[i];
			}

			for (String s : ar) {
				char ch[] = s.toCharArray();
				if (Character.isLowerCase(ch[0])) {
					ch[0] = Character.toUpperCase(ch[0]);

				}
				sb.append(ch);
			}
			sb.insert(0, st[0]);
		} else {
			for (Character c : str.toCharArray()) {
				if (Character.isUpperCase(c)) {
					c = Character.toLowerCase(c);
					sb.append("_").append(c);

				} else {

					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
