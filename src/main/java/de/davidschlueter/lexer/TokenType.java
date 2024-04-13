package de.davidschlueter.lexer;

/**
 * The TokenType enum represents the different types of tokens that can be found in the source code.
 */
public enum TokenType {
    // identifiers
    TOKEN_IDENTIFIER,

    // types
    TOKEN_LITERAL_STRING,
    TOKEN_LITERAL_NUMBER,

    // operators
    TOKEN_OPERATOR_PLUS,
    TOKEN_OPERATOR_EQUAL,

    // Symbols
    TOKEN_DELIMITER_LPAREN,
    TOKEN_DELIMITER_RPAREN,
    TOKEN_DELIMITER_SEMICOLON,

    // Keywords
    TOKEN_KEYWORD_PRINT,
    TOKEN_KEYWORD_VAR,
}
