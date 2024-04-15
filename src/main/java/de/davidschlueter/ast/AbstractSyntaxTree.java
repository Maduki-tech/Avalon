package de.davidschlueter.ast;

import de.davidschlueter.model.TokenNode;

public interface AbstractSyntaxTree {
    void add(TokenNode value);
    boolean containsNode(TokenNode value);

}
