import java.awt.*;
import java.awt.event.*;

class reg_form{
    public static void main(String [] args){
        Frame f = new Frame();
        f.setTitle("Registration Form");
        f.setSize(1000,1000);
        f.setVisible(true);
        f.setLayout(null);
        f.setBackground(Color.decode("#CDDEFF"));
        Font f1 = new Font("SansSerif", Font.BOLD, 33);
        Font f2 = new Font("SansSerif",0, 25);
        Font f3 = new Font("Montserrat", 0 , 30);
        Font f4 = new Font("Montserrat", Font.BOLD , 60);
        Label l5 = new Label("REGISTER", Label.CENTER);
        Label l1 = new Label("First Name:");
        Label l2 = new Label("Last Name:");
        Label l3 = new Label("Email:");
        Label l4 = new Label("Phone:");
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        l1.setBounds(150, 300, 200, 60);
        l2.setBounds(150, 400, 200, 60);
        l3.setBounds(150, 500, 200, 60);
        l4.setBounds(150, 600, 200, 60);
        l5.setBounds(350, 150, 310, 80);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l1.setFont(f1);
        l5.setFont(f4);
        l5.setForeground(Color.decode("#FF5959"));
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        t1.setBounds(370,300,450,60);
        t2.setBounds(370,400,450,60);
        t3.setBounds(370,500,450,60);
        t4.setBounds(370,600,450,60);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        t1.setFont(f3);
        t2.setFont(f3);
        t3.setFont(f3);
        t4.setFont(f3);
        Button b1 = new Button("Submit");
        Button b2 = new Button("Clear");
        f.add(b1);
        f.add(b2);
        b1.setBounds(290,720,150,60);
        b2.setBounds(530,720,150,60);
        b1.setFont(f2);
        b2.setFont(f2);
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                System.exit(0);
            }    
        });    
    }
}