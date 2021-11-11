package dev.gressier.food2fork.domain.util

import kotlinx.datetime.*

object DateTimeUtil {

    fun now(): LocalDateTime =
        Clock.System.now().toLocalDateTime(TimeZone.UTC)

    fun toLocalDateTime(date: Double): LocalDateTime =
        Instant.fromEpochMilliseconds(date.toLong()).toLocalDateTime(TimeZone.UTC)

    fun toEpochMilliseconds(date: LocalDateTime): Double =
        date.toInstant(TimeZone.UTC).toEpochMilliseconds().toDouble()

    fun humanizeDatetime(dateTime: LocalDateTime?): String =
        StringBuilder().also { sb ->
            dateTime?.run {
                val hour =
                    if (hour > 12)
                        "${hour - 12} PM"
                    else if (hour != 0)
                        "$hour AM"
                    else "midnight"

                val today = now()
                val tomorrow = Clock.System.now().plus(1, DateTimeUnit.DAY, TimeZone.UTC).toLocalDateTime(TimeZone.UTC)
                sb.append(
                    when (date) {
                        today.date -> "Today at $hour"
                        tomorrow.date -> "Tomorrow at $hour"
                        else -> "${date.month.name.lowercase()} ${date.dayOfMonth}"
                    }
                )
            } ?: sb.append("Unknown")
        }.toString()
}