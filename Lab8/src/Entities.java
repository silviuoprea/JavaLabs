public abstract class Entities {
    protected int id;
    protected String name;

    public Entities(String name) {
        this.name = name;
    }

    public Entities(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
