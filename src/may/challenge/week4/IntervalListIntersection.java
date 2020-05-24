package may.challenge.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
	public static void main(String[] args) {
		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		int[][] inter = new IntervalListIntersection().intervalIntersection(A, B);
		for(int[] i : inter) {
			System.out.println("["+i[0]+","+i[1]+"]");
		}
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> intersection = new ArrayList<>();
		int a = 0; int b =0;
		while(a < A.length && b < B.length) {
			//check if A's a and B's b intersect
			int start = Math.max(A[a][0], B[b][0]);
			int end = Math.min(A[a][1],B[b][1]);
			if(start <= end) {
				intersection.add(new int[]{start,end});
			}
			// check which is smaller bit and increase to refer to next to this smaller bit
			if( A[a][1] < B[b][1] ) {
				a++;
			}
			// this also covers the equal case
			else {
				b++;
			}
		}
		return intersection.toArray(new int[intersection.size()][]);
	}
}
