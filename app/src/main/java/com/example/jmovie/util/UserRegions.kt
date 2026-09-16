package com.example.jmovie.util


data class UserRegion(
    val languageCode: String,
    val countryCode: String,
)

object UserRegions {
    val VIETNAM = UserRegion(
        languageCode = "vi-VN",
        countryCode = "VN",
    )

    val US = UserRegion(
        languageCode = "en-US",
        countryCode = "US",
    )

    val JAPAN = UserRegion(
        languageCode = "ja-JP",
        countryCode = "JP",
    )

    val KOREA = UserRegion(
        languageCode = "ko-KR",
        countryCode = "KR",
    )
}
