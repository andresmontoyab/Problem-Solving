public class QueenAttacksTwo {
    public static void main(String[] args) {
        /**
         * 5 3
         * 4 3
         * 5 5
         * 4 2
         * 2 3
         */
        int[][] obstacles_position = new int[3][2];
        obstacles_position[0][0] = 5;
        obstacles_position[0][1] = 5;

        obstacles_position[1][0] = 4;
        obstacles_position[1][1] = 2;

        obstacles_position[2][0] = 2;
        obstacles_position[2][1] = 3;

        int queensAttack = queensAttack(100000 , 0, 4187 , 5068, null);
        System.out.println(queensAttack );
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int left = c_q -1;
        int right = n -c_q;
        int up = r_q -1;
        int down = n - r_q;

        int left_upper_obs = minVal(r_q -1, c_q-1);
        int right_upper_obs = minVal(r_q -1, n - c_q);
        int right_lower_obs = minVal(n - r_q ,n - c_q);
        int left_lower_obs = minVal(n - r_q , c_q-1);
        if (obstacles != null) {
        for (int i = 0; i < obstacles.length; i ++) {
            int[] obs = obstacles[i];

            //left
            if (r_q == obs[0] && obs[1] < c_q) {
                left = c_q - 1 - obs[1];
            }

            //right
            if (r_q == obs[0] && obs[1] > c_q) {
                right= obs[1] - c_q -1;
            }

            // up
            if (c_q == obs[1] && obs[0] < r_q ) {
                up = r_q - 1 - obs[0];
            }

            // down
            if (c_q == obs[1] && obs[0] > r_q ) {
                down = obs[0] - r_q -1 ;
            }

            //left_upper_obs
            if (isInMainDiagonal(obs, r_q, c_q) && obs[0] < r_q && r_q - 1 - obs[0] < left_upper_obs) {
                left_upper_obs = r_q - 1 - obs[0];
            }

            //right_upper_obs
            if (isInSecondDiagonal(obs, r_q, c_q) && obs[0] < r_q &&  r_q - 1 - obs[0] < right_upper_obs) {
                right_upper_obs = r_q - 1 - obs[0];
            }

            //right_lower_obs
            if (isInMainDiagonal(obs, r_q, c_q) && obs[0] > r_q && obs[0] -1 - r_q < right_lower_obs) {
                right_lower_obs = obs[0] -1 - r_q;
            }

            //left_lower_obs
            if (isInSecondDiagonal(obs, r_q, c_q) && obs[0] > r_q &&  obs[0] -1 - r_q< left_lower_obs) {
                left_lower_obs = obs[0] -1 - r_q;
            }
        }
        }
        return left + right + up + down + left_lower_obs + left_upper_obs + right_lower_obs + right_upper_obs;
    }

    private static boolean isInMainDiagonal(int[] obs, int r_q, int c_q) {
        return ((obs[0] - obs[1]) == r_q - c_q);
    }

    private static boolean isInSecondDiagonal(int[] obs, int r_q, int c_q) {
        return ((obs[0] + obs[1]) == r_q + c_q);
    }

    private static int minVal(int a, int b) {
        if (a > b) return b;
        return a;
    }


}
