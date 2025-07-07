/*
    Generate all substring. 
    Check if sustring is palindrome or not?
    If yes, compare lengths and store max.
 */
class Solutions {
    public boolean isPalindrome(String str){
        int left =0;
        int right= str.length()-1;

        while(left<=right){
            if(str.charAt(left)!=str.charAt(right))
            return false;

            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = Integer.MIN_VALUE;
        int startIndex=-1;
        int endIndex=-1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String str = s.substring(i,j);
                if(isPalindrome(str)){
                    if(j-i>len){
                    len = Math.max(len,j-i);
                    startIndex=i;
                    endIndex=j;
                    }
                }
            }
        }
        return s.substring(startIndex,endIndex);
    }
}

/*Optimized. Extension of Longest common substring.
    you make your dp table as longest common substring. 

    When you iterate in dp table to find the max length you have to 
    check that the substring into considertaion is a palindrome 
    or not. 
    A indexs of palindrome in original string s and reversed string str
    are mirrored. Use this idea to check.

    Time-O(n^2)
    Space - O(n^2)
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        StringBuilder str = new StringBuilder(s);
        str.reverse();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==str.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = 0;
            }
        }

        int maxLen= -1;
        int endIndex=-1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){

                int start_in_original_string = i-dp[i][j];
                int start_in_rev_string = n-j;

                if(start_in_original_string==start_in_rev_string && dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    endIndex=i;
                }
            }
        }

       return s.substring(endIndex-maxLen,endIndex);
    }
}