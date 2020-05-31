package may.challenge.week5;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	List<Integer>[] g = null;
	boolean[] visited = null;
	int[] inDegree = null;
	public static void main(String[] args) {
		int numCourses = 6;
		int[][] prerequisites = {{4,2},{0,1},{0,2},{3,0},{5,4},{1,3}};
		//int[][] prerequisites = {{0,1},{2,0},{1,2}};
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        g = new List[numCourses];
        inDegree = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length ;i++){
        	if(g[prerequisites[i][1]]==null || g[prerequisites[i][1]].isEmpty()) {
        		g[prerequisites[i][1]] = new ArrayList<>();
        	}
        	g[prerequisites[i][1]].add(prerequisites[i][0]);
        	inDegree[prerequisites[i][0]]++;
        }
        boolean hasIndegree = false;
        for(int i = 0 ; i<inDegree.length; i++) {
        	visited = new boolean[numCourses];
        	if(inDegree[i] == 0) {
        		hasIndegree = true;
        		if(!dfs(i))
        			return false;
        	}
        }
        return hasIndegree;
    }

	private boolean dfs(int v) {
		if(visited[v]) {
			if(null == g[v])
				return true;
			return false;
		}
		if(!visited[v]) {
			visited[v] = true;
			if(null == g[v])
				return true;
			for(int next : g[v]) {
				if( !dfs(next) ) {
					return false;
				}
			}
		}
		return true;
	}
}
