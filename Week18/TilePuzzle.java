import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TilePuzzle extends JPanel implements ActionListener{
    private TilePiece[] tiles = new TilePiece[12];
    private TilePiece blankTile = new TilePiece("blank_tile.jpg", 0, 0);
    private JFrame frame = new JFrame();

    public TilePuzzle() {
        this.frame.setSize(475, 400);
        GridLayout layout = new GridLayout(3, 4);
        for (int i = 0; i < 11; i++) {
            String filename = "tile_" + i + ".jpg";
            tiles[i] = new TilePiece(filename, 0, 0);
            this.tiles[i].addActionListener(this);
            frame.add(tiles[i]);
        }
        this.frame.setLayout(layout);
        this.frame.add(blankTile);
        this.frame.setVisible(true);
    }

    //git testing...
    public void actionPerformed(ActionEvent e) {
        TilePiece t = (TilePiece)e.getSource();
        if (blankTile.isAdjacentTo(t)) {
            blankTile.exchangeImageWith(t);
        }
    }
}
