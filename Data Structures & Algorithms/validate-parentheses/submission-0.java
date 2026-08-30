class Solution {
    public boolean isValid(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray())
        {
            if (isOpenBracket(c))
            {
                stack.push(c);
            }
            else
            {
                char prev = Optional.ofNullable(stack.peek()).orElse(' ');
                if (isValidCloseBracket(c, prev))
                {
                    stack.poll();
                }
                else
                {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isValidCloseBracket(char c, char prevBracket)
    {
        switch (c)
        {
            case '}':
                if (prevBracket != '{')
                    return false;
                break;
            case ']':
                if (prevBracket != '[')
                    return false;
                break;
            case ')':
                if (prevBracket != '(')
                    return false;
                break;
            default:
                return true;
        }

        return true;
    }

    private boolean isOpenBracket(char c)
    {
        if (c == '{' || c == '[' || c == '(' )
        {
            return true;
        }

        return false;
    }
}
