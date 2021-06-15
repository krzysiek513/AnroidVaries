package pl.studia.various;

public class Lista {
    private int listSrcId;
    private String nameId;
    private String opisId;


    public Lista(int listNameId, String nameId, String opisId) {
        this.listSrcId = listNameId;
        this.nameId = nameId;
        this.opisId = opisId;
    }

    public Lista(int listNameId, String nameId) {
        this.listSrcId = listNameId;
        this.nameId = nameId;
    }

    public int getListNameId() {
        return listSrcId;
    }

    public void setListNameId(int listNameId) {
        this.listSrcId = listNameId;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getOpisId() {
        return opisId;
    }

    public void setOpisId(String opisId) {
        this.opisId = opisId;
    }
}
