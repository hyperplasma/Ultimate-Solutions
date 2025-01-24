package MC0058;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final char[] BASE32_CHARS = "9876543210mnbvcxzasdfghjklpoiuyt".toCharArray();
    private static final Map<Character, Integer> BASE32_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BASE32_CHARS.length; i++) {
            BASE32_MAP.put(BASE32_CHARS[i], i);
        }
    }

    // Base32 编码
    private static String encodeBase32(String rawStr) {
        StringBuilder binaryBuilder = new StringBuilder();
        for (char c : rawStr.toCharArray()) {
            binaryBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        while (binaryBuilder.length() % 5 != 0) {
            binaryBuilder.append('0');
        }
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < binaryBuilder.length(); i += 5) {
            String group = binaryBuilder.substring(i, i + 5);
            int index = Integer.parseInt(group, 2);
            encoded.append(BASE32_CHARS[index]);
        }

        int paddingCount = (8 - (encoded.length() % 8)) % 8;
        encoded.append("+".repeat(paddingCount));

        return encoded.toString();
    }

    // Base32 解码
    private static String decodeBase32(String encodedStr) {
        String[] split = encodedStr.split("\\+");
        StringBuilder decoded = new StringBuilder();
        for (String s : split) {
            if (s.isEmpty())
                continue;
            StringBuilder binaryBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                int index = BASE32_MAP.get(c);
                binaryBuilder.append(String.format("%5s", Integer.toBinaryString(index)).replace(' ', '0'));
            }
            for (int i = 0; i < binaryBuilder.length(); i += 8) {
                if (i + 8 > binaryBuilder.length())
                    break;
                String byteStr = binaryBuilder.substring(i, i + 8);
                int ascii = Integer.parseInt(byteStr, 2);
                decoded.append((char) ascii);
            }
        }
        return decoded.toString();
    }

    public static String solution(String rawStr, String encodedStr) {
        String encoded = encodeBase32(rawStr);
        String decoded = decodeBase32(encodedStr);
        return encoded + ":" + decoded;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution("foo", "b0zj5+++").equals("bljhy+++:bar"));
        System.out.println(solution(
                "The encoding process represents 40-bit groups of input bits as output strings of 8 encoded characters.  Proceeding from left to right, a 40-bit input group is formed by concatenating 5 8bit input groups. These 40 bits are then treated as 8 concatenated 5-bit groups, each of which is translated into a single character in the base 32 alphabet.  When a bit stream is encoded via the base 32 encoding, the bit stream must be presumed to be ordered with the most-significant- bit first. That is, the first bit in the stream will be the high- order bit in the first 8bit byte, the eighth bit will be the low- order bit in the first 8bit byte, and so on.",
                "bljhy+++b0zj5+++")
                .equals("maf3m164vlahyl60vlds9i6svuahmiod58l3mi6sbglhmodfcbz61b8vb0fj1162c0jjmi6d58jhb160vlk2mu89b0fj1il9b4ls9oogcak2mu89cvp25pncbuls9oo359i79lncbvjh1ln558ahzknsb4aj1lnscbj7917zc0jh3ln4bafhill9bll3yo09vashbu89cajs9id0buf21n89b5z61b8vb0fj1160vlk2mu89bul3yunz58fj3163vul3pln558a2s166vuj33knfbgj37u60vlds9v0928a3su89v4j29unf58dj5oogc8lsi17fv8sj3l093zk79kd0cals9knsbfz21p64vkz21id4b4p3ml89b4ls9c89bvjhiko8cashiknfbgs79v0vb0fj1162c0jjmi6d4zz3mkn6v9z3yla9cuf3sko158fj316fc0zhiiobb4p3ml89v4j21ol9b5z23pncbuh3m166v8zj5kn6casj5160vkz21p6458a37io459ld5168vak3zkn7bgp7i189muf3moa9b5z35pnf58lj1id4b4hs9pnd58shikoxbash116hv4zs9u61bfz35kndbfz63ba9bgj33oo5v4j3cn89caf3m167v4p79iofc0sh7o09vgpj3u89b0ss9i6sbgljmon4bzz21ol9b0ss9oosbasj5ln558ohsu6158p3zl09vgjj3u8vcvfhcod0blfh3kncczhs9kd0czz3bpnscvp7i17fv8zj1160cbh79u61bfz3bpnscvp79kd0czz3soa9caf3m16dcal3mknv58ohso6b58a3m16fv8ss9p60buf7p16xc0s3mia9b0fj1160vkz21p6458d3siddczz6zkd0czz35ynfbfh79u61bfz3mpn2v8p3z167v4p79uo0vah79kd458p3zl09vajjcn09vul31lns58a3su89v4j79u61bfz3bpnscvp79c67v4p79kdlcassk168vls79iox58jhinz+:foobar"));
    }
}
