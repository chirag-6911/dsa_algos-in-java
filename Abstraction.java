public class Abstraction{
    public static void main(String args[]){
        //Dog d = new Dog();
        //d.eat();
        //d.walk();
        //Chiken c = new Chiken();
        //c.eat();
        //c.walk();
        //System.out.println(d.color);
        Chiken c = new Chiken();
        //Animal -> Dog -> Chiken
    }
}

abstract class Animal{
    String color;
    void eat(){
        System.out.println("animal eat");
    }
    abstract void walk();

    Animal(){
        System.out.println("animal constructor called");
    }
}

class Dog extends Animal{
    Dog(){
        System.out.println("dog constructor called");
    }
    void ChangeColor(){
        color = "white";
    }
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Chiken extends Dog{
    Chiken(){
        System.out.println("chiken constructor called");
        }
    void ChangeColor(){
        color = "yellow";
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }
}
