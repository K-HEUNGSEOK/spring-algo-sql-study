package hello.login.web.filter;

import hello.login.web.SessionConst;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

@Slf4j
public class LoginCheckFilter implements Filter {
    private static final String[] whitelist = {"/", "/members/add", "/login", "logout", "/css/*"};
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try{
            log.info("인증 필터 체크 시작 {}", requestURI);
            if (isLoingCheckPath(requestURI)){
                log.info("인증 체크 로직 실행 {}" , requestURI);
                HttpSession session = httpRequest.getSession(false);
                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null){
                    log.info("미인증 사용자 요청 {}",requestURI);
                    //로그인으로 redirect 해준다
                    //예를들어 마이페이지 들어갔더니 로그인하래서 로그인하면 다시 마이페이지 화면부터 보여주는 것처럼 해주는 것
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
                    return;
                }
            }
            chain.doFilter(request,response);
        }catch (Exception e){
            throw e; //예외 로깅 가능
        }finally {
            log.info("인증 체크 필터 종료 {}", requestURI);
        }
    }
    /**
     * 화이트 리스트의 경우 인증 체크를 안한다.
     */
    private boolean isLoingCheckPath(String requestURI){
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }
}
