
package com.oregand.slante.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.text.SimpleDateFormat
import java.util.*

@TypeAlias('pateint')
data class Patient(@Id val handle: String,
                   val totalRecords: Int = 0,
                   val history: List<RecordEvent> = listOf()) {
    operator fun plus(record: Int) = Patient(handle,
            totalRecords + record,
            history + RecordEvent(record))
}

data class RecordEvent(val time: String, val dosage: Int) {
    constructor(dosage: Int) : this(dateFormat.format(Date(), dosage))

    companion object {
        val dateFormat = simpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }
}