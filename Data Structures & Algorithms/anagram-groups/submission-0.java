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
        int[] count = new int[26];
        for (char c : str.toCharArray())
        {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : count)
        {
            sb.append(c).append('#');
        }
        return sb.toString();
    }
}