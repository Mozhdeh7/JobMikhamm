package com.moj.jobmikham

data class JobInfo(
    val results: List<Resultt>
)

data class Resultt(
    val name: String,
    val title: String,
    val company: String,
    val location: String,
    val description: String
)
