/**
 * https://leetcode.com/problems/type-of-triangle/description/?envType=daily-question&envId=2025-05-19
 */
public class TypeofTriangle {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        if (a == b && b == c)
            return "equilateral";
        if (a >= b + c || b >= a + c || c >= a + b)
            return "none";

        return a != b && b != c && a != c ? "scalene" : "isosceles";
    }
}
