import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Image;
import java.awt.Font;

public class Canvas extends JPanel {
    private Model model;
    private Image imageGamer;
    private Image imageWall; 
    private Image imageBox;
    private Image imageGoal;
    private Image imageGround;

    public Canvas (Model model) {
        this.model = model;
        setBackground(new Color(40,114,51));
        setOpaque(true);
        File fileNameImageGamer = new File("images/gamer.png");
        File fileNameImageWall = new File("images/wall.png");
        File fileNameImageBox = new File("images/box.png");
        File fileNameImageGoal = new File("images/goal.png");
        File fileNameImageGround = new File("images/ground.png");
        try {
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
            imageGround = ImageIO.read(fileNameImageGround);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void drawError(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.RED);
        g.drawRect(70, 160, 495, 60);
        g.drawString("Error Level is incorrect structure!!!!", 85, 200);
    }

    public void paint (Graphics g) {
        super.paint(g);
        if (model.getIsOk()) {
            drawDesktop(g);
        } 
        else {
            drawError(g);
        }
    }

    private void drawDesktop(Graphics g) {
        int offset = 0;
        int start = 50;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int[][] desktop = model.getDesktop();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 0) {
                    g.drawImage(imageGround, x, y, null);
                } else if (desktop[i][j] == 1) {
                    g.drawImage(imageGamer, x, y, null);
                } else if (desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if (desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if (desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);
                } 
                x = x + width + offset;
            }
            x = start;
            y = y + height + offset;
        }
    }
}