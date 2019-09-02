package Citadel2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import static Citadel2.DataMap.DaneMapy;

public class KeyTest extends JFrame implements KeyListener {

    int x = 50;
    int y = 50;
    int xp = x + 40;
    int yp = y + 45;
    int marker = 0;
    int marker2 = 0;
    int guySpeed =5;
    int bSpeed = 55;
  int mapka = DaneMapy[0];
    int offsetx = 0;
    int offsety = 0;

    public KeyTest() {
        super("Okno testowe");
        setPreferredSize(new Dimension(800, 480));
        addKeyListener(this);

        JPanel obrazpanel = new ObrazPanel();
        add(obrazpanel);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Step(obrazpanel);
    }

    //   Testowanie wcisnietego klawisza i korekta koordynacji
    public void keyPressed(KeyEvent evt) {
        int k = evt.getKeyCode();

        if (k == KeyEvent.VK_RIGHT) {
           if(x<=300){ x = x + guySpeed;} else {offsetx=offsetx-3;};
            xp = xp + 5;
            marker2 = 1;
        }
        if (k == KeyEvent.VK_LEFT) {
            if (x>=40){x = x - guySpeed;} else {offsetx=offsetx+3;};
            yp = yp + 5;
            marker2 = 1;
        }
        if (k == KeyEvent.VK_UP) {
            y = y - guySpeed;
            yp = yp - 5;
            marker2 = 1;
        }
        if (k == KeyEvent.VK_DOWN) {
            y = y + guySpeed;
            yp = yp + 5;
            marker2 = 1;
        }
        if (k == 32) {
            xp = xp + bSpeed;
            marker = 1;
            marker2 = 1;
        }

// Kontrolka wcisniecia do konsoli
        int cl = evt.getKeyCode();
        checkSecret(cl);
    }

    // Do uzycia pozniej
    public void keyReleased(KeyEvent evt) {

    }

    public void keyTyped(KeyEvent evt) {

    }
    // Wyswietl co wcisniete i wartosci koordynatow

    private void checkSecret(int c1) {
        System.out.println("Wcisnieto " + c1 + " Wartosc X : " + x + " Wartosc Y : " + y
                + " Wartosc XP: " + xp + " Wartosc YP: " + yp + " Mapka blok " +mapka );
    }

    private BufferedImage image;

    public class ObrazPanel extends JPanel {
        private BufferedImage image, image1, image2, image3, b1, b2, b3, b4, b5, b6, block;

        public ObrazPanel() {

            super();
            File imageFile = new File("guy.png");
            File imageFile1 = new File("background.jpg");
            File imageFile2 = new File("guy1.png");
            File imageFile3 = new File("bullet.bmp");
            File block1 = new File("b1.png");
            File block2 = new File("b2.png");
            File block3 = new File("b3.png");
            File block4 = new File("b4.png");
            File block5 = new File("b5.png");
            File block6 = new File("b6.png");


            try {
                image = ImageIO.read(imageFile);
                image1 = ImageIO.read(imageFile1);
                image2 = ImageIO.read(imageFile2);
                image3 = ImageIO.read(imageFile3);
                b1 = ImageIO.read(block1);
                b2 = ImageIO.read(block2);
                b3 = ImageIO.read(block3);
                b4 = ImageIO.read(block4);
                b5 = ImageIO.read(block5);
                b6 = ImageIO.read(block6);


            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;


            g2d.clearRect(x, y, image.getWidth(), image.getHeight());

            //Ponizej background

           for (int t = 0; t <= 25; t++) {

               int mapka = DaneMapy[t];
               if (mapka == 1) {
                   block = b1;
               }
               if (mapka == 2) {
                   block = b2;
               }
               if (mapka == 3) {
                   block = b3;
               }
               if (mapka == 4) {
                   block = b4;
               }
               if (mapka == 5) {
                   block = b5;
               }
               if (mapka == 6) {
                   block = b6;
               }

               g2d.drawImage(block, offsetx + (t * 64), offsety, block.getWidth(), block.getHeight(), this);

           }
            for (int t = 0; t <= 25; t++) {

                int mapka = DaneMapy[t+24];
                if (mapka == 1) {
                    block = b1;
                }
                if (mapka == 2) {
                    block = b2;
                }
                if (mapka == 3) {
                    block = b3;
                }
                if (mapka == 4) {
                    block = b4;
                }
                if (mapka == 5) {
                    block = b5;
                }
                if (mapka == 6) {
                    block = b6;
                }


               g2d.drawImage(block, offsetx+(t*64), 64, block.getWidth(), block.getHeight(), this);
          }            ;

            for (int t = 0; t <= 25; t++) {

                int mapka = DaneMapy[t+49];
                if (mapka == 1) {
                    block = b1;
                }
                if (mapka == 2) {
                    block = b2;
                }
                if (mapka == 3) {
                    block = b3;
                }
                if (mapka == 4) {
                    block = b4;
                }
                if (mapka == 5) {
                    block = b5;
                }
                if (mapka == 6) {
                    block = b6;
                }


                g2d.drawImage(block, offsetx+(t*64), 128, block.getWidth(), block.getHeight(), this);
            } ;

            for (int t = 0; t <= 25; t++) {

                int mapka = DaneMapy[t+74];
                if (mapka == 1) {
                    block = b1;
                }
                if (mapka == 2) {
                    block = b2;
                }
                if (mapka == 3) {
                    block = b3;
                }
                if (mapka == 4) {
                    block = b4;
                }
                if (mapka == 5) {
                    block = b5;
                }
                if (mapka == 6) {
                    block = b6;
                }


                g2d.drawImage(block, offsetx+(t*64), 192, block.getWidth(), block.getHeight(), this);
            } ;



              g2d.drawImage(image, x, y, this);

            if (marker2 == 1) {
                g2d.drawImage(image2, x, y, this);

            } else {
                g2d.drawImage(image, x, y, this);
            }

            if (marker == 1) {
                if (xp <= 800) {
                    xp = xp + bSpeed;
                    g2d.drawImage(image3, xp, yp, this);
                    marker2 = 0;
                } else {
                    xp = x + 40;
                    yp = y + 45;
                    marker = 0;
                    marker2 = 0;
                }
            } else {

                g2d.drawImage(image, x, y, this);
            }

            if (marker2 == 1) {
                g2d.drawImage(image2, x, y, this);
                marker2 = 0;
            }
            marker2 = 0;

        }
    }

    public static void main(String[] args) {
        new JPanel();
    }
}

