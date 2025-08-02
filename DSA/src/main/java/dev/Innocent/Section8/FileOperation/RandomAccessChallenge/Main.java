package dev.Innocent.Section8.FileOperation.RandomAccessChallenge;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

record Employee(int employeeId, String firstName, String lastName, double salary){

};

public class Main {

    private static final Map<Integer, Long> indexedIds = new HashMap<>();

    static {
        int recordsInFile = 0;
        try(RandomAccessFile ra = new RandomAccessFile("employees.dat", "r");){
            recordsInFile = ra.readInt();
            System.out.println(recordsInFile + " records in file");
            for(int i = 0; i < recordsInFile; i++){
                indexedIds.put(ra.readInt(), ra.readLong());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try(RandomAccessFile ra = new RandomAccessFile("employees.dat", "rw")){
            Scanner scanner = new Scanner(System.in);
            List<Integer> ids =new ArrayList<>(indexedIds.keySet());
            Collections.sort(ids);

            while(true){
                System.out.println(ids);
                System.out.println("Enter an Employee Id or 0 to quit");
                if(!scanner.hasNext()) break;
                int employeeId = Integer.parseInt(scanner.nextLine());
                if(employeeId < 1){
                    break;
                }
                if(!ids.contains(employeeId)){
                    continue;
                }
                Employee e = readRecord(ra, employeeId);
                System.out.println("Enter new salary, nothing if no change:");
                try{
                    double salary = Double.parseDouble(scanner.nextLine());
                    ra.seek(indexedIds.get(employeeId) + 4);
                    ra.writeDouble(salary);
                    readRecord(ra, employeeId);
                } catch (NumberFormatException ignore) {
                    // If the entered input is not a valid number, I'll ignore it.
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Employee readRecord(RandomAccessFile ra, int employeeId) throws IOException {
        ra.seek(indexedIds.get(employeeId));
        int id = ra.readInt();
        double salary = ra.readDouble();
        String first = ra.readUTF();
        String last = ra.readUTF();

        Employee e = new Employee(id, first, last, salary);
        System.out.println(e);
        return e;
    }
}
