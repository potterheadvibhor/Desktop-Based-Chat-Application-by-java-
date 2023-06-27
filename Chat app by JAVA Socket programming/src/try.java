import javax.swing.*;
import java.awt.*;
class server extends JFrame
{
    JPanel JP;
    ImageIcon gaitonde;
    Image gaiton;
    JLabel profilepic;
    Color c=new Color(7, 94, 84);
server()
{
    setVisible(true);
    setLayout(null);
    setBounds(100,100, 450, 700);
    setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

JP=new JPanel();
JP.setBounds(0, 0, 450, 70); 
JP.setBackground(c);
JP.setLayout(null);
add(JP);    

// gaitonde=new ImageIcon("arrow.png");
// gaiton=gaitonde.getImage();
// gaiton=gaiton.getScaledInstance(20,20 , java.awt.Image.SCALE_SMOOTH);
// gaitonde=new ImageIcon(gaiton);
// profilepic = new JLabel(gaitonde);
// profilepic.setBounds(20,200,100,100);
// JP.add(profilepic);

}
public static void main(String []args)
{
new server();
}
    
}
