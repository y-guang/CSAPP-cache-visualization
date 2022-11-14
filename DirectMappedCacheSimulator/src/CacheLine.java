public class CacheLine {

    private final int lineSize;
    private final int cacheIndex;
    private boolean valid;
    private long start;
    private long end;

    public CacheLine(int lineSize, int cacheIndex) {
        valid = false;
        this.lineSize = lineSize;
        this.cacheIndex = cacheIndex;
    }

    public void load(long start) {
        this.start = start;
        this.end = start + lineSize;
        valid = true;
    }

    public boolean isHit(long addr) {
        return valid && addr >= start && addr < end;
    }

    @Override
    public String toString() {
        return String.format("cache %04X, ", cacheIndex) +
                "valid: " + (valid ? 1 : 0) + ", " +
                String.format("%016X, ", start) +
                String.format("%016X.", end);
    }

    public int getCacheIndex() {
        return cacheIndex;
    }
}
