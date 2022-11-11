public class Helper {
    static int log_2(int x) {
        int retVal = 0;
        for (retVal = 0; x > 0; x = x >> 1) {
            if ((x & 1) == 1) {
                // find leading 1
                if (x == 1) {
                    return retVal;
                }
                // not 2^n
                return -1;
            }
            retVal++;
        }
        // cannot find leading 1
        return -1;
    }
}
