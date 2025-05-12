package dsa_question;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumOperationToConvertAllElementToZero {
    public static int minOperations(int[] nums) {
        int ops = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : nums) {
            if (x == 0) {
                while (!stack.isEmpty()) {
                    stack.pop();
                    ops++;
                }
            } else {
                while (!stack.isEmpty() && stack.peek() > x) {
                    stack.pop();
                    ops++;
                }
                if (stack.isEmpty() || stack.peek() < x) {
                    stack.push(x);
                }
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
            ops++;
        }
        return ops;
    }
    public static void main(String[] args) {
        System.out.println("Minimum Operation to convert all element to zero");
        int [] nums={3,1,2,1};
        int result=minOperations(nums);
        System.out.println("Result: "+result);
    }
}
