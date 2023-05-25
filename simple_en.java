import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class simple_encryption_gui extends JFrame implements ActionListener
{
    JFrame frame,select_the_mode_frame;
    JLabel l1,l2,l3;
    JMenuBar bar;
    JTextField field;
    JButton but1,but2,but3;
    JButton b,b1;//select,enter
    JButton rbut1,rbut3;//reciever side
    JButton select_the_text_but3;
    Font myFont = new Font("CALIBRI",Font.BOLD,16);
    String send,encrypt,recieve;
    int key,rkey;

    String sender(String input,int key)
    {
     StringBuilder input1 = new StringBuilder(input);
     input1.reverse();
     String s= new String(input1);
     char a[] = s.toCharArray();
     for(int i=0;i<=s.length()-1;i++)
        {
            a[i]+=key;
        }
        System.out.println(key);
     return new String(a);

    }
    String reciever(String to_decrypt,int decrypt_key)
    {
     StringBuilder input2 = new StringBuilder(to_decrypt);
     input2.reverse();
     String s= new String(input2);

     char a[] = s.toCharArray();
     for(int i=0;i<=s.length()-1;i++)
        {
            a[i]-=key;
        }
     return new String(a);

    }
    void reciever_side_frame()
    {
        frame = new JFrame("DECRYPTOIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.setVisible(true);

        l1=new JLabel("Encrypt message : "+encrypt);
        l1.setBounds(23, 23, 300, 30);

        l2 = new JLabel("Enter key: ");
        l2.setBounds(23, 56, 500, 30);
        
        l3=new JLabel();
        l3.setBounds(23, 90, 500, 30);


        field =new JTextField();
        field.setBounds(103, 58, 40, 25);

        rbut1 =new JButton("Submit");
        rbut1.setFocusable(false);
        rbut1.setBounds(35, 130, 75, 25);
    
        
        rbut3 =new JButton("Exittt");
        rbut3.setFocusable(false);
        rbut3.setBounds(230, 130, 75, 25);


        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);


        frame.add(l1);
        frame.add(l2);
        frame.add(l3);

        frame.add(field);

        frame.add(rbut1);
        frame.add(rbut3);

        rbut1.addActionListener(this);
        rbut3.addActionListener(this);

    }
    void select_the_text() throws IOException
    {
        JFileChooser op = new JFileChooser();
        int r = op.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION)
        {
            Path fileName = Path.of(op.getSelectedFile().getAbsolutePath());
            String str = Files.readString(fileName);
            System.out.println(str);
            send=str;
            frame = new JFrame("SIMPLE ENCRYPTOIN");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(350,200);
            frame.setVisible(true);
            l1=new JLabel("TEXT : "+send);
            l1.setBounds(23, 23, 500, 30);
            Random random = new Random();
            key  = random.nextInt(50);
    
            l2 = new JLabel();
            l2.setBounds(23, 56, 500, 30);
            
            l3=new JLabel();
            l3.setBounds(23, 90, 500, 30);
    
            but1 =new JButton("Submit");
            but1.setFocusable(false);
            but1.setBounds(35, 130, 75, 25);
        
            select_the_text_but3 =new JButton("Cancel");
            select_the_text_but3.setFocusable(false);
            select_the_text_but3.setBounds(230, 130, 75, 25);
        
            l1.setFont(myFont);
            l2.setFont(myFont);
            l3.setFont(myFont);
        
        
            frame.add(l1);
            frame.add(l2);
            frame.add(l3);
        
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
    void enter_the_text()
    {
        frame = new JFrame("SIMPLE ENCRYPTOIN");
    //String n = JOptionPane.showInputDialog(null, "Enter your Text : ");
    //send=n;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(350,200);
    frame.setVisible(true);
    l1=new JLabel("TEXT : ");
    l1.setBounds(23, 23, 500, 30);
    
    field =new JTextField();
    field.setBounds(73, 25, 80, 25);
    
    Random random = new Random();
    key  = random.nextInt(50);
  //  l2=new JLabel("Key : "+key);
    l2 = new JLabel();
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
    
    but1.addActionListener(this);
    but2.addActionListener(this);
    but3.addActionListener(this);
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
    simple_encryption_gui()
    {
        select_the_mode_of_txt();
   }
@Override
public void actionPerformed(ActionEvent e) 
{
       if(e.getSource()==but1)
        {
           reciever_side_frame();
        }
       if(e.getSource()==but2)
       {
        send=field.getText();
        encrypt = sender(send,key);
        l2.setText("key "+ key);
        l3.setText("Encrypted text : "+encrypt);
       }
       if(e.getSource()==but3)
       {
    	   
       }
       if(e.getSource()==b1)
       {
        enter_the_text();
       }
       if(e.getSource()==b)
       {
        System.out.println("SXHJBKG");
        try 
        {
            select_the_text();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        encrypt = sender(send,key);
        l2.setText("key "+ key);
        l3.setText("Encrypted text : "+encrypt);


       }
       if(e.getSource()==rbut1)
       {
        System.out.println("1111");
        //String ab =  send=field.getText();
        rkey =Integer.valueOf(field.getText());
        if(rkey==key)
        {
            l3.setText("Decrypted text : "+reciever(encrypt, rkey));
            System.out.println(reciever(encrypt, rkey));
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Wrong key entered");

        }
         //rkey = parseInt(ab);
       }
       if(e.getSource()==rbut3)
       {
        System.out.println("cbgsd");
        frame.dispose();
         new encrypt();
       }
       if(e.getSource()==but3)
       {
        frame.dispose();
        select_the_mode_frame.dispose();
        select_the_mode_of_txt();
       }
    if(e.getSource()==select_the_text_but3)
    {
       
        select_the_mode_frame.dispose();
        select_the_mode_of_txt();
    }
}
}
public class simple_en
{
    public static void main(String args[])
    {
        new simple_encryption_gui();  
    }
}