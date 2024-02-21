package com.globant;

import org.testng.annotations.Factory;

public class UserFactory {
    @Factory
    public Object[] createInstances() {
        Object[] instances = new Object[1];
        String password = "secret_sauce";

        instances[0] = new UserTest("standard_user",password);
//        instances[1] = new UserTest("locked_out_user",password);
//        instances[2] = new UserTest("problem_user",password);
//        instances[3] = new UserTest("performance_glitch_user",password);
//        instances[4] = new UserTest("error_user",password);
//        instances[5] = new UserTest("visual_user",password);

        return instances;
    }
}
