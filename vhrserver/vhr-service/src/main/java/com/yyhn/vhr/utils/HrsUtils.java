package com.yyhn.vhr.utils;

import com.yyhn.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrsUtils {
    public static Hr getCurrentHr(){
        return (Hr)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
