import java.io.FileNotFoundException;

//Name: Lance Cross, Due Date: 1/29/2023
//driver program for the sorted linked list
import java.io.File;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        //checks for file in the command line
        if(args.length == 0) {
            System.out.println("Sorry. Please include a text file.");
        } else {
            try {
                File text = new File(args[0]);
                Scanner reader = new Scanner(text);
                SortedLinkedList l1 = new SortedLinkedList(reader);
                SortedLinkedList l2;

                reader = new Scanner(System.in);
                commands();
                int go = 1;
                String commandInput;
                int length;
                while(go == 1) {
                    System.out.print("Enter Command: ");
                    commandInput = reader.next();
                    switch(commandInput) {
                        case "i":   //inserts item
                            System.out.print("Enter a number to insert: ");
                            l1.insertItem(new ItemType(Integer.parseInt(reader.next())));
                            break;
                        case "d": //deletes item
                            System.out.print("Enter a number to delete: ");
                            l1.deleteItem(new ItemType(Integer.parseInt(reader.next())));
                            break;
                        case "s": //searches for item
                            System.out.print("Enter a number to search: ");
                            int index = l1.searchItem(new ItemType(Integer.parseInt(reader.next())));
                            if(index != -1) {
                                System.out.println("Original List: " + l1);
                                System.out.println("The item is present at index " + index);
                            } else {
                                System.out.println("Original List: " + l1);
                                System.out.println("The item is not present in the list");
                            }
                            break;
                        case "n": //gets next irem
                            System.out.println(l1.getNextItem().getValue());
                            break;
                        case "r":  //resets iterator
                            l1.resetList();
                            System.out.println("Iterator is reset.");
                            break;
                        case "a":  //deletes alternating nodes
                            System.out.println("Original List: " + l1);
                            l1.deleteAlternate();
                            break;
                        case "m": //merges lists
                            System.out.print("Enter the length of the new list: ");
                            length = Integer.parseInt(reader.next());
                            System.out.print("Enter the Numbers: ");
                            l1.mergeList(reader, length);
                            break;
                        case "t": //prints intersection of lists
                            System.out.print("Enter the length of the new list: ");
                            length = Integer.parseInt(reader.next());
                            System.out.print("Enter the Numbers: ");
                            l1.intersection(reader, length);
                            break;
                        case "p": //prints the list
                            System.out.println("The list is: " + l1);
                            break;
                        case "l": //prints length
                            System.out.println("The length of the list is " + l1.getLength());
                            break;
                        case "q":
                            go = 0;
                            System.out.println("Exiting program...");
                            break;
                        default:  //happens if invalid command is given
                            System.out.println("Invalid command, try again!");
                    }
                }
                
            }
            catch(FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }
    }
    //prints the commands list
    public static void commands() {
        System.out.println("Commands:\n(i) - Insert value");
        System.out.println("(d) - Delete value\n(s) - Search value");
        System.out.println("(n) - Print next iterator value\n(r) - reset iterator");
        System.out.println("(a) - Delete alternate nodes\n(m) - Merge lists");
        System.out.println("(t) - Find Intersection\n(p) - Print List");
        System.out.println("(l) - Print length\n(q) - quit program");
    }
}
