package tdu_iwai;

//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class PrintYourAge {
	public static void main(String[] args) {
		try (var in = new Scanner(System.in)) {
            Optional<Integer> pendingAge = Optional.empty();
            // var calender = Calendar.getInstance(TimeZone.getTimeZone("Asya/Tokyo"), Locale.JAPAN);

            // https://qiita.com/yamadamn/items/56e7370bae2ceaec55d5#date-and-time-api%E3%82%92%E4%BD%BF%E3%81%A3%E3%81%9F%E4%BE%8B
            var eraFormat = DateTimeFormatter.ofPattern("GGGGy", Locale.JAPAN);

            while (true) {
                System.out.println("Enter your age (q or e to exit)");
                System.out.print("> ");
                if (!in.hasNextInt()) {
                    if (!in.hasNext()) {
                        System.err.println("No next token is met");
                        break;
                    }

                    var next = in.next();
                    if (next.equals("e") || next.equals("q")) {

                        System.err.println("Exit");
                        continue;
                    } else {
                        System.err.println("Non integer token is met");
                        continue;
                    }

                    // unreachable
                }

                int age = in.nextInt();
                if ((age < 0 || 120 <= age)) {
                    if (pendingAge.isEmpty() || pendingAge.get() != age) {
                        System.out.println("Are you sure? Enter again.");
                        pendingAge = Optional.of(age);
                        continue;
                    }

                    System.out.println("Very strange age, but continue");
                }

                System.out.println("You are " + age + " years old.");
                System.out.println("You will be " + (age + 10) + " years old after 10 years.");

                int year = ZonedDateTime.now().getYear();
                System.out.println("You will be " + (age + 2030 - year) + " years old when 2030");

                var birth = JapaneseDate.of(year - age, 1, 1);
                System.out.println("Your birth is " + eraFormat.format(birth));
            }
		}
	}
}
