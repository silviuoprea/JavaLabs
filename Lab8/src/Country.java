public class Country extends Entities {
    private final String continent;
    private String code;

    public Country(String name, String code, String continent) {
        super(name);
        this.code = code;
        this.continent = continent;
    }

    public Country(int id, String name, String code, String continent) {
        super(id, name);
        this.code = code;
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "continent='" + continent + '\'' +
                ", code='" + code + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
