package com.example.jmovie.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

fun String.dateFormat(): String {

    // 1. Chuyển chuỗi String ban đầu thành đối tượng LocalDate
    val date = LocalDate.parse(this)

    // 2. Lấy Locale hiện tại của hệ thống (ví dụ: máy đang để tiếng Việt hoặc tiếng Anh)
    val currentLocale = Locale.getDefault()

    // 3. Tạo formatter tự động điều chỉnh theo Locale và độ dài mong muốn (SHORT, MEDIUM, LONG, FULL)
    val formatter = DateTimeFormatter
        .ofLocalizedDate(FormatStyle.MEDIUM) // Bạn có thể đổi thành SHORT, LONG, hoặc FULL
        .withLocale(currentLocale)

    return date.format(formatter)
}
