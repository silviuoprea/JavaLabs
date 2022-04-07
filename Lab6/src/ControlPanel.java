import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
    }

    private void saveGame(ActionEvent actionEvent) {
        RenderedImage renderedImage = frame.canvas.image;

        File file = new File("C:\\Users\\blkma\\Desktop\\MyGame.png");

        try {
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
