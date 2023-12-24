import java.util.*;

public class QueueB{
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }


        public static boolean isEmpty(){
            //circular queue
            return rear == -1 && front == -1;
            //queue
            //return rear == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data){
            if(isFull()){
                System.out.print("queue is full");
                return;
            }
            //addint 1st ele
            if(front == -1){
                front = 0;
            }
            //circular queue
            rear = (rear+1)%size;
            arr[rear] = data;
            //queue
            //rear = rear+1;
            //arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.print("queue is empty");
                return -1;
            }
            //circular queue
            int result = arr[front];
            //removing last ele
            if(rear == front){
                rear = front = -1;
            } else {
                front = (front+1)%size;
            }
            return result;
            //queue
            // int front= arr[0];
            // for(int i = 0; i<rear; i++){
            //     arr[i]=arr[i+1];
            // }
            // rear = rear-1;
            // return front;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.print("queue is empty");
                return -1;
            }
            //circular queue
            return arr[front];
            //queue
            //return arr[0];
        }
    }

    public static void main(String args[]){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }

}