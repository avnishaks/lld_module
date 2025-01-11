package dsa_question;

import java.util.Scanner;
/*


Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"



Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.

sbcde , 5
a+b+c+d+e
ab
Approach for the problem statement :-

1. If the length of string is less value of k , is it impossible to construct k palindrome string
2. If the length of string match with the value of k , then we able to generate unique palindrome string
3. Now we have two choice :-
- count of each character has even counted number
{
Approach for this :-
- if all character present in the string have the even number of count for each of the character then we can
form pair of palindrom in mirror pair , that is only the count we insert in our solutions
}

- count of each character has odd counted number
{
- if some of the character present in odd pair , that is the tricky task , we have cover the edge case here for few
points
}


 */

public class ConstructKPalindromeString {
    public static boolean constructKPalindromeString(String s,int k){
        if(s.length()<k) return false;
        if(s.length()==k) return true;
        int [] freqCount=new int[26];
        int oddCount=0;

        // Increment the value of index corresponding to current character
        for(char c:s.toCharArray()){
            freqCount[c-'a']++;
        }

        // count of character that comes up odd number of times
        for(int count:freqCount){
            if(count%2==1){
                oddCount++;
            }
        }
        return oddCount<=k;
    }
    public static void main(String[] args) {
        System.out.println("! *** Problem Statement : Construct K Palindrome String **** ! ");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        System.out.println("Entered String value by user to construct K palindrome string : "+s+" "+"palindrome value is : "+k);

        System.out.println("Boolean value : Is it possible to construct K Palindrome String { true / false } "+constructKPalindromeString(s,k));

    }
}
