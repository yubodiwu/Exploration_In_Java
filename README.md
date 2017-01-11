## An Exploration in Java

#### Introduction:
Java is a programming language created by Sun Microsystems in 1995, and it would not be a stretch to say it is now the most popular programming language in existence. It is a general purpose, class-based, object-oriented language, and in the creation of java there were 5 principles:

1. It must be "simple, object-oriented, and familiar".
1. It must be "robust and secure".
1. It must be "architecture-neutral and portable".
1. It must execute with "high performance".
1. It must be "interpreted, threaded, and dynamic".

It is somewhat unique in that all of the code must be in classes. Scripting can sort of be done, but it must be inside of a class and then the script can be put inside the main method of that class, here's a hello world program in Java:
``` Java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // print 'Hello World!' to the console
    }
}
```
It is also a strongly typed language, meaning that each type of data (integer, character, hexadecimal, etc.) are predefined and all variables must be described with one of those given data types. It is also compiled as opposed to interpreted. For example, creating an integer variable with a value of 7 would look like this:
```Java
int x = 7;
```
and creating a string "Hello World!" would be:
```Java
String x = "Hello World!";
```

#### Why use Java?
So with these rather inconvenient drawbacks (OOP being a requirement, strongly typed, etc.), and the unwieldy amounts of code needed to perform simple tasks, why bother using Java? Besides it being incredibly popular and being almost everywhere.

To start off with, those inconveniences can actually be benefits rather than drawbacks. The fact that it forces object-oriented programming forces the first principle of Java. Because of it's nature, people writing code in Java will have more object-oriented code and therefore simpler, easier to read, and hopefully more familiar to code to people who are used to reading Java code. Java being objected-oriented and strongly typed also forces the user to use better programming practices and keeps them from committing some bad programming practices, and forces the user to create more scalable code.

To the second point, Java is robust and platform independent. The Java compiler only half compiles code which is given to the JVM (Java Virtual Machine) installed on a specific platform which understands the half compiled code and processes it for that platform. The secure part comes from the fact that it's strongly typed and that there's no access to the pointers. The JVM also makes Java architecture-neutral and portable, again because the half-compiled code is then executable on many processors.

High performance just means that Java programs run relatively fast. With a "just-in-time compiler" Java code can run in speeds that rival C++. The "just-in-time compiler" compiles methods into native machine code and the JVM calls the compiled code directly instead of interpreting it. This is also because it's a lower-level language relative to languages like Javascript or Python.

Interpreted just means that the Java compiler generates byte-code instead of machine code, and it has built-in constructs for multithreading, but it can still be synchronized. Java is considered dynamic because the bytecode is loaded at runtime, and anything happening at runtime is considered dynamic.

That was probably more information about Java than was strictly necessary, but suffice to say Java is versatile, fast, and promotes good practices.

#### How do I use Java?
Given the heavily object-oriented nature of Java, it makes sense to first go over it's class syntax. One particularity is that the file name must be the same as the main class name, and the main method of that class will run when the program is executed. Another restriction is that the constructor function is denoted by having the same name as the class name, and any function with the same name as the class is the constructor function. Generally the class with the main method won't have a constructor. The following is an example of a class with two integers for parameters:

``` Java
class SampleClass {
    int int1;
    int int2;

    public SampleClass(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }
}
```

and this is a class with a main method:

``` Java
class ClassMain {
    public static void main(String[] args) {
        SampleClass newClass = new SampleClass(1, 2);
        System.out.print(newClass.int1);
        // this code will run on execution
    }
}
```

When methods in the class are created, the data type being returned needs to be specified. So adding a method to the sample class that would return one of the held integers would look like this:

``` Java
class SampleClass {
    int int1;
    int int2;

    public SampleClass(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public int getInt1() {
        return this.int1;
    }
}
```

If the method doesn't return anything, use the keyword 'void':

```Java
public void incrementInt(int incrementVal) {
    this.int1 += incrementVal;
}
```

Variables can also be made private, in which case only that class can access the variables. For example, if the sample class looks like this:

```Java
class SampleClass {
    private int int1;
    private int int2;

    public SampleClass(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }
}
```

Then this will no longer work:

``` Java
class ClassMain {
    public static void main(String[] args) {
        SampleClass newClass = new SampleClass(1, 2);
        System.out.print(newClass.int1); // int1 can no longer be accessed because it's private
        // this code will run on execution
    }
}
```

Those are some of the basic differences from Python and Javascript. In this repository you can also find examples of recursive fibonacci and merge sort in Java.
