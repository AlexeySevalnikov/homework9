public class MainCollectionMethod {
    public static void main(final String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
//        myCollection.add(1);
//        myCollection.add(2);
//        myCollection.add(4);
//        myCollection.add(5);
//        myCollection.add(10);
//        myCollection.add(6);


        System.out.print("\nBefore: ");
        for (Integer i : myCollection) {
            System.out.print(i + " ");
        }
        System.out.println();
        Object result = null;

//        Integer[] arr = new  Integer[6];
//        result = myCollection.toArray(arr);

//        result = myCollection.toArray();
//        myCollection.clear();
//        result = myCollection.contains(5);
//        result = myCollection.remove(2);
//        result = myCollection.containsAll(Arrays.asList(2, 10));
//        result = myCollection.addAll(Arrays.asList(15, 29, 30));
//        result = myCollection.removeAll(Arrays.asList(2, 6, 10, 1, 4, 5));

//        result = myCollection.retainAll(Arrays.asList(2, 6, 10, 1, 4, 5));
        System.out.println("Result:" + result);

        System.out.print("After: ");
        for (Integer j : myCollection) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }
}


