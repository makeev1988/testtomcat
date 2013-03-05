import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 03.03.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class GuestBook {
    private GuestBook(){}

    static private GuestBook guestBookInstance = new GuestBook();
    static private LinkedList<String> listRecords = new LinkedList<>();

    static GuestBook getGuestBook(){
        return  guestBookInstance;
    }

    public synchronized void addRecord(String s){
    listRecords.add(0, s);
    }

    public List getRecords(){
        return listRecords;
    }
}
