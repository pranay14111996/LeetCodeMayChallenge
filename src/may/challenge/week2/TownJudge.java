package may.challenge.week2;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {
		//Lets assume if a trusts b then 
		//b's truster is a
		//a's trustee is b
		int[] trustersCount = new int[1001];
		int[] trusteesCount = new int[1001];
		int judge = 0;
		for (int[] pair : trust) {
				trusteesCount[pair[0]]++;
				trustersCount[pair[1]]++;
			if (trustersCount[pair[1]] == N - 1) {
				judge = pair[1];
			}
		}
		return trusteesCount[judge]!=0?-1:judge;
	}

	public static void main(String[] args) {
		TownJudge townJudge = new TownJudge();
		//int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int[][] trust = {{1,3},{2,3}};
		System.out.println(townJudge.findJudge(3, trust));
	}
}
