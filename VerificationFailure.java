package library;

/**
 * Error thrown when user fails verification
 */
public class VerificationFailure extends Exception {

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("library.Verification Failure");
    }
}
