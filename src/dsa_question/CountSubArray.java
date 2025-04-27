package dsa_question;



/*
Input: nums = [1,2,1,4,1]
Output: 1
Explanation:
Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers
equals half the middle number.


 */
public class CountSubArray {

    public static void main(String[] args) {
        System.out.println("Number of sub-array of length 3 i.e. ( sum of the first and third number equal exactly half of the second number ).");
        int[] nums = {1, 2, 1, 4, 1};
        int result = countSpecialSubarrays(nums);
        System.out.println("Result: " + result);
    }

    public static int countSpecialSubarrays(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1])*2== nums[i]) {
                count++;
            }
        }
        return count;
    }
}
