package com.company.TestManager.Tests._2Login.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Tests._2Login.LoginResponse;

import java.io.IOException;

public class LoginUnitTest3 extends UnitTest {
    public LoginUnitTest3(Test test) {
        super(test, "With wrong email format, response code should be 1001 and data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params.put("email", "thanh12345com");
        this.params.put("password", "12345654sdf6");

        LoginResponse res = this.sendPostRequest(LoginResponse.class);

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
    }
}
