package examples;


import org.junit.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.hasSize;

public class usCountryCodes {
//test
    @Test
    public void requestZipCodeAndResponse_Details() {

        given().
                log().all().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                log().body();
        //test again
    }

    @Test
    public void checkPlaceName_expectBeverlyHills() {
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
                    body("places[0].'place name'", equalTo("Beverly Hills"));
        // test1 amir branch
    }

    @Test
    public void checkPlaceNameAmount_expect1() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }
}
