package de.davidschlueter.model;

import de.davidschlueter.lexer.TokenType;
import lombok.Data;

@Data
public class TokenNode {
    int weight;
    TokenType tokenType;
    String value;

    public TokenNode(int weight, TokenType tokenType, String value) {
        this.weight = weight;
        this.tokenType = tokenType;
        this.value = value;
    }
}
