public class Room {
    String name;
    RoomType type;
    int capacity;

    public Room(String name, int capacity, RoomType type) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }
}
