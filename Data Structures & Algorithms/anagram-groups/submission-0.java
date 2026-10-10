class Solution {
    private String getSortedString(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        return new String(sArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String word = strs[i];
            String sortedWord = getSortedString(word);

            List<String> anagramGroup = map.getOrDefault(sortedWord, new ArrayList<String>());

            anagramGroup.add(word);

            map.put(sortedWord, anagramGroup);
        }

        return new ArrayList<>(map.values());


    }
}