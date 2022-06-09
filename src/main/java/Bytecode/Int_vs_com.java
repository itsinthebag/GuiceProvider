package Bytecode;

/*
-Xint: 2.8
-Xcom: 2.8
-Xmix: 3
 */
public class Int_vs_com
{
    public static void main(String[] args)
    {
        for(long i=0; i<100_000L; i++){
            m();
        }

        long start = System.currentTimeMillis();
        for(long i=0; i<100_000L; i++){
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static void m(){
        for(long i=0; i<100_000L;i++){
            long j = i%3;
        }
    }
}
