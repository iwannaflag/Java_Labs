package Labs.Lab02;

import java.util.Scanner;

public class Q1 {
    public static class Complex{
        int a;
        int b;
        public Complex(){
            this.a=0;
            this.b=0;
        }
        public Complex(Complex complex){
            this.a=complex.a;
            this.b=complex.b;
        }
        public Complex(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public void Print(){
            if (this.a == 0 && this.b==0){
                System.out.println("0\n");
            }
            else {
                System.out.printf("%d %di\n", this.a, this.b);
            }
        }
    }
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        Complex n1 = new Complex(r.nextInt(), r.nextInt());
        Complex n2 = new Complex(r.nextInt(), r.nextInt());
        Complex add = new Complex(n1.a + n2.a, n1.b+n2.b);
        Complex minus = new Complex(n1.a - n2.a, n1.b-n2.b);
        add.Print();
        minus.Print();
    }
}
