class Time {
    constructor(hour, minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    compare(secondTime) {
        if(this.hour === secondTime.hour) {
            return this.minute - secondTime.minute;
        }
        else return this.hour - secondTime.hour;
    }
}

function timeToMinute(hour, minutes) {
    return (hour*60) + minutes;
}

function minuteToTime(minutes){
    let hour = Math.floor(minutes/60).toString().padStart(2,'0');;
    let minute = (minutes - (Math.floor(minutes/60)*60)).toString().padStart(2,'0');
    return`${hour}:${minute}`
}


function solution(n, t, m, timetable) {
    var answer = '';
    
    let timeStore = [];
    let busArrival = new Map();
    
    for(curTime of timetable) {
        let curTimeParse = curTime.split(":").map(a => parseInt(a));
        timeStore.push(timeToMinute(curTimeParse[0], curTimeParse[1]));
    }
    timeStore.sort((a,b) => a-b);
    
    let busArrivalTime = timeToMinute(9,0);
    let busArrivalTimeStore = [busArrivalTime];
    
    for(let i = 0; i<n; i++) {
        let passengerArr = timeStore.filter((val) => (val<= busArrivalTime)).slice(0,m);
        busArrival.set(busArrivalTime, passengerArr);
        
        //Update bus Arrival time
        timeStore = timeStore.slice(passengerArr.length);
        busArrivalTime += t;
        busArrivalTimeStore.push(busArrivalTime);
    }
    busArrivalTimeStore.splice(busArrivalTimeStore.length-1);
    busArrivalTimeStore.sort((a,b) => b-a);
    
    //console.log(busArrival);
    
    for(curTime of busArrivalTimeStore) {
        //If map has empty space: answer becomes the busArrivalTime for the following
        if(busArrival.get(curTime).length < m) {
            answer = minuteToTime(curTime);
            return answer;
        }
        //If map has no empty space: answer becomes the latest time of the passengers: 
        else {
            let latestTime = busArrival.get(curTime).at(-1);
            if(latestTime < curTime) {
                answer = minuteToTime(latestTime - 1);
                return answer;
            }
            else {
                //but if latest time is equal or smaller to bus time-> get
                let count = busArrival.get(curTime).filter((val) => val === latestTime).length;
                console.log(count);
                //If number is less than m -> return -1
                if(count < m) {
                    answer = minuteToTime(latestTime - 1);
                    return answer;
                }
                else {
                    //If all of the members are last -> If first time , return 08:59 and else move to next
                    if(curTime === 540) return "08:59";
                }
            }
        }
        
    }

    
    return answer;
}