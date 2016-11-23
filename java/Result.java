/**
 * Created by TAWEESOFT on 11/23/2016 AD.
 */
public class Result {
    private String name;
    private double percentage;

    public Result(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercantage() {
        return percentage;
    }

    public void setPercantage(double percantage) {
        this.percentage = percantage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        return name != null ? name.equals(result.name) : result.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

