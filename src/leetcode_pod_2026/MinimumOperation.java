package leetcode_pod_2026;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*


You are given a binary string s, and an integer k.
In one operation, you must choose exactly k different
indices and flip each '0' to '1' and each '1' to '0'.

Return the minimum number of operations required
to make all characters in the string equal to '1'.
If it is not possible, return -1.


Example 1:

Input: s = "110", k = 1

Output: 1

Explanation:

There is one '0' in s.
Since k = 1, we can flip it directly in one operation.
Example 2:

Input: s = "0101", k = 3

Output: 2

Explanation:

One optimal set of operations choosing k = 3
indices in each operation is:

Operation 1:

Flip indices [0, 1, 3]. s changes from "0101" to "1000".

Operation 2:

Flip indices [1, 2, 3]. s changes from "1000" to "1111".
Thus, the minimum number of operations is 2.

Example 3:

Input: s = "101", k = 2

Output: -1

Explanation:

Since k = 2 and s has only one '0',
it is impossible to flip exactly k indices
to make all '1'. Hence, the answer is -1.



Constraints:

1 <= s.length <= 10
s[i] is either '0' or '1'.
1 <= k <= s.length



 */
public class MinimumOperation {

    public static int minOperations(String st, int k) {
        int n=st.length();
        int startZero=0;

        for(char c:st.toCharArray()){
            if(c=='0'){
                startZero++;
            }
        }
        if(startZero==0){
            return 0;
        }
        int[] operationsCount=new int[n+1];
        Arrays.fill(operationsCount,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(startZero);
        operationsCount[startZero]=0;
        while(!q.isEmpty()){
            int zero=q.peek();
            q.poll();
            int minF=Math.max(0,k-n+zero);
            int maxF=Math.min(k,zero);
            for(int f=minF;f<=maxF;f++){
                int newZero=zero+k-2*f;
                if(operationsCount[newZero]==-1){
                    operationsCount[newZero]=operationsCount[zero]+1;
                    if(newZero==0){
                        return operationsCount[newZero];
                    }
                    q.add(newZero);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int k=sc.nextInt();
        int minOperationsRequired = minOperations(st,k);
        System.out.println(minOperationsRequired);
    }
}
