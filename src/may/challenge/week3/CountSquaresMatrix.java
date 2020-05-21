package may.challenge.week3;

public class CountSquaresMatrix {

	int totalCount = 0;
	int[][] matrix = null;
	public static void main(String[] args) {
		int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		int[][] matrix2 = {{1,0,1},{1,1,0},{1,1,0}};
		System.out.println(new CountSquaresMatrix().countSquares(matrix));
		System.out.println(new CountSquaresMatrix().countSquares(matrix2));
		System.out.println(new CountSquaresMatrix().countSquaresDp(matrix2));
	}

	public int countSquares(int[][] matrix) {
		this.matrix = matrix;
		for (int l = 1; l <= matrix.length && l <= matrix[0].length; l++) {
			for (int i = 0; i <= matrix.length - l; i++) {
				for (int j = 0; j <= matrix[0].length - l; j++) {
					csh(i, j, l);
				}
			}
		}
		return totalCount;
	}

	public int countSquaresDp(int [][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		int dp[][] = new int[r][c];
		for(int i = 0 ; i < r ;i++) {
			if(matrix[i][0] == 1) {
				dp[i][0] = 1;}
		}
		for(int i = 1 ; i < c ;i++) {
			if(matrix[0][i] == 1) {
				dp[0][i] = 1;}
		}
		for(int i = 1;i<r;i++) {
			for(int j = 1;j<c;j++) {
				if(matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
				}
			}
		}
        int count = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){                
                count += dp[i][j];
            } 
        }
		return count;
	} 
	
	private void csh(int x, int y, int l) {
		if(l > matrix.length || l > matrix[0].length || x >=matrix.length || y >= matrix[0].length) {
			return ;
		}
		//System.out.println("l = "+l+"; x = "+x+ "; y = "+y);
		int tc = 0;
		for (int i = x; i <= x + l - 1; i++) {
			for (int j = y; j <= y + l - 1; j++) {
				if(matrix[i][j] != 1) {
					return ;
				}
			}
		}
		totalCount++;
		return;
	}
}
