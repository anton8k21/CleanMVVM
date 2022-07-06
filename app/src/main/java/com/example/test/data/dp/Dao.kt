package com.example.test.data.dp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.data.dp.entity.CardBestEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface Dao {
        @Query("SELECT * FROM CardBestEntity")
        fun getAll(): Flow<List<CardBestEntity>>

        @Query("SELECT * FROM CardBestEntity WHERE isFavorite = 1")
        fun getAllLike(): Flow<List<CardBestEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(cardBestEntity: List<CardBestEntity>)

        @Query("UPDATE CardBestEntity SET isFavorite = 1 WHERE id = :id")
        suspend fun like(id: Long)

        @Query("UPDATE CardBestEntity SET isFavorite = 0 WHERE id = :id")
        suspend fun disLike(id: Long)


}