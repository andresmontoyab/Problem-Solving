import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ReallySpecialSubtree {

       static Comparator<WeightedMatrix> comp =
        new Comparator<WeightedMatrix>(){
               public int compare(WeightedMatrix a,WeightedMatrix b){
                   if(a.weight!=b.weight){
                       return a.weight-b.weight;
                   }
                   else return a.from+a.to-(b.from+b.to);
               }
    };

    public static void main(String[] args) {

    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int sum = 0;
        Set<Integer> alreadyvisitedNodes = new HashSet<>();
        Set<WeightedMatrix> weightedMatrix = buildWeightedMatrix(gFrom, gTo, gWeight);
        Iterator<WeightedMatrix> iterator = weightedMatrix.iterator();
        while(iterator.hasNext() && !(alreadyvisitedNodes.size() == gNodes)) {
            WeightedMatrix x = iterator.next();
            System.out.println(weightedMatrix);
            if (!alreadyvisitedNodes.contains(x.to)) {
                sum = sum + x.weight;
                alreadyvisitedNodes.add(x.to);
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static Set<WeightedMatrix> buildWeightedMatrix(List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        Set<WeightedMatrix> weightedMatrices = new TreeSet<>(comp);
        for(int i = 0; i<gFrom.size(); i++) {
            WeightedMatrix weightedMatrix = new WeightedMatrix(gFrom.get(i), gTo.get(i), gWeight.get(i));
            weightedMatrices.add(weightedMatrix);
        }
        return weightedMatrices;
    }

}

class WeightedMatrix {
    Integer from;
    Integer to;
    Integer weight;

    public WeightedMatrix() {
    }

    /* @Override
       public int compareTo(WeightedMatrix o) {
            int reuslt = this.weight.compareTo(o.weight);
            if (reuslt  != 0) return reuslt;
            else {
                Integer  sum = this.from + this.to;
                int finalResult = sum.compareTo(o.from + o.to);
                if (finalResult != 0) return finalResult;
                else return 1;
            }
        }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeightedMatrix)) return false;
        WeightedMatrix that = (WeightedMatrix) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to, weight);
    }

    public WeightedMatrix(Integer from, Integer to, Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightedMatrix{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}



