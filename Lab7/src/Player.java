import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private final String name;
    public Game game;
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private int k;
    private boolean running = true;
    private int score;
    private List<Tile> extracted = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private boolean submitWord() {
        Integer result = threadLocal.get();
        System.out.println(name + "'s turn");
        System.out.println(game.getBag().getLetters().size() + " tiles left");
        System.out.println("You have to extract " + result + " tiles");

        if (game.getBag().getLetters().size() < result) {
            System.out.println("Bag has not enough tiles!");
            result = game.getBag().getLetters().size();
        }

        extracted.addAll(game.getBag().extractTiles(result));

        List<Tile> copyOfExtracted = new ArrayList<>(extracted);

        System.out.println("You have extracted " + result + " tiles");

        boolean keepReading = true;

        String word = null;
        int points = 0;

        while (keepReading) {
            extracted = new ArrayList<>();
            extracted.addAll(copyOfExtracted);

            System.out.println("You have tiles: " + extracted);
            System.out.print("Type here : ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            points = 0;

            try {
                word = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            boolean matchAllLetters = true;

            for (int i = 0; i < Objects.requireNonNull(word).length() && matchAllLetters; i++) {
                boolean matchOneLetter = false;

                for (Tile tile : extracted) {
                    if (word.charAt(i) == tile.getLetter()) {
                        extracted.remove(tile);
                        matchOneLetter = true;
                        points = points + tile.getPoints();
                        break;
                    }
                }

                if (!matchOneLetter) {
                    matchAllLetters = false;
                }
            }

            if (matchAllLetters) {
                keepReading = false;
            } else {
                System.out.println("You must use only tiles you have extracted!");
            }
        }

        if (game.getDictionary().isWord(word)) {
            game.getBoard().addWord(this, word);

            points = points * word.length();
            System.out.println("You gained: " + points + " points.");

            score = score + points;
            System.out.println("Your total score is: " + score);

            k = word.length();
        } else {
            System.out.println("Your word was not found in the dictionary!");
            System.out.println(copyOfExtracted);
            extracted = new ArrayList<>();
            extracted.addAll(copyOfExtracted);
            System.out.println(extracted);
            k = 0;
        }
        // make the player sleep 50 ms
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (game.getBag().getLetters().isEmpty()) {
            running = false;
        }
        return true;
    }

    @Override
    public void run() {
        threadLocal.set(7);

        while (running && !game.stop) {
            waitForOthers(game.getPlayers().indexOf(this));

            if (submitWord()) {
                threadLocal.set(k);
            }

            game.getNextPlayer();
        }
        System.out.println("Game has ended!");
        Player winner = game.getPlayers().get(0);

        for (Player player : game.getPlayers()) {
            if (player.getScore() > winner.getScore())
                winner = player;
        }

        System.out.println(winner.getName() + " has won the game!");
    }

    private void waitForOthers(int indexOf) {
        synchronized (game) {
            game.notifyAll();
            while (game.getIndex() != indexOf && !game.stop) {
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
