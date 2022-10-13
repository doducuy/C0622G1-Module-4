package codegym.model;

public class Dictionary {
    private String eng;
    private String vn;

    public Dictionary() {
    }

    public Dictionary(String eng, String vn) {
        this.eng = eng;
        this.vn = vn;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
}
