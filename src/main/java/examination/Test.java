package main.java.examination;

public class Test {
//    public static void main(String[] args) {
//        Test t = new Test();
//        t.method(null);
//
//    }
//    public void method(Object o ){
//        System.out.println("Object");
//    }
//
//    public void method(String s){
//        System.out.println("String");
//    }
    static int cnt = 0;

    public static void main(String[] args) {
        fib(7);
        System.out.println(cnt);
    }
    static int fib(int n){
        cnt++;
        if(n==0)
            return 1;
        else if(n ==1)
            return 2;
        else
            return fib(n-1)+fib(n-2);
    }

}
