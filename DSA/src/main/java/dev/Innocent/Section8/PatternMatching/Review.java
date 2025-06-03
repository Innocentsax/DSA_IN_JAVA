package dev.Innocent.Section8.PatternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Review {
    public static void main(String[] args) {

        String phoneList = """
                (800) 123-4567
                (800)123-4567
                (800) 123 4567
                800-123-4567
                800 123-4567
                800 123 4567
                8001234567
                """;

        Pattern phonePattern =
                Pattern.compile("\\(*[0-9]{3}[)\\s-]*\\d{3}[\\s-]*\\p{Digit}{4}");

        Matcher phoneMatcher = phonePattern.matcher(phoneList);
        phoneMatcher.results().forEach(mr -> System.out.println(mr.group()));

        String htmlSnippets = """
                <H1>My Heading</h1>
                <h2>Sub-heading</h2>
                <p>This is a paragraph about something.</p>
                <p style="abc">This is another paragraph about something else.</p>
                <h3 id="third">Summary</h3>
                <br/>
                <p>Testing</p>
                """;

        Pattern htmlPattern =
                Pattern.compile("<([a-z_0-9]+)[^>]*>([^\\v</>]*)(</\\1>)*",
                        Pattern.CASE_INSENSITIVE);

        Matcher m = htmlPattern.matcher(htmlSnippets);
        m.results()
                .filter(mr -> mr.group(1).toLowerCase().startsWith("h"))
                .forEach(mr -> System.out.println("Full Tag: " + mr.group(0)
                        + "\n\tType: " + mr.group(1)
                        + "\n\tText: " + mr.group(2)
                ));

    }
}
