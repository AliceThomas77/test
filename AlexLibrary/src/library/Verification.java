package library;

/**
 * Created by Administrator on 20/12/2016.
 */
public interface Verification{

    boolean verify(String attempt, String password);
    boolean verify(String attempt, String password, int numTries);
}
