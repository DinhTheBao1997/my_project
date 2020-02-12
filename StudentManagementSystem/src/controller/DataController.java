package controller;

import model.Departments;
import model.Students;
import model.Subjects;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private Scanner scanner;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    public void openFileToRead(File fileName) {
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead(File fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewDepartment(Departments departments, File fileName) {
        openFileToRead(fileName);
        printWriter.println("|" + departments.getDepartmentID() + "|" + departments.getDepartmentName() + "|");
        closeFileAfterRead(fileName);
    }

    public void addNewSubject(Subjects subjects, File fileName) {
        openFileToRead(fileName);
        printWriter.println("|" + subjects.getSubjectID() + "|" + subjects.getSubjectName() + "|" +
                subjects.getTotalLessons() + "|" + subjects.getSubjectType() + "|");
        closeFileAfterRead(fileName);
    }

    public void addNewStudent(Students students, File fileName) {
        openFileToRead(fileName);
        printWriter.println("|" + students.getStudentID() + "|" +students.getFullName() + "|" + students.getDepartmentID() +
                "|" + students.getAddress() + "|" + students.getPhoneNumber() + "|");
        closeFileAfterRead(fileName);
    }

    public void readListOfDepartmentsFromFile(File fileName) throws FileNotFoundException {
        scanner = new Scanner(fileName);
        String dataReturn = null;
        int number = 0;
        while (scanner.hasNextLine()) {
            ++number;
            String data = scanner.nextLine();
            int stringLength = data.length();
            char[] departmentID = new char[2];
            char[] departmentName = new char[stringLength - 5];
            data.getChars(1, 3, departmentID, 0);
            data.getChars(4, stringLength - 1, departmentName, 0);
            String temp_1 = new String(departmentID);
            String temp_2 = new String(departmentName);
            System.out.println(number + ".\t\tDepartment ID: " + temp_1 + "\n" + "\t" + "Department name: " +
                    temp_2);
        }
        scanner.close();
    }

    public int numberOfLine(File fileName) throws FileNotFoundException {
        int number = 0;
        scanner = new Scanner(fileName);
        while (scanner.hasNextLine()) {
            ++number;
            scanner.nextLine();
        }
        scanner.close();
        return number;
    }

    public String chooseDepartmentFromFile(int location, File fileName) throws FileNotFoundException{
        scanner = new Scanner(fileName);
        boolean check = false;
        int local = 0;
        String result = null;
        while (scanner.hasNextLine() && !check) {
            ++local;
            String data = scanner.nextLine();
            if (local == location) {
                char[] departmentID = new char[2];
                data.getChars(1, 3, departmentID, 0);
                result = new String(departmentID);
                check = true;
            }
        }
        scanner.close();
        return result;
    }

    public void readListOfSubjectType(File fileName) throws FileNotFoundException {
        scanner = new Scanner(fileName);
        String dataReturn = null;
        int number = 0;
        while (scanner.hasNextLine()) {
            ++number;
            String data = scanner.nextLine();
            System.out.println(number + ". " + data);
        }
        scanner.close();
    }

    public String chooseSubjectTypeFromFile(int location, File fileName) throws FileNotFoundException{
        scanner = new Scanner(fileName);
        boolean check = false;
        int local = 0;
        String result = null;
        while (scanner.hasNextLine() && !check) {
            ++local;
            String data = scanner.nextLine();
            if (local == location) {
                result = data;
                check = true;
            }
        }
        scanner.close();
        return result;
    }

    public void readAllSubjectOfSameDepartment(String departmentID, File fileName) throws FileNotFoundException {
        scanner = new Scanner(fileName);
        int total = 0;
        boolean check = false;
        char[] tempData = new char[2];
        ArrayList<Character> tempResult = new ArrayList<>();
        String result;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            data.getChars(1, 3, tempData, 0);
            String temp = new String(tempData);
            if (temp.equals(departmentID)) {
                ++total;
                String[] tempArray = data.split("\\|");
                result = tempArray[2];
                System.out.println(total + ". " + result);
                check = true;
            }
        }
        if (!check) {
            System.out.println("There are not any subject of department ID: " + departmentID);
        }
    }
}
