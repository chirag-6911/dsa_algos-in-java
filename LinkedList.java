public class LinkedList{
    //syntax of creating linkedlist.
    //this is single node. 
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){

        //step 1-> creat new node
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head = tail = newNode;
            return;
        }

        //step 2-> newNode next = head;
        newNode.next= head;//link

        //step 3-> head=newNode
        head = newNode; 
    }

    public void print(){
        if(head == null){
            System.out.println("ll is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addLast(int data){
        // step 1-> creat node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            return;
        }
        
        // step 2-> 
        tail.next = newNode;

        // step 3->
        tail = newNode;

    }

    public int removeFirst(){
        if(size==0){
            System.out.print("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;

        return val;
    }


    public int removeLast(){
        if(size==0){
            System.out.print("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0; i<size-2; i++){
             prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = null;
        size--;
        return val;
    }

    public int itrsearch(int key){
        int i=0;
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }


    public int helper(Node head, int key){
        if (head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }

        int indx = helper(head.next,key);
        if(indx == -1){
                return -1;
            }
        return indx+1; 
    }


    public int recsearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next ;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void addMiddle(int indx, int data){
        if(indx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0; 
        while(i < indx-1){
            temp = temp.next;
            i++;
        }
        // i = indx-1; temp=prev
        newNode.next = temp.next;
        temp.next = newNode;
    }


    public void deleteNthFromEnd(int n){
        //calculate size
        int sz =0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }
        //sz-n
        int i = 1;
        int itofind = sz-n;
        Node prev = head;
        while(i<itofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return; 
    }

    public Node findmid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }return slow;// slow is my midnode
    }

    public boolean pallindrom(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1 find mid
        Node midNode = findmid(head);

        // step 2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next ;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev ;// head of right half
        Node left = head;// head of left half
        // step 3 check left half & rigth half are equale?

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
        
    }

    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow == fast){
                return true;
            }
        }return false;
    }



    public static void removecycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast == slow){
                cycle=true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meet point
        slow = head;
        Node prev = null;
        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        //remove cycle 
        prev.next = null;
    }

    private Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node lh , Node rh){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(lh != null && rh != null){
            if(lh.data <=rh.data){
                temp.next = lh;
                lh = lh.next;
                temp = temp.next;
            }else{
                temp.next = rh;
                rh = rh.next;
                temp = temp.next;
            }
        }
        while(lh != null){
            temp.next = lh;
            lh = lh.next;
            temp = temp.next;
        }
        while(rh != null){
            temp.next = rh;
            rh = rh.next;
            temp = temp.next;
        }

       return mergedLL.next; 
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getmid(head);

        // divide into two parts
        Node righthead = mid.next;
        mid.next = null;

        Node newleft=mergeSort(head);
        Node newright=mergeSort(righthead);

        //merge
        return merge(newleft,newright);
    }

    public void ZigZag(){
        //get mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        
        //reverse second half

        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // alt merge

        Node lefthead = head;
        Node righthead = prev;
        Node nextL, nextR;
        while(lefthead != null && righthead != null){
            nextL = lefthead.next;
            lefthead.next = righthead;
            nextR = righthead.next;
            righthead.next = nextL;

            righthead = nextR;
            lefthead = nextL;

        }

    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(6);
        ll.head=ll.mergeSort(ll.head);
        ll.print();//
        ll.ZigZag();
        ll.print();

        //head = new Node(1);
        //Node temp =new Node(2);
        //head.next=temp;

        //head.next.next=new Node(3);
        //head.next.next.next=temp;
        //System.out.println(iscycle());
        //removecycle();
        //System.out.println(iscycle());
        


        //ll.print();//1->2->9->3->4
        //System.out.print(ll.size);
        //ll.removeFirst();
        //ll.print();//2->9->3->4

        //ll.removeLast();
        //ll.print();//2->9->3
        //System.out.println(size);

        //System.out.println(ll.recsearch(9));
        //System.out.println(ll.recsearch(1));
        //ll.print();
        //ll.deleteNthFromEnd(3);
        //ll.print();
        //System.out.println(ll.pallindrom());
    }
}