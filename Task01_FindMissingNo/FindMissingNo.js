/* Task: Write a NodeJS program to find a missing number of given sequence. 
sequence start number is random but it is guaranteed n+1 sequence. 
	e.g.: if range is 10 numbers then array would contain 9 elements as one is missing
	i.e. : numberSeq= [21,25,29,28,22,24,27,26,30] here missing one is 23. 
trick is if start number or end number is missing how to figure that. 
make sure they captured that.
*/

/* 
Following 3 functions are implemented to find a missing value in a given sequence assuming that
if there is no missing value in the middle,missing one shoud be the start or end value.
These functions work correctly if the any given sequnce start with odd number like 21,31... 
*/

var sequence = [21,25,29,28,22,24,27,26,30,23];

// Method 01
function findMissingNoMethod1(sequence) {
	var seqSort = sequence.sort();
	var missing = 0;
	// Check whether the missing is a middle no
	for (let i = 0; i < seqSort.length-1 ; i++){

		var prev = seqSort[i];
		var next = seqSort[i+1];
	
		if (prev+1 != next){
			missing = prev+1;
			console.log("Missing is middle no: "+(prev+1));
		}	
	}
	
	// If missing is not middle no, check whether it is start or end
	if ((missing==0)&& (seqSort[0]%10 != 1)) { 
			console.log("Missing is start no: "+(seqSort[0]-1));
	} else if ((missing==0) && (seqSort[0]%10 == 1)){
			console.log("Missing is end no: "+(seqSort[seqSort.length-1]+1));
	}
}


// Mehtod 02
function findMissingNoMethod2(sequence) {
	var seqSort = sequence.sort();
	var min = seqSort[0];
	var max = seqSort[seqSort.length-1];
	var expected=0;
	var real = 0;
	var missing = 0;
	// Calculate the expected total between min & max
	for (let i = min ; i <= max ; i++){
		expected+= i;
	}
	// Calculate the total of values in seqSort array
	for (let j = 0 ; j < seqSort.length ; j++){
		real+=seqSort[j];
	}
	

	if (expected!=real){
		missing=expected-real;
		console.log("Missing is middle no: "+missing);
	} else if (seqSort[0]%10 != 1){
		missing = min-1;
		console.log("Missing is start no: "+missing);
	} else {
		missing = max+1;
		console.log("Missing is end no: "+missing);
	}
	
}


// Method 03
function findMissingNoMethod3() {
	var seqSort = sequence.sort();
	var min = seqSort[0];
	var max = seqSort[seqSort.length-1];
	var missing = 0;
	for (let i = min ; i <= max ; i++){
		if (!seqSort.includes(i)){
			missing = i;
			console.log("Missing is middle no: "+missing);
		}
	}
	if ((missing == 0) && (min%10 != 1)){
		console.log("Missing is start no: "+(min-1));
	} else if ((missing == 0) && (min%10 == 1)){
		console.log("Missing is end no: "+(max+1));
	}
}

findMissingNoMethod1(sequence);
// findMissingNoMethod2(sequence);
// findMissingNoMethod3(sequence);
