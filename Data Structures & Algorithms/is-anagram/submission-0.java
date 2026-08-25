class Solution {
    public boolean isAnagram(String s1, String s2) {
        Hashtable<Character, Integer>  t1 = new Hashtable<>(s1.length());
        Hashtable<Character, Integer>  t2 = new Hashtable<>(s1.length());

        if( s1.length() != s2.length() )
        {
            return false;
        }

        for (int i=0; i<s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            t1.put(c1, t1.getOrDefault(c1, 0) + 1);
            t2.put(c2, t2.getOrDefault(c2, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : t1.entrySet())
        {
            Character key1 = entry.getKey();
            Integer value1 = entry.getValue();

            if (!value1.equals(t2.getOrDefault(key1, 0)))
            {
                return false;
            }
        }

        return true;

    }
}
