package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class CreateAuctionUnitTest2 extends UnitTest {
    public CreateAuctionUnitTest2(Test test) {
        super(test, "not input yet, Server will return code 1004");
    }

    @Override
    public void test() throws IOException {
        this.params.put("category_id", "5");
        this.params.put("start_date", "2023-06-18 11:03:38");
        this.params.put("end_date", "2023-06-20 11:03:38");
        this.params.put("title_ni", "Tui xach "+Util.randomAlphabetString(20));

        CreateAuctionResponse res = sendPostRequest(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
