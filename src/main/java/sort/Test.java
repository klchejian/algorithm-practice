package main.java.sort;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {

        Thread t0 = new Thread() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000*1000*10; i++){
                        System.out.println(i);
                }
            }
        };
        t0.start();
        try{
            Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("suspending thread0");
        t0.suspend();
        System.out.println("suspended thread00");
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        t0.resume();
        System.out.println("resumed thread0");

//        FatherClass second = new SubClass();

//        System.out.print();

//        Scanner sc = new Scanner(System.in);
//        int n = Integer.valueOf(sc.nextLine());
//        String str = sc.nextLine();
//        int[] arr = new int[n];
//        String[] strArr = str.split(" ");
//        for(int i = 0 ; i < n ; i++){
//            arr[i] = Integer.valueOf(strArr[i]);
//        }
//
//        int[] negetive = new int[2];
//        int[] pos = new int[3];
//
//        for(int i:arr){
//            if(i<0){
//                if(negetive[1]==0){
//                    negetive[1] = i;
//                }else if(negetive[0]==0 && i >= negetive[1]){
//                    negetive[0] = i;
//                }else if(negetive[0]==0 && i < negetive[1]){
//                    negetive[0] = negetive[1];
//                    negetive[1] = i;
//                }else if(i < negetive[0] && i > negetive[1]){
//                    negetive[0] = i;
//                }else if(i < negetive[1]){
//                    negetive[0] = negetive[1];
//                    negetive[1] = i;
//                }
//            }else if(i>0){
//                if(pos[2] == 0){
//                    pos[2] = i;
//                }else if(pos[1]==0){
//                    if( i <= pos[2]){
//                        pos[1] = i;
//                    }else{
//                        pos[1] = pos[2];
//                        pos[2] = i;
//                    }
//                }else if(pos[0]==0){
//                    if(i <= pos[1]){
//                        pos[0] = i;
//                    }else if(i > pos[1] && i <= pos[2]){
//                        pos[0] = pos[1];
//                        pos[1] = i;
//                    }else{
//                        pos[0] = pos[1];
//                        pos[1] = pos[2];
//                        pos[2] = i;
//                    }
//                }else if(i > pos[0] && i <= pos[1]){
//                    pos[0] = i;
//                }else if (i> pos[1] && i<= pos[2]){
//                    pos[0] = pos[1];
//                    pos[1] = i;
//                }else if (i> pos[2]){
//                    pos[0] = pos[1];
//                    pos[1] = pos[2];
//                    pos[2] = i;
//                }
//            }
//        }
//        DecimalFormat d = new DecimalFormat();
//
//        System.out.print(negetive[0]*negetive[1] > pos[0]*pos[1] ? negetive[0]*negetive[1]*pos[2]:pos[1]*pos[2]*pos[0]);
    }

    public static int testfinal(int a){
        try{
            a = a*2;
            return a;
        }finally {
            a = 501;
        }
    }
}