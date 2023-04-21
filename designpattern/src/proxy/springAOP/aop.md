## Spring AOP 
- How AOP work
  - Aspect Object Programming (AOP) is tool to modularize cross-cutting, such as logging
  security and transaction.
    - Aspect which are reusable modules containing advise (code) that can be appiled 
    to specific points in an application's execution, called join points.
    - Apply AOP -> create a proxy object for target class and add extra logics before/after calling it.
- Why need AOP
  - example: In Ecommerce, we wanna record all user action during browsing/searching. 
  but if we add log in every method it take so much duplicate work (logger.info)

### 常见用例
- @Cachable
- @RequestMapping
- @Transactional