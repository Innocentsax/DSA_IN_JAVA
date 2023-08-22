import java.util.*;

class Challenge {

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> validIps = new ArrayList<>();
        backtrack(string, 0, new ArrayList<>(), validIps);
        return validIps;
    }

    private void backtrack(String s, int start, ArrayList<String> path, ArrayList<String> validIps) {
        if (path.size() == 4 && start == s.length()) {
            validIps.add(String.join(".", path));
            return;
        }

        if (path.size() >= 4 || start >= s.length()) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {
                String segment = s.substring(start, start + i);
                if (isValidSegment(segment)) {
                    path.add(segment);
                    backtrack(s, start + i, path, validIps);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean isValidSegment(String segment) {
        int num = Integer.parseInt(segment);
        return String.valueOf(num).equals(segment) && num >= 0 && num <= 255;
    }

}
