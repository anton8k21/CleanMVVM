package com.example.test.data.dataModel.detailsScreen

data class DetailsPhoneDataModel(
    val CPU: String,
    val camera: String,
    val capacity: List<Int>,
    val color: List<String>,
    val id: Long,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
) {

    fun toDetailsPhoneDomainModel(): DetailsPhoneDomainModel{
        val value =
            DetailsPhoneDomainModel(
                CPU = CPU,
                camera = camera,
                capacity = capacity,
                color = color,
                id = id,
                images = images,
                isFavorites = isFavorites,
                price = price,
                rating = rating,
                sd = sd,
                ssd = ssd,
                title = title
            )
        return value
    }
}