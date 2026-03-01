package leetcode_pod_2026.march_2026;

public class MaximumDeciBinaryNumber {
    public int minPartitions(String n) {
        int ans=0;
        for(int i=0;i<n.length();i++){
            ans=Math.max(ans,n.charAt(i)-'0');
        }
        return ans;

    }
    public static void main(String[] args) {
        String s="32";
        int ans= new MaximumDeciBinaryNumber().minPartitions(s);
        System.out.println(ans);
    }
}
