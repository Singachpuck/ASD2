public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.add(16);
        tree.add(5);
        tree.add(18);
        tree.add(3);
        tree.add(9);
        tree.add(17);
        tree.add(20);
        tree.add(2);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(16);
        tree.add(7);

        tree.remove(2);
        tree.remove(4);
        tree.remove(16);
        tree.add(16);


        System.out.println(tree.contains(9));
        System.out.println(tree.sum());
    }
}
