package Object;

import java.util.Scanner;

/**
 * 需求： 解决n皇后问题，在n×n的国际象棋上摆放n个皇后，任意两个皇后不得处在同一行、同一列或者同一对角斜线上。
 * （1）创建一个长度n的一维数组，queens[n]表示棋盘
 *      1.数组下标表示行数，元素值表示列数
 *      2.每个下标只代表一个元素：任意两个皇后不会处在同一行
 *      3.每个元素的值不相等：任意两个皇后不会处在同一列,0<=元素值<n
 *      4.两个元素（下标差的绝对值）！=（值差的绝对值）：任意两个皇后不会处在同一对角线
 * （2）创建Queens2类，int num属性，putQueen方法,judge方法,traverse方法
 *      1.int num属性：存放找到的解法数量，每运行一次程序加载一次Queens2类，num初始化一次
 *      2.putQueen方法：找到n皇后解法(假定功能：在当前数组下，找到第i行及后续每行皇后的所有摆法)
 *          1_putQueen(int[] queens,int i)传入当前数组，当前行数
 *          2_判断数组长度：长度为1；长度大于1；
 *          3_调用judge方法判断是否可以在当前列摆皇后（queens[i]值是否可以取j）
 *              如不可以：循环带入j+1（找到当前行皇后的所有摆法）
 *              如可以：递归调用自身，寻找第i+1行及后续皇后的摆法（找到后续每行皇后的所有摆法）
 *                  (当i==queens.length是说明已经找到一种解法，调用traverse方法输出)
 *      3.judge方法：判断当前位置是否可以摆放皇后
 *          1_每个下标只代表一个元素：任意两个皇后不会处在同一行
 *          2_每个元素的值不相等：任意两个皇后不会处在同一列
 *          3_两个元素（下标差的绝对值）！=（值差的绝对值）：任意两个皇后不会处在同一对角线
 *      4.traverse方法：遍历并输出当前数组
 *
 */
public class EightQueens02 {
    public static void main(String[] args) {
        //创建scanner对象接受用户输入的n值
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n<1){
            System.out.println("请输入棋盘大小(大于等于1)：");
            n = scanner.nextInt();
        }

        //创建对应n的一维数组，元素默认初始化为0
        int[] queens = new int[n];

        //创建Queens2的对象que，调用putQueen方法
        Queens2 que = new Queens2();
        que.putQueen(queens,0);
    }
}
class Queens2{
    //存放找到的解法数量，每运行一次程序加载一次Queens2类，num初始化一次
    int num = 0;

    //找到n皇后的解法
    public void putQueen(int[] queens,int i){
        //判断数组长度：长度为1；长度大于1；
        if(queens.length==1){
            queens[0]=1;
            System.out.println(queens.length+"皇后解法第"+(++num)+"种");
            traverse(queens);
        }else {
            //当i==queens.length是说明已经找到一种解法，调用traverse方法输出
            if(i<queens.length){
                /*调用judge方法判断是否可以在当前列摆皇后（queens[i]值是否可以取j）
                         如不可以：循环带入j+1
                         如可以：递归调用自身，寻找第i+1行及后续皇后的摆法*/
                for(int j = 0;j < queens.length;j++){
                    if(judge(queens,i,j)){
                        queens[i] = j;
                        putQueen(queens,i+1);
                        queens[i] = 0;
                    }
                }
            }else {
                System.out.println(queens.length+"皇后解法第"+(++num)+"种");
                traverse(queens);
            }
        }
    }

    //判断当前位置是否可以摆放皇后(queens[i]值是否可以取j)
    public boolean judge(int[] queens,int a,int b){
        //每个元素的值不相等：任意两个皇后不会处在同一列
        for (int i = 0;i < a;i++){
            if(queens[i]==b){
                return false;
            }
        }

        //两个元素（下标差的绝对值）！=（值差的绝对值）：任意两个皇后不会处在同一对角线
        //i表示下标差的绝对值
        for(int i = 1;i <= a; i++){
            if(Math.abs(b-queens[a-i])==i){
                return false;
            }
        }

        //如果条件都满足
        return true;
    }

    //遍历并输出当前数组
    public void traverse(int[] queens){
        for(int i = 0;i < queens.length;i++){
            System.out.print(queens[i]+"\t");
        }
        System.out.println();
    }
}
