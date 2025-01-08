package xcom.nitesh.apps.cinehub.utils

class Constants {

    companion object{
        val BASEURL = "https://api.themoviedb.org/3/"
        val APIKEY = "5beb7de48c677bd7df5d9a7b58a295c8"
        val AccessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YmViN2RlNDhjNjc3YmQ3ZGY1ZDlhN2I1OGEyOTVjOCIsIm5iZiI6MTczNjE0MzEyOC42NjUsInN1YiI6IjY3N2I3MTE4NmQ3Y2EwMGU3ODcyY2FmNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5PyM5Sb2topIt1lxVFTTYsbrAXnzcVIrmZs8vQ0Sc6U"
        val ImageUrl = "https://image.tmdb.org/t/p/w700"

        val ImageBaseURL = "https://image.tmdb.org/t/p/original"
        val ImageBaseURLw780 = "https://image.tmdb.org/t/p/w780"
        val ImageBaseURLw500 = "https://image.tmdb.org/t/p/w500"

        fun getGenreMap(): HashMap<Int, String> {
            val genreMap = HashMap<Int, String>()
            genreMap[28] = "Action 🤠 "
            genreMap[12] = "Adventure 🏕 "
            genreMap[16] = "Animation 🎥 "
            genreMap[35] = "Comedy 🤣 "
            genreMap[80] = "Crime 👮‍♂️ "
            genreMap[99] = "Documentary 📃 "
            genreMap[18] = "Drama 😨 "
            genreMap[10751] = "Family 👪 "
            genreMap[14] = "Fantasy 🧙‍♂️ "
            genreMap[36] = "History 💾 "
            genreMap[27] = "Horror 👻 "
            genreMap[10402] = "Music 🎶 "
            genreMap[9648] = "Mystery 🕵️‍♀️ "
            genreMap[10749] = "Romance 💏"
            genreMap[878] = "Science Fiction 🚀 "
            genreMap[53] = "Thriller 🗡 "
            genreMap[10752] = "War ⚔ "
            genreMap[37] = "Western 🤵 "
            genreMap[10770] = "TV Movie 📺 "
            return genreMap
        }

    }
}