package test;

/*�������� ������ �� ���� ������ ����� �� 2 �� 20 � �������� �������� ������� �� ����� ������� � ������, 
������� ���� ������� �� ������� ��������, � ����� � ������� (������� ���� ������� �� ������� ������� ����� ������). 
����� ��������� ������� ���������, ������ �� ����� �������.*/


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
