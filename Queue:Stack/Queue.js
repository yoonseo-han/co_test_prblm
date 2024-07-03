class Queue{
    constructor() {
        this.list = [];
        this.size = 0;
    }

    push(curNum) {
        this.list[this.size++] = curNum;
    }

    pop() {
        if (this.index <= 0) return null;
        this.size--;
        return this.list.splice(0,1).reduce((acc, cur) => {
            return acc;
        });
    }

    isEmpty() {
        if(this.index == 0) return true;
        else return false;
    }
}

module.exports = {Queue};