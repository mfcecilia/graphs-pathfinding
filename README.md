# graphs-pathfinding
VT Programming team lecture 2016.01.28  <br>
Bread First <br>
Time Limit: 5 seconds

Bobby Baker is playing a board game. The details of the game aren’t quite important right now, but Bobby has one goal: to get to the bread piece. The board game consists of many locations, with each location being connected to a number of other locations. On each turn, a player rolls a single 6-sided dice, and may move along to connected locations from their current position up to the number on the dice. For example, if Bobby rolled a 1 on the dice, he could move to any connected location of his current location or stay in place. If he rolled a 2, he could move to any location a distance of 2 or less away (with distance defined by the “connectedness” of the locations).

Bobby is quite good at this game, so we can be certain he will take the optimal path towards the bread for any of his turns. Given the board layout, can you find both the minimum and maximum number of turns until Bobby reaches the bread?
Note that the optimal path length does not change, but the number of turns depends on Bobby’s dice rolls.

Input  <br>
Input will begin with one line containing four integers N(1≤N≤5000)N(1≤N≤5000) E(1≤E≤20,000)E(1≤E≤20,000), S, and B(0≤S,B<N)B(0≤S,B<N). N denotes the number of distinct board locations, with E the number of connections between them. S and B are the starting locations of Bobby and the ending location of the bread as 0-indexed board locations.

E lines will follow, each of consisting of two integers i,j(0≤i,j<N)i,j(0≤i,j<N) denoting a connection between board place i and board place j.

Note that the connections are bi-directional (i connected to j implies that j is connected to i), and the places are numbered starting from 0.

Output  <br>
Output a single line containing two integers MN separated by a single space, denoting the minimum number of dice rolls and the maximum number of dice rolls until Bobby reaches the bread on the game board.

Sample Input 1	
5 5 0 4 <br>
0 1 <br>
1 3 <br>
1 2 <br>
3 4 <br>
1 4

Sample Output 1 <br>
1 2
