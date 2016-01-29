import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;

public class BreadFirst {

    public static void main(String[] args) {
        
        //always remember to initialize a scanner to read the input in the problem
        
        Scanner scan = new Scanner(System.in);
        
        //initialize these in the order they appear in the sample input of the problem
        
        int nodes = scan.nextInt();
        int edges = scan.nextInt();
        int start = scan.nextInt();
        int end = scan.nextInt(); 
        
        /**
         * this is an arraylist within an array list. 
         * the outer array list stores the nodes
         * the inner array list stores the edges connected to those nodes (adjacency list)
         * therefore, the first number in the outer array is 0, 
         * 0 is the first adjacency array. within
         * the 0 array, you'll find the connection 1.
         * the second number in the outer array is 1, within
         * the 1 array is 0, 3, 2, and 4. this is seen in the input list.
         * the inner array is the adjacency array. it records 
         * which nodes are adjacent to whichever node you're looking at in the outer array.
         */
        
        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>();
        
        //using this for loop lets you call the adjacent.add() method the correct number of times without writing it out 5 times to populate the arraylist
        for (int i = 0; i < nodes; i++)
        {
            //populates the outer array with nodes
            adjacent.add(new ArrayList<Integer>());
            
        }
        
        //this loop goes through the input and adds the input values corresponding adjacency to the inner array
        //it's bi-directional because, for example, it not only adds 0 to 1, but it also adds 1 to 0
        //adjacent.get(first) means that it's inside the outer array getting the 0 inner array, and adding it's adjacent int using .add(second)
        //adjacent.get(second) means that it's inside the outer array getting the 1 inner array and adding it's adjacent int using .add(first)
        //this back and forth getting and adding is ensuring the bi-directionality
        for (int i = 0; i < edges; i++)
        {
            int first = scan.nextInt();
            int second = scan.nextInt();
            adjacent.get(first).add(second);
            adjacent.get(second).add(first);
        }
        
        //the following code will initalize values for and begin bfs process
        //initialize an arraydeque to keep track of and create your queue
        //initialize a hashset to keep track of the nodes you've visited (this means immediately adding int start)
        //the Queue has methods like "poll" and "offer"
        //offer adds thing to the queue and poll does a search (this also means offering start right away)
        
       
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(start);
        visited.add(start);
              
        //initialize the distance array to keep track of how far you are moving from the start point
        //the visualization of the distance aspect of the code has not been fully realized for me yet, so i am not able to fully elaborate on it's technicalities in detail
        
        int[] distance = new int[nodes];
        
        //this holds logic for bfs
        //keep looping while the queue isn't empty
        
        while (!queue.isEmpty())
        {
            
            //initialize current with the poll method so that you can begin searching upon each step taken.
            int current = queue.poll();
            
            //if your current position matches you end node value, break the loop.
            if (current == end)
            {
                break;
            }
            else 
            {
                //iterate through neighbors. If you haven't been there, add them to the queue so they can be visited later
                //while also recording how far away they are from the current node
                //this syntax in the for loop represent the i < 5; i++ which i've never seen until now, so i can't elaborate on it at the moment
                //you don't give a concrete value for the i<5 part because the loop number changes based on where you are in the graph
                for (int i : adjacent.get(current))
                {
                    
                    //if the current number hasn't been visited, offer it to the queue, then add it to the visited array because as of now, it has just been visited
                    if (!visited.contains(i))
                    {
                    queue.offer(i);
                    visited.add(i);
                    
                    //every step you take, you're increasing your distance from start point
                    distance[i] = distance[current] + 1;
                    }
                
                    
                }
                
            }
            
        }
        
        //find the minimum number of rolls
        //int in parenthesis automatically converts math.ceil to a decimal
        //math.ceil rounds up int values
        int min = (int)Math.ceil(distance[end]/6.0);
        
        //print the results to the console in the order they appear in the sample output
        System.out.println(min);
        System.out.println(distance[end]);
        
                 
  
        
    }
    

}
