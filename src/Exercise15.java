import java.util.*;

public class Exercise15
{
    public static void main(String[] args)
    {

        //initializes a new arraylist and fills it with elements
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(6);
        list.add(5);
        list.add(6);

        //initializes class as to be able to access methods of class
        //and then prints out method call
        Exercise15 exercise15 = new Exercise15();
        System.out.println(exercise15.maxOccurrences(list));
    }

    //method takes a list af integers and returns the number of times
    //the most frequently occurring number occurs in the list
    public int maxOccurrences(List<Integer> list)
    {
        //map used for storing the different numbers in.
        //values in map will be used as counters for times appeared
        Map<Integer, Integer> map = new TreeMap<>();

        //methods check if list is empty and returns 0 if that's the case
        if(list.isEmpty())
        {
            return 0;
        }

        //iterator for the passed list
        //used for adding each element of list to map as keys
        Iterator<Integer> itr = list.iterator();

        //integer used for the values paired with the keys
        int value = 1;

        // the loop runs while there are more elements to examine
        while(itr.hasNext())
        {
            //sets current to itr.next to avoid calling itr.next multiple times through loop
            int current = itr.next();

            //checks if map already contains the current element as a key
            //and adds 1 to the value if it does
            if(map.containsKey(current))
            {
                //count set to the current value
                int count = map.get(current);
                map.put(current, count + 1);
            }

            //if map doesn't contain the current key it is added to map with a value of 1
            else
                map.put(current, value);

        }
        //integer used for storing the maximum number of occurrences
        //will later be returned at end of method
        int maxOccur = 0;

        //examines each entry of map and sets maxOccur to current value if higher than maxOccur
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() >= maxOccur)
            {
                maxOccur = entry.getValue();
            }
        }

        //prints out key value pairings of map
        System.out.println(map);

        //returns the number of times the most frequently occurring number appears
        return maxOccur;
    }
}
