import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            Random random = new Random();
            int points = random.nextInt(10);    // Generate random integer in range 0 to 9
            points++;   // Generate random integer in range 1 to 10

            letters.add(new Tile(c, points));
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }

            Random random = new Random();
            int pos = random.nextInt(letters.size());

            extracted.add(letters.get(pos));
            letters.remove(pos);
        }

        return extracted;
    }
}
