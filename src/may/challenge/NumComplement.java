package may.challenge;

public class NumComplement {
	public static void main(String[] args) {
		NumComplement numComplement = new NumComplement();
		System.out.println(numComplement.findComplement(5));
		System.out.println(numComplement.findComplement2(5));
	}

	public int findComplement(int N) {
		if (N == 0) {
			return 1;
		}
		int count = 0;
		int comp = 0;
		while (N > 0) {
			if ((N & 1) == 0) {
				comp = comp + (int) Math.pow(2, count);
			}
			N = N >> 1;
			count++;
		}
		return comp;
	}

	/**
	 * Complement of number can we calculated by subtracting given num with it's
	 * equivalent length of 1 binary
	 * 
	 * @param N
	 * @return complement of given number N
	 */
	public int findComplement2(int N) {
		int comp = N;
		int oneStream = 0;
		while (N > 0) {
			oneStream = (oneStream << 1) + 1;
			N >>= 1;
		}
		return oneStream - comp;

	}
}
