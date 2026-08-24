class Solution {
    public boolean hasDuplicate(int[] nums) {
    
        HashSet<Integer> unique = Arrays.stream(nums)
                             .boxed()
                             .collect(Collectors.toCollection(HashSet::new));
        return unique.size() != nums.length;
    }
}