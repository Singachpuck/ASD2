public class Main {
    public static void main(String []args){
        //arrayList();
        //linkedList();
        //binarySearchTree();
        //avlTree();
        rbTree();
    }

    public static void arrayList() {
        System.out.println("ArrayList Test");
        long start, end;

        for (int i = 10000; i <= 100000; i += 10000) {
            MyArrayList myArrayList = new MyArrayList();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                myArrayList.addFirst(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                myArrayList.indexOf(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j = 0; j < arr.length; j++) {
                myArrayList.removeFirst();
            }
            end = System.nanoTime();
            System.out.printf("Delete time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n\n", i);
        }

        for (int i = 200000; i <= 500000; i += 100000) {
            MyArrayList myArrayList = new MyArrayList();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                myArrayList.addFirst(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                myArrayList.indexOf(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j = 0; j < arr.length; j++) {
                myArrayList.removeFirst();
            }
            end = System.nanoTime();
            System.out.printf("Delete time for arraylist, %d elements- " + (end - start)/arr.length + " ns\n\n", i);
        }

    }

    public static void linkedList() {
        System.out.println("LinkedList Test");
        long start, end;

        for (int i = 10000; i <= 100000; i += 10000) {
            LinkedList linkedList = new LinkedList();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                linkedList.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for linked list, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                linkedList.indexOf(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for linked list, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j = 0; j < arr.length; j++) {
                linkedList.removeFirst();
            }
            end = System.nanoTime();
            System.out.printf("Delete time for linked list, %d elements- " + (end - start)/arr.length + " ns\n\n", i);

            linkedList = null;
        }

        for (int i = 200000; i <= 500000; i += 100000) {
            LinkedList linkedList = new LinkedList();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                linkedList.addFirst(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for linked list, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                linkedList.indexOf(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for linked list, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j = 0; j < arr.length; j++) {
                linkedList.removeFirst();
            }
            end = System.nanoTime();
            System.out.printf("Delete time for linked list, %d elements- " + (end - start)/arr.length + " ns\n\n", i);
        }

    }


    public static void binarySearchTree() {
        System.out.println("Binary Search Tree Test");
        long start, end;

        for (int i = 100000; i <= 1000000; i += 100000) {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for BST, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for BST, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for BST, %d elements- " + (end - start)/arr.length + " ns\n\n", i);

            /*start = System.nanoTime();
            binarySearchTree.getInorderSuccessor(binarySearchTree.root);
            end = System.nanoTime();
            System.out.printf("Sort print time for BST, %d elements- " + (end - start)/arr.length + " ns\n\n", i);*/

            binarySearchTree = null;
        }

        for (int i = 2000000; i <= 10000000; i += 1000000) {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for BST, %d elements- " + (end - start)/arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for BST, %d elements- " + (end - start)/arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j : arr) {
                binarySearchTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for BST, %d elements- " + (end - start)/arr.length + " ns\n\n", i);

            /*start = System.nanoTime();
            binarySearchTree.getInorderSuccessor(binarySearchTree.root);
            end = System.nanoTime();
            System.out.printf("Sort print time for BST, %d elements- " + (end - start)/arr.length + " ns\n\n", i);*/

            binarySearchTree = null;
        }
    }

    public static void avlTree() {
        System.out.println("AVL Tree Test");
        long start, end;

        for (int i = 100000; i <= 1000000; i += 100000) {
            AvlTree avlTree = new AvlTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                avlTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                avlTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j : arr) {
                avlTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);

            avlTree = null;
        }

        for (int i = 2000000; i <= 10000000; i += 1000000) {
            AvlTree avlTree = new AvlTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                avlTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                avlTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);


            start = System.nanoTime();
            for (int j : arr) {
                avlTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for AVL Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);

            avlTree = null;
        }
    }

    public static void rbTree() {
        System.out.println("RB Tree Test");
        long start, end;

        for (int i = 100000; i <= 1000000; i += 100000) {
            RedBlackTree rbTree = new RedBlackTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                rbTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                rbTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);


            /*start = System.nanoTime();
            for (int j : arr) {
                rbTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);*/

            /*start = System.nanoTime();
            rbTree.inOrder(rbTree.root);
            end = System.nanoTime();
            System.out.printf("Sort print time for RB Tree, %d elements- " + (end - start)/arr.length + " ns\n\n", i);*/

            rbTree = null;
        }

        for (int i = 2000000; i <= 10000000; i += 1000000) {
            RedBlackTree rbTree = new RedBlackTree();
            int[] arr = new int[i];
            Util.fillTestArray(arr);

            start = System.nanoTime();
            for (int j : arr) {
                rbTree.add(j);
            }

            end = System.nanoTime();
            System.out.printf("Insert time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n", i);

            start = System.nanoTime();
            for (int j : arr) {
                rbTree.contains(j);
            }
            end = System.nanoTime();
            System.out.printf("Search time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);


            /*start = System.nanoTime();
            for (int j : arr) {
                rbTree.remove(j);
            }
            end = System.nanoTime();
            System.out.printf("Delete time for RB Tree, %d elements- " + (end - start) / arr.length + " ns\n\n", i);*/

            /*start = System.nanoTime();
            rbTree.inOrder(rbTree.root);
            end = System.nanoTime();
            System.out.printf("Sort print time for RB Tree, %d elements- " + (end - start)/arr.length + " ns\n\n", i);*/

            rbTree = null;
        }


    }
}
