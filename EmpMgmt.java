import javax.swing.JOptionPane;
import java.util.*;

class Employee {
    private int employeeNo;
    private String employeeName;
    private String employeeIc;
    private String employeeGender;
    private String employeeRole;
    private int salary;

    Employee(int employeeNo, String employeeName, String employeeIc, String employeeGender, String employeeRole,
            int salary) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.employeeIc = employeeIc;
        this.employeeGender = employeeGender;
        this.employeeRole = employeeRole;
        this.salary = salary;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeIc() {
        return employeeIc;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String toString() {
        return employeeNo + " || \t\t" + employeeName + " || \t\t" + employeeIc + " || \t\t" + employeeGender
                + " || \t\t"
                + employeeRole + " || \t\t"
                + salary;
    }
}

class EmpMgmt {
    public static void main(String[] args) {

        List<Employee> c = new ArrayList<Employee>();
        int choise;
        do {
            choise = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            "1. INSERT Employee Info \n2. DISPLAY Employee Info \n3. SEARCH Employee Info \n4. DELETE Employee Info \n5. UPDATE Employee Info \nPlease choose your action from the list above (0 to exit):"));

            switch (choise) {
                case 1:
                    int eno = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter employee number : "));
                    String employeeName = JOptionPane.showInputDialog(null, "Please enter employee name  : ");
                    String employeeIc = JOptionPane.showInputDialog(null, "Please enter employee IC  : ");
                    String employeeGender = JOptionPane.showInputDialog(null, "Please enter employee gender  : ");
                    String employeeRole = JOptionPane.showInputDialog(null, "Please enter employee role  : ");
                    int salary = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter employee salary : "));

                    c.add(new Employee(eno, employeeName, employeeIc, employeeGender, employeeRole, salary));
                    break;
                case 2:

                    String display = "----------------------------\n";
                    display += "No || \t\tName || \t\tEmployee IC || \t\tGender || \t\tRole || \t\tSalary\n";
                    Iterator<Employee> i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        display += e.toString() + "\n";
                    }
                    display += "----------------------------";
                    JOptionPane.showMessageDialog(null, display);
                    break;
                case 3:
                    boolean found = false;
                    int employeeNo = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Please enter employee number to Search :"));
                    String searchResult = "----------------------------\n";
                    searchResult += "No || \t\tName || \t\tEmployee IC || \t\tGender || \t\tRole || \t\tSalary\n";
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmployeeNo() == employeeNo) {
                            searchResult += e.toString() + "\n";
                            found = true;
                        }
                    }

                    if (!found) {
                        searchResult += "Record Not Found\n";
                    }
                    searchResult += "----------------------------";
                    JOptionPane.showMessageDialog(null, searchResult);
                    break;
                case 4:
                    found = false;
                    employeeNo = Integer
                            .parseInt(JOptionPane.showInputDialog("Please enter employee number to Delete :"));
                    StringBuilder output = new StringBuilder("----------------------------\n");
                    for (Employee e : c) {
                        if (e.getEmployeeNo() == employeeNo) {
                            c.remove(e);
                            found = true;
                            output.append("Record is Deleted Successfully...!\n");
                            break;
                        }
                    }

                    if (!found) {
                        output.append("Record Not Found\n");
                    }
                    output.append("----------------------------");
                    JOptionPane.showMessageDialog(null, output.toString());
                    break;

                case 5:
                    found = false;
                    employeeNo = Integer
                            .parseInt(JOptionPane.showInputDialog("Please enter employee number to Update :"));

                    for (ListIterator<Employee> li = c.listIterator(); li.hasNext();) {
                        Employee e = li.next();
                        if (e.getEmployeeNo() == employeeNo) {
                            employeeName = JOptionPane.showInputDialog("Enter new Name : ");
                            employeeIc = JOptionPane.showInputDialog("Enter new IC : ");
                            employeeGender = JOptionPane.showInputDialog("Enter new Gender : ");
                            employeeRole = JOptionPane.showInputDialog("Enter new Role : ");
                            salary = Integer.parseInt(JOptionPane.showInputDialog("Enter new Salary : "));
                            li.set(new Employee(employeeNo, employeeName, employeeIc, employeeGender, employeeRole,
                                    salary));
                            found = true;
                            break;
                        }
                    }

                    output = new StringBuilder("----------------------------\n");
                    if (!found) {
                        output.append("Record Not Found\n");
                    } else {
                        output.append("Record is Updated Successfully...!\n");
                    }
                    output.append("----------------------------");
                    JOptionPane.showMessageDialog(null, output.toString());
                    break;
            }
        } while (choise != 0);
    }
}
