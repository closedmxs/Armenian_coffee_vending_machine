package gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;

/** * This class demonstrates how to load an Image from an external file */

public class CoffeeMachineApp extends Component {
    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public CoffeeMachineApp() {
        try {
            File file = new File("src/gui/img/background.png");
            System.out.println("Looking for: " + file.getAbsolutePath());
            img = ImageIO.read(file);
            if (img == null) {
                System.out.println("Image is NULL (unsupported format?)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    } public static void main(String[] args) {
        JFrame f = new JFrame("Armenian Coffee ");
        ImageIcon icon = new ImageIcon("src/gui/img/flag.png");
        f.setIconImage(icon.getImage());

        JButton menu = new JButton();
        menu.setBounds(0, 195, 260, 190);
        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.addActionListener(e -> {
            JFrame menuFrame = new JFrame("Armenian Coffee - Menu");
            menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuFrame.add(new MainMenu());
            menuFrame.pack();
            menuFrame.setLocationRelativeTo(f);
            menuFrame.setVisible(true);
        });

        JButton drink = new JButton();
        drink.setBounds(0,395,260,125);
        drink.setOpaque(false);
        drink.setContentAreaFilled(false);
        drink.setBorderPainted(true);
        drink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton payement = new JButton();
        payement.setBounds(270, 150, 45, 40);
        payement.setOpaque(false);
        payement.setContentAreaFilled(false);
        payement.setBorderPainted(false);
        payement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        payement.addActionListener(e -> {
            JFrame paymentFrame = new JFrame("Armenian Coffee - Payment");
            paymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            paymentFrame.add(new PaymentMenu());
            paymentFrame.pack();
            paymentFrame.setLocationRelativeTo(f);
            paymentFrame.setVisible(true);
        });

        JButton charge = new JButton();
        charge.setBounds(270,490,45,40);
        charge.setOpaque(false);
        charge.setContentAreaFilled(false);
        charge.setBorderPainted(true);
        charge.setCursor(new Cursor(Cursor.HAND_CURSOR));

        f.add(menu);
        f.add(drink);
        f.add(payement);
        f.add(charge);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } });
        String[] sounds = {"1.wav", "2.wav"};
        String fileName = sounds[new Random().nextInt(sounds.length)];
        SoundPlayer.playWav("src/gui/music/"+fileName);

        f.add(new CoffeeMachineApp());
        f.pack();
        f.setVisible(true);
    }
}