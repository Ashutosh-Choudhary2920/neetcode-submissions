class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] array = str.toCharArray();

            Arrays.sort(array);

            String key = new String(array);

            List<String> anagrams = map.getOrDefault(key, new ArrayList<String>());

            anagrams.add(str);

            map.put(key, anagrams);
        }

        return new ArrayList<>(map.values());

    }
}
