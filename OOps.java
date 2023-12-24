 //we can creat multiple class in a single class.
 public class OOps{
    public static void main(String args[]){
       /* Pen p1 = new Pen();// created pen object
        System.out.println("color = "+p1.getcolor());
        System.out.println("tip="+ p1.gettip());
        p1.setcolor("blue");
        System.out.println("color = "+p1.getcolor());
        p1.setTip(4);
        System.out.print("tip="+ p1.gettip());*/
        Student s1 = new Student("chirag");
        Student s2 = new Student();
        Student s3 = new Student();
        s3.name = "chirag";
        s3.roll = 23;
        s3.pass = "abcdfg";
        s3.marks[0]=100;
        s3.marks[1]=98;
        s3.marks[2]=100;


        Student s4 = new Student(s3);
        s4.pass="xyz";

        s3.marks[2]=91;
        for(int i=0;i<3;i++){
            System.out.println(s4.marks[i]);
        }
        


    }
 }

 class Student{
    String name;
    int roll;
    String pass;
    int marks[];
    //constructor, we didn't make constructur in pen class but code still run without any error because
    //java make constructor in pen class atomatically by default

    //shallow copy-constructor
   // Student(Student s3){
   //     marks = new int[3];
   //     this.name=s3.name;
   //     this.roll=s3.roll;
   //     this.marks=s3.marks;
   // }

   //deep copy-constructor
   Student(Student s3){
        marks = new int[3];
        this.name=s3.name;
        this.roll=s3.roll;
        for(int i=0; i<marks.length; i++){
            this.marks[i]=s3.marks[i];
        }
   }
    //this parameterized constructor
    Student(String name){
        marks = new int[3];
        this.name = name;
    }
    //this non-parameterized costructor
    Student(){
        marks = new int[3];
        
    }
 }

 class Pen{
    //properties
   private String color="red";
    private int tip=3;

    //fuction

    //getters
    String getcolor(){
        return this.color;
    }
    int gettip(){
        return this.tip;
    }
    // setters
    void setTip(int newTip){
        tip = newTip;
    }
    void setcolor(String newcolor){
    color = newcolor;
    }
 }