package hello.login.web.interceptor;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private static final String LOG_ID = "logId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid); //클릭 한번의 생명주기를 가진 것을 담아서 컨트롤러로 보내는 역할

        //RequestMapping 의 핸들러가 이거임
        //정적리소스는 ResourceHttpRequestHandler 임
        if (handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler; //컨트롤러 메서드 모든정보가 포함되어있음
        }
        log.info("REQUEST [{}] [{}] [{}]", uuid, requestURI, handler);
        return true; //이제 컨트롤러로 넘어간다.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandler [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //예외사항은 여기서 출력할 수 있음
        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);
        log.info("REQUEST [{}] [{}] [{}]", logId, requestURI, handler);
        if (ex != null){
            log.error("afterCompletion error!", ex); //예외 객체도 있음
        }
    }
}
