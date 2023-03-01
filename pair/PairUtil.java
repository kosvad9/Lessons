package pair;

public class PairUtil {
    public static boolean equals(Pair p1, Pair p2){
        return (p1.first.equals(p2.first) && p1.second.equals(p2.second));
    }

    public static Pair copy(Pair p){
        return new Pair<>(p.first, p.second);
    }

    public static void swap(Pair p){
        Object temp = p.first;
        p.first = p.second;
        p.second = p.first;
    }
}
