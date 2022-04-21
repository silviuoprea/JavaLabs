public record Tile(char letter, int points) {

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return letter + "=" + points + "p";
    }
}
