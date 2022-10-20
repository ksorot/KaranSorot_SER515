import java.util.Iterator;

public class OfferingIterator extends OfferingList implements ListIterator{
    @Override
    public boolean hasNext(Iterator itr) {
        return false;
    }

    @Override
    public Offering Next(Iterator itr) {
        return null;
    }


}
