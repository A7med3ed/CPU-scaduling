import java.util.Scanner;

public class Main {
    SRTF schaduling;
    RR schaduling2;
    priority scheduling3;

    public static void main(String args[]) {


        Scanner sc=new Scanner(System.in);
        int choose;
        System.out.println("choose one of scheduling options:");
        System.out.println("1- Shortest- Job First");
        System.out.println("2- Priority Scheduling");
        System.out.println("3- Round Robin");

        choose=sc.nextInt();
       switch (choose) {
           case 1:
               SRTF schaduling =new SRTF();
               schaduling.SRTF();
               break;
           case 2:
               priority schaduling3=new priority();
               schaduling3.priority();
               break;

           case 3:
               RR schaduling2=new RR();
               schaduling2.RR();
               break;

       }




    }
}