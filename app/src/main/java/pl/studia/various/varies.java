package pl.studia.various;

public class varies {
    private String discription;
    private String image;
    private String name;


    public varies(String listNameId, String naame, String opisId) {
        this.image = listNameId;
        this.name = naame;
        this.discription = opisId;
    }

    public varies() {
    }

    public String getListNameId() {
        return image;
    }

    public void setListNameId(String listNameId) {
        this.image = listNameId;
    }

    public String getNaame() {
        return name;
    }

    public void setNaame(String naame) {
        this.name = naame;
    }

    public String getOpisId() {
        return discription;
    }

    public void setOpisId(String opisId) {
        this.discription = opisId;
    }
}
