package May2022;

import java.util.Arrays;

/**Question:
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */

/**
 * Explanation:
 *
 * We are using 2 pointer approach here.
 * We need to place 2 pointers; namely i and j at 0th and n - 1th position of the array.
 * For every situation one of 4 conditions might occur: (by reading the question we know that the even elements belong to the left hand side of the array and odd element belong to the right hand side of the array; the pointer i represents the left hand side and the pointer j represents the right hand side of the array)
 *
 * 1. The element on the ith position is even and element on the jth position is odd ->
 * This means that both the elements are currently in the correct places in the array, so there is no need for any changes. When this situation is encountered, we simply move ahead i.e. (i++ & j--)
 *
 * 2. The element on the ith position is odd and element on the jth position is even ->
 * This means that both the elements are currently in the wrong places in the array, so we need to change. When this situation is encountered we swap the elements at ith and jth position (swap(i, j)) and then we move ahead (i++, j--).
 *
 * 3. The element on the ith position is even and the element on the jth position is also even ->
 * This means that one the element is currently in the wrong place in the array, which is the jth element which by rule should be odd. When this situation is encountered, we simply move the pointer of the element which is in the right place since it requires no change.(i++). Here, i requires no change since it is even;
 *
 * 4. The element on the ith position is odd and the element on the jth position is also odd ->
 * This means that one the element is currently in the wrong place in the array, which is the ith element which by rule should be even. When this situation is encountered, we simply move the pointer of the element which is in the right place since it requires no change.(j--).
 */
public class May2_SortByParity {
    public static void main(String[] args) {
        int[] a = {5,4,1,5,2,6,7,2,5,7,6};
        sortArrayByParity(a);
        System.out.println(Arrays.toString(a));
    }
    public static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 == 0 && nums[j] % 2 != 0){
                i++;
                j--;
            }else if(nums[i] % 2 != 0 && nums[j] % 2 == 0){
                swap(nums, i, j);
                i++;
                j--;
            }else if(nums[i] % 2 == 0){
                i++;
            }else{
                j--;
            }
        }
        return nums;
    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
