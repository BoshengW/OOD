## Builder Pattern
### why need builder pattern
- when there are too many input params in constructor
  - add setter() to reduce param input if this param don't need to do some
  validation or extra logics inside constructor
  - if not, then need to use **Builder** pattern

### How to create a Builder pattern
1. private DEMO.class constructor(Builder builder) for avoiding external call, and read param from Builder class.
2. public static internal Builder class
3. public build() to call DEMO.class constructor with validation and extra logics
4. public Builder setter methods for param setting
