package com.company.TestManager.Tests._4EditAccount.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._4EditAccount.EditAccountResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest14 extends UnitTest{
    public EditAccountUnitTest14(Test test) {super(test, "'re_pass' does not match the 'password' - Can not edit account with wrong access token ");
    }
    public void test() throws IOException {
        //        create request object
        this.params.put("email", "Cubee@gmail.com");
        this.params.put("password", "12345678");
        this.params.put("re_pass", "12323123");
        this.params.put("name",  Util.randomAlphabetString(8));
        this.params.put("address", Util.randomAlphabetString(20));
        this.params.put("phone", "0932198999");

        EditAccountResponse res = this.sendPostRequestWithAccessToken(EditAccountResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
    }
}
