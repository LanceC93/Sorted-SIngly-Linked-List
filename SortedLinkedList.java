//Name: Lance Cross, Due Date: 1/29/2023
//object that represents a sorted singly linked list
public class SortedLinkedList {

    //first node in the list
    private NodeType head;
    //the node that is currently being traversed
    private NodeType currentPos;

    //creates new list with node pointers pointing to null values
    public SortedLinkedList() {
        head = null;
        currentPos = null;
    }

    //gets length of list
    public int getLength() {
        int length = 0;
        //keeps iterating length until next node is null
        while(currentPos != null) {
            length++;
            currentPos = currentPos.next;
        }
        return length;
    }    
}