package leetcode_pod_2026.march_2026;

import java.util.Scanner;

public class CheckOneSegment {
    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        boolean res=checkOnesSegment(str);
        System.out.println(res);
    }
}
