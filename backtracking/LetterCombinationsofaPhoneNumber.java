package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    private List<String> createLists(String digitsVal){
        List<String> result = new ArrayList<>();
        for (String str: digitsVal.split(""))
            result.add(str);
        return result;
    }

    private List<String> createCombinations(List<String> one, List<String> two, List<String> three, List<String> four){
        List<String> first = new ArrayList<>();
        List<String> sec = new ArrayList<>();
        List<String> third = new ArrayList<>();
        //List<String> first = new ArrayList<>();
        for (String str: one) {
            if (two.isEmpty()){
                first = one;
                return first;
            }
            for (String s_str: two){
                first.add(str+s_str);
            }
        }
        for (String str: first) {
            if (three.isEmpty()){
                sec = first;
                return sec;
            }
            for (String s_str: three){
                sec.add(str+s_str);
            }
        }
        for (String str: sec) {
            if (four.isEmpty()) {
                third = sec;
                return third;
            }
            for (String s_str : four) {
                third.add(str + s_str);
            }
        }
        return third;

    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || digits.equals(""))
            return new ArrayList<>();
        Map<Integer, List<String>> list = new HashMap<>();
        for (int i=0; i<4; i++){
            list.put(i,new ArrayList<>());
        }
        Map<String, String> constVals = new HashMap<>();
        constVals.put("2", "abc");
        constVals.put("3", "def");
        constVals.put("4", "ghi");
        constVals.put("5", "jkl");
        constVals.put("6", "mno");
        constVals.put("7", "pqrs");
        constVals.put("8", "tuv");
        constVals.put("9", "wxyz");
        String digitsArr[] = digits.split("");
        for (int i=0; i<digitsArr.length; i++){
            list.put(i,createLists(constVals.get(digitsArr[i])));
        }
        //System.out.println(list);

        return createCombinations(list.get(0), list.get(1), list.get(2), list.get(3));
    }
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lc = new LetterCombinationsofaPhoneNumber();
        System.out.println(lc.letterCombinations("234"));
    }
}
