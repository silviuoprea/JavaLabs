import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMechanics {
    private final MainFrame frame;
    List<Node> nodeList;
    List<Node> usedNodesList;
    Node previousNode = null;

    public GameMechanics(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Method responsible for generating randomly the sticks
     * that would be valid for the game
     */

    public void init() {
        Node[] nodes = new Node[frame.canvas.rows * frame.canvas.cols];

        for (int index = 0; index < nodes.length; index++) {
            int row = index / frame.canvas.rows;
            int col = index - (row * frame.canvas.cols);

            nodes[index] = new Node(index, row, col);
        }

        nodeList = new ArrayList<>();

        for (int i = 0; i < frame.canvas.rows; i++) {
            for (int j = 0; j < frame.canvas.cols - 1; j++) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    Node node1 = nodes[frame.canvas.cols * i + j];
                    Node node2 = nodes[frame.canvas.cols * i + j + 1];
                    addNodesToList(node1, node2);
                }
            }
        }

        for (int i = 0; i < frame.canvas.rows - 1; i++) {
            for (int j = 0; j < frame.canvas.cols; j++) {
                Random random = new Random(); // creating Random object
                if (random.nextBoolean()) {
                    Node node1 = nodes[frame.canvas.cols * i + j];
                    Node node2 = nodes[frame.canvas.cols * (i + 1) + j];
                    addNodesToList(node1, node2);
                }
            }
        }

        for (Node node1 : nodeList) {
            for (Node node2 : node1.adjacencyList) {
                if (node1.row == node2.row && node1.col < node2.col)
                    frame.canvas.paintSticks(node1, node2);
                else if (node1.col == node2.col && node1.row < node2.row)
                    frame.canvas.paintSticks(node1, node2);
            }
        }
        usedNodesList = new ArrayList<>();
    }

    private void addNodesToList(Node node1, Node node2) {
        if (!nodeList.contains(node1))
            nodeList.add(node1);
        if (!nodeList.contains(node2))
            nodeList.add(node2);
        if (!node1.adjacencyList.contains(node2))
            node1.adjacencyList.add(node2);
        if (!node2.adjacencyList.contains(node1))
            node2.adjacencyList.add(node1);
    }
}
