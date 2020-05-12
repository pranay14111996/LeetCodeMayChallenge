package may.challenge.week2;

public class FloodFill {
	public static void main(String[] args) {
		/*int[][] image = { 
				{1,1,1},
				{1,1,0},
				{1,0,1} };*/
		int[][] image = { 
				{0,0,0},
				{0,1,1}};
		FloodFill ff = new FloodFill();
		ff.floodFill(image, 1, 1, 1);
		
		for(int[] i : image){
			for(int j : i) {
				System.out.print(j +" ");
			}
			System.out.println();
		}
	}
	int oldColor = 0;
	int[][] image = null;
	int newColor = 0;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		this.image = image;
		this.newColor = newColor;
		this.oldColor = image[sr][sc];
		floodFillHelper(sr,sc);
		return image;
	}
	private void floodFillHelper(int sr, int sc) {
		if(sr < 0 || sc <0 || sr >= image.length || sc>=image[0].length) {
			return;
		}
        if(image[sr][sc] == newColor){
            return;
        }
		if(image[sr][sc] == oldColor) {
			image[sr][sc] = newColor;
			floodFillHelper(sr-1, sc);
			floodFillHelper(sr+1, sc);
			floodFillHelper(sr, sc-1);
			floodFillHelper(sr, sc+1);
		}
	}
}
