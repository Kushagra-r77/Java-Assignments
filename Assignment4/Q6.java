package Assignment4;
import java.util.Scanner;

class InvalidUsernameException extends Exception {

    InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {

    InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {

    AccountLockedException(String message) {
        super(message);
    }
}

public class Q6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "1234";

        int attempts = 0;
        int maxAttempts = 3;
        boolean locked = false;

        while (attempts < maxAttempts && !locked) {

            try {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                if (locked) {
                    throw new AccountLockedException(
                        "Account is locked"
                    );
                }

                if (!username.equals(correctUsername)) {
                    throw new InvalidUsernameException(
                        "Invalid username"
                    );
                }

                if (!password.equals(correctPassword)) {
                    throw new InvalidPasswordException(
                        "Invalid password"
                    );
                }

                System.out.println("Login successful");
                break;

            }
            catch (InvalidUsernameException e) {

                attempts++;
                System.out.println(e.getMessage());

            }
            catch (InvalidPasswordException e) {

                attempts++;
                System.out.println(e.getMessage());

            }
            catch (AccountLockedException e) {

                System.out.println(e.getMessage());
                break;

            }
            finally {

                if (attempts >= maxAttempts) {
                    locked = true;
                }

            }
        }

        if (locked) {
            System.out.println("Account locked after maximum attempts.");
        }
    }
}
