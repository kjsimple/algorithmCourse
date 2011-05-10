
/**
 *
 */

class Counter {
    static int count = 0
}

def findMaxAndMin(golds) {
    if (golds.size <= 1) {
        return
    }
    int len = golds.size
    for (int i = 0; i < (len/2).intValue(); i++) {
        Counter.count++
        int p0 = i
        int p1 = len - 1 - i
        if (golds[p0] > golds[p1]) {
            t = golds[p0]
            golds[p0] = golds[p1]
            golds[p1] = t
        }
    }
    if (len % 2) {
        Counter.count++
        int index = len/2
        if (golds[index] < golds[0]) {
            golds[0] = golds[index]
        } else if (golds[index] > golds[len - 1]) {
            golds[len - 1] = golds[index]
        }
    }

    int endIndex = len/2 - 1
    while (endIndex > 0) {
        for (int i = 0; i < endIndex/2; i++) {
            Counter.count++
            int p0 = i
            int p1 = endIndex - i
            if (golds[p0] > golds[p1]) {
                t = golds[p0]
                golds[p0] = golds[p1]
                golds[p1] = t
            }
        }
        if (endIndex % 2 == 0) {
            Counter.count++
            int index = endIndex/2
            if (golds[index] < golds[0]) {
                golds[0] = golds[index]
            }
        }
        endIndex = endIndex/2
    }

    int startIndex = (len+1)/2
    int lastIndex = len - 1
    while (startIndex < lastIndex) {
        int size = lastIndex - startIndex + 1
        for (int i = 0; i < (size)/2; i++) {
            Counter.count++
            int p0 = startIndex + i
            int p1 = len - 1 - i
            if (golds[p0] > golds[p1]) {
                t = golds[p0]
                golds[p0] = golds[p1]
                golds[p1] = t
            }
        }
        if ((size) % 2) {
            Counter.count++
            int index = startIndex + (size)/2
            if (golds[index] > golds[lastIndex]) {
                golds[lastIndex] = golds[index]
            }
        }
        startIndex = startIndex + size/2
    }
}

1.upto(1000) {
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
//    //golds = [2, 11, 14, 17, 4, 19, 14, 16, 26, 11, 66, 29, 29, 73, 172, 83, 21, 13, 51, 71, 79, 14, 64, 72, 97, 183, 114, 74, 88, 118, 75, 185, 34, 96, 176, 155, 76, 11, 31, 118, 73, 213, 132, 156, 52, 28, 126, 125, 195, 89, 100, 79, 57, 126, 140, 152, 117, 81, 146, 81, 21, 6, 86, 184, 127, 93, 126, 196, 155, 172, 103, 129, 196, 196, 191, 195, 171, 196, 197, 193, 198, 197, 198]
//    //golds = [2, 99, 3, 3, 25, 13, 17, 32, 10, 24, 43, 3, 57, 44, 11, 62, 94, 38, 45, 36, 97, 18, 76, 85, 68, 113, 91, 173, 93, 114, 60, 18, 126, 152, 50, 149, 56, 175, 147, 151, 94, 69, 32, 103, 8, 55, -3, 199, 17, 121, 69, 33, 93, 156, 128, 25, 81, 177, 124, 166, 143, 71, 103, 26, 118, 49, 170, 126, 54, 79, 163, 178, 167, 49, 177, 96, 178, 153, 107, 157, 157, 198, 169, 180, 133, 189, 1162, -96, 192, 194, 194, 196, 198]
//    golds = [2, 99, 1]
//    golds.each {
//        if (it > mx) {
//            mx = it
//        }
//        if (it < mn) {
//            mn = it
//        }
//    }
//    def ll = golds.size
//    size = golds.size
//    println "$ll, $mx, $mn"

    findMaxAndMin(golds)
    max = golds[golds.size()-1]
    min = golds[0]
    if (max != mx || min != mn) {
        println "*"*30
        golds.each {
            print "$it, "
        }
        println ''
        println "*"*30
    }
    assert max == mx
    assert min == mn
    def rate = Counter.count/size
    println "max is: $max, min is: $min. rate is: $rate"
}
