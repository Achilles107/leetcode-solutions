package binary_search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeBasedKeyValueStore {
    class TimeMap {

        HashMap<String, ArrayList<Pair<Integer, String>>> timeMap;

        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!timeMap.containsKey(key)) {
                timeMap.put(key, new ArrayList<Pair<Integer, String>>());
            }
            timeMap.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!timeMap.containsKey(key)) {
                return "";
            }

            ArrayList<Pair<Integer, String>> time = timeMap.get(key);

            if (timestamp < time.get(0).getKey()) {
                return "";
            }

            if (timestamp >= time.get(time.size() - 1).getKey()) {
                return time.get(time.size() - 1).getValue();
            }

            // binary search

            int left = 0;
            int right = time.size();

            while (left < right) {
                int mid = (left + right) / 2;
                if (time.get(mid).getKey() <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (right == 0)
                return "";

            return time.get(right - 1).getValue();
        }
    }
}
