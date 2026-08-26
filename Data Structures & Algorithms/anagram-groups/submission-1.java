class Solution 
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs)
        {
            String key = buildKey(str);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    private static String buildKey(String str)
    {
        Map<Character, Integer> count = new TreeMap<>(); // Tree is not necessary but better for debug
        for (char c : str.toCharArray())
        {
            count.merge(c, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : count.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}
