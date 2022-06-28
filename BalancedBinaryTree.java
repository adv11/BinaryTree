package FreeKaTree;

public class BalancedBinaryTree extends TreeNode{
    TreeNode root = null;

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Approach 1 : By Brute Force Approach
     * Here we will check possibility in each node
     * Time complexity : O(N * N) - O(N) for traversing and O(N) for checking height each time. So it is not suitable.
     */
    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        // Condition for Not Balanced Tree
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);


        System.out.println("By Brute Force Approach");
        if(isBalanced(tree.root)){
            System.out.println("Given tree is Balanced Tree");
        }else{
            System.out.println("Given tree is not Balanced Tree");
        }
    }
}
