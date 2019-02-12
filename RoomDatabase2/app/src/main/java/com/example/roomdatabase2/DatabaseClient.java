package com.example.roomdatabase2;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient databaseClientInstance;
    private AppDatabase appDatabase;

    public DatabaseClient(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context,AppDatabase.class,"Task").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(databaseClientInstance == null){
            databaseClientInstance = new DatabaseClient(context);
        }
        return databaseClientInstance;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
