package binarySearchTree.queueForBreadth_First;

import binarySearchTree.Node;

// tạo queue cho breath-first traverser
public class NodeQueue {

    Node value; // value của node queue chính là node của tree
    NodeQueue next;

    public NodeQueue(Node q) {
        value = q;
        next = null;
    }
}
