public class ArrayTestE {
    public static void main(String[] args){
        int i;int a[]=new int[2];
        try{
            for (i=0;i<=a.length;i++) a[i]=4*(i+1);
            System.out.println("出现异常后本语句不执行");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("异常");
        }
        finally {
            {
                for (i=a.length-1;i>=0;i--)
                    System.out.print("a["+i+"]="+a[i]+" ");
            }
            System.out.println("\n结束");
        }
    }
}
