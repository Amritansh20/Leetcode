/*
    I almost got it corrent. 
    What i did wrong was : everytime i find a potential ans I moved 
    indexS1 to the end of curret poetential ans.This will prevent me
    from better better answer in some cases.
    eg : "abcdbebe" , "bbe"

    So, what did i miss?
    Once we exhaust indexS2 we do not keep it in ans.
    we move back again until i exhaust the s2 again to find the start of my 
    potential ans. 
    the momemt i exhaust my s2 from back to front I will consider this as 
    potential ans. 

    T.C - O(n*m)
    indexS1 will go till n
    if i find an ans then indexS2 will again go back till 0
    In worst case I can will get an potentail ans everytime I move indexS1.
    

 */
public class Minimum_Sliding_Subsequence {
    public String minwindow(String s1, String s2){
        int indexS1 =0;
        int indexS2=0;
        int start=-1;
        int end=-1;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        while(indexS1<s1.length()){
            if(s1.charAt(indexS1)==s2.charAt(indexS2)){
                indexS2++;

                if(indexS2==s2.length()){
                    start = indexS1;
                    end = indexS1;

                    indexS2--;

                    while(indexS2>=0){
                        if(s1.charAt(start) == s2.charAt(indexS2)){
                            indexS2--;
                        }
                        start--;
                    }
                    start++;
                    if((end-start+1)<minLen){
                        minLen=end-start+1;
                        ans = s1.substring(start, end+1);
                    }
                    indexS1=start;
                    indexS2=0;
                }
            }
            indexS1++;
        }
        return ans;
    }
}
