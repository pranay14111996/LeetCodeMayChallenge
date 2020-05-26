package may.challenge.week4;

import java.util.HashMap;
import java.util.Map;

public class MaxZeroOnes {
	public static void main(String[] args) {
		//int A[] = { 1, 0, 1, 0, 1, 0, 0, 1, 1 };
		int A[] = { 0,1,1,0,1,1,1,0};
		System.out.println(new MaxZeroOnes().findMaxLength(A));
	}

	public int findMaxLength(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int max = 0;
		for(int i = 0 ; i < nums.length ;i++) {
			if(nums[i] == 0 ) {
				sum +=-1;
			} 
			else {
				sum +=1;
			}
			if(map.containsKey(sum)) {
				max = Math.max(max,i - map.get(sum));
			}
			else {
				map.put(sum, i);
			}
		}
		return max;
	}
}
