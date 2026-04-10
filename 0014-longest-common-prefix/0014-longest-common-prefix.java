class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();

        Arrays.sort(strs);
        String st = strs[0];
        String end = strs[strs.length-1];

        for(int i=0 ; i<Math.min(st.length(),end.length());i++){

            if(st.charAt(i)!=end.charAt(i)){
                return ans.toString();
            }

            ans.append(st.charAt(i));
        }

        return ans.toString();
        
    }
}