package com.velev.outdoorsy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velev.outdoorsy.fragments.OutdoorsyListingFragment
import com.velev.outdoorsy.util.ActivityUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityUtil.replaceFragmentInActivity(
            supportFragmentManager,
            OutdoorsyListingFragment.newInstance(),
            R.id.fragment
        )
    }
}
