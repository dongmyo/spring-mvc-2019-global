package com.nhnent.edu.spring_mvc.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

// TODO #2: 참고.
public class MeasuringUtils {
    private static final String START_TIME = "startTime";


    private MeasuringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void start(HttpServletRequest request) {
        request.setAttribute(START_TIME, System.currentTimeMillis());
    }

    public static long stopAndGetElapsed(HttpServletRequest request) {
        long endTime = System.currentTimeMillis();

        long startTime = Optional.ofNullable((Long) request.getAttribute(START_TIME))
                                 .orElse(endTime);

        return (endTime - startTime);
    }

}
