import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private long startTime;
    private Player currentPlayer;
    private int index;
    private Thread t;
    public boolean stop = false;

    public int getIndex() {
        return index;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        game.play();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        startTime = System.nanoTime();

        index = 0;
        currentPlayer = players.get(index);

        t = new Thread(new Timekeeper());
        t.setDaemon(true);//success is here now
        t.start();

        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void getNextPlayer() {
        index++;

        if (index == players.size())
            index = 0;

        currentPlayer = players.get(index);

        if (!t.isAlive()) {
            stop = true;
            System.out.println("Time limit has been reached!");
        } else {
            long endTime = System.nanoTime();

            System.out.println("Time reached: " + (endTime - startTime) / 1000000 + " millis");
        }
    }
}
