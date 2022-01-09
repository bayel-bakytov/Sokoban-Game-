public class ServerLevels implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private int[][] desktop;

    public ServerLevels() {
        desktop = null;
    }

    private void seventhLevel() {
        desktop = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 1, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 4, 0, 2},
            {2, 0, 0, 0, 3, 2, 0, 0, 2, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 4, 2},
            {2, 0, 0, 0, 3, 2, 0, 3, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 4, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
    };
    
    private void eighthLevel() {
        desktop = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 4, 0, 0, 0, 2, 0, 1, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 0, 2, 2, 0, 0, 0, 4, 0, 2},
            {2, 0, 3, 0, 3, 0, 0, 0, 2, 2},
            {2, 0, 0, 0, 3, 0, 0, 0, 4, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 0, 3, 0, 0, 2, 0, 4, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
    };


    private void ninethLevel() {
        desktop = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 1, 0, 0, 0, 0, 0, 2, 4, 2},
            {2, 0, 0, 0, 2, 2, 2, 2, 0, 2},
            {2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 2, 4, 0, 0, 0, 2},
            {2, 0, 3, 0, 2, 2, 2, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 2, 0, 0, 2},
            {2, 2, 0, 3, 0, 0, 3, 0, 0, 2},
            {2, 4, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
    };

    public int[][] getNewLevel(int level) {
        switch (level) {
            case 7:
                seventhLevel();
                break;
            case 8:
                eighthLevel();
                break;
            case 9:
                ninethLevel();
                break;
            default:
                break;
        }
        return desktop;
    }
}
