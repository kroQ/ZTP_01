
public class Levenshtein {

    int len0, len1;
    int[] cost, newcost;

    public int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
        setVariables(lhs, rhs);
        setCost(len0);
        startCore(len1, lhs, rhs);
        return cost[len0 - 1];
    }

    private void setVariables(CharSequence lhs, CharSequence rhs) {
        len0 = lhs.length() + 1;
        len1 = rhs.length() + 1;
        cost = new int[len0];
        newcost = new int[len0];
    }

    private void setCost(int len0) {
        for (int i = 0; i < len0; i++) {
            cost[i] = i;
        }
    }
    
    private void startCore(int len1, CharSequence lhs, CharSequence rhs) {
        for (int j = 1; j < len1; j++) {
            newcost[0] = j;
            countNewCost(lhs, rhs, j);
            int[] swap = cost;
            cost = newcost;
            newcost = swap;
        }
    }

    private void countNewCost(CharSequence lhs, CharSequence rhs, int j) {
        for (int i = 1; i < len0; i++) {
            int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;
            int replace = cost[i - 1] + match;
            int insert = cost[i] + 1;
            int delete = newcost[i - 1] + 1;
            newcost[i] = Math.min(Math.min(insert, delete), replace);
        }
    }
}
