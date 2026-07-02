import {test,expect} from "../fixtures/baseFixture";
import data from "../testData/registerData.json";
test.describe("Register test @smoke",()=>{
    test("Register",async({registerPage})=>{
        await registerPage.navigate();
        await registerPage.RegisterAction(
            data.fname,
            data.lname,
            data.email,
            data.phone,
            data.pass,
            data.cpass
        )
        await expect(registerPage.created).toBeVisible();
        console.log("Account created");
    })
})