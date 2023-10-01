
public class BrutoForce {
    String str, strSubString;

    public BrutoForce(String str, String strSubString) {
        this.str = str;
        this.strSubString = strSubString;
        if(str.length()< strSubString.length()){
            System.out.println("done");
            return;
        }
        BrutoForceSearch();
    }
    public boolean check(int i){
        for(int j= 0; j< strSubString.length(); j++)
                if(str.charAt(i+j)!=strSubString.charAt(j))
                    return false;
        return true;
    }
    public void BrutoForceSearch(){
        int count= 0;
        for(int i= 0; i< str.length()-strSubString.length()+1; i++){
            if(!check(i)) continue;
            System.out.println("match at "+ i);
            count++;
        }
        System.out.println("there are "+count+ " string match");
    }
    public static void main(String[] args) {
        //abbbaabcabbabcba abc
        BrutoForce bruto= new BrutoForce("abbbaabcabbabcba", "abc");
    }
}
