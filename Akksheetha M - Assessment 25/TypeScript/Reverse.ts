import promptSync from "prompt-sync";

const prompt = promptSync();
const num = prompt("Enter a number : ");
const num1 = Number(num);
function reverse(num:number):number{
    let ans = 0;
    for(let i = 0;i<5;i++){
        let r = num%10;
        ans = (ans*10)+r;
        num = Math.floor(num/10);
    }
    return ans;
}
let ans = reverse(num1);
console.log("Reversed Number : ",ans)