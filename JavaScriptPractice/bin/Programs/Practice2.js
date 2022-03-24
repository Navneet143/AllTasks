var a = getValue;
var b = a; 
var c = b();

function getValue(){
    return 41;
}

console.log(a+"\n"+ b+"\n"+c);