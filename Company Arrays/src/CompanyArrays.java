// This program will provide an employee report. (Jade Park - 7/22/2021)

import java.util.Scanner;

public class CompanyArrays {
   
   public static int numberOfEmployees;
   public static int typeOfEmployee;
   public static int[] employeeList;
    
   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to Starr! This program will provide a report including salaried and hourly workers.");
      System.out.print("Please enter the total number of employees to be entered: ");
      numberOfEmployees = input.nextInt();
      
      // creating a 1d array that holds employee IDs input by the user
      int[] employeeList = new int[numberOfEmployees];
      
      System.out.println("Enter an employee ID: ");  
      

      for (int i = 0; i < numberOfEmployees; i++) {     
         int length = String.valueOf(employeeList[i]).length();
         
         // if the employee ID is not 6 digits, the user has an option to input again
         if (length != 6) {
            System.out.println("Invalid Employee ID Number! Input a valid, 6-digit employee ID.");
            i -= 1;
         } 
      }  
      
      // calls the selection sort method
      selectionSort(employeeList);
      
      // prints out the IDs in numerical order
      System.out.println("\nHere are the employee ID's you've output so far. ");
      // foreach loop 
      for (int i: employeeList) {
         System.out.println(i);
      }
      
      // creating the 2d array
      int[][] employeeDatabase = new int[numberOfEmployees][2];
      
      // places the employee IDs from the 1d array into a singular column of the 2d array
      for (int i = 0; i <= employeeList.length - 1; i++) {
         employeeDatabase[i][0] = employeeList[i];
      }
  
      // creating a 1d array holding each employee's type
      int[] typeOfEmployeeArray = new int [numberOfEmployees];
      System.out.println("\n");
      for (int i = 0; i < numberOfEmployees; i++) {
         System.out.print("Please enter 1 if employee " + employeeList[i] + " is salaried, or 2 if the employee is hourly: ");
         typeOfEmployeeArray[i] = input.nextInt(); 
         
         // lets the user know if they input something invalid
         if (typeOfEmployeeArray[i] < 1 || typeOfEmployeeArray[i] > 2) {
            System.out.println("Invalid input! Type 1 for salaried or 2 for hourly.");
            i -= 1;
         }   
      }
      
      // placing each employee's types into the 2d array we created earlier
      for (int i = 0; i <= employeeList.length - 1; i++) {
         employeeDatabase[i][1] = typeOfEmployeeArray[i];
      }
      
      // creating arrays that each hold a specific type of employee (salaried vs hourly)
      int[] salariedEmployees = new int[numberOfEmployees];
      int[] hourlyEmployees = new int[numberOfEmployees];
      
      for (int i = 0; i <= numberOfEmployees - 1; i++) {
         if (employeeDatabase[i][1] == 1) {
            salariedEmployees[i] = employeeList[i];
            
         } else if (employeeDatabase[i][1] == 2) {
            hourlyEmployees[i] = employeeList[i];
         }
      }
      
      // prints out employee ID's that are salaried
      System.out.println("\nSalaried employees are: ");  
         
      for (int i = 0; i < salariedEmployees.length; i++) {  
         if (salariedEmployees[i] != 0) {
            System.out.println(salariedEmployees[i]);
         }          
      }
      
      // prints out employee ID's that are hourly
      System.out.println("\nHourly employees are: ");  
         
      for (int i = 0; i < hourlyEmployees.length; i++) {  
         if (hourlyEmployees[i] != 0) {
            System.out.println(hourlyEmployees[i]);
         } 
      }
   }
   
   
   // selection sort method
   public static void selectionSort(int[] list) {

      for (int i = 0; i < list.length - 1; i++) {
         int currentMin = list[i];
         int currentMinIndex = i;
         
         for (int j = i + 1; j < list.length; j++) {
            if (currentMin > list[j]) {
               currentMin = list[j];
               currentMinIndex = j;
            }
         }
         
         if (currentMinIndex != i) {
            list[currentMinIndex] = list[i];
            list[i] = currentMin;
         }
      }
   }
}