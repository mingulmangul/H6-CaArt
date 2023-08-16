package org.softeer_2nd.caArt.model.data

data class Trim(
    val description: String,
    val exteriorColors: List<TrimItemColor>,
    val interiorColors: List<TrimItemColor>,
    val mainOptions: List<TrimMainItem>,
    val trimImage: String,
    val trimName: String,
    val trimPrice: Long,
    var isChecked: Boolean = false
)