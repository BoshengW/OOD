## Decorator 装饰器
- 典型用例：Java InputStream
  - InputStream子类(FileInputStream, DataInputStream, ...)数量众多，如果每一个子类为了扩展一个新功能都
  采用继承实现的派生类，会导致继承结构过于复杂(树状结构)
    - 假设 InputStream存在3个子类(file, filter, byteArray)，各个子类又扩展出2个新功能(buffered, dataInput)
    如果直接继承创建派生类则需要创建 6 个单一功能派生类 + 3个组合功能派生类。
    - 但是如果使用装饰器模式，我们只需要创建2个功能类作为装饰器就可以为3个子类添加新功能。
      - 通俗理解每一个装饰器即是一个加工坊，将实例注入装饰器后构造出带有新功能的派生类
    ```java
    InputStream in = new FileInputStream("/user/wangzheng/test.txt");
    InputStream bin = new BufferedInputStream(in);
    DataInputStream din = new DataInputStream(bin);
    int data = din.readInt();
    ```
- 装饰器代码结构
```java
public interface IA { 
    void f();
}

public class A impelements IA { 
    public void f() {
      System.out.println("test");
    }
}

public class ADecorator implements IA { 
    private IA a; 
    public AADecorator(IA a) { 
        this.a = a; 
    } 
    public void f() {
        // 新的增强功能
        a.f(); 
        // 新的增强功能 
    }
}
```
- 装饰器实例 - Java IO Stream
```java
/**
 * Java IO 使用Buffered - FileInputStream 是将FileInputStream注入进BufferedInputStream - 装饰器模式
 * 而非继承FileInputStream 实现一个新类 BufferedFileInputStream
 * */

/* base class */
public class InputStream {
  public InputStream() {

  }
}

/* child class for InputStream */
public class FileInputStream extends InputStream {
  InputStream io;

  public FileInputStream(String filename) {
    io = io.readFile(filename); // load file for IO instance
  }

}

/* decorator 1 - DataInputStream */
public class DataInputStream extends InputStream {
  InputStream io;

  public DataInputStream(InputStream io) {
    this.io = io;
  }

  public void dataInputFunc() {
    System.out.println("This is Data Input Func");
  }
}

/* decorator 2 - BufferedInputStream */
public class BufferedInputStream extends InputStream {
  InputStream io;

  public BufferedInputStream(InputStream io) {
    this.io = io;
  }

  public void bufferedFunc() {
    System.out.println("This is Buffered func");
  }
}

public class MainDemo {
  public static void main(String[] args) {
    FileInputStream in = new FileInputStream("/user/ben/test.txt");
    BufferedInputStream bin = new BufferedInputStream(in);
    DataInputStream dbin = new DataInputStream(bin);
    
  }
}
```

- 装饰器模式作用是对类功能增强
  - 与代理模式不同：代理模式通常是为了增加与原始类不相关的功能如 监控，日志记录等。模式之间的意图不同，但是代码实现相似
  - 如何选择使用代理还是装饰器
    - 代理模式 - 展现封装性，开发者无需关注代理功能实现，更加透明，能做到新增功能隐藏性。
    - 装饰器模式 - 展现多态性，在平行结构上扩展各个新功能，并串联在一起，避免继承爆炸。

