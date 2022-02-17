package com.timnjonjo.digilend.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Controller
@RequestMapping(value = "/")
public class DashboardController {

    @GetMapping
    public String index() {
        return "layout";
    }
}
