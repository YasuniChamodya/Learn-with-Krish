/* Write a NodeJS program to find a missing number of given sequence. 
sequence start number is random but it is guaranteed n+1 sequence. 
	e.g.: if range is 10 numbers then array would contain 9 elements as one is missing
	i.e. : numberSeq= [21,25,29,28,22,24,27,26,30] here missing one is 23. 
trick is if start number or end number is missing how to figure that. 
make sure they captured that.
*/


/* These functions are implemented to find a missing value in a given sequence.
If there is no missing value in the middle, I assumed that the missing one shoud be the end value, 
because it is mentioned that the sequence starts with a random number in the quection.   
*/


var sequence = [21,25,29,28,22,24,27,26,30];


// Method 1
function findMissingNoMethod1(sequence) {
	var seqSort = sequence.sort();
	
	for (let i = 0; i < seqSort.length ; i++){

		var prev = seqSort[i];
		var next = seqSort[i+1];
	
		if (prev+1 != next){
			console.log(prev+1);
			break;
		} else if ((prev+1 == next) && (i == seqSort.length-1)) {
			console.log(next+1);
		}
	}	
}


// Method 2
function findMissingNoMethod2(sequence) {
	var seqSort = sequence.sort();
	var min = seqSort[0];
	var max = seqSort[seqSort.length-1];
	var expected=0;
	var real = 0;
	var missing = 0;
	for (let i = min ; i <= max ; i++){
		expected+= i;
	}
	for (let j = 0 ; j < seqSort.length ; j++){
		real+=seqSort[j];
	}
	if (expected!=real){
		missing=expected-real;
		console.log(missing);
	} else {
		missing = max+1;
		console.log(missing);
	}
	
}


// Method 3
function findMissingNoMethod3() {
	var seqSort = sequence.sort();
	var min = seqSort[0];
	var max = seqSort[seqSort.length-1];
	var missing = 0;
	for (let i = min ; i <= max ; i++){
		if (!seqSort.includes(i)){
			
			missing = i;
			console.log(i);
		}
	}
	if (missing == 0){
		console.log(max+1);
	}
}

//findMissingNoMethod1(sequence);
//findMissingNoMethod2(sequence);
findMissingNoMethod3(sequence);