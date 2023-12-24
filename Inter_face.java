public class Inter_face{
    public static void main(String args[]){
        Bear b = new Bear();
        b.eat();
    }
}
//absolut abstraction
interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,right,left,diagonal");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,right,left");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,right,left,diagonal-(by 1 step)");
    }
}
//multiple  inheritance
interface Herbivorus{
    void eat();
}
interface Carbivorous{
    void eat();
}

class Bear implements Herbivorus,Carbivorous{
    public void eat(){
        System.out.print("eat both meat and vegies");
    }
}