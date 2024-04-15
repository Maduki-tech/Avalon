package de.davidschlueter.ast;

import de.davidschlueter.model.TokenNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSyntacticsImplTest {
    AbstractSyntacticsImpl sut;

    @BeforeEach
    void setup() {
        sut = new AbstractSyntacticsImpl();
        sut.add(new TokenNode(6, null, null));
        sut.add(new TokenNode(4, null, null));
        sut.add(new TokenNode(8, null, null));
        sut.add(new TokenNode(3, null, null));
        sut.add(new TokenNode(5, null, null));
        sut.add(new TokenNode(7, null, null));
        sut.add(new TokenNode(9, null, null));
    }

    @Test
    void testAddToRoot() {

        assertEquals(6, sut.root.getValue().getWeight());
    }

    @Test
    void testTreeGivenElementsAndSearchIfContains() {
        assertTrue(sut.containsNode(new TokenNode(6, null, null)));
        assertTrue(sut.containsNode(new TokenNode(4, null, null)));

        assertFalse(sut.containsNode(new TokenNode(1, null, null)));
    }

}