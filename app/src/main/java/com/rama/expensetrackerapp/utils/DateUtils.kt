package com.rama.expensetrackerapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZoneOffset

@RequiresApi(Build.VERSION_CODES.O)
fun getMonthStartTimestamp(year: Int, month: Int): Long {
    return LocalDate.of(year, month, 1)
        .atStartOfDay()
        .toEpochSecond(ZoneOffset.UTC) * 1000
}

@RequiresApi(Build.VERSION_CODES.O)
fun getMonthEndTimestamp(year: Int, month: Int): Long {
    val lastDay = YearMonth.of(year, month).lengthOfMonth()

    return LocalDate.of(year, month, lastDay)
        .atTime(23, 59, 59)
        .toEpochSecond(ZoneOffset.UTC) * 1000
}
@RequiresApi(Build.VERSION_CODES.O)
fun getMonthNameLocalized(month: Int): String {
    return java.time.Month.of(month)
        .getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.getDefault())
}


@RequiresApi(Build.VERSION_CODES.O)
fun getMonthName(month: Int): String {
    return java.time.Month.of(month)
        .name
        .lowercase()
        .replaceFirstChar { it.uppercase() }
}


@RequiresApi(Build.VERSION_CODES.O)
fun localDateToTimestamp(date: LocalDate): Long {
    return date.atStartOfDay(ZoneId.systemDefault())
        .toEpochSecond() * 1000
}


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
