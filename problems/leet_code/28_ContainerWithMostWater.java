/* Container with most water
 *
 * Given n non negative integers (a1, a2, ...., an), where each represents
 * a point at coordinate (i, ai). n vertical lines are drawn such that
 * two endpoints of line i is at (i, ai) and (i, 0). Find two lines which,
 * together with x-axis forms a container, such that the container contains
 * the most water
 *
 * Notice: you may not slant the container and 
 *
 */

class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                area = Math.max(area, height[l] * (r - l));
                l++;
            } else {
                area = Math.max(area, height[r] * (r - l));
                r--;
            }
        }

        return area;
    }

    public static void main(String args[]) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution sol = new Solution();
        System.out.println(sol.maxArea(h));
    }
}

