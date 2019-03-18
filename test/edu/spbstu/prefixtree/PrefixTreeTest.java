package edu.spbstu.prefixtree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixTreeTest {

    private PrefixTree prefixTree;
    @Before
    public void init(){
        prefixTree = new PrefixTree();
    }

    @Test
    public void add() {
        prefixTree.add("i");
        prefixTree.add("is");
        prefixTree.add("issue");
        prefixTree.add("can");
        prefixTree.add("cat");
        prefixTree.add("canada");
        prefixTree.add("cant");
        prefixTree.add("volume");
        prefixTree.add("value");
        assertEquals(9, prefixTree.findAllWithPrefix("").size());
    }

    @Test
    public void findAllWithPrefix() {
        prefixTree.add("i");
        prefixTree.add("is");
        prefixTree.add("issue");
        prefixTree.add("can");
        prefixTree.add("cat");
        prefixTree.add("canada");
        prefixTree.add("voice");
        prefixTree.add("volume");
        prefixTree.add("value");
        assertEquals(3, prefixTree.findAllWithPrefix("i").size());
        assertEquals(2, prefixTree.findAllWithPrefix("is").size());
        assertEquals(2, prefixTree.findAllWithPrefix("can").size());
        assertEquals(3, prefixTree.findAllWithPrefix("ca").size());
        assertEquals(3, prefixTree.findAllWithPrefix("v").size());
        assertEquals(1, prefixTree.findAllWithPrefix("val").size());
        assertEquals(2, prefixTree.findAllWithPrefix("vo").size());
        assertEquals(3, prefixTree.findAllWithPrefix("c").size());
    }

    @Test
    public void findStr() {
        prefixTree.add("highest");
        prefixTree.add("high");
        prefixTree.add("memes");
        prefixTree.add("memory");
        prefixTree.add("corn");
        assertEquals(false, prefixTree.findStr("memo"));
        assertEquals(false, prefixTree.findStr("core"));
        assertEquals(true, prefixTree.findStr("high"));
        assertEquals(false, prefixTree.findStr("highestr"));
    }

    @Test
    public void remove() {
        prefixTree.add("highest");
        prefixTree.add("high");
        prefixTree.remove("highest");
        assertTrue(prefixTree.findStr("high"));
        assertFalse(prefixTree.findStr("heinz"));
        assertFalse(prefixTree.findStr("store"));
        assertFalse(prefixTree.findStr("highest"));
        prefixTree.add("warning");
        prefixTree.remove("warning");
        assertFalse(prefixTree.findStr("warning"));
        assertTrue(prefixTree.findStr("high"));
    }
}