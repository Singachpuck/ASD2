import java.util.Iterator;

public class BinarySearchTree<T extends Integer> implements Iterable<T> {
    protected Node<T> root = new Node<>(null, Directions.ROOT);
    protected int size = 0;

    protected Node<T> getUncle(Node<T> node) {
        if (node == null || node.equals(root) || node.parent.equals(root))
            throw new IllegalArgumentException("Can't get uncle");
        else {
            return getSibling(node.parent);
        }
    }

    protected Node<T> getSibling(Node<T> node) {
        if (root.equals(node) || node == null) throw new IllegalArgumentException("Can't get sibling");

        return node.child == Directions.LEFT ? node.parent.right : node.parent.left;
    }

    void add(T value) {
        if (size == 0) {
            root.setValue(value);
            root.color = Colors.BLACK;
        } else {
            Node<T> current = root;
            Node<T> newNode = new Node<>(value, Directions.ROOT);

            while (true) {
                Integer nodeValue = current.getValue();

                if ((Integer) value < nodeValue) {
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.parent = current;
                        newNode.child = Directions.LEFT;
                        break;
                    } else
                        current = current.left;
                } else if ((Integer) value > nodeValue) {
                    if (current.right == null) {
                        current.right = newNode;
                        newNode.parent = current;
                        newNode.child = Directions.RIGHT;
                        break;
                    } else
                        current = current.right;
                } else {
                    return;
                }
            }

            restoreBalanceAfterAdd(newNode);
        }

        size++;
    }

    protected void restoreBalanceAfterAdd(Node<T> node) {
    }

    void remove(T value) {
        if (size == 0) throw new IndexOutOfBoundsException("Can't remove from an empty tree");

        if (size == 1) {
            if (value.equals(root.getValue())) root.setValue(null);
            else return;
        } else {
            Node<T> current = root;

            while (true) {
                Integer nodeValue = current.getValue();

                if (value.equals(nodeValue)) {
                    handleRemove(current);
                    break;
                } else if ((Integer) value < nodeValue) {
                    if (current.left == null)
                        return;
                    else
                        current = current.left;
                } else if ((Integer) value > nodeValue) {
                    if (current.right == null)
                        return;
                    else
                        current = current.right;
                }
            }
        }

        size--;
    }

    void handleRemove(Node<T> node) {
        if (node == null) throw new NullPointerException();

        if (node.left == null && node.right == null) {
            if (node.child == Directions.LEFT)
                node.parent.left = null;
            else
                node.parent.right = null;
        } else if (node.left != null && node.right == null) {
            if (!root.equals(node)) {
                if (node.child == Directions.LEFT) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                    node.left.child = Directions.RIGHT;
                }

                node.left.parent = node.parent;
            } else {
                root = node.left;
                node.left.parent = node.parent;
            }
        } else if (node.left == null && node.right != null) {
            if (!root.equals(node)) {
                if (node.child == Directions.LEFT) {
                    node.parent.left = node.right;
                    node.right.child = Directions.LEFT;
                } else {
                    node.parent.right = node.right;
                }

                node.right.parent = node.parent;
            } else {
                root = node.right;
                node.right.parent = node.parent;
            }
        } else {
            Node<T> iSuccessor = getInorderSuccessor(node);

            node.setValue(iSuccessor.getValue());

            handleRemove(iSuccessor);
        }
    }

    protected Node<T> getInorderSuccessor(Node<T> node) {
        Node<T> iSuccessor = node.right;

        if (iSuccessor == null) throw new IllegalArgumentException("Node doesn't have inorder successor");

        while (iSuccessor.left != null) {
            iSuccessor = iSuccessor.left;
        }

        return iSuccessor;
    }

    public boolean contains(Object o) {
        if (size == 0 || !(o instanceof Integer)) return false;

        Node<T> current = root;

        while (true) {
            Integer iValue = current.getValue();

            if (iValue.equals(o))
                return true;
            else if (iValue < (Integer) o) {
                if (current.right == null)
                    break;
                else
                    current = current.right;
            } else if (iValue > (Integer) o) {
                if (current.left == null)
                    break;
                else
                    current = current.left;
            }
        }

        return false;
    }

    protected void rotateTree(Node<T> node, Directions direction) {
        if (direction == Directions.RIGHT) {
            if (node.left == null) return;

            Node<T> newRoot = node.left;
            newRoot.parent = node.parent;

            if (node.equals(root)) {
                newRoot.child = Directions.ROOT;
                root = newRoot;
            } else {
                if (node.child == Directions.LEFT) {
                    node.parent.left = newRoot;
                } else {
                    node.parent.right = newRoot;
                }

                newRoot.child = node.child;
            }

            node.child = Directions.RIGHT;
            node.left = newRoot.right;
            if (newRoot.right != null) {
                newRoot.right.parent = node;
                newRoot.right.child = Directions.LEFT;
            }
            newRoot.right = node;
            node.parent = newRoot;
        } else if (direction == Directions.LEFT) {
            if (node.right == null) return;

            Node<T> newRoot = node.right;
            newRoot.parent = node.parent;

            if (node.equals(root)) {
                newRoot.child = Directions.ROOT;
                root = newRoot;
            } else {
                if (node.child == Directions.LEFT) {
                    node.parent.left = newRoot;
                } else {
                    node.parent.right = newRoot;
                }

                newRoot.child = node.child;
            }

            node.child = Directions.LEFT;
            node.right = newRoot.left;
            if (newRoot.left != null) {
                newRoot.left.parent = node;
                newRoot.left.child = Directions.RIGHT;
            }
            newRoot.left = node;
            node.parent = newRoot;
        } else
            throw new IllegalArgumentException("Illegal direction");
    }

    long sum() {
        return getSum(root);
    }

    private long getSum(Node<T> currentNode) {
        if (currentNode == null) return 0;

        return getSum(currentNode.left) + (Integer) currentNode.getValue() + getSum(currentNode.right);
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private Node<T> current = root;
            private int processed = 0;

            private boolean hn;

            {
                hn = size != 0;
            }

            @Override
            public boolean hasNext() {
                return hn;
            }

            @Override
            public T next() {
                return getItem().getValue();
            }

            private BinarySearchTree.Node<T> getItem() {
                if (current.left != null && !current.left.processed) {
                    current = current.left;

                    return getItem();
                } else {
                    BinarySearchTree.Node<T> toReturn = current;

                    if (current.right != null && !current.right.processed) {
                        current = current.right;
                    } else if (current.parent != null) {
                        if (current.left != null) current.left.processed = false;
                        if (current.right != null) current.right.processed = false;
                        current = current.parent;

                        if (toReturn.processed) {
                            return getItem();
                        }
                    } else {
                        if (current.left != null) current.left.processed = false;
                        if (current.right != null) current.right.processed = false;

                        current.processed = false;
                    }


                    toReturn.processed = true;

                    if (++processed == size) {
                        do {
                            if (current.left != null) current.left.processed = false;
                            if (current.right != null) current.right.processed = false;
                            current = current.parent;
                        } while (current != null);

                        root.processed = false;

                        hn = false;
                    }

                    return toReturn;
                }
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder saso = new StringBuilder("[ ");

        for (Integer i : this) {
            saso.append(i).append(", ");
        }

        saso.replace(saso.length() - 2, saso.length(), " ]");
        return saso.toString();
    }

    public static class Node<T>
    {
        private T value;

        Node<T> left = null;
        Node<T> right = null;
        Node<T> parent = null;

        boolean processed = false;
        Colors color = Colors.RED;
        Directions child;

        Node(T value, Directions d)
        {
            this.value = value;
            child = d;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}