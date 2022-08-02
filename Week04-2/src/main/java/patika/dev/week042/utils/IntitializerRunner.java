package patika.dev.week042.utils;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.week042.models.*;
import patika.dev.week042.repository.ICourseRepository;
import patika.dev.week042.repository.IInstructorRepository;
import patika.dev.week042.repository.IStudentRepository;

import java.time.LocalDate;
import java.time.Month;

@Component
@RequiredArgsConstructor
@Transactional
public class IntitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(IntitializerRunner.class);
    private final ICourseRepository iCourseRepository;

    private final IStudentRepository iStudentRepository;

    private final IInstructorRepository iInstructorRepository;



    @Override
    @Transactional
    public void run(String... args) throws Exception {

        iCourseRepository.deleteAll();
        iStudentRepository.deleteAll();
        iInstructorRepository.deleteAll();

        Student student1 = new Student("Emre " , "Konya" , "Erkek" , LocalDate.of(1995 , Month.JULY,28));
        Student student2 = new Student("Nur " , "Tokat" , "Erkek" , LocalDate.of(1994 , Month.MAY,1));
        Student student3 = new Student("Aycan " , "Ankara" , "Erkek" , LocalDate.of(1996 , Month.FEBRUARY,25));
        Student student4 = new Student("Burak " , "Adana" , "Erkek" , LocalDate.of(1994 , Month.AUGUST,6));

        Course course1 = new Course("Mathematics","M101",8);
        Course course2 = new Course("Chemical","C101",5);
        Course course3 = new Course("Physics","P101",5);

        Instructor visitingResearcher = new VisitingResearcher("Hülya", "İzmir" , "0506" , 10500);
        Instructor permanentInstructor1 = new PermanentInstructor("Kerem","Ankara","0507",9000);
        Instructor permanentInstructor2 = new PermanentInstructor("Tahsin" , "Tokat","0505",13500);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student3);
        course1.getStudentList().add(student4);
        course2.getStudentList().add(student2);
        course3.getStudentList().add(student2);
        course2.getStudentList().add(student3);

        student1.getCourseList(course1);

        student2.getCourseList(course1);
        student2.getCourseList(course2);
        student2.getCourseList(course3);

        student3.getCourseList(course1);
        student3.getCourseList(course2);

        student4.getCourseList(course1);

        iStudentRepository.save(student1);
        iStudentRepository.save(student2);
        iStudentRepository.save(student3);
        iStudentRepository.save(student4);

        iCourseRepository.save(course1);
        iCourseRepository.save(course2);
        iCourseRepository.save(course3);

        iInstructorRepository.save(permanentInstructor1);
        iInstructorRepository.save(permanentInstructor2);
        iInstructorRepository.save(visitingResearcher);

        logger.info("All Test Data Save");

    }
}
