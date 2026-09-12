/*
You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Constraints:

All elements of nums are distinct.
1 <= nums.length <= 20
2 <= nums[i] <= 30
2 <= target <= 30
*/

/*
Backtracking (поиск с возвратом) — это метод перебора, при котором мы строим решение шаг за шагом, и как только видим, что текущий путь не может привести к правильному ответу (или уже привёл), мы "откатываемся" назад и пробуем другой вариант.

В задаче с комбинациями это выглядит так:

Выбор — на каждом шаге мы решаем: взять текущий элемент nums[i] ещё раз или перейти к следующему элементу nums[i+1].
Ограничение (constraint) — если sum > target, эта ветка бесперспективна — отсекаем её (pruning).
Цель (goal) — если sum == target, значит текущий путь — валидная комбинация, сохраняем её копию в результат.
Откат (backtrack) — после того как мы попробовали взять элемент и рекурсивно исследовали все продолжения, мы убираем его из текущего пути (path.remove(...)), чтобы попробовать следующий вариант — не брать этот элемент вообще.

Ключевой момент, почему числа не повторяются в разном порядке (например, [2,2,3] и [3,2,2] не считаются разными): мы всегда идём по индексам вперёд (не назад), то есть на шаге i разрешаем брать либо nums[i] снова, либо двигаться к nums[i+1], но никогда не возвращаемся к nums[i-1]. Это гарантирует, что элементы в найденной комбинации идут в неубывающем порядке индексов — а значит, дубликатов комбинаций не будет.
*/

class Solution 
{
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, target, 0, 0, path, result);
        return result;
    }

    private void backtrack(int[] nums, int target, 
                            int start, int sum,
                            List<Integer> path, 
                            List<List<Integer>> result) 
                            {
        // Цель достигнута — сохраняем копию текущего пути
        if (sum == target) 
        {
            result.add(new ArrayList<>(path));
            return;
        }

        // Отсекаем бесперспективные ветки
        if (sum > target) 
        {
            return;
        }

        // Перебираем элементы начиная с индекса start (не назад!)
        for (int i = start; i < nums.length; i++) 
        {
            // Выбор: добавляем элемент в путь
            path.add(nums[i]);

            // Рекурсивно идём дальше, разрешая снова взять nums[i] (передаём i, а не i+1)
            backtrack(nums, target, i, sum + nums[i], path, result);

            // Откат (backtrack): убираем элемент, чтобы попробовать без него
            path.remove(path.size() - 1);
        }
    }
/*
    // Пример использования
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = sol.combinationSum(nums, target);
        System.out.println(res); // [[2, 2, 3], [7]]
    }
*/
}