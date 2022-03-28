import java.awt.*;
import java.awt.event.*;


class mobileNumberLenMismatch extends Exception{
    private int len;
    mobileNumberLenMismatch(int a){
        len = a;
    }
    public String show(){
        return "mobileNumberLenMismatch[" + len +"]";
    }
}

class emptyFirstName extends Exception{
    public String show(){
        return "emptyFirstName[ no first name ]";
    }
}

class invalidEmailId extends Exception{
    private String sub;
    invalidEmailId(String a){
        sub = a;
    }
    public String show(){
        return "invalidEmailId[" + sub +"]";
    }
}

class RegForm{
    Frame f = new Frame();
    Label l1 = new Label("First Name:");
    Label l2 = new Label("Last Name:");
    Label l3 = new Label("Email:");
    Label l4 = new Label("Phone:");
    Label l5 = new Label("REGISTER", Label.CENTER);
    Label l7 = new Label("*Enter valid email-id");
    Label l6 = new Label("*Mandatory");
    Label l8 = new Label("*Enter valid 10 digit mobile number");
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    Button b1 = new Button("Submit");
    Button b2 = new Button("Clear");
    RegForm(){
        f.setTitle("Registration Form");
        f.setSize(1000,1000);
        f.setVisible(true);
        f.setLayout(null);
        f.setBackground(Color.decode("#CDDEFF"));
        Font f1 = new Font("SansSerif", Font.BOLD, 33);
        Font f2 = new Font("SansSerif",0, 25);
        Font f3 = new Font("Montserrat", 0 , 30);
        Font f4 = new Font("Montserrat", Font.BOLD , 60);
        Font f5 = new Font("SanSerif", 0, 20);
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
        f.add(b1);
        f.add(b2);
        b1.setBounds(290,720,150,60);
        b2.setBounds(530,720,150,60);
        b1.setFont(f2);
        b2.setFont(f2);

        f.add(l6);
        l6.setBounds(370, 363, 200, 40);
        l6.setForeground(Color.decode("#DA1212"));
        l6.setFont(f5);
        l6.setVisible(false);
        f.add(l7);
        l7.setBounds(370, 563, 200, 40);
        l7.setForeground(Color.decode("#DA1212"));
        l7.setFont(f5);
        l7.setVisible(false);
        f.add(l8);
        l8.setBounds(370, 663, 330, 40);
        l8.setForeground(Color.decode("#DA1212"));
        l8.setFont(f5);
        l8.setVisible(false);

        t4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
                  t4.setEditable(true);
                  l8.setVisible(false);
               } else {
                  t4.setEditable(false);
                  l8.setVisible(true);
               }
            }
         });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int ret = checkDetails();
                System.out.println(ret);
                if(ret==1){
                    System.exit(0);
                }
            }
        });
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                System.exit(0);
            }    
        });

    }
    public int checkDetails(){
        String ts1 = t1.getText().toString();
        String ts3 = t3.getText().toString();
        String ts4 = t4.getText().toString();
        int flag = 1;
        try{
            if(ts1.length()==0){
                flag = 0; 
                System.out.println("set flag to 0 in ts1");
                throw new emptyFirstName();
            }
        }
        catch(emptyFirstName e){
            l6.setVisible(true);
        }
        try{
            int rIndex = ts3.length();
            int lIndex = rIndex - 10;
            // String sub = ts3.substring(lIndex,rIndex);
            String req = "@gmail.com";
            if(ts3.length()==0 || lIndex<0){
                flag = 0; 
                String sub = "";
                throw new invalidEmailId(sub);
            }
            else if((ts3.substring(lIndex, rIndex)).equals(req)==false){
                flag = 0; 
                String sub = ts3.substring(lIndex,rIndex);
                throw new invalidEmailId(sub);
            }
        }
        catch(invalidEmailId e){
            l7.setVisible(true);
        }
        try{
            if(ts4.length()!=10){
                flag = 0; 
                System.out.println("set flag to 0 in ts5");
                throw new mobileNumberLenMismatch(ts4.length());
            }
        }
        catch (mobileNumberLenMismatch e){
            l8.setVisible(true);
        }
        return flag;
    }
}
public class sample {
    public static void main(String[] args){
        RegForm r1 = new RegForm();
    }
}
