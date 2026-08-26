
class Solution 
{
    public String encode(List<String> strs) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        for (String str : strs) {
            byte[] payload = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            byte[] header = (payload.length + "#").getBytes(java.nio.charset.StandardCharsets.US_ASCII);
            out.writeBytes(header);
            out.writeBytes(payload);
        }
        // Побайтовая упаковка итогового массива в String без потерь.
        return new String(out.toByteArray(), java.nio.charset.StandardCharsets.ISO_8859_1);
    }

    public List<String> decode(String s) {
        byte[] data = s.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1);
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int j = i;
            while (data[j] != '#') {
                j++;
            }
            int len = Integer.parseInt(
                    new String(data, i, j - i, java.nio.charset.StandardCharsets.US_ASCII));
            int start = j + 1;
            String str = new String(data, start, len, java.nio.charset.StandardCharsets.UTF_8);
            result.add(str);
            i = start + len;
        }
        return result;
    }
}
