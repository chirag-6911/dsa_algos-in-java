

public class inheritance{
    public static void main(String args[]){
        Humans h1 = new Humans();
        h1.eat();
        Birds b1 = new Birds();
        b1.eat();
    }
}
    //base class
    class Animal{
        String color;
        void eat(){
            System.out.println("eats");
        }
        void breath(){
            System.out.println("breaths");
        }
    }
     //drived class(single-level inheritance)
    class Fish extends Animal{
        int fins;

        void swim(){
            System.out.println("water");
        }
    }

    //1.drived class(multi-level inhertance)
    class Mammls extends Animal{
        void blood(){
            System.out.print("warm blooded");
        }
    }

    //2.drived class(muli-level inheritance)
    class Dog extends Mammls{
        void walk(){
            System.out.print("walk on 4-legs");
        }
    }

    //1.drived class (hirarichial inheri)
    class Birds extends Mammls{
        void fly(){
            System.out.println("fly");
        }
    }

    //2.drived class (hirarichial inheri)
    class Humans extends Mammls{
        void wlak(){
            System.out.println("walk");
        }
    }


