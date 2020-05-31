package may.challenge.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BipartiteElements {
	Map<Integer,Set<Integer>> map = new HashMap<>();
	int visited[] = null;
	public static void main(String[] args) {
		//int[][] A = {{1,2},{2,3},{3,4},{4,5}};
		int[][] A = {};
		int N = 1;
		System.out.println(new BipartiteElements().possibleBipartition(N, A));
	}
    public boolean possibleBipartition(int N, int[][] dislikes) {
    	visited = new int[N+1];
    	Arrays.fill(visited, -1);
        // create graph
    	for(int[] pair : dislikes) {
    		map.putIfAbsent(pair[0], new HashSet<Integer>());
    		map.putIfAbsent(pair[1], new HashSet<Integer>());
    		map.get(pair[0]).add(pair[1]);
    		map.get(pair[1]).add(pair[0]);
    	}
    	// we use for loop in case the graph is disconnecting
    	for(int i = 1 ; i < N; i++) {
    		if(visited[i] == -1 && !dfs(i,0)) {
    			return false;
    		}
    	}
    	return true;
    }
	private boolean dfs(int vertex, int lvl) {
		if( visited[vertex] == -1 ) {
			visited[vertex] = lvl;
		}
		else {
			return visited[vertex] == lvl;
		}
		for( int next : map.get(vertex) ) {
			if(!dfs(next, 1-lvl)) {
				return false;
			}
		}
		return true;
	}
}
