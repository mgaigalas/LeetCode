import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Codec contains business logic for encoding and decoding any valid ASCII string.
 * NOTE: Skeleton of this class has been provided by LeetCode.
 *
 * @author Marius Gaigalas on 25/09/2024
 */
class Codec {
    private static final String UNICODE_DELIMITER = Character.toString(0x00A7);

    /**
     * Encodes a list of strings to a single string.
     *
     * @param strs list of non-encoded strings
     * @return encoded string
     */
    public String encode(List<String> strs) {
        final var sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append(UNICODE_DELIMITER);
        }
        return sb.toString();
    }

    /**
     * Decodes a single string to a list of strings.
     *
     * @param s encoded string
     * @return list of non-encoded strings
     */
    public List<String> decode(String s) {
        final var strs = s.split(UNICODE_DELIMITER, -1);
        return new ArrayList<>(Arrays.asList(strs)
                .subList(0, strs.length - 1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));