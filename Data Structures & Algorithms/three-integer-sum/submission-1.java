class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < n; i++)
        {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++)
            {
                // Считаем в long, чтобы избежать переполнения int при больших значениях
                long complementLong = 0L - nums[i] - nums[j];

                if (complementLong >= Integer.MIN_VALUE && complementLong <= Integer.MAX_VALUE)
                {
                    int complement = (int) complementLong;

                    if (seen.contains(complement))
                    {
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], complement));
                        Collections.sort(triplet); // для консистентной дедупликации
                        resultSet.add(triplet);
                    }
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
        
    }
}
