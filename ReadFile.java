package Web;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    // constructor
    public ReadFile() {
        super("Jali Browser");

        addressBar = new JTextField("enter a URL hoss!");
        addressBar.addActionListener(

                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        loadCrap(event.getActionCommand());

                    }
                }

        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {

            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    loadCrap(event.getURL().toString());
                }

            }

        }

        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);

    }

    // loadCrap to display on the Screen
    private void loadCrap(String userText) {
        try {
            display.setPage(userText);
            addressBar.setText(userText);
        } catch (Exception e) {
            System.out.println("crap!");
        }
    }

}
