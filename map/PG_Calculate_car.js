function calculateFee(fees, minute) {
    let minTime = fees[0];
    let minFee = fees[1];
    let unitTime = fees[2];
    let unitCost = fees[3];
    
    if (minute <= minTime) return minFee;
    else return minFee + (Math.ceil((minute - minTime) / unitTime) * unitCost);
}

function convertMin(curTime) {
    let time = curTime.split(":").map(a => parseInt(a));
    return time[0] * 60 + time[1];
}

function solution(fees, records) {
    let answer = [];
    
    let storeTime = new Map();
    let storeDuration = new Map();
    
    for (let curRecord of records) {
        let parseRecord = curRecord.split(" ");
        
        if (parseRecord[2] === "IN") {
            storeTime.set(parseRecord[1], convertMin(parseRecord[0]));
        } else {
            let duration = convertMin(parseRecord[0]) - storeTime.get(parseRecord[1]);
            let newDuration = storeDuration.has(parseRecord[1]) ? storeDuration.get(parseRecord[1]) + duration : duration;
            storeDuration.set(parseRecord[1], newDuration);
            storeTime.delete(parseRecord[1]);
        }
    }
    
    for (let [key, value] of storeTime.entries()) {
        let duration = convertMin("23:59") - value;
        let newDuration = storeDuration.has(key) ? storeDuration.get(key) + duration : duration;
        storeDuration.set(key, newDuration);
        storeTime.delete(key);
    }
    // Calculate fees and prepare answer in sorted order
    answer = Array.from(storeDuration.keys())
        .map(car => [car, calculateFee(fees, storeDuration.get(car))])
        .sort((a, b) => a[0] - b[0]) // Sort by car number
        .map(pair => pair[1]); // Extract fees
    
    return answer;
}
