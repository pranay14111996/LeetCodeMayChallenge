package may.challenge.utils;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
	Set<String> permutations = new HashSet<>();
	char[] path = null;
	boolean[] visited = null;
	String str = null;
	public static void main(String[] args) {
		String str = "abc";
		Permutations permutations = new Permutations();
		System.out.println(permutations.findPermuations(str));
	}

	private Set<String> findPermuations(String str) {
		this.str = str;
		path = new char[str.length()];
		visited = new boolean[path.length];
		permutationHelper(0);
		return permutations;
	}

	private void permutationHelper(int idx) {
		if (idx == path.length) {
			permutations.add(String.valueOf(path));
			return;
		}
		for (int i = 0; i < path.length; i++) {
			if (!visited[i]) {
				path[idx] = str.charAt(i);
				visited[i] = true;
				permutationHelper(idx + 1);
				visited[i] = false;
			}
		}
	}
}
