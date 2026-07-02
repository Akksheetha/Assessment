import {test as base,expect} from "@playwright/test";
import { RegisterPage } from "../pages/RegisterPage";
import {LoginPage} from "../pages/LoginPage";
type Fixtures={
    registerPage:RegisterPage;
    loginPage:LoginPage;
}
export const test = base.extend<Fixtures>({
    registerPage:async({page},use)=>{
        await use(new RegisterPage(page));
    },
    loginPage:async({page},use)=>{
        await use(new LoginPage(page));
    }
})
export {expect}