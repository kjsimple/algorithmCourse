
/**
 *
 */

//def golds = [34, 18, 19, 7, 57, 3, 8, 97, 26, 45]
def golds = [34, 18, 19, 7, 57, 3, 8, 97]
findMaxAndMin(golds, 0, golds.size()-1)
max = golds[golds.size()-1]
min = golds[0]
println "max is: $max, min is: $min"

def findMaxAndMin(golds, start, end) {
    if (start == end) {
        return
    }
    def len = end - start + 1
    0.upto(len/2) {
        if (golds[start+it] > golds[end-it]) {
            t = golds[start+it]
            golds[start+it] = golds[end-it]
            golds[end-it] = t
        }
    }
    findMaxAndMin(golds, start, start+len/2-1)
    findMaxAndMin(golds, start+len/2, end)
}
