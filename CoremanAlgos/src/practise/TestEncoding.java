package practise;

/**
 * Created by raj8lm on 01/08/18.
 */
public class TestEncoding implements PasswordEncoder{

    public PasswordEncoder makeBadEncoder(){
        return (password, salt) -> password.toUpperCase();
    }

    public  void doSomething(PasswordEncoder encoder){
        String salted = encoder.encode("abc", "123");
        System.out.println(salted);
    }

    public static void main(String[] args) {
        TestEncoding test = new TestEncoding();
        PasswordEncoder encoder = test.makeBadEncoder();
        test.doSomething(encoder);
    }

    @Override
    public String encode(String password, String salt) {
        return null;
    }
}
