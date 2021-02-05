import java.io.*;
import java.util.HashMap;

class Solution {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("foo", 1);
        hm.put("bar", 2);
        for (String i : hm.keySet())
            System.out.println(hm.get(i));
    }
}
