import {Browser, BrowserContext, Page} from "@playwright/test";
import { Registerpage } from "../pages/RegisterPage";
import { LoginPage } from "../pages/LoginPage";

export class CustomWorld{
    browser!: Browser;
    context!: BrowserContext;
    page!: Page;
    registerPage!: Registerpage;
    loginPage!: LoginPage;
}