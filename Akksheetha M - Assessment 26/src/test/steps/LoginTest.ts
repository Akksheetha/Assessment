import { Given,When,Then } from "@cucumber/cucumber";
import {expect} from "@playwright/test";
import { CustomWorld } from "../world/customWorld";
import { readCsvData } from "../utils/csvReader";
Given('the user is on register page of demo web shop', async function (this:CustomWorld) {
    await this.page.goto(process.env.BASEURL!);
});

When('the user click login', async function (this:CustomWorld) {
    await this.loginPage.clickLogin();
});

When('enter the valid details of the user from {string}', async function (this: CustomWorld, data) {
    const users: any[] = readCsvData("loginData.csv");
    const user = users.find(u => u.type === data);
    await this.loginPage.enteringDetails(user.email,user.password);
    await this.loginPage.login();
});

Then('user should should be displayed with respective page {string}',async function (this: CustomWorld, data) {
    if (data === "valid") {
        await expect(this.loginPage.books).toBeVisible();
    } 
    else {
        await expect(this.loginPage.errormsg).toContainText("Login was unsuccessful");
    }
});