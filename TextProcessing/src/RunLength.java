

public class RunLength {
    public static void decode(String string) {
        String resultString="";
        for (int i = 0; i < string.length(); i+=2) {
            int count=Character.getNumericValue(string.charAt(i));
            for(int j=0;j<count;j++) {
                resultString+=string.charAt(i+1);
            }
        }
        System.out.println(resultString);
        
    }
    public static void encoding(String str)
    {
        int n = str.length();
        for (int i = 0; i < n; i++) {
 
            // Count occurrences of current character
            int count = 1;
            while (i < n - 1
                   && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            // Print character and its count
            System.out.print(str.charAt(i) + "" + count);
        }
    }
    public static void main(String[] args) {
        decode("2A3b4D");
        encoding("00011011001");
        
    }
}
