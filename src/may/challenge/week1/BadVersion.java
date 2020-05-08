package may.challenge.week1;
public class BadVersion {
	
	private static final int n = 5;
	private static final int badVersion = 4;
	
	int search_hops = 0 ;
	public static void main(String[] args) {
		BadVersion badVersion = new BadVersion();
		System.out.println( "badVersion = "+ badVersion.firstBadVersion(n)+", search hops = "+badVersion.search_hops );
	}
	public int firstBadVersion(int n) {
        return helper(1, n);
        /*
		int start = 1;
		int end = n;
		int mid = -1;
		while(start < end) {
			search_hops++;
			mid = (int) Math.ceil((start+end)/2.0);
			if(isBadVersion(end)) {
				if(!isBadVersion(mid)) {
					start = mid+1;
				}
				else {
					end = mid -1;
				}
			}
		}
		return n%2==0?mid:mid-1;
	    */    
	}
	boolean isBadVersion(int n) {
		return n >= badVersion;
	}
    private int helper(int up, int down) {
        int mid = up + (down - up) /2;
        if(up >= down) {
            return up;
        }
        if(isBadVersion(mid)) {
            return helper(up, mid);
        } else {
            return helper(mid + 1, down);
        }
    }
}
