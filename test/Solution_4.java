package test;

import java.util.Random;

/*
 * Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран в строку. 
 * Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на экран на отдельной строке.
 */

public class Solution_4 {
	 public static void main(String[] args) {
		 Random random = new Random();
		 int[] array = new int[8];
		 for(int i = 0; i < array.length; i++) {
			 array[i] = random.nextInt(10) + 1;
		 }
		 for(int j = 0; j < array.length; j++) {
			 System.out.print(array[j] + " ");
		 }
		 System.out.println();
		 for(int j = 0; j < array.length; j+=2) {
			 array[j] = 0;
		 }
		 for(int k = 0; k < array.length; k++) {
			 System.out.print(array[k] + " ");
		 }
	 }
}