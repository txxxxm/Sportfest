public class Schueler {
    String name;
    String nachname;
    String Sport;
    Schueler nachfolger;
    Double zeit;
    public Schueler(String pname, String pnachname, String pSport, Double pzeit)
    {
        zeit=pzeit;
        name=pname;
        nachname=pnachname;
        Sport=pSport;

    }
    public void setZeit(Double pzeit){
        zeit=pzeit;
    }

    public Double getZeit() {
        return zeit;
    }

    public void setName(String pname){
        name=pname;
    }
    public void setSport(String pSport){Sport=pSport;}
    public void setNachname(String pnachname){
        nachname=pnachname;
    }
    public String toString() {return "" + name + "," + nachname;}
    public String getAlles() {
        return name + " " + nachname+" "+Sport;
    }
}

