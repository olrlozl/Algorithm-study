import java.util.*;

class Solution {
    public String work(String s) {
        String tmp = "";

        for(int i = 1; i <= s.length(); i++) {
            String u = s.substring(0, i);
            String v = s.substring(i, s.length());

            if(count(u) && count(v)) {
                if(check(u)) {
                    return u + work(v);
                }
                else {
                    return "(" + work(v) +  ")" + reverse(u);
                }
            }
        }

        return tmp;
    }
    public boolean check(String p) { //올바른
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                stack.push('(');
            }
            else if(!stack.isEmpty()) {
                stack.pop();
            }
            else return false;
        }

        if(!stack.isEmpty()) return false;
        else return true;
    }
    public boolean count(String s) { //균형
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else count--;
        }

        if(count == 0) return true;
        else return false;
    }
    public String reverse(String s) {
        String tmp = "";

        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '(') tmp += ")";
            else tmp += "(";
        }

        return tmp;
    }
    public String solution(String p) {
        String answer = "";

        if(check(p)) {
            answer = p;
        }
        else if(count(p)){
            answer = work(p);
        }

        return answer;
    }
}