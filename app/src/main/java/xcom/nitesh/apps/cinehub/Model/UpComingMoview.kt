package xcom.nitesh.apps.cinehub.Model

data class UpComingMoview(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>
)