import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    private Controller controller;

    public Viewer() {
        controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);
        JMenuBar menu = getMenuBar();
        frame = new JFrame("Sokoban MVC Pattern");
        frame.setJMenuBar(menu);
        frame.setLocationRelativeTo(null);
        frame.setSize(700,700);
        frame.add("Center",canvas);
        frame.setLocation(500,0);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    public void update() {
        canvas.repaint();
    }

    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You won!!!!!!");
        return true;
    }

    private JMenuBar getMenuBar() {    
        JMenuItem firstLevel = new JMenuItem("Level 1");
        firstLevel.addActionListener(controller);
        firstLevel.setActionCommand("Level 1");

        JMenuItem secondLevel = new JMenuItem("Level 2");
        secondLevel.addActionListener(controller);
        secondLevel.setActionCommand("Level 2");

        JMenuItem thirdLevel = new JMenuItem("Level 3");
        thirdLevel.addActionListener(controller);
        thirdLevel.setActionCommand("Level 3");

        JMenuItem fourthLevel = new JMenuItem("Level 4");
        fourthLevel.addActionListener(controller);
        fourthLevel.setActionCommand("Level 4");

        JMenuItem fifthLevel = new JMenuItem("Level 5");
        fifthLevel.addActionListener(controller);
        fifthLevel.setActionCommand("Level 5");

        JMenuItem sixthLevel = new JMenuItem("Level 6");
        sixthLevel.addActionListener(controller);
        sixthLevel.setActionCommand("Level 6");

        JMenuItem seventhLevel = new JMenuItem("Level 7");
        seventhLevel.addActionListener(controller);
        seventhLevel.setActionCommand("Level 7");

        JMenuItem eighthLevel = new JMenuItem("Level 8");
        eighthLevel.addActionListener(controller);
        eighthLevel.setActionCommand("Level 8");

        JMenuItem ninethLevel = new JMenuItem("Level 9");
        ninethLevel.addActionListener(controller);
        ninethLevel.setActionCommand("Level 9");

        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(controller);
        restart.setActionCommand("Restart");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(controller);
        exit.setActionCommand("Exit");

        JMenuBar menuBar = new JMenuBar();
        JMenuBar mainMenu = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        mainMenu.add(menu);
        menu.add(restart);
        menu.add(exit);

        JMenuBar containerMenuLevel = new JMenuBar();
        JMenu levelsMenu = new JMenu("Levels");
        containerMenuLevel.add(levelsMenu);
        levelsMenu.add(firstLevel);
        levelsMenu.add(secondLevel);
        levelsMenu.add(thirdLevel);
        levelsMenu.add(fourthLevel);
        levelsMenu.add(fifthLevel);
        levelsMenu.add(sixthLevel);
        levelsMenu.add(seventhLevel);
        levelsMenu.add(eighthLevel);
        levelsMenu.add(ninethLevel);
        menuBar.add(mainMenu);
        menuBar.add(containerMenuLevel);
        return menuBar;
    }
}