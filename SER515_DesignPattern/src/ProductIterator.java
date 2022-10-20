import java.util.Iterator;

public class ProductIterator extends ClassProductList implements ListIterator{


    @Override
    public boolean hasNext(Iterator itr) {
        return itr.hasNext();
    }

    @Override
    public String Next(Iterator itr)
    {
        return (String) itr.next();
    }

}
