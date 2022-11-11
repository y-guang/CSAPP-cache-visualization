import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class DirectMappedCache {
    private final int cacheSize;
    private final int lineSize;
    private final int coLen;
    private final int linesCount;
    private final HashMap<Integer, CacheLine> cacheLines = new HashMap<>();
    private long readMiss = 0;
    private long readHit = 0;
    private long writeMiss = 0;
    private long writeHit = 0;

    public DirectMappedCache(int cacheSize, int lineSize) {
        this.cacheSize = cacheSize;
        this.lineSize = lineSize;
        this.coLen = Helper.log_2(lineSize);
        if (coLen < 0) throw new RuntimeException("coLen is not 2^n");
        linesCount = cacheSize / lineSize;

        // init cache lines
        long start = 0;
        for (int i = 0; i < linesCount; i++) {
            CacheLine line = new CacheLine(lineSize, i);
            cacheLines.put(i, line);
        }
    }

    public void write(long addr) {
        int index = addr_to_index(addr);
        CacheLine line = cacheLines.get(index);
        if (line.isHit(addr)) {
            writeHit++;
        } else {
            writeMiss++;
            line.load(addr_to_start(addr));
        }
    }

    public void read(long addr) {
        int index = addr_to_index(addr);
        CacheLine line = cacheLines.get(index);
        if (line.isHit(addr)) {
            readHit++;
        } else {
            readMiss++;
            line.load(addr_to_start(addr));
        }
    }

    /**
     * @return the index of the corresponding cache line of the addr.
     */
    private int addr_to_index(long addr) {
        return (int)((addr >> coLen) % linesCount);
    }

    /**
     * find the start addr of a cache line that contains the addr.
     * @return start of cache line that contains the addr.
     */
    private long addr_to_start(long addr) {
        return addr >> coLen << coLen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DirectMappedCache{")
                .append( "cacheSize=").append(cacheSize)
                .append(", lineSize=").append(lineSize)
                .append(", coLen=").append(coLen)
                .append(", linesCount=").append(linesCount)
                .append(", readMiss=").append(readMiss)
                .append(", readHit=").append(readHit)
                .append(", writeMiss=").append(writeMiss)
                .append(", writeHit=").append(writeHit)
                .append('}').append("\n");
        ArrayList<CacheLine> lines = new ArrayList<>(cacheLines.values());
        lines.sort(Comparator.comparingInt(CacheLine::getCacheIndex));
        for (CacheLine line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public long getReadMiss() {
        return readMiss;
    }

    public long getReadHit() {
        return readHit;
    }

    public long getWriteMiss() {
        return writeMiss;
    }

    public long getWriteHit() {
        return writeHit;
    }

    public double calTotalMissRatio() {
        return ((double)(writeMiss + readMiss)) / (writeMiss + writeHit + readMiss + readHit);
    }

    public double calTotalHitRatio() {
        return ((double) (readHit + writeHit)) / (writeMiss + writeHit + readMiss + readHit);
    }

    public void outputSummary() {
        System.out.println("Hit ratio: \t" + calTotalHitRatio());
        System.out.println("Miss ratio:\t" + calTotalMissRatio());
        System.out.println("Hit: \t" + (readHit + writeHit));
        System.out.println("  Read Hit: \t" + readHit);
        System.out.println("  Write Hit: \t" + writeHit);
        System.out.println("Miss: \t" + (readMiss + writeMiss));
        System.out.println("  Read Miss: \t" + readMiss);
        System.out.println("  Write Miss: \t" + writeMiss);
    }
}