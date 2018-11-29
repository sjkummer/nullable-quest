# Limitations of @NotNull Annotations and Code Inspection

## About

In Java, the most widespread problem causing applications to crash is the so called NullPointerException. Developers can deal with this problem by introducing Annotations (e.g. @Nullable and @NotNull) and using code inspectors. A correctly annotated code that passes code analysis without any warning should never crash - that's the theory.


## Code Quest

The following code is correctly annotated and passed code inspection without any warnings. Nevertheless, it will crash immediately when executed.

### Main.java

    import org.jetbrains.annotations.NotNull;
    
    class Main {
    
        public static void main(String [] args) {
            @NotNull SubClass instance = new SubClass();
            System.out.println("Execution completed. SubClass has been instantiated: " + instance);
        }
    }

### SubClass.java

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


### SuperClass.java

    abstract class SuperClass {
    
        SuperClass() {
            abstractMethod();
        }
    
        abstract void abstractMethod();
    }


## Exception

When executing this project, you will get the following exception stacktrace:

    Exception in thread "main" java.lang.NullPointerException
        at SubClass.abstractMethod(SubClass.java:15)
        at SuperClass.<init>(SuperClass.java:4)
        at SubClass.<init>(SubClass.java:9)
        at Main.main(Main.java:6)


## Code Inspection

Code Inspectors can be separate tools or part of your IDE. In my case, I used IntelliJ IDEA from Jetbrains.

Just checkout the project, open it in IntelliJ and run 'Analyze' -> 'Inspect Code'

The inspection will pass without any warnings: "No suspicious code found. 4 files processed in 'Project 'NullableQuest'."

![Inspection Result](inspection-result.png)


## Hints

* This has nothing to do with the Annotations itself. You can remove them if you want, but the problem will persist.

* This has nothing to do with Threading.

* This has something to do with Java itself.


## Solution of this quest

Spoiler alert!

You'll find it here: [Solution](SOLUTION.md)