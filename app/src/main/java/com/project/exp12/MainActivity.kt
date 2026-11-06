package com.project.exp12

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var btnFetchData: Button
    private lateinit var tvStatus: TextView
    private lateinit var tvResult: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFetchData = findViewById(R.id.btnFetchData)
        tvStatus = findViewById(R.id.tvStatus)
        tvResult = findViewById(R.id.tvResult)
        progressBar = findViewById(R.id.progressBar)

        btnFetchData.setOnClickListener {
            fetchDataFromWebService()
        }
    }

    private fun fetchDataFromWebService() {
        tvStatus.setText(R.string.status_fetching)
        tvStatus.setTextColor(ContextCompat.getColor(this, R.color.status_ready_text))
        tvResult.setText(R.string.connecting_to_server)
        progressBar.visibility = View.VISIBLE
        btnFetchData.isEnabled = false

        // Execute network operation in a background thread
        Executors.newSingleThreadExecutor().execute {
            var urlConnection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val stringBuilder = StringBuilder()

            try {
                // Endpoint URL for HTTP GET request
                val url = URL("https://jsonplaceholder.typicode.com/posts/1")

                // Step 4: Establish HTTP connection
                urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.connectTimeout = 10000
                urlConnection.readTimeout = 10000

                // Step 5 & 6: Check response code and read server response using BufferedReader
                val responseCode = urlConnection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = urlConnection.inputStream
                    reader = BufferedReader(InputStreamReader(inputStream))

                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        stringBuilder.append(line).append("\n")
                    }

                    val responseText = stringBuilder.toString()

                    // Step 8: Update UI thread with retrieved response
                    runOnUiThread {
                        tvStatus.text = getString(R.string.status_success)
                        tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.status_success_text))
                        tvResult.text = responseText
                        progressBar.visibility = View.GONE
                        btnFetchData.isEnabled = true
                    }
                } else {
                    runOnUiThread {
                        tvStatus.text = getString(R.string.status_error, responseCode)
                        tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.status_error_text))
                        tvResult.text = getString(R.string.server_returned_status, responseCode)
                        progressBar.visibility = View.GONE
                        btnFetchData.isEnabled = true
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    tvStatus.setText(R.string.status_connection_error)
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.status_error_text))
                    tvResult.text = "Failed to retrieve data:\n${e.localizedMessage ?: e.message}"
                    progressBar.visibility = View.GONE
                    btnFetchData.isEnabled = true
                }
            } finally {
                try {
                    reader?.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                urlConnection?.disconnect()
            }
        }
    }
}