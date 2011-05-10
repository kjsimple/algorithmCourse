
/**
 *
 */

class Counter {
    static int count = 0
}

def findMaxAndMin(golds) {
    start = 0
    end = golds.size() - 1
    if (start == end) {
        return
    }
    def len = end - start + 1
    0.upto((end/2).intValue()) {
        Counter.count++
        if (golds[start+it] > golds[end-it]) {
            t = golds[start+it]
            golds[start+it] = golds[end-it]
            golds[end-it] = t
        }
    }
    if (len % 2) {
        Counter.count++
        def index = (len/2).intValue()
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
        Counter.count++
        if (golds[it] > golds[end-it]) {
            t = golds[it]
            golds[it] = golds[end-it]
            golds[end-it] = t
        }
    }
    def index = (end/2).intValue()
    if (len % 2) {
        Counter.count++
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
        Counter.count++
        if (golds[start+it] > golds[end-it]) {
            t = golds[start+it]
            golds[start+it] = golds[end-it]
            golds[end-it] = t
        }
    }
    def index = start + ((end - start)/2).intValue() + 1
    if (len % 2) {
        Counter.count++
        if (golds[index-1] > golds[end]) {
            golds[end] = golds[index-1]
        }
    }
    findMax(golds, index)
}

1.upto(10) {
    Counter.count = 0
    Random r = new Random();
    int size = r.nextInt(20) + 80;
    def golds = []
    def mx = -1
    def mn = 300
    0.upto(size-1) {
        golds[it] = r.nextInt(200)
        if (golds[it] > mx) {
            mx = golds[it]
        }
        if (golds[it] < mn) {
            mn = golds[it]
        }
    }

//    mx = -1
//    mn = 300
//    golds = [2, 11, 14, 17, 4, 19, 14, 16, 26, 11, 66, 29, 29, 73, 172, 83, 21, 13, 51, 71, 79, 14, 64, 72, 97, 183, 114, 74, 88, 118, 75, 185, 34, 96, 176, 155, 76, 11, 31, 118, 73, 213, 132, 156, 52, 28, 126, 125, 195, 89, 100, 79, 57, 126, 140, 152, 117, 81, 146, 81, 21, 6, 86, 184, 127, 93, 126, 196, 155, 172, 103, 129, 196, 196, 191, 195, 171, 196, 197, 193, 198, 197, 198]
//    golds.each {
//        if (it > mx) {
//            mx = it
//        }
//        if (it < mn) {
//            mn = it
//        }
//    }
//    def ll = golds.size
//    println "$ll, $mx, $mn"

    findMaxAndMin(golds)
    max = golds[golds.size()-1]
    min = golds[0]
//    if (max != mx || min != mn) {
//        println "*"*30
//        golds.each {
//            print "$it, "
//        }
//        println ''
//        println "*"*30
//    }
    assert max == mx
    assert min == mn
    def rate = Counter.count/size
    println "max is: $max, min is: $min. rate is: $rate"
}
