package server.modals;

public class Employ {
    private int id;
    private String family;
    private String name;
    private String otch;
    private String tel;
    private String adres;


    public Employ(String family, String name, String otch, String tel, String adres) {
        this.family = family;
        this.name = name;
        this.otch = otch;
        this.tel = tel;
        this.adres = adres;
    }

    public Employ(String family, String name) {
        this.family = family;
        this.name = name;
    }

    public Employ(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getOtch() {
        return otch;
    }

    public String getTel() {
        return tel;
    }

    public String getAdres() {
        return adres;
    }

    public int getId() {
        return id;
    }
}
