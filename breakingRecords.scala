def breakingRecords(scores: Array[Int]): Array[Int] = {
        val first = scores.toList.head
        var high = first
        var low  = first
        var highRec = 0
        var lowRec = 0

        scores.foreach { game =>
            if (game > high){
                high = game
                highRec += 1
            } else {
                high
            }
            if (game < low ) {
                low = game
                lowRec += 1
            }else {
                low
            }
        }
        Array(highRec, lowRec)
    }
