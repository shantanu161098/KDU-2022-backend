import javax.print.DocFlavor.STRING;

public class Employee{
    private String name;
    private int basic;
    private int equity;
    private int hra;
    private int gratuity;
    private int performance_bonus;

    public Employee(String name,int basic,int equity,int hra,int gratuity,int performance_bonus){
        this.name = name;
        this.basic =basic;
        this.equity =equity;
        this.hra =hra;
        this.gratuity =gratuity;
        this.performance_bonus =performance_bonus;

    }

    public void print_details(){
        System.out.println(name + " " + basic + " " +equity + " " +hra + " " +gratuity + " " +performance_bonus);
    }

    public static Employee[] sort(Employee[] employee_list)
    {
        int n = employee_list.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (employee_list[j].basic > employee_list[j+1].basic)
                {
                    Employee temp = employee_list[j];
                    employee_list[j] = employee_list[j+1];
                    employee_list[j+1] = temp;
                }
        
                return employee_list;
    }
    
    
    public static boolean isequal(Employee e1,Employee e2){
        return e1.equity == e2.equity;
    }
}



class Employee_with_vehicle extends Employee{
    String vehicle;
    public Employee_with_vehicle(String name,int basic,int  equity,int hra,int gratuity,int performance_bonus,String vehicle){
        super(name, basic, equity, hra, gratuity, performance_bonus);
        this.vehicle = vehicle;
    }

    // Method overriding
    public static boolean isequal(Employee_with_vehicle e1,Employee_with_vehicle e2){
        return e1.vehicle == e2.vehicle;
    }

}



class Main{
    public static void main(String[] args) {
        Employee[] employee_list = new Employee[5];

        // putting values

        employee_list[0] = new Employee("abc", 1000, 10, 1, 10000, 500);
        employee_list[1] = new Employee("def", 2000, 20, 1, 20000, 500);
        employee_list[2] = new Employee("ghi", 5000, 10, 1, 10000, 500);
        employee_list[3] = new Employee("jkl", 7000, 40, 1, 40000, 500);
        employee_list[4] = new Employee("mno", 500, 60, 1, 30000, 500);


        for(int i=0;i<5;i++){
            employee_list[i].print_details();
        }

        employee_list = Employee.sort(employee_list);
        System.out.println("================== After sorting based on basic pay ==========");
        for(int i=0;i<5;i++){
            employee_list[i].print_details();
        }
        

        System.out.println(Employee.isequal(employee_list[3],employee_list[1]));

        Employee_with_vehicle e1 = new Employee_with_vehicle("abc", 1000, 10, 1, 10000, 500,"santro");
        Employee_with_vehicle e2 = new Employee_with_vehicle("abc", 2000, 20, 2, 20000, 500,"santro");
        // method overriding
        
        System.out.println(Employee_with_vehicle.isequal(e1, e2));
    }


}