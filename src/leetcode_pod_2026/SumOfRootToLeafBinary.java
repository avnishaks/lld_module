package leetcode_pod_2026;

public class SumOfRootToLeafBinary {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

      /*
              1
             / \
            0   1
           / \ / \
          0  1 0  1

            1,0,1,0,1,0,1

          Paths:
          100 -> 4
          101 -> 5
          110 -> 6
          111 -> 7
          Sum = 22

          path-1 : 100
          node = 1 | 0
          current = 0 | 1 = 1 | 1 0 | 0 1



        */

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        current = (current << 1) | node.val;
        if (node.left == null && node.right == null) {
            return current;
        }
        return dfs(node.left, current) + dfs(node.right, current);
    }
    public static void main(String[] args) {
        SumOfRootToLeafBinary solution = new SumOfRootToLeafBinary();
        TreeNode root = solution.new TreeNode(1, solution.new TreeNode(0, solution.new TreeNode(0), solution.new TreeNode(1)), solution.new TreeNode(1,solution.new TreeNode(0), solution.new TreeNode(1)));

        System.out.println(solution.sumRootToLeaf(root)); // Output: 22
    }
}