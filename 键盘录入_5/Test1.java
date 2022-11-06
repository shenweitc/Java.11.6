package 键盘录入_5;

import java.util.ArrayList;
import java.util.Scanner;

/*
键盘录入一些1~100之间的整数，并添加到集合中。
直到集合中所有数据和超过200为止。
 */
public class Test1 {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<Integer> list=new ArrayList<>();
        //键盘录入数据
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("请输入一个整数：");
            String numStr = sc.nextLine();
            int num = Integer.parseInt(numStr);
            if(num<1||num>100){
                System.out.println("输入的数不在范围之内，请重新输入：");
                continue;
            }
            list.add(num);

            //统计和
            int sum=grtSum(list);
            
            if(sum>200){
                System.out.println("集合中所有数据和超过200");
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }

    private static int grtSum(ArrayList<Integer> list) {
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            int num=list.get(i);
            sum+=num;
        }
        return sum;
    }
}
