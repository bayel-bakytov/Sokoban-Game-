import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Levels {
    private int level;
    private LevelParser levelParser;

    public Levels() {
        level = 1;
        levelParser = new LevelParser();
    }

    public int[][] nextLevel() {
        int[][] desktop = null;
        switch (level) {
            case 1:
                desktop = getFirstLevel();
                break;
            case 2:
                desktop = getSecondLevel();
                break;    
            case 3:
                desktop = getThirdLevel();
                break;
            case 4:
                desktop = levelParser.newLevel("levels/level4.sok");
                break;
            case 5:
                desktop = levelParser.newLevel("levels/level5.sok");
                break;
            case 6:
                desktop = levelParser.newLevel("levels/level6.sok");
                break;
            case 7:
                desktop = getLevelFromServer("7");
                break;  
            case 8:
                desktop = getLevelFromServer("8");
                break;  
            case 9:
                desktop = getLevelFromServer("9");
                break;  
            default:
                level = 1;
                desktop = getFirstLevel();
                break;
        }
        level = level + 1;
        return desktop;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    private int[][] getFirstLevel() {
        int[][] levelFirst = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 4, 2},
            {2, 0, 0, 0, 3, 0, 2, 0, 0, 2},
            {2, 0, 3, 4, 0, 0, 2, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 2},
            {2, 1, 0, 2, 2, 2, 2, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelFirst;
    }

    private int[][] getSecondLevel() {
        int[][] levelSecond = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 1, 2, 0, 0, 0, 4, 0, 2},
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 3, 0, 0, 2},
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 2, 0, 3, 0, 0, 0, 2},
            {2, 4, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelSecond;
    }

    private int[][] getThirdLevel() {
        int[][] levelThird = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 4, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 4, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 1, 0, 0, 3, 0, 0, 2},
            {2, 0, 3, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 3, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 4, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelThird;
    }

    public int[][] getLevelFromServer(String level) {
        String hostName = "194.152.37.7";
        //String hostName = "localhost";
        int portNumber = 4446;
        System.out.println("Connection to Server ...");
        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter outputStream = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        )
        {
            outputStream.println(level);  
            outputStream.flush();
            ServerLevels object = (ServerLevels)in.readObject();
            int[][] desktop = object.getServerLevels();
            System.out.println("A desktop from server is " + desktop);
            return desktop;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe);
            this.level = 1;
            return getFirstLevel();
        } 
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
            this.level = 1;
            return getFirstLevel();
        }
    }
}