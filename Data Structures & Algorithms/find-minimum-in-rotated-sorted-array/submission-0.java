class Solution {
    public int findMin(int[] nums) {
      int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Минимум находится справа от mid
                left = mid + 1;
            } else {
                // Минимум находится в mid или левее него
                right = mid;
            }
        }
        
        return nums[left];        
    }
}
