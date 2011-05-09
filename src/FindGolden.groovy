
/**
 *
 */

def findMaxAndMin(golds) {
    start = 0
    end = golds.size() - 1
    if (start == end) {
        return
    }
    def len = end - start + 1
    0.upto((end/2).intValue()) {
        println "*"*20
        if (golds[start+it] > golds[end-it]) {
            t = golds[start+it]
            golds[start+it] = golds[end-it]
            golds[end-it] = t
        }
    }
    if (len % 2) {
        println "*"*20
        def index = (len/2).intValue() + 1
        if (golds[index] < golds[0]) {
            golds[0] = golds[index]
        } else if (golds[index] > golds[end]) {
            golds[end] = golds[index]
        }
    }
    def i = (start+len/2-1).intValue()
    findMin(golds, i)
    findMax(golds, i+1)
}

def findMin(golds, end) {
    if (end <= 0) {
        return
    }
    def len = end + 1
    0.upto((end/2).intValue()) {
        println "*"*20
        if (golds[it] > golds[end-it]) {
            t = golds[it]
            golds[it] = golds[end-it]
            golds[end-it] = t
        }
    }
    def index = (end/2).intValue()
    if (len % 2) {
        println "*"*20
        if (golds[index+1] < golds[0]) {
            golds[0] = golds[index+1]
        }
    }
    findMin(golds, index)
}

def findMax(golds, start) {
    if (start >= golds.size() - 1) {
        return
    }
    def end = golds.size() - 1
    def len = end - start + 1
    0.upto(((end - start)/2).intValue()) {
        println "*"*20
        if (golds[start+it] > golds[end-it]) {
            t = golds[start+it]
            golds[start+it] = golds[end-it]
            golds[end-it] = t
        }
    }
    def index = start + ((end - start)/2).intValue() + 1
    if (len % 2) {
        println "*"*20
        if (golds[index-1] > golds[end]) {
            golds[end] = golds[index-1]
        }
    }
    findMax(golds, index)
}

//def golds = [34, 18, 19, 7, 57, 3, 8, 97, 26, 45]
def golds = [34, 1, 19, 7, 57, 3, 8, 97, 2, 45]
findMaxAndMin(golds)
max = golds[golds.size()-1]
min = golds[0]
println "max is: $max, min is: $min"
