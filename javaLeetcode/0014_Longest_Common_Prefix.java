class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ("");
        int minlen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minlen) minlen = s.length();
        }
        for (int i=0;i<minlen;i++) {
            for (String s : strs) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    // System.out.println("once");
                    if (i>0) return (strs[0].substring(0,i));
                    return ("");
                }
            }
            if (i == minlen - 1) {
                // System.out.println("once");
                return (strs[0].substring(0,i+1));
            }
        }
        return ("");
    }
}
