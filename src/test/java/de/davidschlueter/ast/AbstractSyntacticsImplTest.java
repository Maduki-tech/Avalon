package de.davidschlueter.ast;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSyntacticsImplTest {
    AbstractSyntacticsImpl sut;

    @BeforeEach
    void setup() {
        sut = new AbstractSyntacticsImpl();
        sut.add(6);
        sut.add(4);
        sut.add(8);
        sut.add(3);
        sut.add(5);
        sut.add(7);
        sut.add(9);
    }

    @Test
    void testAddToRoot() {

        assertEquals(6, sut.root.value);
    }

    @Test
    void testTreeGivenElementsAndSearchIfContains() {
        assertTrue(sut.containsNode(6));
        assertTrue(sut.containsNode(4));

        assertFalse(sut.containsNode(1));
    }

}