package com.hdev.kt.footballleague.ui

import android.support.v7.widget.GridLayoutManager
import android.widget.LinearLayout
import com.hdev.kt.footballleague.activity.DetailLeagueActivity
import com.hdev.kt.footballleague.activity.MainActivity
import com.hdev.kt.footballleague.adapter.LeagueAdapter
import com.hdev.kt.footballleague.model.League
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainUI(private var leagueList: List<League>) : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.VERTICAL

            //RecyclerView
            recyclerView {
                layoutManager = GridLayoutManager(context, 2)
                adapter = LeagueAdapter(leagueList) {
                    startActivity<DetailLeagueActivity>(DetailLeagueActivity.LEAGUE_DATA_EXTRA_KEY to it)
                }
            }
        }
    }
}