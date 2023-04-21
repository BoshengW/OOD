package factory.springdi.beandef;

public class BeanDefinition {

    private Object instance;

    public BeanDefinition(Object bean) {
        instance = bean;
    }


    public Object getObject() {
        return this.instance;
    }
}
