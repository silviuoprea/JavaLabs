public class Continent extends Entities{
    public Continent(String name) {
        super(name);
    }

    public Continent(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
