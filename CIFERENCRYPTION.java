import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


class  cifer_encrypt implements ActionListener
{
    JFrame frame,rframe,select_the_mode_frame;
    JLabel l1,l2,l3;
    JTextField field;
    JButton but1,but2,but3;
    JButton rbut1,rbut2,rbut3;
    JButton b,b1;//select,enter
    JButton select_the_text_but3;
    Font myFont = new Font("CALIBRI",Font.BOLD,16);
    String send,encrypt,recieve;
    Cipher desCipher;
    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	SecretKey myDesKey;
    byte[] textEncrypted;
    byte[] textDecrypted;
    String key1,key2;
    public static String convertSecretKeyToString(SecretKey secretKey) 
	 {
        byte[] rawData = secretKey.getEncoded();
        String encodedKey = Base64.getEncoder().encodeToString(rawData);
        return encodedKey;
    }
	public static SecretKey convertStringToSecretKeyto(String encodedKey)
    {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		System.out.println(decodedKey.length);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
		System.out.println(encodedKey);
        return (originalKey);
    }
    cifer_encrypt() throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        desCipher = Cipher.getInstance("DES");
        select_the_mode_of_txt();
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
    void myframe()
    {
        frame = new JFrame("Cifer_self_key");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.setVisible(true);
    
    }
    void select_the_text() throws IOException
    {
        JFileChooser op = new JFileChooser();
        int r = op.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION)
        {
            Path fileName = Path.of(op.getSelectedFile().getAbsolutePath());
            String str = Files.readString(fileName);
           // System.out.println(str);
            send=str;
            frame = new JFrame("CIFER ENCRYPTION");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(350,200);
            frame.setVisible(true);
            l1=new JLabel("TEXT : "+send);
            l1.setBounds(23, 23, 500, 30);
            //System.out.println("kkfgd");
            byte[] text = send.getBytes();
            myDesKey = keygenerator.generateKey();
            try
            {
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			textEncrypted = desCipher.doFinal(text);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
           
            key1 = convertSecretKeyToString(myDesKey);
            System.out.println(key1);
            l2=new JLabel("key : "+ key1);
            
            l2.setBounds(23, 56, 500, 30);
            but1 =new JButton("Submit");
            but1.setFocusable(false);
            but1.setBounds(35, 130, 75, 25);
        
            select_the_text_but3 =new JButton("Cancel");
            select_the_text_but3.setFocusable(false);
            select_the_text_but3.setBounds(230, 130, 75, 25);
        
            l1.setFont(myFont);
            l2.setFont(myFont);
        
        
            frame.add(l1);
            frame.add(l2);
        
            frame.add(but1);
            frame.add(select_the_text_but3);
    
                
            but1.addActionListener(this);
            select_the_text_but3.addActionListener(this);

        }
        else
        {
            select_the_mode_frame.dispose();
            select_the_mode_of_txt();
         
        }
    }
    void cifer_self_key_sender()
    {
        myframe();

        l1=new JLabel("TEXT : ");
        l1.setBounds(23, 23, 500, 30);
        
        field =new JTextField();
        field.setBounds(73, 25, 80, 25);

        l2 = new JLabel();
        l2.setBounds(23, 56, 500, 30);
    
        l3=new JLabel();
        l3.setBounds(23, 90, 900, 30);
    
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
        
        but1.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);

    }
    void cifer_self_key_reciever()
    {
        rframe = new JFrame("Cifer_self_key");
        rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rframe.setLayout(null);
        rframe.setSize(350,200);
        rframe.setVisible(true);

        l2 = new JLabel("Enter key: ");
        l2.setBounds(23, 56, 500, 30);

        l3=new JLabel();
        l3.setBounds(23, 90, 500, 30);

        field =new JTextField();
        field.setBounds(103, 58, 100, 25);

        rbut1 =new JButton("Submit");
        rbut1.setFocusable(false);
        rbut1.setBounds(35, 130, 75, 25);

        rbut3 =new JButton("Exit");
        rbut3.setFocusable(false);
        rbut3.setBounds(230, 130, 75, 25);

        l2.setFont(myFont);
        l3.setFont(myFont);

        rframe.add(l2);
        rframe.add(l3);

        rframe.add(field);

        rframe.add(rbut1);

        rframe.add(rbut3);

        rbut1.addActionListener(this);
        rbut3.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==but2)
        {
            send=field.getText();
            byte[] text = send.getBytes();
            myDesKey = keygenerator.generateKey();
            try
            {
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			textEncrypted = desCipher.doFinal(text);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
           
            key1 = convertSecretKeyToString(myDesKey);
            l2.setText("key : "+ key1 );
            //l3.setText(new String(textEncrypted));
            //System.out.println("ahcbsd");//ok
        }

        if(e.getSource()==but1)
        {
            cifer_self_key_reciever();
        }
        if(e.getSource()==rbut1)
        {
            key2 =field.getText();
            System.out.println(key1);
            System.out.println(key2);
            System.out.println("fgs");
                try
                {
                desCipher.init(Cipher.DECRYPT_MODE, convertStringToSecretKeyto(key2));
                textDecrypted = desCipher.doFinal(textEncrypted);
                l3.setText("Decrypted text : "+ new String(  textDecrypted));
                }
                catch(Exception e3)
                {

                    JOptionPane.showMessageDialog(frame, "Wrong key entered");
                    rframe.dispose();
                    cifer_self_key_reciever();

                }

        }
        if(e.getSource()==b)
        {
            try
             {
                select_the_text();
            } catch (IOException e1) 
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource()==b1)
        {
            cifer_self_key_sender();
        }
        if(e.getSource()==but3)
        {
            frame.dispose();
            select_the_mode_frame.dispose();
            select_the_mode_of_txt();
        }
        if(e.getSource()==select_the_text_but3)
        {
            frame.dispose();
            select_the_mode_frame.dispose();
            select_the_mode_of_txt();

        }
        if(e.getSource()==rbut3)
        {
            rframe.dispose();
            frame.dispose();
            select_the_mode_frame.dispose();
            new encrypt();

        }


        
    }
}

public class CIFERENCRYPTION
 {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        new cifer_encrypt();
    }
}