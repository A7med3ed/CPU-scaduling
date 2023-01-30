import java.util.Scanner;


public class RR {



        public static void RR() {

            Scanner sc=new Scanner(System.in);

            System.out.println ("enter no of process:");

            int n= sc.nextInt();




            int execution_time_1[] = new int[n];

            int completion_time[] = new int[n];

            int waiting_time[] = new int[n];

            int execution_time_2[]= new int[n];

            String execution_order[]=new String[100*n];

            int count,qt,temp,i,sum=0,c=0,cur_time=0;

            float AVGwt=0, AVGta=0;

            System.out.print("Enter the burst time of the process\n");

            for (i=0;i<n;i++)
            {
                System.out.print("P"+i+" = ");
                execution_time_1[i] = sc.nextInt();
                execution_time_2[i] = execution_time_1[i];

            }

            System.out.print("Enter the quantum time: ");
            qt = sc.nextInt();





            while(true) {
                for (i=0,count=0;i<n;i++)
                {
                    temp = qt;

                    if(execution_time_2[i] == 0)
                    {
                        count++;
                        continue;
                    }

                    if(execution_time_2[i]>qt){

                        execution_time_2[i]= execution_time_2[i] - qt;
                        execution_order[c]="p"+(i+1);
                        c++;
                    }

                    else if(execution_time_2[i]>=0 ) {
                        temp = execution_time_2[i];
                        execution_time_2[i] = 0;
                        execution_order[c]="p"+(i+1);
                        c++;
                    }



                      sum = sum + temp;
                    completion_time[i] = sum;
                }



                if(n == count){
                    break;}
            }



            System.out.print("--------------------------------------------------------------------------------");
            System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
            System.out.print("--------------------------------------------------------------------------------");

            for(i=0;i<n;i++)
            {
                waiting_time[i]=completion_time[i]-execution_time_1[i];
                AVGwt=AVGwt+waiting_time[i];
                AVGta=AVGta+completion_time[i];

                System.out.print("\n "+(i+1)+"\t "+execution_time_1[i]+"\t\t\t\t\t\t "+completion_time[i]+"\t\t \t\t\t\t"+waiting_time[i]+"\n");
            }
            System.out.println("\naverage turn around time is ="+ (float)(AVGta/n));
            System.out.println("average waiting time is ="+ (float)(AVGwt/n));

            System.out.println("Processes execution order:");
            for(i=0;execution_order[i]!=null;i++)
            {

                System.out.print("\n "+execution_order[i]+"\n");


            }
        }



    }
