//Name: Lance Cross, Due Date: 1/29/2023
//object containing an integer for comparison
public class ItemType {

    private int value;

    //creates an ItemType object with value = num
    public ItemType(int num) {
        value = num;
    }

    //returns value of the object
    public int getValue() {
        return value;
    }

    //compares two ItemType object's value 
    public int compareTo(ItemType item) {
        //value is less than item
        if(value == item.getValue()) {
            return 0;
        } else if (value > item.getValue()) {   //value is greater than item
            return 1;
        } else {     //value and item are equal
            return -1;
        }
    }
}