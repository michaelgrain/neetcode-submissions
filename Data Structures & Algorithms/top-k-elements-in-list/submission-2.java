class Solution {
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    // Bucket теперь HashMap, а не массив!
    Map<Integer, List<Integer>> bucket = new HashMap<>();
    int maxFreq = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        int count = entry.getValue();
        bucket.computeIfAbsent(count, x -> new ArrayList<>()).add(entry.getKey());
        maxFreq = Math.max(maxFreq, count);
    }
    
    int[] result = new int[k];
    int idx = 0;
    for (int i = maxFreq; i >= 1 && idx < k; i--) {
        if (bucket.containsKey(i)) {
            for (int num : bucket.get(i)) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
    }
    return result;
}}
