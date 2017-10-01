package com.hucet.weekly276

import com.squareup.moshi.*
import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by tyler on 2017. 10. 1..
 */
class StageDataTest {
    var jsonAdapter : JsonAdapter<DummyStage>? = null
    @Before
    fun setUp() {
        jsonAdapter = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(StageAdapter())
                .build()
                .adapter(DummyStage::class.java)
    }

    @Test
    fun moshi() {
        val jsonString = "{\"stage\":\"in-progress\"}"
        println("jsonString ${jsonString}")
        val stageObject = jsonAdapter?.fromJson(jsonString)
        println("stageObject ${stageObject}")
        assertThat(stageObject?.stage, Is.`is`(Stage.IN_PROGRESS))
    }
}

enum class Stage {
    @Json(name = "not-started") NOT_STARTED,
    @Json(name = "in-progress") IN_PROGRESS,
    @Json(name = "rejected") REJECTED,
    @Json(name = "completed") COMPLETED


}


class StageAdapter {
    @FromJson fun fromJson(jsonReader: JsonReader, delegate: JsonAdapter<Stage>): Stage? {
        val value = jsonReader.nextString()
        return if (value.startsWith("in-progress")) Stage.IN_PROGRESS else delegate.fromJsonValue(value)
    }
}


data class DummyStage(val stage : Stage)