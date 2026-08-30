class Solution {
    public int characterReplacement(String s, int k) 
    {
        int[] count = new int[26]; // счётчик частоты букв в текущем окне
        int left = 0;
        int maxCount = 0;   // максимальная частота одной буквы в текущем окне
        int result = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            count[c - 'A']++;

            // обновляем максимальную частоту буквы в окне
            maxCount = Math.max(maxCount, count[c - 'A']);

            // размер окна - самая частая буква = сколько символов надо заменить
            int windowSize = right - left + 1;
            if (windowSize - maxCount > k)
            {
                // окно невалидно, сжимаем слева
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            // окно валидно (или уже было сжато до валидного размера)
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
