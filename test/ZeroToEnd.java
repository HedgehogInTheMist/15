package test;

import java.util.Random;

public class ZeroToEnd {
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[15];
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		System.out.println("Исходный массив: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				sb.append(array[i]);
			} else count++;
		}
		
		for(int i = 0; i < count; i++) {
			sb.append(0);
		}
		
		String str = sb.toString();
		char[] arrayChar = str.toCharArray();
		System.out.println("Измененный массив: ");
		for(int i = 0; i < arrayChar.length; i++) { 
			System.out.print(arrayChar[i] + " ");
		}
	
	}
}
