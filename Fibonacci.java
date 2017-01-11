class Fibonacci {
    static int fib(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }

        return fib(x - 1) + fib(x - 2);
    }

    public static void main(String[] args) {
        System.out.print("should equal 5, is actually ");
        System.out.println(fib(4));
        System.out.print("should equal 8, is actually ");
        System.out.println(fib(5));
        System.out.print("should equal 13, is actually ");
        System.out.println(fib(6));
    }
}
