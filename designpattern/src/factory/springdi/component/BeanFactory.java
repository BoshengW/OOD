package factory.springdi.component;

import factory.springdi.beandef.BeanDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private Map<String, Object> beans = new ConcurrentHashMap<>();

    public void load(List<BeanDefinition> beanDefs)  {
        for (BeanDefinition bean : beanDefs) {
            beans.put(bean.getClass().getName(), bean.getObject());
        }
    }

}
