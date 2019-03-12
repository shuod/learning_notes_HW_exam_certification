# Head first JAVA

#### 1. How to compile and execute Java in windows.

There is some tricky part in compiling and excuting Java in windows.

There are mainly two categories in executing codes: the compilation way (C/C++, Fortran etc) or the interpretation way (Python, perl etc). Java, however, needs  both. The Java codes is first compiled into the binary code that only runs on Java virtual machine (Just-in-time compilation, or JIT) using a compiler, then you have to use a interpreter to execute the complied JIT codes. The first step is achieved using "javac somecode.java" and the second step uses "java somecode"(no extension name).

In windows, the tricky part is you have to setup the environment variable "CLASSPATH" to include the output path where JIT codes are stored after compilation. Although, by default, the JIT code is output to the current folder, you have to put "." (which represent "current path") into the "CLASSPATH". Without doing so, even if you put the complete path to the JIT code, the interpreter "java" will still claim that it couldn't find the class file ("Error: Could not find or load main class somecoe.class").

There are other two environment variables to setup in the powershell (run with the administrator privilege, of course):
```powershell
//name: JAVA_HOME 
//value: E:\Program Files\Java\jdk1.8.0_202 
[Environment]::SetEnvironmentVariable("JAVA_HOME", "E:\Program Files\Java\jdk1.8.0_202","User") 

//There is a "." at the very front
//name: CLASSPATH
//value: .;%JAVA_HOME%\lib
[Environment]::SetEnvironmentVariable("CLASSPATH", "$($Env:JAVA_HOME)\bin", "User")

//Path
[Environment]::SetEnvironmentVariable("PATH", $Env:Path + ";$($Env:JAVA_HOME)\bin", "User")

```

#### 2. Java SE, JRE, SDK and others

Unlike other languages, Java seems to have particularly more encapsulate packages:

https://www.quora.com/What-is-the-difference-between-Java-SDK-JRE-JVM-Java-SE-Runtime-and-J2SE

https://stackoverflow.com/questions/250517/java-se-6-vs-jre-1-6-vs-jdk-1-6-what-do-these-mean



For entry level learners, download the Java SE (standard edition)from the oracle website is enough:

https://www.oracle.com/technetwork/java/javase/downloads/index.html

This includes Java JVM, JRE and SDK.



Other packages like JEE/J2EE are for enterprise edition. In Java11, this will not be free. J2ME is for "Mobile edition".









## chp1 Breaking the surface

#### 1.  Some code in java to have a first-hand impression:

```java
int size=27;

String name = "Fido";

Dog myDog = new Dog(name, size);

int[] numList={2,3,4,5}

System.out.print("Hello");

System.out.print("Dog:" + name);

try{

	readTheFile("myFile.txt");

}

catch (FileNotFoundException ex){

	System.out.print("File not found.");

}

```

![](..\chp1\HFJ_chp1_1.png)

- Organization of JAVA codes:

  A source file contains several class, each go within a pair of curly braces;

  A class has one or more method, each go within a pair of curly braces and must be declared inside a class;

  Statements can be put in a method, tell the computer how to do certain instructions;

- Internal Architecture of JVM (JAVA virtual machine): 

  unlike C/C++, where the complied binary codes are executed in real machine, JAVA complies source codes into Just-In-TIme (JIT) code and excutes them in JAVA virtual machine. This unique feature enable it cross-platform. Virtual machine has the following architecture:

  - Classloader: A subsystem of JVM that is used to load class files;
  - Memory Areas or Method Areas: stores per-class structures, such as the runtime constant pool, field and method data, the code for methods;
  - Execution Engine
    - Class Areas
    - Heap: it is the runtime data area in which objects are allocated;
    - Stack: It stores frames. Frames are created each time a method is invoded, and destroyed when its method invocation completes. It holds local variables and partial results, and plays a part in method invocation.
    - Program Counter Register: It contains the address of the Java virtual machine instruction currently being executed.
    - Native Method Stack: It contains all the native methods used in the application
  - Native Method Interface
  - Java Native Libraries
- Comments: sinlge line uses "//" and multiple lines use "/* ... */"

![](..\chp1\HFJ_chp1_2.png)

#### 2 Identifiers

- Name of a constant is all Capitalized: GAME_COLOR = "RED"
- Name of a variable: starts with alphabet or _ or $, and cannot start with numbers; Case sensitive and no maximum length;  examples: user_name, _sys_var1, $_change;
- Name of a class: the first name is capitalized, and each of the word in the name is capitalized. 
- Name of a method: the first name is small, and each of the word is capitalized.
- Name of the source code file: the name of the source code file must be the same as the class in it.
- The declaration of main is: ''public static void main(String []args)"

#### 3. Variable
- a piece of memory that can contain a data value:

  - local variable: inside the method;
  - instance variable: inside the class but outside the method;
  - static variable: other than local;

- Data type: 

  - primitive data types: JAVA built-in types

    - 8 primitive data types and default size:

      ![](..\chp1\HFJ_chp1_3.png)

      | Data Type                    | Default Value | Default Size     |
      | ---------------------------- | ------------- | ---------------- |
      | Boolean(true, false)         | false         | 1 byte or 8 bits |
      | Byte(-128~127, 2^7)          | 0             | 1 byte           |
      | Char(\u0000~\uffff, 0~65535) | '\u0000'      | 2 byte           |
      | Short(-32768~32767,2^15)     | 0             | 2 byte           |
      | Int(-2147483648, 2^31)       | 0             | 4 byte           |
      | Long(2^63)                   | 0L            | 8 byte           |
      | Float                        | 0.0f          | 4 byte           |
      | Double                       | 0.0d          | 8 byte           |

```java
public class PrimitiveTypeTest {  
    public static void main(String[] args) {  
        // byte  
        System.out.println("Byte type：" + Byte.SIZE);  
        System.out.println("Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
        }
    }
      
```
  - non primitive data types: derived from the primitive ones and store group of values





