package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaymentMenu extends JPanel {
    private BufferedImage img;

    public PaymentMenu() {
        try {
            img = ImageIO.read(new File("src/gui/img/paymentmenu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Armenian Coffee");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new PaymentMenu());

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}