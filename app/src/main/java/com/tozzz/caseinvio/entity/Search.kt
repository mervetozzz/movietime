package `in`.example.moviesapp.network.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Search(
        @SerializedName("Response")
    val response: String,
        @SerializedName("Search")
    val search: List<SearchX>,
        @SerializedName("totalResults")
    val totalResults: String
):Serializable