import java.util.Arrays;
import java.util.Iterator;

public class MainCollectionMethod {
    public static void main(final String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(0);
        myCollection.add(2);
        myCollection.add(null);
        myCollection.add(5);
        myCollection.add(2);


        System.out.print("\nBefore: ");
        for (Integer i : myCollection) {
            System.out.print(i + " ");
        }
        System.out.println();
        Object result = null;

//        result = Arrays.toString(myCollection.toArray(new Integer[]{0, 0, 0, 0, 0, 0, 0}));

//        result = myCollection.toArray();
//        myCollection.clear();
//        result = myCollection.contains(null);
//        result = myCollection.remove(2);
//        result = myCollection.containsAll(myCollection);
//        result = myCollection.addAll(Arrays.asList(15, 29, 30));
//        result = myCollection.removeAll(Arrays.asList(2, 6, 10, 1, 4, 5));

//        result = myCollection.retainAll(Arrays.asList(null, 5, 2, 0));
        System.out.println("Result:" + result);

        System.out.print("After: ");
        for (Integer j : myCollection) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }
}


