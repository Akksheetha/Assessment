import promptSync from "prompt-sync";

const prompt = promptSync();
const num1 = prompt("Enter a number : ");
const num2 = prompt("Enter a number : ");
const a:number = Number(num1);
const b:number = Number(num2);
function addition(a:number,b:number){
    const ans = a+b;
    console.log("Addition of two numbers is ",ans);
}
function sub(a:number,b:number){
    const ans = a-b;
    console.log("Subtract of two numbers is ",ans);
}
function mul(a:number,b:number){
    const ans = a*b;
    console.log("Multiplication of two numbers is ",ans);
}
function div(a:number,b:number){
    const ans = a/b;
    console.log("Division of two numbers is ",ans);
}
addition(a,b);
sub(a,b);
mul(a,b);
div(a,b);
