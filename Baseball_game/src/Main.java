import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> targetNum = new HashSet();
        int rNum;
        while (targetNum.size() < 3) {
            rNum = (int) (Math.random() * 9 + 1);
            targetNum.add(rNum);
        }
    }
}