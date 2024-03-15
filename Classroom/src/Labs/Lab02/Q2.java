package Labs.Lab02;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static class Student implements Comparable<Student>{
        String sNO, sName;
        int sJava;
        public Student(String sNO, String sName, int sJava) {
            this.sNO = sNO;
            this.sName = sName;
            this.sJava = sJava;
        }

        public String getSNO() {
            return sNO;
        }

        public void setSNO(String sNO) {
            this.sNO = sNO;
        }

        public String getSName() {
            return sName;
        }

        public void setSName(String sName) {
            this.sName = sName;
        }

        public int getSJava() {
            return sJava;
        }

        public void setSJava(int sJava) {
            this.sJava = sJava;
        }

        public int compareTo (Student s1) {
            return s1.getSJava()-sJava;
        }
    }
    public static int getHigh(Student[] students) {
        Arrays.sort(students);
        return students[0].getSJava();
    }

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        Student[] students = new Student[n];
        for (int i=0; i<n; i++){
            students[i] = new Student(r.next(), r.next(), r.nextInt());
        }
        System.out.println(getHigh(students));

    }
}
