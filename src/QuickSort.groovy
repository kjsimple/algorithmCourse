
/**
 *
 */
def partition(list, left, right) {
    def l = left
    def r = right
    def pivot = list[left]
    while (l < r) {
        while (l < r && list[r] >= pivot) r--
        list[l] = list[r]
        while (l < r && list[l] <= pivot) l++
        list[r] = list[l]
    }
    list[l] = pivot
    if (debug) println list
    l
}

def quickSort(list, l, r) {
    if (l < r) {
        def m = partition(list, l, r)
        quickSort(list, l, m-1)
        quickSort(list, m+1, r)
    }
}

def testData = [
                  [8, 3, 9, 17],
                  [9, 8, 7, 6, 5, 4],
                  [1, 2, 3, 4, 5, 6, 90],
                  [6, 2, 8, 5, 10, 9, 12, 1, 15, 7, 3, 13, 4, 11, 16, 14]
               ]
debug = true
testData.each { list ->
    def listSorted = list.collect({it}).sort{a1, a2-> a1.compareTo(a2)}
    if (debug) println list
    quickSort(list, 0, list.size-1)
    assert list == listSorted
}

