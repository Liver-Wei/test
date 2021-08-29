interface jiekou{
    public static final int x=30;
    public static final int y=10;
    public abstract void output();
}
public class A implements jiekou{

    @Override
    public void output() {
        System.out.println("x+y="+(x+y));
    }
}
class B implements jiekou{
    @Override
    public void output() {
        System.out.println("x-y="+(x-y));
    }
}

class exam{
    public static void main(String[] args){
        A a=new A();
        a.output();
        B b=new B();
        b.output();
    }
}

