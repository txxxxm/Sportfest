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
    private JTextField Sportfeld;
    private JLabel label4;


    public SportfestGUI() {
        Abutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = new Schueler(Vorname.getText(), Nachname.getText(), Sportfeld.getText());
                if (Liste.isEmpty()) {
                    erster = s;
                    Liste.append(s);
                } else {
                    Liste.append(s);
                }
                updateList();
                Vorname.setText("");
                Nachname.setText("");
                Sportfeld.setText("");

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
