package may.challenge.week1;

public class JewelsStones {
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		JewelsStones jewelsStones = new JewelsStones();
		System.out.println( jewelsStones.numJewelsInStones(J, S) );
	}
    public int numJewelsInStones(String J, String S) {
        int jewels[] = new int[52 	];
        //Store characters of J in jewels array according to ASCII values in index
        for( int i = 0;i <J.length() ;i++ ) {
        	jewels[J.charAt(i) - 'A'] = 1;
        }
        int count = 0 ;
        for( int i = 0;i <S.length() ;i++ ) {
        	if(jewels[S.charAt(i) - 'A'] == 1) {
        		count++;
        	}
        }
       return count;
    }
}
