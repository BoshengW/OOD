### MVC Design

#### 常见贫血模型
- Controller + VO (暴露给用户访问)
  - VO - (将BO转化成View Object) 
- Repository + Entity (数据访问)
  - Entity - (原始数据) - 数据业务分离
- Service + BO (业务逻辑)
  - BO - (将Entity转化成Biz 对象) - 数据业务分离
  - BizService - (业务函数)


#### 充血模型DDD - 领域模型
- 充血模型又称领域模型
  - domain类来封装数据和业务逻辑
  - Service类只封装事务