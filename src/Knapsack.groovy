
/**
 *
 */

def v = 50
def objs = [4, 2, 33, 17, 14, 7, 9, 18, 21]
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
