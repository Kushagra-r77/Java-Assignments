import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private T marksObtained;
    private T totalMarks;

    public Result(T marksObtained, T totalMarks) {
        this.marksObtained = Objects.requireNonNull(marksObtained, "Marks obtained cannot be null");
        this.totalMarks = Objects.requireNonNull(totalMarks, "Total marks cannot be null");
    }

    public double calculatePercentage() {
        return (marksObtained.doubleValue() / totalMarks.doubleValue()) * 100.0;
    }

    public boolean hasPassed(double thresholdPercentage) {
        return calculatePercentage() >= thresholdPercentage;
    }

    public Optional<Double> getPercentageOptional() {
        return Optional.ofNullable(calculatePercentage());
    }
}

public class Q3 {
    public static void main(String[] args) {
        Result<Integer> studentResult = new Result<>(420, 500);
        double passingThreshold = 40.0;

        studentResult.getPercentageOptional().ifPresent(percentage -> {
            System.out.println("Calculated Percentage: " + percentage + "%");
            System.out.println("Pass Status: " + (studentResult.hasPassed(passingThreshold) ? "Passed" : "Failed"));
        });
    }
}