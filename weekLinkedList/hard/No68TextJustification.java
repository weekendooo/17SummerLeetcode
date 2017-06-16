package StringHard;

import java.util.ArrayList;
import java.util.List;

public class No68TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int gaps = last - index - 1;
            
            if (last == words.length || gaps == 0) {     // 最后一行左对齐，单词间1个空格，最后补足maxWidth
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            }
            else {
                int spaces = (maxWidth - count) / gaps;  // 非最后一行，单词间空格均匀分配，不能整除，左边多空格。
                int rest = (maxWidth - count) % gaps;
                for (int i = index + 1; i < last; i++) {
                    for(int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if(rest > 0) {
                        sb.append(" ");
                        rest--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
