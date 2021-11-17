package dev.gressier.food2fork.util

import dev.gressier.food2fork.domain.model.Recipe
import io.ktor.http.*

val Recipe.Companion.Example: Recipe
     get() = Recipe(
        id = 5,
        title = "Easy Ice Cream Cake",
        publisher = "maizy",
        featuredImageUrl = Url("https://nyc3.digitaloceanspaces.com/food2fork/food2fork-static/featured_images/5/featured_image.png"),
        rating = 67,
        sourceUrl = Url("http://www.realsimple.com/food-recipes/browse-all-recipes/easy-ice-cream-cake-10000001817861/index.html"),
        ingredients = listOf(
            "1 cup heavy cream",
            "1/2 cup chocolate chips, chopped",
            "2 tablespoons confectioners' sugar",
            "6 ice cream sandwiches (3.5 ounces each)",
        ),
        addedAt = DateTimeUtil.toLocalDateTime(1606348710.0),
        updatedAt = DateTimeUtil.toLocalDateTime(1606348710.0),
    )