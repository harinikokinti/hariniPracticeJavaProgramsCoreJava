package com.harini.core.exceptionalHandling;
/*
-- Exception Propagation
An exception is first thrown from the top of the stack and if it is not caught,
it drops down the call stack to the previous method.
If not caught there, the exception again drops down to the previous method,
and so on until they are caught or until they reach the very bottom of the call stack. This is called exception propagation.

Note: By default Unchecked Exceptions are forwarded in calling chain (propagated).
      By default, Checked Exceptions are not forwarded in calling chain (propagated).

 */
public class ExceptionPropagation {
    void m(){
        int data=50/0;
    }
    void n(){
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handled");}
    }
    public static void main(String args[]){
        ExceptionPropagation obj=new ExceptionPropagation();
        obj.p();
        System.out.println("normal flow...");
    }
}  // Exception can be handled in any method in call stack either in the main() method, p() method, n() method or m() method.


