import {Page,Locator} from "@playwright/test";

export class HomePage{
    readonly page:Page;
    readonly searchbox:Locator;

    constructor(page:Page){
        this.page = page;
        this.searchbox = page.getByRole('textbox', { name: 'Search' });
    }
    async search(){
        this.searchbox.click();
    }
}
