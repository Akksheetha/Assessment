import {Page,Locator} from "@playwright/test";

export class LoginPage{
    readonly page:Page;
    readonly account:Locator;
    readonly login:Locator;
    readonly email:Locator;
    readonly password:Locator;
    readonly loginbtn:Locator;
    readonly success:Locator;
    readonly wrongemail:Locator;

    constructor(page:Page){
        this.page = page;
        this.account = page.getByRole('link', { name: ' My Account' });
        this.login = page.locator('#top-links').getByRole('link', { name: 'Login' });
        this.email = page.getByRole('textbox', { name: 'E-Mail Address' })
        this.password = page.getByRole('textbox', { name: 'Password' });
        this.loginbtn = page.getByRole('button', { name: 'Login' });
        this.success = page.locator('#content').getByRole('heading', { name: 'My Account' });
        this.wrongemail = page.getByText('Warning: No match for E-Mail');
    }
    async navigate(){
        await this.page.goto(process.env.BASE_URL || 'https://tutorialsninja.com/demo/');
    }
    async loginAction(email:string, password:string){
        await this.account.click();
        await this.login.click();
        await this.email.fill(email);
        await this.password.fill(password);
        this.loginbtn.click();
    }
}
