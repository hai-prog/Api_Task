package pages;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;

public class RegisterPage {

    SHAFT.API api ;
    private String email ;
    private String password ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public RegisterPage(SHAFT.API api) {
        this.api = api;
    }

    public void createAccount()
    {
        List<List<Object>> parameters = Arrays.asList(
                Arrays.asList("name" , "Haidy"),
                Arrays.asList("email" , "hmm@gmail.com"),
                Arrays.asList("password" , "1233"),
                Arrays.asList("title" , "Mrs"),
                Arrays.asList("birth_date" , "16"),
                Arrays.asList("birth_month", "05"),
                Arrays.asList("birth_year" , "1999"),
                Arrays.asList("firstname" , "haidy"),
                Arrays.asList("lastname", "osama"),
                Arrays.asList("company" , "vois"),
                Arrays.asList("address1" , "giza"),
                Arrays.asList("address2" , "giza"),
                Arrays.asList("country" , "India"),
                Arrays.asList("zipcode", "555"),
                Arrays.asList("state" , "giza"),
                Arrays.asList("city", "giza"),
                Arrays.asList("mobile_number", "01064145")

        );
       api.post("createAccount").
               setParameters(parameters, RestActions.ParametersType.FORM).
               setContentType(ContentType.URLENC)
               .perform();

      setEmail(parameters.get(1).toString());
      setPassword(parameters.get(2).toString());
    }
}
