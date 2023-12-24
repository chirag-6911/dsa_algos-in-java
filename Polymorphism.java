public class Polymorphism{
    public static void main(String args[]){
        //Calculate c = new Calculate();
        //System.out.println(c.sum((float)1.2,(float)1.2));
        //System.out.println(c.sum(12,12));
        //System.out.println(c.sum(12,12,12));
        Animal a1 = new Animal();
        Deer d1 = new Deer();
        d1.eat();
        a1.eat();
    }
}

//Method overloding
class Calculate{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a, float b){
        return a+b;
    }
    int  sum(int a,int b,int c){
        return a+b+c;
    }
    
}

//Method overring
class Animal{
    void eat(){
        System.out.println("can eat anithing");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("only eat grass");
    }
}