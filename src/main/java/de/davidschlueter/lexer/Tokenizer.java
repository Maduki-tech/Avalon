package de.davidschlueter.lexer;

import java.util.List;

/**
 * The Tokenizer is responsible for converting the input string into a list of tokens.
 */
public interface Tokenizer {

    /**
     * This method takes a string of code and returns a list of tokens.
     * @param code The code to be tokenized.
     * @return A list of tokens.
     */
    List<TokenType> parse(String code);


}
