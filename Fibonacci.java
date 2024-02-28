package Object;
import java.util.Scanner;
/**
 * 需求：递归的方式求出斐波那契数：1，1，2，3，5，8，13给一个整数n，求出第n个的值
 * （1）创建一个Fibonacci类，类中创建fibonacci01方法
 * （2）fibonicci01方法假定功能：返回第n个数的值
 *      1.第n个数的值是前两个数之和
 *          即fibonicci01(n-1)+fibonicci01(n-2)
 *      2.当n等于1或者2时返回1
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的斐波那契数列位置：");
        n = scanner.nextInt();
        Fibonacci01 fibonacci = new Fibonacci01();
        int m = fibonacci.fiboniacci01(n);
        System.out.println("第"+n+"个数是"+m);
    }
}
class Fibonacci01{
    //假定fibonicci01方法中返回第n个数的值
    public int fiboniacci01(int n){
        if(n==1||n==2){
            //当n是1或2时值为1
            return 1;
        }else if(n < 1) {
            System.out.println("请输入一个大于等于1的整数");
            return -1;
        }else {
            //第n个数的值等于它前面两个数之和
            return fiboniacci01(n-1)+fiboniacci01(n-2);
        }
    }
}
