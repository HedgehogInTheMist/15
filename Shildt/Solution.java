package Shildt;

public class Solution {
	public static void main(String[] args) {
		Shared shared = new Shared();
		new Producer(shared);
		new Consumer(shared);
		
	}
}
