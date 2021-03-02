public class OverProblem {

    public static void main(String[] args) {
        // 说一下byte a = 127， byte b = 127; a+=b 和a = a+b的区别分别会出现什么问题。
        byte a = 127;
        byte b = 127;
        a+=b;
        System.out.println(a);
        int i = a + b;
        //System.out.println(a);
    }
}
