package com.hdev.kt.footballleague.activity

import android.os.Bundle
import com.hdev.kt.footballleague.ui.MainUI
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar("main")
        MainUI(getLeagueData()).setContentView(this)
    }
}
