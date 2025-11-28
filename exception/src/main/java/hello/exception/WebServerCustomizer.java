package hello.exception;

import org.springframework.boot.web.error.ErrorPage;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        //해당 상태코드가 발생하면 해당 컨트롤러를 호출해라
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
        //Exception 이 터지면 해당 컨트롤러를 호출해라
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class,"/error-page/500");

        factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
    }


}
