package test;

/*—оздайте массив из всех чЄтных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку, 
отдел€€ один элемент от другого пробелом, а затем в столбик (отдел€€ один элемент от другого началом новой строки). 
ѕеред созданием массива подумайте, какого он будет размера.*/


public class Solution {
	public static void main(String[] args) {
		int [] arr = new int [10];
		//for (int i = 0, b = 0; b++ < 20; arr[i++] = ++b);
		int data = 2;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = data;
			data += 2;
		}
		
		
		
		
		for(int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
		for(int el : arr) {
			System.out.println(el);
		}
	}
}
