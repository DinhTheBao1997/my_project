package view;

import controller.DataController;
import model.Departments;
import model.Students;
import model.Subjects;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class View {
    public static void main(String args[]) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        DataController dataController = new DataController();
        Departments departments;
        Subjects subjects;
        Students students;

        int choice = 0;
        int temp = 0;
        boolean check;
        String tempData;
        File fileDepartment =
                new File("E:\\Java\\StudentManagementSystem\\src\\storage\\ListOfDepartments.txt");
        File fileSubjectType =
                new File("E:\\Java\\StudentManagementSystem\\src\\storage\\ListOfSubjectTypes.txt");
        File fileSubject =
                new File("E:\\Java\\StudentManagementSystem\\src\\storage\\ListOfSubjects.txt");
        File fileStudent =
                new File("E:\\Java\\StudentManagementSystem\\src\\storage\\ListOfStudents.txt");
        String departmentID = null;
        do {
            System.out.println("_____________________MENU_____________________");
            System.out.println("List of Functions:");
            System.out.println("0. Exit.");
            System.out.println("1. Add new department.");
            System.out.println("2. Add new subject");
            System.out.println("3. Add new student.");
            System.out.println("4. View subject list base on department.");
            System.out.println("5. Find student by name.");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please choose a natural number grater thanh 0 and less than 4");
                continue;
            }
            scanner.nextLine();
        switch (choice) {
            case 0:
                System.out.println("Thanks you!\nGoodbye!");
                break;

            case 1:
                boolean checkDepartmentID = false;
                String departmentName;
                System.out.println("Function: add new department.");
                while (!checkDepartmentID) {
                    System.out.print("Department ID: ");
                    departmentID = scanner.nextLine();
                    if (departmentID.length() == 2) {
                        checkDepartmentID = true;
                    }
                    else {
                        System.out.println("Department ID' length must have 2 symbols");
                    }
                }
                System.out.println();
                System.out.print("Department name: ");
                departmentName = scanner.nextLine();
                departments = new Departments(departmentID, departmentName);
                dataController.addNewDepartment(departments, fileDepartment);
                break;

            case 2://String subjectID, String subjectName, int totalLessons, String subjectType
                check = false;
                String subjectID; //Format: EE1234
                String subjectName;
                int totalLesson;
                String subjectType;
                int id;
                System.out.println("Function: add new subject.");
                do {
                    System.out.print("Subject ID: ");
                    id = scanner.nextInt();
                    System.out.println();
                    if (id < 1000 || id > 9999) {
                        System.out.println("Please re-enter the subject ID.");
                    }
                    else {
                        check = true;
                    }
                } while (!check);
                check = false;
                System.out.println();
                scanner.nextLine();
                System.out.println("List Of Department:");
                try {
                    dataController.readListOfDepartmentsFromFile(fileDepartment);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int numberOfLine = dataController.numberOfLine(fileDepartment);
                do {
                    System.out.print("Choose a department: ");
                    temp = scanner.nextInt();
                    if (temp > 0 && temp <= numberOfLine) {
                        check = true;
                    }
                    else {
                        System.out.println("Your choice number must greater 0 and less than " + numberOfLine);
                    }
                } while (!check);
                scanner.nextLine();
                departmentID = dataController.chooseDepartmentFromFile(temp, fileDepartment);
                subjectID = departmentID + id;
                System.out.print("Subject name: ");
                subjectName = scanner.nextLine();
                check = false;
                System.out.print("Total Lesson: ");
                totalLesson = scanner.nextInt();
                System.out.println("List Of Subject Type: ");
                dataController.readListOfSubjectType(fileSubjectType);
                System.out.println(subjectName);
                numberOfLine = dataController.numberOfLine(fileSubjectType);
                do {
                    System.out.print("Choose a subject type = ");
                    temp = scanner.nextInt();
                    if (temp > 0 && temp <= numberOfLine) {
                        check = true;
                    }
                    else {
                        System.out.println("Your choice number must greater 0 and less than " + numberOfLine);
                    }
                } while (!check);
                subjectType = dataController.chooseSubjectTypeFromFile(temp, fileSubjectType);
                subjects = new Subjects(subjectID, subjectName, subjectType, totalLesson);
                dataController.addNewSubject(subjects, fileSubject);
                break;

            case 3: //String fullName, String departmentID, String address, String phoneNumber
                String fullName;
                String address;
                String phoneNumber;
                System.out.println("Function: Add new student");
                System.out.print("Student full name: ");
                fullName = scanner.nextLine();
                System.out.println("List Of Department: ");
                try {
                    dataController.readListOfDepartmentsFromFile(fileDepartment);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                numberOfLine = dataController.numberOfLine(fileDepartment);
                check = false;
                do {
                    System.out.print("Choose a department : ");
                    temp = scanner.nextInt();
                    if (temp > 0 && temp <= numberOfLine) {
                        check = true;
                    }
                    else {
                        System.out.println("Your choice number must greater 0 and less than " + numberOfLine);
                    }
                } while (!check);
                scanner.nextLine();
                departmentID = dataController.chooseDepartmentFromFile(temp, fileDepartment);
                System.out.print("Student address: ");
                address = scanner.nextLine();
                check = false;
                String tempNumber;
                do {
                    System.out.print("Student phone number: ");
                    tempNumber = scanner.nextLine();
                    System.out.println();
                    if (tempNumber.length() == 10) {
                        check = true;
                    }
                    else {
                        System.out.println("Phone number must have 10 number");
                    }
                } while (!check);
                tempNumber = tempNumber + " ";
                char[] tempChar = new char[12];
                tempChar[3] = '-';
                tempChar[7] = '-';
                tempNumber.getChars(0, 3, tempChar, 0);
                tempNumber.getChars(3,6, tempChar,4);
                tempNumber.getChars(6,10, tempChar,8);
                phoneNumber = new String(tempChar);
                students = new Students(fullName, departmentID, address, phoneNumber);
                dataController.addNewStudent(students, fileStudent);
                break;

            case 4:
                System.out.println("Function: View list of subject base on department.");
                System.out.println("List of department");
                try {
                    dataController.readListOfDepartmentsFromFile(fileDepartment);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                numberOfLine = dataController.numberOfLine(fileDepartment);
                check = false;
                do {
                    System.out.print("Choose a department : ");
                    temp = scanner.nextInt();
                    if (temp > 0 && temp <= numberOfLine) {
                        check = true;
                    }
                    else {
                        System.out.println("Your choice number must greater 0 and less than " + numberOfLine);
                    }
                } while (!check);
                scanner.nextLine();
                tempData = dataController.chooseDepartmentFromFile(temp, fileDepartment);
                dataController.readAllSubjectOfSameDepartment(tempData, fileSubject);
                break;

            case 5:

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        } while (choice != 0);
    }
}
