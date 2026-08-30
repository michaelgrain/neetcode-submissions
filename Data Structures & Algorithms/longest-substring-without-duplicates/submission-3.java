class Solution {
public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            // пока текущий символ уже есть в окне — сжимаем окно слева
            while (window.contains(c))
            {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
