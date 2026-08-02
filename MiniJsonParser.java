import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MiniJsonParser {

    private final String json;
    private int pos;

    private MiniJsonParser(String json) {
        this.json = json;
        this.pos = 0;
    }

    public static Object parse(String json) {
        MiniJsonParser parser = new MiniJsonParser(json);
        parser.skipWhitespace();
        return parser.parseValue();
    }

    private Object parseValue() {
        skipWhitespace();
        char c = json.charAt(pos);

        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (c == 't' || c == 'f') return parseBoolean();
        if (c == 'n') { pos += 4; return null; }
        return parseNumber();
    }

    private Map<String, Object> parseObject() {
        Map<String, Object> map = new LinkedHashMap<>();
        pos++;
        skipWhitespace();

        if (json.charAt(pos) == '}') { pos++; return map; }

        while (true) {
            skipWhitespace();
            String key = parseString();
            skipWhitespace();
            pos++; // consume ':'
            Object value = parseValue();
            map.put(key, value);
            skipWhitespace();

            if (json.charAt(pos) == ',') { pos++; continue; }
            if (json.charAt(pos) == '}') { pos++; break; }
        }
        return map;
    }

    private List<Object> parseArray() {
        List<Object> list = new ArrayList<>();
        pos++;
        skipWhitespace();

        if (json.charAt(pos) == ']') { pos++; return list; }

        while (true) {
            list.add(parseValue());
            skipWhitespace();

            if (json.charAt(pos) == ',') { pos++; continue; }
            if (json.charAt(pos) == ']') { pos++; break; }
        }
        return list;
    }

    private String parseString() {
        StringBuilder sb = new StringBuilder();
        pos++;

        while (json.charAt(pos) != '"') {
            char c = json.charAt(pos);
            if (c == '\\') {
                pos++;
                char escaped = json.charAt(pos);
                switch (escaped) {
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    case 'r': sb.append('\r'); break;
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'u':
                        String hex = json.substring(pos + 1, pos + 5);
                        sb.append((char) Integer.parseInt(hex, 16));
                        pos += 4;
                        break;
                    default: sb.append(escaped);
                }
            } else {
                sb.append(c);
            }
            pos++;
        }
        pos++;
        return sb.toString();
    }

    private Boolean parseBoolean() {
        if (json.startsWith("true", pos)) { pos += 4; return Boolean.TRUE; }
        pos += 5;
        return Boolean.FALSE;
    }

    private Double parseNumber() {
        int start = pos;
        while (pos < json.length() &&
                (Character.isDigit(json.charAt(pos)) || "-+.eE".indexOf(json.charAt(pos)) >= 0)) {
            pos++;
        }
        return Double.parseDouble(json.substring(start, pos));
    }

    private void skipWhitespace() {
        while (pos < json.length() && Character.isWhitespace(json.charAt(pos))) pos++;
    }
}