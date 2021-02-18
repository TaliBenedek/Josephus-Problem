/**
 * @author MCON264
 * modified by TBenedek
 * This class creates a circular linked list of the specified type
 * @param <T>
 */
public class GCLL<T>
{

    private Node first = null;
//<editor-fold defaultstate="collapsed" desc="Node">

    private class Node<T>
    {

        private T info;
        private Node<T> next;

        private Node(T info)
        {
            this.info = info;
            next = null;
        }
    }
//</editor-fold>

    /**
     * This method adds an element to the circular linked list. If the list is
     * empty, the added element becomes the first node. Otherwise, the element
     * is inserted between the first and second nodes.
     *
     * @param element the element to be added to the list
     */
    public void add(T element)
    {
        Node node = new Node(element);
        if (first == null)
        {
            first = node;
            first.next = first;
        } else
        {
            node.next = first.next;
            first.next = node;
        }
    }

    /**
     * This method searches the list to determine if the specified element is in
     * the list
     * @param element the element to be searched for
     * @return true if the element is in the list and false if it is not
     */
    public boolean find(T element)
    {
        boolean retVal = false;
        Node curr = first;
        if (curr != null)
        {
            do
            {
                curr = curr.next;
                if (curr.info.equals(element))
                {
                    retVal = true;
                    break;
                }
            } while (curr != first);
        }
        return retVal;
    }

    /**
     * This method returns the first element in the list
     * @return The first element in the list
     */
    public T getFirst()
    {
        T element = null;
        if (first != null)
        {
            element = (T) first.info;
        }
        return element;
    }

    /**
     * This method returns the last element of the list ie: the element pointing to first
     * @return The last element of the list
     */
    private Node getLast()
    {
        Node last = null;
        if (first == first.next)
        {
            last = first;
        } else
        {
            Node curr = first.next;
            while (curr != first)
            {
                last = curr;
                curr = curr.next;
            }
        }
        return last;
    }

    /**
     * If the specified element is in the list, this method removes it. When
     * there is more than one instance of the same element, the first one is
     * removed.
     *
     * @param element The element to be removed from the list.
     * @return True, if the specified element was removed and false if the
     * element was not removed.
     */
    public boolean remove(T element)
    {
        boolean retVal = false;
        if (find(element))
        {
            if (first.equals(first.next))
            {
                first = null;
            } else if (first.info.equals(element))
            {
                Node last = getLast();
                first = first.next;
                last.next = first;
            } else
            {
                Node curr = first;
                do
                {
                    curr = curr.next;
                    if (curr.next.info.equals(element))
                    {
                        curr.next = curr.next.next;
                        break;
                    }
                } while (true);
            }
            retVal = true;
        }

        return retVal;
    }

    /**
     * This method advances the specified number of spaces from first, and the
     * node that is landed on becomes first.
     *
     * @param count The number the list should be advanced by
     */
    public void advance(int count) throws NullPointerException
    {
        if(first == null)
        {
            throw new NullPointerException();
        }
        if (count > 0)
        {
            for (int move = 0; move < count; ++move)
            {
                first = first.next;
            }
        }
    }

    @Override
    public String toString()
    {
        String rV = "first->";
        if (first != null)
        {
            Node<T> curr = first;
            while (curr.next != first)
            {
                rV += ("|" + curr.info.toString() + "|->");
                curr = curr.next;
            }
            rV += ("|" + curr.info.toString() + "|->");
            curr = curr.next;
            rV += ("|" + curr.info.toString() + "|");
        }
        return rV;
    }
}

