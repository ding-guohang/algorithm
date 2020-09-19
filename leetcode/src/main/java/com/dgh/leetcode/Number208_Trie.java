package com.dgh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 丁国航 Meow on 2020/9/14
 */
public class Number208_Trie {

    /**
     * 前缀数，每个字母是一个分支，然后每个节点标记是否有单词在这里结束
     */
    static class Trie {

        static class TrieNode {
            private char key;
            private boolean end;
            private Map<Character, TrieNode> next;

            public TrieNode(char key, boolean end) {
                this.key = key;
                this.end = end;
                this.next = new HashMap<>();
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode(' ', false);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                TrieNode target = node.next.get(c);
                if (null == target) {
                    target = new TrieNode(c, false);
                }
                node.next.put(c, target);
                node = target;
            }

            node.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next.get(c);
                if (null == node) {
                    return false;
                }
            }
            return node.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.next.get(c);
                if (null == node) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

}
