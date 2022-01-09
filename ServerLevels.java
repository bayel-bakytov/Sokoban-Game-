public class ServerLevels implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] desktop;

    public ServerLevels(int[][] desktop) {
        this.desktop = desktop;
    }

    public int[][] getServerLevels() {
        return desktop;
    }
  
}
