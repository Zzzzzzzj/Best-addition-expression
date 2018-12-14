import java.util.ArrayList;
import java.util.List;

/**
 * 设V(m,n)表示在n个数字中插入m个加号所能形成
 的表达式最小值，那么：
 if m = 0
 V(m,n) = n个数字构成的整数
 else if n < m + 1
 V(m,n) = ∞
 else
 V(m,n) = Min{ V(m-1,i) + Num(i+1,n) } ( i = m … n-1)
 Num(i,j)表示从第i个数字到第j个数字所组成的数。数字编号从1开始算。此操
 作复杂度是O(j-i+1)
 总时间复杂度：O(mn2
 ) .
 *
 *
 *
 */

public class test2 {

    private static int[][] v=new int[10][10];

    private static String math="123456789";

    private static void init(int m,int n){

        if (m==0)
            v[m][n]=Integer.valueOf(math.substring(0,n));
        //如果加号大于等于数字总数 则设置为无穷
        else if (m>=n)
            v[m][n]=999999999;
        else{
            List<Integer> a=new ArrayList();
            //如果加号就比数字少1，则就为 1+2+3+4+n
            if (m==n-1){
                int count=0;
                for (int i=0;i<n;i++){
                    int z=Integer.valueOf(math.substring(i,i+1));
                    count+=z;
                }
                v[m][n]=count;
                return;
            }
            for (int i=m;i<n-1;i++){
                if (v[m-1][i]==0){
                    init(m-1,i);
                }
                int num=v[m-1][i]+Integer.valueOf(math.substring(i,n));
                a.add(num);
            }

           v[m][n]=min(a);
        }

    }


    private static int min(List<Integer> a){
        int min=999999;
        for (int number:a){
            if (number<min){
                min=number;
            }

        }

        return min;

    }

    public static void main(String[] args){
        init(1,9);

        System.out.println(v[1][9]);

    }

}
