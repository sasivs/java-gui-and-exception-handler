class Try{
    public void method(int a){
        System.out.println("Value of a: " + a);
        int b = 10/a;
        System.out.println("Value of b: " + b);
    }
}

class Throw{
    public void method(){
        throw new ArrayIndexOutOfBoundsException(5);
    }
}

class Throws{
    public void method() throws NullPointerException{
        throw new ArithmeticException();
    }
}

public class excp_handler {
    public static void main(String [] args){
        int a = 1;
        try{
            Try t = new Try();
            t.method(a);
            System.out.println("No Exception");
            try{
                Throw t1 = new Throw();
                t1.method();
            }
            finally{
                System.out.println("Just after the inner try block,this will be printed even though exception occurs or not");
            }
            System.out.println("Inner try and catch blocks complete");
            Throws t2 = new Throws();
            t2.method();
        }
        catch (ArithmeticException e){
            System.out.println("In Catch: Exception caught; " + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("In Catch: Exception caught; " + e);
        }
        System.out.println("Execution complete");
    }
}
