package may.challenge.week2;

public class RemoveKNumbers {
	private String result = "";
	public static void main(String[] args) {
		RemoveKNumbers removeKNumbers = new RemoveKNumbers();
		String num = "10200";
		System.out.println(removeKNumbers.removeKdigits(num, 1));
	}
    public String removeKdigits(String num, int k) {
        if(k == 0) {
        	result+=num;
        	return removeTrailingZeros(result);
        }
        if( num.length() <= k ) {
        	return removeTrailingZeros(result);
        }
        int minIdx = 0;
        for( int i = 1; i <= k ;i++ ) {
        	if( num.charAt(i) < num.charAt(minIdx)  ) {
        		minIdx = i;
        	}
        }
        result += num.charAt(minIdx);
        removeKdigits(num.substring(minIdx+1), k-minIdx);
        return removeTrailingZeros(result);
    }
    private String removeTrailingZeros(String string) {
    	if(string.length() == 0 ) {
    		return "0";
    	}
    	int nonZeroIdx = string.length();
    	for(int i = 0 ; i < string.length(); i++) {
    		if(string.charAt(i) != '0') {
    			nonZeroIdx = i;
    			break;
    		}
    	}
    	return nonZeroIdx == string.length()?"0":string.substring(nonZeroIdx);
	}
}
