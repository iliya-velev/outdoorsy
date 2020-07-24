package com.velev.outdoorsy.data

import com.google.gson.annotations.SerializedName

/**
 * @author Iliya Velev
 * @since 1.0
 */
class ResponseData {

    @SerializedName("data")
    var data: List<Data>? = null
    @SerializedName("included")
    var included: List<Included>? = null

    class Data {
        var id: String? = null
        var type: String? = null
        @SerializedName("attributes")
        var attributes: Attribute? = null
        @SerializedName("relationships")
        var relationships: RelationShip? = null
    }

    class Included {
        var id: String? = null
        var type: String? = null
        @SerializedName("attributes")
        var attribute: IncludedAttribute? = null
    }

    class IncludedAttribute {
        var url: String? = null
    }

    class Attribute {
        @SerializedName("name")
        var name: String? = null
    }

    class RelationShip {
        @SerializedName("primary_image")
        var primaryImage: PrimaryImage? = null
    }

    class PrimaryImage {
        @SerializedName("data")
        var data: PrimaryImageData? = null
    }

    class PrimaryImageData {
        var id: String? = null
        var type: String? = null
    }
}