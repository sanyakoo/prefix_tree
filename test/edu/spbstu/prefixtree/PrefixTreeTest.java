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
        prefixTree.add("cannabis");
        prefixTree.add("canada");
        prefixTree.add("cant");
        prefixTree.add("volume");
        prefixTree.add("value");
        assertEquals(10, prefixTree.findAllWithPrefix("").size());
    }

    @Test
    public void findAllWithPrefix() {
    }

    @Test
    public void findStr() {
    }

    @Test
    public void remove() {
    }
}