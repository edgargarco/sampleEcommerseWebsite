package spring.jpa.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControllerAdvisor {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle404(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","ex.getMessage()");
        mv.setViewName("error/404");
        return mv;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalError.class)
    public ModelAndView handle500(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error/500");
        return mv;
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ModelAndView handle401(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error/401");
        return mv;
    }


}
