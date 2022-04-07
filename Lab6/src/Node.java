import java.util.ArrayList;
import java.util.List;

public class Node {
    public int index;
    public int row;
    public int col;

    List<Node> adjacencyList = new ArrayList<>();

    public Node(int index, int row, int col) {
        this.index = index;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "index=" + index +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
