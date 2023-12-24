public class As5{
    public static void main(String args[]){
        int n=9;
        Tower_of_hanoi(n,'a','c','b');
    }

    public static void OccurenceIndex(int arr[],int i,int key){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        OccurenceIndex(arr,i+1,key);
    }


    public static void Convert_No_to_string(int n, String str){
        if(n==0){
            System.out.print(str);
            return;
        }
        int N = n%10;
        if(N==0){
            Convert_No_to_string(n/10," zero "+str);
        }else if(N==1){
            Convert_No_to_string(n/10," one "+str);
        }else if(N==2){
            Convert_No_to_string(n/10," two "+str);
        }else if(N==3){
            Convert_No_to_string(n/10," three "+str);
        }else if(N==4){
            Convert_No_to_string(n/10," four "+str);
        }else if(N==5){
            Convert_No_to_string(n/10," five "+str);
        }else if(N==6){
            Convert_No_to_string(n/10," six "+str);
        }else if(N==7){
            Convert_No_to_string(n/10," seven "+str);
        }else if(N==8){
            Convert_No_to_string(n/10," eight "+str);
        }else if(N==9){
            Convert_No_to_string(n/10," nine "+str);
        }
    }

    public static void StrLength(String str,int i){
        if(i==str.length()){
            System.out.print(i);

            return;
        }
        StrLength(str,i+1);
    }

    public static void contiguousSubStrings(String str, int s, int e, int count){
        
        //base case
        if(s==str.length()){
            System.out.print(count);
            return;
        }
        if(e==str.length()){
            contiguousSubStrings(str,s+1,s+1,count);
            return;
        }

        //kaam
        if(str.charAt(s)==str.charAt(e)){
            contiguousSubStrings(str,s,e+1,count+1);
        }else{
            contiguousSubStrings(str,s,e+1,count);
        }
    }

    public static void Tower_of_hanoi(int n,char source,char destination, char helper){
        //base case
        if(n==1){
            System.out.println("move disk "+n+" from "+source+" to "+destination);
            return;
        }
        //work
        Tower_of_hanoi(n-1,source,helper,destination);
        System.out.println("move disk "+n+" from " +source+" to " +destination);
        Tower_of_hanoi(n-1,helper,destination,source);
    }
/*
Sure, let's do a dry run of the code for the Tower of Hanoi problem with 3 disks. We'll walk through each step of the recursion to see how the disks are moved from the source peg (A) to the destination peg (C) using the helper peg (B).

Initially, we have three disks on peg A, and our goal is to move them to peg C.

Step 1: Call `Tower_of_hanoi(3, 'A', 'C', 'B')`

Since n (number of disks) is not 1, we proceed to the recursive steps:

Step 2: Call `Tower_of_hanoi(2, 'A', 'B', 'C')`

Again, n is not 1, so we proceed with recursion:

Step 3: Call `Tower_of_hanoi(1, 'A', 'C', 'B')`

Now, n is 1, so we execute the base case:

Base Case 1: Print "Move disk 1 from A to C"

Step 4: Return from the recursive call to `Tower_of_hanoi(1, 'A', 'C', 'B')`

Back to Step 3:

Step 5: Print "Move disk 2 from A to B"

Step 6: Call `Tower_of_hanoi(1, 'C', 'B', 'A')`

Now, n is 1, so we execute the base case:

Base Case 2: Print "Move disk 1 from C to B"

Step 7: Return from the recursive call to `Tower_of_hanoi(1, 'C', 'B', 'A')`

Back to Step 6:

Step 8: Print "Move disk 2 from B to C"

Step 9: Call `Tower_of_hanoi(2, 'B', 'C', 'A')`

Back to Step 2:

Step 10: Print "Move disk 3 from A to C"

Step 11: Call `Tower_of_hanoi(2, 'B', 'C', 'A')`

Step 12: Return from the recursive call to `Tower_of_hanoi(2, 'B', 'C', 'A')`

Back to Step 9:

Step 13: Return from the recursive call to `Tower_of_hanoi(2, 'A', 'B', 'C')`

Back to Step 1:

Step 14: Print "Move disk 3 from A to C"

Step 15: Call `Tower_of_hanoi(2, 'A', 'C', 'B')`

Step 16: Return from the recursive call to `Tower_of_hanoi(2, 'A', 'C', 'B')`

The entire Tower of Hanoi problem is solved! All three disks have been moved from peg A to peg C according to the rules of the puzzle. The output of the dry run will be a series of instructions on how to move the disks to reach the goal configuration.
*/
}