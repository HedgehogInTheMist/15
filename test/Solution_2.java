package test;

/* Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
 * а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1)
 */

public class Solution_2 {
	public static void main(String[] args) {
		int[] array = new int [50];
		int value = 1;
		for(int i = 0; i < array.length; i++) {
			array[i] = value;
			value += 2;
		}
		System.out.println("Вывод массива в прямом порядке:");
		for(int j = 0; j < array.length; j++) {
			
			System.out.print(array[j] + " ");
		}
		System.out.println("\nВывод массива в обратном порядке: ");
		for(int k = array.length - 1; k > 0; k--) {
			System.out.print(array[k] + " ");
		}
		
	}
}
