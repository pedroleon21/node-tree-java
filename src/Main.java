import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Node node = null;
        long[] arr = generateRandomLongArray(100);
        for (long i : arr) {
            node = Node.insert(node, i);
        }
        node.inOrder();
        System.out.println("heigth left: " + node.getLeftHeigth() + " heigth rigth: " + node.getRigthHeigth() + " size: " + node.size());
        node = node.balancedTree();
        System.out.println();
        node.inOrder();
        System.out.println("heigth left: " + node.getLeftHeigth() + " heigth rigth: " + node.getRigthHeigth() + " size: " + node.size());
    }

    //CHAT GTP FUNCTION:
    public static long[] generateRandomLongArray(int size) {
        if (size > 9223372036854775807L) {
            throw new IllegalArgumentException("Cannot generate more than 9223372036854775807 unique longs.");
        }

        Random random = new Random();
        Set<Long> generatedNumbers = new HashSet<>();
        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            long randomLong = Math.abs(random.nextLong());
            while (generatedNumbers.contains(randomLong)) {
                randomLong = Math.abs(random.nextLong());
            }
            generatedNumbers.add(randomLong);
            result[i] = randomLong;
        }
        return result;
    }
}