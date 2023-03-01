package pair;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(76,89);
        Pair<String> pair2 = new Pair<>("hi", "hello");
        Pair<Integer> pair4 = new Pair<>(79, 89);
        Pair<Integer> pair5 = new Pair<>(79, 89);
        System.out.println("pair1 == pair4   "+PairUtil.equals(pair1,pair4));
        System.out.println("pair5 == pair4   "+PairUtil.equals(pair5,pair4));
        System.out.println("pair1 == pair2   "+PairUtil.equals(pair1,pair2));
        Pair<String> pair6 = PairUtil.copy(pair2);
        System.out.printf("copy pair2 to pair6.   pair6.first = %s, pair6.second = %s\n", pair6.first, pair6.second);
        PairUtil.swap(pair1);
        System.out.printf("swap values in pair1.  pair1.first = %s, pair1.second = %s\n", pair1.first, pair1.second);

    }
}
