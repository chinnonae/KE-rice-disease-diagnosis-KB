import java.util.Comparator;

/**
 * Created by TAWEESOFT on 11/23/2016 AD.
 */
public class Compare implements Comparator<Result> {

    @Override
    public int compare(Result o1, Result o2) {
        return (int) (o2.getPercantage() - o2.getPercantage());
    }
}
