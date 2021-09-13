package com.sundar.ezetapandroidassignmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sundar.ezetapandroidassignmen.classes.AppBaseActivity
import com.sundar.ezetapandroidassignmen.classes.Constants
import com.sundar.ezetapandroidassignmen.classes.HelperClass
import kotlinx.android.synthetic.main.activity_main.*
import org.aviran.cookiebar2.CookieBar

/**
 * Created by Sundar Chaupal (yr developer)on 03-09-2021.
 */
class MainActivity : AppBaseActivity() {
    private val TAG = "MainActivityTAG"
    private val activity = this@MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        btn_submit.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {

        if (edt_uitype.getText().toString().trim { it <= ' ' }.isEmpty()) {
            HelperClass.snackbar(activity, main_layout, getString(R.string.uitype))
            edt_uitype.requestFocus()
        } else if (edt_name.getText().toString().trim { it <= ' ' }.isEmpty()) {
            HelperClass.snackbar(activity, main_layout, getString(R.string.enter_your_name))
            edt_name.requestFocus()
        } else if (edt_phone_number.getText().toString().trim { it <= ' ' }.isEmpty()) {
            HelperClass.snackbar(activity, main_layout, getString(R.string.enter_your_phone_no))
            edt_phone_number.requestFocus()
        } else if (!HelperClass.isValidMobile(
                edt_phone_number.getText().toString().trim { it <= ' ' })
        ) {
            HelperClass.snackbar(
                activity,
                main_layout,
                getString(R.string.please_enter_your_phone_no)
            )
            edt_phone_number.requestFocus()
        } else {
            val intent = Intent(activity, JsonDataActivity::class.java)
            intent.putExtra(Constants.UITYPE, edt_uitype.text.toString())
            intent.putExtra(Constants.NAME, edt_name.text.toString())
            intent.putExtra(Constants.PHONE_NUMBER, edt_phone_number.text.toString())
            activity.startActivity(intent)


        }
    }
}