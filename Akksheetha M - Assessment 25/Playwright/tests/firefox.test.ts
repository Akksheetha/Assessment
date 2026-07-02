import {test, expect} from "@playwright/test";
test("FireFox test",async({page})=>{
    await page.goto("https://www.bing.com/");
    let title = await page.title();
    console.log("Title : ",title);
    let url = page.url();
    console.log("URL : ",url);
     expect(title).toContain("Bing");
     expect(url).toBe("https://www.bing.com/");
    let bing = await page.locator("//h1[@title='Trending Now on Bing']").innerText();
    console.log("Extracted Inner Text: ", bing);
    const search = page.locator('textarea[name="q"], input[name="q"]');
    await search.fill("playwright");
    await search.press("Enter");
    const result = page.locator("ol#b_results li.b_algo h2 a").first();
    await result.click();
    await page.waitForLoadState("domcontentloaded");
    let title1 = await page.title();
    console.log("Final Destination Page Title: ", title1);
    expect(title1.toLowerCase()).toContain("playwright");
})