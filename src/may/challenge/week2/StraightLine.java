package may.challenge.week2;

public class StraightLine {
	public static void main(String[] args) {
		StraightLine straightLine = new StraightLine();
		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6}};
		System.out.println(straightLine.checkStraightLine(coordinates));
	}
    public boolean checkStraightLine(int[][] coordinates) {
    	if(coordinates.length == 2) {
    		return true;
    	}
    	// slope = (x2-x1)/(y2-y1) 
    	int slope = (coordinates[1][1] - coordinates[0][1])==0?-1:(coordinates[1][0] - coordinates[0][0])/(coordinates[1][1] - coordinates[0][1]);
    	int[] initial = {coordinates[0][0],coordinates[0][1]};
    	for(int i = 1; i< coordinates.length;i++) {
    		if((coordinates[i][1]-initial[1]) == 0 && slope != -1) {
    			return false;
    		}
    		if((coordinates[i][1]-initial[1]) != 0 && slope != (coordinates[i][0]-initial[0])/(coordinates[i][1]-initial[1])) {
    			return false;
    		}
    	}
    	return true;
    }
}
