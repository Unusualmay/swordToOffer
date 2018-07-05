package exception;

public class ExceptionTestChild extends ExceptionTest{
    /**
     * 子类覆写父类中含有抛异常的方法，可以不用抛异常
     */
    @Override
    public void fileRead(String name) {
        System.out.println("这是子类");
    }

    public static void main(String[] args) {
        ExceptionTestChild etc = new ExceptionTestChild();
        etc.fileRead("ｈｏｉｏｉｈｉｏｈ");
    }
}
