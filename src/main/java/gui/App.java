package gui;

import client.RequestProcessor;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.Color;

public class App {
    public static void main(String[] args) {
        LayoutManager layOut = new GridLayout(4, 1);
        final Frame f = new Frame();
        f.setLayout(layOut);
        final TextField tfNumberA = new TextField();
        tfNumberA.setSize(new Dimension(100, 10));
        final TextField tfNumberB = new TextField();
        tfNumberB.setPreferredSize(new Dimension(200, 50));

        f.add(tfNumberA);
        f.add(tfNumberB);
        Button bttn = new Button("Calculate");
        f.add(bttn);
        final Label labelRezultat = new Label("Rezult: ");
        f.add(labelRezultat);
        bttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RequestProcessor processor = new RequestProcessor(6666);
                try {
                    labelRezultat.setText(String.valueOf(processor.add(Double.parseDouble(tfNumberA.getText()), Double.parseDouble(tfNumberB.getText()))));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Connection to the server could not be established.");
                } catch(NumberFormatException | NullPointerException numberProblem) {
                    JOptionPane.showMessageDialog(null, "Invalid numbers.");
                }
            }
        });
        f.setSize(new Dimension(250, 250));
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setBackground (Color.GREEN);
        
        
        f.addWindowListener(new WindowAdapter()
   {
         @Override
         public void windowClosing(WindowEvent we){
         System.exit(0);
         }
   });
    }
}
