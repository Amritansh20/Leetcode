package Strings;

/*
    This problem uses the concept of Next Permutation. 

    Approach: 
    1- We store the count of chars of s
    2- We check each substring of target that weather it can be kept of not. 
    3- If a substring can be kept, the next char is updated with "just" greator char and rest ahead in sorted fashion.
    4- If a substring cannot be kept, we simply check another.

 */
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
        freq[ch-'a']++;

        for(int i=s.length()-1;i>=0;i--){
            int[] clonedFreq = freq.clone();
            String str = target.substring(0,i);
            boolean canBe = true;

            for(int j=0;j<str.length();j++){
                clonedFreq[str.charAt(j)-'a']--;

                if(clonedFreq[str.charAt(j)-'a']<0){
                    canBe = false;
                    break;
                }
            }

            if(canBe==false)
            continue;

            int u = target.charAt(i)-'a';
            for(int c=u+1;c<26;c++){
                if(clonedFreq[c]>0){
                    clonedFreq[c]--;

                    StringBuilder st = new StringBuilder();

                    for(int j=0;j<26;j++){
                        for(int k=0;k<clonedFreq[j];k++){
                            st.append((char) (j+'a'));
                        }
                    }
                    return str + (char) ('a'+c)+ st.toString();
                }
            }

        }
        return "";
    }
}