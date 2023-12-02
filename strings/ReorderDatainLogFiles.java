package strings;

import java.util.*;

public class ReorderDatainLogFiles {

    boolean isDigitLog(String content) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char digit : digits) {
            if (content.charAt(0) == digit)
                return true;
        }
        return false;
    }

    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        List<Integer> orderOfDigits = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for (int idx = 0; idx < len; idx++) {
            String content = logs[idx].split(" ", 2)[1];
            if (isDigitLog(content)) {
                orderOfDigits.add(idx);
            } else {
                letterLogs.add(logs[idx]);
            }
        }
        if (orderOfDigits.size() == len) {
            return logs;
        }

        Comparator<String> order = (o1, o2) -> {
            String log1[] = o1.split(" ", 2);
            String log2[] = o2.split(" ", 2);

            String cont1 = log1[1];
            String cont2 = log2[1];
            int cmp = cont1.compareTo(cont2);
            if (cmp == 0) {
                String id1 = log1[0];
                String id2 = log2[0];
                return id1.compareTo(id2);
            }
            return cmp;
        };
        Collections.sort(letterLogs, order);
        String[] resultLogs = new String[len];
        int idx = 0;
        for (String letterLog : letterLogs) {
            resultLogs[idx] = letterLog;
            idx++;
        }
        for (int ord : orderOfDigits) {
            resultLogs[idx] = logs[ord];
            idx++;
        }
        return resultLogs;
    }

    public static void main(String[] args) {

    }
}
