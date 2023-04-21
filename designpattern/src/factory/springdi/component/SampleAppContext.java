package factory.springdi.component;

import factory.springdi.beandef.BeanDefinition;

import java.util.List;

public class SampleAppContext implements AppContext {

    private BeanFactory beanFactory;

    private BeanConfigParser beanConfigParser;

    public SampleAppContext(String beanXML) {
        beanConfigParser = new BeanConfigParser();
        beanFactory = new BeanFactory();

        List<BeanDefinition> beansDef = beanConfigParser.parseConfig(beanXML);
        beanFactory.load(beansDef);
    }

    @Override
    public Object getBean(String className) {
        return null;
    }
}
