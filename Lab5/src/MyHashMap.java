import java.util.ArrayList;

public class MyHashMap<T> {

    private ArrayList<Node<T>> buckets;
    private int numberOfBuckets;
    private int size;

    public MyHashMap() {
        buckets = new ArrayList<>(16);
        numberOfBuckets = 16;
        size = 0;

        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(null);
    }


    public T find(String key) {
        Node<T> node = buckets.get(getBucketIndex(key));
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.nextNode;
        }
        return null;
    }

    private int getBucketIndex(String key) {
        return Math.abs(getHashCode(key) % numberOfBuckets);
    }

    public void delete(String key) {
        int bucketIndex = getBucketIndex(key);
        Node<T> nodeToRemove = buckets.get(bucketIndex);
        if (nodeToRemove == null) return;
        Node<T> previousNode = null;
        while (nodeToRemove != null) {
            if (nodeToRemove.key.equals(key))
                break;
            previousNode = nodeToRemove;
            nodeToRemove = nodeToRemove.nextNode;
        }
        size -= 1;
        if (previousNode != null) {
            if (nodeToRemove == null) {
                return;
            }
            previousNode.nextNode = nodeToRemove.nextNode;
        } else {
            buckets.set(bucketIndex, nodeToRemove.nextNode);
        }
    }

    public ArrayList<T> toArray() {
        ArrayList<T> result = new ArrayList<>();
        for (Node<T> node : buckets) {
            while (node != null) {
                result.add(node.value);
                node = node.nextNode;
            }
        }
        return result;
    }

    public void insert(String key, T value) {
        int bucketIndex = getBucketIndex(key);
        Node<T> nodeAfterInserted = buckets.get(bucketIndex);
        while (nodeAfterInserted != null) {
            if (nodeAfterInserted.key.equals(key)) {
                nodeAfterInserted.value = value;
                return;
            }
            nodeAfterInserted = nodeAfterInserted.nextNode;
        }
        size++;
        nodeAfterInserted = buckets.get(bucketIndex);
        Node<T> newNode = new Node(key, value);
        newNode.nextNode = nodeAfterInserted;
        buckets.set(bucketIndex, newNode);
        if (!isLoadFactorAcceptable()) {
            ensureCapacity();
        }
    }

    private void ensureCapacity() {
        ArrayList<Node<T>> temp = buckets;
        size = 0;
        numberOfBuckets *= 2;
        buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(null);
        for (Node<T> node : temp) {
            while (node != null) {
                insert(node.key, node.value);
                node = node.nextNode;
            }
        }
    }

    private boolean isLoadFactorAcceptable() {
        return (1.0 * size / numberOfBuckets) <= 0.7;
    }

    private static int getHashCode(String key) {
        double smallNumber = 79;
        double bigNumber = 28072202;
        double mult = 1;
        int hashCode = 0;

        for (char i : key.toCharArray()) {
            hashCode += ((int) i) * mult % bigNumber;
            mult = mult * smallNumber % bigNumber;
        }

        return hashCode;
    }

    private class Node<T> {
        String key;
        T value;

        Node<T> nextNode;

        public Node(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}