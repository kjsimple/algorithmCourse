
/**
 *
 */

def v = 50
def objs = [2, 4, 18, 17, 7, 14, 9, 33, 21]
def res = []

0.upto(v) {
    res [it] = 0
}

0.upto(v) {
    it = it.toString().center(2)
    print "$it "
}
println ''

objs.each { obj ->
    v.downto(0) { currentV ->
        if (currentV - obj >= 0) {
            res[currentV] = Math.max(res[currentV], res[currentV - obj] + obj)
        }
    }
    res.each {
        it = it.toString().center(2)
        print "$it "
    }
    println ''
}
