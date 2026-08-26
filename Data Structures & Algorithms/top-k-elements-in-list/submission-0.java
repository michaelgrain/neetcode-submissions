class Solution {
public int[] topKFrequent(int[] nums, int k) {
    int n = nums.length;
    
    // Шаг 1: считаем частоту каждого числа — O(n)
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    // Шаг 2: раскладываем числа по корзинам согласно частоте — O(n) в худшем случае
    List<Integer>[] bucket = new List[n + 1];
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        int num = entry.getKey();
        int count = entry.getValue();
        if (bucket[count] == null) {
            bucket[count] = new ArrayList<>();
        }
        bucket[count].add(num);
    }
    
    // Шаг 3: идём с конца (от самой высокой частоты), собираем k чисел — O(n)
    int[] result = new int[k];
    int idx = 0;
    for (int i = n; i >= 0 && idx < k; i--) {
        if (bucket[i] != null) {
            for (int num : bucket[i]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
    }
    
    return result;
}}
