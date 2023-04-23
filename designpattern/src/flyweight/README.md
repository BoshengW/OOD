## 享元模式 (共享单元) flyweight design pattern
- 主要用于减少创建对象数量，复用对象，节省内存，前提是享元对象是不可变对象
  - 当一个系统中存在大量重复对象的时候，如果这些重复的对象是不可变对象，
  我们就可以利用享元模式将对象设计成享元，在内存中只保留一份实例，供多处代码引用
  - 不可变对象指的是，一旦通过构造函数初始化完成之后，它的状态（对象的成员变量或者属性）就不会再被修改了。
  所以，不可变对象不能暴露任何 set() 等修改内部状态的方法

### 享元实现方法
- 创建缓存保留已创建类，通过工厂类保存已经缓存好的资源

### 常见享元模式
  - String的常量池
  - Integer的常量池
```java
Integer i1 = 56;
Integer i2 = 56;

Integer i3 = 129;
Integer i4 = 129;

System.out.println(i1 == i2); // true 56 可以直接在integer cache中直接找到
System.out.println(i3 == i4); // false Integer只缓存[-128, 127]的整数 129 > 范围所以会创建new integer()而不是直接在cache中查找

/* Integer 类底层实现逻辑 */
public static Integer valueOf(int i) { 
    if (i >= IntegerCache.low && i <= IntegerCache.high) 
        return IntegerCache.cache[i + (-IntegerCache.low)]; 
    return new Integer(i);
}
```
  - 数据库连接池
