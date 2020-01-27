package com.gautam.groceryfund

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_update.*
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class UpdateActivity : AppCompatActivity() {
val db by lazy {
    FirebaseFirestore.getInstance()
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val method = intent.getBooleanExtra("method",false)
        if(method)
            methodText.text = "Credit"

        submitButton.setOnClickListener {
            val amount = amountText.editText?.text.toString()
            var message = notesText.editText?.text.toString()
            if (message.isNullOrBlank())
                message = " "
            if (amount.isNullOrBlank())
                toast("Invalid Amount")
            else {
                enableUI(false)
                updateAmount(amount, message, method)
            }

        }
    }

    private fun updateAmount(amount: String, message: String, method: Boolean) {
        if (method){
            db.collection("groceryfund").document("niggalance").get().addOnSuccessListener {
                db.collection("groceryfund").document("niggalance").set(hashMapOf(
                    "balance" to (it.toObject(Balance::class.java)?.balance!! + amount.toDouble())
                )).addOnSuccessListener {
                    Log.i("nigga", java.util.Calendar.getInstance().toString())
                    val sdf = SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    val currentDate = sdf.format(Date())
                    db.collection("transactions").document(currentDate.toString()).set(
                        hashMapOf(
                            "amount" to amount,
                            "type" to "credit",
                            "message" to message
                        )).addOnSuccessListener {
                        toast("Successful")
                        this.finish()
                    }
                }
            }
        }
        else{
            db.collection("groceryfund").document("niggalance").get().addOnSuccessListener {
                db.collection("groceryfund").document("niggalance").set(hashMapOf(
                    "balance" to (it.toObject(Balance::class.java)?.balance!! - amount.toDouble())
                )).addOnSuccessListener {
                    Log.i("nigga", java.util.Calendar.getInstance().toString())
                    val sdf = SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    val currentDate = sdf.format(Date())
                    db.collection("transactions").document(currentDate.toString()).set(
                        hashMapOf(
                            "amount" to amount,
                            "type" to "debit",
                            "message" to message
                        )).addOnSuccessListener {
                        toast("Successful")
                        this.finish()
                    }
                }
            }.addOnFailureListener {
                toast("Unknown Error Occured")
                enableUI(true)
            }
        }
    }
    private fun enableUI(way: Boolean){
        runOnUiThread {
            amountText.isEnabled = way
            notesText.isEnabled = way
            submitButton.isEnabled = way
        }
    }
}
