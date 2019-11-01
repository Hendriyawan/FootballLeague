package com.hdev.kt.footballleague.activity

import android.os.Bundle
import android.view.MenuItem
import com.hdev.kt.footballleague.model.League
import com.hdev.kt.footballleague.ui.DetailUI
import org.jetbrains.anko.setContentView

class DetailLeagueActivity : BaseActivity() {
    companion object {
        const val LEAGUE_DATA_EXTRA_KEY = "league_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val league = intent.getParcelableExtra<League>(LEAGUE_DATA_EXTRA_KEY)
        initActionBar("detail")
        DetailUI(league).setContentView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
