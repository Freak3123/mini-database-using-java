package Ashreeta_2241016258;
import java.util.Arrays;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        // Create an employee database
        Employee[] employees = createEmployeeDatabase();

        // Arrange the employee details in descending order by salary
        arrangeEmployeeBySalary(employees);

        // Display the details of employees whose jobPosition is manager
        getEmployeesByJobPosition(employees, "manager");

         // Display the details of employees whose hireDate is between 01-04-2022 to 31-03-2023
         Date startDate = new Date(2022, 4, 1); // April 1, 2022
         Date endDate = new Date(2023, 3, 31); // March 31, 2023
         getEmployeesByHireDate(employees, startDate, endDate);

        // Find the number of foreign employees
        int foreignCount = foreignEmployeeCount(employees);
        System.out.println("Number of foreign employees: " + foreignCount);

        // Display the details of employees whose salary is in the range 150000 INR to 300000 INR
        double minSalary = 150000;
        double maxSalary = 300000;
        getEmployeesBySalary(employees, minSalary, maxSalary);
    }

    public static void arrangeEmployeeBySalary(Employee[] employees) {
        Arrays.sort(employees, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("Employees arranged in descending order by salary:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ", Salary: " + employee.getSalary());
        }
    }

    public static void getEmployeesByJobPosition(Employee[] employees, String jobPosition) {
        System.out.println("Employees with jobPosition '" + jobPosition + "':");
        for (Employee employee : employees) {
            if (employee.getJobPosition().equalsIgnoreCase(jobPosition)) {
                System.out.println("Name: " + employee.getName() + ", Job Position: " + employee.getJobPosition());
            }
        }
    }

    public static void getEmployeesByHireDate(Employee[] employees, Date startDate, Date endDate) {
        System.out.println("Employees hired between " + startDate.getDay() + "-" +
                startDate.getMonth() + "-" + startDate.getYear() + " to " +
                endDate.getDay() + "-" + endDate.getMonth() + "-" + endDate.getYear() + ":");
        for (Employee employee : employees) {
            Date hireDate = employee.getHireDate();
            if (isDateInRange(hireDate, startDate, endDate)) {
                System.out.println("Name: " + employee.getName() + ", Hire Date: " +
                        hireDate.getDay() + "-" + hireDate.getMonth() + "-" + hireDate.getYear());
            }
        }
    }

    public static int foreignEmployeeCount(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getContactNumber().startsWith("+")) {
                count++;
            }
        }
        return count;
    }

    public static void getEmployeesBySalary(Employee[] employees, double minSalary, double maxSalary) {
        System.out.println("Employees with salary in the range " + minSalary + " INR to " + maxSalary + " INR:");
        for (Employee employee : employees) {
            double salary = employee.getSalary();
            if (salary >= minSalary && salary <= maxSalary) {
                System.out.println("Name: " + employee.getName() + ", Salary: " + salary);
            }
        }
    }

    public static boolean isDateInRange(Date date, Date startDate, Date endDate) {
    if (date.getYear() > startDate.getYear() && date.getYear() < endDate.getYear()) {
        return true;
    } else if (date.getYear() == startDate.getYear() && date.getYear() == endDate.getYear()) {
        if (date.getMonth() > startDate.getMonth() && date.getMonth() < endDate.getMonth()) {
            return true;
        } else if (date.getMonth() == startDate.getMonth() && date.getMonth() == endDate.getMonth()) {
            if (date.getDay() >= startDate.getDay() && date.getDay() <= endDate.getDay()) {
                return true;
            }
        } else if (date.getMonth() == startDate.getMonth() && date.getMonth() < endDate.getMonth()) {
            if (date.getDay() >= startDate.getDay()) {
                return true;
            }
        } else if (date.getMonth() > startDate.getMonth() && date.getMonth() == endDate.getMonth()) {
            if (date.getDay() <= endDate.getDay()) {
                return true;
            }
        }
    } else if (date.getYear() == startDate.getYear() && date.getYear() < endDate.getYear()) {
        if (date.getMonth() >= startDate.getMonth()) {
            return true;
        }
    } else if (date.getYear() > startDate.getYear() && date.getYear() == endDate.getYear()) {
        if (date.getMonth() <= endDate.getMonth()) {
            return true;
        }
    }
    return false;
}

public static Employee[] createEmployeeDatabase() {
    Employee[] employees = new Employee[500];

    // Create and populate Employee objects using a loop
    for (int i = 0; i < employees.length; i++) {
        // Create Employee object with appropriate values
        Employee employee = createEmployee(i);

        // Assign the created Employee object to the array
        employees[i] = employee;
    }

    return employees;
}

public static Employee createEmployee(int index) {
    // Generate unique values for each employee using the index parameter
    String name = "Employee " + (index + 1);
    int empId = 1001 + index;
    double salary = 50000.0 + (index * 1000);
    Date hireDate = generateRandomHireDate();
    String jobPosition = "Manager";
    String contactNumber = "+1234567890";
    Address address = new Address("123 Main St", "City", "State", "12345");

    // Create and return the Employee object with the generated values
    return new Employee(name, empId, salary, hireDate, jobPosition, contactNumber, address);
}

public static Ashreeta_2241016258.Date generateRandomHireDate() {
    // Generate a random hire date within a specific range (e.g., within the past 5 years)
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, -5); // Subtract 5 years from the current date
    Ashreeta_2241016258.Date startDate = new Ashreeta_2241016258.Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

    calendar.add(Calendar.YEAR, 5); // Reset the calendar to the current date
    Ashreeta_2241016258.Date endDate = new Ashreeta_2241016258.Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

    // Generate a random hire date between startDate and endDate
    long startMillis = startDate.getTime();
    long endMillis = endDate.getTime();

    // Generate a random timestamp between startMillis and endMillis
    long randomTimestamp = startMillis + (long) (Math.random() * (endMillis - startMillis + 1));

    // Create a Calendar instance and set the time to the randomTimestamp
    Calendar randomCalendar = Calendar.getInstance();
    randomCalendar.setTimeInMillis(randomTimestamp);

    // Create the Ashreeta_2241016258.Date object using the Calendar instance
    Ashreeta_2241016258.Date randomHireDate = new Ashreeta_2241016258.Date(
        randomCalendar.get(Calendar.DAY_OF_MONTH),
        randomCalendar.get(Calendar.MONTH) + 1,
        randomCalendar.get(Calendar.YEAR)
    );

    return randomHireDate;
}

}

