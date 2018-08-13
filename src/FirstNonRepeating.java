/* First NonRepeating*/

import java.util.HashMap;
import java.util.function.BiConsumer;

public class FirstNonRepeating {

    /**
     * char findFirst(String input)
     * Finds the first character that does not repeat anywhere in the input string
     * If all characters are repeated, return 0
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     * Given "ababdc", the answer is "d"
     **/
    public static char findFirst(String input) {
        // TODO: Implement solution
        HashMap<String, DTO> map = new HashMap<>();

        int i = 0;
        for (String s : input.split("")) {
            if (map.containsKey(s)) {
                DTO dto = map.get(s);
                dto.isRepeated = true;
                dto.pos = i;
                map.put(s, dto);
            } else {
                DTO dto = new DTO(i, false);
                map.put(s, dto);
            }
            i++;
        }
        DTO temp = new DTO(Integer.MAX_VALUE, true);
        final DTO[] min = { temp };

        map.forEach(new BiConsumer<String, DTO>() {
            @Override public void accept(String s, DTO dto) {
                if (!dto.isRepeated) {
                    //System.out.println("1");
                    if (min[0].pos > dto.pos) {
                        //System.out.println("1");
                        min[0] = dto;
                    }

                }
            }
        });
        if (!min[0].isRepeated) {
            return input.charAt(min[0].pos);
        } else {
            return 'n';
        }
    }

    static class DTO {
        int pos;
        boolean isRepeated;

        public DTO(int pos, boolean isRepeated) {
            this.pos = pos;
            this.isRepeated = isRepeated;
        }
    }

    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        String[] inputs = { "apple", "racecars", "ababdc" };
        char[] outputs = { 'a', 'e', 'd' };

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result) System.out.println("Test failed for: " + inputs[i]);
            else System.out.println("Test passed for: " + inputs[i]);
        }
        return (result);
    }

    public static void main(String args[]) {
        doTestsPass();
    }
}
