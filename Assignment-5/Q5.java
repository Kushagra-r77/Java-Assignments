import java.util.Objects;
import java.util.Optional;

class GenericUtility {
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Q5 {
    public static void main(String[] args) {
        System.out.println("isEqual('Enterprise', 'Enterprise'): " + GenericUtility.isEqual("Enterprise", "Enterprise"));

        Optional<String> presentOpt = Optional.of("Custom Library");
        Optional<String> emptyOpt = Optional.empty();
        System.out.println("getDefault (Present): " + GenericUtility.getDefault(presentOpt, "Default Library"));
        System.out.println("getDefault (Empty): " + GenericUtility.getDefault(emptyOpt, "Default Library"));

        System.out.println("Max of 45 and 89: " + GenericUtility.max(45, 89));
        System.out.println("Max of 'Java' and 'Python': " + GenericUtility.max("Java", "Python"));

        String testString = null;
        System.out.println("Is testString null?: " + GenericUtility.isNull(testString));
    }
}