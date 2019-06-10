/**
 * create by Canon4G 2019-06-10
 **/
public class Hanoi {

    public static void main(String[] args) {
        hanoi(3, "A", "B", "C");
    }

    /**
     * 汉诺塔
     * @param num       圆盘数量
     * @param a         第一个柱子
     * @param b         第二个柱子
     * @param c         第三个柱子
     */
    private static void hanoi(int num, String a, String b, String c) {
        if (1 == num) {
            System.out.println(a + "---------->" + c);
        } else {
            hanoi(num - 1, a, c, b);
            System.out.println(a + "---------->" + c);
            hanoi(num - 1, b, a, c);
        }
    }
}
