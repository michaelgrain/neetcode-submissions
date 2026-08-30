class Solution {
    public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // нашли
            }
            
            // Определяем, какая половина отсортирована
            if (nums[left] <= nums[mid]) {
                // Левая половина отсортирована
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target в левой половине
                } else {
                    left = mid + 1;  // target в правой половине
                }
            } else {
                // Правая половина отсортирована
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // target в правой половине
                } else {
                    right = mid - 1; // target в левой половине
                }
            }
        }
        
        return -1; // не найдено        
    }
}
