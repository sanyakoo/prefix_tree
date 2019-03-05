package edu.spbstu.prefixtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixTree {
    private static class Node {
        private Node parent;
        private int marker;
        private Map<Character, Node> map = new HashMap<>();

        public Node(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public int getMarker() {
            return marker;
        }

        public void setMarker(int marker) {
            this.marker = marker;
        }

        public Map<Character, Node> getMap() {
            return map;
        }

        public void setMap(Map<Character, Node> map) {
            this.map = map;
        }
    }

    private Node root = new Node(null);
    private int counter = 0;

    public void add(String str) {
        Node curNode = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Node node = curNode.getMap().get(ch);
            if (node == null) {
                node = new Node(curNode);
                curNode.getMap().put(ch, node);
            }
            curNode = node;
        }
        curNode.setMarker(++counter);
    }

    public List<String> findAllWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Node node = curNode.getMap().get(ch);
            if (node == null) {
                return result;
            } else {
                curNode = node;
            }
        }
        findFromNode(prefix, curNode, result);
        return result;
    }

    public boolean findStr(String str) {
        Node curNode = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Node node = curNode.getMap().get(ch);
            if (node == null) {
                return false;
            } else {
                curNode = node;
            }
        }
        if (curNode.getMarker() != 0) {
            return true;
        }
        return false;
    }

    public boolean remove(String str) {
        Node curNode = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Node node = curNode.getMap().get(ch);
            if (node == null) {
                return false;
            } else {
                curNode = node;
            }
        }
        curNode.setMarker(0);
        if (curNode != root && curNode.getMap().isEmpty()) {
            int curChIdx = str.length() - 1;
            while(curNode.getMarker() == 0 && curNode.getMap().isEmpty()) {
                Node parent = curNode.getParent();
                parent.getMap().remove(str.charAt(curChIdx--));
                curNode = parent;
            }
        }
        return true;
    }

    /**
     * BFS, fills result list with found strings
     * @param prefix
     * @param curNode
     * @param result
     */
    private void findFromNode(String prefix, Node curNode, List<String> result) {
        if (curNode.getMarker() != 0) {
            result.add(prefix);
        }
        for (Map.Entry<Character, Node> entry : curNode.getMap().entrySet()) {
            findFromNode(prefix + entry.getKey(), entry.getValue(), result);
        }
    }


    public static void main(String[] args) {
        System.out.println("Prefix tree");

        PrefixTree prefixTree = new PrefixTree();
        prefixTree.add("i");
        prefixTree.add("is");
        prefixTree.add("issue");
        prefixTree.add("can");
        prefixTree.add("cat");
        prefixTree.add("canada");
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
