package de.davidschlueter.ast;

public class Node {
    int value;
    Node left;
    Node right;

    Node(int tokenType){
        this.value = tokenType;
    }
}

