package progresstest.main;
import progresstest.point.Circle;
import progresstest.point.point;
public class Main {
    public static void main(String[] args) {
//Khai báo và khởi tạo 2 điểm A, B
        point A= new point(1, 9);
        point B= new point(5, 3);
//Tính khoảng cách z của AB rồi in ra màn hình:
        System.out.println("The distance between A"+A.toString()+" and B"+B.toString()+" is "+A.distance(B));
//Khai báo và khởi tạo hình tròn tâm A bán kính r, hình tròn tâm B bán kính s
        Circle cirA= new Circle(3.211110, A.getX(), A.getY());
        Circle cirB= new Circle(4, B.getX(), B.getY());
//In ra màn hình kết quả
        if(cirA.checkCir(cirB)== true)
            System.out.println("Two circle Circle(A"+cirA.toString()+") and Circle(B"+cirB.toString()+") are in outer contact");
        else System.out.println("Two circle Circle(A"+cirA.toString()+") and Circle(B"+cirB.toString()+") are not in outer contact");
    }
    
}
