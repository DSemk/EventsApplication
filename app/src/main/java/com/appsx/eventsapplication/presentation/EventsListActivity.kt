package com.appsx.eventsapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsx.eventsapplication.R
import com.appsx.eventsapplication.common.buildPresenterFunctionCallStack
import com.appsx.eventsapplication.common.buildViewFunctionCallStack
import com.appsx.eventsapplication.common.wrapToProxy
import com.appsx.eventsapplication.data.repository.AssetsEventsRepository
import com.appsx.eventsapplication.domain.useCase.GetActiveEventDisplayModelsUseCase
import com.appsx.eventsapplication.presentation.presenter.EventsListPresenter
import com.appsx.eventsapplication.presentation.presenter.IEventsListPresenter
import com.appsx.eventsapplication.presentation.view.EventsListView
import kotlinx.android.synthetic.main.activity_events_list.*

class EventsListActivity : AppCompatActivity() {
    private lateinit var presenter: IEventsListPresenter
    private lateinit var eventsListRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_list)

        setupView()

        presenter = wrapToProxy(
            EventsListPresenter(
                wrapToProxy(
                    EventsListView(
                        tv_activity_events_list_empty_info,
                        eventsListRv
                    ),
                    buildViewFunctionCallStack(this)
                ),
                GetActiveEventDisplayModelsUseCase(
                    AssetsEventsRepository(assets)
                )
            ),
            buildPresenterFunctionCallStack(this)
        )

        presenter.onCreate()
    }

    private fun setupView() {
        eventsListRv = findViewById(R.id.rv_activity_events_list)
        eventsListRv.layoutManager = LinearLayoutManager(this)
    }
}
