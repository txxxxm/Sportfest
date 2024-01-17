
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SportfestGUI");
        frame.setContentPane(new SportfestGUI().Mainpanell);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
