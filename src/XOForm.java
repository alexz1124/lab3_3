import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOForm {
    private JPanel mainPanel;
    private JLabel lblScoreX;
    private JLabel lblScoreDraw;
    private JLabel lblScoreO;
    private JButton bnt1;
    private JButton bnt2;
    private JButton bnt3;
    private JButton bnt4;
    private JButton bnt5;
    private JButton bnt6;
    private JButton bnt7;
    private JButton bnt8;
    private JButton bnt9;
    private OX ox;
    private int col;
    private int row;
    public XOForm() {
        ox = new OX();
        bnt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 0;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 0;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 0;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 1;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 1;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 1;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 2;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 2;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        bnt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 2;
                if (ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
    }

    private void process() {
        if (ox.checkWin(col,row)){
            int result = JOptionPane.showConfirmDialog(null,ox.getCurrentPlayer() +" WIN,"
                    + "Do you want to play again?","WIN",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                ox.reset();
                render();
                return;
            }else{
                System.exit(0);
            }
        }else if (ox.isDraw()){
            int result = JOptionPane.showConfirmDialog(null,"DRAW,"
                    + "Do you want to play again?","DRAW",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                ox.reset();
                render();
                return;
            }else{
                System.exit(0);
            }
        }
        ox.switchPlayer();
    }

    private void render() {
        bnt1.setText(ox.get(0,0));
        bnt2.setText(ox.get(1,0));
        bnt3.setText((ox.get(2,0)));
        bnt4.setText(ox.get(0,1));
        bnt5.setText(ox.get(1,1));
        bnt6.setText((ox.get(2,1)));
        bnt7.setText(ox.get(0,2));
        bnt8.setText(ox.get(1,2));
        bnt9.setText((ox.get(2,2)));
        lblScoreX.setText("X : "+ox.getScoreX());
        lblScoreDraw.setText("Draw : "+ox.getScoreDraw());
        lblScoreO.setText("O : "+ox.getScoreO());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        XOForm from = new XOForm();
        frame.setContentPane(from.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
