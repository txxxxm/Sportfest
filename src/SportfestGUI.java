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


    public SportfestGUI() {
        Abutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = new Schueler(Vorname.getText(), Nachname.getText());
                if (Liste.isEmpty()) {
                    erster = s;
                    Liste.append(s);
                } else {
                    Liste.append(s);
                }
               updateList(s);
                Vorname.setText("");
                Nachname.setText("");

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

    private void updateList(Schueler schueler) {
       Listegrafik.setText("Liste:\n");
        Listegrafik.setText(Listegrafik.getText()+s.getFullName()+"\n");
    }
}
