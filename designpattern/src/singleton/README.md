# Singleton
## Definition
一个类只会有一个实例， 且在同一个进程内唯一，进程间不唯一，要实现进程间唯一需要设计集群单例(Cluster Singleton)
- 集群单例设计：需要将单例序列化到一个外部共享空间，所有进程反序列化同一个单例对象。

## Singleton Examples
1. handle sharing resource concurrency issue
    - 共享资源是竞争资源，多线程写入时会有数据覆盖隐患
2. Global ID Generator

## how to define singleton class
- Notice:
1. private constructor, cannot create instance externally
2. make public get instance method to return singleton object
3. Lazy loading or not

- Multiple ways to define singleton class
1. Eager loading - cannot delay init, but can use in concurrent
2. Lazy loading - can delay init, only allow single thread. since getInstance method have a sync lock
3. Enum class - Thread safe
4. Static Internal class - Thread safe

## 单例设计模式缺点
1. 违背OOP原则，牺牲了继承和多态来实现全局类
2. 单例类不好进行单元测试，改进就是将单例类作为依赖注入的方式注入依赖类中

## 单例设计扩展
1. 线程内唯一的单例模式 - thread ID Map
2. 进程内唯一的单例模式 - 将单例类序列化到共享外部存储
3. 集群单例模式
4. 多例模式 - 利用ID map进行储存

### Reference
- https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples