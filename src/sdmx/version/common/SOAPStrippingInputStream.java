import java.io.*;
import java.util.*;

class SOAPStrippingInputStream extends FilterInputStream {

    LinkedList<Integer> inQueue = new LinkedList<Integer>();
    LinkedList<Integer> outQueue = new LinkedList<Integer>();
    final byte[] search, replacement;

    protected SOAPStrippingInputStream(InputStream in, byte[] search,
                                                   byte[] replacement) {
        super(in);
        this.search = search;
        this.replacement = replacement;
    }

    private boolean isMatchFound() {
        Iterator<Integer> inIter = inQueue.iterator();
        for (int i = 0; i < search.length; i++)
            if (!inIter.hasNext() || search[i] != inIter.next())
                return false;
        return true;
    }

    private void readAhead() throws IOException {
        // Work up some look-ahead.
        while (inQueue.size() < search.length) {
            int next = super.read();
            inQueue.offer(next);
            if (next == -1)
                break;
        }
    }

    boolean strippedStart = false;

    @Override
    public int read() throws IOException {
        // Next byte already determined.
        if (outQueue.isEmpty()) {
            readAhead();
            if (isMatchFound()) {
                if( !strippedStart ) {
                   for (int i = 0; i < inQueue.size(); i++)
                       inQueue.remove();
                   strippedStart=true;
                }else {
                   for (int i = 0; i < inQueue.size(); i++)
                       inQueue.remove();
                }
            } else
                outQueue.add(inQueue.remove());
        }
        return outQueue.remove();
    }

    // TODO: Override the other read methods.
}
