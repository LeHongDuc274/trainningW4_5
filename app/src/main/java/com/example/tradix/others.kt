package com.example.tradix

import com.example.tradix.adapter.ItemMenu
import com.example.tradix.adapter.NewItem
import com.example.tradix.model.Model1

const val VIEW_TYPE_HEADER_1 = 1
const val VIEW_TYPE_ITEM_1 = 2
const val VIEW_TYPE_ITEM_2 = 3
val firstListCoin = mutableListOf<Model1?>(
    Model1("Down fffff Jone 1 ", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 2", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 3", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 4", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 5", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 6", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 7", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 8", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 9", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    Model1("Down fffff Jone 10", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
    null
)
val listItemMenu = mutableListOf<ItemMenu>(
    ItemMenu(R.drawable.icons_8_alarm, "Alerts", VIEW_TYPE_ITEM_2),
    ItemMenu(R.drawable.icons_8_left_and_right_arrows, "Predictions", VIEW_TYPE_ITEM_2),
    ItemMenu(R.drawable.icons_8_pin, "Saved elements", VIEW_TYPE_ITEM_2),
    ItemMenu(R.drawable.icons_8_no_entry, "Remove Ads", VIEW_TYPE_ITEM_2),

    ItemMenu(null, "Tools", VIEW_TYPE_HEADER_1),
    ItemMenu(R.drawable.icons_8_profit_2, "Select Stocks", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_swap, "Remove Ads", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_video_call, "Webinar", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_rent, "Best Broker", VIEW_TYPE_ITEM_1),

    ItemMenu(null, "Markets", VIEW_TYPE_HEADER_1),
    ItemMenu(R.drawable.icons_8_profit_2, "Select Stocks", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_swap, "Remove Ads", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_video_call, "Webinar", VIEW_TYPE_ITEM_1),
    ItemMenu(R.drawable.icons_8_rent, "Best Broker", VIEW_TYPE_ITEM_1)
)

val listItemNews = mutableListOf<NewItem>(
    NewItem(R.drawable.ic_item_new, "ALT -3%", "3 Sept 2020", "ALANTIA", R.string.text_disc),
    NewItem(
        R.drawable.ic_item_new_2,
        "HKD -2,13%",
        "2 Sept 2020",
        "XIAOMI",
        R.string.text_disc
    ),
    NewItem(
        R.drawable.ic_item_new_3,
        "AAPL -0,91%",
        "1 Sept 2020",
        "APPlE",
        R.string.text_disc
    ),
    NewItem(R.drawable.ic_item_new, "ALT -387%", "3 Sept 2022", "ALANTIA", R.string.text_disc),
    NewItem(
        R.drawable.ic_item_new_2,
        "ALT -387%",
        "3 Sept 2023",
        "ALANTIA",
        R.string.text_disc
    ),
    NewItem(
        R.drawable.ic_item_new_3,
        "ALT -387%",
        "3 Sept 2024",
        "ALANTIA",
        R.string.text_disc
    ),
    NewItem(R.drawable.ic_item_new_2, "ALT -387%", "3 Sept 2025", "ALANTIA", R.string.text_disc)
)
val mutableListChart = mutableListOf<Int>(
    R.drawable.neo_chart,
    R.drawable.neo_chart,
    R.drawable.neo_chart
)

