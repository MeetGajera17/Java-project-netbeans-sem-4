
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton bt1, bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;
    Login()
    {
        // creating the main frame!
        f=new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        //creating the login label which is added to the frame
        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        
        //adding image to l1 label
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icons/1.jpg"));
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);
        
        //adding login label to frame
        f.add(l1);
        
        // creating username label
        l2 = new JLabel("Username");
        l2.setBounds(120, 120 , 150 , 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        //adding username label to l1
        l1.add(l2);
        
        //creating another small login account label and adding to l1 label
        l3 = new JLabel("Login Account");
        l3.setBounds(190, 30 , 500 , 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l1.add(l3);
        
        // creating password label
        l4 = new JLabel("Password");
        l4.setBounds(120, 170 , 150 , 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        //adding password label to l1
        l1.add(l4);
        
        // creating a text filed to enter username and adding it to label 1
        tf = new JTextField();
        tf.setBounds(320,120,150,30);
        l1.add(tf);
        
        // creating a password field to enter password and adding it to label 1
        pf = new JPasswordField();
        pf.setBounds(320,170,150,30);
        l1.add(pf);
        
        // creating login button and adding it to label 1
        bt1 = new JButton("login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        bt1.setBounds(120, 220, 150, 40);
        l1.add(bt1);
        
        // creating sing up button and adding it to label 1
        bt2 = new JButton("Sign up");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(320, 220, 150, 40);
        l1.add(bt2);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
        try {
            String username = tf.getText();
            String password = pf.getText();
            
            ConnectionClass c = new ConnectionClass();
            String query = "select * from singup where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.stm.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                //new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } 
        catch(Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
