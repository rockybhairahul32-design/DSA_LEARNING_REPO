class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int left = 0;
            
            while (left < s.length()) {
                int right = left;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) {
                    right++;
                }
                next.append(right - left).append(s.charAt(left));
                left = right;
            }
            
            s = next.toString();
        }
        
        return s;
    }
}