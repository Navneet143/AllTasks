function add(x, y) {
	console.log("ADD:" + (x + y))
};


var sum = function(x, y) {
	console.log("SUM:" + (x + y))
};

for(let i=0;i<=4;i++){
	for(let j=0;j<=4;j++)
	sum(i,j);
} 
for(let i=4;i<=9;i++){
	for(let j=10;j<=15;j++)
	add(i,j);
}


