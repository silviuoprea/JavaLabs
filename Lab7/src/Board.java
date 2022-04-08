import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> board = new ArrayList<>();

    public Board() {
    }

    public synchronized void addWord(Player player, String word) {
        board.add(word);
        System.out.println(player.getName() + ": " + word);
    }
}
