package may.challenge.week1;

public class FirstUniqueChar {
	public static void main(String[] args) {
		FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
		System.out.println(firstUniqueChar.firstUniqChar(""));
	}
    public int firstUniqChar(String s) {
    	int uniqueIndex = -1;
    	int[] uniq = new int[26];
    	for(int i = s.length()-1 ; i >= 0;i--) {
    		uniq[ s.charAt(i) -'a']++;
    	}
    	for(int i = 0;i<s.length();i++) {
    		if(uniq[ s.charAt(i) -'a'] == 1) {
    			return i;
    		}
    	}
    	return uniqueIndex;
    }
}
