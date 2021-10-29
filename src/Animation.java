
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 *@author: Jose Soto
 */
public class Animation extends JPanel {

    static ArrayList<String> sucs;
    private int qAnim = 0;
    static int turn = 0;
    static int xc1t, yc1t, xc2t, yc2t;
    static int dTop = 724, iTop = 74, aTop = 97, bTop = 524;
    static int dirI = 1, dirD = 1;
    static int cabezaD, cabezaI, cantPases;
    private int punt, xnomU, xparSel, xPase, yM, puntU = 0, puntM = 0, datas = 0;
    private String nombreU;
    private String parejaSel;
    private String maquina1;
    private String maquina2;
    private String compl = "";
    private final Media media = new Media();
    private Table mesaJ;
    private int[] lind;
    private int ind, pxg, pyg;
    private MouseMotionListener e, eW;
    private MouseListener eW1, eW2;
    static int yco = 600;
    static int xco;
    private int ypr;
    private int y;
    private int xt1;
    private int yt1;
    private int xt2;
    private int yt2;
    private int xt3;
    private int yt3;
    private int xt4;
    private int yt4;
    private Graphics G;
    private Image I;
    Image present, mesa, tabla1, config;
    ArrayList<Card> fich, fichA, fichJ1, fichJ2;
    static ArrayList<Card> cD;
    static ArrayList<Card> cI;
    private static Card[] sobra;
    private final Color color;

    public Animation() {
        setSize(800, 600);
        setBackground(Color.BLACK);
        config = Objects.requireNonNull(Media.cIcon("parts/config.png")).getImage();
        present = Objects.requireNonNull(Media.cIcon("parts/present.jpg")).getImage();
        mesa = Objects.requireNonNull(Media.cIcon("parts/mesa.png")).getImage();
        tabla1 = Objects.requireNonNull(Media.cIcon("parts/tabla1.gif")).getImage();
        color = new Color(0, 0, 10, 190);
        Carga(1);


    }

    private char mOrientD(Card f, String or) {
        char ori = 'q';
        if (or.equals("ver")) {
            if (cabezaD == f.getV1()) {
                ori = 's';
                cabezaD = f.getV2();
            } else {
                ori = 'n';
                cabezaD = f.getV1();
            }
        } else {
            if (or.equals("horE")) {
                if (cabezaD == f.getV1()) {
                    ori = 'w';
                    cabezaD = f.getV2();
                } else {
                    ori = 'e';
                    cabezaD = f.getV1();
                }
            } else {
                if (or.equals("horW")) {
                    if (cabezaD == f.getV1()) {
                        ori = 'e';
                        cabezaD = f.getV2();
                    } else {
                        ori = 'w';
                        cabezaD = f.getV1();
                    }
                }
            }
        }
        return ori;
    }

    private char mOrientI(Card f, String or) {
        char ori = 'q';
        if (or.equals("ver")) {
            if (cabezaI == f.getV1()) {
                ori = 'n';
                cabezaI = f.getV2();
            } else {
                ori = 's';
                cabezaI = f.getV1();
            }
        } else {
            if (or.equals("horE")) {
                if (cabezaI == f.getV1()) {
                    ori = 'w';
                    cabezaI = f.getV2();
                } else {
                    ori = 'e';
                    cabezaI = f.getV1();
                }
            } else {
                if (or.equals("horW")) {
                    if (cabezaI == f.getV1()) {
                        ori = 'e';
                        cabezaI = f.getV2();
                    } else {
                        ori = 'w';
                        cabezaI = f.getV1();
                    }
                }
            }
        }
        return ori;
    }

    public void Carga(int i) {

        qAnim = 0;
        datas = 0;
        puntU = 0;
        puntM = 0;
        cantPases = 0;
        dirI = 1;
        dirD = 1;
        Table.xc1 = 362;
        Table.yc1 = 275;
        Table.xc2 = -75;
        Table.yc2 = 275;
        xc1t = -75;
        yc1t = -75;
        xc2t = -75;
        yc2t = -75;
        Table.x = (800 - 30) / 2;
        Table.y = (600 - 60) / 2 + 12;
        Table.x2 = (800 - 30) / 2;
        Table.y2 = (600 - 60) / 2 + 12;
        this.removeMouseListener(eW1);
        this.removeMouseListener(eW2);
        this.removeMouseMotionListener(eW);
        cI = new ArrayList<Card>();
        cD = new ArrayList<Card>();
        mesaJ = new Table();
        Table.creaPareja(i);
        mesaJ.daAgua();
        mesaJ.repartir();
        fich = Team.getU().getFichas();
        fichA = Team.getA().getFichas();
        fichJ1 = Team.getJ1().getFichas();
        fichJ2 = Team.getJ2().getFichas();
        sobra = mesaJ.getTf();
        nombreU = "";
        parejaSel = "";
        maquina1 = "";
        maquina2 = "";
        xPase = 850;
        xnomU = 800;
        xparSel = 800;
        yM = 650;
        this.removeMouseListener(eW1);
        ypr = 15;
        yco = 600;
    }

    public static Card[] getSobra() {
        return sobra;
    }

    public void dibujaInicio() {
        pxg = 850;
        for (int i = 0; i < fich.size(); i++) {
            fich.get(i).setPy(600);
            fichA.get(i).setPy(-60);
            fichJ1.get(i).setPx(-60);
            fichJ2.get(i).setPx(800);
        }
        ypr = 15;
        xt4 = -62;
        yt4 = ((600 - 306) / 2) + 10;
        xt2 = 800;
        yt2 = (600 - 306) / 2 + 10;
        xt1 = (800 - 306) / 2;
        yt1 = 600;
        xt3 = (800 - 306) / 2;
        yt3 = -40;
        y = -448;
        repaint();

    }

    public void muestraConfig() {

        while (yco > 200) {
            yco -= 40;
            repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException ex) {
            }
        }
        yco -= 2;
        Main.desabilita();
        repaint();

    }

    public void ocultaConfig() {
        yco = 198;
        while (yco < 600) {
            yco += 40;
            repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void dibujaMesa(int oc) {

        nombreU = Main.nombreU;
        parejaSel = Team.getA().toString();
        maquina1 = "M1" + Team.getJ2().toString().substring(0, 3);
        maquina2 = "M2" + Team.getJ1().toString().substring(0, 3);
        punt = Main.punt;
        ypr = 600;
        repaint();
        for (int i = 0; i < fich.size(); i++) {
            fich.get(i).setPy(600);
            fichA.get(i).setPy(-60);
            fichJ1.get(i).setPx(-60);
            fichJ2.get(i).setPx(800);
        }
        ypr = 15;
        xt4 = -62;
        yt4 = ((600 - 306) / 2) + 10;
        xt2 = 800;
        yt2 = (600 - 306) / 2 + 10;
        xt1 = (800 - 306) / 2;
        yt1 = 600;
        xt3 = (800 - 306) / 2;
        yt3 = -40;
        y = -448;
        ypr = -600;
        while (y < 72) {
            y += 40;
            repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException ex) {
            }
        }
        y += 20;
        while (xt4 < 8) {
            xt4 += 2;
            xt2 -= 2;
            yt1 -= 2;
            yt3 += 2;
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
        if (oc == 0) {
            setBackground(Color.WHITE);
            DibujaFichas rep = new DibujaFichas();
            rep.start();
        }
    }

    class DibujaFichas extends Thread {

        public void run() {

            dibujaFichas();
        }
    }

    public void cargaParcial() {
        qAnim = 0;
        xPase = 850;
        cantPases = 0;
        yM = 650;
        dirI = 1;
        dirD = 1;
        Table.xc1 = 362;
        Table.yc1 = 275;
        Table.xc2 = -75;
        Table.yc2 = 275;
        xc1t = -75;
        yc1t = -75;
        xc2t = -75;
        yc2t = -75;
        Table.x = (800 - 30) / 2;
        Table.y = (600 - 60) / 2 + 12;
        Table.x2 = (800 - 30) / 2;
        Table.y2 = (600 - 60) / 2 + 12;
        mesaJ = new Table();
        mesaJ.daAgua();
        mesaJ.repartir();
        fich = Team.getU().getFichas();
        fichA = Team.getA().getFichas();
        fichJ1 = Team.getJ1().getFichas();
        fichJ2 = Team.getJ2().getFichas();
        cI = new ArrayList<>();
        cD = new ArrayList<>();

    }

    public void dibujaFichas() {
        sucs = new ArrayList<>();
        for (int i = 0; i < fich.size(); i++) {
            fich.get(i).setPy(600);
            fichA.get(i).setPy(-60);
            fichJ1.get(i).setPx(-60);
            fichJ2.get(i).setPx(800);
        }
        repaint();
        int au = 0;
        for (int i = 0; i < 10; i++) {
            fich.get(i).setPy(530);
            fichA.get(i).setPy(33);
            fichJ1.get(i).setPx(10);
            fichJ2.get(i).setPx(730);
            fichA.get(i).setPx(250 + au);
            fich.get(i).setPx(250 + au);
            fichJ1.get(i).setPy(160 + au);
            fichJ2.get(i).setPy(160 + au);
            au += 30;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            media.PlayAudio(1);
            repaint();
        }
        lind = new int[10];
        for (int i = 0; i < lind.length; i++) {
            lind[i] = fich.get(i).getPx();
        }
        xnomU = 150;
        xparSel = 150;
        yM = 150;
        repaint();
        if (puntU == 0 && puntM == 0) {
            parImpar();
        } else {
            if (turn == 1) {
                media.PlayAudio(2);
                JOptionPane pane = new JOptionPane();
                int op = JOptionPane.showConfirmDialog(this, "Want to start?", "Start Game", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    turn = 1;
                } else {
                    turn = 3;
                }
            }
            Organizador th = new Organizador();
            th.start();

        }

    }

    private void parImpar() {
        media.PlayAudio(2);
        ParImpar pi = new ParImpar();
        pi.show();
        if (turn == 1) {
            media.PlayAudio(2);
            JOptionPane pane = new JOptionPane();
            int op = JOptionPane.showConfirmDialog(this, "Want to start?", "Start Game", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                turn = 1;
            } else {
                turn = 3;
            }
        }
        Organizador th = new Organizador();
        th.start();
    }

    public void juegaU() {

        if (Team.getU().lleva()) {
            cantPases = 0;
            doWindowEvt();
            Main.abilita(0);
        } else {
            turn = 2;
            cantPases += 1;
            xPase = 180;
            compl = nombreU;
            Table.setPasesU(cabezaD, cabezaI);
            repaint();
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
            }
            xPase = 850;
            repaint();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
            sucs.add("You passed: " + cabezaD + " and " + cabezaI);
            Organizador t = new Organizador();
            t.start();
        }
    }

    public void juega1() {
        CardPlayer f = Team.getJ2().juega();
        if (f != null) {

            cantPases = 0;
            if (f.getLoc() == 1) {
                if (cI.size() == 0) {
                    Table.setUltCD(1);
                    cD.add(f.getFicha());
                    if (!f.getFicha().isDoble()) {
                        Table.x2 -= 15;
                        Table.y2 += 15;
                    }
                }
                cI.add(f.getFicha());
                turn = 3;
                Table.setUltCI(1);
                AnimI an = new AnimI();
                an.start();
            } else {
                if (f.getLoc() == 2) {
                    if (cD.size() == 0) {
                        Table.setUltCI(1);
                        cI.add(f.getFicha());
                        if (!f.getFicha().isDoble()) {
                            Table.x -= 15;
                            Table.y += 15;
                        }
                    }
                    cD.add(f.getFicha());
                    turn = 3;
                    Table.setUltCD(1);
                    AnimD an = new AnimD();
                    an.start();
                }
            }
            sucs.add(maquina1 + " played: " + f.getFicha().toString());
        } else {
            turn = 3;
            cantPases += 1;
            xPase = 180;
            compl = maquina1;
            Table.setPases2(cabezaD, cabezaI);
            repaint();
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
            }
            xPase = 850;
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
            sucs.add(maquina1 + " se pasó a: " + cabezaD + " y " + cabezaI);
            Organizador t = new Organizador();
            t.start();

        }

    }

    public void juega2() {
        CardPlayer f = Team.getA().juega();
        if (f != null) {

            cantPases = 0;
            if (f.getLoc() == 1) {
                if (cI.size() == 0) {
                    Table.setUltCD(2);
                    cD.add(f.getFicha());
                    if (!f.getFicha().isDoble()) {
                        Table.x2 -= 15;
                        Table.y2 += 15;
                    }
                }
                cI.add(f.getFicha());
                turn = 4;
                Table.setUltCI(2);
                AnimI an = new AnimI();
                an.start();
            } else {
                if (f.getLoc() == 2) {
                    if (cD.size() == 0) {
                        Table.setUltCI(2);
                        cI.add(f.getFicha());
                        if (!f.getFicha().isDoble()) {
                            Table.x -= 15;
                            Table.y += 15;
                        }
                    }
                    cD.add(f.getFicha());
                    turn = 4;
                    Table.setUltCD(2);
                    AnimD an = new AnimD();
                    an.start();
                }
            }
            sucs.add(parejaSel + " played: " + f.getFicha().toString());
        } else {
            turn = 4;
            cantPases += 1;
            xPase = 180;
            compl = parejaSel;
            Table.setPasesA(cabezaD, cabezaI);
            repaint();
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
            }
            xPase = 850;
            repaint();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
            sucs.add(parejaSel + " se pasó a: " + cabezaD + " y " + cabezaI);
            Organizador t = new Organizador();
            t.start();
        }
    }

    public void juega3() {
        CardPlayer f = Team.getJ1().juega();
        if (f != null) {

            cantPases = 0;
            if (f.getLoc() == 1) {
                if (cI.size() == 0) {
                    Table.setUltCD(3);
                    cD.add(f.getFicha());
                    if (!f.getFicha().isDoble()) {
                        Table.x2 -= 15;
                        Table.y2 += 15;
                    }
                }
                cI.add(f.getFicha());
                turn = 1;
                Table.setUltCI(3);
                AnimI an = new AnimI();
                an.start();
            } else {
                if (f.getLoc() == 2) {
                    if (cD.size() == 0) {
                        Table.setUltCI(3);
                        cI.add(f.getFicha());
                        if (!f.getFicha().isDoble()) {
                            Table.x -= 15;
                            Table.y += 15;
                        }
                    }
                    cD.add(f.getFicha());
                    turn = 1;
                    Table.setUltCD(3);
                    AnimD an = new AnimD();
                    an.start();
                }
            }
            sucs.add(maquina2 + " played: " + f.getFicha().toString());
        } else {
            turn = 1;
            cantPases += 1;
            xPase = 180;
            compl = maquina2;
            Table.setPases1(cabezaD, cabezaI);
            repaint();
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
            }
            xPase = 850;
            repaint();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
            sucs.add(maquina2 + " passed: " + cabezaD + " and " + cabezaI);
            Organizador t = new Organizador();
            t.start();
        }
    }

    private boolean haDominado(ArrayList<Card> f) {
        int i = 0;

        while (i < 10 && !f.get(i).esActiva()) {
            i++;
        }
        return i == 10;
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        AffineTransform posW = new AffineTransform(
                Math.cos(Math.toRadians(90)), -Math.sin(Math.toRadians(90)),
                Math.sin(Math.toRadians(90)), Math.cos(Math.toRadians(90)),
                xt2, yt2 + 306);
        AffineTransform posE = new AffineTransform(
                Math.cos(Math.toRadians(270)), -Math.sin(Math.toRadians(270)),
                Math.sin(Math.toRadians(270)), Math.cos(Math.toRadians(270)),
                xt4 + 62, yt4);
        AffineTransform posN = new AffineTransform(
                Math.cos(Math.toRadians(0)), -Math.sin(Math.toRadians(0)),
                Math.sin(Math.toRadians(0)), Math.cos(Math.toRadians(0)),
                xt1, yt1);
        AffineTransform posS = new AffineTransform(
                Math.cos(Math.toRadians(180)), -Math.sin(Math.toRadians(180)),
                Math.sin(Math.toRadians(180)), Math.cos(Math.toRadians(180)),
                xt3 + 306, yt3 + 62);
        Graphics2D g2 = null;
        if (G == null) {
            g2 = (Graphics2D) g;
            GraphicsConfiguration gc = g2.getDeviceConfiguration();
            I = gc.createCompatibleImage(getWidth(), getHeight());
            G = I.getGraphics();
        }
        
        g2 = (Graphics2D) G;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(present, 0, ypr, 800, 600, this);
        g2.drawImage(mesa, 70, y, 702, 467, this);
        g2.drawImage(tabla1, posS, this);
        g2.drawImage(tabla1, posW, this);
        g2.drawImage(tabla1, posN, this);
        g2.drawImage(tabla1, posE, this);

        g2.setColor(new Color(0, 150, 0));
        g2.setFont(new Font("Serif", Font.BOLD, 16));
        g2.drawString(nombreU, xnomU, 590);
        g2.drawString(parejaSel, xparSel, 90);
        g2.setColor(Color.BLACK);
        g2.drawString(maquina1, 731, yM);
        g2.drawString(maquina2, 5, yM);

        g2.drawImage(fich.get(0).getImf(), fich.get(0).getOrientG(), this);
        g2.drawImage(fich.get(1).getImf(), fich.get(1).getOrientG(), this);
        g2.drawImage(fich.get(2).getImf(), fich.get(2).getOrientG(), this);
        g2.drawImage(fich.get(3).getImf(), fich.get(3).getOrientG(), this);
        g2.drawImage(fich.get(4).getImf(), fich.get(4).getOrientG(), this);
        g2.drawImage(fich.get(5).getImf(), fich.get(5).getOrientG(), this);
        g2.drawImage(fich.get(6).getImf(), fich.get(6).getOrientG(), this);
        g2.drawImage(fich.get(7).getImf(), fich.get(7).getOrientG(), this);
        g2.drawImage(fich.get(8).getImf(), fich.get(8).getOrientG(), this);
        g2.drawImage(fich.get(9).getImf(), fich.get(9).getOrientG(), this);

        g2.drawImage(fichA.get(0).getImf(), fichA.get(0).getOrientG(), this);
        g2.drawImage(fichA.get(1).getImf(), fichA.get(1).getOrientG(), this);
        g2.drawImage(fichA.get(2).getImf(), fichA.get(2).getOrientG(), this);
        g2.drawImage(fichA.get(3).getImf(), fichA.get(3).getOrientG(), this);
        g2.drawImage(fichA.get(4).getImf(), fichA.get(4).getOrientG(), this);
        g2.drawImage(fichA.get(5).getImf(), fichA.get(5).getOrientG(), this);
        g2.drawImage(fichA.get(6).getImf(), fichA.get(6).getOrientG(), this);
        g2.drawImage(fichA.get(7).getImf(), fichA.get(7).getOrientG(), this);
        g2.drawImage(fichA.get(8).getImf(), fichA.get(8).getOrientG(), this);
        g2.drawImage(fichA.get(9).getImf(), fichA.get(9).getOrientG(), this);

        g2.drawImage(fichJ1.get(0).getImf(), fichJ1.get(0).getOrientG(), this);
        g2.drawImage(fichJ1.get(1).getImf(), fichJ1.get(1).getOrientG(), this);
        g2.drawImage(fichJ1.get(2).getImf(), fichJ1.get(2).getOrientG(), this);
        g2.drawImage(fichJ1.get(3).getImf(), fichJ1.get(3).getOrientG(), this);
        g2.drawImage(fichJ1.get(4).getImf(), fichJ1.get(4).getOrientG(), this);
        g2.drawImage(fichJ1.get(5).getImf(), fichJ1.get(5).getOrientG(), this);
        g2.drawImage(fichJ1.get(6).getImf(), fichJ1.get(6).getOrientG(), this);
        g2.drawImage(fichJ1.get(7).getImf(), fichJ1.get(7).getOrientG(), this);
        g2.drawImage(fichJ1.get(8).getImf(), fichJ1.get(8).getOrientG(), this);
        g2.drawImage(fichJ1.get(9).getImf(), fichJ1.get(9).getOrientG(), this);

        g2.drawImage(fichJ2.get(0).getImf(), fichJ2.get(0).getOrientG(), this);
        g2.drawImage(fichJ2.get(1).getImf(), fichJ2.get(1).getOrientG(), this);
        g2.drawImage(fichJ2.get(2).getImf(), fichJ2.get(2).getOrientG(), this);
        g2.drawImage(fichJ2.get(3).getImf(), fichJ2.get(3).getOrientG(), this);
        g2.drawImage(fichJ2.get(4).getImf(), fichJ2.get(4).getOrientG(), this);
        g2.drawImage(fichJ2.get(5).getImf(), fichJ2.get(5).getOrientG(), this);
        g2.drawImage(fichJ2.get(6).getImf(), fichJ2.get(6).getOrientG(), this);
        g2.drawImage(fichJ2.get(7).getImf(), fichJ2.get(7).getOrientG(), this);
        g2.drawImage(fichJ2.get(8).getImf(), fichJ2.get(8).getOrientG(), this);
        g2.drawImage(fichJ2.get(9).getImf(), fichJ2.get(9).getOrientG(), this);
        
        g2.setColor(color);
        if (cI.size() != 0 && cD.size() != 0) {
            if (qAnim == 1) {
                g2.drawImage(cI.get(cI.size() - 1).getImf(), cI.get(cI.size() - 1).getOrientG(), this);
            } else if (qAnim == 2) {
                g2.drawImage(cD.get(cD.size() - 1).getImf(), cD.get(cD.size() - 1).getOrientG(), this);
            }
        }
        g2.fillRoundRect(pxg - 5, pyg + 6, 32, 64, 8, 8);
        char kj;
        if (fich.get(ind).isDoble()) {
            kj = 'v';
        } else {
            kj = 's';
        }
        g2.drawImage(fich.get(ind).getImf(), pxg, pyg, 34, 68, this);


        g2.setColor(Color.green);
        g2.drawRoundRect(xc1t, yc1t, 75, 75, 30, 30);
        g2.drawRoundRect(xc2t, yc2t, 75, 75, 30, 30);
        g2.drawImage(config, 236, yco, 347, 150, this);
        g2.setFont(new Font("Serif", Font.PLAIN, 50));
        g2.setColor(new Color(255, 0, 0, 200));
        g2.fillRoundRect(xPase - 5, 283, 450, 60, 12, 12);
        g2.setColor(Color.YELLOW);
        String pase = "PASS ";
        g2.drawString(pase + compl, xPase, 330);

        g.drawImage(I, 0, 0, this);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 800, 600);
    }

    public void doWindowEvt() {
        eW = new java.awt.event.MouseMotionAdapter() {

            public void mouseMoved(java.awt.event.MouseEvent evt) {
                moved(evt);
            }
        };
        eW1 = new java.awt.event.MouseAdapter() {

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                released3(evt);
            }
        };
        eW2 = new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                pressed5(evt);
            }
        };
        this.addMouseMotionListener(eW);
        this.addMouseListener(eW1);
        this.addMouseListener(eW2);
    }

    private void dra(java.awt.event.MouseEvent evt) {
        xc1t = Table.xc1;
        yc1t = Table.yc1;
        xc2t = Table.xc2;
        yc2t = Table.yc2;
        fich.get(ind).setPx(evt.getX() - 15);
        fich.get(ind).setPy(evt.getY() - 30);
        pxg = evt.getX() - 17;
        pyg = evt.getY() - 34;
        repaint();
    }

    private void pressed5(java.awt.event.MouseEvent evt) {
        if (evt.getX() > 60 && evt.getX() < 740 && evt.getY() > 90 && evt.getY() < 540) {
        } else if (evt.getX() > fich.get(0).getPx() && evt.getX() < fich.get(0).getPx() + 30 && evt.getY() > fich.get(0).getPy() - 2 && evt.getY() < fich.get(0).getPy() - 2 + 60) {
            e = new java.awt.event.MouseMotionAdapter() {

                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    dra(evt);
                }
            };
            media.PlayAudio(1);
            addMouseMotionListener(e);
            ind = 0;
        } else {
            if (evt.getX() > fich.get(1).getPx() && evt.getX() < fich.get(1).getPx() + 30 && evt.getY() > fich.get(1).getPy() - 2 && evt.getY() < fich.get(1).getPy() - 2 + 60) {
                e = new java.awt.event.MouseMotionAdapter() {

                    public void mouseDragged(java.awt.event.MouseEvent evt) {
                        dra(evt);
                    }
                };
                media.PlayAudio(1);
                addMouseMotionListener(e);
                ind = 1;
            } else {
                if (evt.getX() > fich.get(2).getPx() && evt.getX() < fich.get(2).getPx() + 30 && evt.getY() > fich.get(2).getPy() - 2 && evt.getY() < fich.get(2).getPy() - 2 + 60) {
                    e = new java.awt.event.MouseMotionAdapter() {

                        public void mouseDragged(java.awt.event.MouseEvent evt) {
                            dra(evt);
                        }
                    };
                    media.PlayAudio(1);
                    addMouseMotionListener(e);
                    ind = 2;
                } else {
                    if (evt.getX() > fich.get(3).getPx() && evt.getX() < fich.get(3).getPx() + 30 && evt.getY() > fich.get(3).getPy() - 2 && evt.getY() < fich.get(3).getPy() - 2 + 60) {
                        e = new java.awt.event.MouseMotionAdapter() {

                            public void mouseDragged(java.awt.event.MouseEvent evt) {
                                dra(evt);
                            }
                        };
                        media.PlayAudio(1);
                        addMouseMotionListener(e);
                        ind = 3;
                    } else {
                        if (evt.getX() > fich.get(4).getPx() && evt.getX() < fich.get(4).getPx() + 30 && evt.getY() > fich.get(4).getPy() - 2 && evt.getY() < fich.get(4).getPy() - 2 + 60) {
                            e = new java.awt.event.MouseMotionAdapter() {

                                public void mouseDragged(java.awt.event.MouseEvent evt) {
                                    dra(evt);
                                }
                            };
                            media.PlayAudio(1);
                            addMouseMotionListener(e);
                            ind = 4;
                        } else {
                            if (evt.getX() > fich.get(5).getPx() && evt.getX() < fich.get(5).getPx() + 30 && evt.getY() > fich.get(5).getPy() - 2 && evt.getY() < fich.get(5).getPy() - 2 + 60) {
                                e = new java.awt.event.MouseMotionAdapter() {

                                    public void mouseDragged(java.awt.event.MouseEvent evt) {
                                        dra(evt);
                                    }
                                };
                                media.PlayAudio(1);
                                addMouseMotionListener(e);
                                ind = 5;
                            } else {
                                if (evt.getX() > fich.get(6).getPx() && evt.getX() < fich.get(6).getPx() + 30 && evt.getY() > fich.get(6).getPy() - 2 && evt.getY() < fich.get(6).getPy() - 2 + 60) {
                                    e = new java.awt.event.MouseMotionAdapter() {

                                        public void mouseDragged(java.awt.event.MouseEvent evt) {
                                            dra(evt);
                                        }
                                    };
                                    media.PlayAudio(1);
                                    addMouseMotionListener(e);
                                    ind = 6;
                                } else {
                                    if (evt.getX() > fich.get(7).getPx() && evt.getX() < fich.get(7).getPx() + 30 && evt.getY() > fich.get(7).getPy() - 2 && evt.getY() < fich.get(7).getPy() - 2 + 60) {
                                        e = new java.awt.event.MouseMotionAdapter() {

                                            public void mouseDragged(java.awt.event.MouseEvent evt) {
                                                dra(evt);
                                            }
                                        };
                                        media.PlayAudio(1);
                                        addMouseMotionListener(e);
                                        ind = 7;
                                    } else {
                                        if (evt.getX() > fich.get(8).getPx() && evt.getX() < fich.get(8).getPx() + 30 && evt.getY() > fich.get(8).getPy() - 2 && evt.getY() < fich.get(8).getPy() - 2 + 60) {
                                            e = new java.awt.event.MouseMotionAdapter() {

                                                public void mouseDragged(java.awt.event.MouseEvent evt) {
                                                    dra(evt);
                                                }
                                            };
                                            media.PlayAudio(1);
                                            addMouseMotionListener(e);
                                            ind = 8;
                                        } else {
                                            if (evt.getX() > fich.get(9).getPx() && evt.getX() < fich.get(9).getPx() + 30 && evt.getY() > fich.get(9).getPy() - 2 && evt.getY() < fich.get(9).getPy() - 2 + 60) {
                                                e = new java.awt.event.MouseMotionAdapter() {

                                                    public void mouseDragged(java.awt.event.MouseEvent evt) {
                                                        dra(evt);
                                                    }
                                                };
                                                media.PlayAudio(1);
                                                addMouseMotionListener(e);
                                                ind = 9;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    private void released3(java.awt.event.MouseEvent evt) {

        pxg = 850;
        repaint();
        this.removeMouseMotionListener(e);
        if (fich.get(ind).esActiva() && (fich.get(ind).getPx() + 15 > Table.xc1 && fich.get(ind).getPx() + 15 < Table.xc1 + 75 && fich.get(ind).getPy() + 30 > Table.yc1 && fich.get(ind).getPy() + 30 < Table.yc1 + 75)) {
            AnimI an = new AnimI();
            if (cD.size() == 0) {
                Table.setUltCD(0);
                cD.add(fich.get(ind));
                cI.add(fich.get(ind));

                if (!cI.get(0).isDoble()) {
                    Table.x2 -= 15;
                    Table.y2 += 15;
                }
                an.start();

            } else {
                cI.add(fich.get(ind));

                if ((cI.get(cI.size() - 1).isDoble() && cI.get(cI.size() - 2).isDoble()) || !(cI.get(cI.size() - 1).getV1() == cabezaD || cI.get(cI.size() - 1).getV2() == cabezaD)) {
                    media.PlayAudio(2);
                    cI.remove(cI.size() - 1);
                    fich.get(ind).setPy(530);
                    fich.get(ind).setPx(lind[ind]);
                    fich.get(ind).setActiva(true);
                    repaint();
                } else {
                    an.start();

                }
            }
            sucs.clear();
            Table.setUltCI(0);

        } else if (fich.get(ind).esActiva() && (fich.get(ind).getPx() + 15 > Table.xc2 && fich.get(ind).getPx() + 15 < Table.xc2 + 75 && fich.get(ind).getPy() + 30 > Table.yc2 && fich.get(ind).getPy() + 30 < Table.yc2 + 75)) {
            AnimD an = new AnimD();
            if (cI.size() == 0) {
                Table.setUltCI(0);
                cD.add(fich.get(ind));
                cI.add(fich.get(ind));

                if (!cD.get(0).isDoble() || !cD.get(0).isDoble()) {
                    Table.x -= 15;
                    Table.y += 15;
                }
                an.start();
            } else {
                cD.add(fich.get(ind));

                if ((cD.get(cD.size() - 1).isDoble() && cD.get(cD.size() - 2).isDoble()) || !(cD.get(cD.size() - 1).getV1() == cabezaI || cD.get(cD.size() - 1).getV2() == cabezaI)) {
                    media.PlayAudio(2);
                    cD.remove(cD.size() - 1);
                    fich.get(ind).setPy(530);
                    fich.get(ind).setPx(lind[ind]);
                    fich.get(ind).setActiva(true);
                    repaint();
                } else {
                    an.start();
                }
            }
            sucs.clear();
            Table.setUltCD(0);
        } else {

            if (fich.get(ind).esActiva()) {
                media.PlayAudio(2);
                fich.get(ind).setPy(530);
                fich.get(ind).setPx(lind[ind]);
                fich.get(ind).setActiva(true);
                repaint();
            }
        }
        xc1t = -75;
        yc1t = -75;
        xc2t = -75;
        yc2t = -75;
        turn = 2;
        cantPases = 0;
    }

    public static ArrayList<String> getSucs() {
        return sucs;
    }

    private void moved(java.awt.event.MouseEvent evt) {
        if (evt.getX() > 60 && evt.getX() < 740 && evt.getY() > 90 && evt.getY() < 530) {
        } else if (evt.getX() > fich.get(0).getPx() && evt.getX() < fich.get(0).getPx() + 30 && evt.getY() > fich.get(0).getPy() - 2 && evt.getY() < fich.get(0).getPy() - 2 + 60) {

            ind = 0;
            pxg = fich.get(ind).getPx() - 2;
            pyg = fich.get(ind).getPy() - 4;
            repaint();
        } else {
            if (evt.getX() > fich.get(1).getPx() && evt.getX() < fich.get(1).getPx() + 30 && evt.getY() > fich.get(1).getPy() - 2 && evt.getY() < fich.get(1).getPy() - 2 + 60) {

                ind = 1;
                pxg = fich.get(ind).getPx() - 2;
                pyg = fich.get(ind).getPy() - 4;
                repaint();
            } else {
                if (evt.getX() > fich.get(2).getPx() && evt.getX() < fich.get(2).getPx() + 30 && evt.getY() > fich.get(2).getPy() - 2 && evt.getY() < fich.get(2).getPy() - 2 + 60) {

                    ind = 2;
                    pxg = fich.get(ind).getPx() - 2;
                    pyg = fich.get(ind).getPy() - 4;
                    repaint();
                } else {
                    if (evt.getX() > fich.get(3).getPx() && evt.getX() < fich.get(3).getPx() + 30 && evt.getY() > fich.get(3).getPy() - 2 && evt.getY() < fich.get(3).getPy() - 2 + 60) {

                        ind = 3;
                        pxg = fich.get(ind).getPx() - 2;
                        pyg = fich.get(ind).getPy() - 4;
                        repaint();
                    } else {
                        if (evt.getX() > fich.get(4).getPx() && evt.getX() < fich.get(4).getPx() + 30 && evt.getY() > fich.get(4).getPy() - 2 && evt.getY() < fich.get(4).getPy() - 2 + 60) {

                            ind = 4;
                            pxg = fich.get(ind).getPx() - 2;
                            pyg = fich.get(ind).getPy() - 4;
                            repaint();
                        } else {
                            if (evt.getX() > fich.get(5).getPx() && evt.getX() < fich.get(5).getPx() + 30 && evt.getY() > fich.get(5).getPy() - 2 && evt.getY() < fich.get(5).getPy() - 2 + 60) {

                                ind = 5;
                                pxg = fich.get(ind).getPx() - 2;
                                pyg = fich.get(ind).getPy() - 4;
                                repaint();
                            } else {
                                if (evt.getX() > fich.get(6).getPx() && evt.getX() < fich.get(6).getPx() + 30 && evt.getY() > fich.get(6).getPy() - 2 && evt.getY() < fich.get(6).getPy() - 2 + 60) {

                                    ind = 6;
                                    pxg = fich.get(ind).getPx() - 2;
                                    pyg = fich.get(ind).getPy() - 4;
                                    repaint();
                                } else {
                                    if (evt.getX() > fich.get(7).getPx() && evt.getX() < fich.get(7).getPx() + 30 && evt.getY() > fich.get(7).getPy() - 2 && evt.getY() < fich.get(7).getPy() - 2 + 60) {

                                        ind = 7;
                                        pxg = fich.get(ind).getPx() - 2;
                                        pyg = fich.get(ind).getPy() - 4;
                                        repaint();
                                    } else {
                                        if (evt.getX() > fich.get(8).getPx() && evt.getX() < fich.get(8).getPx() + 30 && evt.getY() > fich.get(8).getPy() - 2 && evt.getY() < fich.get(8).getPy() - 2 + 60) {

                                            ind = 8;
                                            pxg = fich.get(ind).getPx() - 2;
                                            pyg = fich.get(ind).getPy() - 4;
                                            repaint();
                                        } else {
                                            if (evt.getX() > fich.get(9).getPx() && evt.getX() < fich.get(9).getPx() + 30 && evt.getY() > fich.get(9).getPy() - 2 && evt.getY() < fich.get(9).getPy() - 2 + 60) {

                                                ind = 9;
                                                pxg = fich.get(ind).getPx() - 2;
                                                pyg = fich.get(ind).getPy() - 4;
                                                repaint();
                                            } else {
                                                pxg = 850;
                                                repaint();
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public void colocaFichaI() {

        Card h = cI.get(cI.size() - 1);
        if (cI.size() == 1) {
            if (h.isDoble() && (h.getOrient() == 'v' || h.getOrient() == 'a')) {

                h.setPx(Table.x);
                h.setPy(Table.y);
                Table.xc1 = h.getPx() + 30;
                Table.xc2 = h.getPx() - 75;
                h.setOrient('v');
                cabezaD = h.getV1();
                cabezaI = h.getV2();
                h.setActiva(false);
                repaint();
            } else {
                if (h.isDoble() && (h.getOrient() == 'h' || h.getOrient() == 'r')) {

                    h.setPx(Table.x);
                    h.setPy(Table.y);
                    Table.xc1 = h.getPx() + 30;
                    Table.xc2 = h.getPx() - 75;
                    h.setActiva(false);
                    h.setOrient('v');
                    cabezaD = h.getV1();
                    cabezaI = h.getV2();
                    repaint();

                } else {
                    h.setPx(Table.x - 15);
                    h.setPy(Table.y + 15);
                    Table.x -= 15;
                    Table.y += 15;
                    Table.xc1 = h.getPx() + 60;
                    Table.xc2 = h.getPx() - 75;
                    h.setOrient('e');
                    cabezaD = h.getV1();
                    cabezaI = h.getV2();

                    h.setActiva(false);
                    repaint();
                }
            }

        } else {
            Card h2 = cI.get(cI.size() - 2);

            if (Table.xc1 + 75 < dTop && dirI == 1) {
                if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                    h.setPx(Table.x + 30);
                    h.setPy(Table.y + 15);
                    Table.x += 30;
                    Table.y += 15;
                    Table.xc1 = h.getPx() + 60;
                    Table.yc1 = h.getPy() - 25;
                    h.setOrient(mOrientD(h, "horE"));
                    h.setActiva(false);
                    repaint();
                }
                if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'h')) {
                    h.setPx(Table.x + 60);
                    h.setPy(Table.y);
                    Table.x += 60;
                    Table.xc1 = h.getPx() + 60;
                    Table.yc1 = h.getPy() - 25;
                    h.setOrient(mOrientD(h, "horE"));
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                    h.setPx(Table.x + 60);
                    h.setPy(Table.y - 15);
                    Table.x += 60;
                    Table.y -= 15;
                    Table.xc1 = h.getPx() + 30;
                    Table.yc1 = h.getPy() - 7;
                    h.setOrient('v');
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                    h.setPx(Table.x - 15);
                    h.setPy(Table.y - 30);
                    Table.x -= 15;
                    Table.y -= 30;
                    Table.xc1 = h.getPx() + 60;
                    Table.yc1 = h.getPy() - 25;
                    h.setOrient('h');
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                    h.setPx(Table.x + 60);
                    h.setPy(Table.y);
                    Table.x += 60;
                    Table.xc1 = h.getPx() + 60;
                    Table.yc1 = h.getPy() - 25;
                    h.setOrient(mOrientD(h, "horE"));
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                    h.setPx(Table.x + 30);
                    h.setPy(Table.y);
                    Table.x += 30;
                    Table.y -= 0;
                    Table.xc1 = h.getPx() + 60;
                    Table.yc1 = h.getPy() - 25;
                    h.setOrient(mOrientD(h, "horE"));
                    h.setActiva(false);
                    repaint();
                }

            } else {
                if (Table.xc1 + 75 > dTop && dirI == 1) {
                    Card h3 = cI.get(cI.size() - 3);
                    if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                        h.setPx(Table.x);
                        h.setPy(Table.y - 60);
                        Table.x += 0;
                        Table.y -= 60;
                        Table.xc1 = h.getPx() - 75;
                        Table.yc1 = h.getPy() - 7;
                        h.setOrient(mOrientD(h, "ver"));
                        h.setActiva(false);
                        dirI = 2;
                        repaint();
                    }
                    if (!h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h2.setPx(Table.x);
                        h2.setPy(Table.y - 30);
                        Table.x += 0;
                        Table.y -= 30;
                        h2.setOrient(h2.nextOrienI());
                        h.setPx(Table.x - 15);
                        h.setPy(Table.y - 30);
                        Table.x -= 15;
                        Table.y -= 30;
                        Table.xc1 = h.getPx() - 75;
                        Table.yc1 = h.getPy() - 25;
                        h.setOrient('h');
                        h.setActiva(false);
                        dirI = 2;
                        repaint();
                    }
                    if (h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h2.setPx(Table.x - 30);
                        h2.setPy(Table.y - 75);
                        Table.x -= 30;
                        Table.y -= 75;
                        h2.setOrient(h2.nextOrienI());
                        h.setPx(Table.x - 15);
                        h.setPy(Table.y - 30);
                        Table.x -= 15;
                        Table.y -= 30;
                        Table.xc1 = h.getPx() - 75;
                        Table.yc1 = h.getPy() - 25;
                        h.setOrient('h');
                        h.setActiva(false);
                        dirI = 2;
                        repaint();
                    }
                    if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h.setPx(Table.x + 30);
                        h.setPy(Table.y - 60);
                        Table.x += 30;
                        Table.y -= 60;
                        Table.xc1 = h.getPx() - 75;
                        Table.yc1 = h.getPy() - 7;
                        h.setOrient(mOrientD(h, "ver"));
                        h.setActiva(false);
                        dirI = 2;
                        repaint();
                    }
                } else {
                    if (Table.xc1 > iTop && dirI == 2) {
                        if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                            h.setPx(Table.x - 60);
                            h.setPy(Table.y + 15);
                            Table.x -= 60;
                            Table.y += 15;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 25;
                            h.setOrient(mOrientD(h, "horW"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'h')) {
                            h.setPx(Table.x - 60);
                            h.setPy(Table.y);
                            Table.x -= 60;
                            Table.y += 0;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 25;
                            h.setOrient(mOrientD(h, "horW"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                            h.setPx(Table.x - 30);
                            h.setPy(Table.y - 15);
                            Table.x -= 30;
                            Table.y -= 15;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 7;
                            h.setOrient('v');
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                            h.setPx(Table.x - 15);
                            h.setPy(Table.y - 30);
                            Table.x -= 15;
                            Table.y -= 30;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 25;
                            h.setOrient('h');
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                            h.setPx(Table.x - 60);
                            h.setPy(Table.y);
                            Table.x -= 60;
                            Table.y -= 0;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 25;
                            h.setOrient(mOrientD(h, "horW"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                            h.setPx(Table.x - 60);
                            h.setPy(Table.y);
                            Table.x -= 60;
                            Table.y -= 0;
                            Table.xc1 = h.getPx() - 75;
                            Table.yc1 = h.getPy() - 25;
                            h.setOrient(mOrientD(h, "horW"));
                            h.setActiva(false);
                            repaint();
                        }

                    } else {
                        if (Table.xc1 < iTop && dirI == 2) {
                            Card h3 = cI.get(cI.size() - 3);
                            if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                                h.setPx(Table.x);
                                h.setPy(Table.y - 60);
                                Table.x += 0;
                                Table.y -= 60;
                                Table.xc1 = h.getPx() + 30;
                                Table.yc1 = h.getPy() - 7;
                                h.setOrient(mOrientD(h, "ver"));
                                h.setActiva(false);
                                dirI = 1;
                                repaint();
                            }
                            if (!h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h2.setPx(Table.x + 30);
                                h2.setPy(Table.y - 30);
                                Table.x += 30;
                                Table.y -= 30;
                                h2.setOrient(h2.nextOrienD());
                                h.setPx(Table.x - 15);
                                h.setPy(Table.y - 30);
                                Table.x -= 15;
                                Table.y -= 30;
                                Table.xc1 = h.getPx() + 60;
                                Table.yc1 = h.getPy() - 25;
                                h.setOrient('h');
                                h.setActiva(false);
                                dirI = 1;
                                repaint();
                            }
                            if (h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h2.setPx(Table.x + 60);
                                h2.setPy(Table.y - 75);
                                Table.x += 60;
                                Table.y -= 75;
                                h2.setOrient(h2.nextOrienD());
                                h.setPx(Table.x - 15);
                                h.setPy(Table.y - 30);
                                Table.x -= 15;
                                Table.y -= 30;
                                Table.xc1 = h.getPx() + 60;
                                Table.yc1 = h.getPy() - 25;
                                h.setOrient('h');
                                h.setActiva(false);
                                dirI = 1;
                                repaint();
                            }
                            if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h.setPx(Table.x);
                                h.setPy(Table.y - 60);
                                Table.x += 0;
                                Table.y -= 60;
                                Table.xc1 = h.getPx() + 30;
                                Table.yc1 = h.getPy() - 7;
                                h.setOrient(mOrientD(h, "ver"));
                                h.setActiva(false);
                                dirI = 1;
                                repaint();
                            }
                        }
                    }
                }
            }
            if (h.getPy() < aTop + 20) {
                while (h.getPy() < aTop + 20) {
                    for (int i = 1; i < cD.size(); i++) {
                        cD.get(i).setPy(cD.get(i).getPy() + 2);
                    }
                    for (int i = 0; i < cI.size(); i++) {
                        cI.get(i).setPy(cI.get(i).getPy() + 2);
                    }
                    Table.y += 2;
                    Table.y2 += 2;
                    Table.yc1 += 2;
                    Table.yc2 += 2;
                }
            }
        }
        media.PlayAudio(1);

    }

    public void colocaFichaD() {

        if (cD.size() == 1) {
            Card h = cD.get(cI.size() - 1);
            if (h.isDoble() && (h.getOrient() == 'v' || h.getOrient() == 'a')) {
                h.setPx(Table.x2);
                h.setPy(Table.y2);
                Table.xc1 = h.getPx() + 30;
                Table.xc2 = h.getPx() - 75;
                h.setActiva(false);
                h.setOrient('v');
                cabezaD = h.getV1();
                cabezaI = h.getV2();
                repaint();
            } else {
                if (h.isDoble() && (h.getOrient() == 'h' || h.getOrient() == 'r')) {
                    h.setPx(Table.x2);
                    h.setPy(Table.y2);
                    Table.xc1 = h.getPx() + 30;
                    Table.xc2 = h.getPx() - 75;
                    h.setActiva(false);
                    h.setOrient('v');
                    cabezaD = h.getV1();
                    cabezaI = h.getV2();
                    repaint();

                } else {
                    h.setPx(Table.x2 - 15);
                    h.setPy(Table.y2 + 15);
                    Table.x2 -= 15;
                    Table.y2 += 15;
                    Table.xc1 = h.getPx() + 60;
                    Table.xc2 = h.getPx() - 75;
                    h.setOrient('e');
                    cabezaD = h.getV1();
                    cabezaI = h.getV2();

                    h.setActiva(false);
                    repaint();
                }
            }

        } else {
            Card h = cD.get(cD.size() - 1);
            Card h2 = cD.get(cD.size() - 2);

            if (Table.xc2 > iTop && dirD == 1) {
                if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                    h.setPx(Table.x2 - 60);
                    h.setPy(Table.y2 + 15);
                    Table.x2 -= 60;
                    Table.y2 += 15;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 25;
                    h.setOrient(mOrientI(h, "horW"));
                    h.setActiva(false);
                    repaint();
                }
                if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'h')) {
                    h.setPx(Table.x2 - 60);
                    h.setPy(Table.y2);
                    Table.x2 -= 60;
                    Table.y2 += 0;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 25;
                    h.setOrient(mOrientI(h, "horW"));
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                    h.setPx(Table.x2 - 30);
                    h.setPy(Table.y2 - 15);
                    Table.x2 -= 30;
                    Table.y2 -= 15;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 7;
                    h.setOrient('v');
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                    h.setPx(Table.x2 - 15);
                    h.setPy(Table.y2 + 60);
                    Table.x2 -= 15;
                    Table.y2 += 60;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 25;
                    h.setOrient('h');
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                    h.setPx(Table.x2 - 60);
                    h.setPy(Table.y2);
                    Table.x2 -= 60;
                    Table.y2 -= 0;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 25;
                    h.setOrient(mOrientI(h, "horW"));
                    h.setActiva(false);
                    repaint();
                }
                if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                    h.setPx(Table.x2 - 60);
                    h.setPy(Table.y2 + 30);
                    Table.x2 -= 60;
                    Table.y2 += 30;
                    Table.xc2 = h.getPx() - 75;
                    Table.yc2 = h.getPy() - 25;
                    h.setOrient(mOrientI(h, "horW"));
                    h.setActiva(false);
                    repaint();
                }

            } else {
                if (Table.xc2 < iTop && dirD == 1) {
                    Card h3 = cD.get(cD.size() - 3);
                    if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                        h.setPx(Table.x2);
                        h.setPy(Table.y2 + 60);
                        Table.x2 += 0;
                        Table.y2 += 60;
                        Table.xc2 = h.getPx() + 30;
                        Table.yc2 = h.getPy() - 7;
                        h.setOrient(mOrientI(h, "ver"));
                        h.setActiva(false);
                        dirD = 2;
                        repaint();
                    }
                    if (!h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h2.setPx(Table.x2 + 60);
                        h2.setPy(Table.y2 + 30);
                        Table.x2 += 60;
                        Table.y2 += 30;
                        h2.setOrient(h2.nextOrienI());
                        h.setPx(Table.x2 - 15);
                        h.setPy(Table.y2 + 60);
                        Table.x2 -= 15;
                        Table.y2 += 60;
                        Table.xc2 = h.getPx() + 60;
                        Table.yc2 = h.getPy() - 25;
                        h.setOrient('h');
                        h.setActiva(false);
                        dirD = 2;
                        repaint();
                    }
                    if (h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h2.setPx(Table.x2 + 60);
                        h2.setPy(Table.y2 + 45);
                        Table.x2 += 60;
                        Table.y2 += 45;
                        h2.setOrient(h2.nextOrienI());
                        h.setPx(Table.x2 - 15);
                        h.setPy(Table.y2 + 60);
                        Table.x2 -= 15;
                        Table.y2 += 60;
                        Table.xc2 = h.getPx() + 60;
                        Table.yc2 = h.getPy() - 25;
                        h.setOrient('h');
                        h.setActiva(false);
                        dirD = 2;
                        repaint();
                    }
                    if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                        h.setPx(Table.x2);
                        h.setPy(Table.y2 + 30);
                        Table.x2 += 0;
                        Table.y2 += 30;
                        Table.xc2 = h.getPx() + 30;
                        Table.yc2 = h.getPy() - 7;
                        h.setOrient(mOrientI(h, "ver"));
                        h.setActiva(false);
                        dirD = 2;
                        repaint();
                    }
                } else {
                    if (Table.xc2 + 75 < dTop && dirD == 2) {
                        if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                            h.setPx(Table.x2 + 30);
                            h.setPy(Table.y2 + 15);
                            Table.x2 += 30;
                            Table.y2 += 15;
                            Table.xc2 = h.getPx() + 60;
                            Table.yc2 = h.getPy() - 25;
                            h.setOrient(mOrientI(h, "horE"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'h')) {
                            h.setPx(Table.x2 + 60);
                            h.setPy(Table.y2);
                            Table.x2 += 60;
                            Table.y2 += 0;
                            Table.xc2 = h.getPx() + 60;
                            Table.yc2 = h.getPy() - 25;
                            h.setOrient(mOrientI(h, "horE"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                            h.setPx(Table.x2 + 60);
                            h.setPy(Table.y2 - 15);
                            Table.x2 += 60;
                            Table.y2 -= 15;
                            Table.xc2 = h.getPx() + 30;
                            Table.yc2 = h.getPy() - 7;
                            h.setOrient('v');
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                            h.setPx(Table.x2 - 15);
                            h.setPy(Table.y2 + 60);
                            Table.x2 -= 15;
                            Table.y2 += 60;
                            Table.xc2 = h.getPx() + 60;
                            Table.yc2 = h.getPy() - 25;
                            h.setOrient('h');
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                            h.setPx(Table.x2 + 60);
                            h.setPy(Table.y2);
                            Table.x2 += 60;
                            Table.y2 -= 0;
                            Table.xc2 = h.getPx() + 60;
                            Table.yc2 = h.getPy() - 25;
                            h.setOrient(mOrientI(h, "horE"));
                            h.setActiva(false);
                            repaint();
                        }
                        if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 's' || h2.getOrient() == 'n')) {
                            h.setPx(Table.x2 + 30);
                            h.setPy(Table.y2 + 30);
                            Table.x2 += 30;
                            Table.y2 += 30;
                            Table.xc2 = h.getPx() + 60;
                            Table.yc2 = h.getPy() - 25;
                            h.setOrient(mOrientI(h, "horE"));
                            h.setActiva(false);
                            repaint();
                        }

                    } else {
                        if (Table.xc2 + 75 > dTop && dirD == 2) {
                            Card h3 = cD.get(cD.size() - 3);
                            if (h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'v')) {
                                h.setPx(Table.x2);
                                h.setPy(Table.y2 + 60);
                                Table.x2 += 0;
                                Table.y2 += 60;
                                Table.xc2 = h.getPx() - 75;
                                Table.yc2 = h.getPy() - 7;
                                h.setOrient(mOrientI(h, "ver"));
                                h.setActiva(false);
                                dirD = 1;
                                repaint();
                            }
                            if (!h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h2.setPx(Table.x2 - 30);
                                h2.setPy(Table.y2 + 30);
                                Table.x2 -= 30;
                                Table.y2 += 30;
                                h2.setOrient(h2.nextOrienD());
                                h.setPx(Table.x2 - 15);
                                h.setPy(Table.y2 + 60);
                                Table.x2 -= 15;
                                Table.y2 += 60;
                                Table.xc2 = h.getPx() - 75;
                                Table.yc2 = h.getPy() - 25;
                                h.setOrient('h');
                                h.setActiva(false);
                                dirD = 1;
                                repaint();
                            }
                            if (h3.isDoble() && !h2.isDoble() && h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h2.setPx(Table.x2 - 30);
                                h2.setPy(Table.y2 + 45);
                                Table.x2 -= 30;
                                Table.y2 += 45;
                                h2.setOrient(h2.nextOrienD());
                                h.setPx(Table.x2 - 15);
                                h.setPy(Table.y2 + 60);
                                Table.x2 -= 15;
                                Table.y2 += 60;
                                Table.xc2 = h.getPx() - 75;
                                Table.yc2 = h.getPy() - 25;
                                h.setOrient('h');
                                h.setActiva(false);
                                dirD = 1;
                                repaint();
                            }
                            if (!h2.isDoble() && !h.isDoble() && (h2.getOrient() == 'e' || h2.getOrient() == 'w')) {
                                h.setPx(Table.x2 + 30);
                                h.setPy(Table.y2 + 30);
                                Table.x2 += 30;
                                Table.y2 += 30;
                                Table.xc2 = h.getPx() - 75;
                                Table.yc2 = h.getPy() - 7;
                                h.setOrient(mOrientI(h, "ver"));
                                h.setActiva(false);
                                dirD = 1;
                                repaint();
                            }
                        }
                    }
                }
            }
            if (h.getPy() + 60 > bTop) {
                while (h.getPy() + 60 > bTop) {
                    for (int i = 1; i < cD.size(); i++) {
                        cD.get(i).setPy(cD.get(i).getPy() - 2);
                    }
                    for (int i = 0; i < cI.size(); i++) {
                        cI.get(i).setPy(cI.get(i).getPy() - 2);
                    }
                    Table.y -= 2;
                    Table.y2 -= 2;
                    Table.yc1 -= 2;
                    Table.yc2 -= 2;
                }
            }
        }
        media.PlayAudio(1);


    }

    class AnimI extends Thread {

        public void run() {

            animaFichaI();
        }
    }

    class AnimD extends Thread {

        public void run() {

            animaFichaD();
        }
    }

    public void animaFichaI() {
        qAnim = 1;
        Card h = cI.get(cI.size() - 1);
        double x1 = h.getPx();
        double y1 = h.getPy();
        double x2 = Table.x;
        double y2 = Table.y;
        if (x2 - x1 != 0) {
            double m = (y2 - y1) / (x2 - x1);
            int n = (int) (y1 - m * x1);
            int dx = Math.abs((int) (x2 - x1));
            int dy = Math.abs((int) (y2 - y1));

            if (dx > dy) {
                if (x1 > x2) {
                    for (int i = (int) x1; i > x2; i -= 10) {
                        h.setPx(i);
                        h.setPy((int) (m * i + n));
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                        }
                        repaint();
                    }

                } else {
                    if (x1 < x2) {
                        for (int i = (int) x1; i < x2; i += 10) {
                            h.setPx(i);
                            h.setPy((int) (m * i + n));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException ex) {
                            }
                            repaint();
                        }
                    }

                }
            } else {
                if (y1 > y2) {
                    for (int i = (int) y1; i > y2; i -= 10) {
                        h.setPy(i);
                        h.setPx((int) ((i - n) / m));
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                        }
                        repaint();
                    }

                } else {
                    if (y1 < y2) {
                        for (int i = (int) y1; i < y2; i += 10) {
                            h.setPy(i);
                            h.setPx((int) ((i - n) / m));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException ex) {
                            }
                            repaint();
                        }
                    }

                }
            }
        } else {
            for (int i = (int) y1; i < y2; i += 10) {
                h.setPy(i);

                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                }
                repaint();
            }
        }
        colocaFichaI();
        Organizador t = new Organizador();
        t.start();
    }

    public void animaFichaD() {
        qAnim = 2;
        Card h = cD.get(cD.size() - 1);
        double x1 = h.getPx();
        double y1 = h.getPy();
        double x2 = Table.x2;
        double y2 = Table.y2;
        if (x2 - x1 != 0) {
            double m = (y2 - y1) / (x2 - x1);
            int n = (int) (y1 - m * x1);
            int dx = Math.abs((int) (x2 - x1));
            int dy = Math.abs((int) (y2 - y1));

            if (dx > dy) {
                if (x1 > x2) {
                    for (int i = (int) x1; i > x2; i -= 10) {
                        h.setPx(i);
                        h.setPy((int) (m * i + n));
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                        }
                        repaint();
                    }

                } else {
                    if (x1 < x2) {
                        for (int i = (int) x1; i < x2; i += 10) {
                            h.setPx(i);
                            h.setPy((int) (m * i + n));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException ex) {
                            }
                            repaint();
                        }
                    }

                }
            } else {
                if (y1 > y2) {
                    for (int i = (int) y1; i > y2; i -= 10) {
                        h.setPy(i);
                        h.setPx((int) ((i - n) / m));
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                        }
                        repaint();
                    }

                } else {
                    if (y1 < y2) {
                        for (int i = (int) y1; i < y2; i += 10) {
                            h.setPy(i);
                            h.setPx((int) ((i - n) / m));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException ex) {
                            }
                            repaint();
                        }
                    }

                }
            }
        } else {
            for (int i = (int) y1; i < y2; i += 10) {
                h.setPy(i);

                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                }
                repaint();
            }
        }
        colocaFichaD();
        Organizador t = new Organizador();
        t.start();

    }

    public void destroyEvt() {
        this.removeMouseListener(eW1);
        this.removeMouseListener(eW2);
        this.removeMouseMotionListener(eW);
    }

    class Organizador extends Thread {

        public void run() {
            destroyEvt();
            Main.desabilita();
            if (!haDominado(fich) && !haDominado(fichA) && !haDominado(fichJ1) && !haDominado(fichJ2) && cantPases != 4) {


                if (turn == 2) {
                    juega1();
                } else if (turn == 3) {
                    juega2();
                } else if (turn == 4) {
                    juega3();
                } else if (turn == 1) {
                    juegaU();

                }
            } else {
                muestraPunt();


            }
        }
    }

    public void muestraPunt() {
        media.PlayAudio(2);
        if ((haDominado(fich) || haDominado(fichA)) && cantPases < 4) {
            puntU += Team.getJ1().cuenta() + Team.getJ2().cuenta();
            datas += 1;
            turn = 1;
        } else {
            if ((haDominado(fichJ1) || haDominado(fichJ2)) && cantPases < 4) {
                puntM += Team.getU().cuenta() + Team.getA().cuenta();
                datas += 1;
                Random ra = new Random();
                int w = ra.nextInt(4);
                if (w < 2) {
                    turn = 2;
                } else {
                    turn = 4;

                }
            } else {
                if (!haDominado(fich) && !haDominado(fichA) && !haDominado(fichJ1) && !haDominado(fichJ2) && cantPases >= 4) {

                    int pm1 = Team.getJ1().cuenta();

                    int pm2 = Team.getJ2().cuenta();

                    int pu = Team.getU().cuenta();

                    int puA = Team.getA().cuenta();

                    if ((pm1 < pu && pm1 < puA) || (pm2 < pu && pm2 < puA)) {

                        puntM += (pu + puA);
                        datas += 1;
                        Random ra = new Random();
                        int w = ra.nextInt(4);
                        if (w < 2) {

                            turn = 2;
                        } else {
                            turn = 4;

                        }
                    } else {

                        puntU += (pm1 + pm2);
                        datas += 1;
                        turn = 1;
                    }


                }
            }
        }
        if (puntU >= punt || puntM >= punt) {
            Team.getA().virarse('c');
            Team.getJ1().virarse('m');
            Team.getJ2().virarse('m');
            repaint();
            Main.muestraPunt(2, puntU, puntM, datas);
            Main.abilita(1);
        } else {
            Team.getA().virarse('c');
            Team.getJ1().virarse('m');
            Team.getJ2().virarse('m');
            repaint();
            Main.muestraPunt(1, puntU, puntM, datas);
            cargaParcial();
            DibujaFichas rep = new DibujaFichas();
            rep.start();
        }
    }

    static class ParImpar extends javax.swing.JDialog {

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (pantalla.getWidth());
        int h = (int) (pantalla.getHeight());
        private javax.swing.JButton par;
        private javax.swing.JButton impar;
        private javax.swing.JButton OK;
        private javax.swing.JLabel paim;
        private Comp pa;
        private Card f;

        public ParImpar() {
            design();
        }

        public void design() {
            Random ra = new Random();
            pa = new Comp();
            paim = new javax.swing.JLabel("");
            par = new javax.swing.JButton("even");
            impar = new javax.swing.JButton("odd");
            OK = new javax.swing.JButton("OK");
            OK.setVisible(false);
            f = Animation.getSobra()[ra.nextInt(15)];
            f.setOrient('a');
            par.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clicked1(evt);
                }
            });
            impar.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clicked2(evt);
                }
            });
            OK.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clicked3(evt);
                }
            });
            this.setModal(true);
            this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            this.setTitle("Even or Odd?");
            this.setResizable(false);
            this.setSize(200, 200);
            this.setLocation((w - 200) / 2, (h - 200) / 2);
            this.setLayout(null);
            this.add(OK);
            OK.setBounds(70, 145, 60, 25);
            this.add(par);
            par.setBounds(40, 145, 60, 25);
            this.add(impar);
            impar.setBounds(100, 145, 60, 25);
            this.add(pa);
            pa.setBounds(85, 40, 30, 60);
            this.add(paim);
            paim.setBounds(2, 110, 200, 25);
        }

        class Comp extends javax.swing.JPanel {

            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(f.getImf(), 0, 0, this);
            }
        }

        private void clicked1(ActionEvent evt) {
            if (f.isDoble()) {
                f.setOrient('v');
            } else {
                f.setOrient('n');
            }
            pa.repaint();
            if (f.getSum() % 2 == 0) {
                paim.setText("Guessed, card is even, you can start!");
                Animation.turn = 1;
            } else {
                paim.setText("Failed, card is odd, machine starts!");
                Random ra = new Random();
                int w = ra.nextInt(4);
                if (w < 2) {
                    Animation.turn = 2;
                } else {
                    Animation.turn = 4;

                }
            }
            par.setVisible(false);
            impar.setVisible(false);
            OK.show();
        }

        private void clicked2(ActionEvent evt) {
            if (f.isDoble()) {
                f.setOrient('v');
            } else {
                f.setOrient('n');
            }
            pa.repaint();
            if (f.getSum() % 2 == 0) {
                paim.setText("Failed, card is even, machine starts!");
                Random ra = new Random();
                int w = ra.nextInt(4);
                if (w < 2) {
                    Animation.turn = 2;
                } else {
                    Animation.turn = 4;

                }
            } else {
                paim.setText("Guessed, card is odd, you can start!");
                Animation.turn = 1;
            }
            par.setVisible(false);
            impar.setVisible(false);
            OK.show();
        }

        private void clicked3(ActionEvent evt) {
            this.setVisible(false);
        }
    }
}

       
        


        

 
    










