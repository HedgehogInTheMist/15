package test;

import java.util.Random;

/* Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран. 
 * Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.
 */
public class Solution_3 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[15];
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(9);
			System.out.print(array[i] + " ");
		}
		int even = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j] % 2 == 0 && array[j] != 0) {
				even ++;
			}
		}
		System.out.print("\nКоличество четных элементов в массиве: " + even);
	}
}
