package apache.ranger.client.utils;

public class Base64 {
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    private Base64() {
    }

    public static char[] encode(byte[] data) {
        char[] out = new char[(data.length + 2) / 3 * 4];
        int ii = 0;

        for(int index = 0; ii < data.length; index += 4) {
            boolean isQuadrupel = false;
            boolean isTripel = false;
            int val = 255 & data[ii];
            val <<= 8;
            if (ii + 1 < data.length) {
                val |= 255 & data[ii + 1];
                isTripel = true;
            }

            val <<= 8;
            if (ii + 2 < data.length) {
                val |= 255 & data[ii + 2];
                isQuadrupel = true;
            }

            out[index + 3] = ALPHABET[isQuadrupel ? val & 63 : 64];
            val >>= 6;
            out[index + 2] = ALPHABET[isTripel ? val & 63 : 64];
            val >>= 6;
            out[index + 1] = ALPHABET[val & 63];
            val >>= 6;
            out[index] = ALPHABET[val & 63];
            ii += 3;
        }

        return out;
    }

}
