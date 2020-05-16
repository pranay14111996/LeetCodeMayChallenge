package may.challenge.week3;

/**
 * @author cpranay
 *
 */
public class CircularMaxSum {
	public static void main(String[] args) {
		CircularMaxSum circularMaxSum = new CircularMaxSum();
		int[] A = {3,-2,2,-1,3};
		System.out.println(circularMaxSum.maxSubarraySumCircular(A));
	}
	
	/**
	 * See this link
	 * @see <a href = "https://www.youtube.com/watch?v=kssIQAIg9c8">Max sum in circular array</a>
	 * @param A
	 * @return
	 */
	public int maxSubarraySumCircular(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int K = kadaneAlgo(A);
		if(K<0) {
			return K;
		}
		int totalArraySum = 0 ;
		for(int i = 0; i < A.length; i++) {
			totalArraySum +=A[i];
			A[i] = -A[i];
		}
		int negativeK = kadaneAlgo(A);
		return Math.max(K, totalArraySum+negativeK);
	}
	private int kadaneAlgo(int A[]) {
		int cs = A[0];
		int ms = A[0];
		for(int i = 1; i < A.length; i++) {
			cs = Math.max(A[i], cs+A[i]);
			ms = Math.max(cs, ms);
		}
		return ms;
	}
}
