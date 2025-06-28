/* 
    First Let's understand rabin_karp Algo.
    -> Rabin karp works on calculation of hash (rolling hash) values.
    -> If there are two string "abc" and "abc" It is sure that the hash values of both this string will be same.
    -> But point to be noted -> If is also true that if there are two different strings and their hash values 
    are same. 
    -> and because of this whenever we find that the hash values are same we check the strings are same or not. 
    
    Rolling over source string is like sliding window.
    -> If window size is > targetLength we remove the hash value from the left char which is out of window 
    and add the new incoming char (hash value). 

    -> Source string = "efgabcjkl" 
    -> target string = "abc" 
    We need to check each window of source (of size = targetLength) to check if hash values matches or not.
    If it matches we check if strings are same or not. If yes we return the starting index of the string window.

    The concept is easy to understand. Problem comes when we calculate the hash.
    Well, there is no specific way to calculate the hash. you have to introduce one hash function of your own 
    or a already known one.

    We know that if hashes are equal strings may or may not be same. That is why we introduce prime as 
    it reduces the chances of different strings having a same hash. There can be same hash values of 
    different strings but probablity is low.
    If we don't use prime the chances of different strings having same hash is high. 

    Time = O(n) and when there are way too many collisions it may lead to O(n^2). 
    Here collsions means two different strings having same hash values.

    The problem after understanding the rabin karp is simple. 
    The q is asking what is the minimum number of times you need to concanate string a such tha string b becomes
    it's substring?

    -> In order for b to be a substring of string a. length of string a should>= length of string b
    -> So we keep appending string a on a till it's length become >= len(b) -> Store the count.
    -> Then we apply rabin karp to check does the new string(text) contains b.
    -> If yes then we simply return the count
    -> else we add a one more time and check. If at this time text contains b the return count+1
    -> else return -1. Why? because it's recuring now and no pattern found. so even if you add
    -> a to text again. It's not gonna happen.
 */

class Solution {
    private static int PRIME = 101;
    private double calculateHash(String str){
        double hash=0;
        for(int i=0;i<str.length();i++){
            hash = hash + (str.charAt(i) * Math.pow(PRIME,i));
        }
        return hash;
    }

    private double updateHash(double prevHash,char oldChar, char newChar, int patternLength){
        double newHash = (prevHash-oldChar)/PRIME;
        newHash = newHash + newChar*Math.pow(PRIME,patternLength-1);

        return newHash;
    }

    public int rabin_karp(String text, String pattern){

        if(text==null || pattern==null || text.length()<pattern.length())
        return -1;

        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash= calculateHash(text.substring(0,patternLength));

        for(int i=0;i<=text.length()-patternLength;i++){
            if(textHash==patternHash){
                if(text.substring(i,i+patternLength).equals(pattern))
                return i;
            }

            if(i< text.length()-patternLength)
            textHash = updateHash(textHash,text.charAt(i), text.charAt(i+patternLength),patternLength);
        }
        return -1;
    }
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b))
        return 1;

        int count=1;
        StringBuilder text = new StringBuilder(a);

        while(text.length()<b.length()){
            text.append(a);
            count++;
        }

        if(text.toString().equals(b))
        return count;
        
        if(rabin_karp(text.toString(),b)!=-1)
        return count;

        text.append(a);
        if(rabin_karp(text.toString(),b)!=-1)
        return count+1;

        return -1;

    }
}