package view;
import model.*;
import myException.MyException;
public class CompanyManagement extends Menu<String>{
    static String[] menu={"List all Customer","Search Customer","Add new Customer","Customer statistical","Exit"};
    private Company com= new Company();
    public CompanyManagement(){
        super("Company Mannagement System", menu);
    }
    @Override
    public void excute() {
        com.readFile();
        int k=1;
        do {            
            try {
                k= super.getSelect();
                switch (k) {
                    case 1: com.printAll();  break;
                    case 2: cusSearching(); break;
                    case 3: com.insertCus(); break;
                    case 4: staSearching(); break;
                }
            } catch (Exception e) {
                System.out.println("!!!Selection Wrong Format!!!");
            }
        } while ((k>0)&&(k<5));
    }
    public void cusSearching(){
        String[] cusOption={"Find by CustomerID","Find by name"};
        Menu cusSearching= new Menu("Customer Searching", cusOption) {
            @Override
            public void excute() {  
                try {
                    int k=1;
                    String str;
                    k= super.getSelect();
                    if ((k<1)||(k>2)) throw new MyException("!!!WE DONT HAVE OPTION "+k+"!!!");
                    com.cusSearch(k);
                }catch(MyException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    System.out.println("!!!Selection Wrong Format!!!");
                }
            }
        };
        cusSearching.excute();
    }
    public void staSearching(){
        String[] staOption={"Viettel","MobiPhone","VnaPhone"};
        Menu staSearching= new Menu("Statistical Customer", staOption) {
            @Override
            public void excute() {  
                try {
                    int k=1;
                    String str;
                    k= super.getSelect();
                    if ((k<1)||(k>3)) throw new MyException("!!!WE DONT HAVE OPTION "+k+"!!!");
                    com.satic(k);
                }catch(MyException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    System.out.println("!!!Selection Wrong Format!!!");
                }
            }
        };
        staSearching.excute();
    }
}
    

