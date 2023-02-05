package v3.model;

public class Manufacture {
    private String code;
    private String name;
    private String country;

    public Manufacture(String name) {
        this.name = name;
    }

    public Manufacture(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Mã = " + code +
                ",tên = " + name +
                ",quốc gia = " + country;
    }
}
