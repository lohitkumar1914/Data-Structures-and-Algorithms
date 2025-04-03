class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] minWindow = {0, Integer.MAX_VALUE};
        int targetCharsCount = t.length();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch: t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        int startIdx = 0;
        
        for (int endIdx = 0; endIdx < s.length(); endIdx++) {
            char endC = s.charAt(endIdx);
            if (charCount.containsKey(endC) && charCount.get(endC) > 0) {
                targetCharsCount--;
            }
            charCount.put(endC, charCount.getOrDefault(endC, 0) - 1);

            if (targetCharsCount == 0) {

                while (true) {
                    char start = s.charAt(startIdx);
                    if (charCount.containsKey(start) && charCount.get(start) == 0) break;

                    charCount.put(start, charCount.getOrDefault(start, 0) + 1);
                    startIdx++;
                }

                if (endIdx - startIdx < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIdx; 
                    minWindow[1] = endIdx;
                }

                char c = s.charAt(startIdx);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                startIdx++;
                targetCharsCount++;
            }
        }
        return minWindow[1] == Integer.MAX_VALUE ? "" : s.substring(minWindow[0], minWindow[1]+1);
    }
}