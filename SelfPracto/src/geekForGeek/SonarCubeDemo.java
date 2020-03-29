package geekForGeek;

public class SonarCubeDemo {

    public static void main(String[] args) {
        SonarCubeDemo sd = init();
        sd.foo("DEMO");
    }

    private void foo(String demo) {
        System.out.println(demo.toUpperCase());
    }

    private static SonarCubeDemo init() {
        return null;
    }

    public void checkOptionMethod(User user){
        /*if(!isPresent(user.getName())){
            System.out.println("NAME is not PRESENT");
        }*/
    }

}
