class First {
    First() {
        aMethod();
    }
    First(int a) {
        aMethod();
    }
     public  void aMethod() {
        System.out.println("in First class");
    }

}

public class Second extends First{
    Second(){
        //super();
        //super(1);
        //super();
        //super.aMethod();
        aMethod();
    }
    public void aMethod(){
        System.out.println("in Second class");
    }
    public static void main(String[] args){
        new Second();
    }
}
