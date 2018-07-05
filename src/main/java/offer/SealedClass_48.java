package offer;

public class SealedClass_48 {
}

/**
 * 方法１：将类变为final修饰的类
 */
final class A{

}

/**
 * 方法２：将类的构造方法私有化
 */
class B{
    private B(){

    }
    public B getInstance() {
        return new B();
    }
}

