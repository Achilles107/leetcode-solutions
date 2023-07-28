package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

    private StringBuilder alphabets = new StringBuilder();
    private boolean visited[] = new boolean[26];
    private boolean cycle = false;
    private void createAlphabets(char currChar, Map<Character, List<Character>> relations) {
        if (alphabets.toString().contains(""+currChar))
            return;
        if (alphabets.length() == relations.size())
            return;
        if (visited[currChar - 'a']) {
            cycle = true;
            return;
        }
        visited[currChar - 'a'] = true;
        List<Character> predecessors = relations.get(currChar);
        for (char pred: predecessors) {
            createAlphabets(pred, relations);
        }
        alphabets.append(currChar);
        visited[currChar - 'a'] = false;
    }

    private Map<Character, List<Character>> createRelation(String words[]) {
        Map<Character, List<Character>> relations = new HashMap<>();

        for (String word: words) {
            for (int ch =0; ch<word.length(); ch++) {
                relations.put(word.charAt(ch), new ArrayList<>());
            }
            if (relations.size() == 26)
                break;
        }
        for (int idx =0; idx<words.length-1; idx++) {
            int len = Math.min(words[idx].length(), words[idx+1].length());
            int j =0;
            if (words[idx].length() > words[idx+1].length() && words[idx].startsWith(words[idx+1])) {
                cycle = true;
                return relations;
            }
            while (j<len && words[idx].charAt(j) == words[idx+1].charAt(j)){
                j++;
            }
            if (j!=len){
                List<Character> parentChars = relations.get(words[idx + 1].charAt(j));
                if (!parentChars.contains(words[idx].charAt(j))) {
                    parentChars.add(words[idx].charAt(j));
                }
            }
        }
        return relations;
    }
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> relations = createRelation(words);
        if (cycle)
            return "";
        for (char ch: relations.keySet()) {
            if (!alphabets.toString().contains(""+ch)){
                createAlphabets(ch, relations);
            }
        }
        if (cycle)
            return "";
        return this.alphabets.length() == relations.size() ? alphabets.toString() : "";
    }
    public static void main(String[] args) {
        String words[] = {"abc","ab"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
