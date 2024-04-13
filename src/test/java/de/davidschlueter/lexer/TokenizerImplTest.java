package de.davidschlueter.lexer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerImplTest {

    @Test
    void parse() {
        TokenizerImpl tokenizer = new TokenizerImpl();
        String code = "var x = 5;";
        TokenType[] expected = new TokenType[]{
                TokenType.TOKEN_KEYWORD_VAR,
                TokenType.TOKEN_IDENTIFIER,
                TokenType.TOKEN_OPERATOR_EQUAL,
                TokenType.TOKEN_LITERAL_NUMBER,
                TokenType.TOKEN_DELIMITER_SEMICOLON
        };
        TokenType[] actual = tokenizer.parse(code).toArray(new TokenType[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseWithFunction(){
        TokenizerImpl tokenizer = new TokenizerImpl();
        String code = "print(5);";
        TokenType[] expected = new TokenType[]{
                TokenType.TOKEN_KEYWORD_PRINT,
                TokenType.TOKEN_DELIMITER_LPAREN,
                TokenType.TOKEN_LITERAL_NUMBER,
                TokenType.TOKEN_DELIMITER_RPAREN,
                TokenType.TOKEN_DELIMITER_SEMICOLON
        };
        TokenType[] actual = tokenizer.parse(code).toArray(new TokenType[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseWithFunctionAndString(){
        TokenizerImpl tokenizer = new TokenizerImpl();
        String code = "print(\"Hello World\");";
        TokenType[] expected = new TokenType[]{
                TokenType.TOKEN_KEYWORD_PRINT,
                TokenType.TOKEN_DELIMITER_LPAREN,
                TokenType.TOKEN_LITERAL_STRING,
                TokenType.TOKEN_DELIMITER_RPAREN,
                TokenType.TOKEN_DELIMITER_SEMICOLON
        };
        TokenType[] actual = tokenizer.parse(code).toArray(new TokenType[0]);
        assertArrayEquals(expected, actual);
    }
}