public class Data {
    private String negara;
    private String tgl;
    private int pos;
    private int sembuh;
    private int mati;
    private int id;

    public Data(int id, String negara, int pos, int sembuh, int mati, String tgl){
        this.id = id;
        this.negara = negara;
        this.pos = pos;
        this.sembuh = sembuh;
        this.mati = mati;
        this.tgl=tgl;
    }

    public int getId(){
        return id;
    }
    public String getTgl() {
        return tgl;
    }
    public String getNegara() {
        return negara;
    }

    public int getPos() {
        return pos;
    }

    public int getSembuh() {
        return sembuh;
    }

    public int getMati() {
        return mati;
    }

}
