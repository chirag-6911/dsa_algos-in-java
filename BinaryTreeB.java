import java.util.*;

public class BinaryTreeB{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
           this.data = data;
           this.left = null;
           this.right = null; 
        }

    } 


    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root){

            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void Inorder(Node root){
            if(root == null){
                return;
            }

            Inorder(root.left);
            System.out.print(root.data +" ");
            Inorder(root.right);
        }

        public static void Postorder(Node root){
            if(root == null){
                return;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void Levelorder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int Height(Node root){
            if(root == null){
                return 0;
            }

            int lh = Height(root.left);
            int rh = Height(root.right);

            return Math.max(lh,rh)+1;


        }

        public static int countNode(Node root){
            if(root == null){
                return 0;
            }

            int lc = countNode(root.left);
            int rc = countNode(root.right);

            return lc+rc+1;
        }

        public static int Sum(Node root){
            if(root == null){
                return 0;
            }

            int ls = Sum(root.left);
            int rs = Sum(root.right);

            return ls+rs+root.data;
        }

        public static int Diam1(Node root){
            if(root == null){
                return 0;
            }


            int ld = Diam1(root.left);
            int lh = Height(root.left);
            int rd = Diam1(root.right);
            int rh = Height(root.right);

            int selfDiam = lh + rh +1;

            return Math.max(selfDiam, Math.max(ld,rd));
        }


        public static void kLevel(Node root, int level, int k){
            if(root == null){
                return;
            }

            if(level == k){
                System.out.print(root.data+" ");
                return;
            }

            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }

            path.add(root);

            if(root.data == n){
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
            

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for(;i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            Node lca = path1.get(i-1);
            return lca;
            

        }
        public static Node lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right,n1, n2 );
            //leftlca = value   rightlca = null
            if(rightLca == null){
                return leftLca;
            }
            if(leftLca == null){
                return rightLca;
            }

            return root;
        }
        public static int lcaDist(Node root, int n){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }

            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }else if(leftDist == -1){
                return rightDist+1;
            }else {
                return leftDist+1;
            }
        }
        public static int minDis(Node root, int n1, int n2){
            Node lca = lca2(root,n1,n2);
            int dist1=lcaDist(lca,n1);
            int dist2=lcaDist(lca,n2);

            return dist1 + dist2;
        }

        public static int kAncestor(Node root, int n, int k){

            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int leftDist = kAncestor(root.left, n, k);
            int rightDist = kAncestor(root.right, n, k);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }

            int max = Math.max(leftDist,rightDist);
            if(max+1 == k){
                System.out.println(root.data);
            }

            return max+1;
        }


        public static int transform(Node root){
            if(root == null){
                return 0;
            }

            int leftchild = transform(root.left);
            int rightchild = transform(root.right);

            int data = root.data;

            int newleft = root.left == null? 0 : root.left.data;
            int newright = root.right == null? 0: root.right.data;
            root.data = newleft + leftchild + newright + rightchild;
            return data;
        }
        
    }


    // this info is use to calculate diameter of tree
    static class info{
            int diam;
            int ht;

            public info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

    public static info Diam2(Node root){
        if(root == null){
            return new info(0,0);
        }
        info  leftinfo = Diam2(root.left);
        info  rightinfo = Diam2(root.right);
        int diam = Math.max(Math.max(leftinfo.diam, rightinfo.diam),leftinfo.ht + rightinfo.ht+1);
        int ht = Math.max(leftinfo.ht, rightinfo.ht)+1;

        return new info(diam,ht);

    }

    public static boolean isIdentical(Node node , Node subroot){
        if(node == null && subroot == null){
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }

        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){

                return true;
            }
        }

        return  isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

    }

    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        //level order traversal

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map =  new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd , curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1); 
                }
            }
        }

        for(int i = min; i<= max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }

    
    
    public static void main(String args[]){
        //int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //BinaryTree tree = new BinaryTree();
        //Node root = tree.buildTree(nodes);
        //System.out.println(tree.Height(root));


        //tree
        /*
                     1
                    / \
                   /   \
                  2     3
                 / \   /  \
                4   5 6    7*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //topView(root);
        //int k = 3;
        //BinaryTree.kLevel(root,1,k);

        //int n1 = 4, n2 = 7;
        //System.out.println(BinaryTree.minDis(root, n1,n2));


        //int n=5, k=2;
        //BinaryTree.kAncestor(root,n,k);

        BinaryTree.transform(root);
        BinaryTree.preorder(root);
        

        //subtree
        /*
                 2
                / \
               4   5*/

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5); 


        //System.out.print(isSubtree(root, subroot));      
    }
}