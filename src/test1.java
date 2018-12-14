import java.util.Scanner;

/**
 * 有一个由1..9组成的数字串.问如果将m个加
 号插入到这个数字串中,在各种可能形成的
 表达式中，值最小的那个表达式的值是多少
 */




public class test1 {

    public static void main(String[] args){
        String math="123456789";
        char[] maths=math.toCharArray();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if (n>math.length()-1){
            System.out.println("输入错误");
        }



    }
}
