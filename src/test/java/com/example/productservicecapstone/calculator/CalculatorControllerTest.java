package com.example.productservicecapstone.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito; //spring provides mockito
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorControllerTest {

//    Below is using Mockito
//    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
//    CalculatorController calculatorController = new CalculatorController(calculatorService);


    //Below is using Spring

    // Before adding @SpringBootTest annotation, @Autowired will give error here because CalculatorController is not a spring bean.
    // Because this class is part of test package and spring application starter does not scan test packages and beans are not created for test classes.
    // In short, this is not a part of spring application context.
    // We don't want to take the ENTIRE spring context here because we don't want to start the server for running tests.
    // We will just take a partial spring context for testing. This is done by @SpringBootTest annotation.

    @MockitoBean
    CalculatorService calculatorService;

    @Autowired
    CalculatorController calculatorController;

    @Test
    public void testAddWhenTwoIntegersArePassedReturnsAnInteger(){

        when(calculatorService.addInService(10,5)).thenReturn(15);
        when(calculatorService.addInService(10,6)).thenThrow(new RuntimeException("Some exception"));

        //Arrange
         int a = 10;
         int b = 5;
         int expectedResult = 15;

         //Act
         int actualResult = calculatorController.add(a,b);

         //Assert
         Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddWhenAnyTwoIntegersArePassedReturnsAnInteger(){

        when(calculatorService.addInService(anyInt(),anyInt())).thenReturn(15);

        //Arrange
        int a = 100;
        int b = 5;
        int expectedResult = 15;

        //Act
        int actualResult = calculatorController.add(a,b);

        //Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
