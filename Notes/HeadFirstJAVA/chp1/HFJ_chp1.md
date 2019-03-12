# Head first JAVA chp 1

#### 1.  Some difference with other language (C/C++/Fortran/Python)

- Each source code file is a class, and the name of the class must be  the same as the file name.
- Two-step compilation-interpretation: Source cods are first complied into JIT binary code and then executed by an interpreter.
- In windows, setup CLASSPATH to include the current folder ("."), even if full path of the code is provided.


#### 2. How to compile and execute Java in command line in windows.

There is some tricky part in compiling and excuting Java in windows.

There are mainly two categories in executing codes: the compilation way (C/C++, Fortran etc) or the interpretation way (Python, perl etc). Java, however, needs  both. The Java codes (\*.java) is first compiled into the binary code (*.class) that only runs on Java virtual machine (Just-in-time compilation, or JIT) using a compiler, then you have to use a interpreter to execute the complied JIT codes. The first step is achieved using "javac somecode.java" and the second step uses "java somecode"(no extension name).

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

#### 3. Installation of Eclipse in windows

There is also some tricky part in using Eclipse in windows. 

- First, download the 64-bit window version from:

https://www.eclipse.org/downloads/packages/release/neon/3

Versions for Java EE or Java developer are both alright. 

- Second, extract the archive to the folder that its name doesn't have any special character.

- Third, modify the eclipse.ini to add

  ```
  -vm
  E:\Program Files\Java\jdk1.8.0_202\bin\javaw.exe
  ```

  For the current version, without step three, you will have the error: "Java was Started but Returned Exit Code=13". Although there can be many reasons for this error, the fact that the official package lacks of the path to the Java virtual machine (appointed by "-vm" in the "*.ini") can cause this error.

  

For other possible reasons for this error, see:

https://ashout.com/fix-java-started-returned-exit-code13-eclipse/

#### 4. For features different from C++

Clearly, C++ and Java are the two mainstream language that used the most in the production environment. Although they both language satisfying Object Oriented Principles (OOP), there are some subtle difference. Any OOP must satisfying:

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism

C++ is partially OOP, because:

- According to OOP, no main() method/ should be exist without the object. In C++, main() can be independent and doesn't need any class;

- C++ provides "Friends" which violate "Encapsulation";

- In C++, the built-in data types, such as int, float, are not object. But in Java, everything is object. 

- According to OOP, one object should have only one hierarchical parent reference. But in C++, multiple inheritance can exist.

- In Java any function must be written inside the class, but in C++, function can exist outside or even a whole program can run without having a class.

  (https://www.waytoeasylearn.com/2016/04/java-language-basics.html)

####  4. Java SE, JRE, SDK and others

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

  - primitive/non-primitive/reference data types: JAVA built-in types

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
- - 
    - non-primitive data types: derived from the primitive ones and store group of values
    - reference data types: Declaration of objects or array. Also, Integer, String etc are reference type. The default value of reference data is "null" for example:

  ```java
  Class Student(){
      some code;
  }
  Student John = new Student();
  ```

  John is then a reference variable. In C/C++, there are pointer type variables. They are essentially the similar idea as the reference variable. They contain the starting address of the variable in the memory block.

- Instance Variables/Static Variables/Local Variables

  The "{}" is an important label. It divides the program into different sections or "scope". Since a Java program is a class, within a class, there are some standard "{}" that must be there:

  ```java
  public class Student{
  
      int id;
      String name;
      String major;
      
      public StudentInfor(int id, String name, String major){
          super();
          this.id=id;
          this.name=name;
          this.major=major;
      }
      
  }
  ```

  there are two "{}" that separate the whole code into three scopes:

  1. inside StudentInfor()  or method area

  2. outside StudentInfor() but inside Student or instance area (includes the method area)

  3. outside Student or static area (doesn't include the method area), this also include other class, if the program contains more than one class

  

  - Local Variables: Local variables are defined inside the method part (the scope No.1 above ). Java designs this type of variable to have the following features:

    - Local variables are created when methods are executed, destroyed after methods are executed;
    - Decorators can not be used on local variables;
    - Local variables are only accessed inside the scope of its method();
    - Local variables are allocated in the stack (a special region in the memory);
    - Local variables don't have default values, they must be manually initiated or error will be raised.
    - Only "final" keyword can be used.

  - Instance Variables: Instance variables are defined inside the class but outside the method part (the scope No.2 above). Their values can be varied from object to object. Java designs this type of variable to have the following features:

    - The value of the variable are given after the creation of the object;
    - For every object, a separate memory copy will be created, meaning if you change their values in one object, their values in another object won't be affected. 
    - Instance variable are created when an object is created, destroyed after the object is destroyed;
    - Outside the class, the values of instance variable can be accessed through the function/statement in the method() part. 
    - Decorators can be used on this type of variable;
    - Generally, they could be set to private and sub-class can access them through decorators;
    - Instance variable has default values and we don't have to initialize them explicitly: numeric type is "0", boolen is "false", reference is "null". Values can be given when defined them or in the constructor method;
    - Instance variable are allocated in the heap as the part of the Object;

  - Static Variables: Static variables are defined inside one class but outside its method part. The value of them are not changed from object to object, or they stay the same for another class. They are declared with the key word "Static":

    - Using "Static" key word to declare;
    - Only one copy of the variable will be created, not matter how many objects will used it. This means, if you changed the value, every object will receive the "update".
    - They are created when the program starts, and destroyed when program ends.
    - They have default values the same as the instance variables;
    - They can be accessed by ClassName.VariableName;

    

https://www.waytoeasylearn.com/2016/05/types-of-variables.html

Reference

1. Head first Java, by Kathy Sierra & Bert Bates, Oreilly, 2nd Edition, 2005
2. How to fix exit code 13 error, https://ashout.com/fix-java-started-returned-exit-code13-eclipse/
3. Java basics, https://www.waytoeasylearn.com/2016/04/java-language-basics.html
4. Java video tutorial, https://www.youtube.com/watch?v=TBWX97e1E9g&list=PLE7E8B7F4856C9B19
5. Identifiers and data types, https://www.waytoeasylearn.com/2016/04/java-language-fundamentals.html
6. Types of variables, https://www.waytoeasylearn.com/2016/05/types-of-variables.html