import java.util.*;


public class HeapS{

    static class student implements Comparable<student>{
        String name;
        int rank;

        public student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        //to compare the objects in class
        @Override
        public int compareTo(student s2){
            return this.rank - s2.rank;
        }
        
    }

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
           arr.add(data);

           int x = arr.size()-1;
           int par = (x-1)/2; 
           while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x=par;
                par = (x-1)/2;
           }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            int data = arr.get(0);


            //step 1 - swap first and last;
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 - delete last
            arr.remove(arr.size()-1);

            //step 3 - heapify
            heapify(0);
            return data;


        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    
    public static void main(String args[]){
        // PriorityQueue<student> pq = new PriorityQueue<>();

        // pq.add(new student("A", 1));//O(logn)
        // pq.add(new student("b", 5));
        // pq.add(new student("c", 4));
        // pq.add(new student("d", 12));

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name);//O(1)
        //     pq.remove();// O(logn)
        // }

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}