package practise;

/**
 * Created by raj8lm on 01/08/18.
 */
@FunctionalInterface
public interface PasswordEncoder {
    public String encode(String password, String salt);
}
