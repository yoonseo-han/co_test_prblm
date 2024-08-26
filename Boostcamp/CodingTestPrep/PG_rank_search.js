//https://school.programmers.co.kr/learn/courses/30/lessons/72412

function solution(info, query) {
    var answer = [];
    
    let personInfo = info.map((curInfo) => {
        let infoSplit = curInfo.split(" ");
        return {
            language: infoSplit[0],
            position: infoSplit[1],
            experience: infoSplit[2],
            food: infoSplit[3],
            score: parseInt(infoSplit[4])
        };
    });
    
    for(curQuery of query) {
        let infoCopy = [...personInfo];
        let curSplit = curQuery.split(" ").filter(a => a !== 'and');
        if(curSplit[0] !== '-') infoCopy = infoCopy.filter(a => a.language === curSplit[0]);
        if(curSplit[1] !== '-') infoCopy = infoCopy.filter(a => a.position === curSplit[1]);
        if(curSplit[2] !== '-') infoCopy = infoCopy.filter(a => a.experience === curSplit[2]);
        if(curSplit[3] !== '-') infoCopy = infoCopy.filter(a => a.food === curSplit[3]);
        if(curSplit[4] !== '-') infoCopy = infoCopy.filter(a => a.score >= parseInt(curSplit[4]));
        
        answer.push(infoCopy.length);
    }

    //console.log(personInfo);
    
    return answer;
}