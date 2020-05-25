package may.challenge.week4;

public class UncrossedLines {
	public static void main(String[] args) {
		int A[] = {1,4,2};
		int B[] = {1,2,4};
		System.out.println(new UncrossedLines().maxUncrossedLines(A, B));
	}

	public int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length+1][B.length+1];
		for(int i = 1; i < A.length+1 ;i++) {
			for(int j = 1; j < B.length+1 ;j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[A.length][B.length];
	}
}
