package ustc.dicey.ssm.util;



public class TestClass
{
    public static void main(String[] args)
    {
        test();

    }

    public static void test()
    {
        getCaller();
    }

    public static void getCaller()
    {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (int i = 0; i < stack.length; i++)
        {
            StackTraceElement s = stack[i];
            System.out.format(" ClassName:%d\t%s\n", i, s.getClassName());
            System.out.format("MethodName:%d\t%s\n", i, s.getMethodName());
            System.out.format("  FileName:%d\t%s\n", i, s.getFileName());
            System.out.format("LineNumber:%d\t%s\n\n", i, s.getLineNumber());
        }
    }
}