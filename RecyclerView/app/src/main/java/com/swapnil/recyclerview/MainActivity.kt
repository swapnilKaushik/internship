package com.swapnil.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var itemRecyclerAdapter: ItemRecyclerAdaptor
    lateinit var layoutManager: LinearLayoutManager

//    val itemList: List<String> = listOf<String>("Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9", "Item10", "Item11")
    val itemList: ArrayList<ItemModel> = arrayListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)

        val request = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/69c3a285-9d98-41a0-abe2-a4b03fa82764"

        val jsonObjectRequest = object: JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
            try {
                print("data")
                print(it)
                val data = it.getJSONArray("users")
                for( i in 0 until data.length() ) {
                    val itemJsonObject = data.getJSONObject(i)
                    val itemObject = ItemModel(
                        itemJsonObject.getInt("id"),
                        itemJsonObject.getString("name"),
                        itemJsonObject.getString("email"),
                        itemJsonObject.getString("phone_no")
                    )
                    itemList.add(itemObject)

                    itemRecyclerAdapter = ItemRecyclerAdaptor(this, itemList)
                    recyclerView.adapter = itemRecyclerAdapter
                    recyclerView.layoutManager = layoutManager
                }
            } catch(e: JSONException) {
                Toast.makeText(this, "Error occured!", Toast.LENGTH_SHORT).show()
            }
        }, Response.ErrorListener {
            Toast.makeText(this, "Volley error occured", Toast.LENGTH_SHORT).show()
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-type"] = "application/json"
                return headers
            }
        }
        request.add(jsonObjectRequest)
    }
}