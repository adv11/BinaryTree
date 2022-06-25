package FreeKaTree;

import java.util.ArrayList;
import java.util.Stack;

public class DFS_Traversal_Iterative extends DFS_Traversal_Recursive{
    Node root;
    DFS_Traversal_Iterative(){
        root = null;
    }

    // method for iterative preorder traversal
    // Hint : Always append Right child first and the left child into the Stack data structure
    public static void preorder_iterative(Node root){

        // for storing the nodes
        Stack<Node> preorder = new Stack<>();

        // edge case : if there is no node in the tree
        if(root == null){
            return;
        }
        preorder.push(root);    // otherwise push the root node because it is preorder traversal so follow root, right, left

        // run till stack has an element
        while(!preorder.isEmpty()){

            // pop out the peek element the stack and print it
            Node peekElement = preorder.pop();
            System.out.print(peekElement.key + " ");


            // first push left child of popped node
            if(peekElement.rightChild != null){
                preorder.push(peekElement.rightChild);
            }

            // after that push right child of popped node
            if(peekElement.leftChild != null){
                preorder.push(peekElement.leftChild);
            }
        }
    }

    // Inorder Iterative solution : left, root, right
    public static void inorder_iterative(Node root){
        Stack<Node> inorder = new Stack<>();
        Node tempNode = root;

        while(true){
            if(tempNode != null){
                inorder.push(tempNode);
                tempNode = tempNode.leftChild;
            }else{
                if(inorder.isEmpty()){
                    break;
                }
                tempNode = inorder.pop();
                System.out.print(tempNode.key + " ");
                tempNode = tempNode.rightChild;
            }
        }
    }

    // Method 1 : By using two Stacks
    // Postorder Iterative Solution : left, right, root
    /**
     * Steps :
     * 1) Push root node into the stack1 and then pop it and push it into the stack2.
     * 2) Now push left and right children of the current node present in the stack1.
     * 3) Now pop the peek node present in the stack1 and push it into the stack2.
     * 4) Repeat the steps 2 and 3 until stack1 is not empty.
     */
    public static void postorder_iterative_byTwoStacks(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // edge cae : if there is no node present in the given tree
        if(root == null){
            return;
        }
        // otherwise push the root node into the stack1
        stack1.push(root);

        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);

            if(root.leftChild != null){
                stack1.push(root.leftChild);
            }
            if(root.rightChild != null){
                stack1.push(root.rightChild);
            }
        }

        // This will give the resultant Postorder of the tree
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().key + " ");
        }
    }


    // Method 2 : Postorder Iterative Traversal using one stack only
    /**
     * Hint :
     * Move left until you find null.
     * If found then move right.
     * If both left and right are null then perform action on root.
     */
    public static void postorder_iterative_byOneStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        // run till current node is not null and stack has an element
        while(cur != null || !stack.isEmpty()){

            // case 1 : if current node is null
            // traverse for left child
            if(cur != null){
                stack.push(cur);
                cur = cur.leftChild;
            }

            // case 2 : if current node is not null
            // Now we have to traverse for right child
            else{
                Node temp = stack.peek().rightChild;

                // subcase 1 : if right child is also null
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.key + " ");
                    while(!stack.isEmpty() && temp==stack.peek().rightChild){
                        temp = stack.pop();
                        System.out.print(temp.key + " ");
                    }
                }

                // subcase 2 : if right child is not null
                else{
                    cur = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS_Traversal_Iterative tree = new DFS_Traversal_Iterative();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(7);
        tree.root.leftChild.leftChild = new Node(3);
        tree.root.leftChild.rightChild = new Node(4);
        tree.root.leftChild.rightChild.leftChild = new Node(5);
        tree.root.leftChild.rightChild.rightChild = new Node(6);

        System.out.println("Preorder Iterative Traversal");
        preorder_iterative(tree.root);

        System.out.println();

        System.out.println("Inorder Iterative Traversal");
        inorder_iterative(tree.root);

        System.out.println();

        System.out.println("Postorder Traversal By using Two stacks");
        postorder_iterative_byTwoStacks(tree.root);

        System.out.println();

        System.out.println("Postorder Iterative Traversal by using only one Stack");
        postorder_iterative_byOneStack(tree.root);
    }
}
