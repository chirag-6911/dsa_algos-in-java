import java.util.*;

public class ComplexNumbers{
    public static void main(String [] args){
    int a1;//real part of first complex no.
    int a2;//real part of second complex no.
    int b1i;//imaginary part of first complex no.
    int b2i;//imaginary part of second complex no.
    Scanner sc = new Scanner(System.in);
    Complex c = new Complex();
    System.out.println("enter first complex no. ");
    System.out.print("enter real part = ");
    a1 = sc.nextInt();
    System.out.print("enter imaginary part = ");
    b1i = sc.nextInt();
    System.out.println("enter second complex no. ");
    System.out.print("enter real part = ");
    a2 = sc.nextInt();
    System.out.print("enter imaginary part = ");
    b2i = sc.nextInt();
    c.add(a1,a2,b1i,b2i);
    c.product(a1,a2,b1i,b2i);
    c.difference(a1,a2,b1i,b2i);
    }
}

class Complex{

    void add(int a/*real part of first */, int b/*real part of second */, int c, int d){
        System.out.print("sum of two complex no. is = ");
        System.out.println((a+b)+"+"+(c+d)+"i");
    }
    void product(int a, int c, int b, int d){
        System.out.print("product of two complex no. is = ");
        System.out.println((a * c - b * d)+"+"+ (a * d + b * c)+"i");
    }
    void difference(int a, int b, int c, int d){
        System.out.print("difference of two complex no. is = ");
        System.out.println((a-b) + "+" + (c-d) + "i");
    }
}