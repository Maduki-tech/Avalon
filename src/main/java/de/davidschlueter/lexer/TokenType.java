package de.davidschlueter.lexer;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The TokenType enum represents the different types of tokens that can be found in the source code.
 */
public enum TokenType {
    TOKEN_LITERAL_STRING("\".*\""),
    TOKEN_LITERAL_NUMBER("[0-9]+"),
    TOKEN_OPERATOR_PLUS("\\+"),
    TOKEN_OPERATOR_EQUAL("="),
    TOKEN_DELIMITER_LPAREN("\\("),
    TOKEN_DELIMITER_RPAREN("\\)"),
    TOKEN_DELIMITER_SEMICOLON(";"),
    TOKEN_KEYWORD_PRINT("print"),
    TOKEN_KEYWORD_VAR("var"),
    TOKEN_IDENTIFIER("[a-zA-Z_][a-zA-Z0-9_]*");

    private final Pattern pattern;

    TokenType(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean matches(String token) {
        return pattern.matcher(token).matches();
    }

    public static TokenType forToken(String token) {
        return Arrays.stream(TokenType.values())
                .filter(type -> type.matches(token))
                .findFirst()
                .orElse(TOKEN_IDENTIFIER);

    }
}
