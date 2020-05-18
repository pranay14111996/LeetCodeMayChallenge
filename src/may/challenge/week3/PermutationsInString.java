package may.challenge.week3;

public class PermutationsInString {
	public static void main(String[] args) {
		PermutationsInString permutationsInString = new PermutationsInString();
		System.out.println(permutationsInString.checkInclusion("ab", "eidbaooo"));
	}
    public boolean checkInclusion(String p, String s) {
		if(p.length() > s.length()) {
			return false;
		}
		int[] pa = new int[26];
		int[] ta = new int[26];
		int i = 0 ;
		for(; i < p.length() ;i++) {
			pa[p.charAt(i) - 'a']++;
			ta[s.charAt(i) - 'a']++;
		}
		for(; i < s.length() ;i++ ) {
			if(compare(ta,pa)) {
                return true;
			}
			ta[s.charAt(i) - 'a']++;
			ta[s.charAt(i-p.length()) - 'a']--;
		}
		if(compare(ta,pa)) {
			return true;
		}
		return false;
    }
    private boolean compare(int s[], int p[]) 
    { 
        for (int i = 0; i < 26; i++) 
            if (s[i] != p[i]) 
                return false; 
        return true; 
    }
}
