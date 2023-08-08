package algo;

import java.util.Arrays;

public class P12915 {
	public static void main(String[] args) {
		
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		String[] answer = {};
		
		for (int i=0; i<strings.length; i++) {
			for (int j=0; j<strings.length-1; j++) {
				if (strings[j].charAt(n) >= strings[j+1].charAt(n)) {
					String temp = strings[j+1];
					strings[j+1] = strings[j];
					strings[j] = temp;
				}
//				else if (strings[j].charAt(n) == strings[j+1].charAt(n)) {
//					
//				}
			}
		}
		System.out.println(Arrays.toString(strings));
	}
}
