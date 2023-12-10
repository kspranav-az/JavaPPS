@FunctionalInterface
interface  A{
    void show();
}

interface B{
    void add(int a,int b);
}

interface C{
    int mult(int a,int b);
}
public class Lambda {
    public static void main(String[] args){
        //inner class
        A obj = new A()
        {
            public void show(){
                System.out.println("inner class");
            }
        };
        obj.show();
        A obj1 = () ->
        {
            System.out.println("lambda expression of inner class");
        };
        obj1.show();

        B obj2 = (int a,int b)->
        {
            System.out.println(a+b);
        };
        obj2.add(1,2);

        C  obj3 = (int a,int b)->
        {
            return a+b;
        };

        int ans = obj3.mult(2,4);
        System.out.println(ans);
    }
}