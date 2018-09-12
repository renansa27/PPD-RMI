package rmiPPD;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author renan
 */
public class ClienteFramePPD extends javax.swing.JFrame implements EventListener {

    private String name, message;
    String mapaJogo;
    String corPeca = "vermelho";
    private ClientePPD chatClient;
    boolean vez = false;
    String ipServidor = "";
    int portaCliente = 0;

    /**
     * Creates new form ClienteFrame
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteFramePPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JTextField nome = new JTextField();
        JTextField ip = new JTextField();
        Object[] dialog = {
            "Nome", nome,
            "Ip", ip
        };
        int opcao = JOptionPane.showConfirmDialog(null, dialog, "Dados para conexão", JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                ClienteFramePPD clienteFrame = new ClienteFramePPD(nome.getText(), ip.getText());
                clienteFrame.setResizable(false);
                clienteFrame.setVisible(true);
                System.out.println("Cliente Criado!");
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não criado!");
        }
    }

    public ClienteFramePPD(String name, String ip) throws RemoteException {
        super("Trabalho PPD - Sockets");
        ipServidor = ip;
        this.name = name;
        this.mapaJogo = "AABVV";
        initComponents();
        getConnected(name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanelChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaTextoEnviar = new javax.swing.JTextArea();
        Desistir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaTextoReceber = new javax.swing.JTextArea();
        PanelJogo = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button3 = new java.awt.Button();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SuaCor = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                Fechar(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PONG-HAU-KI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelChat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AreaTextoEnviar.setColumns(20);
        AreaTextoEnviar.setLineWrap(true);
        AreaTextoEnviar.setRows(1);
        AreaTextoEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        AreaTextoEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaTextoEnviarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ResolveEnter(evt);
            }
        });
        jScrollPane1.setViewportView(AreaTextoEnviar);

        Desistir.setText("Desistir");
        Desistir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DesistirMouseClicked(evt);
            }
        });

        AreaTextoReceber.setEditable(false);
        AreaTextoReceber.setColumns(20);
        AreaTextoReceber.setLineWrap(true);
        AreaTextoReceber.setRows(5);
        AreaTextoReceber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AreaTextoReceber.setDragEnabled(true);
        jScrollPane3.setViewportView(AreaTextoReceber);

        javax.swing.GroupLayout PanelChatLayout = new javax.swing.GroupLayout(PanelChat);
        PanelChat.setLayout(PanelChatLayout);
        PanelChatLayout.setHorizontalGroup(
            PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Desistir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addContainerGap())
        );
        PanelChatLayout.setVerticalGroup(
            PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChatLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Desistir)
                .addGap(16, 16, 16))
        );

        PanelJogo.setBackground(new java.awt.Color(255, 255, 255));
        PanelJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelJogo.setForeground(new java.awt.Color(240, 240, 240));

        button1.setBackground(new java.awt.Color(51, 51, 240));
        button1.setForeground(new java.awt.Color(51, 51, 255));
        button1.setBackground(new java.awt.Color(51,51,255));
        button1.setLabel("");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });

        button2.setBackground(new java.awt.Color(51, 51, 240));
        button2.setForeground(new java.awt.Color(51, 51, 255));
        button2.setLabel("");
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });

        button4.setBackground(new java.awt.Color(255, 0, 0));
        button4.setForeground(new java.awt.Color(51, 51, 255));
        button4.setLabel("");
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
        });

        button5.setBackground(new java.awt.Color(255, 0, 0));
        button5.setForeground(new java.awt.Color(51, 51, 255));
        button5.setLabel("");
        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button5MouseClicked(evt);
            }
        });

        button3.setBackground(new java.awt.Color(255, 255, 255));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("");
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/horizontal.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/vertical.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/diagonal_2.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Diagonal3.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Diagonal1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Diagonal4.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/vertical.png"))); // NOI18N

        javax.swing.GroupLayout PanelJogoLayout = new javax.swing.GroupLayout(PanelJogo);
        PanelJogo.setLayout(PanelJogoLayout);
        PanelJogoLayout.setHorizontalGroup(
            PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJogoLayout.createSequentialGroup()
                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelJogoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelJogoLayout.createSequentialGroup()
                        .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(59, 59, 59)
                                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJogoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(14, 14, 14)))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelJogoLayout.createSequentialGroup()
                    .addGap(0, 243, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 243, Short.MAX_VALUE)))
        );
        PanelJogoLayout.setVerticalGroup(
            PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelJogoLayout.createSequentialGroup()
                        .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6)))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(403, 403, 403))
                    .addGroup(PanelJogoLayout.createSequentialGroup()
                        .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelJogoLayout.createSequentialGroup()
                                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelJogoLayout.createSequentialGroup()
                    .addGap(0, 407, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 408, Short.MAX_VALUE)))
        );

        SuaCor.setText("Sua cor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SuaCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SuaCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AreaTextoEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaTextoEnviarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AreaTextoEnviar.requestFocus();
        }
    }//GEN-LAST:event_AreaTextoEnviarKeyPressed

    private void DesistirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesistirMouseClicked
        int respostaDesistir = JOptionPane.showConfirmDialog(null, "Aceitando a derrota uma nova partida será criada!", "Reiniar jogo", JOptionPane.YES_NO_OPTION);
        if (respostaDesistir == JOptionPane.YES_OPTION) {
            try {
                chatClient.servidor.updateSurrender(corPeca);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DesistirMouseClicked

    private void Fechar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Fechar
        int derrota = JOptionPane.showConfirmDialog(null, "Aceita a derrota?", "Fechar jogo", JOptionPane.YES_NO_OPTION);
        if (derrota == JOptionPane.YES_OPTION) {
            try {
                chatClient.servidor.leaveChat(name);
            } catch (RemoteException e) {

            }
            System.exit(0);
        }
    }//GEN-LAST:event_Fechar

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
        if (vez) {
            char[] posicoes = mapaJogo.toCharArray();
            Color cor = button3.getBackground();
            if (((cor.getRGB() == -13421584 || cor.getRGB() == -13421569) && "azul".equals(corPeca)) || (cor.getRGB() == -65536 && "vermelho".equals(corPeca))) {
                if (posicoes[0] == 'B') {
                    button1.setBackground(new java.awt.Color(cor.getRGB()));
                    button3.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 0, 2);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[1] == 'B') {
                    button2.setBackground(new java.awt.Color(cor.getRGB()));
                    button3.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 2, 1);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[3] == 'B') {
                    button4.setBackground(new java.awt.Color(cor.getRGB()));
                    button3.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 3, 2);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[4] == 'B') {
                    button5.setBackground(new java.awt.Color(cor.getRGB()));
                    button3.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 2, 4);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada proibida!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mova apenas sua peça!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espere sua vez!");
        }
    }//GEN-LAST:event_button3MouseClicked

    private void button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseClicked
        if (vez) {
            char[] posicoes = mapaJogo.toCharArray();
            Color cor = button5.getBackground();
            if (((cor.getRGB() == -13421584 || cor.getRGB() == -13421569) && "azul".equals(corPeca)) || (cor.getRGB() == -65536 && "vermelho".equals(corPeca))) {
                if (posicoes[1] == 'B') {
                    button2.setBackground(new java.awt.Color(cor.getRGB()));
                    button5.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 4, 1);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[2] == 'B') {
                    button3.setBackground(new java.awt.Color(cor.getRGB()));
                    button5.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 4, 2);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[3] == 'B') {
                    button4.setBackground(new java.awt.Color(cor.getRGB()));
                    button5.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 3, 4);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada proibida!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mova apenas sua peça!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espere sua vez!");
        }
    }//GEN-LAST:event_button5MouseClicked

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        if (vez) {
            char[] posicoes = mapaJogo.toCharArray();
            Color cor = button4.getBackground();
            if (((cor.getRGB() == -13421584 || cor.getRGB() == -13421569) && "azul".equals(corPeca)) || (cor.getRGB() == -65536 && "vermelho".equals(corPeca))) {
                if (posicoes[0] == 'B') {
                    button1.setBackground(new java.awt.Color(cor.getRGB()));
                    button4.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 0, 3);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[2] == 'B') {
                    button3.setBackground(new java.awt.Color(cor.getRGB()));
                    button4.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 2, 3);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[4] == 'B') {
                    button5.setBackground(new java.awt.Color(cor.getRGB()));
                    button4.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 3, 4);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada proibida!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mova apenas sua peça!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espere sua vez!");
        }
    }//GEN-LAST:event_button4MouseClicked

//Clique do Mouse

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        if (vez) {
            char[] posicoes = mapaJogo.toCharArray();
            Color cor = button2.getBackground();
            if (((cor.getRGB() == -13421584 || cor.getRGB() == -13421569) && "azul".equals(corPeca)) || (cor.getRGB() == -65536 && "vermelho".equals(corPeca))) {
                if (posicoes[2] == 'B') {
                    button3.setBackground(new java.awt.Color(cor.getRGB()));
                    button2.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();
                    swap(posicoes, 1, 2);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        System.out.println("Mandei o mapa "+mapaJogo+" para o servidor");
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[4] == 'B') {
                    button5.setBackground(new java.awt.Color(cor.getRGB()));
                    button2.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();
                    swap(posicoes, 1, 4);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada proibida!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mova apenas sua peça!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espere sua vez!");
        }
    }//GEN-LAST:event_button2MouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        if (vez) {
            char[] posicoes = mapaJogo.toCharArray();
            Color cor = button1.getBackground();
            if (((cor.getRGB() == -13421584 || cor.getRGB() == -13421569) && "azul".equals(corPeca)) || (cor.getRGB() == -65536 && "vermelho".equals(corPeca))) {
                if (posicoes[2] == 'B') {
                    button3.setBackground(new java.awt.Color(cor.getRGB()));
                    button1.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 0, 2);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (posicoes[3] == 'B') {
                    button4.setBackground(new java.awt.Color(cor.getRGB()));
                    button1.setBackground(new java.awt.Color(255, 255, 255));
                    repaint();

                    swap(posicoes, 0, 3);
                    mapaJogo = String.valueOf(posicoes);
                    try {
                        chatClient.servidor.updateMap(mapaJogo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada proibida!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mova apenas sua peça!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espere sua vez!");
        }
    }//GEN-LAST:event_button1MouseClicked

    private void ResolveEnter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResolveEnter
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                message = AreaTextoEnviar.getText();
                AreaTextoEnviar.setText("");
                sendMessage(message);
                System.out.println("Sending message : " + message);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResolveEnter

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextArea AreaTextoEnviar;
    protected javax.swing.JTextArea AreaTextoReceber;
    private javax.swing.JButton Desistir;
    private javax.swing.JPanel PanelChat;
    private javax.swing.JPanel PanelJogo;
    public javax.swing.JLabel SuaCor;
    protected java.awt.Button button1;
    protected java.awt.Button button2;
    protected java.awt.Button button3;
    protected java.awt.Button button4;
    protected java.awt.Button button5;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void getConnected(String userName) throws RemoteException {
        String cleanedUserName;
        cleanedUserName = userName.replaceAll("\\s+", "_");
        cleanedUserName = userName.replaceAll("\\W+", "_");
        try {
            chatClient = new ClientePPD(this, cleanedUserName);
            chatClient.startClient();
        } catch (RemoteException e) {
            System.out.println("Não foi possivel conectar ao servidor!");
        }
    }

    private void sendMessage(String chatMessage) throws RemoteException {
        chatClient.servidor.updateChat(name, chatMessage);
    }

    private void swap(char[] posicoes, int num1, int num2) {
        char aux = posicoes[num2];
        posicoes[num2] = posicoes[num1];
        posicoes[num1] = aux;
    }
}