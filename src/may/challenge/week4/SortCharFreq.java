package may.challenge.week4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharFreq {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		PriorityQueue pq = new PriorityQueue<Character>((a,b)->map.get(b)-map.get(a));
		map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
				.forEach(record -> {
					Character key = record.getKey();
					int value = record.getValue();
					for (int i = 0; i < value; i++) {
						sb.append(key);
					}
				});

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "Aabb";
		System.out.println(new SortCharFreq().frequencySort(str));
	}
}
