package com.rama.expensetrackerapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.YearMonth
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentMonthRange(): Pair<Long, Long> {
    val now = LocalDate.now()
    return getMonthRangeFor(now.year, now.monthValue)
}


@RequiresApi(Build.VERSION_CODES.O)
fun getMonthRangeFor(year: Int, month: Int): Pair<Long, Long> {

    val startOfMonth = LocalDate.of(year, month, 1)
        .atStartOfDay(ZoneId.systemDefault())
        .toEpochSecond() * 1000

    val endDay = YearMonth.of(year, month).lengthOfMonth()
    val endOfMonth = LocalDate.of(year, month, endDay)
        .atTime(23, 59, 59)
        .atZone(ZoneId.systemDefault())
        .toEpochSecond() * 1000

    return startOfMonth to endOfMonth
}
