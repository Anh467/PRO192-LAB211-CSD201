/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myArray;


public class MyArrayList <E>{
    public E []a;
    private int n;

    public MyArrayList() {
        a= (E[]) new Object[10];
        n= 0;
    } 
    public MyArrayList(int capacity){
        if(capacity<0)
            a=(E[]) new Object[10];
        else 
            a=(E[]) new Object[10];
        n=capacity;    
    }

    // tang kich thuoc mang neu so luong phan tu vuot qua
    public void increaseSize(){
        E[] b=(E[]) new Object[n*2];       
            for(int i= 0; i<a.length; i++)
                b[i]= a[i];
            a=b;
           System.arraycopy(b, 0, a, 0, n);
    }
    // them 1 phan tu vao cuoi mang
    public void add( E x){
        if(n== a.length)
            increaseSize();
        n++;
        a[n-1]= x;
    }
    // them 1 phan vao vi tri cho truoc
    public void add(int index, E x){
        if(n== a.length)
            increaseSize();
        n++;
        for(int i=n-1; i>=index ; i--){
            a[i+1]=a[i];
        }
        a[n+1]=a[n-1];
        a[index]= x;
    }
    //output
    public void output(){
        System.out.println("         Array: ");
        for(int i=0; i< n; i++)
            System.out.println(a[i]);
    }
    //lay phan tu tai vi tri cho truoc
    public E get(int index) {
        return a[index];
    }
    //chinh sua 1 phan tu tai vi tri cho tuoc
    public void set(int index, E a) {
        this.a[index] = a;
    }
    //xoa 1 phan tu tai vi tri cho truoc
    public void remove(int index){
        for(int i=index; i< n-1; i++)
            a[i]=a[i+1];
        n--;
    }
    //kiem tra phan tu co ton tai k
    public boolean contain(E x){
        for(int i= 0; i< n; i++)
            if(x==a[i])
                return true;
        return false;
    }
    //lan xuat hien dau tien trong mang
    public int indexOf(E x){
        for(int i= 0; i< n; i++)
            if(x==a[i])
                return i;
        return -1;
    }
    //lan xuat hien cuoi cung trong mang
    public int lasIndexOf(E x){
        for(int i= n-1; i>=0; i--)
            if(x==a[i])
                return i;
        return -1;
    }
    //xem thanh phan trong arrayList
    public void view(){
        System.out.println("[");
        for(int i=0; i< n; i++)
            System.out.print(a[i]+" ");
        System.out.println("]");
    }
    //kich thuoc chuong trinh
    public int size(){
        return n;
    }
    //toString
     @Override
     public String toString() {
         int k= 0;
         String str="";
         for(int i=0; i< n-1; i++){
             int k1= str.length();
             str=str+a[i]+", ";
             if((str.length()-k)>20)
                 str=str+ " \n";
             k=k+ str.length()- k1;
         }
         str=str +a[n-1];
         return "["+str+"]";
     }
}
