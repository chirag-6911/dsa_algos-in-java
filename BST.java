import java.util.*;
//BST -> Binary Search Tree
public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(int val,Node root){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(val, root.left);
        }else{
            //right subtree
            root.right = insert(val, root.right);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }else if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2
            if(root.left == null){
               return root.right; 
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3

            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1,k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1,k2);
        }
        else{
            printInRange(root.right, k1,k2);
        }
    }


    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("N");
    }

    public static void printRootToPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRootToPath(root.left, path);
        printRootToPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBst(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);

    }


    public static void preorder(Node root){

        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node creatMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftSubtree = creatMirror(root.left);
        Node rightSubtree = creatMirror(root.right);


        root.left = rightSubtree;
        root.right = leftSubtree;


        return root;
    }

    public static Node creatBst(int arr[], int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = creatBst(arr, st, mid-1);
        root.right = creatBst(arr, mid+1, end);
        return root;
    }
    public static void getInorder(Node root, ArrayList<Integer> Inorder){
        if(root == null){
            return;
        }

        getInorder(root.left, Inorder);
        Inorder.add(root.data);
        getInorder(root.right, Inorder);
    }

    public static Node creatBst(ArrayList<Integer> Inorder, int st, int end ){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(Inorder.get(mid));
        root.left = creatBst(Inorder, st, mid-1);
        root.right = creatBst(Inorder, mid+1, end);

        return root;
    } 

    public static Node balancedBst(Node root){
        //inorder
        ArrayList<Integer> Inorder = new ArrayList<>();
        getInorder(root, Inorder);

        //sorted inorder -> balanced
        root = creatBst(Inorder, 0, Inorder.size()-1);

        return root;

    }
    static class Info{
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isBst, int size, int min, int max){
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBst = 0;

    public static Info largestBst(Node root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBst(root.left);
        Info rightInfo = largestBst(root.right);
        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max,rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBst && rightInfo.isBst){
            maxBst = Math.max(maxBst, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }

    public static Node mergeBst(Node root1, Node root2){
        //step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i=0,j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }


        //sorted arr --> balance Bst
        return creatBst(finalArr, 0, finalArr.size()-1);

    }
    public static void main(String args[]){
    //    int values[] =  {5,1,3,4,2,7};
    //    Node root = null;


    //    for(int i = 0; i<values.length; i++){
    //     root = insert(values[i], root);
    //    }
    //    inorder(root);
    //    System.out.println();

       //printRootToPath(root,new ArrayList<>());


    //    if(isValidBst(root, null, null)){
    //     System.out.println("Bst is valid");
    //    }else{
    //     System.out.println("Bst is not valid");
    //    }

       
    //    System.out.println();

    //    if(search(root,9)){
    //     System.out.println("found");
    //    }else{
    //     System.out.println("not found");
    //    }
    /*case 1 - no child //root = delete(root,1);*/
    /*case 2 - one child //root = delete(root,10);*/
    ///*case 3 - two child */root = delete(root,5);
    //System.out.println();
    
    //inorder(root);
    //tree
        /*
                     1
                    / \
                   /   \
                  5     10
                 / \      \
                3   6     11*/
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);
        // preorder(root);
        // System.out.println();
        // creatMirror(root);
        // preorder(root);
        //int arr[] = {3,5,6,8,10,11,12};
        //Node root=creatBst(arr,0,arr.length-1);
        //preorder(root);

        //
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // balancedBst(root);
        // preorder(root);

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.right = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBst(root);
        // System.out.print("size of largest Bst in bt is "+maxBst);


        //Bst1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        //Bst2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBst(root1,root2);
        preorder(root);




    }
}