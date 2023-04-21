package builder;

/**
 * Description: create a ConstructorArg class which can
 * 1. if isRef==true, arg is String refBeanId and skip setting type
 * 2. if isRef==false, arg, type need to set
 * */
public class ConstructorArgBuilder {
    private boolean isRef;
    private Class type;
    private Object arg;

    private ConstructorArgBuilder(Builder builder) {
        this.arg = builder.arg;
        this.type = builder.type;
    }

    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArgBuilder build() {
            if (isRef) {
                if (!(arg instanceof String)) {
                    throw new IllegalArgumentException("String arg ");
                }

                if (type != null) {
                    throw new IllegalArgumentException("no type");
                }
            } else {
                if (type == null || arg == null) {
                    throw new IllegalArgumentException("both should be set");
                }
            }

            return new ConstructorArgBuilder(this);
        }

        public Builder setArg(Object arg) {
            this.arg = arg;

            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setRef(boolean isRef) {
            this.isRef = isRef;
            return this;
        }

    }

    public static void main(String[] args) {
        /* test isRef true */
        ConstructorArgBuilder obj1 = new ConstructorArgBuilder.Builder().setRef(true).setArg("12").setType(null).build();

        /* test isRef false */
        ConstructorArgBuilder obj2 = new ConstructorArgBuilder.Builder().setRef(false).setArg(12).setType(Integer.class).build();


    }
}
