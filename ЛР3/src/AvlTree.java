import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvlTree <T extends Integer> extends BinarySearchTree<T> {

    private final int BALANCE = 1;

    @Override
    protected void restoreBalanceAfterAdd(Node<T> node) {

        if (node == null) throw new NullPointerException("Can't rebalance");

        Node<T> current = node.parent;

        while(current != null)
        {
            SimpleEntry<Integer, AddCases> leftSubTreeHeight = getHeightInfo(current.left);
            SimpleEntry<Integer, AddCases> rightSubTreeHeight = getHeightInfo(current.right);

            if (Math.abs(leftSubTreeHeight.getKey() - rightSubTreeHeight.getKey()) > BALANCE)
            {
                solveAddCases(current, Collections.max(List.of(leftSubTreeHeight, rightSubTreeHeight), Comparator.comparingInt(SimpleEntry::getKey)).getValue());
            }

            current = current.parent;
        }
    }

    private SimpleEntry<Integer, AddCases> getHeightInfo(Node<T> node)
    {
        if (node != null)
        {
            SimpleEntry<Integer, AddCases> leftSubTreeHeight = getHeightInfo(node.left);
            SimpleEntry<Integer, AddCases> rightSubTreeHeight = getHeightInfo(node.right);

            int heightLeft = leftSubTreeHeight.getKey(), heightRight = rightSubTreeHeight.getKey();

            if (heightLeft >= heightRight)
            {
                if (heightLeft == 0)
                {
                    return new SimpleEntry<>(heightLeft + 1, AddCases.OTHER_CASE);
                }
                else
                    return new SimpleEntry<>(heightLeft + 1, node.child == Directions.LEFT ? AddCases.LEFT_LEFT : AddCases.RIGHT_LEFT);
            }
            else
            {
                return new SimpleEntry<>(heightRight + 1, node.child == Directions.LEFT ? AddCases.LEFT_RIGHT : AddCases.RIGHT_RIGHT);
            }
        }
        else
            return new SimpleEntry<>(0, null);
    }

    private void solveAddCases(Node<T> node, AddCases addCase)
    {
        switch (addCase)
        {
            case LEFT_LEFT:
                rotateTree(node, Directions.RIGHT);
                break;
            case LEFT_RIGHT:
                rotateTree(node.left, Directions.LEFT);
                rotateTree(node, Directions.RIGHT);
                break;
            case RIGHT_RIGHT:
                rotateTree(node, Directions.LEFT);
                break;
            case RIGHT_LEFT:
                rotateTree(node.right, Directions.RIGHT);
                rotateTree(node, Directions.LEFT);
                break;
        }
    }

    @Override
    void handleRemove(Node<T> node) {
        if (node == null) throw new NullPointerException();

        if (node.left == null && node.right == null)
        {
            if (node.child == Directions.LEFT)
                node.parent.left = null;
            else
                node.parent.right = null;

            restoreBalanceAfterAdd(node);
        }
        else if (node.left != null && node.right == null)
        {
            if (!root.equals(node))
            {
                if (node.child == Directions.LEFT)
                {
                    node.parent.left = node.left;
                }
                else
                {
                    node.parent.right = node.left;
                    node.left.child = Directions.RIGHT;
                }

                node.left.parent = node.parent;
                restoreBalanceAfterAdd(node);
            }
            else
            {
                root = node.left;
                node.left.parent = node.parent;
            }
        }
        else if(node.left == null && node.right != null)
        {
            if (!root.equals(node))
            {
                if (node.child == Directions.LEFT)
                {
                    node.parent.left = node.right;
                    node.right.child = Directions.LEFT;
                }
                else
                {
                    node.parent.right = node.right;
                }

                node.right.parent = node.parent;
                restoreBalanceAfterAdd(node);
            }
            else
            {
                root = node.right;
                node.right.parent = node.parent;
            }
        }
        else
        {
            Node<T> iSuccessor = getInorderSuccessor(node);

            node.setValue(iSuccessor.getValue());

            handleRemove(iSuccessor);
        }
    }
}
