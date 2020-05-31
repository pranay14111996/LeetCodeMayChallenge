package may.challenge.week5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
	public static void main(String[] args) {
		int[][] points = {{-5,4},{-6,-5},{4,6}};//41 61 52
		System.out.println(Arrays.deepToString(new KClosestPoints().kClosest(points, 2)));
	}

	public int[][] kClosestUsingSort(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> (Double.compare(getEuclideanDist(p1), getEuclideanDist(p2))));
		System.out.println(Arrays.deepToString(points));
		return Arrays.copyOfRange(points, 0, K);
	}
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1,p2) -> (Double.compare(getEuclideanDist(p2), getEuclideanDist(p1))));
		for(int[] point : points) {
			maxHeap.add(point);
			if(maxHeap.size() > K) {
				maxHeap.remove();
			}
		}
		int[][] closest = new int[K][2];
		while(K >0) {
			closest[--K] = maxHeap.remove();
		}
		return closest;
	}

	private double getEuclideanDist(int[] p) {
		return Math.sqrt(p[0] * p[0] + p[1] * p[1]);
	}
}
