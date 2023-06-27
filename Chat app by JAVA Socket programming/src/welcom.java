import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class welcom extends JFrame implements ActionListener
{
        Font f=new Font("Arial Black",Font.BOLD,15);
    JButton login;
    welcom()
    {
setLayout(null);
       JPanel JP=new JPanel();
JP.setBounds(0, 0, 600, 400); 
JP.setLayout(null);
add(JP);   

ImageIcon  i1=new ImageIcon("watsaap.jpg");
Image i11=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
ImageIcon  i111=new ImageIcon(i11);
JLabel back=new JLabel(i111);
back.setBounds(0,0,600,400);
JP.add(back);

login=new JButton("Start");
login.setBounds(245,315,100,25);
login.setFont(f);
login.setBackground(Color.black);
login.setForeground(Color.white);
login.setBorderPainted(false);
back.add(login);
login.addActionListener(this);

        
        setBounds(400,100,600,400);
setVisible(true);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        new server();
        new client();
        dispose();

    }
    public static void main(String []args)
    {
        new welcom();
    }
}