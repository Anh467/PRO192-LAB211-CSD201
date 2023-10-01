import java.util.Stack;
public class Q1 {
    static Stack<Character> nx = new Stack<>();
    static void f1() 	// 2 point
    { 
        if(nx.isEmpty()) return;
        Character r= nx.pop();
        f1();
        f2(r);
    }
    static void f2(Character r){
        if(nx.isEmpty()) {
        nx.push(r);
        return;
        }
        Character x= nx.pop();
        f2(r);
        nx.push(x);
    }
    public static void main(String[] args) 		// 1 point
    {         
        // push elements into the stack
        nx.push('F');
        nx.push('P');
        nx.push('T');
        nx.push('U');
        nx.forEach((t) -> {
            System.out.print(t+"");
        });
        f1();
        System.out.println("");
        nx.forEach((t) -> {
            System.out.print(t+"");
        });
    }
}

