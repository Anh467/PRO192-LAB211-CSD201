/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0025.control;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class Control {
    public StringBuffer deleteSpace(StringBuffer content){ 
        String contentText= content.toString();
        contentText= contentText.trim();
        while(contentText.contains("  "))
            contentText= contentText.replaceAll("  "," ");
        content= new StringBuffer(contentText);  
        return content;
    }
    public boolean checkSign(Character sign){
        return((sign==',')||(sign=='.')||(sign==':')||(sign=='"'));
    }
    public StringBuffer standard(StringBuffer content){
        content= deleteSpace(content);
        content.setCharAt(0, Character.toUpperCase(content.charAt(0)));
        Stack colon= new Stack();
        Stack colonStack= new Stack();
        for(int i=1; i< content.length()-3; i++)
            if(checkSign(content.charAt(i))){
                switch (content.charAt(i)) {
                    case '.':if(content.charAt(i+1)!=' ')
                            content.insert(i+1, " ");
                            content.setCharAt(i+2, Character.toUpperCase(content.charAt(i+2)));
                            break;
                    case '"': if(colon.isEmpty()){
                                if(content.charAt(i+1)==' ')
                                    content.deleteCharAt(i);
                                i--;
                                colon.push('"');
                                colonStack.push(i);
                            }else{
                                colonStack.pop();
                                if(content.charAt(i-1)==' ')
                                    content.deleteCharAt(i);
                                colon.pop();
                            }
                    default:if(content.charAt(i+1)!=' ')
                                content.insert(i+1, " ");
                            content.setCharAt(i+2, Character.toLowerCase(content.charAt(i+2)));
                            
                            break;
                }
                if(content.charAt(i-1)==' '){
                    content.delete(i-1, i);
                    i--;
                }
            }
        if(!colonStack.isEmpty())
            content.deleteCharAt((int)colonStack.pop());
        if(content.charAt(content.length()-1)!='.')
            content.append(".");
        return content;
    }
}
