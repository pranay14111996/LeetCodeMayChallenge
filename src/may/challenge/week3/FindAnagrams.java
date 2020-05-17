package may.challenge.week3;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		FindAnagrams findAnagrams = new FindAnagrams();
		System.out.println( findAnagrams.findAnagrams(s, p) );
	}

	public List<Integer> findAnagrams(String s, String p) {
		if(p.length() > s.length()) {
			return new ArrayList<>();
		}
		int[] pa = new int[26];
		int[] ta = new int[26];
		List<Integer> result = new ArrayList<>();
		int i = 0 ;
		for(; i < p.length() ;i++) {
			pa[p.charAt(i) - 'a']++;
			ta[s.charAt(i) - 'a']++;
		}
		for(; i < s.length() ;i++ ) {
			if(compare(ta,pa)) {
				result.add(i - p.length());
			}
			ta[s.charAt(i) - 'a']++;
			ta[s.charAt(i-p.length()) - 'a']--;
		}
		if(compare(ta,pa)) {
			result.add(i - p.length());
		}
		return result;
	}
	
    private boolean compare(int s[], int p[]) 
    { 
        for (int i = 0; i < 26; i++) 
            if (s[i] != p[i]) 
                return false; 
        return true; 
    } 
}
