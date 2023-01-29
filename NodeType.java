//Name: Lance Cross, Due Date: 1/29/2023
//object that represents the node of a singly linked list
public class NodeType {

    //contains value of the node
    ItemType info;
    //represents next node
    NodeType next;

    //constructs a node with parameters
    public NodeType(ItemType i, NodeType n) {
        info = i;
        next = n;
    }
}