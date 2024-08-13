import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int num;

            System.out.println("Enter a num");
            num=input.nextInt();

            fib(num);

            System.out.println("Fibonacci number at position " + num + " is: " + fib(num));
        }
        
    }

    public static int fib(int num){
       int sum = 0;

       if (num <= 1) {
        return num;
    }

    int[] fib = new int[num + 1];
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i <= num; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

       return sum; 
    }
}

