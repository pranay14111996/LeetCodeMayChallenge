package may.challenge.week1;

public class RansomNote {
	public static void main(String[] args) {
		RansomNote ransomNote = new RansomNote();
		System.out.println(ransomNote.canConstruct("aa", "aab"));
	}
/*
	public boolean canConstruct(String ransomNote, String magazine) {
		int mag[] = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			mag[magazine.charAt(i) - 'A']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--mag[ransomNote.charAt(i) - 'A'] == -1) {
				return false;
			}
		}
		return true;
	}*/
    public boolean canConstruct(String ransomNote, String magazine) {
        int mag[] = new int[26];
        for(char c : magazine.toCharArray()){
            mag[ c - 'a' ]++;
        }
        for(char c : ransomNote.toCharArray()){
            if( --mag[ c - 'a' ] == -1){
                return false;
            }
        }
        return true;
    }
}