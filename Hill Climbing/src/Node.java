
import java.util.ArrayList;

public class Node implements Comparable<Node>{

    static  int size = 8; //Initializing the size
     Queen[] state;
     ArrayList<Node> nextNode;  //Storing all the nextNode in an ArrayList of Node class
     int h; //Heuristic value stored and checked for zero

    public Node() {
        state = new Queen[size];
        nextNode = new ArrayList<>();
        h = 0;
    }

    public Node(Node n) {
        state = new Queen[size];
        nextNode = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            state[i] = new Queen(n.state[i].getRows(), n.state[i].getColumns());
        }
        h = 0;
    }


    //setters and getters for setting and getting the size of the n-queen problems from the user input
    static public int getSize() {
        return size;
    }

    static public void setSize(int Size) {
        size = Size;
    }


    //Generating all the possible nextNode of the node passed as an argument to this method
    public ArrayList<Node> createNode(Node startState){

        int count=0;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                nextNode.add(count, new Node(startState));
                nextNode.get(count).state[i].goDown(j);
                nextNode.get(count).calculateH();
                count++;
            }
        }

        return nextNode;
    }




    //Computing the h is done by this method
    //Heuristic value is computed by calculating the number of queens that can attack each other by calling the canAttack boolean
    //method that returns a boolean value based on the configuration of Queens.
    public int calculateH(){

        for (int i = 0; i < size - 1; i++){
            for (int j = i + 1; j < size; j++){
                if (state[i].checkAttack(state[j])){
                    h++;
                }
            }
        }

        return h;
    }

    //Getter for the h
    public int getH(){

        return this.h;
    }

    public int compareTo(Node n){
        if (this.h < n.getH()) {
            return -1;
        } else if (this.h > n.getH()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setStateBoard(Queen[] s) {
        for(int i = 0; i < size; i++){
            state[i]= new Queen(s[i].getRows(), s[i].getColumns());
        }
    }


    public String toString(){

        String result = "";
        String[][] board = new String[size][size];

        for (int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                board[i][j] = ".";

        for (int i = 0; i < size; i++){
            board[state[i].getRows()][state[i].getColumns()]="Q";
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                result += board[i][j];
            }
            result += "\n";
        }

        return result;
    }
}
