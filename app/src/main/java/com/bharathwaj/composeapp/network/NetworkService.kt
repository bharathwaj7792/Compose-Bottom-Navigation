import com.bharathwaj.composeapp.utils.Constants.ACCESS_TOKEN
import com.bharathwaj.composeapp.utils.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createApiService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    private class AuthInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Authorization", ACCESS_TOKEN)

            val request: Request = requestBuilder.build()
            return chain.proceed(request)
        }
    }
}