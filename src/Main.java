
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 *@author Jose Soto
 */
class Main extends JFrame {

    static String userName = "",  userTeam = "";
    static int score;
    private final Media media = new Media();
    static javax.swing.JMenuItem dom;
    static javax.swing.JMenuItem checkScore;
    static javax.swing.JMenuItem newGame;
    static javax.swing.JMenuItem moves;
    private javax.swing.JButton continueGame;
    static javax.swing.JButton startNewGame;
    static javax.swing.JButton start;
    static javax.swing.JButton OK;
    private javax.swing.JTextField name;
    private javax.swing.JSpinner teamMachine;
    static javax.swing.JComboBox<String> team;
    private static javax.swing.JTable table;
    private static javax.swing.JDialog dialog;
    static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    static int w = (int) (screen.getWidth());
    static int h = (int) (screen.getHeight());
    private Animation f;

    public Main() {

        design();
        animation();
    }

    private void animation() {
        f = new Animation();
        this.add(f);
        f.setBounds(-2, -29, 800, 600);
        DesignStart t = new DesignStart();
        t.start();
        ShowConfig t1 = new ShowConfig();
        t1.start();
        setVisible(true);
    }

    public void design() {

        
        dialog = new javax.swing.JDialog();
        dialog.setModal(true);
        table = new javax.swing.JTable();
        table.setShowHorizontalLines(false);
        name = new javax.swing.JTextField();
        name.setFont(new java.awt.Font("Arial Black", 0, 32));
        name.setText("User");
        name.setOpaque(false);
        name.selectAll();
        name.setVisible(false);
        teamMachine = new javax.swing.JSpinner();
        teamMachine.setFont(new java.awt.Font("Arial Black", 0, 40));
        teamMachine.setModel(new javax.swing.SpinnerNumberModel(100, 10, 250, 10));
        teamMachine.setVisible(false);
        team = new javax.swing.JComboBox<String>();
        team.addItem("Greedy");
        team.addItem("Ally");
        team.addItem("Domineering");
        team.setForeground(new java.awt.Color(0, 0, 0));
        team.setFont(new java.awt.Font("Arial Black", 0, 20));
        team.setVisible(false);
        continueGame = new javax.swing.JButton();
        continueGame.setOpaque(false);
        startNewGame = new javax.swing.JButton("Play Again");
        start = new javax.swing.JButton("Cancel");
        OK = new javax.swing.JButton("OK");
        OK.setVisible(false);
        javax.swing.JSeparator sep = new javax.swing.JSeparator();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu game = new javax.swing.JMenu();
        javax.swing.JMenu help = new javax.swing.JMenu();
        dom = new javax.swing.JMenuItem();
        newGame = new javax.swing.JMenuItem();
        checkScore = new javax.swing.JMenuItem();
        moves = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exit = new javax.swing.JMenuItem();
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null}
                },
                new String[]{
                    "", ""
                }) {

            final boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        dialog.setLayout(null);
        dialog.add(OK);
        OK.setBounds(95, 250, 60, 25);
        dialog.add(startNewGame);
        startNewGame.setBounds(5, 250, 120, 25);
        dialog.add(start);
        start.setBounds(128, 250, 90, 25);
        dialog.add(table);
        table.setBounds(0, 0, 250, 320);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(800, 624);
        this.setLocation((w - 800) / 2, (h - 624) / 2);
        this.setResizable(false);
        this.setIconImage(Objects.requireNonNull(Media.cIcon("cards/wit.png")).getImage());
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        moves.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked8(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked5(evt);
            }
        });
        OK.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked5(evt);
            }
        });
        startNewGame.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked12(evt);
            }
        });
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked1(evt);
            }
        });
        continueGame.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked2(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked3(evt);
            }
        });
        checkScore.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked4(evt);
            }
        });
        dom.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked6(evt);
            }
        });
        moves.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        newGame.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        checkScore.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        exit.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        continueGame.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        dom.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        dom.setText("About");
        moves.setText("Moves");
        moves.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        moves.setIcon(Media.cIcon("buttons/edit-find-replace.png"));
        moves.setEnabled(false);
        checkScore.setText("Score");
        checkScore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        checkScore.setIcon(Media.cIcon("buttons/edit-find-replace.png"));
        checkScore.setEnabled(false);
        exit.setText("Exit");
        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        exit.setIcon(Media.cIcon("buttons/exit.png"));
        newGame.setText("New Game");
        newGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        newGame.setIcon(Media.cIcon("buttons/restart.png"));
        dom.setIcon(Media.cIcon("cards/wit.png"));
        game.setText("Game");
        help.setText("Help");
        game.setIcon(Media.cIcon("buttons/system-run.png"));
        this.setTitle("Domino Game");
        jMenuBar1.add(game);
        jMenuBar1.add(help);
        help.add(dom);
        game.add(newGame);
        game.add(checkScore);
        game.add(moves);
        game.add(sep);
        game.add(exit);

        this.setLayout(null);
        this.add(name);
        name.setBounds(416, 177, 150, 50);
        this.add(teamMachine);
        teamMachine.setBounds(416, 266, 150, 50);
        this.add(team);
        team.setBounds(416, 229, 150, 35);
        this.add(continueGame);
        continueGame.setVisible(false);
        continueGame.setBackground(Color.RED);
        continueGame.setBorder(null);
        continueGame.setBorderPainted(false);
        continueGame.setRolloverIcon(Media.cIcon("buttons/continue1a.png"));
        continueGame.setIcon(Media.cIcon("buttons/continue1.png"));
        continueGame.setBounds(328, 321, 140, 48);
        setJMenuBar(jMenuBar1);

    }


    class ShowConfig extends Thread {
        public void run() {
            f.showConfig();
            continueGame.setVisible(true);
            name.setVisible(true);
            teamMachine.setVisible(true);
            teamMachine.setValue(100);
            team.setVisible(true);

        }
    }

    class DesignStart extends Thread {
        public void run() {
            f.designStart();
        }
    }

    public void clicked12(java.awt.event.ActionEvent evt) {
        dialog.setVisible(false);
        f.Load(1);
        DesignStart t = new DesignStart();
        t.start();
        ShowConfig t1 = new ShowConfig();
        t1.start();
        team.setSelectedIndex(0);
    }

    public void clicked1(java.awt.event.ActionEvent evt) {
        int r = JOptionPane.showConfirmDialog(this, "You want to leave?", "Warning", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            f.Load(1);
            DesignStart t = new DesignStart();
            t.start();
            ShowConfig t1 = new ShowConfig();
            t1.start();
            team.setSelectedIndex(0);
        }
    }

    class HideConfig extends Thread {

        public void run() {
            continueGame.setVisible(false);
            name.setVisible(false);
            teamMachine.setVisible(false);
            team.setVisible(false);
            f.hideConfig();
        }
    }

    class DesignTable extends Thread {
        public void run() {
            f.designTable(0);
        }
    }

    public static void enableMenu(int i) {
        newGame.setEnabled(true);
        checkScore.setEnabled(true);
        dom.setEnabled(true);
        moves.setEnabled(true);

    }

    public static void disableMenu() {
        newGame.setEnabled(false);
        checkScore.setEnabled(false);
        dom.setEnabled(false);
        moves.setEnabled(false);

    }

    public static void showScore(int tipo, int v1, int v2, int fil) {

        dialog.setLocation((w - 250) / 2, (h - 320) / 2);
        dialog.setResizable(false);
        dialog.setSize(250, 320);
        table.setValueAt(userName + "/" + userTeam, 0, 0);
        table.setValueAt("Machine-1/Machine-2", 0, 1);
        if (tipo == 1) {
            startNewGame.setVisible(false);
            start.setVisible(false);
            OK.setVisible(true);
            dialog.setTitle("Score");
            table.setValueAt(v1, fil, 0);
            table.setValueAt(v2, fil, 1);
        } else {
            if (tipo == 2) {
                startNewGame.setVisible(true);
                start.setVisible(true);
                OK.setVisible(false);
                dialog.setTitle("Game Over");
                table.setValueAt(v1, fil, 0);
                table.setValueAt(v2, fil, 1);
                if (v1 > v2) {
                    table.setValueAt("Winner", fil + 1, 0);
                } else {
                    table.setValueAt("Winner", fil + 1, 1);
                }
            } else {
                dialog.setTitle("Score");
                startNewGame.setVisible(false);
                start.setVisible(false);
                OK.setVisible(true);
            }
        }
        dialog.setVisible(true);


    }

    public void clicked2(java.awt.event.ActionEvent evt) {
        for (int i = 1; i < table.getRowCount(); i++) {
            table.setValueAt("", i, 0);
            table.setValueAt("", i, 1);
        }
        score = (Integer) teamMachine.getValue();
        userName = name.getText();
        userTeam = (String) team.getSelectedItem();
        f.Load(team.getSelectedIndex());
        HideConfig t2 = new HideConfig();
        t2.start();
        DesignTable t4 = new DesignTable();
        t4.start();


    }

    public void clicked3(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public void clicked4(java.awt.event.ActionEvent evt) {
        showScore(3, 0, 0, 0);
    }

    private void enterM(java.awt.event.MouseEvent evt) {
        media.PlayAudio(2);
    }

    private void clicked5(ActionEvent evt) {
        
        dialog.setVisible(false);
        
    }

    private void clicked6(ActionEvent evt) {
        Dialog pi = new Dialog();
        pi.setVisible(true);
    }

    static class Dialog extends javax.swing.JDialog {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (screenSize.getWidth());
        int h = (int) (screenSize.getHeight());
        private javax.swing.JButton OK;

        public Dialog() {
            design();
        }

        public void design() {
            OK = new javax.swing.JButton("OK");
            Panel kp = new Panel();

            this.setTitle("About");
            this.setIconImage(Objects.requireNonNull(Media.cIcon("cards/wit.png")).getImage());
            this.setModal(true);
            this.setSize(300, 150);
            this.setResizable(false);
            this.setLocation((w - 300) / 2, (h - 150) / 2);
            this.setLayout(null);
            this.add(OK);
            OK.setOpaque(false);
            OK.hide();
            OK.setBounds(240, 95, 50, 25);
            this.add(kp);
            kp.setBounds(0, 0, 300, 150);
            OK.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clicked7(evt);
                }
            });


        }

        private void clicked7(ActionEvent evt) {
            this.setVisible(false);
        }

        class Panel extends JPanel {

            private int x1,  x2,  x3;

            public Panel() {
                x1 = -130;
                x2 = -130;
                x3 = -130;
                present = Objects.requireNonNull(Media.cIcon("parts/present.jpg")).getImage();
                GameThread kt = new GameThread();
                kt.start();
                repaint();
            }
            Image present;

            public void paint(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 300, 150);
                g.drawImage(present, 0, 0, 150, 130, this);
                g.setColor(Color.WHITE);
                g.drawString("DOMINO v1.0 2011", x1, 20);
                g.drawString("Author:", x2, 50);
                g.drawString("Jose Soto", x3, 80);
                
            }

            public void anim() {
                for (int i = 0; i < 160; i += 10) {
                    x1 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < 160; i += 10) {
                    x2 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < 160; i += 10) {
                    x3 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                OK.setVisible(true);
            }

            class GameThread extends Thread {
                public void run() {
                    anim();
                }
            }
        }
    }

    private void clicked8(ActionEvent evt) {
        media.PlayAudio(2);
        ArrayList<String> sucs = Animation.getSucs();
        String[] sucss = new String[sucs.size()];
        for (int i = 0; i < sucs.size(); i++) {
            sucss[i] = sucs.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(this, sucss, "Moves", JOptionPane.ERROR_MESSAGE, Media.cIcon("buttons/edit-find-replace.png"));

    }


    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch(Exception ignored){}
        JFrame.setDefaultLookAndFeelDecorated(false);
       new Main();
    }
}
