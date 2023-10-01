
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84384
 */
public class LZW {
// đoạn văn bản cần mã hóa
    static String str= "";
// mã code sau khi đã mã hóa xong
    static String strCode= "";
// lưu mã code đã mã hóa vào array vd: strCode="30 40 50" -> int []strCodeArray[]={30, 40, 50}
    static int []strCodeArray;
// ki tu cuoi cung bang ma ascii la 255 sau do khi muon luu ki tu chua co trong bang ma thi tang them 1 don  vi
    static int newAscii= 255;
// dùng để lưu kí tự với 1 bộ mã cho dễ dàng truy xuất vd: (a,65), (c,67), (b,66) ta dễ dàng lấy bộ mã bằng cách LZWCode.get("C")-> 67
    static Map<String,Integer> LZWCode= new HashMap<>();
// dùng để lưu bộ mã suy ra kí tự với 1 cho dễ dàng truy xuất vd: (a,65), (c,67), (b,66) ta dễ dàng lấy bộ kí tự bằng cáhc LZWCode.get(67)-> c
    static Map<Integer,String> LZWDeCode= new HashMap<>();
// dùng để đưa tất cả biến về lại ban đầu
    public static void reset(){
        str= "";
        strCode= "";
        newAscii= 255;
        LZWCode= new HashMap<>();
    }
// kiểm tra kí tự có trong thư viện chưa
    public static boolean checkContain(String str){
    //neeys đã có thì trả về true
        if(LZWCode.containsKey(str)) return true;
    //nếu có đúng 1 kí tự trong chuỗi thì đưa vào thư viện đồng thời trả về tru
        if(str.length()==1){
            LZWCode.put(str,(int) str.charAt(0));
            return true;
        }
    //không thì trả về false
        return false;
    }
    public static void encode(String code, int i){
    //đã đi qua kí tự cuối cùng thì dừng
        if(i==str.length()){
        //vì đây là trường hợp đặt biệt nếu biến code có đúng 1 kí tự thì ta sẽ thực hiện xuất ra màng hình thêm vào mã hóa strCode
            if(code.length()==1){
                System.out.println(code+": "+ LZWCode.get(code));
                //thêm vào biến mã hóa
                strCode= strCode+ " "+ LZWCode.get(code);
            }else strCode= strCode+ " "+ LZWCode.get(code);
            return;
        }
        //kiếm tra đã có trong thư viện chưa, đã có rồi thì gọi dệ quy kí tự tiếp theo
        if(checkContain(code+ str.charAt(i))){
            encode(code+ str.charAt(i), ++i);
            return;
        }
        //nếu không có trong thư viên thì ta thực hiện dòng bên dưới
        // dùng lênh dưới là để thêm kì tự tại vị trí i vào thư viện
        checkContain(""+str.charAt(i));
        // vì chưa có trong thư viện nên ta đưa code vào thư viện với bộ mã ascii mới được tăng thêm "++newAscii"
        LZWCode.put(code+ str.charAt(i), ++newAscii);
        // đồng thời xuất ra màng hình kí tự và bộ mã của kí tự vừa đi qua cùng với kí tự và bộ mã của kí tự vừa thêm vào
        System.out.println(code+": "+ LZWCode.get(code)+"         "+code+ str.charAt(i)+": "+ LZWCode.get(code+ str.charAt(i)));
        // đưa kí tự vừa đi qua với bộ code vừa mã hóa vào trong strCode
        strCode= strCode+ " "+ LZWCode.get(code);
        //tiếp tục đệ quy với kí tự tiếp theo
        encode(""+ str.charAt(i), ++i);
    }
    public static void encode(String enterStr){
    // đưa giá trị về trạng thái ban đầu
        reset();
    // gán giá trị cần mã hóa vào str
        str= enterStr;
    // thực hiện encode *lưu ý kết quả sẽ được lưu vào strCode
        encode("", 0);
    }
// dùng để kiểm tra sô đã có trong thư viện chưa
    public static boolean checkContainForDecode(int num){
        //nếu có rồi thì trả về true
        if(LZWDeCode.containsKey(num)) return true;
        // nếu số đó lớn hơn hoặc bằng 0 và nhở hơn hoặc bằng 255 thì có nghĩa thuộc bảng mã ascii ta đưa vào thư viện đồng thời trả về true
        if(num>=0 && num<=255){
            LZWDeCode.put(num,""+(char) num);
            //System.out.println("num: "+num+" char: "+(char)num);
            return true;
        }
        // còn không trả về false
        return false;
    }
// sẽ dùng đệ quy để duyệt tất cả phần tư có trong mảng strCodeArray
    public static void decode( int i) {
        // nếu đã duyệt qua phần tử cuối cùng thì dừng đệ quy
        if(i==strCodeArray.length) return;
        //nếu số tại vị trí i trong strCodeArray 
        if(checkContainForDecode(strCodeArray[i])){
            //nếu đã có trong thư viện
            // ta ghép chuỗi tại i-1 vào kí tự đầu tiên của chuỗi i với bộ mã được tăng thêm "++newAscii" 
            LZWDeCode.put(++newAscii, LZWDeCode.get(strCodeArray[i-1])+LZWDeCode.get(strCodeArray[i]).charAt(0));
            //xuất ra màng hình chuỗi kí tự vừa đi qua và chuỗi kí tự vừa được thêm                                             \
                            // bộ mã vừa đi qua        chuỗi kí tự vừa đi qua                 bộ mã vừađược thêm         chuỗi kí tự vừa được thêm
            System.out.println(strCodeArray[i]+"->"+LZWDeCode.get(strCodeArray[i])+"            "+newAscii+        "->"  +LZWDeCode.get(newAscii));
        }
        else {  
            //nếu chưa có trong thư viện
            //ta sẽ ghép chuỗi kí tự tại i-1 và kí tự đầu tiên cũng của vị trí i-1 và đưa vào thư viện
            LZWDeCode.put(strCodeArray[i], LZWDeCode.get(strCodeArray[i-1])+LZWDeCode.get(strCodeArray[i-1]).charAt(0));
            //xuất ra màng hình chuỗi kí tự vừa được thêm 
            System.out.println(strCodeArray[i]+"->"+LZWDeCode.get(strCodeArray[i]));
        }
        // đi tiếp dệ quy với i tăng thêm 1
        decode(++i);
    }
    public static void decode(String enterStrCode){
    // đưa giá trị về trạng thái ban đầu
        reset();
    // ta đưa chuỗi kí tự vào mảng vd: strCode="30 40 50" -> int []strCodeArray[]={30, 40, 50}
        String[] strDraft= enterStrCode.split(" ");
    // tạo strCodeArray có kích thước như strDraft
        strCodeArray= new int[strDraft.length];
    // chạy hết strDraft để gán String vào strCodeArray
        for(int i= 0; i< strDraft.length; i++)
            // ép kiểu từ kí tự sang int
            strCodeArray[i]= Integer.parseInt(strDraft[i].trim());
    // đưa phần tư đầu tiên trong strCodeArray vào thư viện vì kí tự đầu tiên luôn là kí tự có trong ascii
        LZWDeCode.put(strCodeArray[0],""+(char) strCodeArray[0]);
        System.out.println(strCodeArray[0]+"->"+LZWDeCode.get(strCodeArray[0]));
    // thực hiện decode bắt đầu tại vị trí 1 vì vị trí 0 luôn là kí tự có trong bảng mã assccii
        decode(1);
        System.out.print("output: ");
    // xuất ra màng hình kết quả
        for(int i= 0; i< strCodeArray.length; i++)
            System.out.print(LZWDeCode.get(strCodeArray[i]));
    }
    public static void main(String[] args) {
        //ABABCABCDABCDE
        //WYS*WYGWYS*WYSWYSG
        //WYS*WYGWYS*WYSWYSG
        //CFCFCFCCFCCFC
        //BABAABRRR
        //bn abnbnb bnb
//        encode("bn abnbnb bnb");
//        System.out.println("output: "+ strCode);
        //87 89 83 42 256 71 256 258 262 262 71
        //66 65 256 257 82 260
        encode("AAABCADAB");
        System.out.println("output: "+ strCode);
        //decode("66 65 256 257 82 260");
        //decode("66 65 256 257 82 260");
    }
}
