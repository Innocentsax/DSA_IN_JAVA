package dev.Innocent.Section7.Streams;

import java.util.Arrays;

public record PersonRecord(String name, String dob, PersonRecord[] kids) {
    public PersonRecord(String dob, String name) {
        this(name, dob, new PersonRecord[20]);
    }

    @Override
    public String toString() {
        String kidString = "n/a";
        if(kids != null){
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }

    @Override
    public PersonRecord[] kids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }
}
