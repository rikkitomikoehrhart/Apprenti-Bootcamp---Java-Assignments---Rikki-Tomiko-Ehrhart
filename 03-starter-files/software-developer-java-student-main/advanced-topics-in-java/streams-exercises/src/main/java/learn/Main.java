package learn;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
//        for (Student student : students) {
//            System.out.println(student);
//        }

        // stream solution
        // students.stream().forEach(System.out::println);

        // 1. Print students from Argentina
//        List<Student> argentinianStudents = students.stream().filter(student -> student.getCountry().equals("Argentina")).collect(Collectors.toList());
//        argentinianStudents.forEach(s -> System.out.println(s));


        // 2. Print students whose last names starts with 'T'.
//        List<Student> lastNameStartsT = students.stream().filter(student -> student.getLastName().startsWith("T")).collect(Collectors.toList());
//        lastNameStartsT.forEach(s -> System.out.println(s));

        // 3. Print students from Argentina, ordered by GPA
//        List<Student> argentinianStudents = students.stream().filter(
//                student -> student.getCountry()
//                        .equals("Argentina"))
//                        .sorted(Comparator.comparing(Student::getGpa))
//                        .collect(Collectors.toList());
//        argentinianStudents.forEach(s -> System.out.println(s));

        // 4. Print the bottom 10% (100 students) ranked by GPA.
//        List<Student> lowestGPA = students.stream().sorted(Comparator.comparing(Student::getGpa)).limit(100).collect(Collectors.toList());
//        lowestGPA.forEach(s -> System.out.println(s));


        // 5. Print the 4th - 6th ranked students by GPA from Argentina
//        List<Student> argentinianStudents = students.stream().filter(
//                student -> student.getCountry().equals("Argentina"))
//                .sorted(Comparator.comparing(Student::getGpa))
//                .limit(6)
//                .collect(Collectors.toList());
//        System.out.println(argentinianStudents.get(3));
//        System.out.println(argentinianStudents.get(5));

        // 6. Is anyone from Maldives?
//        List<Student> maldives = students.stream().filter(student -> student.getCountry().equals("Maldives")).collect(Collectors.toList());
//        maldives.forEach(s -> System.out.println(s));

        // 7. Does everyone have a non-null, non-empty email address?
//        List<Student> emails = students.stream().filter(
//                student -> student.getEmailAddress().isEmpty() || student.getEmailAddress().isBlank()).collect(Collectors.toList());
//
//        emails.forEach(s -> System.out.println(s));

        // 8. Print students who are currently registered for 5 courses.
//        List<Student> overAchievers = students.stream().filter(student -> student.getRegistrations().size() > 4).collect(Collectors.toList());
//        overAchievers.forEach(s -> System.out.println(s));

        // 9. Print students who are registered for the course "Literary Genres".
//        List<Student> literaryGenres = students.stream().filter(student -> student.getRegistrations().stream().anyMatch(course -> course.getCourse().equals("Literary Genres"))).collect(Collectors.toList());
//        literaryGenres.forEach(s -> System.out.println(s));

        // 10. Who has the latest birthday? Who is the youngest?
//        Optional<Student> youngestStudent = students.stream().max(Comparator.comparing(Student::getBirthDate));
//        System.out.println(youngestStudent);

        // 11. Who has the highest GPA? There may be a tie.
        

        // 12. Print every course students are registered for, including repeats.

        // 13. Print a distinct list of courses students are registered for.

        // 14. Print a distinct list of courses students are registered for, ordered by name.

        // 15. Count students per country.

        // 16. Count students per country. Order by most to fewest students.

        // 17. Count registrations per course.

        // 18. How many registrations are not graded (GradeType == AUDIT)?

        // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).

        // 20. What is the average GPA per country (remember, it's random fictional data).

        // 21. What is the maximum GPA per country?

        // 22. Print average IQ per Major ordered by IQ ascending.

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
    }
}
