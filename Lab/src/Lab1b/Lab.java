package Lab1b;

public class Lab{  
    static int n= 0;   
    static Information[] infor= new Information[150];
    static GetUserChoice getChoice= new GetUserChoice();
    static Func funRun= new Func();
    public static int checkStudent(String str){
        for(int i=1; i<= n; i++)
            if(str.equalsIgnoreCase(infor[i].name))
                return i;      
        return 0;
    }
    private static void accName(){
        String str;
        
        str= funRun.addStudent();
        if (checkStudent(str)!=0)
            System.out.println("!!!!student with name '"+str+ "' already have in list!!!!");
        else{
            infor[++n]= new Information();
            infor[n].name= str;
        }
    }
    private static void accMark(){
        String str;
        int check;
        str= funRun.addStudent();
        check= checkStudent(str);
        if(check==0)
            System.out.println("we don't have student with name '"+str+"' in list");
        else
            infor[check].mark= funRun.addMark(str);
    }
    private static void printOut(){
        if(n==0)
            System.out.println("!!!Have no information!!!");
        else{
            for(int i=1; i<= n; i++)
                System.out.format("name: %-15s mark: %-15.3f type: %-15s\n",infor[i].name,infor[i].mark,infor[i].type);
            System.out.println("!!!Successfull!!!");
        }
    }
    private static void sortType(){
        for(int i= 1; i<= n; i++){
       //     infor[i]= new Information();
            infor[i].type= funRun.addType(infor[i].mark); 
        }
        System.out.println("!!!Successfull!!!");
    }
    private static void sortMark(){
        for(int i=1; i< n; i++)
            for(int j=i+1; j<= n; j++){
            if(infor[i].mark< infor[j].mark){
                infor[0]= infor[i];
                infor[i]= infor[j];
                infor[j]= infor[0];
            }
        }
        System.out.println("!!!Successfull!!!");
    }
    public static void main(String[] args) { 
        int choice;
        do{
            choice= funRun.getUserChoice();
            switch(choice){
                case 1: accName();
                        break;
                case 2: accMark();
                        break;
                case 3: printOut();
                        break;
                case 4: sortType();
                        break;
                case 5: sortMark();
                        break;
            }
        }while(choice>0 && choice<6);
    }
}
