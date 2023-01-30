import java.util.Scanner;

public class priority {


    public static void priority(){
    Scanner sc=new Scanner(System.in);

        System.out.println ("enter no of process:");

    int n= sc.nextInt();

    int arrival_time[] = new int[n];

    int execution_time_1[] = new int[n];

    int completion_time[] = new int[n];

    int turn_around[] = new int[n];

    int waiting_time[] = new int[n];

    int priority[]=new int [n];

    int flag[] = new int[n];

    int execution_time_2[]= new int[n];

    String execution_order[]=new String[100*n];

    int i,current_time=0, completed_pro=0,coun=0;

    float AVGwt=0, AVGta=0;



        for (i=0;i<n;i++)
    {
        System.out.println("Enter the burst time of the process\n"+"P"+i);
        System.out.println("P"+i+" = ");
        execution_time_1[i] = sc.nextInt();
        execution_time_2[i] = execution_time_1[i];
        flag[i]= 0;
        System.out.println("Enter the arrival time of the process\n"+"P"+i);
        arrival_time[i]=sc.nextInt();
        System.out.println("Enter the priority of the process\n"+"P"+i);
        priority[i]=sc.nextInt();

    }


        while(true){

        int min=1000000,c=n;

        if(completed_pro==n){
            break;
        }

        for ( i=0;i<n;i++) {
            if ((arrival_time[i]<=current_time) && (flag[i]==0) && (priority[i]<min)){
                min=execution_time_2[i];
                c=i;
            }
        }

        if(c==n){
            current_time++;
        }

        else {
            execution_time_2[c]--;
            current_time++;
            execution_order[coun]="p"+(c+1);
            if(execution_order[coun]!="p"+(c+1)){
            coun++;
            execution_order[coun]="p"+(c+1);
            }
            if (execution_time_2[c]==0) {
                completion_time[c]= current_time;
                flag[c]=1;
                completed_pro++;

            }
        }





    }

        System.out.print("-----------------------------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t    completion time\t     Turnaround Time\t          Waiting Time\n");
        System.out.print("-----------------------------------------------------------------------------------------------------");


        for(i=0;i<n;i++)
    {
        turn_around[i] = completion_time[i] -arrival_time[i];
        waiting_time[i] = turn_around[i] - execution_time_1[i];
        AVGwt+= waiting_time[i];
        AVGta+= turn_around[i];
        System.out.print("\n "+(i+1)+"\t "+execution_time_1[i]+"\t\t "+completion_time[i]+"\t\t "+"\t\t "+turn_around[i]+"\t\t "+waiting_time[i]+"\n");
    }



        System.out.println("\naverage turn around time is "+ (float)(AVGta/n));
        System.out.println("average waiting time is "+ (float)(AVGwt/n));

        System.out.println("Processes execution order:");

        for(i=0;execution_order[i]!=null;i++)
        {
           if(!(execution_order[i].equals(execution_order[i+1])) ){
            System.out.print("\n "+execution_order[i]+"\n");}


        }

        sc.close();



}

}
