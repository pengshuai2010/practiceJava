package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/6/16.
 */
public class Q271_EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.

    /**
     * The idea is use "%#%" as delimiter, and use "##" to escape "#". So "%#%" escaped to "%##%".
     * When decoding, we can simply use split() to get an array of strings, and restore each string by replace "##" back
     * to "#".
     */
    public String encode(List<String> strs) {
        if (strs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.replace("#", "##")).append("%#%");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        if (s == null) {
            return strs;
        }
        //note that if call split() with only one argument, trailing empty string will be discarded
        //when calling split(String regx, int n), if n > 0, the regx will be applied at most (n - 1) times, i.e. the length of returned array is
        // at most n; if n < 0, there's no limit, the returned array can have any length; if n == 0, there's no limit either, but the tailing empty
        // will be discarded.
        //
        // In this problem, we need to distinguish [] -> "", [""] -> "%#%" and ["", ""] -> "%#%%#%". so we need the tailing empty string to indicate
        // difference of the former two.
        String[] arr = s.split("%#%", -1);
        for (int i = 0; i < arr.length - 1; i++) {
            strs.add(arr[i].replace("##", "#"));
        }
        return strs;
    }
}
