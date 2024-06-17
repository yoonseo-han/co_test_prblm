function solution(survey, choices) {
    var answer = '';
    
    var map = new Map(); 
    map.set("R" , 0);
    map.set("T" , 0);
    map.set("C" , 0);
    map.set("F" , 0);
    map.set("J" , 0);
    map.set("M" , 0);
    map.set("A" , 0);
    map.set("N" , 0);
    
    for(let i = 0; i<choices.length; i++) {
        let score = choices[i];
        let firstElement = survey[i].charAt(0);
        let secondElement = survey[i].charAt(1);
        if(score > 4) {
            map.set(secondElement, map.get(secondElement) + (score - 4));
        }
        else if(score < 4) {
            map.set(firstElement, map.get(firstElement) + (4 - score));
        }
    }
    
    //For each personality trait, add larger number
    if(map.get("R") >= map.get("T")) answer += 'R';
    else answer+= 'T';
    
    if(map.get("C") >= map.get("F")) answer += 'C';
    else answer+= 'F';

    if(map.get("J") >= map.get("M")) answer += 'J';
    else answer+= 'M';
    
    if(map.get("A") >= map.get("N")) answer += 'A';
    else answer+= 'N';
    
    return answer;
}