public class Main {
    public static void main(String[] args) {
        DirectMappedCache cache = new DirectMappedCache(16, 8);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (cache.read(i * 2 * 4 + j * 4)) {
                    System.out.println("r hit, " + i + j);
                }
                if(cache.write(j * 2 * 4 + i * 4 + 16)) {
                    System.out.println("w hit " + i + j);
                }

            }
        }
        cache.outputSummary();
    }

    // Practice Problem 6.18
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(2048, 32);
//        int i, j;
//        for (i = 31; i >= 0; i--) {
//            for (j = 31; j >= 0; j--) {
//                cache.read(i * 32 * 8 + j * 8);
//                cache.read(i * 32 * 8 + j * 8 + 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam3 Q3
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(16, 8);
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                cache.read(16 + j * 4 * 2 + i * 4);
//                cache.write(j * 4 * 2 + i * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam1 Q3 C 2
//    public static void main(String[] args) {
//        int ROWS = 192;
//        int COLS = 128;
//        long src = 0L;
//        long dest = src + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int j = 0; j < COLS; j++) {
//            for (int i = 0; i < ROWS; i++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + (COLS - 1 - j) * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam Q3 C 1
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 128;
//        long src = 0L;
//        long dest = src + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int j = 0; j < COLS; j++) {
//            for (int i = 0; i < ROWS; i++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + (COLS - 1 - j) * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam1 Q3 B 2
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 192;
//        long src = 0L;
//        long dest = src + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + (COLS - 1 - j) * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam Q3 B 1
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 128;
//        long src = 0L;
//        long dest = src + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + (COLS - 1 - j) * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam1 Q3 3
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 256;
//        long dest = 0L;
//        long src = dest + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + j * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam1 Q3 2
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 192;
//        long dest = 0L;
//        long src = dest + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + j * 4);
//            }
//        }
//        cache.outputSummary();
//    }

//    // exam Q3 1
//    public static void main(String[] args) {
//        int ROWS = 128;
//        int COLS = 128;
//        long dest = 0L;
//        long src = dest + ROWS * COLS * 4;
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 16);
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                cache.read(src + i * COLS * 4 + j * 4);
//                cache.write(dest + i * COLS * 4 + j * 4);
//            }
//        }
//        cache.outputSummary();
//    }

    // exam2 Q3 C
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(2048, 32);
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < 16; j++) {
//                cache.write(i * 16 * 4 * 4 + j * 4 * 4 + 2);
//            }
//        }
//        System.out.println(cache);
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < 16; j++) {
//                cache.write(i * 16 * 4 * 4 + j * 4 * 4);
//                cache.write(i * 16 * 4 * 4 + j * 4 * 4 + 1);
//                cache.write(i * 16 * 4 * 4 + j * 4 * 4 + 3);
//            }
//        }
//        System.out.println(cache);
//        cache.outputSummary();
//    }

    // exam2 Q3 B
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(2048, 32);
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < 8; j++) {
//                for (int c = 0; c < 4; c++) {
//                    cache.write(j * 16 * 4 * 4 + i * 4 * 4 + c * 4);
//                }
//            }
//        }
//        System.out.println(cache.toString());
//        cache.outputSummary();
//    }

    // exam2 Q3 A
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(2048, 32);
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < 16; j++) {
//                for (int c = 0; c < 4; c++) {
//                    cache.write(i * 16 * 16 + j * 16 + c * 4);
//                }
//            }
//        }
//        cache.outputSummary();
//    }

    // exam3 Q2 A
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 4);
//        for (int j = 0; j < 640; j++) {
//            for (int i = 0; i < 480; i++) {
//                for (int c = 0; c < 4; c++) {
//                    cache.write((640L * i * 4) + j * 4 + c);
//                }
//            }
//        }
//        System.out.println(cache.toString());
//        System.out.println(cache.calTotalMissRatio());
//    }

    // exam3 Q2 B
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 4);
//        for (int i = 0; i < 648 * 480 * 4; i++) {
//            cache.write(i);
//        }
//        System.out.println(cache.toString());
//        System.out.println(cache.calTotalMissRatio());
//    }

    // exam3 Q2 C
//    public static void main(String[] args) {
//        DirectMappedCache cache = new DirectMappedCache(64 * 1024, 4);
//        for (int i = 0; i < 640 * 480; i++) {
//            cache.write(i * 4);
//        }
//        cache.outputSummary();
//    }
}
