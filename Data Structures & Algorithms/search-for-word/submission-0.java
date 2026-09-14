/*
Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.

For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
*/

/*
Классическая задача решается через DFS/backtracking: перебираем все клетки как стартовые, из каждой пытаемся построить путь, соответствующий слову, помечая посещённые клетки временно (например, спецсимволом), чтобы не использовать их повторно.

Как это работает
Перебор стартовых точек — слово может начинаться с любой клетки, поэтому проверяем все rows * cols позиций.
DFS с индексом — на каждом шаге сравниваем текущий символ клетки с нужным символом слова (word.charAt(index)).
Пометка посещённых клеток — временно заменяем символ на '#', чтобы не пройти по той же клетке дважды в рамках одного пути.
Backtracking — после того как ветка рекурсии отработала (успешно или нет), возвращаем исходный символ обратно, чтобы клетка могла использоваться в других путях.
Базовый случай — если index == word.length(), значит все буквы найдены — возвращаем true.
*/

class Solution 
{
    private int rows, cols;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) 
    {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int index) 
    {
        // Все символы слова найдены
        if (index == word.length()) 
        {
            return true;
        }

        // Проверка границ и совпадения символа
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || board[r][c] != word.charAt(index)) 
        {
            return false;
        }

        // Помечаем клетку как посещённую
        char temp = board[r][c];
        board[r][c] = '#';

        // Идём в 4 направлениях
        boolean found = dfs(r + 1, c, index + 1)
                || dfs(r - 1, c, index + 1)
                || dfs(r, c + 1, index + 1)
                || dfs(r, c - 1, index + 1);

        // Возвращаем исходное значение (backtrack)
        board[r][c] = temp;

        return found;
    }
}