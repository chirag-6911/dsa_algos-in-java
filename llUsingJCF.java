import java.util.LinkedList;
//import java.util.*;

public class llUsingJCF{
    public static void main(String args[]){
        //creat
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);

        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}