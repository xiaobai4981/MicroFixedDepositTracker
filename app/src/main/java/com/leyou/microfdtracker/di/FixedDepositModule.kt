package com.leyou.microfdtracker.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import androidx.glance.appwidget.GlanceAppWidget
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.leyou.microfdtracker.data.alarm.AlarmScheduler
import com.leyou.microfdtracker.data.local.database.FixedDepositDatabase
import com.leyou.microfdtracker.data.preferences.PreferencesDataSource
import com.leyou.microfdtracker.data.repository.FixedDepositRepositoryImpl
import com.leyou.microfdtracker.data.repository.PreferencesRepositoryImpl
import com.leyou.microfdtracker.domain.notification.FixedDepositNotificationManager
import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import com.leyou.microfdtracker.domain.repository.PreferencesRepository
import com.leyou.microfdtracker.domain.usecase.AddFixedDepositUseCase
import com.leyou.microfdtracker.domain.usecase.DeleteAllFixedDepositsUseCase
import com.leyou.microfdtracker.domain.usecase.DeleteFixedDepositUseCase
import com.leyou.microfdtracker.domain.usecase.ExportFixedDepositUseCase
import com.leyou.microfdtracker.domain.usecase.GetAllFixedDepositUseCase
import com.leyou.microfdtracker.domain.usecase.GetDarkModeUseCase
import com.leyou.microfdtracker.domain.usecase.GetDynamicColorUseCase
import com.leyou.microfdtracker.domain.usecase.GetFixedDepositByIDUseCase
import com.leyou.microfdtracker.domain.usecase.GetTotalInvestedAmountUseCase
import com.leyou.microfdtracker.domain.usecase.GetTotalMaturityAmountUseCase
import com.leyou.microfdtracker.domain.usecase.RescheduleAlarmUseCase
import com.leyou.microfdtracker.domain.usecase.SetDarkModeUseCase
import com.leyou.microfdtracker.domain.usecase.SetDynamicColorUseCase
import com.leyou.microfdtracker.domain.usecase.UpdateFixedDepositUseCase
import com.leyou.microfdtracker.presentation.ui.widget.FixedDepositWidget
import com.leyou.microfdtracker.presentation.ui.widget.FixedDepositWidgetViewModel
import com.leyou.microfdtracker.utils.FileUtils
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FixedDepositModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun providesContentResolver(@ApplicationContext context: Context): ContentResolver {
        return context.contentResolver
    }

    @Provides
    @Singleton
    fun providesAppDatabase(app: Application): FixedDepositDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            FixedDepositDatabase::class.java,
            "fdDB"
        ).build()
    }

    @Provides
    @Singleton
    fun providesFixedDepositRepository(appDatabase: FixedDepositDatabase, notificationManager: FixedDepositNotificationManager): FixedDepositRepository {
        return FixedDepositRepositoryImpl(appDatabase.fixedDepositDao, notificationManager)
    }

    @Provides
    @Singleton
    fun providesPreferencesDataSource(@ApplicationContext context: Context): PreferencesDataSource {
        return PreferencesDataSource(context)
    }

    @Provides
    @Singleton
    fun providesPreferencesRepository(dataSource: PreferencesDataSource): PreferencesRepository {
        return PreferencesRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providesAddFixedDepositUseCase(repository: FixedDepositRepository): AddFixedDepositUseCase {
        return AddFixedDepositUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesUpdateFixedDepositUseCase(repository: FixedDepositRepository): UpdateFixedDepositUseCase {
        return UpdateFixedDepositUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetAllFixedDepositUseCase(repository: FixedDepositRepository): GetAllFixedDepositUseCase {
        return GetAllFixedDepositUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesDeleteFixedDepositUseCase(repository: FixedDepositRepository): DeleteFixedDepositUseCase {
        return DeleteFixedDepositUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesDeleteAllFixedDepositsUseCase(repository: FixedDepositRepository): DeleteAllFixedDepositsUseCase {
        return DeleteAllFixedDepositsUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesAlarmScheduler(@ApplicationContext context: Context): AlarmScheduler {
        return AlarmScheduler(context)
    }

    @Provides
    @Singleton
    fun providesFixedDepositNotificationManager(alarmScheduler: AlarmScheduler): FixedDepositNotificationManager {
        return FixedDepositNotificationManager(alarmScheduler)
    }

    @Provides
    @Singleton
    fun providesGetTotalInvestedAmountUseCase(repository: FixedDepositRepository): GetTotalInvestedAmountUseCase {
        return GetTotalInvestedAmountUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetTotalMaturityAmountUseCase(repository: FixedDepositRepository): GetTotalMaturityAmountUseCase {
        return GetTotalMaturityAmountUseCase(repository)
    }


    @Provides
    @Singleton
    fun providesSetDynamicColorUseCase(repository: PreferencesRepository): SetDynamicColorUseCase {
        return SetDynamicColorUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetDynamicColorUseCase(repository: PreferencesRepository): GetDynamicColorUseCase {
        return GetDynamicColorUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesSetDarkModeUseCase(repository: PreferencesRepository): SetDarkModeUseCase {
        return SetDarkModeUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetDarkModeUseCase(repository: PreferencesRepository): GetDarkModeUseCase {
        return GetDarkModeUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesExportDepositUseCase(repository: FixedDepositRepository): ExportFixedDepositUseCase {
        return  ExportFixedDepositUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetFixedDepositByIDUseCase(repository: FixedDepositRepository): GetFixedDepositByIDUseCase {
        return GetFixedDepositByIDUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesFixedDepositWidgetViewModel(
        getTotalInvestedAmountUseCase: GetTotalInvestedAmountUseCase,
        getTotalMaturityAmountUseCase: GetTotalMaturityAmountUseCase
    ): FixedDepositWidgetViewModel {
        return FixedDepositWidgetViewModel(getTotalInvestedAmountUseCase, getTotalMaturityAmountUseCase)
    }

    @Provides
    @Singleton
    fun providesFixedDepositWidget(viewModel: FixedDepositWidgetViewModel): GlanceAppWidget {
        return FixedDepositWidget(viewModel)
    }

    @Provides
    @Singleton
    fun providesRescheduleAlarmUseCase(repository: FixedDepositRepository): RescheduleAlarmUseCase {
        return RescheduleAlarmUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesFileUtils(contentResolver: ContentResolver): FileUtils {
        return FileUtils(contentResolver)
    }


}