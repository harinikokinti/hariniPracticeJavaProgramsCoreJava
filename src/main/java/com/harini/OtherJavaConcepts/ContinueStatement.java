package com.harini.OtherJavaConcepts;
// continue statement in  while loop
public class ContinueStatement {
    public static void main(String args[]) {

        int i = 0;
        while(i<10) {
            if(i==4){
               i++;  //  here i must be incremented to not to stop the iteration
                continue;  // skips the iteration for  i=4

            }

            System.out.println(i);
            i++;
        }
    }
}


// continue statement in for loop

class ContinueInForLoop {
    public static void main(String args[]) {
        for(int i=0; i<5; i++) {
            if(i==2) {
                continue; // skips the iteration for i=2
            }
            System.out.println(i);
        }
    }

}