/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import myArray.MyLinkedList;
import myArray.MyArrayList;
import model.*;
public class TestLinkedList {
    public static int sum(MyLinkedList list){
        int s= 0;
        for(int i= 0; i< list.size(); i++)
            s+=(int) list.get(i);
        return s;
    }
    public static int countOdd(MyLinkedList list){
        int s= 0;
        for(int i= 0; i< list.size(); i++)
            if((int) list.get(i)%2!=0)
                s+=1;
        return s;
    }
    public static boolean primeCheck(int index){
        if(index<2) return false;
        if(index==2) return true;
        for(int i=2; i*i<= index; i++)
            if(index%i==0) return false;
        return true;
    }
    public static int avePrime(MyLinkedList list){
        int s= 0, n= 0;
        for(int i= 0; i< list.size(); i++)
            if(primeCheck((int)list.get(i))==true){
                s+= (int) list.get(i);
                n++;
            }
        if(n==0) return 0;
        return s/n;
    }
    public static int diffMinMAx(MyLinkedList list){
        int min=0, max=0;
        if(((int)list.get(0))>((int)list.get(1))){
            max= (int)list.get(0);
            min= (int)list.get(1);
        }else{
            min= (int)list.get(0);
            max= (int)list.get(1);
        }
            
        for(int i= 2; i< list.size(); i++){
            if(min>(int)list.get(i))
                min= (int)list.get(i);
            if(max<(int)list.get(i))
                max= (int)list.get(i);
        }
        return max-min;
    }
    public static int sumLargest(MyLinkedList list, int max, int index){
        while(index<list.size()-1){
            if (max<(((int) list.get(index))+((int) list.get(index+1))))
                max= ((int) list.get(index))+((int) list.get(index+1));
            index++;
        }
        return max;
    }
     public static int sumTwoLargest(MyLinkedList list){
        int max1=0, max2=0, index=2;
        if(((int)list.get(0))>((int)list.get(1))){
            max2= (int)list.get(0);
            max1= (int)list.get(1);
        }else{
            max1= (int)list.get(0);
            max2= (int)list.get(1);
        }
        while(index<list.size()){
            if (max2< (int)list.get(index)){
                max1= max2;
                max2= (int)list.get(index);
            }
            index++;
        }
        return max1+ max2;
    }
    public static void reverses(MyLinkedList list){
        for(int i=0; i< list.size()/2; i++){
            int temp=(int) list.get(i);
            list.set(i, list.get(list.size()-i-1));
            list.set(list.size()-i-1, temp);
        }
    }
    public static void removeNegative(MyLinkedList list){
        for(int i=0; i< list.size(); i++)
            if((int) list.get(i)<0){
                list.remove(i);
                --i;
            }
    }
    public static void removeSimilar(MyLinkedList list){
        for(int i=0; i< list.size(); i++)
            for(int j= i+1; j<list.size(); j++)
                if(((int)list.get(i))==((int)list.get(j))){
                    list.remove(j);
                    --j;
                }
    }
    public static void removeSpecified(MyLinkedList list, int i){
        int value= (int) list.get(i);
        while(list.remove((Object)value)==true);
    }
    public static boolean checkSorted(MyLinkedList list){
        if(((int)list.get(0))>((int)list.get(1))){
            for(int i=1; i< list.size()-1; i++)
                if(((int)list.get(i))<((int)list.get(i+1)))
                    return false;
        }
        else for(int i=1; i< list.size()-1; i++)
                if(((int)list.get(i))>((int)list.get(i+1)))
                    return false;
        return true;
    }
    public static boolean checkIncrease(MyLinkedList list){
         for(int i=0; i< list.size()-1; i++)
                if(((int)list.get(i))>((int)list.get(i+1)))
                    return false;
        return true;
    }
    public static void insertInc(MyLinkedList list, int value){
        if(checkIncrease(list)==true)
        for(int i=0; i< list.size(); i++)
                if(i==list.size()-1){
                    System.out.println(i);
                    list.addLast(value);
                    break;
                }
                else if((((int)list.get(i))<=value)&&(((int)list.get(i+1))>=value)){
               
                    list.addIndex(i+1, value);
                    break;
                }
    }
    public static void mergeList(MyLinkedList list1, MyLinkedList list2, MyLinkedList draft){
        int i=0,j =0;
        while((i!=list1.size())&&(j!=list2.size())){
            if(((int)list1.get(i))<((int)list2.get(j))){
                draft.add(((int)list1.get(i)));
                ++i;
            }else{
                draft.add(((int)list2.get(j)));
                ++j;
            }
            if(j==list2.size())
                for(int k= i; k<list1.size(); k++)
                    draft.add(((int)list1.get(k)));
            if(i==list1.size())
                for(int k= j; k<list2.size(); k++)
                    draft.add(((int)list2.get(k)));
        }
    }
    public static void addListEnd(MyLinkedList list, MyLinkedList draft){
        for(int i=0; i< draft.size(); i++)
            list.addLast(draft.get(i));
    }
     public static void QuickSort(MyLinkedList list1, int i, int j) 
    {  
        
        int p=(int) list1.get((i+j)/2);
        int l= i, r= j;
        do {            
            while (((int)list1.get(i))<p){
                i++;
            }
            while (((int)list1.get(j))>p){
                j--;
            }
            if(i<=j){
                int temp= ((int)list1.get(i));
                list1.set(i,(int)list1.get(j));
                list1.set(j, temp);
                i++; j--;
            }
            if (i>j) break;
        } while (true);
        if(l<j) QuickSort(list1, l, j);
        if(i<r) QuickSort(list1, i, r);
    }  
     public static boolean sameContents(MyLinkedList list1, MyLinkedList list2){
        if(list1.size()!=list2.size())
             return false;
        QuickSort(list1, 0, list1.size()-1);
        QuickSort(list2, 0, list2.size()-1);
        for(int i=0; i< list1.size(); i++)
            if(((int)list1.get(i))!=((int)list2.get(i)))
                return false;
        return true;
     }
    public static void main(String[] args) {
        MyLinkedList<Integer> list= new MyLinkedList();
        list.add();
        list.toString();
        System.out.println(list.toString());
        System.out.println("Sum= "+sum(list));
        
        System.out.println("Sum odd= "+countOdd(list));
        System.out.println("Sum prime= "+avePrime(list));
        System.out.println("Different min and max= "+diffMinMAx(list));
        System.out.println("Largest sum="+ sumLargest(list, ((int) list.get(0))+((int) list.get(1)), 1));
        System.out.println("Sum two largest="+ sumTwoLargest(list));
        list.reverse();
        System.out.println("Ater reverses: "+ list.toString());
        System.out.println("get first: "+list.getFirst()+" get last: "+list.getLast());
        list.removeNegative();
        //list.add(-5);
        System.out.println("Ater remove negative number: "+ list.toString());
                

        removeSimilar(list);
        System.out.println("Ater remove similar: "+ list.toString());
        removeSpecified(list, 2);
        System.out.println("Ater specified element : "+ list.toString());
        System.out.println("Check sorted list: "+checkSorted(list));
        insertInc(list, 32);
        System.out.println("Ater insert element : "+ list.toString());
        MyLinkedList<Integer> listDraft= new MyLinkedList();
        MyLinkedList<Integer> draft= new MyLinkedList();
        listDraft.add(2);
        listDraft.add(6);
        listDraft.add(10);
        listDraft.add(11);
        listDraft.add(20);
        listDraft.add(25);
        System.out.println("first list: "+ list.toString());
        System.out.println("Second list: "+ listDraft.toString());
        mergeList(list, listDraft, draft);
        System.out.println("Ater merge 2 list : "+draft.toString());
        addListEnd(list, listDraft);
        //1 2 6 10 11 15 20 20 25 30 32 40 
        // 1 15 20 30 32 40 
        listDraft.add(1);
        listDraft.add(15);
        listDraft.add(20);
        listDraft.add(30);
        listDraft.add(32);
        listDraft.add(40);
        System.out.println("Ater Attach a singly linked list to the end of another singly linked list: "+list.toString());
        //System.out.println("linked list have the same contents is:"+ sameContents(list, listDraft));
    }
}