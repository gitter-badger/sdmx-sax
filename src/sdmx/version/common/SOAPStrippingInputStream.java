package sdmx.version.common;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOAPStrippingInputStream extends FilterInputStream {

    LinkedList<Integer> inQueue = new LinkedList<Integer>();
    LinkedList<Integer> outQueue = new LinkedList<Integer>();
    final byte[] stripStart, stripEnd;
    boolean started = false;
    boolean finished = false;

    public SOAPStrippingInputStream(InputStream in, String stripStart,
            String stripEnd) {
        super(in);
        this.stripStart = stripStart.getBytes();
        this.stripEnd = stripEnd.getBytes();
        try {
            readToStart();
        } catch (IOException ex) {
            Logger.getLogger(SOAPStrippingInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isMatchFound() {
        if (!started) {
            Iterator<Integer> inIter = inQueue.iterator();
            for (int i = 0; i < stripStart.length; i++) {
                if (!inIter.hasNext() || stripStart[i] != inIter.next()) {
                    return false;
                }
            }
            return true;
        } else {
            Iterator<Integer> inIter = inQueue.iterator();
            for (int i = 0; i < stripEnd.length; i++) {
                if (!inIter.hasNext() || stripEnd[i] != inIter.next()) {
                    return false;
                }
            }
            return true;
        }
    }

    private void readAhead() throws IOException {
        // Work up some look-ahead.
        while (inQueue.size() < stripEnd.length) {
            int next = super.read();
            //System.out.print((char)next);
            inQueue.offer(next);
            if (next == -1) {
                throw new IOException("Stream Closed");
            }
        }
    }

    public void readToStart() throws IOException {
        char c = (char) read();
        while (!started) {
            c = (char) read();
        }
        while (c == ' ' || c == '\r' || c == '\n') {
            c = (char) read();
        }
        if (c != ' ' && c != '\r' && c != '\n') {
            outQueue.addFirst((int) c);
        }
    }

    @Override
    public int read() throws IOException {

        // Next byte already determined.
        if (outQueue.isEmpty()) {

            readAhead();

            if (isMatchFound()) {
                if (started) {
                    finished = true;
                }
                if (!started) {
                    started = true;
                }
                if (!finished) {
                    for (int i = 0; i < stripStart.length; i++) {
                        inQueue.remove();
                    }
                    readAhead();
                    Iterator it = inQueue.iterator();
                    while (it.hasNext()) {
                        outQueue.add((Integer) it.next());
                        it.remove();
                    }
                } else {
                    Iterator it = inQueue.iterator();
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    return -1;
                }
            } else {
                outQueue.add(inQueue.remove());
            }
        }
        if (finished) {
            return -1;
        }
        int k = outQueue.remove();
        return k;
    }

    public int read(byte[] b) throws IOException {
        int i = 0;
        while (i < b.length) {
            int r = read();
            if (r == -1) {
                if (i == 0) {
                    return -1;
                }
                return i;
            }
            b[i] = (byte) r;
            i++;
        }
        return i;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int i = off;
        int read = 0;
        while (read < len) {
            int r = read();
            if (r == -1) {
                if (read == 0) {
                    return -1;
                }
                return read;
            }
            b[i++] = (byte) r;
            read++;
        }
        return read;
    }
    // TODO: Override the other read methods.
}
