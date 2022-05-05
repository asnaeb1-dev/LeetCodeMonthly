package May2022;

/**Question - 3rd May
 * Given an integer array nums,
 * you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */

/**
 * Explanation:
 *
 *
 */
public class May3_ShortestUnsortedSubarray {
    public static void main(String[] args) {
        int[] a = {7, 6, 8, 14, 10, 9, 15};
        int x = shortestSubarray(a, a.length);
        System.out.println(x);
    }
    private static int shortestSubarray(int[] a, int n){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            if(i == 0){
                if(a[i] > a[i + 1]){
                    min = Integer.min(min, a[i]);
                    max = Integer.max(max, a[i]);
                }
            } else if(i == n - 1){
                if(a[i] < a[i - 1]){
                    min = Integer.min(min, a[i]);
                    max = Integer.max(max, a[i]);
                }
            } else {
                if(a[i] < a[i - 1] || a[i] > a[i + 1]){
                    min = Integer.min(min, a[i]);
                    max = Integer.max(max, a[i]);
                }
            }
        }

//        System.out.println(min + ", " + max);
        if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) return 0;

        int start = -1, end = -1;
        for(int i = 0;i<n;i++){
            if(a[i] > min){
                start = i;
                break;
            }
        }
        for(int i = n - 1;i>=0;i--){
            if(a[i] < max){
                end = i;
                break;
            }
        }

        return end - start + 1;
    }
}
