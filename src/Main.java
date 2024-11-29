import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.println("Введите начало отсчета:");
        String start = in.nextLine();
        System.out.println("Введите конец отсчета:");
        String end = in2.nextLine();

        String[] startTime = start.split(" ");
        String[] endTime = end.split(" ");

        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        if (endHour < startHour || (endHour == startHour && endMinute < startMinute)) {
            endHour += 24;
        }

        int count = 0;
        int currentHour = startHour;

        while (currentHour < endHour){
            currentHour++;
            count += strikesAtHour(currentHour);
            if (currentHour != endHour)count++;
        }

        if (startMinute < 30) count++;
        if (endMinute > 30) count++;

        System.out.println(count);
    }
    public static int strikesAtHour(int hour24) {
        int hour12 = hour24 % 12;
        if (hour12 == 0) {
            hour12 = 12;
        }
        return hour12;
    }
}