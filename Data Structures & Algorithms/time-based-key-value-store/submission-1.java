class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Pair(value, timestamp));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            map.put(key, list);
        }
    }

    private String lowerBound(List<Pair> list, int timestamp) {
        int low = 0, high = list.size()-1, ans = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(list.get(mid).timestamp <= timestamp) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (ans == -1) ? "" : list.get(ans).value;
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) {
            return "";
        }

        return lowerBound(list, timestamp);

    }
}
