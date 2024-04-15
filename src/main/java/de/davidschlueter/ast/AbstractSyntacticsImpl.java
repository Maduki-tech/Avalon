package de.davidschlueter.ast;

import de.davidschlueter.model.TokenNode;

public class AbstractSyntacticsImpl implements AbstractSyntaxTree {

    Node root;

    public Node addRecursive(Node current, TokenNode tokenNode) {
        if (current == null) {
            return new Node(tokenNode);
        }

        if (tokenNode.getWeight() < current.getValue().getWeight()) {
            current.setLeft(addRecursive(current.getLeft(), tokenNode));
        } else if (tokenNode.getWeight() > current.getValue().getWeight()) {
            current.setRight(addRecursive(current.getRight(), tokenNode));
        } else {
            return current;
        }

        return current;
    }

    @Override
    public void add(TokenNode tokenNode) {
        root = addRecursive(root, tokenNode);
    }

    private boolean containsNodeRecursive(Node current, TokenNode tokenNode) {
        if (current == null) {
            return false;
        }
        if (tokenNode.getWeight() == current.getValue().getWeight()) {
            return true;
        }

        return tokenNode.getWeight() < current.getValue().getWeight()
                ? containsNodeRecursive(current.getLeft(), tokenNode)
                : containsNodeRecursive(current.getRight(), tokenNode);
    }


    @Override
    public boolean containsNode(TokenNode tokenNode) {
        return containsNodeRecursive(root, tokenNode);
    }
}
