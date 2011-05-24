/**
 *
 */

def rearrange(list, pIndex, maxIndex) {
    int c1 = 2*pIndex;
    int c2 = 2*pIndex+1;
    if (c2 < maxIndex) {
        if (list[c2] > list[c1]) {
            if (list[c2] > list[pIndex]) {
                def t = list[pIndex]
                list[pIndex] = list[c2]
                list[c2] = t
                rearrange(list, c2, maxIndex)
            }
        } else {
            if (list[c1] > list[pIndex]) {
                def t = list[pIndex]
                list[pIndex] = list[c1]
                list[c1] = t
                rearrange(list, c1, maxIndex)
            }
        }
    } else if (c1 < maxIndex) {
        if (list[c1] > list[pIndex]) {
            def t = list[pIndex]
            list[pIndex] = list[c1]
            list[c1] = t
            rearrange(list, c1, maxIndex)
        }
    }
}

def initHeap(list) {
    if (list?.size > 1) {
        int len = list.size
        int index = len - 1
        int pIndex = len/2 - 1
        while (index) {
            if (list[pIndex] < list[index]) {
                def t = list[pIndex]
                list[pIndex] = list[index]
                list[index] = t
                rearrange(list, index, list.size)
            }
            index--
            len--
            pIndex = len/2 -1
        }
    }
}

def sort(heapList) {
    if (heapList?.size > 1) {
        int right = heapList.size - 1
        while(right) {
            def t = heapList[0]
            heapList[0] = heapList[right]
            heapList[right] = t
            rearrange(heapList, 0, right)
            right--
        }
    }
}

def testData = [
                [],
                [1],
                [2, 14],
                [2, 9, 7],
                [3, 18, 4, 8],
                [10, 3, 8, 2, 9, 18, 34, 6, 28]
               ]
testData.each {
    initHeap(it)
    sort(it)
    println it
}
