package PE.PE1;
import java.util.Stack;
public class Q1 {
    static Stack<Character> nx = new Stack<>();
    static void f1() 	// 2 point
    { 
        if(nx.isEmpty()) return;
        Character element= nx.pop();
        f1();
        f2(element);
    }
    static void f2(Character element){
        if(nx.isEmpty()){
            nx.push(element);
            return;
        }
        Character p= nx.pop();
        f2(element);
        nx.push(p);
    }
    public static void main(String[] args) 		// 1 point
    {         
        // push elements into the stack
        nx.push('F');
        nx.push('P');
        nx.push('T');
        nx.push('U');
        nx.forEach((t) -> {
            System.out.print(t+" ");
        });
        System.out.println("");
        f1();
        nx.forEach((t) -> {
            System.out.print(t+" ");
        });
    }
}
