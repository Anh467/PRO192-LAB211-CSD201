package Lab1;

import java.util.Scanner;

public class LAb1 {

    public static int choice() {

       Scanner sc = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1.nhập tên học sinh ");
        System.out.println("2.nhập điểm ");
        System.out.println("3.xuất dữ liệu ");
        System.out.println("4.xếp loại học sinh ");
        System.out.println("5.sắp xếp theo điểm giảm dần ");
        System.out.println("6.quit");
        System.out.print("Lựa chọn: ");
        int userChoice = sc.nextInt();
        return userChoice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userChoice, check;
        String[] name = new String[150];
        String draft;
        float[] score = new float [150];
        int n = 0;
        do {
            userChoice = choice();
            switch (userChoice) {
                case 1:
                    System.out.print("Enter student name:");
                    n++;
                    name[n]= sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter student name need to add mark:");
                    draft= sc.nextLine();
                    check=0;
                    for(int i=1; i<=n; i++)
                        if(draft.equalsIgnoreCase(name[i])){
                            check=i;
                            break;
                        }
                    System.out.print("enter score: ");
                    score[check]= sc.nextFloat();
                    break;
                case 3:
                    for (int i = 0; i < n; i++) {
                        System.out.println("name: " +name[i] + "score: " + score[i]);
                    }
                    break;
                case 4:
                    for (int i = 0; i < n; i++) {
                        if (score[i] < 5) {
                            System.out.println(score[i] + "yếu ");
                        } else if (score[i] >= 5 && score[i] < 6.5) {
                            System.out.println(score[i] + "trung bình ");
                        } else if (score[i] >= 6.5 && score[i] < 7.5) {
                            System.out.println(score[i] + "kha");
                        } else if (score[i] >= 7.5 && score[i] < 9) {
                            System.out.println(score[i] + "giỏi");
                        } else {
                            System.out.println(score[i] + "xuất sắc");
                        }
                    }

                    break;
                case 5:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (score[j] > score[i]){
                                float diem = score[j];
                                score[j] = score[i];
                                score[i] = diem;
                                String ten = name[j];
                                name[j] = name[i];
                                name[i] = ten;
                            }
                        }
                    }
                 
                    for (int i = 0; i < n; i++) {
                        System.out.println(name[i] + "score " + score[i]);
                    }
                    break;
                default:
                    System.out.println("Goodbye");
                    break;
            }
        } while (userChoice > 0 && userChoice < 6);
    }

}