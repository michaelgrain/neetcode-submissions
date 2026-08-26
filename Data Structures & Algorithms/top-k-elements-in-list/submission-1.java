class Solution {
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    // Превращаем в список пар и сортируем по частоте (по убыванию)
    List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
    entries.sort((a, b) -> b.getValue() - a.getValue());
    
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = entries.get(i).getKey();
    }
    return result;
}    
}
