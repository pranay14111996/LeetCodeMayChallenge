package may.challenge.week4;

import may.challenge.utils.PrintUtils;

public class CountingBits {
	public static void main(String[] args) {
		int res[] = new CountingBits().countBits(16);
		PrintUtils.printArray(res);
	}
    public int[] countBits(int num) {
    	int[] dp = new int[num+1];
        for(int i = 1 ; i <= num;i++) {
        	dp[i] = (i&1) + dp[i>>1];
        }
        return dp;
    }

}
