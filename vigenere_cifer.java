import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class vigenere_en implements ActionListener
{
    JFrame frame,select_the_mode_frame;
    JLabel l1,l2,l3;
    JMenuBar bar;
    JTextField field,field1;
    JButton but1,but2,but3,nbut1,nbut2;
    JButton b,b1;//select,enter
    JButton rbut1,rbut3;//reciever side
    JButton select_the_text_but3;
    Font myFont = new Font("CALIBRI",Font.BOLD,16);
    String send,encrypt,recieve;
    String key,rkey,sss;
    String ekey,erkey;

boolean check_for_caps(String str)
{
    int i=0;
    for(i=0;i<=str.length()-1;i++)
    {
        if(str.charAt(i)<'A'||str.charAt(i)>'Z')
        {
            return false;
        }

    }
    return true;
}
String CipherText(String str, String s_key)
{
    String cipher_text="";
 
    for (int i = 0; i < str.length(); i++)
    {
        // converting in range 0-25
        int x = (str.charAt(i) + s_key.charAt(i)) %26;
 
        // convert into alphabets(ASCII)
        x += 'A';
 
        cipher_text+=(char)(x);
    }
    return cipher_text;
}
static String originalText(String cipher_text, String r_key)
{
    String orig_text="";
 
    for (int i = 0 ; i < cipher_text.length() &&
                            i < r_key.length(); i++)
    {
        // converting in range 0-25
        int x = (cipher_text.charAt(i) -
                    r_key.charAt(i) + 26) %26;
 
        // convert into alphabets(ASCII)
        x += 'A';
        orig_text+=(char)(x);
    }
    return orig_text;
}
String generateKey(String str, String s_key)
{
    int x = str.length();
 
    for (int i = 0; ; i++)
    {
        if (x == i)
            i = 0;
        if (s_key.length() == str.length())
            break;
        s_key+=(s_key.charAt(i));
    }
    return s_key;
}
void select_the_text() throws IOException
{
    JFileChooser op = new JFileChooser();
    int r = op.showOpenDialog(null);
    if (r == JFileChooser.APPROVE_OPTION)
    {
        select_the_mode_frame.dispose();;
        Path fileName = Path.of(op.getSelectedFile().getAbsolutePath());
        String str = Files.readString(fileName);
        System.out.println(str);
        send=str;
        frame = new JFrame("encryptoin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.setVisible(true);

        l1=new JLabel("TEXT : "+send);
        l1.setBounds(23, 23, 500, 30);
        l2 = new JLabel("key :");
        l2.setBounds(23, 56, 500, 30);
        l3=new JLabel();
        l3.setBounds(23, 90, 500, 30);


            nbut1 =new JButton("Submit");
            nbut1.setFocusable(false);
            nbut1.setBounds(35, 130, 75, 25);
        
            nbut2 =new JButton("Ok");
            nbut2.setFocusable(false);
            nbut2.setBounds(133, 130, 75, 25);
            

            select_the_text_but3 =new JButton("Cancel");
            select_the_text_but3.setFocusable(false);
            select_the_text_but3.setBounds(230, 130, 75, 25);
            field1 =new JTextField();
            field1.setBounds(73, 56, 80, 25);
            l1.setFont(myFont);
            l2.setFont(myFont);
            l3.setFont(myFont);

        
        
            frame.add(l1);
            frame.add(l2);
            frame.add(l3);
            frame.add(field1);
        
            frame.add(nbut1);
            frame.add(nbut2);
            frame.add(select_the_text_but3);

                
            nbut1.addActionListener(this);
            nbut2.addActionListener(this);
            select_the_text_but3.addActionListener(this);


    }
    else
    {
        select_the_mode_of_txt();
    }
}
    void select_the_mode_of_txt()
    {
        b = new JButton();
        b.setBounds(30, 90,120,50);
        b.addActionListener(this);
        b.setText("Select the file");
        b.setFocusable(false);
        b.setFont(new Font("Comic Sans",Font.BOLD,12));
               

        b1 = new JButton();
        b1.setBounds(250, 90,120,50);
        b1.addActionListener(this);
        b1.setText("Enter the text");
        b1.setFocusable(false);
        select_the_mode_frame = new JFrame("SELECT");
        select_the_mode_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        select_the_mode_frame.setLayout(null);
        select_the_mode_frame.setSize(430,300);
        select_the_mode_frame.setVisible(true);
        select_the_mode_frame.setBackground(Color.blue);
        select_the_mode_frame.add(b);
        select_the_mode_frame.add(b1);

    }
    void sender()
    {
    frame = new JFrame("VIGENERE ENCRYPTOIN");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(350,200);
    frame.setVisible(true);
    l1=new JLabel("TEXT : ");
    l1.setBounds(23, 23, 500, 30);
    
    field =new JTextField();
    field.setBounds(73, 25, 80, 25);
     
    field1 =new JTextField();
    field1.setBounds(73, 56, 80, 25);

    l2 = new JLabel("key : ");
    l2.setBounds(23, 56, 500, 30);

    l3=new JLabel();
    l3.setBounds(23, 90, 500, 30);

    but1 =new JButton("Submit");
    but1.setFocusable(false);
    but1.setBounds(35, 130, 75, 25);

    but2 =new JButton("Ok");
    but2.setFocusable(false);
    but2.setBounds(133, 130, 75, 25);
    
    but3 =new JButton("Cancel");
    but3.setFocusable(false);
    but3.setBounds(230, 130, 75, 25);

    l1.setFont(myFont);
    l2.setFont(myFont);
    l3.setFont(myFont);


    frame.add(l1);
    frame.add(l2);
    frame.add(l3);

    frame.add(but1);
    frame.add(but2);
    frame.add(but3);
    frame.add(field);
    frame.add(field1);

    
    but1.addActionListener(this);
    but2.addActionListener(this);
    but3.addActionListener(this);



    }
    void reciever()
    {
        frame = new JFrame("VIGENERE ENCRYPTOIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.setVisible(true);
        l1=new JLabel("ENCRYPTED TEXT : "+encrypt);

        l1.setBounds(23, 23, 500, 30);

        field1 =new JTextField();
        field1.setBounds(73, 56, 80, 25);

        l2 = new JLabel("key : ");
        l2.setBounds(23, 56, 500, 30);

        l3=new JLabel();
        l3.setBounds(23, 90, 500, 30);

        rbut1 =new JButton("Submit");
        rbut1.setFocusable(false);
        rbut1.setBounds(35, 130, 75, 25);

        rbut3 =new JButton("Exitt");
        rbut3.setFocusable(false);
        rbut3.setBounds(230, 130, 75, 25);

        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);

        
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);

        frame.add(field1);

        frame.add(rbut1);
        frame.add(rbut3);

        rbut1.addActionListener(this);
        rbut3.addActionListener(this);

    }
    vigenere_en()
    {
        select_the_mode_of_txt();
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()== select_the_text_but3)
        {
            frame.dispose();
            select_the_mode_of_txt();
        }
        if(e.getSource()==nbut1)
        {
            frame.dispose();
            reciever();
        }
        if(e.getSource()==nbut2)
        {
            key  = field1.getText();
            if(key.length()<=send.length() && check_for_caps(key) && check_for_caps(send))
            {
                ekey = generateKey(send,key);
                encrypt = CipherText(send, ekey);
                l3.setText("ENCYPTED TEXT : "+encrypt);   
                
            }
            else
            {
                String war = "key length must be less than text length\n only caps must be allowed in the texts\nTry again!!!";
                JOptionPane.showMessageDialog(frame, war);
                frame.dispose();
                try {
                    select_the_text();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        }
        if(e.getSource()==b)
        {
            try {
                select_the_text();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource()==b1)
        {
            sender();
        }
        if(e.getSource()==but2)
        {
            
            send=field.getText();
            key  = field1.getText();
            sss=key;
           System.out.println(check_for_caps(key));
           System.out.println(check_for_caps(send));
            if(key.length()<=send.length() && check_for_caps(key) && check_for_caps(send))
            {
                ekey = generateKey(send,key);
                String sendSekeyy;
                encrypt = CipherText(send, ekey);
                l3.setText("ENCYPTED TEXT : "+encrypt);
                
            }
            else
            {
                String war = "key length must be less than text length\n only caps must be allowed in the texts\nTry again!!!";
                JOptionPane.showMessageDialog(frame, war);
                frame.dispose();
                sender();
            }


        }
        if(e.getSource()==but1)
        {
            frame.dispose();
            reciever();
        }
        if(e.getSource()==rbut1)
        {
            rkey  = field1.getText();
            if(key.equals(rkey))
            {
                System.out.println("INSIDE");
                erkey = generateKey(send,rkey);
                recieve = originalText(encrypt, erkey);
                System.out.println(key+"  " +rkey);
                l3.setText("DECRYPTED TEXT :"+ recieve);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "INVALID KEY");
                frame.dispose();
                reciever();

            }
        }
        if(e.getSource()==rbut3)
        {
            frame.dispose();
            new encrypt();
        }

    }

}





public class vigenere_cifer
 {
    public static void main(String args[])
    {
        new vigenere_en();
    }
    
}