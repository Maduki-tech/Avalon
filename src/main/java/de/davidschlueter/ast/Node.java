package de.davidschlueter.ast;

import de.davidschlueter.model.TokenNode;
import lombok.Data;

@Data
public class Node {
    private TokenNode value;
    private Node left;
    private Node right;

    Node(TokenNode tokenType){
        this.value = tokenType;
    }
}

