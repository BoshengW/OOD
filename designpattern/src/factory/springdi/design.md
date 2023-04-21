## Dependency injection Container Design
- Config file parser
- Bean Factory (Hugh Factory)

### 依赖注入-Spring循环依赖问题
#### 为什么
- spring IOC的底层实现导致循环依赖的出现，由于底层使用递归来实例化依赖类
所以如果有循环依赖，递归就会进入死循环直到OOM.

#### Spring解决方法