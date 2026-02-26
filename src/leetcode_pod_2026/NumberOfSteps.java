package leetcode_pod_2026;

import java.util.Scanner;

public class NumberOfSteps {
    public static int numSteps(String st) {
        int steps = 0;
        Long num= Long.parseLong(st,2);
        while(num!=1){
            if(num%2==0){
                num=num/2;
            }
            else{
                num+=1;
            }
            steps++;
        }
        return steps;
    }

    public static int numSteps2(String st) {
        int steps=0;
        int carry=0;
        for(int i=st.length()-1;i>0;i--){
            int bits=(st.charAt(i)-'0')+carry;
            if(bits==1){
                steps+=2;
                carry=1;
            }
            else{
                steps+=1;
            }
        }
        return steps+carry;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.next();
//        int numberOfSteps=numSteps(st);
        // for the simulation of the larger number
        int numberOfSteps=numSteps2(st);
        System.out.println(numberOfSteps);
    }
}
