[1mdiff --cc src/model/Student.java[m
[1mindex 1ed8dc7,b7e90f1..0000000[m
[1m--- a/src/model/Student.java[m
[1m+++ b/src/model/Student.java[m
[36m@@@ -1,9 -1,9 +1,14 @@@[m
  package model;[m
  [m
[31m -import interfaces.Searchable;[m
[32m +import exceptions.InvalidAgeException;[m
[32m +import exceptions.InvalidNameException;[m
  import interfaces.Enrollable;[m
[32m++<<<<<<< HEAD[m
[32m +import interfaces.Searchable;[m
[32m++=======[m
[32m+ import exceptions.InvalidNameException;[m
[32m+ import exceptions.InvalidAgeException;[m
[32m++>>>>>>> 8fc181e58fd25616809a4b3aab95ec8bf92f094a[m
  import java.util.ArrayList;[m
  import java.util.List;[m
  [m
[36m@@@ -14,18 -14,14 +19,26 @@@[m [mpublic class Student extends Person imp[m
      protected List<String> enrolledCourses;[m
  [m
      public Student(String name, int age, String email, String phoneNumber,[m
[32m++<<<<<<< HEAD[m
[32m +                    String id, String major, double gpa)[m
[32m +            throws InvalidNameException, InvalidAgeException {[m
[32m++=======[m
[32m+                     String id, String major, double gpa) throws InvalidNameException, InvalidAgeException {[m
[32m++>>>>>>> 8fc181e58fd25616809a4b3aab95ec8bf92f094a[m
          super(name, age, email, phoneNumber, id);[m
[32m +        validateName(name);[m
[32m +        validateAge(age);[m
          this.major = major;[m
          this.gpa = gpa;[m
          this.enrolledCourses = new ArrayList<>();[m
      }[m
  [m
[32m++<<<<<<< HEAD[m
[32m +    public Student(String name, int age, String email, String phoneNumber, String id)[m
[32m +            throws InvalidNameException, InvalidAgeException {[m
[32m++=======[m
[32m+     public Student(String name, int age, String email, String phoneNumber, String id) throws InvalidNameException, InvalidAgeException {[m
[32m++>>>>>>> 8fc181e58fd25616809a4b3aab95ec8bf92f094a[m
          this(name, age, email, phoneNumber, id, "Undeclared", 0.0);[m
      }[m
  [m
