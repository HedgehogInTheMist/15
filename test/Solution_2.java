package test;

/* �������� ������ �� ���� �������� ����� �� 1 �� 99, �������� ��� �� ����� � ������,
 * � ����� ���� �� ������ �������� �� ����� ���� � ������, �� � �������� ������� (99 97 95 93 � 7 5 3 1)
 */

public class Solution_2 {
	public static void main(String[] args) {
		int[] array = new int [50];
		int value = 1;
		for(int i = 0; i < array.length; i++) {
			array[i] = value;
			value += 2;
		}
		System.out.println("����� ������� � ������ �������:");
		for(int j = 0; j < array.length; j++) {
			
			System.out.print(array[j] + " ");
		}
		System.out.println("\n����� ������� � �������� �������: ");
		for(int k = array.length - 1; k > 0; k--) {
			System.out.print(array[k] + " ");
		}
		
	}
}
