import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 04.03.13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        List testMessage = new LinkedList();

        testMessage.add(0, "qqq");
        testMessage.add(0, "wwww");
        testMessage.add(0, "eeeee");

        for (Object s: testMessage){
            String currentString = (String) s;
            System.out.println(currentString);
        }
    }
}
