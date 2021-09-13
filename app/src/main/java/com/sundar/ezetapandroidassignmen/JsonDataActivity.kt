package com.sundar.ezetapandroidassignmen

import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.sundar.ezetapandroidassignmen.adapter.DataAdapter
import com.sundar.ezetapandroidassignmen.classes.ApiServices
import com.sundar.ezetapandroidassignmen.classes.AppBaseActivity
import com.sundar.ezetapandroidassignmen.classes.Constants
import com.sundar.ezetapandroidassignmen.classes.HelperClass
import com.sundar.ezetapandroidassignmen.interfaces.ApiInterface
import kotlinx.android.synthetic.main.activity_json_data.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class JsonDataActivity : AppBaseActivity() {

    private val TAG = "JsonDataActivityTAG"
    private val activity = this@JsonDataActivity
    private var uiType = ""
    private var name = ""
    private var phone_number = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_data)

        uiType = intent.getStringExtra(Constants.UITYPE).toString()
        name = intent.getStringExtra(Constants.NAME).toString()
        phone_number = intent.getStringExtra(Constants.PHONE_NUMBER).toString()

        txt_uitype.text = uiType.toString()
        txt_name.text = name.toString()
        txt_phone_number.text = phone_number.toString()


        home()
    }

    private fun home(
        // int: page_count
    ) {

        // Log.d("tjCheck", "page_count list: " + page_count)
        if (HelperClass.getNetworkInfo(activity)) {
            val apiInterface = ApiServices.apiService(activity).create(ApiInterface::class.java)
            val call = apiInterface.getHome(0)
            call.enqueue(object : Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {

                    } else if (response.code() == HttpURLConnection.HTTP_OK) {
                        val body = JSONObject(response.body().toString())
                        HelperClass.setBannerImage(body.getString("logo-url"), logo, activity)
                        txt_api.text = body.getString("heading-text")
                        val uidataArr = body.getJSONArray("uidata")
                        Log.d(TAG, "url" + uidataArr)
                        data_recyclerview.adapter = DataAdapter(activity, uidataArr)


                    }

                    Log.d(TAG, "Resopnse of home api: " + response.body().toString())
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                    //   Handler().postDelayed(Runnable { enableOrientation() }, 1000)
                    //  HelperClass.hideLoader()
                    HelperClass.snackbar(
                        activity,
                        realtivelayout,
                        getString(R.string.something_went_wrong)
                    )
                }

            })


        } else {
            //no network
            HelperClass.snackbar(
                activity,
                realtivelayout,
                getString(R.string.check_your_internet_connection)
            )

        }

    }
}