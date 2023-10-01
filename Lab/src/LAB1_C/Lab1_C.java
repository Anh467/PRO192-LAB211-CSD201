
package LAB1_C;

import java.util.Scanner;


public class Lab1_C {
    static Function func= new Function();
    static Information[] infor= new Information[200];
    static int n=0;
    public static int check_house(String str){
        for(int i=1; i <= n; i++)
            if(str.equalsIgnoreCase(infor[i].infor_name))
                return i;
        return 0;
    }
    private static void accName(){
        infor[n+1]= new Information();
        infor[n+1].infor_name= func.get_name();
        if (check_house(infor[n+1].infor_name)==0)
             n++;
    }
    public static void accIndex(){
        Scanner ip= new Scanner(System.in);
        String str;
        int position;
        System.out.print("Enter name of house need to add index: ");
        str= ip.nextLine();
        position=check_house(str);
        if (position!=0){
            System.out.print("Enter index for "+str+": ");
            infor[position].infor_index= ip.nextDouble();
        }
        else 
            System.out.print("dont have information "+str+" in list");
    }
    public static void printOutData(){
        for(int i=1; i<=n; i++)
            System.out.format("Name: %-15s Index: %-15.4f Bill: %-15.4f\n", infor[i].infor_name, infor[i].infor_index, infor[i].infor_bill);
    }
    private static void cal_elec_bill(){
        for(int i=1; i<=n; i++)
            infor[i].infor_bill= func.cal_bill(infor[i].infor_index);
        System.out.println("!!!SuccessFull!!!");
    }
    private static void sort_elec_bill(){
        for(int i= 1; i< n; i++)
            for(int j= i+ 1; j<= n; j++ )
                if(infor[i].infor_index< infor[j].infor_index){
                    infor[0]= infor[i];
                    infor[i]= infor[j];
                    infor[j]= infor[0];
                }
        System.out.println("!!!SuccessFull!!!");
    }
    public static void main(String[] args) {
        int choice;
        do{
            choice= func.getUserChoice();
            switch(choice){
                case 1: accName();
                        break;
                case 2: accIndex();
                        break;
                case 3: printOutData();
                        break;
                case 4: cal_elec_bill();
                        break;
                case 5: sort_elec_bill();
                        break;
            }
        }while(choice>0&&choice<6);
    }
}
