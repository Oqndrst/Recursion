package Object;

import java.util.Scanner;

/**
 * 需求：解决汉诺塔问题
 * （1）创建Tower类，通过towerMove方法解决问题
 * （2）汉诺塔问题可以简化为初始在A柱把除底层外的放到B柱，将底层放到C柱
 *      1.即过程为A-B,A-C,B-C
 *      2.towerMove(n,a,b,c)假定功能：把A的n层放到C
 */
public class HanoiTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入汉诺塔层数：");
        int n = scanner.nextInt();
        Tower tower = new Tower();
        char a = 'A';
        char b = 'B';
        char c = 'C';
        tower.towerMove(n,a,b,c);
    }
}
class Tower{
    //假定towerMove(n,a,b,c)功能是把A的n层放到C
    public void towerMove(int n,char a,char b,char c){
        if(n<1){
            System.out.println("输入错误");
        }else if(n==1){
            System.out.println(a+"->"+c);
        } else {
            //把A上的n-1层放到B
            towerMove(n-1,a,c,b);
            //把A上的第n层放到c
            System.out.println(a+"->"+c);
            //把B上的n-1层放到C
            towerMove(n-1,b,a,c);
        }
    }
}
