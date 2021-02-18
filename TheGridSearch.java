public class TheGridSearch {


    public static void main(String[] args) {
        String[] grid = new String[10];
        String[] pattern = new String[10];
        grid[0] = "7283455864";
        grid[1] = "7283455864";
        grid[2] = "7283455864";
        grid[3] = "7283455864";
        grid[4] = "7283455864";
        grid[5] = "7283455864";
        grid[6] = "7283455864";
        grid[7] = "7283455864";
        grid[7] = "7283455864";
        grid[7] = "7283455864";

        if(startsWith("123456", "123")) {

        };
        gridSearch(grid, pattern);

    }

    private static boolean startsWith(String s, String s1) {
        System.out.println();
        return s.startsWith(s1);
    }

    static String gridSearch(String[] G, String[] P) {
        boolean patternIsPressent = false;
        String inLinePattern  = convertPatternInOneLine(P);
        for(int i = 0; i < G.length; i ++ ) {
            for (int j=0; j < G[i].length(); j++) {
                patternIsPressent = thatPositionMatchThePattern(i,j,G,P,inLinePattern);
                if (patternIsPressent) return "YES";
            }
        }
        return "NO";
    }

    private static boolean thatPositionMatchThePattern(int i, int j, String[] g, String[] p, String pattern) {
        int amountColumsPattern = p[0].length();
        int amountRowsPattern = p.length;
        StringBuilder inLine = new StringBuilder("");
        for (int row= 0; row < amountRowsPattern; row++) {
            if ( i + row < g.length  && j + amountColumsPattern -1 < g[i+row].length()) {
                if (pattern.startsWith(g[i+row].substring(j, j+amountColumsPattern))) return false;
                    inLine.append(g[i+row].substring(j, j+amountColumsPattern));
            }
        }
        return inLine.toString().equalsIgnoreCase(pattern);
    }

    private static String convertPatternInOneLine(String[] p) {
        StringBuilder inLine = new StringBuilder("");
        for (int i = 0; i < p.length; i++) {
            inLine.append(p[i]);
        }
        System.out.println("The amount of row is :");
        return inLine.toString();
    }

}
