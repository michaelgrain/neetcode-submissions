class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty())
        {
            return "";
        }

        // Считаем требуемое количество каждого символа из t
        Map<Character, Integer> tCounts = new HashMap<>();
        for (char c : t.toCharArray())
        {
            tCounts.merge(c, 1, Integer::sum);
        }

        int requiredUniqueSymbols = tCounts.size();   // сколько уникальных символов нужно "закрыть"
        int formedUniqueSymbols = 0;                  // сколько уникальных символов уже набрали в нужном количестве

        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestLeft = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char charAtRight = s.charAt(right);
            windowCounts.merge(charAtRight, 1, Integer::sum);

            if (tCounts.containsKey(charAtRight)
                    && windowCounts.get(charAtRight).intValue() == tCounts.get(charAtRight).intValue())
            {
                formedUniqueSymbols++;
            }

            // Пытаемся сжать окно слева, пока оно валидно
            while (formedUniqueSymbols == requiredUniqueSymbols)
            {
                if (right - left + 1 < bestLen)
                {
                    bestLen = right - left + 1;
                    bestLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (tCounts.containsKey(leftChar) && windowCounts.get(leftChar) < tCounts.get(leftChar))
                {
                    formedUniqueSymbols--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
        
    }
}
