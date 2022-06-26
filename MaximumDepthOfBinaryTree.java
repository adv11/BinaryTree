package FreeKaTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree extends TreeNode{
    TreeNode root = null;

    /**
     * Approach 1 : By using Recursion
     * Time Complexity : O(N)
     * Space Complexity : Average - O(height of tree), Worst - O(N) in case of Skew Tree
     */
    public static int maxDepth(TreeNode root){
        // Edge case : if there is no node present in the tree
        if(root == null){
            return 0;
        }

        // max height of left subtree
        int leftHeight = maxDepth(root.left);
        // max height of right subtree
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    /**
     * Approach 2 : By using Level Order Traversal
     * Time Complexity : O(N)
     * Space Complexity : O(N) in case of Complete Binary Tree N will be too large to handle. So it is not good approach.
     */
    public static int maxDepthByLevelOrderTraversal(TreeNode root){
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return level;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int numOfChildren = queue.size();
            level++;
            for(int i=0 ; i<numOfChildren ; i++){
                TreeNode poppedNode = queue.poll();
                if(poppedNode.left != null){
                    queue.offer(poppedNode.left);
                }
                if(poppedNode.right != null){
                    queue.offer(poppedNode.right);
                }
            }
        }
        return level;
    }
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
        tree.root.right.left.left = new TreeNode(5);

        System.out.println("Maximum Depth of the given tree is : " + maxDepth(tree.root));
        System.out.println("Maximum Depth of the given tree by Level Order is : " + maxDepthByLevelOrderTraversal(tree.root));
    }
}
