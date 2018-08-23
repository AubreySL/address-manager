package com.sap.cloud.s4hana.examples;

import io.restassured.RestAssured;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.sap.cloud.s4hana.examples.HelloWorldServlet;
import com.sap.cloud.sdk.testutil.MockUtil;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith( Arquillian.class )
public class HelloWorldServletTest
{
    private static final MockUtil mockUtil = new MockUtil();

    @ArquillianResource
    private URL baseUrl;

    @Deployment
    public static WebArchive createDeployment()
    {
        return TestUtil.createDeployment(HelloWorldServlet.class);
    }

    @BeforeClass
    public static void beforeClass()
    {
        mockUtil.mockDefaults();
    }

    @Before
    public void before()
    {
        RestAssured.baseURI = baseUrl.toExternalForm();
    }

    @Test
    public void testService()
    {
        final String body = given().get("/hello").body().asString();
        assertThat(body).isEqualToIgnoringCase("Hello World!");
    }

    @Test
    public void testService1()
    {
        long startTime = System.currentTimeMillis();
        while(true) {
            final String body = given().get("/hello").body().asString();
            assertThat(body).isEqualToIgnoringCase("Hello World!");

            final long now = System.currentTimeMillis();
            if(now >= (startTime + TimeUnit.MINUTES.toMillis(1))) {
                break;
            }
        }
        System.out.println("End of test 1");
    }

    @Test
    public void testService2()
    {
        long startTime = System.currentTimeMillis();
        while(true) {
            final String body = given().get("/hello").body().asString();
            assertThat(body).isEqualToIgnoringCase("Hello World!");

            final long now = System.currentTimeMillis();
            if(now >= (startTime + TimeUnit.MINUTES.toMillis(2))) {
                break;
            }
        }
        System.out.println("End of test 2");
    }

    @Test
    public void testService3()
    {
        long startTime = System.currentTimeMillis();
        while(true) {
            final String body = given().get("/hello").body().asString();
            assertThat(body).isEqualToIgnoringCase("Hello World!");

            final long now = System.currentTimeMillis();
            if(now >= (startTime + TimeUnit.MINUTES.toMillis(3))) {
                break;
            }
        }
        System.out.println("End of test 3");
    }


}
