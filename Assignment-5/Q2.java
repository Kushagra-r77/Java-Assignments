import java.util.Optional;
public class Q2 {
    public static void main(String[] args) {
        Optional<String> emailOpt = Optional.of("student@thapar.edu");
        Optional<String> emptyEmailOpt = Optional.empty();

        emailOpt.ifPresent(email -> System.out.println("Found -> " + email));

        String fallbackEmail = emptyEmailOpt.orElse("default.user@thapar.edu");
        System.out.println("Email using orElse(): " + fallbackEmail);

        try {
            String missingEmail = emptyEmailOpt.orElseThrow(() -> new IllegalArgumentException("Email address is missing!"));
            System.out.println(missingEmail);
        } catch (Exception e) {
            System.out.println("Handled Exception: " + e.getMessage());
        }
    }
}
