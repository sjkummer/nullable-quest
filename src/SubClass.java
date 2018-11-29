import org.jetbrains.annotations.NotNull;

class SubClass extends SuperClass {

    @NotNull
    private String aString = "initialised";

    SubClass() {
        super();
        aString += " and extended by constructor";
    }

    @Override
    void abstractMethod() {
        int length = aString.length();
        System.out.println(aString + " has " + length + " characters");
    }
}
