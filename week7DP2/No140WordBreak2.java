package backtrackHard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No140WordBreak2 {
	Map<String, List<String>> map = new HashMap<>();
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> value = map.get(s);
        if (value != null) return value;
        
        List<String> res = new LinkedList<>();
	    if (s.length() == 0) {
		    res.add("");
		    return res;
	    }
        
        for (String word : wordDict) {
		    if (s.startsWith(word)) {
			    List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
			    for (String sub : sublist)
				    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
		    }
	    }
        
        map.put(s, res);
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
