public class BufferArray
{
   private int bufferSize;
   public int numberOfElements;
   public int[] intArray;
   
   // new constructor for size
   public BufferArray(int size)
   {
	   this.bufferSize = size;
	   this.numberOfElements = 0;
      // array for size
      intArray = new int[bufferSize];
   }
      
   // inserts a value at end
   public boolean insert(int value)
   {
       // checks array
       if (numberOfElements == bufferSize) 
       return false;
       // inserts value at end
       intArray[numberOfElements] = value;
       // increase array's size
       numberOfElements++;
       return true;
   }
  
   // gets target's location in array
   public int locationOf(int target)
   {
       // loop thru array
       for (int i = 0; i < numberOfElements; i++)
       {
           // if array value matches target, return index i
           if (intArray[i] == target) return i;
       }
       return -1;
   }

   // returns true if target is present
   public boolean find(int target)
   {
       if (locationOf(target) == -1) 
       return false;

       return true;
   }
  
   // removes value, and inserts the last element at it's place
   public boolean fastRemove(int value)
   {
       // gets  index of value in array
       int index = locationOf(value);
       if (index == -1) 
       return false;
       // reduces array size
       numberOfElements--;
       // inserts last element at index position
       intArray[index] = intArray[numberOfElements];
       return true;
   }
  
   // removes value w/o changing order
   public boolean stableRemove(int value)
   {
       // gets index of value in array
       int index = locationOf(value);
       if (index == -1) 
       return false;
       // shifts all elements from index + 1 to the left
       for (int i = index; i < numberOfElements - 1; i++)
       {
           intArray[i] = intArray[i + 1];
       }
       // reduces array size
       numberOfElements--;
       return true;
   }
  
   // prints numbers in array
   public void display()
   {
       // iterate through each element of array
       for (int i = 0; i < numberOfElements; i++)
       {
           // prints value
           System.out.print(intArray[i]);
           // adds comma, if not the last value in the array
           if (i != numberOfElements - 1)
           {
               System.out.print(", ");
           }
       }
       System.out.println();
   }  
}

class BufferArrayNoDups extends BufferArray {
// parameterized constructor
    public BufferArrayNoDups(int size)
    {
	    super(size);
    }
   
// overriden function to insert value into the array
    public final boolean insert(int value)
    {
    if (!find(value)) // validate that value doesn't exist in array
        {
        return super.insert(value); // insert at the end using insert function
        }

    return false; // value already exist in array
    }

}

class BufferArrayWithDups extends BufferArray {
// parameterized constructor
    public BufferArrayWithDups(int size)
    {
	    super(size);
    }

// function to count and return the number of occurrence of value in array
    public final int findAll(int value) {
    
        int count = 0;

// loop over array counting the number of times value appear
        for (int i = 0;i < this.numberOfElements;i++) {
            if (value == intArray[i])
            {
                count++;
            }
        }

        return count;
        }

// function to remove all occurrences of value from array
    public final int fastRemoveAll(int value) {

        int count = findAll(value); // get the number of times value occurs in array

// loop to remove each occurrence of value from array using fastRemove function
        for (int i = 0;i < count;i++) {

            this.fastRemove(value);
        }

        return count;
    }

// function to remove all occurrences of value from array
    public final int stableRemoveAll(int value) {

        int count = findAll(value); // get the number of times value occurs in array

// loop to remove each occurrence of value from array using stableRemove function
        for (int i = 0;i < count;i++) {

            this.stableRemove(value);
        }

        return count;
    }

}