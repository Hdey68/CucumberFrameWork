package testbase;

import pages.*;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;
    public static DashBoardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;
    public static PersonalDetailsPage personalDetailsPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashBoardPage ();
        addEmployeePage = new AddEmployeePage();
        employeeListPage = new EmployeeListPage();
        personalDetailsPage = new PersonalDetailsPage();



    }
}
