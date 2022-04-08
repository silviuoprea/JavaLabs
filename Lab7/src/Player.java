import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);

        if (extracted.isEmpty()) {
            return false;
        }

        // create a word with all the extracted tiles
        System.out.println("You have tiles: " + extracted);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = null;

        try {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        game.getBoard().addWord(this, word);

        try {
            sleep((int) (Math.random() * 500));  // make the player sleep 50 ms
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        return true;
    }

    @Override
    public void run() {
        submitWord();
    }
}