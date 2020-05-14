package may.challenge.week2;

import java.util.Arrays;

public class TrieDS {

	class TrieNode {
		TrieNode[] nodes = new TrieNode[26];
		boolean isEndOfWord = false;

		@Override
		public String toString() {
			return "TrieNode [nodes=" + Arrays.toString(nodes) + ", isEndOfWord=" + isEndOfWord + "]";
		}

	}

	TrieNode root = null;

	public TrieDS() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word != null && word.length() != 0)
			insertHelper(root, word, 0);
	}

	private void insertHelper(TrieNode root, String word, int i) {
		if (i >= word.length()) {
			return;
		}
		if (root == null) {
			root = new TrieNode();
		}
		if (root.nodes[word.charAt(i) - 'a'] == null) {
			root.nodes[word.charAt(i) - 'a'] = new TrieNode();
		}
		if (i == word.length() - 1) {
			root.nodes[word.charAt(i) - 'a'].isEndOfWord = true;
		}
		insertHelper(root.nodes[word.charAt(i) - 'a'], word, i + 1);
	}

	public boolean search(String word) {
		if (word != null && word.length() != 0)
			return searchHelper(root, word, 0);
		return false;
	}

	private boolean searchHelper(TrieNode root, String word, int i) {
		if (root == null) {
			return false;
		}
		if (i >= word.length() || root.nodes[word.charAt(i) - 'a'] == null) {
			return false;
		}
		if (i == word.length() - 1 && root.nodes[word.charAt(i) - 'a'].isEndOfWord) {
			return true;
		}
		return searchHelper(root.nodes[word.charAt(i) - 'a'], word, i + 1);
	}

	public boolean startsWith(String prefix) {
		return startsWithHelper(root, prefix, 0);
	}

	private boolean startsWithHelper(TrieNode root, String prefix, int i) {
		if (root == null)
			return false;
		if (i >= prefix.length() || root.nodes[prefix.charAt(i) - 'a'] == null) {
			return false;
		}
		if (i == prefix.length() - 1 && root.nodes[prefix.charAt(i) - 'a'] != null) {
			return true;
		}
		return startsWithHelper(root.nodes[prefix.charAt(i) - 'a'], prefix, i + 1);
	}

	public static void main(String[] args) {
		TrieDS obj = new TrieDS();
		String word = "apple";
		obj.insert(word);
		System.out.println(obj.search(word));
		System.out.println(obj.search(word + "e"));
		System.out.println(obj.search("appl"));
		String prefix = "apt";
		System.out.println(obj.startsWith(prefix));
	}
}
