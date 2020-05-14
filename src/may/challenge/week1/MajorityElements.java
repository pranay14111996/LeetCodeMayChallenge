package may.challenge.week1;

public class MajorityElements {
	public int majorityElement(int[] nums) {
		return majorityElement(nums, 0);
	}

	private int majorityElement(int[] nums, int start) {
		int maj = nums[start];
		int majCount = 1;
		for (int i = start+1; i < nums.length; i++) {
			if (nums[i] == maj)
				majCount++;
			else {
				majCount--;
			}
			/*
			 * we considered the first element as maj and we were iterating and if majCount
			 * == 0 we have assumed wrong and ask the rest for the array starting from i+1
			 * cause till this i index majElement is not found and we hence search in rest
			 * of array for majElement remember that the majority element always occupy more
			 * than half of array.
			 */
			if (majCount == 0) {
				return majorityElement(nums, i + 1);
			}
		}
		return maj;
	}
}
