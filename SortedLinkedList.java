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
        currentPos = head;
        //keeps iterating length until next node is null
        while(currentPos != null) {
            length++;
            currentPos = currentPos.next;
        }
        currentPos = head;  //REPLACE LATER WITH FUNCTION
        return length;
    }
    
    //inserts item into the linked list
    public void insertItem(ItemType item) {
        //inserts into string if it is empty
        if(head == null) {
            head = new NodeType(item, null);
            currentPos = head;
        } else if (head.info.compareTo(item) == -1){  //inserts node as head if it is less than head
            head = new NodeType(item, head.next);
        } else {
            currentPos = head;
            while(currentPos.next != null) {
                if(currentPos.next.info.compareTo(item) == 0) {
                    System.out.println("Sorry. You cannot insert duplicate item.");
                    return;
                } else if(currentPos.next.info.compareTo(item) == -1) {
                    currentPos.next = new NodeType(item, currentPos.next);
                    return;                                                //CHECK IF THIS WORKS LATER       
                }
                currentPos = currentPos.next;
            }
            //adds to the end
            currentPos.next = new NodeType(item, null);
        }
    }

    //deletes item
    public void deleteItem(ItemType item) {
        //does nothing if list is empty
        if(head == null) {
            System.out.println("You cannot delete from an empty list.");
        } else if(head.info.compareTo(item) == 0) {   //deletes head
            head = head.next;
        } else {
            currentPos = head;
            while(currentPos.next != null) { 
                if(currentPos.next.info.compareTo(item) == 0) {
                    currentPos.next = currentPos.next.next;
                    return; 
                }
                currentPos = currentPos.next;
            }
        }
    }

    //searches for an item in the list
    public int searchItem(ItemType item) {
        currentPos = head;
        int index = 0;
        while(currentPos != null && currentPos.info.compareTo(item) != 1) {
            if(currentPos.info.compareTo(item) == 0) {
                return index;
            }
            index++;
            currentPos = currentPos.next;
        }
        System.out.println("Item not Found.");
        return -1;
    }

    //returns the next item in the list
    public ItemType getNextItem() {
        if(head == null) {
            System.out.println("List is Empty");
            return null;
        } else {
            if(currentPos.next == null) {
                currentPos = head;
                return currentPos.info;
            } else {
                currentPos = currentPos.next;
                return currentPos.info;
            }
        }
    }

    //resets currentPos to null
    public void resetList() {
        currentPos = null;
    }

    //returns string representation of list
    public String toString() {
        String s = String.valueOf(head.info.getValue());
        currentPos = head.next;
        while(currentPos != null) {
            s = s + " " + currentPos.info.getValue();
        }
        return s;
    }

    //merges two lists
    public void mergeList(SortedLinkedList l) {
        currentPos = head;
        l.currentPos = l.head;
        SortedLinkedList merged = new SortedLinkedList();
        while(currentPos != null ) {
            merged.insertItem(currentPos.info);
            currentPos = currentPos.next;
        }
        while(l.currentPos != null ) {                         //THIS IS GOING TO PRINT A MESSAGE FOR EVERY DUPLICATE
            merged.insertItem(l.currentPos.info);
            l.currentPos = l.currentPos.next;
        }
        System.out.println("List 1: " + toString());
        System.out.println("List 2: " + l);
        System.out.println("Merged List: " + merged);
    }

    //deletes alternate nodes
    public void deleteAlternate() {
        System.out.println("List Before Alternate Delete: " + toString());
        currentPos = head;
        while(currentPos.next != null) {
            deleteItem(getNextItem());
        }
        System.out.println("List After Alternate Delete: " + toString());
    }

    //prints the values that two lists have in common
    public void intersection(SortedLinkedList l) {
        System.out.println("List 1: " + toString());
        System.out.println("List 2: " + l);

        currentPos = head;
        SortedLinkedList intersect = new SortedLinkedList();
        while(currentPos != null) {
            l.currentPos = l.head;
            while(l.currentPos != null && currentPos.info.compareTo(l.currentPos.info) != 1) {
                if(currentPos.info.compareTo(l.currentPos.info) == 0) {
                    intersect.insertItem(getNextItem());
                }
                l.currentPos = l.currentPos.next;
            }
        }
        System.out.println("Intersection: " + intersect);
    }
}