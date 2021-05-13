public class RedBlackTree<T extends Integer> extends BinarySearchTree<T> {

    @Override
    protected void restoreBalanceAfterAdd(Node<T> x)
    {
        if (x.equals(root))
        {
            x.color = Colors.BLACK;
            x.child = Directions.ROOT;
        }
        else if (x.parent.color == Colors.RED)
        {
            Node<T> uncle = getUncle(x);
            Node<T> grandParent = x.parent.parent;

            if (uncle != null && uncle.color == Colors.RED)
            {
                grandParent.color = Colors.RED;
                x.parent.color = Colors.BLACK;
                uncle.color = Colors.BLACK;

                restoreBalanceAfterAdd(grandParent);
            }
            else
            {
                AddCases nodePlace = getAddCase(x);

                switch (nodePlace)
                {
                    case LEFT_LEFT:
                        rotateTree(grandParent, Directions.RIGHT);
                        grandParent.color = Colors.RED;
                        x.parent.color = Colors.BLACK;
                        break;
                    case LEFT_RIGHT:
                        rotateTree(x.parent, Directions.LEFT);
                        rotateTree(grandParent, Directions.RIGHT);
                        grandParent.color = Colors.RED;
                        x.color = Colors.BLACK;
                        break;
                    case RIGHT_RIGHT:
                        rotateTree(grandParent, Directions.LEFT);
                        grandParent.color = Colors.RED;
                        x.parent.color = Colors.BLACK;
                        break;
                    case RIGHT_LEFT:
                        rotateTree(x.parent, Directions.RIGHT);
                        rotateTree(grandParent, Directions.LEFT);
                        grandParent.color = Colors.RED;
                        x.color = Colors.BLACK;
                        break;
                }
            }
        }
    }

    private AddCases getAddCase(Node<T> node)
    {
        if (node.equals(root)) return AddCases.OTHER_CASE;
        Node<T> parent = node.parent;

        if (parent.equals(root)) return AddCases.OTHER_CASE;

        if (node.child == Directions.LEFT && parent.child == Directions.LEFT)
            return AddCases.LEFT_LEFT;
        else if (node.child == Directions.RIGHT && parent.child == Directions.LEFT)
            return AddCases.LEFT_RIGHT;
        else if (node.child == Directions.LEFT && parent.child == Directions.RIGHT)
            return AddCases.RIGHT_LEFT;
        else
            return AddCases.RIGHT_RIGHT;
    }

    @Override
    protected void handleRemove(Node<T> node)
    {
        Node<T> redChild;

        if (node.left == null && node.right == null)
        {
            removeLeave(node);
        }
        else if ((redChild = onlyOneChildRed(node)) != null)
        {
            node.setValue(redChild.getValue());
            node.left = redChild.left;
            node.right = redChild.right;
        }
        else if (node.left != null && node.right != null)
        {
            Node<T> iSuccessor = getInorderSuccessor(node);

            node.setValue(iSuccessor.getValue());

            handleRemove(iSuccessor);
        }
        else
            throw new IllegalArgumentException("This is not RBT");
    }

    private void removeLeave(Node<T> node)
    {
        if (node == null) throw new NullPointerException();

        if (node.color != Colors.RED) {
            solveDoubleBlackNode(node);
        }

        if (node.child == Directions.LEFT) node.parent.left = null; else node.parent.right = null;
    }

    private void solveDoubleBlackNode(Node<T> node)
    {
        RemoveCases remCase = getRemoveCases(node);

        Node<T> sibling = new Node<>(null, Directions.ROOT);

        if (remCase != RemoveCases.FIRST_CASE)
            sibling = getSibling(node);

        switch (remCase)
        {
            case FIRST_CASE:
                node.color = Colors.BLACK;
                return;
            case SECOND_CASE:
                if (node.child == Directions.LEFT)
                {
                    rotateTree(node.parent, Directions.LEFT);
                }
                else
                {
                    rotateTree(node.parent, Directions.RIGHT);
                }

                node.parent.color = Colors.RED;
                sibling.color = Colors.BLACK;

                solveDoubleBlackNode(node);
                return;
            case THIRD_CASE:
                node.color = Colors.BLACK;
                sibling.color = Colors.RED;

                solveDoubleBlackNode(node.parent);
                return;
            case FOURTH_CASE:
                node.color = Colors.BLACK;
                sibling.color = Colors.RED;
                node.parent.color = Colors.BLACK;
                return;
            case FIFTH_CASE:
                if (node.child == Directions.LEFT)
                {
                    rotateTree(sibling, Directions.RIGHT);
                }
                else
                {
                    rotateTree(sibling, Directions.LEFT);
                }

                sibling.parent.color = Colors.BLACK;
                sibling.color = Colors.RED;

                solveDoubleBlackNode(node);
                return;
            case SIXTH_CASE:
                if (node.child == Directions.LEFT)
                {
                    rotateTree(node.parent, Directions.LEFT);
                }
                else
                {
                    rotateTree(node.parent, Directions.RIGHT);
                }

                node.color = Colors.BLACK;
                getUncle(node).color = Colors.BLACK;
                sibling.color = node.parent.color;
                node.parent.color = Colors.BLACK;
        }
    }

    private RemoveCases getRemoveCases(Node<T> node)
    {
        if (root.equals(node)) return RemoveCases.FIRST_CASE;

        Node<T> sibling = getSibling(node);

        assert sibling != null;

        if (node.parent.color == Colors.BLACK
                && sibling.color == Colors.RED)
                    return RemoveCases.SECOND_CASE;

        if (node.parent.color == Colors.BLACK
                && sibling.color == Colors.BLACK
                && (sibling.left == null || sibling.left.color == Colors.BLACK)
                && (sibling.right == null || sibling.right.color == Colors.BLACK))
                    return RemoveCases.THIRD_CASE;

        if (node.parent.color == Colors.RED
                && sibling.color == Colors.BLACK
                && (sibling.left == null || sibling.left.color == Colors.BLACK)
                && (sibling.right == null || sibling.right.color == Colors.BLACK))
                    return RemoveCases.FOURTH_CASE;

        if (node.parent.color == Colors.BLACK
                && sibling.color == Colors.BLACK
                && ((node.child == Directions.LEFT
                    && sibling.left != null && sibling.left.color == Colors.RED
                    && (sibling.right == null || sibling.right.color == Colors.BLACK))
                    ||
                    (node.child == Directions.RIGHT
                    && (sibling.left == null || sibling.left.color == Colors.BLACK)
                    && sibling.right != null && sibling.right.color == Colors.RED)))
                    return RemoveCases.FIFTH_CASE;

        if (
                sibling.color == Colors.BLACK
                && ((node.child == Directions.LEFT
                    && sibling.right != null
                    && sibling.right.color == Colors.RED)
                    ||
                    (node.child == Directions.RIGHT
                    && sibling.left != null
                    && sibling.left.color == Colors.RED)))
                    return RemoveCases.SIXTH_CASE;

        return RemoveCases.OTHER_CASE;
    }

    private Node<T> onlyOneChildRed(Node<T> node)
    {
        if (node.left == null && node.right != null && node.right.color == Colors.RED)
            return node.right;
        else if (node.right == null && node.left != null && node.left.color == Colors.RED)
            return node.left;

        return null;
    }
}
