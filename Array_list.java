import java.util.*;
public class Array_list{



    public static void swap(ArrayList<Integer> list, int indx1, int indx2){
        int temp;
        temp=list.get(indx1);
        list.set(indx1,list.get(3));
        list.set(indx2,temp);
    }
    public static void main(String args[]){
       // ArrayList<Integer> list = new ArrayList<>();
        
        //add element 
        //list.add(2);
        //list.add(5);
        //list.add(9);
        //list.add(3);
        //list.add(6);
        //System.out.println(list);

        //list.add(1,9);

        //get element
        //int element = list.get(2);
        //System.out.print(element);

        //remove element
        //list.remove(2);

        //set element at index
        //list.set(2,10);

        //contain element
        //System.out.println(list.contains(1));
        //System.out.println(list.contains(11));

        //size of an arraylist
        //System.out.println(list.size());


        //print reverse of an arraylist
        //for(int i=list.size()-1; i>=0;i--){
        //    System.out.print(list.get(i)+" ");
        //}

        //find Maximum in an arraylist
        //int M = Integer.MIN_VALUE;
        //for(int i = 0; i<list.size();i++){
        //    if(list.get(i)>=M){
        //        M=list.get(i);
        //    }
        //}
        //System.out.print(M+" is the max value in an arraylist.");

        //swap 2 numbers
        //System.out.println(list);
        //swap(list,1,3);
        //System.out.println(list);



        //Sorting an arraylist
        //System.out.println(list);
        //Collections.sort(list);//assending order
        //System.out.println(list);
        //Collections.sort(list, Collections.reverseOrder());//desending order
        //System.out.println(list);

        //multi-dimensional arraylist
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> tb1 = new ArrayList<>();
        ArrayList<Integer> tb2 = new ArrayList<>();
        ArrayList<Integer> tb3 = new ArrayList<>();

        for(int i=1; i<=5;i++){
            tb1.add(i*1);
            tb2.add(i*2);
            tb3.add(i*3);
        }

        mainlist.add(tb1);
        mainlist.add(tb2);
        mainlist.add(tb3);

        for(int i = 0; i<mainlist.size(); i++){
            ArrayList<Integer> currlist = mainlist.get(i);
            for(int j=0;j<currlist.size();j++){
                System.out.print(currlist.get(j)+" ");
            }System.out.println();
        }


    }
}