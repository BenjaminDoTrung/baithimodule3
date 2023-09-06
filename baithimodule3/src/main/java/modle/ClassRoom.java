package modle;

public class ClassRoom {
    private int id;
    private String nameClass;

    public ClassRoom() {
    }

    public ClassRoom(int id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
