package Util;

import java.util.ArrayList;
import java.util.List;

public class CustomSplit  {
    public static List<String> mySplit(String input) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            StringBuilder splits = new StringBuilder();
            while(i < input.length() && input.charAt(i) != ',') {
                splits.append(input.charAt(i));
                i++;
            }
            if(splits.charAt(0) == '"') splits.deleteCharAt(0);
            if(splits.charAt(splits.length()-1) == '"') splits.deleteCharAt(splits.length()-1);
            result.add(splits.toString());
            i++;
        }
        return result;
    }

}
