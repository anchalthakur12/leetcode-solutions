class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length()){
            return false;
        }

        String S = s+s;
        return S.contains(goal);
    }
}