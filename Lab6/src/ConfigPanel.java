import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;

    JLabel label = new JLabel("Grid Size: ");
    JSpinner spinner;
    JButton button = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(spinner);
        add(button);

        button.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent actionEvent) {
        frame.removeCanvas();
        frame.gameMechanics.init();
    }

    public int getRows() {
        return (int) spinner.getValue();
    }

    public int getCols() {
        return (int) spinner.getValue();
    }
}
