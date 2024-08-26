function solution(s) {
    var answer = [];
    let numZeroRemoved = 0;
    let numIteration = 0;
    
    while(s !== "1") {
        const stringArr = s.split("").filter(a => a!== '0');
        numZeroRemoved += (s.length - stringArr.length);
        s = (stringArr.length).toString(2);
        numIteration++;
    }
    
    return [numIteration, numZeroRemoved];
}