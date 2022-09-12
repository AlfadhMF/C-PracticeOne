package API;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String BaseURI = RestAssured.baseURI = "hrm.syntaxtechs.net/syntaxapi/api";
    String Token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjI5MTI4MzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY2Mjk1NjAzMSwidXNlcklkIjoiNDMyMCJ9.iSHrCKL5_XySAXjQFI7999lbSIBfuYvX0O3FxHE3DEA";
    static String employee_id;

    @Test
    public void AGetCreateEmployee(){

        RequestSpecification preparedRequest = given().header("Content-Type" , "application/json").
                header("Authorization", Token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");


        response.prettyPrint();
        String EmployeeID =  response.jsonPath().getString("employee.employee_id");
        boolean ComparingEmployeeIDs = EmployeeID.contentEquals(employee_id);


        Assert.assertTrue(ComparingEmployeeIDs);
        response.then().assertThat().statusCode(200);

        String MiddleName = response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(MiddleName.contentEquals("MS"));
    }

    @Test
    public void CreateEmployee(){

        RequestSpecification PreparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", Token).body("{\n" +
                        "  \"emp_firstname\": \"Mohanad\",\n" +
                        "  \"emp_lastname\": \"Alfadhli\",\n" +
                        "  \"emp_middle_name\": \"Fadhel\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1997-12-18\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");

        Response response = PreparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();

        employee_id = response.jsonPath().getString("employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("Fadhel"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
        response.then().assertThat().body("Employee.emp_job_title",equalTo("QA Engineer"));
    }

    @Test
    public void UpdateEmployee(){
        RequestSpecification PreparedRequest = given().header("Authorization", Token).
                header("Content-Type","application/json").body("{\n" +
                        "  \"employee_id\": \""+ employee_id +"\",\n" +
                        "  \"emp_firstname\": \"Mohammad\",\n" +
                        "  \"emp_lastname\": \"Alfadhli\",\n" +
                        "  \"emp_middle_name\": \"Fadhel\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1993-06-06\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"Manual Tester\"\n" +
                        "}");


        Response response = PreparedRequest.when().post(" /updateEmployee.php");
        response.prettyPrint();

        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void BGetUpdatedEmployees(){
        RequestSpecification PreparedRequest = given().header("Constent-Type", "application/json").
                header("Authorization", Token).
                queryParam("employee_id",employee_id);

        Response response = PreparedRequest.when().get("/getOneEmployee.php");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        String MiddleName = response.jsonPath().getString("Employee.emp_middle_name");
        Assert.assertTrue(MiddleName.contentEquals("Fadhel"));
    }

    @Test
    public void GetAllEmployee(){

        RequestSpecification PreparedRequest = given().header("Authorization", Token).
                header("Content-Type", "application/json");

        Response response = PreparedRequest.when().get("/getAllEmployees.php");
        String AllEmployees = response.prettyPrint();

        JsonPath JS = new JsonPath(AllEmployees);

        int Count = JS.getInt("Employees.size()");
        System.out.println(Count);

        for(int i = 0; i<Count; i++){
            String EmployeeIDs = JS.getString("Employees["+ i +"].employee_id");
            System.out.println(EmployeeIDs);
        }
    }



}
