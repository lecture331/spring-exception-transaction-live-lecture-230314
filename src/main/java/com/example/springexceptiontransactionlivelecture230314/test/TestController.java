package com.example.springexceptiontransactionlivelecture230314.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/required")
    public void testRequired() throws RuntimeException {
        testService.testRequired();
    }

    @GetMapping("/required-new")
    public void testRequiredNew() {
        testService.testRequiredNew();
    }

    @GetMapping("/mandatory")
    public void testMandatory() {
        testService.testMandatory();
    }

    @GetMapping("/never")
    public void testNever() {
        testService.testNever();
    }

    @GetMapping("/nested")
    public void testNested() {
        testService.testNested();
    }

}
