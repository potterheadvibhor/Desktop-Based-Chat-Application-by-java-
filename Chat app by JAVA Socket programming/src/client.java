import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class client  implements ActionListener
{
   static JFrame j_f=new JFrame();
    static DataOutputStream dos;
JPanel JP;
static JPanel CP;
   JLabel back,profilerpic,video,phone,dot,name;
   JTextField message;
   JButton send;
     static Box vertical=Box.createVerticalBox();
    Color c=new Color(7, 94, 84);
     static Color c1=new Color(152,251,152);
    Font f=new Font("Arial Black",Font.BOLD,15);
    Font f1=new Font("Arial Black",Font.ROMAN_BASELINE,16);
    Font f2=new Font("Arial Black",Font.ITALIC,10);
    Font f3=new Font("Arial Black",Font.ITALIC,13);
client()
{
   
   j_f. setLayout(null);

JP=new JPanel();
JP.setBounds(0, 0, 451, 70); 
JP.setBackground(c);
JP.setForeground(Color.WHITE);
JP.setLayout(null);
j_f.add(JP);    

ImageIcon  i1=new ImageIcon("3.png");
Image i11=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
ImageIcon  i111=new ImageIcon(i11);
back=new JLabel(i111);
back.setBounds(5,20,25,25);
JP.add(back);

back.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent ae)
{
System.exit(0);
}
});

ImageIcon  i2=new ImageIcon("bunty.png");
Image i22=i2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
ImageIcon  i222=new ImageIcon(i22);
profilerpic=new JLabel(i222);
profilerpic.setBounds(40,10,50,50);
JP.add(profilerpic);

name=new JLabel("Bunty");
name.setBounds(100,15,100,30);
name.setFont(f);
name.setForeground(Color.WHITE);
JP.add(name);
name=new JLabel("Active now");
name.setBounds(100,35,100,30);
name.setFont(f2);
name.setForeground(Color.WHITE);
JP.add(name);

ImageIcon  i3=new ImageIcon("video.png");
Image i33=i3.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
ImageIcon  i333=new ImageIcon(i33);
video=new JLabel(i333);
video.setBounds(300,20,30,30);
JP.add(video);


ImageIcon  i5=new ImageIcon("phone.png");
Image i55=i5.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);
ImageIcon  i555=new ImageIcon(i55);
phone=new JLabel(i555);
phone.setBounds(345,20,35,30);
JP.add(phone);

ImageIcon  i4=new ImageIcon("dot.png");
Image i44=i4.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
ImageIcon  i444=new ImageIcon(i44);
dot=new JLabel(i444);
dot.setBounds(400,20,10,25);
JP.add(dot);

CP=new JPanel();
CP.setBounds(5, 75, 440, 570); 
j_f.add(CP);

message =new JTextField("Message");
message.setBounds(5, 655, 310, 40);
message.setFont(f1);
message.setBackground(Color.WHITE);
message.setForeground(Color.BLACK);
j_f.add(message);
message.addKeyListener(new KeyAdapter()
{
public void keyPressed(KeyEvent e)
{
    if(message.getText().equals("Message"))
    {
message.setText("");
    }
}
public void keyReleased(KeyEvent e)
{
    if(message.getText().trim().equals(""))
    {
message.setText("Message");
    }
}
});

send=new JButton("Send");
send.setBounds(320, 655, 115, 40);
send.setFont(f3);
send.setBackground(c);
send.setForeground(Color.WHITE);
send.setBorderPainted(false);
j_f.add(send);
send.addActionListener(this);
    
    j_f.setTitle("Bunty");
    j_f.setBounds(600,60, 450, 735);
    j_f.setResizable(false);
    j_f.getContentPane().setBackground(Color.WHITE);
j_f.setDefaultCloseOperation(j_f.EXIT_ON_CLOSE);
//setUndecorated(true);


j_f.setVisible(true);
}

public void  actionPerformed(ActionEvent e)
{
    try{
    String s1=message.getText();
    if(!s1.equals("Message"))
    {
       
        JPanel p2= formatLabel(s1);

       CP.setLayout(new BorderLayout());

       JPanel right=new JPanel(new BorderLayout());
       right.add(p2,BorderLayout.LINE_END);
       vertical.add(right);
       vertical.add(Box.createVerticalStrut(15));
       CP.add(vertical,BorderLayout.PAGE_START);

       dos.writeUTF(s1);

       j_f.repaint();
      j_f. invalidate();
      j_f. validate();
       
message.setText("Message");
}
    }
    catch(Exception exc)
    {
        exc.printStackTrace();
    }
}
public static JPanel formatLabel(String s1)
{
   
  
    Font f3=new Font("Tahom",Font.PLAIN,16);
JPanel panel=new JPanel();
panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

JLabel output=new JLabel("<html><p style=\"width: 150px\">"+s1);//+"</p></html>");
output.setFont(f3);
output.setBackground(c1);
output.setOpaque(true);
output.setBorder(new EmptyBorder(10, 10, 10, 15));
panel.add(output);

 Calendar cal=Calendar.getInstance();
 SimpleDateFormat sdf=new SimpleDateFormat("HH:MM");

 JLabel time =new JLabel();
 time.setText(sdf.format(cal.getTime()));

 panel.add(time);

return panel;



}
public static void main(String []args)
{
new client();

 
try
{
    Socket s=new Socket("localhost",69);
   
   
    DataInputStream dis=new DataInputStream(s.getInputStream());
    dos=new DataOutputStream(s.getOutputStream());
    while(true)
    {
        CP.setLayout(new BorderLayout());
        String msg=dis.readUTF();
        JPanel panel=formatLabel(msg);

        JPanel left =new JPanel(new BorderLayout());
        left.add(panel,BorderLayout.LINE_START);
        vertical.add(left);
        vertical.add(Box.createVerticalStrut(15));
        CP.add(vertical, BorderLayout.PAGE_START);
        j_f.validate();
    }
    

}
catch(Exception exc)
{
exc.printStackTrace();
}

}
    
}
