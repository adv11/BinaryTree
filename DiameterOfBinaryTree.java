package FreeKaTree;

public class DiameterOfBinaryTree extends TreeNode{
    TreeNode root = null;

    // Method for calculating height of the node
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Brute Force Approach :
    // TC = O(N*N)
    static int maxDia = 0;
    public static int findDiameter_bruteForce(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        maxDia = Math.max(maxDia, leftHeight + rightHeight);

        findDiameter_bruteForce(root.left);
        findDiameter_bruteForce(root.right);

        return maxDia;
    }


    // Optimised Approach
    // TC = O(N)
    public static int findDiameter_optimised(TreeNode root){
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }
    public static int height(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);

        System.out.println("Maximum Diameter of the tree is (by Brute Force) : " + findDiameter_bruteForce(tree.root));
        System.out.println("Maximum Diameter of the tree is (by Optimised Approach) : " + findDiameter_optimised(tree.root));
    }
}
