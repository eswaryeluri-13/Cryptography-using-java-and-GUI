import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
class encrypt implements ActionListener
{
    JFrame frame;
    JButton cifer,ligma,sim_en,ran ;
    encrypt()
    {

        frame = new JFrame("ENCRYPT");
        frame.setSize(500,350);
       // frame.setResizable(false);
        JLabel txt1 = new JLabel("SET THE ENCRYPTION METHOD: ");
        txt1.setBounds(160, 10, 400, 30);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        cifer = new JButton("Cifer en");
        cifer.setBounds(20, 50,150,40);
        cifer.setFocusable(false);
        cifer.addActionListener(this);

        ligma = new JButton("Vigenere");
        ligma.setBounds(20, 120,150,40);
        ligma.setFocusable(false);
        ligma.addActionListener(this);

        sim_en = new JButton("Simple Encryption");
        sim_en.setBounds(270, 50,150,40);
        sim_en.setFocusable(false);
        sim_en.addActionListener(this);

        ran = new JButton("Random");
        ran.setBounds(20, 200,150,40);
        ran.setFocusable(false);
        ran.addActionListener(this);

        frame.setResizable(false);
        frame.add(cifer);
        frame.add(ligma);
        frame.add(sim_en);
        frame.add(ran);
        frame.add(txt1);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==cifer)
        {
            try 
            {
                new cifer_encrypt();
                frame.dispose();
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e1) 
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource()==sim_en)
        {
            new simple_encryption_gui();
            frame.dispose();
        }
        if(e.getSource()==ligma)
        {
            new vigenere_en();
            frame.dispose();
        }
        if(e.getSource()==ran)
        {
            Random random = new Random();
            int r  = random.nextInt(2);
            r=r+1;
            switch(r)
            {
                case 1:{
                    try 
                    {
                        new cifer_encrypt();
                        frame.dispose();
                        JOptionPane.showMessageDialog(frame, "cifer techinique");
                    } catch (NoSuchAlgorithmException | NoSuchPaddingException e1) 
                    {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                      }break;
                case 2:{ new simple_encryption_gui();
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame, "simple encryption");}break;
                case 3:{ new vigenere_en();
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame, "vigenere encryption");}break;
                default :{}break;

            }


        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
public class proj 
{
    public static void main(String args[])
    {
        new encrypt();
    }
}