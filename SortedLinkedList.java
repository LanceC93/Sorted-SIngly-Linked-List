//Name: Lance Cross, Due Date: 1/29/2023
//object that represents a sorted singly linked list
import java.util.Scanner;

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
    //creates new list from a input stream 
    public SortedLinkedList(Scanner reader) {
        this();
        if(reader.hasNext()) {
            insertItem(new ItemType(Integer.parseInt(reader.next())));
            while(reader.hasNext()) {
                insertItem(new ItemType(Integer.parseInt(reader.next())));
            }
        }
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
        currentPos = head;
        return length;
    }
    
    //inserts item into the linked list
    public void insertItem(ItemType item) {
        //inserts into string if it is empty
        if(head == null) {
            head = new NodeType(item, null);
        } else if (head.info.compareTo(item) == 1) {  //inserts node as head if it is less than head
            head = new NodeType(item, head);
        } else {
            currentPos = head;
            while(currentPos.next != null) {
                if(currentPos.info.compareTo(item) == 0) {
                    System.out.println("Sorry. You cannot insert duplicate item.");
                    resetList();
                    return;
                } else if(currentPos.next.info.compareTo(item) == 1) {
                    currentPos.next = new NodeType(item, currentPos.next);
                    resetList();
                    return;                                                     
                }
                currentPos = currentPos.next;
            }
            //adds to the end
            if(currentPos.info.compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert duplicate item.");
            } else {
                currentPos.next = new NodeType(item, null);
            }
            resetList();
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
            System.out.println("Item not found");
        }
    }

    //searches for an item in the list
    public int searchItem(ItemType item) {
        if(head == null) {
            System.out.println("The list is empty");
            return -1;
        }
        currentPos = head;
        int index = 1;
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
        } else if (currentPos == null) {
            currentPos = head;
            return head.info;
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
            currentPos = currentPos.next;
        }
        resetList();
        return s;
    }

    //merges two lists
    public void mergeList(Scanner reader, int length) {
        SortedLinkedList l = new SortedLinkedList();
        for(int i = 1; i <= length; i++) {
            l.insertItem(new ItemType(Integer.parseInt(reader.next())));
        }
        System.out.println("List 1: " + toString());
        System.out.println("List 2: " + l);
        currentPos = head;
        l.currentPos = l.head;
        SortedLinkedList merged = new SortedLinkedList();
        while(l.currentPos != null || currentPos != null) {
            if(l.currentPos == null || currentPos.info.compareTo(l.currentPos.info) == -1){
                merged.insertItem(currentPos.info);
                currentPos = currentPos.next;
            } else if(currentPos == null ||currentPos.info.compareTo(l.currentPos.info) == 1) {
                merged.insertItem(l.currentPos.info);
                l.currentPos = l.currentPos.next;
            } else {
                merged.insertItem(currentPos.info);
                currentPos = currentPos.next;
                l.currentPos = l.currentPos.next;
            }
        }
        System.out.println("Merged List: " + merged);
    }

    //deletes alternate nodes
    public void deleteAlternate() {
        System.out.println("List Before Alternate Delete: " + toString());
        currentPos = head;
        while(currentPos != null && currentPos.next != null) {
            deleteItem(getNextItem());
            currentPos = currentPos.next;
        }
        System.out.println("List After Alternate Delete: " + toString());
    }

    //prints the values that two lists have in common
    public void intersection(Scanner reader, int length) {
        SortedLinkedList l = new SortedLinkedList();
        for(int i = 1; i <= length; i++) {
            l.insertItem(new ItemType(Integer.parseInt(reader.next())));
        }
        System.out.println("List 1: " + toString());
        System.out.println("List 2: " + l);

        currentPos = head;
        l.currentPos = l.head;
        SortedLinkedList intersect = new SortedLinkedList();
        while(l.currentPos != null || currentPos != null) {
            if(l.currentPos == null || currentPos.info.compareTo(l.currentPos.info) == -1){
                currentPos = currentPos.next;
            } else if(currentPos == null ||currentPos.info.compareTo(l.currentPos.info) == 1) {
                l.currentPos = l.currentPos.next;
            } else {
                intersect.insertItem(currentPos.info);
                currentPos = currentPos.next;
                l.currentPos = l.currentPos.next;
            }
        }
        System.out.println("Intersection: " + intersect);
    }
}