import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConsoleForm {
    Manage manage = new Manage();
    HashMap<String, String>  hashMap = new HashMap<>();
    Write write = new Write();
    public static int menu(){
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    public void addWord(){
        System.out.println("------------- Add -------------");
        System.out.println("Enter English: ");
        write.setEnglish(Validation.checkInputString());
        System.out.println("Enter Vietnamese: ");
        write.setVietNam(Validation.checkInputString());
        hashMap.put(write.getEnglish(), write.getVietNam());
        manage.add(write);
        System.out.println("Successful");
    }

    public void deleteWord(){
        System.out.println("------------ Delete ----------------\n");
        System.out.println("Enter english: ");
        write.setEnglish(Validation.checkInputString());
        hashMap.remove(write.getEnglish());
        System.err.println("Successful");
    }

    public void translateWord(){
        System.out.println("------------- Translate ------------\n");
        System.out.println("Enter english: ");
        write.setEnglish(Validation.checkInputString());
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for(Map.Entry entry: entrySet){
            if(entry.getKey().equals(write.getEnglish())){
                System.out.println("Vietnamese: " +entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    public void execute(){
        int choice;
        do{
            choice = menu();
            switch (choice){
                case 1: addWord(); break;
                case 2: deleteWord(); break;
                case 3: translateWord(); break;
                case 4: System.exit(0); break;
            }
        }while((choice>0)&(choice<5));
    }
}
