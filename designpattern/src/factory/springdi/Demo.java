package factory.springdi;

import factory.springdi.component.SampleDep;

import java.lang.reflect.InvocationTargetException;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /* load beans.xml configuration file */

        /* Bean Factory init all registered beans */

        /* use bean classes */

        Class beanClass = Class.forName(SampleDep.class.getCanonicalName());
        Object bean = beanClass.newInstance();
        SampleDep res = (SampleDep) bean;
        res.test();

    }
}
