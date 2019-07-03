package app100.jain.com.network

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData.setOnClickListener {
            updateTextView()
        }
    }

    private fun updateTextView() {
        val networkTask = NetworkTask()
        networkTask.execute("https://api.github.com/search/users?q=%22gautambitious%22", "https://www.github.com/")
    }


    inner class NetworkTask : AsyncTask<String, Int, String>() {
        override fun doInBackground(vararg url: String?): String? {
            val googleUrl: URL = URL(url[0])
            val connectiom = googleUrl.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connectiom.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer: String? = ""

            while (buffer != null) {
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }
            return sb.toString()
        }

        override fun onPostExecute(result: String?) {
            val jsonData = JSONObject(result)
            val userArray=jsonData.getJSONArray("items")
            val user=userArray.get(0) as JSONObject
            val username=user.getString("login")
            showData.text=username

        }
    }
}