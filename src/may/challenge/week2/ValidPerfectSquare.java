package may.challenge.week2;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
		System.out.println(validPerfectSquare.isPerfectSquare(Integer.MAX_VALUE));
		validPerfectSquare.findLargePerfectInt(); //46340
	}

	public boolean isPerfectSquare(int num) {
		long start = 1;
		long end = num;
		while(start < end) {
			long mid = start + (end - start)/2;
			if(mid * mid == num)
				return true;
			else if( mid * mid < num ) {
				start = mid +1;
			}
			else
				end = mid -1;
		}
		return false;
	}
	
	private void findLargePerfectInt() {
		System.out.println((long)46341*46341);
		System.out.println(Integer.MAX_VALUE);
	}
}
