## Chapter 1. Object Oriented Design
- Reference: https://time.geekbang.org/column/intro/100039001?tab=catalog
### 1. 面向过程编程

### 2. 面向对象编程
![Alt text](./Image/design-pattern.png)
- 四要素
  - 封装：保护数据或者某些方法访问权限
  - 继承：解决代码复用
  - 多态：子类代替父类 (定义一个父类类型，但是创建一个子类实例)
  - 抽象：隐藏方法的具体实现

#### 2.1 抽象继承 vs. 接口组合实现

### 贫血模型 vs. 充血模型
- 领域驱动设计 (Domain Driver Design)
- 贫血模型 (Anemic Domain Model)
  - 常见用例：MVC设计 - Controller - Service - Repository - Entity(数据业务分离)
  - 数据与业务分离
```java
////////// Controller+VO(View Object) //////////
public class UserController {
    private UserService userService; //通过构造函数或者IOC框架注入

    public UserVo getUserById(Long userId) {
        UserBo userBo = userService.getUserById(userId);
        UserVo userVo = [...convert userBo to userVo...];
        return userVo;
    }
}

public class UserVo {//省略其他属性、get/set/construct方法
    private Long id;
    private String name;
    private String cellphone;
}

////////// Service+BO(Business Object) //////////
public class UserService {
    private UserRepository userRepository; //通过构造函数或者IOC框架注入

    public UserBo getUserById(Long userId) {
        UserEntity userEntity = userRepository.getUserById(userId);
        UserBo userBo = [...convert userEntity to userBo...];
        return userBo;
    }
}

public class UserBo {//省略其他属性、get/set/construct方法
    private Long id;
    private String name;
    private String cellphone;
}

////////// Repository+Entity //////////
public class UserRepository {
    public UserEntity getUserById(Long userId) { //... }
    }

    public class UserEntity {//省略其他属性、get/set/construct方法
        private Long id;
        private String name;
        private String cellphone;
    }


```

- 充血模型 (Rich Domain Model)
  - 改进贫血模式 - MVC：Entity -> Domain