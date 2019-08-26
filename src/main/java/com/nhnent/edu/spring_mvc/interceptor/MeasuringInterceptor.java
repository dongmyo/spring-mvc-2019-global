package com.nhnent.edu.spring_mvc.interceptor;

import com.nhnent.edu.spring_mvc.utils.MeasuringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * TODO #1: 실습 - Controller의 수행 시간을 측정하는 interceptor 구현하기.
 *
 * cf.)
 *  preHandle
 *      MeasuringUtils.start(request)
 *  postHandler
 *      MeasuringUtils.stopAndGetElapsed(request)
 *      ModelAndView에 "elapsed" 라는 이름으로 속성 추가.
 */
public class MeasuringInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
        MeasuringUtils.start(req);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav)
            throws Exception {
        mav.addObject("elapsed", MeasuringUtils.stopAndGetElapsed(req));
    }
}
