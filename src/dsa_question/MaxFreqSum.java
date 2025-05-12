package dsa_question;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxFreqSum {
    public static int maxFreqSum(String s){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }
        int maxVowel = 0, maxConsonant = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (vowels.contains(c)) {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }
        return maxVowel + maxConsonant;
    }
    public static void main(String[] args) {
        System.out.println("Max Freq Sum Question of leet-code");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int countFreqSum=maxFreqSum(s);
        System.out.println("Max Freq Sum value is : "+countFreqSum);
    }
}
