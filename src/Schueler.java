public class Schueler {
    String name;
    String nachname;

    Schueler nachfolger;

    public Schueler(String pname, String pnachname)
    {
        name=pname;
        nachname=pnachname;

    }
    public void setName(String pname){
        name=pname;
    }
    public String getName(){
        return name;
    }
    public void setNachname(String pnachname){
        nachname=pnachname;
    }
    public String getNachname(){
        return nachname;
    }
    public void setNachfolger(Schueler pnachfolger){
        if(nachfolger==null){
            nachfolger=pnachfolger;
        }
        else{


        }
    }
    public Schueler getNachfolger(){
        return nachfolger;
    }
    public String toString() {
        return "" + name + "," + nachname;
    }
    public String getFullName() {
        return name + " " + nachname;
    }
}

