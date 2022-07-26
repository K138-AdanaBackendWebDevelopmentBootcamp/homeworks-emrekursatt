package dev.patika.clients;

import dev.patika.controller.CourseController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        if (checkTestDate() == 0) {
            saveTestData();
        }
        CourseController courseController = new CourseController();

        //Course newCourse = new Course("Geometri","G101",15);
        //CourseController.saveCourse(newCourse);


        //courseController.deleteCourse(courseList.get(4));
        //courseController.deleteCourse(5 );
        //courseController.deleteCourseWithPrimaryId(2);

        List<Course> courseList = courseController.findAllCourse();

        Course foundCourse = courseList.get(0);

        List<Student> studentList = courseController.getCourseStudentList(foundCourse);
        for (Student student : studentList) {
            System.out.println(student);
        }
        //foundCourse.setCourseCode("M102");
        //courseController.uptadeCourse(foundCourse, foundCourse.getId());

        //for (Course course : courseList) {
          // System.out.println(course);
        //}
        //System.out.println(courseController.findCourseById(1));




    }



    private static int checkTestDate() {
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("from Course ", Course.class).getResultList().size();
    }

    private static void saveTestData(){

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

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(student4);

            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);

            entityManager.persist(permanentInstructor1);
            entityManager.persist(permanentInstructor2);
            entityManager.persist(visitingResearcher);

            entityManager.getTransaction().commit();

            System.out.println("All Data Persisted");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }


    }

}
