import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DirectMappedCacheTest {
    DirectMappedCache cache;
    @BeforeEach
    void init() {
        cache = new DirectMappedCache(64, 4);
    }

    @Test
    void empty() {
        assertEquals(0, cache.getReadHit());
        assertEquals(0, cache.getReadMiss());
        assertEquals(0, cache.getWriteHit());
        assertEquals(0, cache.getWriteMiss());
    }

    @Test
    void rwTheSamePosition() {
        cache.read(0L);
        assertEquals(1, cache.getReadMiss());
        cache.read(0L);
        assertEquals(1, cache.getReadHit());
        cache.write(0L);
        assertEquals(1, cache.getWriteHit());
        assertEquals(0, cache.getWriteMiss());
        assertEquals(1, cache.getReadMiss());
    }

    @Test
    void differentPositionWithinTheSameLine() {
        cache.read(0L);
        assertEquals(1, cache.getReadMiss());
        cache.read(1L);
        assertEquals(1, cache.getReadHit());
        cache.read(2L);
        assertEquals(2, cache.getReadHit());
        cache.read(3L);
        assertEquals(3, cache.getReadHit());
        cache.read(4L);
        assertEquals(3, cache.getReadHit());
        assertEquals(2, cache.getReadMiss());
        cache.write(0L);
        assertEquals(1, cache.getWriteHit());
        cache.write(1L);
        assertEquals(2, cache.getWriteHit());
    }

    @Test
    void replacement() {
        cache.write(0L);
        assertEquals(1, cache.getWriteMiss());
        cache.write(64L);
        assertEquals(2, cache.getWriteMiss());
        cache.write(128L);
        assertEquals(3, cache.getWriteMiss());
        cache.write(128L + 1L);
        assertEquals(1, cache.getWriteHit());
    }
}