package de.davidschlueter.lexer;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * The Tokenizer is responsible for converting the input string into a list of tokens.
 */
@Slf4j
public class TokenizerImpl implements Tokenizer {

    public TokenizerImpl() {
    }

    @Override
    public List<TokenType> parse(String code) {
        List<TokenType> tokenTypes = new ArrayList<TokenType>();
        List<String> strings = tokenize(code);

        strings.forEach(s -> {
            TokenType tokenType = TokenType.forToken(s);
            log.info("Token: {} Type: {}", s, tokenType);
            tokenTypes.add(tokenType);
        });


        return tokenTypes;
    }

    /**
     * Read the code string and split it into tokens
     * @param code the code string
     * @return the list of tokens
     */
    private List<String> tokenize(String code) {
        List<String> tokens = new ArrayList<String>();
        int index = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (isSpace(c)) {
                index = getIndex(code, index, tokens, i);
            } else if (isDelimiter(c)) {
                index = getIndex(code, index, tokens, i);
                // add the delimiter
                tokens.add(String.valueOf(c));
            } else if (isString(c)) {
                index = getIndex(code, index, tokens, i);
                // add the string
                int j = i + 1;
                while (j < code.length() && code.charAt(j) != '"') {
                    j++;
                }
                tokens.add(code.substring(i, j + 1));
                i = j;
            }
            else {
                index++;
            }
        }

        return tokens;
    }

    private boolean isString(char c) {
        return c == '"';
    }

    /**
     * Get the index of the token in the code string and add the token to the tokens list
     * and reset the index
     * @param code the code string
     * @param index the index of the token
     * @param tokens the list of tokens
     * @param i the current index in the code string
     * @return the index of the token
     */
    private int getIndex(String code, int index, List<String> tokens, int i) {
        if (index != 0) {
            tokens.add(code.substring(i - index, i));
            index = 0;
        }
        return index;
    }


    /**
     * Check if the character is a space
     * @param c the character to check
     * @return true if the character is a space
     */
    private boolean isSpace(char c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    /**
     * Check if the character is a delimiter
     * @param c the character to check for being a delimiter
     * @return true if the character is a delimiter
     */
    private boolean isDelimiter(char c) {
        return c == '(' || c == ')' || c == ';' || c == '+' || c == '=';
    }


    /**
     * Get the token type for a given token string representation
     * @param token the token string representation
     * @return the token type
     */
    private TokenType getTokenType(String token) {
        TokenType tokenType = null;

        switch (token){
            case "print":
                tokenType = TokenType.TOKEN_KEYWORD_PRINT;
                break;
            case "var":
                tokenType = TokenType.TOKEN_KEYWORD_VAR;
                break;
            case "+":
                tokenType = TokenType.TOKEN_OPERATOR_PLUS;
                break;
            case "=":
                tokenType = TokenType.TOKEN_OPERATOR_EQUAL;
                break;
            case "(":
                tokenType = TokenType.TOKEN_DELIMITER_LPAREN;
                break;
            case ")":
                tokenType = TokenType.TOKEN_DELIMITER_RPAREN;
                break;
            case ";":
                tokenType = TokenType.TOKEN_DELIMITER_SEMICOLON;
                break;
            default:
                if (token.matches("[0-9]+")) {
                    tokenType = TokenType.TOKEN_LITERAL_NUMBER;
                } else if (token.matches("\".*\"")) {
                    tokenType = TokenType.TOKEN_LITERAL_STRING;
                } else {
                    tokenType = TokenType.TOKEN_IDENTIFIER;
                }
        }
        return tokenType;
    }
}
