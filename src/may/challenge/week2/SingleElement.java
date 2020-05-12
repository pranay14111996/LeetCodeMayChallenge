package may.challenge.week2;

public class SingleElement {

	public static void main(String[] args) {
		SingleElement singleElement = new SingleElement();
		int[] nums = {1,1,2,2,3,4,4};
		System.out.println(singleElement.singleNonDuplicate(nums));
	}
    public int singleNonDuplicate(int[] nums) {
        int unique = nums[0];
        for(int i = 1; i < nums.length; i++){
            unique ^=nums[i];
        }
        return unique;
    }
}
