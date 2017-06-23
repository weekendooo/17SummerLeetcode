package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// MAP degree <w, 0> <r, 1> <t, 1> <f, 1> <e, 1>
//MAP map <t, f> <w, e> <r, t> <e, r>

public class No269AlienDictionary {

	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            
            for (int index = 0; index < length; index++) {
                char c1 = cur.charAt(index);
                char c2 = next.charAt(index);

                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    Set<Character> value = map.get(c1);
                    if (value != null) set = value;  // ?? set.add(value);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c: degree.keySet()) {
            if (degree.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.remove();
            sb.append(c);
            Set<Character> value = map.get(c);
            if (value != null) {
                for (char c2 : value) {
                    degree.put (c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) queue.add(c2);
                }
            }
        }
        
        if (sb.length() != degree.size()) return "";
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
