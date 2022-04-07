import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    GameMechanics gameMechanics;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);

        pack();
    }

    public void removeCanvas() {
        remove(canvas);

        canvas = new DrawingPanel(this);
        add(canvas, CENTER);

        revalidate();

        pack();
    }
}
