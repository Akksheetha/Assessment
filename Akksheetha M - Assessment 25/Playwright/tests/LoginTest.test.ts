import {test,expect} from "../fixtures/baseFixture";
import data from "../testData/LoginData.json";
test.describe("Login test @regression",()=>{
    test("Valid Login",async({loginPage})=>{
        await loginPage.navigate();
        await loginPage.loginAction(
            data.valid.email,
            data.valid.password
        )
        await expect(loginPage.success).toBeVisible();
    })
    test("InValid Login",async({loginPage})=>{
        await loginPage.navigate();
        await loginPage.loginAction(
            data.invalidemail.email,
            data.invalidemail.password
        )
        await expect(loginPage.wrongemail).toBeVisible();
    })
    test("Incorrect Password",async({loginPage})=>{
        await loginPage.navigate();
        await loginPage.loginAction(
            data.incorrectpass.email,
            data.incorrectpass.password
        )
        await expect(loginPage.wrongemail).toBeVisible();
    })
})