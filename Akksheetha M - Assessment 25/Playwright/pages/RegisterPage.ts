import {Page,Locator} from "@playwright/test";

export class RegisterPage{
    readonly page:Page;
    readonly account:Locator;
    readonly register:Locator;
    readonly fname:Locator;
    readonly lname:Locator;
    readonly email:Locator;
    readonly phone:Locator;
    readonly pass:Locator;
    readonly cpass:Locator;
    readonly agree:Locator;
    readonly continue:Locator;
    readonly created:Locator;

    constructor(page:Page){
        this.page = page;
        this.account = page.getByRole('link', { name: ' My Account' });
        this.register = page.getByRole('link', { name: 'Register' });
        this.fname = page.getByRole('textbox', { name: '* First Name' });
        this.lname = page.getByRole('textbox', { name: '* Last Name' });
        this.email = page.getByRole('textbox', { name: '* E-Mail' });
        this.phone = page.getByRole('textbox', { name: '* Telephone' });
        this.pass = page.getByRole('textbox', { name: '* Password', exact: true });
        this.cpass = page.getByRole('textbox', { name: '* Password Confirm' })
        this.agree = page.getByRole('checkbox');
        this.continue = page.getByRole('button', { name: 'Continue' });
        this.created = page.locator("#content > h1")
    }
    async navigate(){
        await this.page.goto(process.env.BASE_URL || 'https://tutorialsninja.com/demo/');
    }
    async RegisterAction(fname:string, lname:string, email:string, phone:string, pass:string, cpass:string){
        await this.account.click();
        await this.register.click();
        await this.fname.fill(fname);
        await this.lname.fill(lname);
        await this.email.fill(email);
        await this.phone.fill(phone);
        await this.pass.fill(pass);
        await this.cpass.fill(cpass);
        await this.agree.click();
        await this.continue.click();
    }
}
