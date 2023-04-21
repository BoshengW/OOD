## Proxy Pattern
- 定义：代理类包含所有委托类的公有函数(无法代理私有方法)，
并将在委托类基础上加入新逻辑

### 常见应用
- 业务系统的非功能性需求开发：Spring AOP
- RPC框架 (远程代理)
- 缓存

### Static Proxy (静态代理)
- 可以通过 继承/接口实现-聚合 这两种方式实现静态代理
- 缺点：代理类中需要实现基类中所有公有函数，如果未来进行修改需要同时修改两个类
### Dynamic Proxy (动态代理) - JDK代理
- JDK代理的基类必须是通过接口实现的实现类，动态代理无需实现基类函数，扩展性更好。
- 常见用例：spring AOP，Spring 依赖注入解决循环依赖
- 主要实现方式：
  1. JDK 反射类 Proxy.newProxyInstance - 创建代理对象
  2. InvocationHandler中invoke方法通过反射调用代理类的方法

### cglib代理 
- Cglib代理的基类可以是非接口实现的普通类
- 常见用例: Spring AOP，Spring 依赖注入解决循环依赖

## Reference
- https://segmentfault.com/a/1190000040407024
- 
