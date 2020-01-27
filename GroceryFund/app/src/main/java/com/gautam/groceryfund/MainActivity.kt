package com.gautam.groceryfund

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {
    private val db by lazy{
        FirebaseFirestore.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshBalance()


        creditText.setOnClickListener {
            startActivity<UpdateActivity>("method" to true)
        }

        debitText.setOnClickListener {
            startActivity<UpdateActivity>("method" to false)
        }

    }

    override fun onPause() {
        super.onPause()
        refreshBalance()
    }

    override fun onResume() {
        super.onResume()
        refreshBalance()
    }

    private fun refreshBalance(){
        db.collection("groceryfund").document("niggalance").get().addOnSuccessListener {
            val balance = it.toObject(Balance::class.java)?.balance!!
            runOnUiThread {
                balanceText.text = balance.toString()
            }
        }
    }
}
