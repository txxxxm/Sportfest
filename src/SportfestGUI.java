
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SportfestGUI {
    Schueler erster=null;

    List<Schueler> Liste = new List<>();
    Schueler s;
    private JPanel Mainpanell;
    private JTextField Vorname;
    private JTextField Nachname;
    private JButton Abutton;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JTextArea Listegrafik;
    private JButton Delete;
    private JTextField Zeitfeld;
    private JLabel label4;
    private JTextField Erster;
    private JButton GF;
    private JButton Lösche;
    private JButton Finder;
    private JTextField Zeit2;
    private JTextField Löschen;
    private JTextField Zeit4;
    double zeit;
    double zeit2;
    int i = 0;

    public SportfestGUI() {
        Abutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if Zeitfeld is not empty
                if (!Zeitfeld.getText().isEmpty()) {
                    zeit = Double.valueOf(Zeitfeld.getText());
                    s = new Schueler(Vorname.getText(), Nachname.getText(), Zeitfeld.getText(), zeit);

                    if (Liste.isEmpty()) {
                        Liste.append(s);
                    } else {
                        Liste.toFirst();
                        while (Liste.hasAccess() && zeit >= Liste.getContent().getZeit()) {
                            Liste.next();
                        }
                        Liste.insert(s);
                    }

                    updateList();
                    Vorname.setText("");
                    Nachname.setText("");
                    Zeitfeld.setText("");
                }
            }

        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLastObject();
            }
        });
        GF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Liste.isEmpty()) {
                    Liste.toFirst();
                    Erster.setText(Liste.getContent().getAlles());
                } else {
                    Erster.setText("Liste ist leer");
                }
            }
        });
        Lösche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zuLoeschenderName = Löschen.getText().trim();
                if (!zuLoeschenderName.isEmpty()) {
                    löscheperson(zuLoeschenderName);
                    Löschen.setText("");
                } else {
                    Löschen.setText( "Der eingegebene Name wurde nicht gefunden.");
                }
            }
        });
        Finder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gesuchterName = Zeit2.getText().trim();
                if (!gesuchterName.isEmpty()) {
                    double gefundeneZeit = zeitfinder(gesuchterName);
                    if (gefundeneZeit != -1) {
                        Zeit4.setText(String.valueOf(gefundeneZeit));
                    } else {
                        Zeit4.setText( "Der eingegebene Name wurde nicht gefunden.");
                    }
                } else {
                    Zeit4.setText( "Der eingegebene Name wurde nicht gefunden.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SportfestGUI");
        frame.setContentPane(new SportfestGUI().Mainpanell);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private double zeitfinder(String gesuchterName) {
        Liste.toFirst();
        while (Liste.hasAccess()) {
            Schueler aktuellerSchueler = Liste.getContent();
            String vollerName = aktuellerSchueler.getName() + " " + aktuellerSchueler.getNachname();
            if (vollerName.equals(gesuchterName)) {
                return aktuellerSchueler.getZeit();
            }
            Liste.next();
        }
        return -1;
    }

    private void löscheperson(String zuLoeschenderName) {
        Liste.toFirst();
        while (Liste.hasAccess()) {
            Schueler aktuellerSchueler = Liste.getContent();
            String vollerName = aktuellerSchueler.getAlles();
            if (vollerName.equals(zuLoeschenderName)) {
                Liste.remove();
                updateList();
                return;
            }
            Liste.next();
        }

        JOptionPane.showMessageDialog(Mainpanell, "Der eingegebene Name wurde nicht gefunden.", "Fehler", JOptionPane.ERROR_MESSAGE);
    }
    private void updateList() {
        Listegrafik.setText("Teilnehmer:\n");

        Liste.toFirst();
        while (Liste.hasAccess()) {

            Listegrafik.append(Liste.getContent().getAlles() + "\n");
            Liste.next();

        }
    }
    private void deleteLastObject() {
        if (!Liste.isEmpty()) {
            Liste.toLast();
            Liste.remove();
            updateList();
        }
    }

}
