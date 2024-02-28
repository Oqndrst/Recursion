package Object;

/**
 * 此方法并不完善，建议直接看一维数组版
 * 需求： 解决八皇后问题，在8×8的国际象棋上摆放八个皇后，任意两个皇后不得处在同一行、同一列或者同一对角斜线上。
 * （1）创建一个8x8的二维数组，queens[8][8]表示棋盘
 * （2）创建Queens类，PutQueen方法
 *      1.分别在0~7行寻找一个合适的位置
 *      2.PutQueen(queens[8][8],i,j)假定功能：在当前数组下，找到第i行，及后续每行皇后所有可能摆法
 *          1_判断queens[i][j】是否符合要求
 *          2_将数组第i行第j个元素设置为1
 *          3_调用自身寻找下一个位置
 */
public class EightQueens {
    public static void main(String[] args) {
        int[][] queens = new int[8][8];
        Queens queens1 = new Queens();
        for(int k=0;k<8;k++){
            queens1.putQueens(queens,0,k);
        }
    }
}
class Queens{
    int num = 0;
    public void putQueens(int[][] queens,int i,int j){
        if(i<8){
            if(judge(queens,i,j)){
                queens[i][j]=1;
                for(int k=0;k<8;k++){
                    putQueens(queens,i+1,k);
                }
                queens[i][j]=0;
            }
        }else if(i==8&&j==0){
            System.out.println("第"+(++num)+"种解法是");
            bianli(queens);
        }
    }
    //检查摆放位置是否符合要求
    public boolean judge(int[][] queens,int i,int j){
        for(int a=0;a<8;a++){
            if(queens[a][j]==1){
                return false;
            }
            if(queens[i][a]==1){
                return false;
            }
        }
        int a=i;
        int b=j;
        while(a>0&&b>0){
            a--;
            b--;
            if(queens[a][b]==1){
                return false;
            }
        }
        a=i;
        b=j;
        while(a<7&&b<7){
            a++;
            b++;
            if(queens[a][b]==1){
                return false;
            }
        }
        a=i;
        b=j;
        while(a>0&&b<7){
            a--;
            b++;
            if(queens[a][b]==1){
                return false;
            }
        }
        a=i;
        b=j;
        while(a<7&&b>0){
            a++;
            b--;
            if(queens[a][b]==1){
                return false;
            }
        }
        return true;
    }
    //遍历当前数组
    public void bianli(int[][] queens){
        for(int m=0;m<8;m++){
            for (int n=0;n<8;n++){
                if(queens[m][n]==0){
                    System.out.print('0'+"\t");
                }else {
                    System.out.print('后'+"\t");
                }

            }
            System.out.println();
        }
    }
}

