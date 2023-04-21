package builder;

public class DemoBuilder {
    private int val1;
    private int val2;

    /* make it private to avoid directly call from outside*/
    private DemoBuilder(Builder builder) {
        this.val1 = builder.val1;
        this.val2 = builder.val2;
    }

    public void printOut() {
        System.out.println(this.val1 + this.val2);
    }

    public static class Builder {

        public DemoBuilder build() {
            if (val1 < 0) {
                throw new IllegalArgumentException("error");
            }

            if (val2 < 0) {
                throw new IllegalArgumentException("error");
            }

            return new DemoBuilder(this);
        }
        /* in builder you need to add all params which are duplicate with raw class */
        private int val1;
        private int val2;

        public Builder setVal1(int val) {
            this.val1 = val;
            return this;
        }

        public Builder setVal2(int val) {
            this.val2 = val;
            return this;
        }


    }

    public static void main(String[] args) {
        DemoBuilder obj = new DemoBuilder.Builder()
                                    .setVal1(2)
                                    .setVal2(3)
                                    .build();

        obj.printOut();
    }
}
