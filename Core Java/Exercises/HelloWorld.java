public class HelloWorld {
    public static void main(String[] args) {
    // as per *args positional args in python. to be passed in the terminal, no args by default
    // javac filename.java -> filename.class
    // filename + args -> output
        System.out.println("Hello World!");

        if (args.length == 0) {
            System.out.println("No Params");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println("Param " + i + ": " + args[i]);
        }
    }
}

