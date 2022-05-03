package net.lemonroot.witch

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import net.lemonroot.witch.databinding.ActivityMainBinding
import net.lemonroot.witch.databinding.ActivityTestsBinding
import java.text.SimpleDateFormat
import java.util.*

class TestsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.readWriteTest.setOnClickListener(){
            //basicReadWrite()
    }

    private fun basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        val db = Firebase.firestore
        val sdf = SimpleDateFormat("mm/dd/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        val user = hashMapOf(
            "username" to "test",
            "email" to "test@test.com",
            "nickname" to "testman",
            "joined" to currentDate
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }

    // Get anonymous user info
    /*
    private fun fetchInfo() {
        val userRecord: String = FirebaseAuth.getInstance().currentUser!!.uid
    // See the UserRecord reference doc for the contents of userRecord.
        System.out.println("Successfully fetched user data: $userRecord")
    } */
}