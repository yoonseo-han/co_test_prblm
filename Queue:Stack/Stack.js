class Stack {
    constructor() {
        this.list = [];
        this.size = 0;
    }
    push(curNum) {
        this.list[this.size++] = curNum;
    }
    pop() {
        if(this.size <= 0) return null;
        return this.list.splice(--this.size, 1).reduce((acc, cur) => {
            return acc;
        })
    }

    isEmpty() {
        if(this.index == 0) return true;
        else return false;
    }
}

module.exports = {Stack};