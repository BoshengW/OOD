package bridge;

public class Demo {
    static {
        System.out.println("This is Demo");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();

        String a = "//dadlfbaflf.com/health";
        System.out.println(a.contains("/health"));

    }

    public int help(String str) {
        int cnt = 0;

        for (int i=0; i<str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
