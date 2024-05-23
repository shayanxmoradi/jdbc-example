package ir.maktabsharif.jdbcexample.domain;

public class City extends BaseEntity {

    public static final String TABLE_NAME = "city";

    private String name;

    private Province province;

    public City() {
    }

    public City(Long id, String name, Province province) {
        super(id);
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}
