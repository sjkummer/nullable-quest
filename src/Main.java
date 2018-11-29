import org.jetbrains.annotations.NotNull;

class Main {

    public static void main(String [] args) {
        @NotNull SubClass instance = new SubClass();
        System.out.println("Execution completed. SubClass has been instantiated: " + instance);
    }
}
