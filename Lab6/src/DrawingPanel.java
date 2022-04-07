import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    int player = 1;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * This is the init method
     * generates the canvas for the game
     * calls the action that is executed on mouse press
     */
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                repaint();
            }
        });
    }

    /**
     * Method responsible for coloring stones, determining the winner
     * @param x coordinate of mouse click
     * @param y coordinate of mouse click
     *
     * X and Y - ideal stone coordinates (intersection)
     */
    private void drawStone(int x, int y) {
        if (player == 1)
            offscreen.setColor(Color.BLUE);
        else offscreen.setColor(Color.RED);

        int col = x / cellWidth;
        int row = y / cellHeight;

        int X = padX + col * cellWidth;
        int Y = padY + row * cellHeight;

        if (x <= X + stoneSize / 2 && x >= X - stoneSize / 2 && y <= Y + stoneSize / 2 && y >= Y - stoneSize / 2) {
            for (Node node : frame.gameMechanics.nodeList) {
                if (node.row == row && node.col == col) {
                    if (!frame.gameMechanics.usedNodesList.contains(node)) {
                        if (frame.gameMechanics.previousNode == null || frame.gameMechanics.previousNode.adjacencyList.contains(node)) {
                            frame.gameMechanics.usedNodesList.add(node);
                            frame.gameMechanics.previousNode = node;

                            offscreen.fillOval(X - stoneSize / 2, Y - stoneSize / 2, stoneSize, stoneSize);

                            if (frame.gameMechanics.usedNodesList.containsAll(node.adjacencyList)) {
                                frame.dispose();
                                System.out.println("Game over!");
                                System.out.println("Game winner is player " + player);
                            }

                            if (player == 1)
                                player = 2;
                            else player = 1;

                        } else {
                            System.out.println("Stone isn't adjacent!");
                        }
                    } else System.out.println("Node already colored!");
                }
            }
        } else System.out.println("Select a node!");
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        paintGrid();
        graphics.drawImage(image, 0, 0, this);
    }

    /**
     * Method responsible for coloring the game grid
     */

    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);

        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            offscreen.drawLine(x1, y1, x2, y1);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int y2 = padY + boardHeight;

            offscreen.drawLine(x1, y1, x1, y2);
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    /**
     * Method responsible for painting the sticks
     * that would be valid for the game
     * @param node1 node that is used as coordinate for a stick
     * @param node2 node that is used as coordinate for a stick
     */

    public void paintSticks(Node node1, Node node2) {
        offscreen.setStroke(new BasicStroke(4));

        offscreen.setColor(Color.BLACK);

        int x1, y1;

        x1 = padX + node1.col * cellWidth;
        y1 = padY + node1.row * cellHeight;

        if (node1.row == node2.row) {
            offscreen.drawLine(x1, y1, x1 + cellWidth, y1);
        } else {
            offscreen.drawLine(x1, y1, x1, y1 + cellHeight);
        }

        offscreen.setStroke(new BasicStroke(0));
    }
}
