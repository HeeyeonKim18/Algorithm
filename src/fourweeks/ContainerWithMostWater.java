package fourweeks;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
        System.out.println(maxArea(new int[] { 1, 2, 3, 4, 5, 6 }));
        System.out.println(maxArea(new int[] { 4, 1, 2, 3, 4 }));
        System.out.println(maxArea(new int[] { 2, 9, 1, 9, 2 }));
        System.out.println(maxArea(new int[] { 5, 5, 5, 5 }));
        System.out.println(maxArea(new int[] { 9, 8, 7, 1, 1, 1, 1 }));
    }

    private static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int max = 0;
        while (left < right) {
            int leftH = height[left], rightH = height[right];
            int width = right - left;
            max = Math.max(Math.min(leftH, rightH) * width, max);

            if (leftH < rightH) {
                int cur = leftH;
                while (left < right && height[left] <= cur)
                    left++;
            } else {
                int cur = rightH;
                while (left < right && height[right] <= cur)
                    right--;
            }
        }

        return max;
    }
}
