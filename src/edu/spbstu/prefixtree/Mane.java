package edu.spbstu.prefixtree;

import java.util.List;

public class Mane {
    public static void main(String[] args) {
        System.out.println("Prefix tree");

        PrefixTree prefixTree = new PrefixTree();
        prefixTree.add("i");
        prefixTree.add("is");
        prefixTree.add("issue");
        prefixTree.add("can");
        prefixTree.add("cat");
        prefixTree.add("canadian");
        prefixTree.add("cant");
        prefixTree.add("volume");
        prefixTree.add("value");

        List<String> found = prefixTree.findAllWithPrefix("can");
        for (String s : found) {
            System.out.println(s);
        }

        System.out.println("prefixTree.findStr = " + prefixTree.findStr("cant"));
        prefixTree.remove("cant");
        System.out.println("prefixTree.findStr = " + prefixTree.findStr("cant"));
    }
}
